package com.company;

import java.util.ArrayList;

public class Developer extends Staff {
    public ArrayList<String> tools;
    public String mainTool;
    public boolean isRemote;
    public String title;

    public Developer(String name, int age, int ID, String entranceDate, int salary, String universityName,
                     ArrayList<String> tools, String mainTool, boolean isRemote, String title, String projectName, String phoneNumber) {
        super(name, age, ID, entranceDate, salary, universityName, projectName, phoneNumber);
        this.tools = tools;
        this.mainTool = mainTool;
        this.isRemote = isRemote;
        this.title = title;
    }
}
