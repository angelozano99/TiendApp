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
public class controladorPedidos implements ActionListener{

    private vistaPedidos vistaPedidos;
    private vistaConfiguracion vistaConfiguracion;
    
    private vistaProducto vistaProducto;
    private vistaContabilidad vistaContabilidad;
    private vistaInventario vistaInventario;
    
    
    public controladorPedidos(vistaPedidos vistaPedidos){
        
        this.vistaPedidos = new vistaPedidos();
        
        this.vistaPedidos.BotonProductos4.addActionListener(this);
        this.vistaPedidos.BotonContabilidad4.addActionListener(this);
        this.vistaPedidos.BotonInventario4.addActionListener(this);
        this.vistaPedidos.BotonPedidos4.addActionListener(this);
        this.vistaPedidos.BotonConfiguracion4.addActionListener(this);
        
        this.vistaPedidos.BotonAnadir.addActionListener(this);
        this.vistaPedidos.BotonRecordatorios.addActionListener(this);
        
        this.vistaPedidos.setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==this.vistaPedidos.BotonProductos4){
            this.vistaPedidos.dispose();
            controladorProductos controladorProductos = new controladorProductos(vistaProducto);
        }
        
        if(e.getSource()==this.vistaPedidos.BotonInventario4){
            this.vistaPedidos.dispose();
            controladorInventario controladorInventario = new controladorInventario(vistaInventario);
            
        }
        
        if(e.getSource()==this.vistaPedidos.BotonContabilidad4){
            this.vistaPedidos.dispose();
            controladorContabilidad controladorContabilidad = new controladorContabilidad(vistaContabilidad);
        }
        
        if(e.getSource()==this.vistaPedidos.BotonConfiguracion4){
            this.vistaPedidos.dispose();
            controladorConfiguracion controladorConfiguracion = new controladorConfiguracion(vistaConfiguracion); 
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
