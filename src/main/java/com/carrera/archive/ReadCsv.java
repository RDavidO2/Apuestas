package com.carrera.archive;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.carrera.controller.Operaciones;

/**
 * Clase encargada de leer el archivo de entrada
 */
public class ReadCsv {
    String path;
    Operaciones op;

    /**
     * Constructor de la clase ReadCsv 
     * @param path String con la ruta absoluta del archivo
     * @param op Operacion
     */
    public ReadCsv(String path, Operaciones op){
        this.path = path;
        this.op = op;
        readFile();    
    }

    /**
     * Metodo encargado de leer el archivo de entrada y crear o llenar el array de apuestas
     */
    public  void readFile() {

        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int cont = 0;
            while ((line = br.readLine()) != null)
            //returns a Boolean value  
            {   
                boolean save = true;
                String[] bet = line.split(splitBy);
                int[] orderHorses = new int[10];
                try {
                    //use comma as separator 
                    orderHorses[0] = Integer.parseInt(bet[2].replaceAll("<", "").replaceAll(">", ""));
                    orderHorses[1] = Integer.parseInt(bet[3].replaceAll("<", "").replaceAll(">", ""));
                    orderHorses[2] = Integer.parseInt(bet[4].replaceAll("<", "").replaceAll(">", ""));
                    orderHorses[3] = Integer.parseInt(bet[5].replaceAll("<", "").replaceAll(">", ""));
                    orderHorses[4] = Integer.parseInt(bet[6].replaceAll("<", "").replaceAll(">", ""));
                    orderHorses[5] = Integer.parseInt(bet[7].replaceAll("<", "").replaceAll(">", ""));
                    orderHorses[6] = Integer.parseInt(bet[8].replaceAll("<", "").replaceAll(">", ""));
                    orderHorses[7] = Integer.parseInt(bet[9].replaceAll("<", "").replaceAll(">", ""));
                    orderHorses[8] = Integer.parseInt(bet[10].replaceAll("<", "").replaceAll(">", ""));
                    orderHorses[9] = Integer.parseInt(bet[11].replaceAll("<", "").replaceAll(">", ""));
                    
                    //System.out.println(" Name=" + bet[0].replaceAll("<", "").replaceAll(">", "")  + ", Amount=" + bet[1] + ", Winner=" + bet[2] + ", second= " + bet[3]);
                } catch (Exception e) {
                    //JOptionPane.showMessageDialog(null, "Error, datos con formato incorrecto ");
                    System.out.println("encontre un error en la linea: "+cont);
                    save = false;
                }
                if(save) {
                    op.registraDatos(bet[0].replaceAll("<", "").replaceAll(">", ""), orderHorses, Integer.parseInt(bet[1].replaceAll("<", "").replaceAll(">", "")));

                }
                cont ++;
                
            }
            JOptionPane.showMessageDialog(null, "Apuestas agregadas correctamente");
        }
        catch(IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error, verifique el archivo de entrada");

        }

  }
}