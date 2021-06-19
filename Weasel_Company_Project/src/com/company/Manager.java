package com.company;

import java.util.ArrayList;
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

    public static void displayToDo() {

    }


















































}
