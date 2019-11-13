/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Camilo Vargas
 */
public class Increment {

    public int id_increment() {
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion db = new Conexion();

        try {

            ps = db.conectado().prepareStatement("SELECT MAX(id_pedido) FROM pedido");
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
       finally{
            try{
                ps.close();
                rs.close();
                db.desconectar();
            }catch(Exception ex){
                
            }
            
        }
        return id;
    }

}
