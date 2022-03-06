package com.carrera.controller;

import com.carrera.model.Gambler;

public class Operaciones {
    //Aqui quiero que me muestre el array
    int n = 0;
    Gambler [] listOfBets;
    public Operaciones(){
        listOfBets= new Gambler[n];
    }

    /**
     * Metodo encargado de registrar una apuesta
     * @param name
     * @param bets
     * @param amount
     */
    public void registraDatos(String name, int [] bets, int amount){
        Gambler [] tmp = new Gambler[listOfBets.length+1];
        //Aqui copio los datos del arrays de apuestas
        for(int i=0; i<tmp.length-2; i++){
            tmp[i]=listOfBets[i]; //Aqui se deberian de copiar los datos antiguos al nuevo array
        }
        listOfBets = tmp;

        listOfBets[listOfBets.length-1]=new Gambler(name, bets, amount);
        
    }



    int contador =0;
    public Gambler[] aumenta(int contador){
        if(contador<10){
            contador++;
            return aumenta(contador);
        }
        return contador;
    }







    /**
     * Metodo encargado de verificar las apuestas
     * @param listOfBets
     */
    public void verifyBets(Gambler[] listOfBets){
        int[] personas = {1,2,3,4,5,6,7,8,9,10};
        int [] datos = {1,2,3,4,5,6,7,8,9,10};
        for(int i=0; i<personas.length; i++){
            int cont = 0;
            if(cont<datos.length){
                if(datos[i]!=datos[datos.length + cont]){
                    
                }
            }

            if(datos[i]!=datos[i+1]){
                
            }
        }
            
    }





    public void imprimeDatos(){
        for(int i=0; i<listOfBets.length; i++){
            System.out.println("Nombre: " + listOfBets[i].getName());
            System.out.println("Caballo Win: " + listOfBets[i].getBets()[0]);
            System.out.println("Caballos: " + listOfBets[i].getName());

        }
    }





    public Gambler[] getListOfBets() {
        return listOfBets;
    }





    public void setListOfBets(Gambler[] listOfBets) {
        this.listOfBets = listOfBets;
    }

    

}
