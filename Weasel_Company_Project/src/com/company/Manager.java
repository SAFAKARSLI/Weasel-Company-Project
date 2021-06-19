package com.company;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Manager(String name, int age, String ID, String entranceDate,
                   int salary, String universityName, ArrayList<String> projects,
                   String phoneNumber) {
        super(name, age, ID, entranceDate, salary, universityName, "", phoneNumber,"M");
        this.projects = projects;
    }

    public static void quitRequest(WeaselCompany company) {
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


}
