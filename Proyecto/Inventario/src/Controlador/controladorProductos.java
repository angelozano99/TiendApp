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
 * @author angel
 */
public class controladorProductos implements ActionListener{
    
    private vistaProducto vistaProducto;
    
    private vistaConfiguracion vistaConfiguracion;
    
    private vistaContabilidad vistaContabilidad;
    private vistaInventario vistaInventario;
    private vistaPedidos vistaPedidos;
    
    
    
    public controladorProductos (vistaProducto vistaProducto){
        
        this.vistaProducto = new vistaProducto();
        
        this.vistaProducto.BotonProductos4.addActionListener(this);
        this.vistaProducto.BotonContabilidad4.addActionListener(this);
        this.vistaProducto.BotonInventario4.addActionListener(this);
        this.vistaProducto.BotonPedidos4.addActionListener(this);
        this.vistaProducto.BotonConfiguracion4.addActionListener(this);
        
        this.vistaProducto.BotonAnadir.addActionListener(this);
        this.vistaProducto.BotonDevolucion.addActionListener(this);
        this.vistaProducto.BotonFoto.addActionListener(this);

        
        
        
        this.vistaProducto.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if(e.getSource()==this.vistaProducto.BotonProductos4){
            this.vistaProducto.dispose();
            controladorProductos controladorProductos = new controladorProductos(vistaProducto);
        }
        
        if(e.getSource()==this.vistaProducto.BotonPedidos4){
            this.vistaProducto.dispose();
            controladorPedidos controladorPedidos = new controladorPedidos(vistaPedidos);
        }
        
        if(e.getSource()==this.vistaProducto.BotonContabilidad4){
            this.vistaProducto.dispose();
            controladorContabilidad controladorContabilidad = new controladorContabilidad(vistaContabilidad);
        }
        
        if(e.getSource()==this.vistaProducto.BotonConfiguracion4){
            this.vistaProducto.dispose();
            controladorConfiguracion controladorConfiguracion = new controladorConfiguracion(vistaConfiguracion); 
        }   
        
        if(e.getSource()==this.vistaProducto.BotonInventario4){
            this.vistaProducto.dispose();
            controladorInventario controladorInventario = new controladorInventario(vistaInventario);
            
        }
            
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

