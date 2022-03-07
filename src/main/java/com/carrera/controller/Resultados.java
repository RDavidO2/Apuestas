package com.carrera.controller;

import com.carrera.model.Gambler;


/**
 * Clase encargada de generar los resultados
 */
public class Resultados {
    ListBetsAcepted acepted;
    int[] orderH;

    /**
     * Constructor de la clase resultados
     * @param order orden de los resultados
     * @param listBetsAcepted listado de aceptdos
     */
    public Resultados(int[] order, ListBetsAcepted listBetsAcepted) {
        this.acepted = listBetsAcepted;
        this.orderH = order;
    }

    /**
     * Metodo encargado de verificar los resultados y hacer la suma de puntos
     */
    public void verifica() {
        long TInicio, TFin, tiempo; 
        TInicio = System.currentTimeMillis();
        Gambler[] datos = acepted.getBets();
        for(int i =0; i<datos.length; i++) {
            int puntos = 0;
            for(int j =0; j<orderH.length ; j++) {
                switch (j+1){
                    case 1:if(orderH[j]==datos[i].getBets()[j]) {
                        puntos = puntos + 10;
                    } break;
                    case 2:if(orderH[j]==datos[i].getBets()[j]) {
                        puntos = puntos + 9;
                    } break;
                    case 3:if(orderH[j]==datos[i].getBets()[j]) {
                        puntos = puntos + 8;
                    } break;

                    case 4:if(orderH[j]==datos[i].getBets()[j]) {
                        puntos = puntos + 7;
                    } break;
                    case 5:if(orderH[j]==datos[i].getBets()[j]) {
                        puntos = puntos + 6;
                    } break;
                    case 6:if(orderH[j]==datos[i].getBets()[j]) {
                        puntos = puntos + 5;
                    } break;
                    case 7:if(orderH[j]==datos[i].getBets()[j]) {
                        puntos = puntos + 4;
                    } break;
                    case 8:if(orderH[j]==datos[i].getBets()[j]) {
                        puntos = puntos + 3;
                    } break;
                    case 9:if(orderH[j]==datos[i].getBets()[j]) {
                        puntos = puntos + 2;
                    } break;
                    case 10:if(orderH[j]==datos[i].getBets()[j]) {
                        puntos = puntos + 1;
                    } break;
                }

               
            }

            datos[i].setPoints(puntos);

        }

        TFin = System.currentTimeMillis();
        tiempo= TFin-TInicio;
        System.out.println("Tiempo que se tardo verificando: " + tiempo);
    }

    
  







}
