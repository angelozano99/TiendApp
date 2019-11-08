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
 * 
 * @author Labing
 */
public class controladorConfiguracion implements ActionListener{

    private vistaConfiguracion vistaConfiguracion;
    
    private vistaProducto vistaProducto;
    private vistaContabilidad vistaContabilidad;
    private vistaInventario vistaInventario;
    private vistaPedidos vistaPedidos;
    
    
    public controladorConfiguracion(vistaConfiguracion vistaConfiguracion){
        
        this.vistaConfiguracion = new vistaConfiguracion();
        
        this.vistaProducto = new vistaProducto();
        this.vistaContabilidad = new vistaContabilidad();
        this.vistaInventario = new vistaInventario();
        this.vistaPedidos  = new vistaPedidos();
        
        
        
        this.vistaConfiguracion.BotonProductos.addActionListener(this);
        this.vistaConfiguracion.BotonContabilidad4.addActionListener(this);
        this.vistaConfiguracion.BotonInventario4.addActionListener(this);
        this.vistaConfiguracion.BotonPedidos4.addActionListener(this);
        this.vistaConfiguracion.BotonConfiguracion4.addActionListener(this);
        
        this.vistaConfiguracion.BotonCrear.addActionListener(this);
        this.vistaConfiguracion.BotonModificar.addActionListener(this);
        this.vistaConfiguracion.BotonEliminar.addActionListener(this);
        
        this.vistaConfiguracion.TextNombre.addActionListener(this);
        this.vistaConfiguracion.TextContraseña.addActionListener(this);
        
        this.vistaConfiguracion.ComboBox.addActionListener(this);
        
        this.vistaConfiguracion.setVisible(true);
       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.vistaConfiguracion.BotonInventario4){
            this.vistaConfiguracion.dispose();
            controladorInventario controladorInventario = new controladorInventario(vistaInventario);
            
        }
        
        if(e.getSource()==this.vistaConfiguracion.BotonProductos){
            this.vistaConfiguracion.dispose();
            controladorProductos controladorProductos = new controladorProductos(vistaProducto);
            
        }
        
        if(e.getSource()==this.vistaConfiguracion.BotonPedidos4){
            this.vistaConfiguracion.dispose();
            controladorPedidos controladorPedidos = new controladorPedidos(vistaPedidos);
            
        }
        
        if(e.getSource()==this.vistaConfiguracion.BotonContabilidad4){
            this.vistaConfiguracion.dispose();
            controladorContabilidad controladorContabilidad = new controladorContabilidad(vistaContabilidad);
            
        }
            
            
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
