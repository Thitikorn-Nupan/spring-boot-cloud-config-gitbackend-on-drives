package com.ttknpdev.client.entities.one;

import com.ttknpdev.client.entities.many.Book;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
// must have constructor() {} null arg

public class Author {
    @Id // Mark is a Pk
    private String aid;
    private String fullname;
    private Short age;
    private Boolean alive;


    public Author(String aid, String fullname, Short age, Boolean alive) {
        this.aid = aid;
        this.fullname = fullname;
        this.age = age;
        this.alive = alive;
    }

    public Author() {

    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }


    @Override
    public String toString() {
        return "Author{" +
                "aid='" + aid + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", alive=" + alive +
                '}';
    }
}
