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
    private vistaInicio2 vistaInicio;
    private ProcesarBD procesarBD = new ProcesarBD();
    private String globalNombre;
    
    public controladorContabilidad(vistaContabilidad vistaContabilidad, String nombre){
        
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
        
        this.vistaContabilidad.ButtonSalir.addActionListener(this);
        
        
        this.vistaContabilidad.setVisible(true);
        
        this.globalNombre=nombre;
        evaluarUsuario();
        
    }
    
    
    public void evaluarUsuario(){
        
        boolean a = procesarBD.tipoUsuario(globalNombre);
        if (a) {
            this.vistaContabilidad.BotonConfiguracion.setEnabled(true);
         }else{
            this.vistaContabilidad.BotonConfiguracion.setEnabled(false);
        }
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==this.vistaContabilidad.BotonInventario){
            this.vistaContabilidad.dispose();
            controladorInventario controladorInventario = new controladorInventario(vistaInventario, globalNombre);
             
        }
        
        if(e.getSource()==this.vistaContabilidad.BotonConfiguracion){
            this.vistaContabilidad.dispose();
            controladorConfiguracion controladorConfiguracion = new controladorConfiguracion(vistaConfiguracion, globalNombre); 
        }
        
        if(e.getSource()==this.vistaContabilidad.BotonProductos){
            this.vistaContabilidad.dispose();
            controladorProductos controladorProductos = new controladorProductos(vistaProducto, globalNombre);
        }
        
        if(e.getSource()==this.vistaContabilidad.BotonPedidos){
            this.vistaContabilidad.dispose();
            controladorPedidos controladorPedidos = new controladorPedidos(vistaPedidos, globalNombre);
        }
        if(e.getSource()==this.vistaContabilidad.ButtonSalir){
            this.vistaContabilidad.dispose();
            controladorInicio controladorInicio = new controladorInicio(vistaInicio);
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
