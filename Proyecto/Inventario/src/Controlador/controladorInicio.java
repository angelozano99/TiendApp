/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProcesarBD;
import Vista.vistaConfiguracion;
import Vista.vistaInicio2;
import Vista.vistaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo Vargas
 */
public class controladorInicio implements ActionListener {

    private vistaInicio2 vistainicio2;
    private vistaConfiguracion vistaConfiguracion;
    private vistaProducto vistaProducto;
    
    private ProcesarBD ProcesarDB;
    

    public controladorInicio(vistaInicio2 vistainicio) {

        this.vistainicio2 = new vistaInicio2();
        this.vistaConfiguracion = new vistaConfiguracion();
        this.vistaProducto = new vistaProducto();
        
        this.ProcesarDB = new ProcesarBD();

        this.vistainicio2.BotonIngresar.addActionListener(this);
        this.vistainicio2.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vistainicio2.BotonIngresar) {
            String nombre=this.vistainicio2.textNombre.getText();
            String contrasena=this.vistainicio2.textContra.getText();
            if (nombre.equals("root") && 
                    contrasena.equals("root")) {
                
             this.vistainicio2.dispose();
             controladorConfiguracion controladorConfiguracion = new controladorConfiguracion(vistaConfiguracion);   
            }else{
                
                ArrayList array = new ArrayList();
                array = ProcesarDB.buscar(nombre,"SELECT * FROM Usuarios Where nombre=?");
                if(array.isEmpty()){
                    JOptionPane.showMessageDialog(null, "El usuario no Existe");
            }else{
                if(array.get(1).equals(contrasena)){
                   
                    controladorProductos vistaProductos = new controladorProductos(vistaProducto);
                    this.vistainicio2.dispose();
                }else{
                     JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
                }
                }
            
            
            
            }
        }

      
    }
}
