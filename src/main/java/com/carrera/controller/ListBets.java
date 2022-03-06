package com.carrera.controller;

import com.carrera.model.Gambler;

public class ListBets {
    
    private Nodo head = null;
    private int longitude = 0;
    private class Nodo{
        public Gambler bet;
        public Nodo next = null;
        public Nodo(Gambler bet) {
            this.bet = bet;
        }
        
    }

    public void insertBeginning(Gambler bet){
        Nodo nodo = new Nodo(bet);
        nodo.next = head;
        head = nodo;
        longitude ++;
    }
}
