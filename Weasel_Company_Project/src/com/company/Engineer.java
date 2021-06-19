package com.company;

public class Engineer extends Staff {

    public String area;
    public String password;

    public Engineer(String name, int age, String ID, String entranceDate,
                    int salary, String universityName, String projectName, String phoneNumber, String area, String password) {
        super(name, age, ID, entranceDate, salary, universityName, projectName, phoneNumber, "E");
        this.area = area;
        this.password = password;
    }

}
