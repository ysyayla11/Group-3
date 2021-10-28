package bacit.web.bacit_web.models;

import java.awt.*;

public class UserModel {
    private int id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
    private String address;
    private boolean union;
    private int debt;


    public UserModel(int id, String fullName, String email, String phoneNumber, String password, String address, boolean union, int debt){
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
        this.union = union;
        this.debt = debt;

    }

    public int getId(){return id;}

    public String getFullName(){
        return fullName;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getPassword(){
        return password;
    }

    public String getAddress() { return address; }

    public boolean getUnion(){
        return union;
    }

    public int getDebt(){
        return debt;
    }

}
