/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vistaConfiguracion;
import Vista.vistaInventario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * 
 * @author Labing
 */
public class controladorConfiguracion implements ActionListener{

    private vistaConfiguracion vistaConfiguracion;
    
    private vistaInventario vistaInventario;
    
    public controladorConfiguracion(vistaConfiguracion vistaConfiguracion){
        
        this.vistaConfiguracion = new vistaConfiguracion();
        this.vistaInventario = new vistaInventario();
        
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
            
            
            
        }
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
