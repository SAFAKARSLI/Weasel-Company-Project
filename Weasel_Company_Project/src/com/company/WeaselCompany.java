package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class WeaselCompany {

    public String CEO;
    public int employeeNum;
    public String birthDate;
    public ArrayList<String> projectHistory;
    public ArrayList<String> currentProjects;
    public int budget;
    public ArrayList<Staff> staffs;
    public ArrayList<Developer> devs;
    public ArrayList<Engineer> engineers;
    public ArrayList<Manager> managers;



    public WeaselCompany(String CEO, int employeeNum, String birthDate, int budget) {
        this.CEO = CEO;
        this.employeeNum = employeeNum;
        this.birthDate = birthDate;
        this.projectHistory = new ArrayList<>();
        this.currentProjects = new ArrayList<>();
        this.budget = budget;
        this.staffs = new ArrayList<>();
        this.devs = new ArrayList<>();
        this.engineers = new ArrayList<>();
        this.managers = new ArrayList<>();
    }

    public String getCEO() {
        return CEO;
    }

    public void setCEO(String CEO) {
        this.CEO = CEO;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<String> getProjectHistory() {
        return projectHistory;
    }

    public void setProjectHistory(ArrayList<String> projectHistory) {
        this.projectHistory = projectHistory;
    }

    public ArrayList<String> getCurrentProjects() {
        return currentProjects;
    }

    public void setCurrentProjects(ArrayList<String> currentProjects) {
        this.currentProjects = currentProjects;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public ArrayList<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(ArrayList<Staff> staffs) {
        this.staffs = staffs;
    }

    public ArrayList<Developer> getDevs() {
        return devs;
    }

    public void setDevs(ArrayList<Developer> devs) {
        this.devs = devs;
    }

    public ArrayList<Engineer> getEngineers() {
        return engineers;
    }

    public void setEngineers(ArrayList<Engineer> engineers) {
        this.engineers = engineers;
    }

    public ArrayList<Manager> getManagers() {
        return managers;
    }

    public void setManagers(ArrayList<Manager> managers) {
        this.managers = managers;
    }

    public static Manager createTheManager(String managerName) {
        return new Manager(managerName, 26, "96537", "06.09.2017", 15700, "Harvard University", "+1 973 276 9075");
    }

    public static Manager createCEO() {
        return new Manager("Cagatay Johns", 48, "0", "05.03.2016", 22500, "Columbia University","+1 235 355 3900");
    }

    public static WeaselCompany createCompany() {
        return new WeaselCompany(createCEO().name, 0, "05.03.2016", 100000);
    }
    public static void generateProjects(int num) {
        String names = "Charlie UglyFox MettlePaw Peacocks Sunergy Uzzin Ranzer Colusa WhiteJacks PrimeEight DejaVu " +
                 "Chasers CelestialInterface YoungMarker WhiteCoast MovingBird Jaguar Whistler RuddyRex ShinyWaves" ;

        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(names.split(" ")));
        for (int i = 0; i < nameList.size(); i++) {
            createCompany().projectHistory.add(nameList.get(i));
            if (nameList.size() - i < 6) {
                createCompany().currentProjects.add(nameList.get(i));
            }
        }
    }



























}

