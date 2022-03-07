package com.carrera.controller;

import java.util.Arrays;
import com.carrera.archive.ExportCsv;
import com.carrera.model.Gambler;


/**
 * Clase encargada de manejar las operaciones
 */
public class Operaciones {
    //Aqui quiero que me muestre el array
    ListBets listOfBets;
    ListBetsRejected rejected;
    ListBetsAcepted acepted;
    

    public ListBetsAcepted getAcepted() {
        return acepted;
    }

    public void setAcepted(ListBetsAcepted acepted) {
        this.acepted = acepted;
    }

    /**
     * Constructor de la clase operaciones
     */
    public Operaciones(){
        listOfBets = new ListBets();
        rejected = new ListBetsRejected(); 
        acepted = new ListBetsAcepted();
    }

    /**
     * Metodo encargado de registrar una apuesta
     * @param name  Nombre del apostador
     * @param bets  lista de apuestas
     * @param amount    monto a apostar
     */
    public void registraDatos(String name, int [] bets, int amount){

        listOfBets.insertBeginning(new Gambler(name, bets, amount));
        
        
    }



    /**
     * Metodo encargado de verificar las apuestas
     */
    public void verifyBets(){
        long TInicio, TFin, tiempo; 
        TInicio = System.currentTimeMillis();
        Gambler[] datos2 = listOfBets.getBets();

        for(int i=0; i<datos2.length; i++){
            boolean [] repetidos = {false, false, false, false, false, false, false, false, false, false};
            int cambios =0;
            System.out.println("\n\nverificando a: "+ datos2[i].getName());
            for(int j=0 ; j<datos2[i].getBets().length; j++){
                //System.out.println("revisando el array"+ Arrays.toString(datos2[i].getBets()));
                try {
                    int n = datos2[i].getBets()[j];
                    //System.out.println("verificando el numero del array "+datos2[i].getBets()[j] );
                    //System.out.println(Arrays.toString(repetidos));
                    String msg = "Error, el numero ya existia";
                    if(n>0 && n<=10){
                        System.out.println("entre aqui, vericando el numero: "+ n);
                        switch (n){
                            case 1: if(!repetidos[0]){repetidos[0] = true; cambios++;}else{System.out.println(msg);}break;
                            case 2:if(!repetidos[1]){repetidos[1] = true;cambios++;}else{System.out.println(msg);}break;
                            case 3:if(!repetidos[2]){repetidos[2] = true;cambios++;}else{System.out.println(msg);}break;
                            case 4:if(!repetidos[3]){repetidos[3] = true;cambios++;}else{System.out.println(msg);}break;
                            case 5:if(!repetidos[4]){repetidos[4] = true;cambios++;}else{System.out.println(msg);}break;
                            case 6:if(!repetidos[5]){repetidos[5] = true;cambios++;}else{System.out.println(msg);}break;
                            case 7:if(!repetidos[6]){repetidos[6] = true;cambios++;}else{System.out.println(msg);}break;
                            case 8:if(!repetidos[7]){repetidos[7] = true;cambios++;}else{System.out.println(msg);}break;
                            case 9:if(!repetidos[8]){repetidos[8] = true;cambios++;}else{System.out.println(msg);}break;
                            case 10:if(!repetidos[9]){repetidos[9] = true;cambios++;}else{System.out.println(msg);}break;
                        }

                    }else{System.out.println("El numero esta fuera de rango, por lo tanto no se guardara");}

                } catch (Exception e) {
                    //TODO: handle exception
                    System.out.println("\n\nerror en apostador: "+ datos2[i].getName()+" con dato en pos: "+ j+"\n\n");
                }
                

            }
            if(cambios ==10){
                //Guardamos la apuesta osea no hacemos nada :D o si?
                System.out.println("Gambler: "+ datos2[i].getName()+" debe guardarse\n\n");
                acepted.insertBeginning(datos2[i]);
            }else{
                //borramos la apuesta
                System.out.println("\n\nnombre a eliminar: "+ datos2[i].getName()+"\n\n");
                //listOfBets.deleteBet(i);
                rejected.insertBeginning(datos2[i]);
            }

        }
        TFin = System.currentTimeMillis();
        tiempo= TFin-TInicio;
        System.out.println("Tiempo que se tardo verificando: " + tiempo);
            
    }




    /**
     * Metodo encargado de imprimir los datos
     */
    public void imprimeDatos(){
        Gambler [] datos = listOfBets.getBets();
        if(datos!=null){
            for(int i=0; i< datos.length; i++){
                System.out.println(i+ ". Nombre: " +  datos[i].getName() + " Winner: "+datos[i].getBets()[0] + "->"+Arrays.toString(datos[i].getBets()));
            }  
        }
    }

    /**
     * Metodo encargado de imprimir las apuestas aceptadas
     */
    public void imprimeAcepted(){
        Gambler [] datos = acepted.getBets();
        System.out.println("Aceptadas");
        if(datos!=null){
            for(int i=0; i< datos.length; i++){
                System.out.println(i+ ". Nombre: " +  datos[i].getName() + " Winner: "+datos[i].getBets()[0] + "->"+Arrays.toString(datos[i].getBets()));
            }  
        }
    }

    /**
     * Metodo encargado de imprimir las apuestas rechazadas
     */
    public void imprimeRejected(){
        Gambler [] datos = rejected.getBets();
        System.out.println("Rechazadas");
        if(datos!=null){
            for(int i=0; i< datos.length; i++){
                System.out.println(i+ ". Nombre: " +  datos[i].getName() + " Winner: "+datos[i].getBets()[0] + "->"+Arrays.toString(datos[i].getBets()));
            }  
        }
        new ExportCsv().saveArchive(datos);
    }


    /**
     * Retorna la longitud
     * @return longitud
     */
    public int getLongitude() {
        return listOfBets.getLongitude();
    }




    /**
     * Metodo encargado de ordenar por insercion
     * @param vector contiene el array con los elementos
     */
    public Gambler[] Insercion () {
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        Gambler [] datos = acepted.getBets();
        for (int i=1; i < datos.length; i++) {
           int aux = datos[i].getPoints(); //datos[i]
           Gambler aux2 = datos[i];
           int j;
           for (j=i-1; j >=0 && datos[j].getPoints() > aux; j--){
                //vector[j+1] = vector[j];
                datos[j+1] = datos[j];
            }
           //vector[j+1] = aux;
           datos[j+1] = aux2;
        }
        TFin = System.currentTimeMillis();
        tiempo= TFin-TInicio;
        System.out.println("Tiempo que se tardo ordenando: " + tiempo);
        return datos;
     }

     public String imprimeOrdenados(){
        String result = "";
        Gambler [] datos = Insercion();
        for(int i=0; i< datos.length; i++){
            System.out.println(i+ " -> "+ datos[i].getPoints());
            result = result + datos[i].getName() + " puntos" + datos[i].getPoints() + "\n";
         }
         return result;
     }
    





    

    

}
