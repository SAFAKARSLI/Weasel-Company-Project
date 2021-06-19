package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Staff {
    public String name;
    public int age;
    public String ID;
    public String entranceDate;
    public int salary;
    public String universityName;
    public String projectName;
    public String phoneNumber;

    public Staff(String name, int age, String ID, String entranceDate, int salary, String universityName, String projectName, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.entranceDate = entranceDate;
        this.salary = salary;
        this.universityName = universityName;
        this.projectName = projectName;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(String entranceDate) {
        this.entranceDate = entranceDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static void makeRequest(WeaselCompany company) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1- Quit The Job\n" +
                "2- Request a Rise\n" +
                "3- Request a Promotion\n" +
                "4- Request vacation\n" +
                "What do you want to request?");

        switch (scan.nextLine().toUpperCase()) {
            case "1":
            case "QUIT":
            case "QUIT JOB":
            case "QUIT THE JOB":
//                quitRequest(company));
                break;
            case "2":
            case "RISE":
            case "REQUEST A RISE":
//                riseRequest(company);
                break;
            case "3":
            case "PROMOTION":
            case "REQUEST A PROMOTION":
//                promotionRequest(company);
                break;
            case "4":
            case "VACATION":
            case "REQUEST VACATION":
//                vacationRequest(company);
                break;
            default:
                System.out.println("You can only select option listed above!!!");
                makeRequest(company);
        }
    }

    public static void quitRequest(WeaselCompany company, Manager manager) {
        Scanner scanner = new Scanner(System.in);
        //Listed reasons
        ArrayList<String> quitReasons = new ArrayList<String>(Arrays.asList("Lack of Salary","Family Issue","Issue With Some Staffs",
                "Looking For A New Challenge","Health Reason"));
        //Printing reasons properly
        for(int i = 0; i<quitReasons.size(); i++) {
            System.out.println((i+1) + "- "+quitReasons.get(i));
        }
        System.out.println("Why do you want to quit?");
        int reasonNum = scanner.nextInt();
//        writePetition(manager,0);
    }

//    public static ArrayList<String> writePetition(Manager manager,int reasonNum) {
//        ArrayList<String> blanks = new ArrayList<String>();
//        Scanner scanner = new Scanner(System.in);
//        switch (reasonNum) {
//            case 0:
//                System.out.println("I want to quit due to the having lack of salary. Sincerely...\n Signing: \n");
//                String sign = scanner.next();
//                break;
//            case 1:
//                System.out.println("I want to quit due to the having family issue. Sincerely...");
//                break;
//            case 2:
//                System.out.println("I want to quit due to the having issue with some staffs. Sincerely...");
//                break;
//            case 3:
//                System.out.println("I want to quit due to the looking for a new challenge. Sincerely...");
//                break;
//            case 4:
//                System.out.println("I want to quit due to the having health issue. Sincerely...");
//                break;
//        }
//    }

    public static void displayInformation(WeaselCompany company) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1- Search by name\n" +
                           "2- Search by ID\n" +
                           "3- Search by age\n" +
                           "4- Search by amount of salary\n" +
                           "5- Search by college name\n" +
                           "6- Search by project name\n" +
                           "\nPlease filter your search =");
        switch (scanner.nextLine().toUpperCase()) {
            case "1":
            case "NAME":
                System.out.println("Please enter the name = ");
                String search = scanner.nextLine().toUpperCase();
                printMatched(company, searchDeveloper(company, search) , searchEngineer(company,search) , searchManager(company,search));
                break;
            case "2":
            case "ID":
                System.out.println("Please enter the ID = ");
                search = scanner.nextLine().toUpperCase();
                printMatched(company, searchDeveloper(company, search) , searchEngineer(company,search) , searchManager(company,search));
                break;
            case "5":
            case "COLLEGE":
            case "COLLEGE NAME":
                System.out.println("Please enter the college name = ");
                search = scanner.nextLine().toUpperCase();
                printMatched(company, searchDeveloper(company, search) , searchEngineer(company,search) , searchManager(company,search));
                break;
            case "6":
            case "PROJECT":
            case "PROJECT NAME":
                System.out.println("Please enter the project name = ");
                search = scanner.nextLine();
                printMatched(company, searchDeveloper(company, search) , searchEngineer(company,search) , searchManager(company,search));
                break;

            case "3":
            case "AGE":
            case "4":
            case "SALARY":
                searchByDefiningRange(company);
                break;
            default:
                System.out.println("You can only select options listed above!!!");
                displayInformation(company);
                break;
        }
    }

