package com.company;

public class Main {

    public static void main(String[] args) {

        // displayLoginScreen();

        Manager CEO = WeaselCompany.createCEO();

        WeaselCompany company = WeaselCompany.createCompany(CEO);

        Manager theManager = WeaselCompany.createTheManager("Sam Jason","password", company);

        WeaselCompany.createProjects(company);

        WeaselCompany.generateManagers(company, 3);
        WeaselCompany.generateDevelopers(company, 400);
        WeaselCompany.generateEngineers(company, 200);

        WeaselCompany.assignProjectsToManagers(company);
        WeaselCompany.formCrews(company);



















    }
}
