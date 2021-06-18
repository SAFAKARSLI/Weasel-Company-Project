package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class WeaselCompany {

    private String CEO;
    private int employeeNum;
    private String birthDate;
    private ArrayList<String> projectHistory;
    private ArrayList<String> currentProjects;
    private int budget;
    private ArrayList<Staff> staffs;
    private ArrayList<Developer> devs;
    private ArrayList<Engineer> engineers;
    private ArrayList<Manager> managers;
}


    public WeaselCompany(String CEO, int employeeNum, String birthDate, int budget, int staffNum, int devNum, int engNum) {
        this.CEO = CEO;
        this.employeeNum = employeeNum;
        this.birthDate = birthDate;
        this.projectHistory = new ArrayList<>();
        this.currentProjects = new ArrayList<>();
        this.budget = budget;
        this.staffNum = staffNum;
        this.devNum = devNum;
        this.engNum = engNum;
        this.managers = new ArrayList<>();
    }

    public static Manager createTheManager(String managerName) {
        return new Manager(managerName, 26, "96537", "06.09.2017", 15700, "Harvard University", "+1 973 276 9075");
    }

    public static Manager createCEO() {
        return new Manager("Cagatay Johns", 48, 0, "05.03.2016", 22500, "Columbia University","+1 235 355 3900");
    }

    public static WeaselCompany createCompany() {
        return new WeaselCompany(createCEO().name, 0, "05.03.2016", 100000, 0,0,0);
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

