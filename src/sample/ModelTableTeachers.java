package sample;

public class ModelTableTeachers {
    private String id;
    private String name;
    private String address;
    private String phone;


    public ModelTableTeachers (String id, String name, String address , String phone){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
