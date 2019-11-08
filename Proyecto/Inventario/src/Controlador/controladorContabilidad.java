/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.vistaContabilidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Camilo Vargas
 */
public class controladorContabilidad implements ActionListener{
    private vistaContabilidad vistaContabilidad;
    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
