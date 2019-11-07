/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controlador.controladorInicio;
import Vista.vistainicio;

/**
 *
 * @author Labingpush
 */
public class Principal {
    
    public static void main(String []args){
        
        vistainicio vistaInicio = new vistainicio();
        controladorInicio controladorInicio = new controladorInicio(vistaInicio);
        
    }
    
}
