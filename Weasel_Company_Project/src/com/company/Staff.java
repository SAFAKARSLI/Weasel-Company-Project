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
    public String job;

    public Staff(String name, int age, String ID, String entranceDate, int salary, String universityName, String projectName, String phoneNumber, String job) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.entranceDate = entranceDate;
        this.salary = salary;
        this.universityName = universityName;
        this.projectName = projectName;
        this.phoneNumber = phoneNumber;
        this.job = job;
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

        switch (scan.nextInt()) {
            case 1:
//                quitRequest(company));
                break;
            case 2:
//                riseRequest(company);
                break;
            case 3:
//                promotionRequest(company);
                break;
            case 4:
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

        //If the user is looking for age
        if(lowerLimit <= 50) {
            //Gets matching developers
            for(Staff staff : company.staffs) {
                if(staff.age <= upperLimit && staff.age >= lowerLimit) {
                    matched.add(staff);
                }
            }

        }
        //If the user is looking for salary
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
            System.out.println("This developer is working remotely...");
        } else {
            System.out.println("This developer is not working remotely...");
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
                System.out.println("Out of bounds!!!\n");
                printMatched(company, matchedStaff);
            }
            if(matchedStaff.get(answer - 1).job.equals("D")) {
                printDevInfo((Developer) matchedStaff.get(answer - 1));
            }
            else if(matchedStaff.get(answer-1).job.equals("E")) {
                printEngineerInfo((Engineer) matchedStaff.get(answer-1));
            }
            else {
                printManagerInfo((Manager) matchedStaff.get(answer-1));
            }
        }




    }

}
