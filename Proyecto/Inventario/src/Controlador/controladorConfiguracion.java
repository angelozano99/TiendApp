/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vistaConfiguracion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Labing
 */
public class controladorConfiguracion implements ActionListener{

    private vistaConfiguracion vistaConfiguracion;
    
    public ControladorConfiguracion(vistaConfiguracion vistaConfiguracion){
        
        this.vistaConfiguracion = new vistaConfiguracion();
        
        this.vistaConfiguracion.BotonProductos.addActionListener(this);
        this.vistaConfiguracion.BotonContabilidad4.addActionListener(this);
        this.vistaConfiguracion.BotonInventario4.addActionListener(this);
        this.vistaConfiguracion.BotonPedidos4.addActionListener(this);
        this.vistaConfiguracion.BotonConfiguracion4.addActionListener(this);
        
        
        
        
    }
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
