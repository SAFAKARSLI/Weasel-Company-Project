package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class WeaselCompany {

    public Manager CEO;
    public int totalStuffNum;
    public String birthDate;
    public ArrayList<String> projectHistory;
    public ArrayList<String> currentProjects;
    public int budget;
    public ArrayList<Developer> developers;
    public ArrayList<Engineer> engineers;
    public ArrayList<Manager> managers;
    public ArrayList<Staff> staffs;


    public WeaselCompany(Manager CEO, String birthDate, int budget) {
        this.CEO = CEO;
        this.totalStuffNum = 0;
        this.birthDate = birthDate;
        this.projectHistory = new ArrayList<>();
        this.currentProjects = new ArrayList<>();
        this.budget = budget;
        this.developers = new ArrayList<>();
        this.engineers = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.staffs = new ArrayList<>();
    }


    public Manager createTheManager(String managerName, String password) {
        ArrayList<String> projects = new ArrayList<>();
        Manager manager = new Manager(managerName.toUpperCase(), 26, "96537234", "6.9.2017", 15700, "Harvard University", projects, "+1 973 276 9075", password);
        this.managers.add(manager);
        this.staffs.add(manager);

        return manager;
    }

    public static Manager createCEO() {
        ArrayList<String> projects = new ArrayList<>();
        return new Manager("Kevin Johns".toUpperCase(), 48, "0", "5.17.2016", 22500, "Columbia University", projects, "+1 235 355 3900", "Ceo's Password");
    }

    public static WeaselCompany createCompany(Manager Ceo) {
        return new WeaselCompany(Ceo, "5.17.2016", 100000);
    }

    public void createProjects() {
        String names = "Wisteria Wilder Violet Vinca Valerian Thorne Sherwood Sequoia Oleander " +
                "Oakley Myrtle Meadow Linden Lily Lavender Charlie Heather Hazel Ginger Hyacinth Forsythia Camellia Calendula " +
                "UglyFox Cerise MettlePaw Peacocks Sunergy Uzzin Juniper Rosemary Saffron Ranzer Colusa WhiteJacks PrimeEight DejaVu Chasers CelestialInterface " +
                "YoungMarker WhiteCoast MovingBird Jaguar Whistler RuddyRex ShinyWaves";

        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(names.split(" ")));
        for (int i = 0; i < nameList.size(); i++) {
            this.projectHistory.add(nameList.get(i).toUpperCase());
            if (nameList.size() - i < 18) {
                this.currentProjects.add(nameList.get(i).toUpperCase());
            }
        }
    }

    public void generateManagers(int managerNum) {
        for (int i = 0; i < managerNum; i++) {
            ArrayList<String> projects = new ArrayList<>();
            Manager manager = new Manager(generateName(), generateAge(), generateID(), generateEntranceDate(),
                    generateSalary(), generateUniversityName(), projects, generatePhoneNumber(), generatePassword());
            this.managers.add(manager);
            this.staffs.add(manager);
        }
    }

    public void assignProjectsToManagers() {
        for (int i=0; i < this.projectHistory.size(); i++) {
            Collections.addAll(this.CEO.projects, this.projectHistory.get(i));
        }
        ArrayList<String> copyOfCurrentProjects = this.currentProjects;
        for (int i = 0; i < this.managers.size(); i++) {
            for (int j = 0; j < 3; j++) {
                this.managers.get(i).projects.add(copyOfCurrentProjects.get(0));
                copyOfCurrentProjects.remove(0);
            }
        }
        this.setTotalStuffNum();
    }

    public void generateDevelopers(int developerNum) {

        for (int i = 0; i < developerNum; i++) {
            Random rand = new Random();
            int langNum = 3 + rand.nextInt(10);
            ArrayList<String> Tools = generateTools(langNum);
            int salary = generateSalary();
            Developer developer = new Developer(generateName(), generateAge(), generateID(), generateEntranceDate(),
                    salary, generateUniversityName(), Tools, generateMainTool(Tools), declareRemoteness(),
                    declareTitle(salary), this.generateProjectName(), generatePhoneNumber(), generatePassword());
            this.developers.add(developer);
            this.staffs.add(developer);
        }

    }

    public void generateEngineers(int engineerNum) {

        for (int i = 0; i < engineerNum; i++) {
            Engineer engineer = new Engineer(generateName(), generateAge(), generateID(), generateEntranceDate(),
                    generateSalary(), generateUniversityName(), this.generateProjectName(), generatePhoneNumber(), generateEngineerArea(), generatePassword());
            this.engineers.add(engineer);
            this.staffs.add(engineer);
        }

    }

    public void setTotalStuffNum() {
        this.totalStuffNum = 1 + this.managers.size() + this.developers.size() + this.engineers.size();
    }

    private static String generateName() {

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
                "Roberts O'Neill Wilson ";

        ArrayList<String> names = new ArrayList<>(Arrays.asList(nameStr.split(" ")));

        Random rand = new Random();
        int i = rand.nextInt(names.size());
        int j = rand.nextInt(names.size());

        String name = names.get(i) + " " + names.get(j);
        return name.toUpperCase();

    }

    private static int generateAge() {
        Random rand = new Random();
        return 18 + rand.nextInt(32);
    }

    private static String generateID() {
        Random rand = new Random();
        int id = 100000 + rand.nextInt(800000);
        return Integer.toString(id);
    }

    private static String generateEntranceDate() {
        Random rand = new Random();
        int month = 1 + rand.nextInt(12);
        int day = 1 + rand.nextInt(27);
        int year = 2017 + rand.nextInt(3);
        return month + "." + day + "." + year;
    }

    private static int generateSalary() {
        Random rand = new Random();
        return 5000 + rand.nextInt(10000);
    }

    private static String generateUniversityName() {
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

        return unis.get(i).toUpperCase();
    }

    private String generateProjectName() {
        Random rand = new Random();
        int i = rand.nextInt(this.currentProjects.size());
        return this.currentProjects.get(i);
    }

    private static String generatePhoneNumber() {
        Random rand = new Random();
        int first = 234 + rand.nextInt(700);
        int second = 234 + rand.nextInt(700);
        int third = 2345 + rand.nextInt(7500);
        return "+1 " + first + " " + second + " " + third;
    }

    private static String generatePassword() {
        String password = "";
        Random rand = new Random();
        for (int i=0; i<4; i++) {
            int numbers = rand.nextInt(100);
            String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");
            int letterIndex = rand.nextInt(alphabet.length);
            password = password + numbers + alphabet[letterIndex];
        }
        return password;
    }

    public void formCrews() {

        for(int i=0; i<this.managers.size(); i++) {
            for (int j = 0; j < this.staffs.size(); j++) {
                Manager manager = this.managers.get(i);
                Staff staff = this.staffs.get(j);
                if (manager.projects.contains(staff.projectName)) {
                    manager.crew.add(staff);
                }
            }
        }
    }

    private static ArrayList<String> generateTools(int num) {
        String languages = "Python Java HTML CSS JavaScript PHP SQL C C++ C# Ruby R Swift";
        ArrayList<String> lang = new ArrayList<>(Arrays.asList(languages.split(" ")));

        Random rand = new Random();
        ArrayList<String> languagesList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int j = rand.nextInt(lang.size());
            languagesList.add(lang.get(j));
            lang.remove(j);
        }
        return languagesList;
    }

    private static String generateMainTool(ArrayList<String> tools) {
        Random rand = new Random();
        int i = rand.nextInt(tools.size());
        return tools.get(i);
    }

    private static boolean declareRemoteness() {
        Random rand = new Random();
        int i = rand.nextInt(2);
        if (i == 0) {
            return false;
        }
        return true;

    }

    private static String declareTitle(int salary) {
        if (salary < 8000) {
            return "Junior";
        }
        return "Senior";
    }

    private static String generateEngineerArea() {
        String areas = "Mechanical Electrical Industrial Chemical Medical " +
                "Aerospace Biomedical Civil";
        ArrayList<String> areasList = new ArrayList<>(Arrays.asList(areas.split(" ")));

        Random rand = new Random();
        int i = rand.nextInt(areasList.size());

        return areasList.get(i);
    }

    public static String generateRequestID() {
        Random rand = new Random();
        int id = 10000000 + rand.nextInt(80000000);
        return Integer.toString(id);
    }

    private Staff pickStaff() {
        Random rand = new Random();
        int i = rand.nextInt(this.managers.get(0).crew.size());
        return this.managers.get(0).crew.get(i);
    }

    private static String generateRequestType() {
        ArrayList<String> requestTypes = new ArrayList<>(Arrays.asList("quit","raise","promotion","permission"));
        Random rand = new Random();
        int i = rand.nextInt(4);
        return requestTypes.get(i);
    }

    private static String generateRequestReason(String requestType) {

        ArrayList<String> requestReasons = new ArrayList<>();
        requestReasons.add("other");

        switch (requestType) {

            case "quit":
                requestReasons.add("insufficient salary");
                requestReasons.add("personal issues");
                requestReasons.add("health issues");
                requestReasons.add("incompatibility with staff");
                break;
            case "raise":
            case "promotion":
                requestReasons.add("financial needs");
                requestReasons.add("reflection of efficiency");
                break;
            case "permission":
                requestReasons.add("personal issues");
                requestReasons.add("health issues");
                requestReasons.add("vacation");
                break;

        }

        Random rand = new Random();
        int i = rand.nextInt(requestReasons.size());
        return requestReasons.get(i);
    }

    private static String generateExtraMessages() {
        return "\nExtra Message";
    }

    public void generateRequests(int numOfRequests){
        for (int i=0; i<numOfRequests; i++){
            Manager TheManager = this.managers.get(0);
            String requestType = generateRequestType();
            Request request = new Request(generateRequestID(), this.pickStaff(), TheManager,
                    requestType, generateRequestReason(requestType), generateExtraMessages());
            TheManager.requests.add(request);
        }
    }

    public void displayCompanyInfo(){

        System.out.println("\n\nWEASEL COMPANY\n\n" +
                "CEO: " + this.CEO.name + "\n\nManagers:" );
        for(int i=0; i<this.managers.size(); i++) {
            System.out.println(this.managers.get(i).name);
        }
        System.out.println("\nDate of Foundation: May 17, 2016\n");
        System.out.println("Budget: " + this.budget + "\n");
        System.out.println("Ongoing Projects:");
        for (int i=0; i<this.currentProjects.size(); i++) {
            System.out.println("Project " + this.currentProjects.get(i));
        }
        System.out.println("\nProject History:");
        for (int i=0; i<this.projectHistory.size(); i++) {
            System.out.println("Project " + this.projectHistory.get(i));
        }
        System.out.println("\nNumber of Stuffs: " + this.staffs.size());
        System.out.println("\nNumber of Developers: " + this.developers.size());
        System.out.println("\nNumber of Engineers: " + this.engineers.size());

    }


}

