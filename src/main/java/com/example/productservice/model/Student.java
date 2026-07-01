package com.example.productservice.model;

public class Student {
    private int id;
    private String name;
    private String marks;

    public Student(int i, String sharru, String number) {
        this.id = i;
        this.name = sharru;
        this.marks = number;
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

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }
}
