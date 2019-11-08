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
public class controladorContabilidad implements ActionListener{
    private vistaContabilidad vistaContabilidad;
    
    private vistaConfiguracion vistaConfiguracion;
    private vistaProducto vistaProducto;
    private vistaInventario vistaInventario;
    private vistaPedidos vistaPedidos;
    
    public controladorContabilidad(vistaContabilidad vistaContabilidad){
        
        this.vistaContabilidad = new vistaContabilidad();
        
        this.vistaContabilidad.BotonProductos.addActionListener(this);
        this.vistaContabilidad.BotonContabilidad.addActionListener(this);
        this.vistaContabilidad.BotonInventario.addActionListener(this);
        this.vistaContabilidad.BotonPedidos.addActionListener(this);
        this.vistaContabilidad.BotonConfiguracion.addActionListener(this);
        
        this.vistaContabilidad.BotonBuscar.addActionListener(this);
        this.vistaContabilidad.BotonDiaria.addActionListener(this);
        this.vistaContabilidad.BotonSemanal.addActionListener(this);
        this.vistaContabilidad.BotonMensual.addActionListener(this);
        this.vistaContabilidad.ComboBox.addActionListener(this);
        this.vistaContabilidad.BotonAnual.addActionListener(this);
        
        this.vistaContabilidad.setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.vistaContabilidad.BotonInventario){
            this.vistaContabilidad.dispose();
            controladorInventario controladorInventario = new controladorInventario(vistaInventario);
             
        }
        
        if(e.getSource()==this.vistaContabilidad.BotonConfiguracion){
            this.vistaContabilidad.dispose();
            controladorConfiguracion controladorConfiguracion = new controladorConfiguracion(vistaConfiguracion); 
        }
        
        if(e.getSource()==this.vistaContabilidad.BotonProductos){
            this.vistaContabilidad.dispose();
            controladorProductos controladorProductos = new controladorProductos(vistaProducto);
        }
        
        if(e.getSource()==this.vistaContabilidad.BotonPedidos){
            this.vistaContabilidad.dispose();
            controladorPedidos controladorPedidos = new controladorPedidos(vistaPedidos);
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
