package com.carrera.model;

/**
 * Clase encargada de definir las caracteristicas de un apostador
 */
public class Gambler {
    private String name;
    private int amount;
    private final int numberOfBets = 10;
    private int[]bets=new int[numberOfBets];

    /**
     * Constructor de la clase Gambler
     * @param name Nombre del apostador
     * @param bets Lista del orden de llegada de los caballos
     * @param amount Monto apostado
     */
    public Gambler(String name, int[] bets, int amount) {
        this.name = name;
        this.bets = bets;
        this.amount = amount;
    }

    
    /**
     * Metodo encargado de retornar el monto apostado
     * @return retorna el valor int del monto 
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Metodo encardado de definir el valor del monto
     * @param amount ingresa el valor int del monto
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Metodo encargado de retornar el nombre del apostador
     * @return retornar el nombre del apostador
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo encargado de definir el nombre del apostador
     * @param name ingresa el nombre del apostador
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo encargado de retornar el array con el orden de llegada de los caballos
     * @return retorna el array con el orden de llegada de los caballos
     */
    public int[] getBets() {
        return bets;
    }

    /**
     * Metodo encargado de definir el array con el orden de llegada de los caballos
     * @param bets ingresa el array con el orden de llegada de los caballos
     */
    public void setBets(int[] bets) {
        this.bets = bets;
    }
    
}
