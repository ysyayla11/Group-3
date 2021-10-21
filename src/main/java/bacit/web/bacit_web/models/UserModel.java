package bacit.web.bacit_web.models;

public class UserModel {
    private String fullName;
    private String email;
    private int phoneNumber;
    private String password;
    private String address;
    private String access;
    private boolean union;
    private int debt;

    public UserModel(String fullName, String email, int phoneNumber, String password, String address, String access, boolean union, int debt){

        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.access = access;
        this.union = union;
        this.debt = debt;

    }

    public String getFullName(){
        return fullName;
    }

    public String getEmail(){
        return email;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    public String getPassword(){
        return password;
    }

    public String getAddress(){
        return address;
    }

    public String getAccess(){
        return access;
    }

    public boolean getUnion(){
        return union;
    }

    public int getDebt(){
        return debt;
    }

}
