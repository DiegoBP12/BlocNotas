/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    ActionListener ac = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewbloc.jm_leer)
                    leer();
            else if(e.getSource() == viewbloc.jm_guardar)
                    guardar();
        }
    };
    public ControllerBlocnotas(ViewBlocnotas viewbloc, ModelBlocnotas modelbloc) {
        this.viewbloc = viewbloc;
        this.modelbloc = modelbloc;
        this.viewbloc.jm_guardar.addActionListener(ac);
        this.viewbloc.jm_leer.addActionListener(ac);
        initComponents();
    }
    public void leer(){
        modelbloc.readFile();
        viewbloc.jta_texto.setText(modelbloc.getMensaje());
    }
    public void guardar(){
        modelbloc.setMensaje(viewbloc.jta_texto.getText());
        modelbloc.writeFile();
    }
    private void initComponents(){
        viewbloc.setVisible(true);
    }
}
