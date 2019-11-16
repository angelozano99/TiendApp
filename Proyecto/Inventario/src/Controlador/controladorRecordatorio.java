/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProcesarBD;
import Vista.vistaRecordatorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Camilo Vargas
 */
public class controladorRecordatorio implements ActionListener{
    private vistaRecordatorio vistaRecordatorio;
     private ProcesarBD procesarBD = new ProcesarBD();
     
    public controladorRecordatorio(vistaRecordatorio vistaRecordatorio){
        
        this.vistaRecordatorio = new vistaRecordatorio();
        
      
        this.vistaRecordatorio.fechatext.addActionListener(this);
        
    
        this.vistaRecordatorio.setVisible(true);
        
        
        
    }
 
    public void llenarTabla(){
        DefaultTableModel tabla = (DefaultTableModel) vistaRecordatorio.tablaRecordatorio.getModel();
        vistaRecordatorio.tablaRecordatorio.setModel(procesarBD.listarpedido(tabla));
    }
     @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}