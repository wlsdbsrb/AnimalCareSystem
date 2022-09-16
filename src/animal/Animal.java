package animal;


public class Animal {

    private String aniName;
    private String type;
    private String kind;
    private String master;
    private String birth;
    private String phone;

    public Animal(String aniName, String type, String kind, String master, String birth, String phone){
        this.aniName=aniName;
        this.birth=birth;
        this.kind=kind;
        this.master=master;
        this.phone=phone;
        this.type=type;
    }

    public void setAniName(String aniName) {
        this.aniName = aniName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAniName() {
        return aniName;
    }

    public String getType() {
        return type;
    }

    public String getKind() {
        return kind;
    }

    public String getMaster() {
        return master;
    }

    public String getBirth() {
        return birth;
    }

    public String getPhone() {
        return phone;
    }


    public Animal(){
    }

}
