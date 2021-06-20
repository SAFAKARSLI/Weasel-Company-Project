package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Manager extends Staff{

    public String password;
    public ArrayList<String> projects;
    public ArrayList<Staff> crew;
    public ArrayList<Request> requests;
    public ArrayList<Request> inbox;

    public Manager(String name, int age, String ID, String entranceDate,
                   int salary, String universityName, ArrayList<String> projects,
                   String phoneNumber, String password) {
        super(name, age, ID, entranceDate, salary, universityName, "", phoneNumber,"M");
        this.password = password;
        this.projects = projects;
        this.crew = new ArrayList<>();
        this.requests = new ArrayList<>();
        this.inbox = new ArrayList<>();
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type anything to quit:");
        if(scanner.hasNext()) {
            WeaselCompany.displayMainMenu(Company, manager);
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
        for(int i=1; i<Company.managers.size(); i++) {
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
        System.out.println("\nTo go to previous screen enter 'back', to back to the main menu enter 'quit':");
        switch (scanner.next()) {
            case "back":
                return false;
            case "quit":
                return true;
            default:
                System.out.println("You can only type 'back' or 'quit'!\n");
                return quit();
        }
    }

    public static void displayRequests(WeaselCompany company, Manager manager) {
        Scanner scanner = new Scanner(System.in);

        //If no request existing
        if(manager.requests.size() == 0) {
            System.out.println("There is no request to display.");
            WeaselCompany.displayMainMenu(company, manager);
        }
        //Printing all existing requests
        System.out.println("Request ID:       From:\n-------------     -------------");
        for (int i = 0; i <manager.requests.size(); i++) {
            System.out.println((i+1) +"- "+manager.requests.get(i).ID+"       "+ manager.requests.get(i).from.name
                    + " ("+manager.requests.get(i).from.ID+")");
        }
            System.out.println("Which request would you like to consider?");
            int consider = scanner.nextInt();
            //If input is invalid
            if(consider > manager.requests.size()) {
                System.out.println("Request list does not include '"+consider+"'.\nDid you mean last element of the list?\nType yes or no:");
                //If user wants to see the last element of the list
                if(doYouAccept()) {
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
                    //Go back or main menu
                    if(quit()) {
                        WeaselCompany.displayMainMenu(company, manager);
                    } else {displayRequests(company, manager);}
                }
                else {
                    displayRequests(company, manager);
                }
            }
            else {
                //Printing request and requester information
                printRequest(manager.requests.get(consider-1));
                System.out.println("Requester Information:\n---------------");
                switch (manager.requests.get(consider-1).from.job) {
                    case "D":
                        printDeveloperInfo((Developer) manager.requests.get(consider-1).from);
                        break;
                    case "E":
                        printEngineerInfo((Engineer) manager.requests.get(consider-1).from);
                }
                //Considering the request (accept or refuse)
                System.out.println("\nDo you accept this request?\nType yes or no:");
                if(doYouAccept()) {
                    System.out.println("You have accepted the request.");
                } else {
                    System.out.println("You have refused the request.");
                }
                //Removing request from requests list
                manager.requests.remove(consider-1);

                if(quit()) {
                    WeaselCompany.displayMainMenu(company, manager);
                } else { displayRequests(company,manager); }
            }

    }

    public static void displayInbox(WeaselCompany company, Manager manager) {
        Scanner scanner = new Scanner(System.in);
        if(manager.inbox.size() == 0) {
            System.out.println("Inbox is empty.");
            WeaselCompany.displayMainMenu(company, manager);
        }
        System.out.println("\nInbox:");
        for(int i = 0 ; i<manager.inbox.size(); i++) {
            System.out.println((i+1) + ": "+manager.inbox.get(i).type);
        }
        System.out.println("\nWhich message would you want to open?");
        int number = scanner.nextInt();
        printRequest(manager.inbox.get(number-1));
        if(!manager.inbox.get(number-1).from.name.equals("KEVIN JOHNS")) {
            printRequester(manager.inbox.get(number-1));
            considerRequest(company,manager.inbox.get(number-1));
        }
        manager.inbox.remove(number-1);
        if(quit()){
            WeaselCompany.displayMainMenu(company, manager);
        } else { displayInbox(company, manager); }
    }


    public static void printRequester(Request request) {
        System.out.println("\nName: "+request.from.name+
                "\nAge: "+ request.from.age+
                "\nExpected Salary: $"+ request.from.salary+
                "\nUniversity: "+ request.from.universityName+
                "\nContact: "+ request.from.phoneNumber+
                "\nPosition: "+request.from.getClass().getName().substring(request.from.getClass().getName().lastIndexOf(".")+1));

    }

    public static void considerRequest(WeaselCompany company,Request request) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you accept this request? Type 'yes' or 'no'");
        if(doYouAccept()) {
            switch(request.type) {
                case "job application":
                    System.out.println(request.from.name+ " is now employee");
                    company.staffs.add(request.from);
                    break;
                case "quit":
                    System.out.println("You accepted the quit request. "+request.from.name+" is removed from the company staff list.");
                    company.staffs.remove(request.from);
                    break;
                case "rise":
                    System.out.println("Please provide rise amount:");
                    int amount = scanner.nextInt();
                    System.out.println(request.from.name +"'s salary has been increased from $"+request.from.salary+" to $"+request.from.salary+amount);
                    request.from.salary += amount;
                    break;
                case "promotion":
                    System.out.println("Promotion has been given to "+ request.from.name);
                    break;
                case "permission":
                    System.out.println("Permission has been given to "+ request.from.name);
                    break;
            }
        }
        else {
            System.out.println("You refused the "+request.from.name+"'s "+request.type+" request.");
        }

    }

    public static void displayInformation(WeaselCompany company, Manager manager) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1: Search by Name\n" +
                "2: Search by ID\n" +
                "3: Search by Age\n" +
                "4: Search by Amount of Salary\n" +
                "5: Search by College Name\n" +
                "6: Search by Project Name\n" +
                "\nPlease filter your search:");
        String answer = scanner.nextLine();
        switch (answer) {
            case "1":
                System.out.println("Please enter the name: ");
                String search = scanner.nextLine().toUpperCase();
                printMatched(company, searchStaff(company, search, answer ));
                break;
            case "2":
                System.out.println("Please enter the ID: ");
                search = scanner.nextLine().toUpperCase();
                printMatched(company, searchStaff(company, search, answer));
                break;
            case "5":
                System.out.println("Please enter the college name: ");
                search = scanner.nextLine().toUpperCase();
                printMatched(company, searchStaff(company, search, answer));
                break;
            case "6":
                System.out.println("Please enter the project name: ");
                search = scanner.nextLine().toUpperCase();
                printMatched(company, searchStaff(company, search, answer));
                break;

            case "3":
            case "4":
                searchByDefiningRange(company, manager);
                break;
            default:
                System.out.println("Please enter a valid number.");
                displayInformation(company, manager);
                break;
        }
    }

    public static void searchByDefiningRange(WeaselCompany company, Manager manager) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Staff> matched = new ArrayList<Staff>();

        //Setting upper and lower limits of age
        System.out.println("Please type the lower limit of the range: ");
        int lowerLimit = scanner.nextInt();
        System.out.println("Please type the upper limit of the range: ");
        int upperLimit = scanner.nextInt();

        if(upperLimit < lowerLimit) {
            System.out.println("The upper limit must be bigger than the lower limit.");
            searchByDefiningRange(company, manager);
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
        if(quit()) {
            WeaselCompany.displayMainMenu(company, manager);
        } else { printMatched(company, matched);}

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
        System.out.println("\nName: "+manager.name+
                "\nID: "+ manager.ID+
                "\nAge: "+ manager.age+
                "\nSalary: "+ manager.salary+
                "\nEntrance Date: "+ manager.entranceDate+
                "\nUniversity: "+ manager.universityName+
                "\nContact: "+ manager.phoneNumber
        );
        String projects = "Projects: ";
        for(int i = 0; i<manager.projects.size(); i++) {
            projects = projects.concat(manager.projects.get(i) + ", ");
        }
        projects = projects.substring(0, projects.length()-2);
        System.out.println(projects);

    }

    public static void printDeveloperInfo(Developer developer) {
        System.out.println("Name: "+developer.name+
                "\nID: "+ developer.ID+
                "\nAge: "+ developer.age+
                "\nTitle: "+ developer.title+
                "\nPassword: "+ developer.password+
                "\nMain Tool: "+ developer.mainTool+
                "\nEntrance Date: "+ developer.entranceDate+
                "\nSalary: "+ developer.salary+
                "\nUniversity: "+ developer.universityName+
                "\nAssigned Project: "+ developer.projectName+
                "\nContact: "+ developer.phoneNumber
        );
        //Printing tools
        String tools = "Tools = ";
        for(int i = 0; i<developer.tools.size(); i++) {
            tools = tools.concat(developer.tools.get(i) + ", ");
        }
        tools = tools.substring(0, tools.length()-2);
        System.out.println(tools);

        if(developer.isRemote) {
            System.out.println("This developer is working remotely.");
        } else {
            System.out.println("This developer is not working in the office.");
        }

    }

    public static void printEngineerInfo(Engineer engineer) {
        System.out.println("Name: "+engineer.name+
                "\nAge: "+ engineer.age+
                "\nID: "+ engineer.ID+
                "\nPassword: "+engineer.password+
                "\nEntrance Date: "+ engineer.entranceDate+
                "\nSalary: "+ engineer.salary+
                "\nUniversity Name: "+ engineer.universityName+
                "\nAssigned Project: "+ engineer.projectName+
                "\nContact: "+ engineer.phoneNumber+
                "\nArea: "+ engineer.area
        );
    }

    public static void printMatched(WeaselCompany company, ArrayList<Staff> matchedStaff) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Staff> upToDateList = new ArrayList<>();
        //Checks if no result
        if(matchedStaff == null) {
            System.out.println("There is no matching result.");
            displayInformation(company, company.managers.get(0));
        }
        else {
            //Prints matched staffs
            int counter= 1;
            for(Staff staff : matchedStaff) {
                //Gets class name properly
                String className = staff.getClass().getName().substring(staff.getClass().getName().lastIndexOf(".")+1);
                System.out.println(counter+ " - "+className+" (" + staff.ID + ") -- " + staff.name);
                counter++;
            }
            System.out.println("Type which staff's information do you want to see: ");
            int answer = scanner.nextInt();
            if(answer > matchedStaff.size()) {
                System.out.println("Type a valid number:\n");
                printMatched(company, matchedStaff);
            }
            printStaff(matchedStaff, answer-1);
            System.out.println("Do you want to see the actions? Type 'yes' or 'no':");
            if(doYouAccept()) {
                upToDateList = action(company,matchedStaff,answer-1);
            }
            if(quit()) {
                WeaselCompany.displayMainMenu(company, company.managers.get(0));
            } else {printMatched(company,upToDateList);}

        }
    }

    public static ArrayList<Staff> action(WeaselCompany company, ArrayList<Staff> matched, int index) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: Fire "+matched.get(index).name+" \n" +
                "2: Give a rise");
        while(true) {
            System.out.println("What do you want to do with this staff?");
            switch (scanner.next()) {
                case "1":
                    System.out.println("You fired "+matched.get(index-1).name);
                    company.staffs.remove(matched.get(index-1));
                    matched.remove(index);
                    return matched;
                case "2":
                    while(true) {
                        System.out.println("Please specify preferred rise: ");
                        int amount = scanner.nextInt();
                        if(amount <= 0) {
                            System.out.println("Please provide positive amount.");
                            continue;
                        }
                        else {
                            System.out.println("\n*\nYou increased "+matched.get(index).name+"'s salary from $"+ matched.get(index).salary+
                                    " to $"+(matched.get(index).salary+amount)+"\n*\n");
                            matched.get(index).salary += amount;
                            printStaff(matched, index);
                            return matched;
                        }
                    }
                default:
                    System.out.println("Out of bounds!");
            }
        }
    }


    public static void printRequest(Request request) {
        System.out.println("\nResult:\n" +
                "---------------" +
                "\nID:     "+request.ID+
                "\nFrom:   "+request.from.name+
                "\nTo:     "+request.to.name+
                "\nType:   "+request.type.toUpperCase()+
                "\nReason: "+request.reason.toUpperCase()+
                "\nAdditional Message (Petition): \n---\n"+request.petition+"\n---");
    }

    public static void makeRequest(WeaselCompany company, Manager manager) {
        String ID = WeaselCompany.generateRequestID();
        String type = specifyRequestType();
        String reason = specifyRequestReason(type);
        String petition = writePetition(manager);
        Request request =  new Request(ID, manager, company.CEO, type,reason,petition);
        printRequest(request);
        System.out.println("Are you sure, type yes or no:");
        if(doYouAccept()) {
            company.CEO.requests.add(request);
            System.out.println("Your request has been send.\n");
        } else {
            System.out.println("You have canceled your request.\n");
            WeaselCompany.displayMainMenu(company, manager);
        }
        WeaselCompany.considerRequest(company,company.CEO, manager);
        WeaselCompany.displayMainMenu(company, manager);

    }

    public static boolean doYouAccept() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "yes":
                return true;
            case "no":
                return false;
            default:
                System.out.println("Please only enter 'yes' or 'no':");
                return doYouAccept();
        }
    }

    public static String writePetition(Manager manager) {
        Scanner scanner = new Scanner(System.in);
        String currentLine;
        ArrayList<String> lines = new ArrayList<String>();
        System.out.println("\nWrite your petition here: ");
        do {
            currentLine = scanner.nextLine();
            lines.add(currentLine);
        }
        while(!currentLine.trim().equals(manager.name));

        String petition = "";
        for(String line : lines) {
            petition = petition.concat(line+"\n");
        }
        return petition;
    }

    public static String specifyRequestReason(String type) {
        Scanner scanner = new Scanner(System.in);
        switch (type) {
            case "quit":
                System.out.println("\n1: Insufficient Salary\n" +
                        "2: Personal Issues\n" +
                        "3: Health Issues\n" +
                        "4: Incompatibility with Staff\n" +
                        "Please specify your quit request: ");
                switch (scanner.next()) {
                    case "1":
                        return "Insufficient Salary";
                    case "2":
                        return "Personal Issues";
                    case "3":
                        return "Health Issues";
                    case "4":
                        return "Incompatibility with Staff";
                    default:
                        System.out.println("Please provide valid number:\n");
                        return specifyRequestReason(type);
                }

            case "raise":
            case "promotion":
                System.out.println("1: Financial Needs\n" +
                        "2: Reflection of Efficiency\n" +
                        "Please specify your request: ");
                switch (scanner.next()) {
                    case "1":
                        return "Financial Needs";
                    case "2":
                        return "Reflection of Efficiency";
                    default:
                        System.out.println("Please provide valid number:\n");
                        return specifyRequestReason(type);
                }

            case "permission":
                System.out.println("1: Personal Issues\n" +
                        "2: Health Issues\n" +
                        "3: Vacation\n" +
                        "Please specify your permission request:");
                switch (scanner.next()) {
                    case "1":
                        return "Personal Issues";
                    case "2":
                        return "Health Issues";
                    case "3":
                        return "Vacation";
                    default:
                        System.out.println("Please provide valid number:\n");
                        return specifyRequestReason(type);
                }
            default:
                System.out.println("Please provide valid number:\n");
                return specifyRequestType();
        }

    }


    public static String specifyRequestType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n1: Quit request\n" +
                "2: Raise request\n" +
                "3: Promotion request\n" +
                "4: Permission request\n" +
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
