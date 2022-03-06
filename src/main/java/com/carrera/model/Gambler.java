package com.carrera.model;

public class Gambler {
    private String name;
    private int amount;
    private final int numberOfBets = 10;
    private int[]bets=new int[numberOfBets];

    
    public Gambler(String name, int[] bets, int amount) {
        this.name = name;
        this.bets = bets;
        this.amount = amount;
    }

    

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getBets() {
        return bets;
    }

    public void setBets(int[] bets) {
        this.bets = bets;
    }
    
}
