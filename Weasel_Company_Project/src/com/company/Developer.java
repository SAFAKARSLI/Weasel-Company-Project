package com.company;

import java.util.ArrayList;

public class Developer extends Staff {
    public ArrayList<String> tools;
    public String mainTool;
    public boolean isRemote;
    public String title;
    public String password;

    public Developer(String name, int age, String ID, String entranceDate, int salary, String universityName,
                     ArrayList<String> tools, String mainTool, boolean isRemote, String title, String projectName, String phoneNumber, String password) {
        super(name, age, ID, entranceDate, salary, universityName, projectName, phoneNumber, "D");
        this.tools = tools;
        this.mainTool = mainTool;
        this.isRemote = isRemote;
        this.title = title;
        this.password = password;
    }


}
