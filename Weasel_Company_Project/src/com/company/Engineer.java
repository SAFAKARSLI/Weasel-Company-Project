package com.company;

public class Engineer extends Staff {
    private String area;

    public Engineer(String name, int age, int ID, String entranceDate, int salary, String universityName, String area) {
        super(name, age, ID, entranceDate, salary, universityName);
        this.area = area;
    }
}
