package com.example.michelle.littleprincesses.entities;

public interface SellerRest {

    public String getEmail();
    public String getResName();
    public String getLocation();
    public String getDescription();

    public void setEmail(String mail);
    public void setResName(String name);
    public void setLocation(String loc);
    public void setDescription(String des);
}
