package com.company;

import java.util.ArrayList;

public class Developer extends Staff {
    private ArrayList<String> tools;
    private String mainTool;
    private boolean isRemote;
    private String title;

    public Developer(String name, int age, int ID, String entranceDate, int salary, String universityName,
                     ArrayList<String> tools, String mainTool, boolean isRemote, String title) {
        super(name, age, ID, entranceDate, salary, universityName);
        this.tools = tools;
        this.mainTool = mainTool;
        this.isRemote = isRemote;
        this.title = title;
    }
}
