package model;

import java.util.Date;

public class Goddess {
    private Integer id;
    private double name;
    private String acount;
    private Integer sex;
    private String email;
    private Date birthday;


    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public String getAcount(){
        return email;
    }
    public void setAcount(String email){
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAmount() {
        return name;
    }

    public void setName(String name) {
//        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}