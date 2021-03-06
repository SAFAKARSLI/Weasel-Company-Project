package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] initialInfo = Manager.displayLoginScreen(scanner);

        Manager CEO = WeaselCompany.createCEO();

        WeaselCompany Company = WeaselCompany.createCompany(CEO);

        Manager TheManager = Company.createTheManager(initialInfo[0],initialInfo[1]);

        Company.createProjects();

        Company.generateManagers(3);
        Company.generateDevelopers(200);
        Company.generateEngineers(400);

        Company.assignProjectsToManagers();
        Company.formCrews();

        Company.generateRequests(8);
        Company.generateJobApplication(TheManager, 2,2);

        WeaselCompany.displayMainMenu(Company, TheManager);

    }
}
