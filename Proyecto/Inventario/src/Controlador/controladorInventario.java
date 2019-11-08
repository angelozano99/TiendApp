/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vistaConfiguracion;
import Vista.vistaContabilidad;
import Vista.vistaInventario;
import Vista.vistaPedidos;
import Vista.vistaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Camilo Vargas
 */
public class controladorInventario implements ActionListener{
    
    private vistaInventario vistaInventario;
    private vistaConfiguracion vistaConfiguracion;
    
    private vistaProducto vistaProducto;
    private vistaContabilidad vistaContabilidad;
    private vistaPedidos vistaPedidos;
    
    
    public controladorInventario(vistaInventario vistaInventario){
        
        this.vistaInventario = new vistaInventario();
        
        this.vistaInventario.BotonProductos.addActionListener(this);
        this.vistaInventario.BotonContabilidad.addActionListener(this);
        this.vistaInventario.BotonInventario.addActionListener(this);
        this.vistaInventario.BotonPedidos.addActionListener(this);
        this.vistaInventario.BotonConfiguracion.addActionListener(this);
        
        this.vistaInventario.BotonBuscar.addActionListener(this);
        this.vistaInventario.BotonCrear.addActionListener(this);
        this.vistaInventario.BotonModificar.addActionListener(this);
        this.vistaInventario.BotonEliminar.addActionListener(this);
        
        
        this.vistaInventario.setVisible(true);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
