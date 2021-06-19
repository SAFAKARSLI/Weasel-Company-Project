package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Options:
 * 1- Display current company statistic
 *      - CEO name
 *      - Managers name
 *      - Birth date of the company
 *      - Company budget
 *      - Current projects
 *      - Project history
 *      - How many staffs we have
 *      - How many developers we have
 *      - How many engineers we have
 *
 * 2- Display requests
 * 3- Display to-do list
 *      - My project
 *      - Check list
 * 4- Display information
 *      - Search by name (returns list)
 *      - Search by Id (returns object)
 *      - Search by age (returns list)
 *      - Search by salary (min max)
 *      - Search by university name
 *      - Search by project name
 * 5- Make a request to CEO
 *      - Quit the job
 *      - Request a rise
 *      - Request a promotion
 *      - Request vacation
 */





public class Manager extends Staff{

    public String password;
    public ArrayList<String> projects;
    public ArrayList<Staff> crew;
    public ArrayList<Request> requests;

    public Manager(String name, int age, String ID, String entranceDate,
                   int salary, String universityName, ArrayList<String> projects,
                   String phoneNumber, String password) {
        super(name, age, ID, entranceDate, salary, universityName, "", phoneNumber,"M");
        this.password = password;
        this.projects = projects;
        this.crew = new ArrayList<>();
        this.requests = new ArrayList<>();
    }

    public static String[] displayLoginScreen(Scanner scanner) {
        System.out.println("\nWeasel Company\n\nManager User Interface\n");
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        String[] nameAndPassword = new String[2];
        nameAndPassword[0] = name;
        nameAndPassword[1] = password;
        return nameAndPassword;
    }

    public static void displayToDo(WeaselCompany Company, Manager manager, int num) {
        System.out.println("\nMy Projects:\n" +
                "Project " + manager.projects.get(0).substring(0,1) + manager.projects.get(0).substring(1).toLowerCase() +
                "\nProject " + manager.projects.get(1).substring(0,1) + manager.projects.get(1).substring(1).toLowerCase() +
                "\nProject " + manager.projects.get(2).substring(0,1) + manager.projects.get(2).substring(1).toLowerCase() ) ;

        System.out.println("\nSchedule:\n");
        ArrayList<String> duties = generateDuties(manager, num, Company);
        for(int i=0; i<duties.size(); i++){
            System.out.println((i+1) + ": " + duties.get(i));
        }
    }

    private static ArrayList<String> generateDuties(Manager manager, int num, WeaselCompany Company) {
        ArrayList<String> duties = new ArrayList<>();
        ArrayList<String> copyOfDuties = createDuties(manager, Company);
        Random rand = new Random();
        for(int i=0; i<num; i++) {
            int index = rand.nextInt(copyOfDuties.size());
            duties.add(copyOfDuties.get(index));
            copyOfDuties.remove(index);
        }
        return duties;
    }

    private static ArrayList<String> createDuties(Manager manager, WeaselCompany Company) {
        ArrayList<String> duties = new ArrayList<>();
        for(int i=0; i<Company.managers.size(); i++) {
            duties.add("Attend the meeting with Manager " + Company.managers.get(i).name);
        }
        ArrayList<Staff> crewCopy = manager.crew;
        Random rand = new Random();
        for(int i=0; i<crewCopy.size()/2; i++ ) {
            int j = rand.nextInt(crewCopy.size());
            int h = 1 + rand.nextInt(10);
            String projectName = crewCopy.get(j).projectName.substring(0,1) + crewCopy.get(j).projectName.substring(1).toLowerCase();
            duties.add("Arrange a meeting with " + crewCopy.get(j).name + " about the Mission-" + h +
                    " of Project " + projectName );
            duties.add("Review Document-" + h + " of Project " + projectName);
            crewCopy.remove(j);
        }

        return duties;
    }

