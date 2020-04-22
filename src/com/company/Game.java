package com.company;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class Game {
    String naam;
    double prijs;
    double currentPrice;
    int jaar;

    public Game(String nm,int jr,double pr){
        this.naam = nm;
        this.jaar = jr;
        this.prijs = pr;
        setCurrentPrice(prijs,jaar);
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public int getJaar() {
        return jaar;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double oldprice, int year){
        int teller = LocalDate.now().getYear() - year;//Check hoeveel jaar verschilt
        this.currentPrice = oldprice;
        IntStream.range(0,teller).forEach(
                n -> {
                    this.currentPrice = currentPrice * 0.7; //Daling van 30% per jaar.
                }
        );
    }


    @Override
    public String toString() {
        return String.format("%s, uitgegeven in %d; nieuwprijs: %.2f nu voor: €%.2f\n",
                getNaam(),getJaar(),getPrijs(),getCurrentPrice());
    }
}
