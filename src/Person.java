import java.io.Serializable;

public class Person implements Serializable {
    private String phonenumber;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String dab;
    private String email;

    public  Person (){

    }

    public Person(String phonenumber, String group, String name, String gender, String address, String dab, String email) {
        this.phonenumber = phonenumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dab = dab;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDab() {
        return dab;
    }

    public void setDab(String dab) {
        this.dab = dab;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
