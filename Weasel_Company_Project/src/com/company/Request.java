package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Request {

    String ID;
    Staff from;
    Manager to;
    String type;
    String reason;
    String petition;

    public Request(String ID, Staff from, Manager to, String type, String reason, String petition) {
        this.ID = ID;
        this.from = from;
        this.to = to;
        this.type = type;
        this.reason = reason;
        this.petition = petition;
    }

    public static String generatePetition(Request request){
        ArrayList<String> possiblePetitions = new ArrayList<>();
        Random rand = new Random();
        switch (request.type) {

            case "quit":
                possiblePetitions.add("Thank you so much for rendering me the opportunity\n" +
                        "to serve your company and I’ll be grateful to you for this.\n" +
                        "You’ll always be cherished with great honor, Boss!");
                possiblePetitions.add("I will forever adore the memories of working with such\n" +
                        "an amazing boss. Thank you for all the help.");
                possiblePetitions.add("I’m leaving this company with some amazing memories.\n" +
                        "Thank you, sir, for guiding me all these years.");
                possiblePetitions.add("Let me express my gratitude to you for teaching me so many\n" +
                        "things new and old through my serving period to this company.\n" +
                        "I’ll miss you, Sir!");
                possiblePetitions.add("Thank you so much for rendering me the opportunity to serve your company and I’ll\n" +
                        "be grateful to you for this. You’ll always be cherished with great honor, Boss!");
                possiblePetitions.add("Though I’m leaving, I’ll never forget the things you bestowed me and will always\n" +
                        "follow them in my working career. You’re the best boss I’ve ever met.");
                possiblePetitions.add("Know my heartiest thankfulness for the guidance and support that you rendered me.\n" +
                        "All your gestures will be kept in the heart and cherished always. Goodbye Sir!");
                possiblePetitions.add("It has been an incredible journey with a co-operative boss like you.\n" +
                        "Thanks for helping me with my work and teaching me some valuable lessons. Pray for my new job.");
                possiblePetitions.add("The way may change, the career may change, but the valuable lessons I’ve achieved from you is unforgettable.\n" +
                        "Working under a boss like you was a prerogative experience.");
                possiblePetitions.add("May wherever I go, what you’ve rendered in me is always a treasure to me.\n" +
                        "Thank you for being there always to guide me. Goodbye Sir!");
                break;

            case "raise":
                String aOrAn = "";
                if(request.from.job.equals("E")){
                    aOrAn = "an ";
                } else {
                    aOrAn = "a ";
                }
                possiblePetitions.add("I am writing to formally request a review of my current salary.\n" +
                        "As " + aOrAn + request.from.job + " with all these years at Weasel Company,\n" +
                        "I have always been ready and able when asked to take on additional work and new job responsibilities.\n" +
                        "I believe a review of my track record with the company, my recent achievements in Project " + request.from.projectName + ", along with industry average salaries,\n" +
                        "will demonstrate justification for an increase in my annual pay.");
                possiblePetitions.add("My role has evolved since starting with Weasel Company.\n" +
                        "In the past year, I have distinguished myself with the accomplishments in the following missions:\n" +
                        "Mission-" + rand.nextInt(5) + " of Project " + request.from.projectName +
                        "\nMission-" + (5 + rand.nextInt(5)) + " of Project " + request.from.projectName+
                        "\nMission-" + (10 + rand.nextInt(5)) + " of Project " + request.from.projectName+
                        "I believe these all justify an increase in my annual pay.");
                possiblePetitions.add("In order to simplify your consideration I would like to share some of the accomplishments of mine in the following missions: :\n" +
                        "Mission-" + rand.nextInt(5) + " of Project " + request.from.projectName +
                        "\nMission-" + (5 + rand.nextInt(5)) + " of Project " + request.from.projectName+
                        "\nMission-" + (10 + rand.nextInt(5)) + " of Project " + request.from.projectName+
                        "Thank you for your attention to this matter. I am willing to work with you to accommodate\n" +
                        "my request along with what is best for the company. If you have another amount in mind or\n" +
                        "a plan to increase my salary in the future, I am open to negotiation.");
                break;

            case "promotion":
                String aOrAns = "";
                String pos;
                if(request.from.job.equals("E")){
                    aOrAns = "an ";
                    pos = "Engineer";
                } else {
                    aOrAns = "a ";
                    pos = "Developer";
                }
                possiblePetitions.add("I am writing to formally request a promotion to my position.\n" +
                        "As " + aOrAns + pos + " with all these years at Weasel Company,\n" +
                        "I have always been ready and able when asked to take on additional work and new job responsibilities.\n" +
                        "I believe a review of my track record with the company, my recent achievements in Project " + request.from.projectName + ",\n" +
                        "will demonstrate justification for a promotion.");
                possiblePetitions.add("My role has evolved since starting with Weasel Company.\n" +
                        "In the past year, I have distinguished myself with the accomplishments in the following missions:\n" +
                        "Mission-" + rand.nextInt(5) + " of Project " + request.from.projectName +
                        "\nMission-" + (5 + rand.nextInt(5)) + " of Project " + request.from.projectName+
                        "\nMission-" + (10 + rand.nextInt(5)) + " of Project " + request.from.projectName+
                        " I believe these all justify a promotion.");
                possiblePetitions.add("In order to simplify your consideration I would like to share some of the accomplishments of mine in the following missions: :\n" +
                        "Mission-" + rand.nextInt(5) + " of Project " + request.from.projectName +
                        "\nMission-" + (5 + rand.nextInt(5)) + " of Project " + request.from.projectName+
                        "\nMission-" + (10 + rand.nextInt(5)) + " of Project " + request.from.projectName+
                        "Thank you for your attention to this matter. I am willing to work with you to accommodate\n" +
                        "my request along with what is best for the company.");
                break;

            case "permission":
                possiblePetitions.add("");
                break;

            case "job application":
                possiblePetitions.add("I have been dreaming of being a part of this exceptional company since I have graduated from " + request.from.universityName +",\n" +
                        "and considering my CV, I believe I can bring a lot to Weasel Company.");
                possiblePetitions.add("I have been following progress of Project " + request.from.projectName + " enthusiastically,\n" +
                        "and also willing to contribute with my ideas that I have been working on and looking forward to share with you.");
                break;
        }

        int i = rand.nextInt(possiblePetitions.size());
        return possiblePetitions.get(i);

    }



}
