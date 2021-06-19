package com.company;

public class Main {

    public static void main(String[] args) {

        // displayLoginScreen();

        Manager CEO = WeaselCompany.createCEO();

        WeaselCompany Company = WeaselCompany.createCompany(CEO);

        Manager TheManager = WeaselCompany.createTheManager("Sam Jason","password", Company);

        WeaselCompany.createProjects(Company);

        WeaselCompany.generateManagers(Company, 3);
        WeaselCompany.generateDevelopers(Company, 400);
        WeaselCompany.generateEngineers(Company, 200);

        WeaselCompany.assignProjectsToManagers(Company);
        WeaselCompany.formCrews(Company);


















    }
}
