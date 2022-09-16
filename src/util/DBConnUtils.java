package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnUtils {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/aaa";
            String id = "root";
            String pw = "jk670403";

            return DriverManager.getConnection(url, id, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

