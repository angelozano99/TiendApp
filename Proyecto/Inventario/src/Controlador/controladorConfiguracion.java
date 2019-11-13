/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ProcesarBD;
import Vista.vistaConfiguracion;
import Vista.vistaContabilidad;
import Vista.vistaInicio2;
import Vista.vistaInventario;
import Vista.vistaPedidos;
import Vista.vistaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

/**
 *
 * 
 * @author Labing
 */
public class controladorConfiguracion implements ActionListener{

    private vistaConfiguracion vistaConfiguracion;
    
    private vistaProducto vistaProducto;
    private vistaContabilidad vistaContabilidad;
    private vistaInventario vistaInventario;
    private vistaPedidos vistaPedidos;
    private vistaInicio2  vistaInicio;
    
    
    public controladorConfiguracion(vistaConfiguracion vistaConfiguracion){
        
        this.vistaConfiguracion = new vistaConfiguracion();
        this.vistaProducto = new vistaProducto();
        this.vistaContabilidad = new vistaContabilidad();
        this.vistaInventario = new vistaInventario();
        this.vistaPedidos  = new vistaPedidos();
        this.vistaInicio = new vistaInicio2();
        
        
        
        this.vistaConfiguracion.BotonProductos.addActionListener(this);
        this.vistaConfiguracion.BotonContabilidad.addActionListener(this);
        this.vistaConfiguracion.BotonInventario.addActionListener(this);
        this.vistaConfiguracion.BotonPedidos.addActionListener(this);
        this.vistaConfiguracion.BotonConfiguracion4.addActionListener(this);
        
        this.vistaConfiguracion.BotonCrear.addActionListener(this);
        this.vistaConfiguracion.BotonModificar.addActionListener(this);
        this.vistaConfiguracion.BotonEliminar.addActionListener(this);
        
        this.vistaConfiguracion.TextNombre.addActionListener(this);
        this.vistaConfiguracion.TextContraseña.addActionListener(this);
        
        this.vistaConfiguracion.butonSalir.addActionListener(this);
        
        //this.vistaConfiguracion.ComboBox.addActionListener(this);
        
        this.vistaConfiguracion.setVisible(true);
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ProcesarBD procesarBD = new ProcesarBD();
        
        
        if(e.getSource()==this.vistaConfiguracion.BotonCrear){
            
            String nombre = this.vistaConfiguracion.TextNombre.getText();
            String contrasena = this.vistaConfiguracion.TextContraseña.getText();
            
            String insertar;
            String buscar;
            String modificar;
            String eliminar;
            
           if(this.vistaConfiguracion.Administrador.isSelected()) {
               insertar = "y";
               buscar = "y";
               modificar = "y";
               eliminar = "y";
               
               System.out.println("Hola");
           }else{
                insertar = "y";
               buscar = "y";
               modificar = "n";
               eliminar = "n";
               System.out.println("Hola2");
               
           }
           
            try {
                procesarBD.ingresarUsuario(nombre, contrasena, insertar, buscar, modificar, eliminar);
            } catch (SQLException ex) {
                Logger.getLogger(controladorConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(e.getSource()==this.vistaConfiguracion.BotonModificar){
            String nombre = this.vistaConfiguracion.TextNombre.getText();
            String contrasena = this.vistaConfiguracion.TextContraseña.getText();
            
            String datos[] = procesarBD.leerUsuario(nombre);
            
            
            
           
            if (datos[5]!=(null)){
                procesarBD.updateUsuario(nombre, contrasena, datos[2], datos[3], datos[4], datos[5]);
            }else{
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
            
        }
        if(e.getSource()==this.vistaConfiguracion.BotonEliminar){
            String nombre = this.vistaConfiguracion.TextNombre.getText();
            
            try {
                procesarBD.eliminarUsuario(nombre);
            } catch (SQLException ex) {
                Logger.getLogger(controladorConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        if(e.getSource()==this.vistaConfiguracion.BotonInventario){
            this.vistaConfiguracion.dispose();
            controladorInventario controladorInventario = new controladorInventario(vistaInventario);
            
        }
        
        if(e.getSource()==this.vistaConfiguracion.BotonProductos){
            this.vistaConfiguracion.dispose();
            controladorProductos controladorProductos = new controladorProductos(vistaProducto);
            
        }
        
        if(e.getSource()==this.vistaConfiguracion.BotonPedidos){
            this.vistaConfiguracion.dispose();
            controladorPedidos controladorPedidos = new controladorPedidos(vistaPedidos);
            
        }
        
        if(e.getSource()==this.vistaConfiguracion.BotonContabilidad){
            this.vistaConfiguracion.dispose();
            controladorContabilidad controladorContabilidad = new controladorContabilidad(vistaContabilidad);
            
        }
        if(e.getSource()==this.vistaConfiguracion.butonSalir){
            this.vistaConfiguracion.dispose();
            controladorInicio controladorInicio = new controladorInicio(vistaInicio);
            
        }
            
            //Camilo
        
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    
}
