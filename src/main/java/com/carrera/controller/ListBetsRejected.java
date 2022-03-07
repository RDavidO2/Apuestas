package com.carrera.controller;
import com.carrera.model.Gambler;

/**
 * Clase encargada del listado de las apuestas realizadas
 */
public class ListBetsRejected {
    
    private Nodo head = null;
    private int longitude = 0;

    private class Nodo{
        public Gambler bet;
        public Nodo next = null;

        /**
         * Constructor de la clase ListBets
         * @param bet Objeto de tipo apostador
         */
        public Nodo(Gambler bet) {
            this.bet = bet;
        }        
        
    }

    /**
     * Metodo encargado de insertar una apuesta al inicio
     * @param bet Objeto de tipo apostador
     */
    public void insertBeginning(Gambler bet){
        Nodo nodo = new Nodo(bet);
        System.out.println("Nodo creado, Nombre: "+ nodo.bet.getName());

        nodo.next = head;
        head = nodo;
        longitude ++;
    }

    /**
     * Metodo encargado de retornar el array con las apuestas realizadas
     * @return retornar el array con las apuestas realizadas
     */
    public Gambler[] getBets(){
        System.out.println("Longitud"+ longitude);
        Gambler[] bets = new Gambler[longitude];
        if(head == null){
            System.out.println("lista vacia");
            return null;
        }else{
            Nodo puntero = head;
            int contador = 0;
            while(puntero != null ){
                bets[contador] = puntero.bet;
                puntero = puntero.next;
                contador++;
            }
            

            
        }

        return bets;
    }
    
    /**
     * Metodo encargado de eliminar una apuesta realizada
     * @param n posicion de la apuesta realizada dentro del listado
     */
    public void deleteBet(int n){
        if(head != null){
            if(n ==0){
                Nodo puntero = head;
                head = head.next;
                puntero.next = null;
                longitude --;

            }else if(n<longitude){
                Nodo puntero = head;
                int contador = 0;
                while(contador < (n-1) ){
                    puntero = puntero.next;
                    contador ++;
                }
    
                Nodo tmp = puntero.next;
                puntero.next = tmp.next;
                tmp.next = null;
                longitude --;
            }
        }
    }
}
