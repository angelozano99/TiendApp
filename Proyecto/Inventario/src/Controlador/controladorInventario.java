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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Camilo Vargas
 */
public class controladorInventario implements ActionListener {

    private vistaInventario vistaInventario;
    private vistaConfiguracion vistaConfiguracion;
    private vistaProducto vistaProducto;
    private vistaContabilidad vistaContabilidad;
    private vistaPedidos vistaPedidos;
    private vistaInicio2 vistaInicio;

    public controladorInventario(vistaInventario vistaInventario) {

        this.vistaInventario = new vistaInventario();

        this.vistaInventario.BotonProductos.addActionListener(this);
        this.vistaInventario.BotonContabilidad.addActionListener(this);
        this.vistaInventario.BotonInventario.addActionListener(this);
        this.vistaInventario.BotonPedidos.addActionListener(this);
        this.vistaInventario.BotonConfiguracion.addActionListener(this);

        this.vistaInventario.BotonBuscar.addActionListener(this);
        this.vistaInventario.BotonCrear.addActionListener(this);
        this.vistaInventario.BotonModificar.addActionListener(this);
        this.vistaInventario.BotonEliminar.addActionListener(this);
        
        this.vistaInventario.ButonSalir.addActionListener(this);

        this.vistaInventario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ProcesarBD procesarBD = new ProcesarBD();
        if (e.getSource() == this.vistaInventario.BotonCrear) {

            int i = 0;
            do {
                
                String nombre = String.valueOf(this.vistaInventario.TableProductos.getValueAt(i, 0));
                int precioCompra = Integer.valueOf(String.valueOf(this.vistaInventario.TableProductos.getValueAt(i, 1)));
                int precioVenta = Integer.valueOf(String.valueOf(this.vistaInventario.TableProductos.getValueAt(i, 2)));
                int ganancia = precioVenta - precioCompra;
                int unidades = Integer.valueOf(String.valueOf(this.vistaInventario.TableProductos.getValueAt(i, 3)));
                String proveedor = String.valueOf(this.vistaInventario.TableProductos.getValueAt(i, 4));

                try {
                    procesarBD.ingresarProducto(nombre, precioCompra, precioVenta, ganancia, unidades, proveedor);
                } catch (SQLException ex) {
                    Logger.getLogger(controladorInventario.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            } while (this.vistaInventario.TableProductos.getValueAt(i, 0) != null);

        }

        if (e.getSource() == this.vistaInventario.BotonProductos) {
            this.vistaInventario.dispose();
            controladorProductos controladorProductos = new controladorProductos(vistaProducto);
        }

        if (e.getSource() == this.vistaInventario.BotonPedidos) {
            this.vistaInventario.dispose();
            controladorPedidos controladorPedidos = new controladorPedidos(vistaPedidos);
        }

        if (e.getSource() == this.vistaInventario.BotonContabilidad) {
            this.vistaInventario.dispose();
            controladorContabilidad controladorContabilidad = new controladorContabilidad(vistaContabilidad);
        }

        if (e.getSource() == this.vistaInventario.BotonConfiguracion) {
            this.vistaInventario.dispose();
            controladorConfiguracion controladorConfiguracion = new controladorConfiguracion(vistaConfiguracion);
        }
        if(e.getSource()==this.vistaInventario.ButonSalir){
            this.vistaInventario.dispose();
            controladorInicio controladorInicio = new controladorInicio(vistaInicio);
            
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
