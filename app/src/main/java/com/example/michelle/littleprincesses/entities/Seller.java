package com.example.michelle.littleprincesses.entities;

public class Seller implements SellerLogin, SellerRest, SellerMenu{

    private String email;
    private String password;
    private String resName;
    private String location;
    private String description;
    private String dishName;
    private double price;

    public Seller() {

    }

    public Seller(String mail, String pw, String resname, String loc, String des) {

        this.email = mail;
        this.password = pw;
        this.resName = resname;
        this.location = loc;
        this.description = des;
    }

    public String getEmail(){return email;}
    public String getPW() {return password;}
    public String getResName() {return resName;}
    public String getLocation() {return location;}
    public String getDescription() {return description;}
    public String getDishName() {return dishName;}
    public double getPrice() {return price;}

    public void setEmail(String mail) {email = mail;}
    public void setPW(String pw) {password = pw;}
    public void setResName(String name) {resName = name;}
    public void setLocation(String loc) {location = loc;}
    public void setDescription(String des) {description = des;}
    public void setDishName(String name) {dishName = name;}
    public void setPrice(double p) {price = p;}
}
