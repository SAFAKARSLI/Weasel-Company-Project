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
            int h = rand.nextInt(10);
            String projectName = crewCopy.get(j).projectName.substring(0,1) + crewCopy.get(j).projectName.substring(1).toLowerCase();
            duties.add("Arrange a meeting with " + crewCopy.get(j).name + " about the Mission-" + h +
                    " of Project " + projectName );
            duties.add("Review Document-" + h + " of Project " + projectName);
            crewCopy.remove(j);
        }

        return duties;
    }


















































}
