/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Componentes.Increment;
import Modelo.ProcesarBD;
import Vista.vistaConfiguracion;
import Vista.vistaContabilidad;
import Vista.vistaInicio2;
import Vista.vistaInventario;
import Vista.vistaPedidos;
import Vista.vistaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private vistaInicio2 vistaInicio;
    private ProcesarBD procesarBD = new ProcesarBD();
    private String globalNombre;
    
    
    public controladorPedidos(vistaPedidos vistaPedidos, String nombre){
        
        this.vistaPedidos = new vistaPedidos();
        
        this.vistaPedidos.BotonProductos4.addActionListener(this);
        this.vistaPedidos.BotonContabilidad4.addActionListener(this);
        this.vistaPedidos.BotonInventario4.addActionListener(this);
        this.vistaPedidos.BotonPedidos4.addActionListener(this);
        this.vistaPedidos.BotonConfiguracion4.addActionListener(this);
        
        this.vistaPedidos.BotonAnadir.addActionListener(this);
        this.vistaPedidos.BotonRecordatorios.addActionListener(this);
        this.vistaPedidos.ButonSalir.addActionListener(this);
        
        this.vistaPedidos.setVisible(true);
        
        this.globalNombre=nombre;
        evaluarUsuario();
        
    }
    
    public void evaluarUsuario(){
        
        boolean a = procesarBD.tipoUsuario(globalNombre);
        if (a) {
            this.vistaPedidos.BotonConfiguracion4.setEnabled(true);
         }else{
            this.vistaPedidos.BotonConfiguracion4.setEnabled(false);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ProcesarBD procesarBD = new ProcesarBD();
        if(e.getSource()==this.vistaPedidos.BotonProductos4){
            this.vistaPedidos.dispose();
            controladorProductos controladorProductos = new controladorProductos(vistaProducto, globalNombre);
        }
        
        if(e.getSource()==this.vistaPedidos.BotonInventario4){
            this.vistaPedidos.dispose();
            controladorInventario controladorInventario = new controladorInventario(vistaInventario, globalNombre);
            
        }
        
        if(e.getSource()==this.vistaPedidos.BotonContabilidad4){
            this.vistaPedidos.dispose();
            controladorContabilidad controladorContabilidad = new controladorContabilidad(vistaContabilidad, globalNombre);
        }
        
        if(e.getSource()==this.vistaPedidos.BotonConfiguracion4){
            this.vistaPedidos.dispose();
            controladorConfiguracion controladorConfiguracion = new controladorConfiguracion(vistaConfiguracion, globalNombre); 
        }
        if(e.getSource()==this.vistaPedidos.BotonAnadir){
            Increment incre=new Increment();
            int id;
            id=incre.id_increment();
            //System.out.println(id);
            String proveedor = this.vistaPedidos.Proveedortext.getText();
            String fecha = this.vistaPedidos.Fechatext.getText();
            String fecha_entrega = this.vistaPedidos.Fecha2text.getText();
            int valortotal = Integer.parseInt(this.vistaPedidos.Costotext.getText());
            int i=0;
            procesarBD.ingresarPedido(id,proveedor,fecha,fecha_entrega,valortotal);
            do{
                String nom_producto=String.valueOf(this.vistaPedidos.Tablaproduc.getValueAt(i, 0));
                int cantidad = Integer.valueOf(String.valueOf(this.vistaPedidos.Tablaproduc.getValueAt(i, 1)));
                
                try {
                    procesarBD.ingresarPedido_producto(id,nom_producto,cantidad);
                } catch (Exception ex) {
                    Logger.getLogger(controladorInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }while(this.vistaPedidos.Tablaproduc.getValueAt(i, 0) != null);
           
        }
        if(e.getSource()==this.vistaPedidos.ButonSalir){
            this.vistaPedidos.dispose();
            controladorInicio controladorInicio = new controladorInicio(vistaInicio);
            
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
