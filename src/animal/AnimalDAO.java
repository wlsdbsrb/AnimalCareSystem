package animal;

import util.DBConnUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AnimalDAO {

    private ResultSet rs; // 필드는 기본적으로 객체를 생성하면 NULL값이 들어간다.
    private PreparedStatement psmt;

    private final Connection conn = DBConnUtils.getConnection();

    private void close() {
        try {
            if (rs != null)
                rs.close();
            if (psmt != null)
                psmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int postAniInfo(String aniName, String type, String kind, String master, String birth, String phone) {
        String postAniInfoQuery = "insert into animalInfo(aniName, type, kind, master, birth,phone) values(?, ?, ?, ?, ?, ?)";
        try {

            psmt = conn.prepareStatement(postAniInfoQuery);

            psmt.setString(1, aniName);
            psmt.setString(2, type);
            psmt.setString(3, kind);
            psmt.setString(4, master);
            psmt.setString(5, birth);
            psmt.setString(6, phone);


            return psmt.executeUpdate();

        } catch (SQLException e) { // 모든 DB관련 SQL문의 오류를 처리
            e.printStackTrace();
        } finally {
            close();
        }

        return -1;
    }
    public List<Animal> AnimalOrder(String Type){
        List<Animal> animals= new ArrayList<Animal>();

        try {
            Connection conn = DBConnUtils.getConnection();
            String getAniOrderQuery = null;

            if(Type.equals("기본정렬")){
                getAniOrderQuery = "select * from animalInfo ORDER BY aniIdx desc";
            }
            else if(Type.equals("주인정렬")){
                getAniOrderQuery = "select * from animalInfo ORDER BY master asc";
            }
            else if(Type.equals("동물정렬")){
                getAniOrderQuery = "select * from animalInfo ORDER BY aniName asc";
            }

            psmt = conn.prepareStatement(getAniOrderQuery);
            rs = psmt.executeQuery();

            while (rs.next()){
                Animal animal = new Animal();
                animal.setAniName(rs.getString("aniName"));
                animal.setType(rs.getString("type"));
                animal.setKind(rs.getString("kind"));
                animal.setMaster(rs.getString("master"));
                animal.setPhone(rs.getString("phone"));
                animal.setBirth(rs.getString("birth"));

                animals.add(animal);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close();
        }
        return animals;
    }


    public List<Animal> AnimalList(Animal ani) {

        List<Animal> animals= new ArrayList<Animal>();

        String Ani =ani.getAniName();

        try {
            Connection conn = DBConnUtils.getConnection();
            String getAniInfoQuery = null;


            if(Ani!=null && Ani.length()!=0){
                getAniInfoQuery = "select * from animalInfo where aniName like ?ORDER BY aniIdx desc";
                psmt = conn.prepareStatement(getAniInfoQuery);
                psmt.setString(1,"%"+Ani+"%");
            }

            else{
                psmt = conn.prepareStatement(getAniInfoQuery);
            }

            rs = psmt.executeQuery();


            while (rs.next()) {
                Animal animal = new Animal();
                animal.setAniName(rs.getString("aniName"));
                animal.setType(rs.getString("type"));
                animal.setKind(rs.getString("kind"));
                animal.setMaster(rs.getString("master"));
                animal.setPhone(rs.getString("phone"));
                animal.setBirth(rs.getString("birth"));

                animals.add(animal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return animals;
    }

}