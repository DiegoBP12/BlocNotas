/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import views.ViewBlocnotas;
import models.ModelBlocnotas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Diego
 */
public class ControllerBlocnotas {
    ViewBlocnotas viewbloc;
    ModelBlocnotas modelbloc;
    MouseListener ml = new MouseListener () {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewbloc.jm_leer){
               modelbloc.setPath("C:\\archivos\\archivo.txt");
               readFile(modelbloc.getPath());
            }
            else if(e.getSource() == viewbloc.jm_guardar){
                modelbloc.setPath("C:\\archivos\\archivo.txt");
                writeFile(modelbloc.getPath(), modelbloc.getMensaje());
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    };
    /**
     *  Lee un archivo según la ruta especificada
     * @param path Es la ruta del archivo que se desea leer.
     * 
     */
    public void readFile(String path){
        try{
                String row; 
            try (FileReader file = new FileReader(path)){
                BufferedReader bufferedReader = new BufferedReader(file);
                while ((row = bufferedReader.readLine()) != null){
                    modelbloc.setMensaje(row);
                    viewbloc.jta_texto.setText(modelbloc.getMensaje());
                }
                bufferedReader.close();
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(viewbloc,"No se econtró el archivo" + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
        }
    }
    
    /**
     * Realiza la escritura o mdoficación a un archivo ya existente o en caso de no ser así crea el archivo.
     * @param path Es la ruta específica del archivo.
     * @param message Es el contenido del archivo que se crea o modifica.
     * 
     */
    public void writeFile(String path, String message){
        boolean bandera = false;
        if (viewbloc.jta_texto.getText().isEmpty()){
             try{
                bandera = true;
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file,bandera);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                    printWriter.println(modelbloc.getMensaje());
                    printWriter.close();
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
                }
            }
        else{
        try{
        bandera = false;
        File file = new File(path);
        FileWriter fileWriter = new FileWriter (file,bandera);
        try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                printWriter.println(modelbloc.getMensaje());
                printWriter.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(viewbloc,"Error en I/O operación" + ex.getMessage());
        }
    }
  }
}
