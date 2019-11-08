/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vistaConfiguracion;
import Vista.vistaInicio2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Camilo Vargas
 */
public class controladorInicio implements ActionListener {

    private vistaInicio2 vistainicio2;
    private vistaConfiguracion vistaConfiguracion;

    public controladorInicio(vistaInicio2 vistainicio) {

        this.vistainicio2 = new vistaInicio2();
        this.vistaConfiguracion = new vistaConfiguracion();

        this.vistainicio2.BotonIngresar.addActionListener(this);
        this.vistainicio2.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.vistainicio2.BotonIngresar) {
            if (vistainicio2.textNombre.equals("root") && vistainicio2.textContra.equals("root")) {

             controladorConfiguracion controladorConfiguracion = new controladorConfiguracion(vistaConfiguracion);
                
            }
        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
