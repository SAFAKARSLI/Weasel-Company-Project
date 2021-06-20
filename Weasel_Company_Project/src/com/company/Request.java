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

        switch (request.type) {

            case "quit":
                possiblePetitions.add("It has been such ");
                possiblePetitions.add("           ");
                possiblePetitions.add("           ");
                break;

            case "raise":
                possiblePetitions.add("           ");
                possiblePetitions.add("           ");
                possiblePetitions.add("           ");
                break;

            case "promotion":
                possiblePetitions.add("           ");
                possiblePetitions.add("           ");
                possiblePetitions.add("           ");

                break;

            case "permission":
                possiblePetitions.add("           ");
                possiblePetitions.add("           ");
                possiblePetitions.add("           ");
                break;

            case "job application":
                possiblePetitions.add("           ");
                possiblePetitions.add("           ");
                possiblePetitions.add("           ");
                break;
        }

        Random rand = new Random();
        int i = rand.nextInt(possiblePetitions.size());
        return possiblePetitions.get(i);

    }



}
