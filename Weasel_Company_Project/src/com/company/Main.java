package com.company;

public class Main {
    public static void main(String[] args) {

        // displayLoginScreen();

        Manager CEO = WeaselCompany.createCEO();

        WeaselCompany Company = WeaselCompany.createCompany(CEO);

        Manager TheManager = WeaselCompany.createTheManager("Sam", Company);

        WeaselCompany.createProjects(Company);

        WeaselCompany.generateManagers(Company, 2);
        WeaselCompany.assignProjectsToManagers(Company);

        WeaselCompany.generateDevelopers(Company, 40);
        WeaselCompany.generateEngineers(Company, 20);











    }
}
