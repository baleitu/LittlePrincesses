package com.example.michelle.littleprincesses.model;

public class MenuInfo {
    private String name;
    private String intro;
    private int price;

    public MenuInfo(String name, String intro, int price){
        this.name = name;
        this.intro = intro;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public String getIntro(){
        return this.intro;
    }

    public int getPrice(){
        return this.price;
    }

}
