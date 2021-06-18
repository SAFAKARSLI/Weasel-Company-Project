package com.company;

import java.util.ArrayList;

public class Developer extends Staff {
    public ArrayList<String> tools;
    public String mainTool;
    public boolean isRemote;
    public String title;

    public Developer(String name, int age, String ID, String entranceDate, int salary, String universityName,
                     ArrayList<String> tools, String mainTool, boolean isRemote, String title, String projectName, String phoneNumber) {
        super(name, age, ID, entranceDate, salary, universityName, projectName, phoneNumber);
        this.tools = tools;
        this.mainTool = mainTool;
        this.isRemote = isRemote;
        this.title = title;
    }

    public ArrayList<String> getTools() {
        return tools;
    }

    public void setTools(ArrayList<String> tools) {
        this.tools = tools;
    }

    public String getMainTool() {
        return mainTool;
    }

    public void setMainTool(String mainTool) {
        this.mainTool = mainTool;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
