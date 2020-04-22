package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Persoon {
    String naam;
    double budget;
    List<Game> games = new ArrayList<>(); //Alle games van de persoon.

    public Persoon(String nm, double bg){
        this.naam = nm;
        this.budget = bg;
    }

    public String koop(Game gm){
        double som = getBudget() - gm.getCurrentPrice();
        int check = 0; // Als check 1 is dan is het spel al in het bezit van de koper.
        for (Game spel : getGames()) {
            String gamename = spel.getNaam();
            if (gamename.equals(gm.getNaam())) {
                check = 1;
                break;
            }
        }
        if (check == 1){
            return "niet gelukt";
        }else if(som < 0){
            return "niet gelukt";
        }else{
            setBudget(som); // Sla het nieuwe budget op.
            setGames(gm); // Sla spel op in bezittingen.
            return "gelukt";
            }
    }

    public String verkoop(Game gm, Persoon p){
        double som = p.getBudget()  - gm.getCurrentPrice();
        int check1 = 0; // Als waarde 1 is dan kan persoon het spel verkopen.
        int check2 = 0; // Als waarde 1 is dan is het spel al in het bezit van de koper.

        for (Game spel : getGames()) {
            String gamename = spel.getNaam();
            if (gamename.equals(gm.getNaam())) {
                check1 = 1;
                break;
            }
        }
        for (Game spel : p.getGames()) {
            String gamename = spel.getNaam();
            if (gamename.equals(gm.getNaam())) {
                check2 = 1;
                break;
            }
        }
        if (check1 == 0){
            return "niet gelukt";
        }else if (check2 == 1 ){
            return "niet gelukt";
        }
        else if(som < 0){
            return "niet gelukt";
        }else{
            p.setBudget(som); // Sla het nieuwe budget op.
            p.setGames(gm); // Sla spel op in bezittingen.
            double newBudget = getBudget() + gm.getCurrentPrice();
            setBudget(newBudget); // Voeg de verkoopprijs toe aan de verkoper.
            return "gelukt";
        }
    }

    public void setGames(Game gm) {
        this.games.add(gm);
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getNaam() {
        return naam;
    }

    public double getBudget() {
        return budget;
    }

    public List<Game> getGames() {
        return games;
    }

    @Override
    public String toString() {
        return String.format("%s heeft een budget van %.2f en bezit de volgende games:\n" +
                "%s\n\n",getNaam(), getBudget(),games).
                replace("[", "").replace("]",""); //Haal haakjes weg van de array
    }
}