    public static boolean quit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTo go to previous screen enter 'previous', to back to the main menu enter 'quit':");
        switch (scanner.next()) {
            case "previous":
                return false;
            case "quit":
                return true;
            default:
                System.out.println("You can only type 'previous' or 'quit'!\n");
                return quit();
        }
    }

    public static void displayRequests(Manager manager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Request ID:       From:\n-------------     -------------");
        for (int i = 0; i <manager.requests.size(); i++) {
            System.out.println((i+1) +"- "+manager.requests.get(i).ID+"       "+ manager.requests.get(i).from.name
                    + " ("+manager.requests.get(i).from.ID+")");
        }
            System.out.println("Which request do you want to consider?");
            int consider = scanner.nextInt();
            //If input is invalid
            if(consider > manager.requests.size()) {
                System.out.println("Request list does not include '"+consider+"'\nDid you mean last element of the list? (y/n)");
                //If user wants to see the last element of the list
                if(doYouAccept(manager)) {
                    printRequest(manager.requests.get(consider-1));
                    System.out.println("Requester Information:\n");
                    switch (manager.requests.get(consider-1).from.job) {
                        case "D":
                            printDeveloperInfo((Developer) manager.requests.get(consider-1).from);
                            break;
                        case "E":
                            printEngineerInfo((Engineer) manager.requests.get(consider-1).from);
                            break;
                    }
                    if(quit()) {
            //            WeaselCompany.displayMainMenu();
                    } else {displayRequests(manager);}
                }
                else {
                    displayRequests(manager);
                }
            }
            else {
                printRequest(manager.requests.get(consider-1));
                System.out.println("Requester Information:\n---------------");
                switch (manager.requests.get(consider-1).from.job) {
                    case "D":
                        printDeveloperInfo((Developer) manager.requests.get(consider-1).from);
                        break;
                    case "E":
                        printEngineerInfo((Engineer) manager.requests.get(consider-1).from);
                }
                if(quit()) {
             //       WeaselCompany.displayMainMenu();
                } else {displayRequests(manager);}
            }

    }


    public static void displayInformation(WeaselCompany company) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1- Search by name\n" +
                "2- Search by ID\n" +
                "3- Search by age\n" +
                "4- Search by amount of salary\n" +
                "5- Search by college name\n" +
                "6- Search by project name\n" +
                "\nPlease filter your search =");
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                System.out.println("Please enter the name = ");
                String search = scanner.nextLine().toUpperCase();
                printMatched(company, searchStaff(company, search, answer ));
                break;
            case "2":
                System.out.println("Please enter the ID = ");
                search = scanner.nextLine().toUpperCase();
                printMatched(company, searchStaff(company, search, answer));
                break;
            case "5":
                System.out.println("Please enter the college name = ");
                search = scanner.nextLine().toUpperCase();
                printMatched(company, searchStaff(company, search, answer));
                break;
            case "6":
                System.out.println("Please enter the project name = ");
                search = scanner.nextLine().toUpperCase();
                printMatched(company, searchStaff(company, search, answer));
                break;

            case "3":
            case "4":
                searchByDefiningRange(company);
                break;
            default:
                System.out.println("Please enter a valid number!!!");
                displayInformation(company);
                break;
        }
    }

    public static void searchByDefiningRange(WeaselCompany company) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Staff> matched = new ArrayList<Staff>();

        //Setting upper and lower limits of age
        System.out.println("Please give a range (Lower Limit) = ");
        int lowerLimit = scanner.nextInt();
        System.out.println("Please give a range (Upper Limit) = ");
        int upperLimit = scanner.nextInt();

        if(upperLimit < lowerLimit) {
            System.out.println("Upper limit must bigger than lower limit!!");
            searchByDefiningRange(company);
        }
        //If the user is asking for age
        if(lowerLimit <= 50) {
            //Gets matching developers
            for(Staff staff : company.staffs) {
                if(staff.age <= upperLimit && staff.age >= lowerLimit) {
                    matched.add(staff);
                }
            }
        }
        //If the user is asking for salary
        else {
            //Gets matching developers
            for(Staff staff : company.staffs) {
                if(staff.salary <= upperLimit && staff.salary >= lowerLimit) {
                    matched.add(staff);
                }
            }

        }
        if(matched.size() == 0) {
            matched = null;
        }
        printMatched(company,matched);

    }

    public static ArrayList<Staff> searchStaff(WeaselCompany company, String searched, String searchBy) {
        ArrayList<Staff> matched = new ArrayList<Staff>();
        for(Staff staff : company.staffs) {
            switch (searchBy) {
                case "1":
                    if(staff.name.contains(searched)) {
                        matched.add(staff);
                    }
                    break;
                case "2":
                    if(staff.ID.contains(searched)) {
                        matched.add(staff);
                    }
                    break;
                case "5":
                    if(staff.universityName.contains(searched)) {
                        matched.add(staff);
                    }
                    break;
                case "6":
                    if(staff.projectName.contains(searched)) {
                        matched.add(staff);
                    }
                    break;
            }
        }
        return matched.size() == 0 ? null : matched;
    }

    public static void printStaff(ArrayList<Staff> staff, int index) {
        switch (staff.get(index).job) {
            case "D":
                printDeveloperInfo((Developer) staff.get(index));
                break;
            case "M":
                printManagerInfo((Manager) staff.get(index));
                break;
            case "E":
                printEngineerInfo((Engineer) staff.get(index));
                break;
        }
    }

    public static void printManagerInfo(Manager manager) {
        System.out.println("\nName = "+manager.name+
                "\nID = "+ manager.ID+
                "\nAge = "+ manager.age+
                "\nSalary = "+ manager.salary+
                "\nEntrance Date = "+ manager.entranceDate+
                "\nUniversity Name = "+ manager.universityName+
                "\nContact = "+ manager.phoneNumber
        );
        String projects = "Projects = ";
        for(int i = 0; i<manager.projects.size(); i++) {
            projects = projects.concat(manager.projects.get(i) + ", ");
        }
        projects = projects.substring(0, projects.length()-2);
        System.out.println(projects);

    }

    public static void printDeveloperInfo(Developer developer) {
        System.out.println("Name = "+developer.name+
                "\nID = "+ developer.ID+
                "\nAge = "+ developer.age+
                "\nTitle = "+ developer.title+
                "\nPassword = "+ developer.password+
                "\nMain Tool = "+ developer.mainTool+
                "\nEntrance Date = "+ developer.entranceDate+
                "\nSalary = "+ developer.salary+
                "\nUniversity Name = "+ developer.universityName+
                "\nAssigned Project = "+ developer.projectName+
                "\nContact = "+ developer.phoneNumber
        );
        //Printing tools
        String tools = "Tools = ";
        for(int i = 0; i<developer.tools.size(); i++) {
            tools = tools.concat(developer.tools.get(i) + ", ");
        }
        tools = tools.substring(0, tools.length()-2);
        System.out.println(tools);

        if(developer.isRemote) {
            System.out.println("This developer is working remotely...");
        } else {
            System.out.println("This developer is not working remotely...");
        }
    }

    public static void printEngineerInfo(Engineer engineer) {
        System.out.println("Name = "+engineer.name+
                "\nAge = "+ engineer.age+
                "\nID = "+ engineer.ID+
                "\nPassword = "+engineer.password+
                "\nEntrance Date = "+ engineer.entranceDate+
                "\nSalary = "+ engineer.salary+
                "\nUniversity Name = "+ engineer.universityName+
                "\nAssigned Project = "+ engineer.projectName+
                "\nContact = "+ engineer.phoneNumber+
                "\nArea = "+ engineer.area
        );
    }

    public static void printMatched(WeaselCompany company, ArrayList<Staff> matchedStaff) {
        Scanner scanner = new Scanner(System.in);

        //Checks if no result
        if(matchedStaff == null) {
            System.out.println("No matching result...");
            displayInformation(company);
        }
        else {
            //Prints matched staffs
            int counter= 1;
            for(Staff staff : matchedStaff) {
                //Gets class name properly
                String className = staff.getClass().getName().substring(staff.getClass().getName().lastIndexOf(".")+1);
                System.out.println(counter+ " - "+className+" (" + staff.ID + ") -> " + staff.name);
                counter++;
            }
            System.out.println("Which staff's information do you want to see = ");
            int answer = scanner.nextInt();
            if(answer > matchedStaff.size()) {
                System.out.println("Out of bounds!\n");
                printMatched(company, matchedStaff);
            }
            if(matchedStaff.get(answer - 1).job.equals("D")) {
                printDeveloperInfo((Developer) matchedStaff.get(answer - 1));
            }
            else if(matchedStaff.get(answer-1).job.equals("E")) {
                printEngineerInfo((Engineer) matchedStaff.get(answer-1));
            }
            else {
                printManagerInfo((Manager) matchedStaff.get(answer-1));
            }
            if(quit()) {
          //      WeaselCompany.displayMainMenu();
            } else {printMatched(company,matchedStaff);}
        }
    }

    public static void printRequest(Request request) {
        System.out.println("\nRequest:\n" +
                "---------------" +
                "\nID:     "+request.ID+
                "\nFrom:   "+request.from.name+
                "\nTo:     "+request.to.name+
                "\nType:   "+request.type.toUpperCase()+
                "\nReason: "+request.reason.toUpperCase()+
                "\n\nYour Petition:\n'''"+request.petition+"\n\n'''");
    }

    public static void makeRequest(WeaselCompany company) {
        String ID = WeaselCompany.generateRequestID();
        String type = specifyRequestType();
        String reason = specifyRequestReason(type);
        String petition = writePetition(company.managers.get(0));
        Request request =  new Request(ID, company.managers.get(0), company.CEO, type,reason,petition);
        printRequest(request);
        System.out.println("Are you sure Mr."+company.managers.get(0).name+"? (y/n)");
        if(doYouAccept(company.managers.get(0))) {
            company.CEO.requests.add(request);
            System.out.println("Your request has been send.");
        } else {
            makeRequest(company);
            System.out.println("You canceled your request.");
        }

    }

    public static boolean doYouAccept(Manager manager) {
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextLine()) {
            case "y":
                return true;
            case "n":
                return false;
            default:
                System.out.println("Please only enter 'y' or 'n'!\n");
                return doYouAccept(manager);
        }
    }

    public static String writePetition(Manager manager) {
        Scanner scanner = new Scanner(System.in);
        String currentLine;
        ArrayList<String> lines = new ArrayList<String>();
        System.out.println("Write your petition here:\n");
        do {
            currentLine = scanner.nextLine();
            lines.add(currentLine);
        }
        while(!currentLine.trim().equals(manager.name));

        String petition = "";
        for(String line : lines) {
            petition = petition.concat("\n"+line);
        }
        return petition;
    }

    public static String specifyRequestReason(String type) {
        Scanner scanner = new Scanner(System.in);
        switch (type) {
            case "quit":
                System.out.println("1- Insufficient salary\n" +
                        "2- Personal issues\n" +
                        "3- Health issues\n" +
                        "4- Incompatibility with staff\n" +
                        "Please specify your quit request: ");
                switch (scanner.next()) {
                    case "1":
                        return "Insufficient salary";
                    case "2":
                        return "Personal issues";
                    case "3":
                        return "Health issues";
                    case "4":
                        return "Incompatibility with staff";
                    default:
                        System.out.println("Please provide valid number!\n");
                        return specifyRequestReason(type);
                }

            case "raise":
            case "promotion":
                System.out.println("1- Financial needs\n" +
                        "2- Reflection of efficiency\n" +
                        "Please specify your request: ");
                switch (scanner.next()) {
                    case "1":
                        return "Financial needs";
                    case "2":
                        return "Reflection of efficiency";
                    default:
                        System.out.println("Please provide valid number!\n");
                        return specifyRequestReason(type);
                }

            case "permission":
                System.out.println("1- Personal issues\n" +
                        "2- Health issues\n" +
                        "3- Vacation\n" +
                        "Please specify your permission request:");
                switch (scanner.next()) {
                    case "1":
                        return "Personal issues";
                    case "2":
                        return "Health issues";
                    case "3":
                        return "Vacation";
                    default:
                        System.out.println("Please provide valid number!\n");
                        return specifyRequestReason(type);
                }
            default:
                System.out.println("Please provide valid number!\n");
                return specifyRequestType();
        }

    }


    public static String specifyRequestType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Quit request\n" +
                "2- Raise request\n" +
                "3- Promotion request\n" +
                "4- Permission request\n" +
                "Which type of request do you want to make?");
        switch (scanner.next()) {
            case "1":
                return "quit";
            case "2":
                return "raise";
            case "3":
                return "promotion";
            case "4":
                return "permission";
            default:
                System.out.println("Please give valid number!\n");
                return specifyRequestType();
        }


        }
    }
