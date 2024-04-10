package com.ttknpdev.client.entity;

public class Student {
    private String code;
    private String fullname;
    private Short age;
    private Character level;

    public Student(String code, String fullname, Short age, Character level) {
        this.code = code;
        this.fullname = fullname;
        this.age = age;
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Character getLevel() {
        return level;
    }

    public void setLevel(Character level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", level=" + level +
                '}';
    }
}
