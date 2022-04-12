package com.example.myplacement.model;

public class Items {
    private int id;
    private String item;
    private String quan;

    public Items(String item, String quan){
        this.item=item;
        this.quan=quan;
    }

    public Items(int id, String item, String quan){
        this.id=id;
        this.item=item;
        this.quan=quan;
    }

    public Items() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }
}
