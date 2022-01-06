package com.superprojects.bookyourflightapp.Models;

public class Users {

    String fullName, phone, email, password, repeatPassword;

    public Users(String fullName, String phone, String email, String password, String repeatPassword) {
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public Users(){}

    //SignUp Constructor
    public Users(String fullName,String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() { return repeatPassword; }

    public void setRepeatPassword(String repeatPassword) { this.repeatPassword = repeatPassword; }
}
