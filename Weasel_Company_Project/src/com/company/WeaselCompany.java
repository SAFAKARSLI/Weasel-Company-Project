package com.company;

import java.util.*;

public class WeaselCompany {

    public Manager CEO;
    public int employeeNum;
    public String birthDate;
    public ArrayList<String> projectHistory;
    public ArrayList<String> currentProjects;
    public int budget;
    public ArrayList<Developer> developers;
    public ArrayList<Engineer> engineers;
    public ArrayList<Manager> managers;


    public WeaselCompany(Manager CEO, int employeeNum, String birthDate, int budget) {
        this.CEO = CEO;
        this.employeeNum = employeeNum;
        this.birthDate = birthDate;
        this.projectHistory = new ArrayList<>();
        this.currentProjects = new ArrayList<>();
        this.budget = budget;
        this.developers = new ArrayList<>();
        this.engineers = new ArrayList<>();
        this.managers = new ArrayList<>();
    }


    public static Manager createTheManager(String managerName, WeaselCompany Company) {
        ArrayList<String> projects = new ArrayList<>();
        Manager manager = new Manager(managerName, 26, "96537234", "6.9.2017", 15700, "Harvard University", projects, "+1 973 276 9075");
        Company.managers.add(manager);
        return manager;
    }

    public static Manager createCEO() {
        ArrayList<String> projects = new ArrayList<>();
        return new Manager("Kevin Johns", 48, "0", "5.17.2016", 22500, "Columbia University", projects, "+1 235 355 3900");
    }

    public static WeaselCompany createCompany(Manager Ceo) {
        return new WeaselCompany(Ceo, 0, "5.17.2016", 100000);
    }

    public static void createProjects(WeaselCompany Company) {
        String names = "Juniper Rosemary Saffron Wisteria Wilder Violet Vinca Valerian Thorne Sherwood Sequoia Oleander " +
                "Oakley Myrtle Meadow Linden Lily Lavender Charlie Heather Hazel Ginger Hyacinth Forsythia Camellia Calendula " +
                "UglyFox Cerise MettlePaw Peacocks Sunergy Uzzin Ranzer Colusa WhiteJacks PrimeEight DejaVu Chasers CelestialInterface " +
                "YoungMarker WhiteCoast MovingBird Jaguar Whistler RuddyRex ShinyWaves";

        ArrayList<String> nameList = new ArrayList<>(Arrays.asList(names.split(" ")));
        for (int i = 0; i < nameList.size(); i++) {
            Company.projectHistory.add(nameList.get(i));
            if (nameList.size() - i < 18) {
                Company.currentProjects.add(nameList.get(i).toUpperCase());
            }
        }
    }

    public static void generateManagers(WeaselCompany Company, int managerNum) {
        for (int i = 0; i < managerNum; i++) {
            ArrayList<String> projects = new ArrayList<>();
            Manager manager = new Manager(generateName(), generateAge(), generateID(), generateEntranceDate(),
                    generateSalary(), generateUniversityName(), projects, generatePhoneNumber());
            Company.managers.add(manager);
        }
    }

    public static void assignProjectsToManagers(WeaselCompany Company) {
        for (int i=0; i < Company.projectHistory.size(); i++) {
            Collections.addAll(Company.CEO.projects, Company.projectHistory.get(i));
        }
        ArrayList<String> copyOfCurrentProjects = Company.currentProjects;
        for (int i = 0; i < Company.managers.size(); i++) {
            for (int j = 0; j < 3; j++) {
                Company.managers.get(i).projects.add(copyOfCurrentProjects.get(0));
                copyOfCurrentProjects.remove(0);
            }
        }
    }

    public static void generateDevelopers(WeaselCompany Company, int developerNum) {

        for (int i = 0; i < developerNum; i++) {
            Random rand = new Random();
            int langNum = 3 + rand.nextInt(10);
            ArrayList<String> Tools = generateTools(langNum);
            int salary = generateSalary();
            Developer developer = new Developer(generateName(), generateAge(), generateID(), generateEntranceDate(),
                    salary, generateUniversityName(), Tools, generateMainTool(Tools), declareRemoteness(),
                    declareTitle(salary), generateProjectName(Company), generatePhoneNumber());
            Company.developers.add(developer);
        }

    }

    public static void generateEngineers(WeaselCompany Company, int engineerNum) {

        for (int i = 0; i < engineerNum; i++) {
            Engineer engineer = new Engineer(generateName(), generateAge(), generateID(), generateEntranceDate(),
                    generateSalary(), generateUniversityName(), generateProjectName(Company), generatePhoneNumber(), generateEngineerArea());
            Company.engineers.add(engineer);
        }

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
        int id = 9783526 + rand.nextInt(1000000);
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

    private static String generateProjectName(WeaselCompany Company) {
        Random rand = new Random();
        int i = rand.nextInt(Company.currentProjects.size());
        return "Project " + Company.currentProjects.get(i);
    }

    private static String generatePhoneNumber() {
        Random rand = new Random();
        int first = 234 + rand.nextInt(700);
        int second = 234 + rand.nextInt(700);
        int third = 2345 + rand.nextInt(7500);
        return "+1 " + first + " " + second + " " + third;
    }

    private static ArrayList<String> generateTools(int num) {
        String languages = "Python Java HTML CSS JavaScript PHP SQL C C++ C# Ruby R Swift";
        ArrayList<String> lang = new ArrayList<>(Arrays.asList(languages.split(" ")));

        Random rand = new Random();
        ArrayList<String> languagesList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int j = rand.nextInt(lang.size());
            languagesList.add(lang.get(j));
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


}

