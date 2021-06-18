package com.company;

public class Engineer extends Staff {

    public String area;

    public Engineer(String name, int age, int ID, String entranceDate,
                    int salary, String universityName, String projectName, String phoneNumber, String area) {
        super(name, age, ID, entranceDate, salary, universityName, projectName, phoneNumber);
        this.area = area;
    }
}
