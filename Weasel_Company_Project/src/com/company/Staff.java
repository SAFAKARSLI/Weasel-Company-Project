package com.company;

import java.util.ArrayList;
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

    public Staff(String name, int age, String ID, String entranceDate, int salary, String universityName, String projectName, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.entranceDate = entranceDate;
        this.salary = salary;
        this.universityName = universityName;
        this.projectName = projectName;
        this.phoneNumber = phoneNumber;
    }

    public void displayInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        switch (scanner.nextLine()) {
            case "1":
                searchByName();
                break;
            case "2":
//                searchByID();
                break;
            case "3":
//                searchByAge();
                break;
            case "4":
//                searchBySalary();
                break;
            case "5":
//                searchByCollegeName();
                break;
            case "6":
//                searchByProject();
                break;
            default:
                System.out.println("Please give valid number!!!");
                displayInformation();
                break;
        }
    }

    public void searchByName() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<String>();
        System.out.println("Please write the name = ");


    }













}
