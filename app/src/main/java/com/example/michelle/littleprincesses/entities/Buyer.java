package com.example.michelle.littleprincesses.entities;

public class Buyer implements BuyerLogin{

    private String email;
    private String password;

    public Buyer() {

    }

    public Buyer(String mail, String pw) {

        this.email = mail;
        this.password = pw;
    }

    public String getEmail(){return email;}
    public String getPW() {return password;}

    public void setEmail(String mail) {email = mail;}
    public void setPW(String pw) {password = pw;}
}
