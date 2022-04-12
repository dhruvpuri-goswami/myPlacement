package com.example.myplacement.model;

public class AddCompany {
    private int id;
    private String name;
    private String desc;
    private String salary;

    public AddCompany(String name, String desc,String salary){
        this.name=name;
        this.desc=desc;
        this.salary=salary;
    }

    public AddCompany(){

    }

    public AddCompany(int id,String name, String desc,String salary){
        this.id=id;
        this.name=name;
        this.desc=desc;
        this.salary=salary;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
