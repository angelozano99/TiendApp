/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.vistaPedidos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author angel
 */
public class controladorPedidos implements ActionListener{

    private vistaPedidos vistaPedidos;
    
    public controladorPedidos(vistaPedidos vistaPedidos){
        
        this.vistaPedidos = new vistaPedidos();
        
        this.vistaPedidos.setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
