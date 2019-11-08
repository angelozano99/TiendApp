/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Vista.vistaInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Camilo Vargas
 */
public class controladorInicio implements ActionListener{
    
    private vistaInicio vistainicio;
    public controladorInicio(vistaInicio vistainicio){
        
        this.vistainicio = new vistaInicio();
        this.vistainicio.botoningresar.addActionListener(this);
        this.vistainicio.setVisible(true);
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(vistainicio.usuariotext.equals("root")&& vistainicio.contratext.equals("root")){
        
            
    }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
