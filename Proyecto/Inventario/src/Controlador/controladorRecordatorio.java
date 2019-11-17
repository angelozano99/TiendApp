/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.ArrayList;
import Modelo.ProcesarBD;
import Vista.vistaRecordatorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Camilo Vargas
 */
public class controladorRecordatorio implements ActionListener {

    private vistaRecordatorio vistaRecordatorio;
    private ProcesarBD procesarBD = new ProcesarBD();
    private String[] datos;

    public controladorRecordatorio(vistaRecordatorio vistaRecordatorio) {

        this.vistaRecordatorio = new vistaRecordatorio();

        this.vistaRecordatorio.fechatext.addActionListener(this);
        this.vistaRecordatorio.BotonFiltrar.addActionListener(this);

        this.vistaRecordatorio.setVisible(true);

        llenarTabla();

    }

    public void llenarTabla() {
        DefaultTableModel tabla = (DefaultTableModel) vistaRecordatorio.tablaRecordatorio.getModel();
        vistaRecordatorio.tablaRecordatorio.setModel(procesarBD.listarpedido(tabla));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vistaRecordatorio.BotonFiltrar) {
            //llenarTabla();
            ArrayList<Integer> numeros = new ArrayList<Integer>();
            String fecha = this.vistaRecordatorio.fechatext.getText();
            DefaultTableModel tabla2 = (DefaultTableModel) this.vistaRecordatorio.tablaRecordatorio.getModel();
            //DefaultTableModel tabla3 = (DefaultTableModel) this.vistaRecordatorio.tablaRecordatorio.getModel();

            int p = tabla2.getRowCount();

            for (int i3 = 0; i3 < p; i3++) {
                String fecha_entrega = String.valueOf(tabla2.getValueAt(i3, 2));

                if (!fecha.equals(fecha_entrega)) {
                    numeros.add(i3);
                    //System.out.println(i3);
                }
            }
            
            
            int po=numeros.size()-1;
            while(po<0){
                
            }
            
              
            //System.out.println("Sale");
            //tabla2.removeRow(1);
            this.vistaRecordatorio.tablaRecordatorio.setModel(tabla2);

            /* int i =0;
             do{
                String fecha_entrega=String.valueOf(tabla2.getValueAt(i, 2));
                
                if(!fecha.equals(fecha_entrega)){
                  numeros.add(i);   
                }
               
                i++;
            }while(tabla2.getValueAt(i, 0) != null);
             */
            //this.vistaRecordatorio.tablaRecordatorio.setModel(tabla2);
        }
    }

}