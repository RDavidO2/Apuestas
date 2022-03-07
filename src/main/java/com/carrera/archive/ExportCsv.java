package com.carrera.archive;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.carrera.model.Gambler;

public class ExportCsv {

    public void saveArchive(Gambler[] datos) {
 
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("CSV .csv", "csv"));
        chooser.setApproveButtonText("Guardar");
        chooser.showSaveDialog(null);
        File archive = new File(chooser.getSelectedFile() + ".csv");
        if (!archive.exists()) {
            try {
                archive.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            //FileWriter fileWriter=new FileWriter(archive);
            BufferedWriter br = new BufferedWriter(new FileWriter(archive));
            br.write(getDatos(datos));
            br.close();
        } catch (Exception e) {
            //TODO: handle exception
        }



    }

    private String getDatos(Gambler[] datos) {
        String result = "";
        for (Gambler g : datos){
            result = result + g.getName() +","+ g.getAmount()+"," + Arrays.toString(g.getBets()) + " \n";
        }
        return result;


    }

}