//    public static void searchByName(WeaselCompany company) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        //Taking input from user
//        System.out.println("Please write the name = ");
//        String searchedName = scanner.nextLine().toUpperCase();
//
//        ArrayList<Developer> matchedDevs = new ArrayList<Developer>();
//        ArrayList<Engineer> matchedEngineers = new ArrayList<Engineer>();
//
//        // Searches matching name on Developers list
//        for(int i = 0; i<company.devs.size(); i++) {
//            if(company.devs.get(i).name.contains(searchedName)) {
//                matchedDevs.add(company.devs.get(i));
//            }
//        }
//
//        // Searches matching name on Engineers list
//        for(int i = 0; i<company.engineers.size(); i++) {
//            if(company.engineers.get(i).name.contains(searchedName)) {
//                matchedEngineers.add(company.engineers.get(i));
//            }
//        }
//
//        //Printing results
//        int counter = 1;
//        System.out.println("Matched results:\n");
//        //Prints matched Devs
//        if(matchedDevs.size() > 0) {
//            for (Developer matchedDev : matchedDevs) {
//                System.out.println(counter + "- Developer (" + matchedDev.ID + ") -> " + matchedDev.name);
//                counter++;
//            }
//        }
//        //Prints matched Engineers
//        if(matchedEngineers.size() > 0) {
//            for (Engineer matchedEngineer : matchedEngineers) {
//                System.out.println(counter + "- Engineer (" + matchedEngineer.ID + ") -> " + matchedEngineer.name);
//                counter++;
//            }
//        }
//
//        //If no matching result
//        if(counter == 1) {
//            System.out.println("No matching result...");
//            displayInformation(company);
//        }
//
//        while(true) {
//            System.out.println("Please specify which staff's information do you want to see = ");
//            int answer = scanner.nextInt();
//
//            //Checks if the answer is bigger than the result list
//            if(answer > (counter-1)) {
//                System.out.println("Please enter valid number!!!");
//                continue;
//            }
//
//            if(matchedDevs.size() == 0) {
//                printEngineerInfo(matchedEngineers.get(answer-1));
//            }
//            else {
//                if(answer-1 <= matchedDevs.size()) {
//                    printDevInfo(matchedDevs.get(answer-1));
//                }
//                else {
//                    printEngineerInfo(matchedEngineers.get( (answer-1) - matchedDevs.size()));
//                }
//                break;
//            }
//            break;
//        }
//    }

    public static void searchByDefiningRange(WeaselCompany company) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Developer> matchedDevs = new ArrayList<Developer>();
        ArrayList<Engineer> matchedEngineers = new ArrayList<Engineer>();
        ArrayList<Manager> matchedManagers = new ArrayList<Manager>();

        //Setting upper and lower limits of age
        System.out.println("Please give a range (Lower Limit) = ");
        int lowerLimit = scanner.nextInt();
        System.out.println("Please give a range (Upper Limit) = ");
        int upperLimit = scanner.nextInt();


        if(upperLimit < lowerLimit) {
            System.out.println("Upper limit must bigger than lower limit!!");
            searchByDefiningRange(company);
        }

        //If the user is looking for age
        if(lowerLimit <= 50) {
            //Gets matching developers
            for(Developer developer : company.developers) {
                if(developer.age <= upperLimit && developer.age >= lowerLimit) {
                    matchedDevs.add(developer);
                }
            }
            //Gets matching engineers
            for(Engineer engineer : company.engineers) {
                if(engineer.age <= upperLimit && engineer.age >= lowerLimit) {
                    matchedEngineers.add(engineer);
                }
            }
            //Gets matching managers
            for(Manager manager : company.managers) {
                if(manager.age <= upperLimit && manager.age >= lowerLimit) {
                    matchedManagers.add(manager);
                }
            }

            printMatched(company,matchedDevs,matchedEngineers,matchedManagers);
        }
        //If the user is looking for salary
        else {
            //Gets matching developers
            for(Developer developer : company.developers) {
                if(developer.salary <= upperLimit && developer.salary >= lowerLimit) {
                    matchedDevs.add(developer);
                }
            }
            //Gets matching engineers
            for(Engineer engineer : company.engineers) {
                if(engineer.salary <= upperLimit && engineer.salary >= lowerLimit) {
                    matchedEngineers.add(engineer);
                }
            }
            //Gets matching managers
            for(Manager manager : company.managers) {
                if(manager.salary <= upperLimit && manager.salary >= lowerLimit) {
                    matchedManagers.add(manager);
                }
            }

            printMatched(company, matchedDevs,matchedEngineers,matchedManagers);
        }

    }

    public static ArrayList<Manager> searchManager (WeaselCompany company, String searched) {
        ArrayList<Manager> matchedManagers = new ArrayList<Manager>();
        for(Manager manager : company.managers) {
            String current = manager.name + manager.ID + manager.universityName + manager.projectName;
            if(current.contains(searched)) {
                matchedManagers.add(manager);
            }
        }
        return matchedManagers;
    }

    public static ArrayList<Developer> searchDeveloper(WeaselCompany company, String searched) {
        ArrayList<Developer> matchedDevs = new ArrayList<Developer>();
        for(Developer developer : company.developers) {
            String current = developer.name + developer.ID + developer.universityName + developer.projectName;
            if(current.contains(searched)) {
                matchedDevs.add(developer);
            }
        }
        return matchedDevs;
    }

    public static ArrayList<Engineer> searchEngineer(WeaselCompany company, String searched) {
        ArrayList<Engineer> matchedEngineers = new ArrayList<Engineer>();
        for(Engineer engineer : company.engineers) {
            String current = engineer.name + engineer.ID + engineer.universityName + engineer.projectName;
            if(current.contains(searched)) {
                matchedEngineers.add(engineer);
            }
        }
        return matchedEngineers;
    }

    public static void printManagerInfo(Manager manager) {
        System.out.println("\nName = "+manager.name+
                        "\nID = "+ manager.ID+
                        "\nAge = "+ manager.age+
                        "\nSalary = "+ manager.salary+
                        "\nEntrance Date = "+ manager.entranceDate+
                        "\nUniversity Name = "+ manager.universityName+
                        "\nProject Name = "+ manager.projectName+
                        "\nContact = "+ manager.phoneNumber
                );
        String projects = "Projects = ";
        for(int i = 0; i<manager.projects.size(); i++) {
            projects = projects.concat(manager.projects.get(i) + ", ");
        }
        projects = projects.substring(0, projects.length()-2);
        System.out.println(projects);

    }

    public static void printDevInfo(Developer developer) {
        System.out.println("\nName = "+developer.name+
                "\nID = "+ developer.ID+
                "\nAge = "+ developer.age+
                "\nTitle = "+ developer.title+
                "\nMain Tool = "+ developer.mainTool+
                "\nEntrance Date = "+ developer.entranceDate+
                "\nSalary = "+ developer.salary+
                "\nUniversity Name = "+ developer.universityName+
                "\nAssigned Project = "+ developer.projectName+
                "\nContact = "+ developer.phoneNumber);
        //Printing tools
        String tools = "Tools = ";
        for(int i = 0; i<developer.tools.size(); i++) {
            tools = tools.concat(developer.tools.get(i) + ", ");
        }
        tools = tools.substring(0, tools.length()-2);
        System.out.println(tools);

        if(developer.isRemote) {
            System.out.println("This developer is working remotely");
        } else {
            System.out.println("This developer is not working remotely");
        }
    }

    public static void printEngineerInfo(Engineer engineer) {
        System.out.println("\nName = "+engineer.name+
                "\nAge = "+ engineer.age+
                "\nID = "+ engineer.ID+
                "\nEntrance Date = "+ engineer.entranceDate+
                "\nSalary = "+ engineer.salary+
                "\nUniversity Name = "+ engineer.universityName+
                "\nAssigned Project = "+ engineer.projectName+
                "\nContact = "+ engineer.phoneNumber+
                "\nArea = "+ engineer.area
        );
    }

    public static void printMatched(WeaselCompany company, ArrayList<Developer> developers, ArrayList<Engineer> engineers, ArrayList<Manager> managers) {
        Scanner scanner = new Scanner(System.in);

        //Checks if no result
        if((engineers.size() == 0) && (developers.size() == 0) && (managers.size() == 0)) {
            System.out.println("No matching result...");
            displayInformation(company);
        }
        int counter = 1;
        ArrayList<String> result = new ArrayList<String>();
        //Prints matched developers
        if(developers.size() != 0) {
            for(Developer developer : developers) {
                System.out.println("D"+counter + " - Developer (" + developer.ID + ") -> " + developer.name);
                counter++;
            }
        }
        //Prints matched engineers
        if(engineers.size() != 0) {
            counter =1;
            for(Engineer engineer : engineers) {
                System.out.println("E"+counter + " - Engineer (" + engineer.ID + ") -> " + engineer.name);
                counter++;
            }
        }
        //Prints matched managers
        if(managers.size() != 0) {
            counter = 1;
            for(Manager manager : managers) {
                System.out.println("M"+counter + " - Manager (" + manager.ID + ") -> " + manager.name);
                counter++;
            }
        }

        String answer = scanner.nextLine();
        if(answer.startsWith("d") || answer.startsWith("D")) {
            printDevInfo(developers.get(Integer.parseInt(answer.substring(1,answer.length()))-1));
        }
        else if(answer.startsWith("e") || answer.startsWith("E")) {
            printEngineerInfo(engineers.get(Integer.parseInt(answer.substring(1,answer.length()))-1));
        }
        else if(answer.startsWith("m") || answer.startsWith("M")){
            printManagerInfo(managers.get(Integer.parseInt(answer.substring(1,answer.length()))-1));
        }


    }

}
