package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
        return new Manager(managerName, 26, "96537234", "6.9.2017", 15700, "Harvard University", "+1 973 276 9075");
    }

    public static Manager createCEO() {
        return new Manager("Cagatay Johns", 48, "0", "5.3.2016", 22500, "Columbia University","+1 235 355 3900");
    }

    public static WeaselCompany createCompany() {
        return new WeaselCompany(createCEO().name, 0, "5.3.2016", 100000);
    }
    public static void createProjects(WeaselCompany Company) {
        String names = "Charlie UglyFox MettlePaw Peacocks Sunergy Uzzin Ranzer Colusa WhiteJacks PrimeEight DejaVu " +
                 "Chasers CelestialInterface YoungMarker WhiteCoast MovingBird Jaguar Whistler RuddyRex ShinyWaves" ;

        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(names.split(" ")));
        for (int i = 0; i < nameList.size(); i++) {
            Company.projectHistory.add(nameList.get(i));
            if (nameList.size() - i < 6) {
                Company.currentProjects.add(nameList.get(i));
            }
        }
    }

    public static void generateStuff(WeaselCompany Company, int developerNum, int engineerNum) {

        ArrayList<String> developers = new ArrayList<>();
        ArrayList<String> engineers = new ArrayList<>();


    }

    public static String generateName() {

        String nameStr = "Oliver Jake Noah James " +
                "Jack Connor Liam John " +
                "Harry Callum Mason Robert " +
                "Jacob Jacob Jacob Michael " +
                "Charlie Kyle William William " +
                "Thomas Joe Ethan David " +
                "George Reece Michael Richard " +
                "Oscar Rhys Alexander Joseph " +
                "James Charlie James Charles " +
                "William Damian Daniel Thomas " +
                "Amelia Margaret Emma Mary " +
                "Olivia Samantha Olivia Patricia " +
                "Isla Bethany Sophia Jennifer " +
                "Emily Elizabeth Isabella " +
                "Poppy Joanne Ava Linda " +
                "Ava Megan Mia Barbara " +
                "Victoria Emily Susan " +
                "Jessica Lauren Abigail Margaret " +
                "Lily Michelle Madison " +
                "Sophie Tracy Charlotte Sarah" +
                "Murphy Smith " +
                "Jones O'Kelly Johnson " +
                "Williams O'Sullivan Williams " +
                "Brown Walsh Brown " +
                "Taylor Jones " +
                "Davies O'Brien Miller " +
                "Wilson Byrne Davis " +
                "Evans O'Ryan Garcia " +
                "Thomas O'Connor Rodriguez " +
                "Roberts O'Neill Wilson " ;

        ArrayList<String> names = new ArrayList<>(Arrays.asList(nameStr.split(" ")));

        Random rand = new Random();
        int i = rand.nextInt(names.size());
        int j = rand.nextInt(names.size());

        String name = names.get(i) + " " + names.get(j);
        return name.toUpperCase();

    }

    public static int generateAge() {
        Random rand = new Random();
        return 18 + rand.nextInt(32);
    }

    public static String generateID() {
        Random rand = new Random();
        int id = 9783526 + rand.nextInt(1000000);
        return Integer.toString(id);
    }

    public static String generateEntranceDate() {
        Random rand = new Random();
        int month = 1 + rand.nextInt(12);
        int day = 1 + rand.nextInt(27);
        int year = 2017 + rand.nextInt(3);
        return month + "." + day + "." + year;
    }

    public static int generateSalary() {
        Random rand = new Random();
        return 5000 + rand.nextInt(10000);
    }

    public static String generateUniversityName() {
        String universities = "University of Oxford;" +
                "University of Cambridge;" +
                "California Institute of Technology;" +
                "Stanford University;" +
                "Massachusetts Institute of Technology;" +
                "Harvard University;" +
                "Princeton University;" +
                "University of Chicago;" +
                "University of Pennsylvania;" +
                "Yale University;" +
                "Johns Hopkins University;" +
                "Columbia University;" +
                "University of California, Los Angeles;" +
                "Duke University;" +
                "University of California, Berkeley;" +
                "Cornell University;" +
                "Northwestern University;" +
                "University of Michigan;" +
                "National University of Singapore;" +
                "University of Toronto Canada;" +
                "Carnegie Mellon University;" +
                "University of Washington;" +
                "University of Edinburgh;" +
                "New York University;" +
                "Peking University;" +
                "University of California, San Diego;" +
                "University of Melbourne;" +
                "Georgia Institute of Technology;" +
                "University of British Columbia;" +
                "King’s College;" +
                "University of Illinois at Urbana-Champaign;" +
                "École Polytechnique Fédérale de Lausanne;" +
                "University of Hong Kong;" +
                "Technical University of Munich;" +
                "McGill University;" +
                "University of Wisconsin-Madison";
        ArrayList<String> unis = new ArrayList<>(Arrays.asList(universities.split(";")));

        Random rand = new Random();
        int i = rand.nextInt(unis.size());

        return unis.get(i);
    }

    public static String generateProjectName(WeaselCompany Company) {
        Random rand = new Random();
        int i = rand.nextInt(Company.currentProjects.size());
        return "Project " + Company.currentProjects.get(i);
    }

    public static String generatePhoneNumber() {
        Random rand = new Random();
        int first = 234 + rand.nextInt(700);
        int second = 234 + rand.nextInt(700);
        int third = 2345 + rand.nextInt(7500);
        return "+1 " + first + " " + second + " " + third ;
    }


    public static void main(String[] args) {
        WeaselCompany Company = createCompany();
        createProjects(Company);
        System.out.println(generateProjectName(Company));
        System.out.println(generateUniversityName());
    }


























}

