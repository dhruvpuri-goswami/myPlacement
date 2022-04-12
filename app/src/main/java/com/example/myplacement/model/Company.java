package com.example.myplacement.model;

public class Company {
    private int id;
    private String name;
    private String no;
    private String address;
    private String email;
    private String pass;

    public Company(){

    }

    public Company(String name,String no,String address,String email,String pass){
        name=this.name;
        no=this.no;
        address=this.address;
        email=this.address;
        pass=this.pass;
    }

    public Company(String name,String pass){
        name=this.name;
        pass=this.pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
