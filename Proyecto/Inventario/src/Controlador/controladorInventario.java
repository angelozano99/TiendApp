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
import javax.swing.table.DefaultTableModel;

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
    private ProcesarBD procesarBD = new ProcesarBD();
    private String globalNombre;

    public controladorInventario(vistaInventario vistaInventario, String nombre) {

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
        this.vistaInventario.BotonAñadirFila.addActionListener(this);

        this.vistaInventario.ButonSalir.addActionListener(this);

        this.vistaInventario.setVisible(true);

        this.globalNombre = nombre;
        evaluarUsuario();
    }

    public void evaluarUsuario() {

        boolean a = procesarBD.tipoUsuario(globalNombre);
        if (a) {
            this.vistaInventario.BotonConfiguracion.setEnabled(true);
        } else {
            this.vistaInventario.BotonConfiguracion.setEnabled(false);
        }
    }

    @Override
    @SuppressWarnings("empty-statement")
    public void actionPerformed(ActionEvent e) {

        String[] datos = new String[5];

        if (e.getSource() == this.vistaInventario.BotonAñadirFila) {

            DefaultTableModel model = (DefaultTableModel) this.vistaInventario.TableProductos.getModel();

            Object filas[] = {null, null, null, null, null, null};

            model.addRow(filas);

        }

        if (e.getSource() == this.vistaInventario.BotonBuscar) {

            String nombre = this.vistaInventario.textBuscar.getText();

            DefaultTableModel model = (DefaultTableModel) this.vistaInventario.TableProductos.getModel();

            int p = model.getRowCount();

            for (int j = 0; j < p; j++) {
                model.removeRow(0);
            }

            datos = procesarBD.leerProducto(nombre);

            Object filas[] = {datos[0], Integer.valueOf(datos[1]), Integer.valueOf(datos[2]),
                Integer.valueOf(datos[4]), datos[5]};

            model.addRow(filas);

        }

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
            controladorProductos controladorProductos = new controladorProductos(vistaProducto, globalNombre);
        }

        if (e.getSource() == this.vistaInventario.BotonPedidos) {
            this.vistaInventario.dispose();
            controladorPedidos controladorPedidos = new controladorPedidos(vistaPedidos, globalNombre);
        }

        if (e.getSource() == this.vistaInventario.BotonContabilidad) {
            this.vistaInventario.dispose();
            controladorContabilidad controladorContabilidad = new controladorContabilidad(vistaContabilidad, globalNombre);
        }

        if (e.getSource() == this.vistaInventario.BotonConfiguracion) {
            this.vistaInventario.dispose();
            controladorConfiguracion controladorConfiguracion = new controladorConfiguracion(vistaConfiguracion, globalNombre);
        }
        if (e.getSource() == this.vistaInventario.ButonSalir) {
            this.vistaInventario.dispose();
            controladorInicio controladorInicio = new controladorInicio(vistaInicio);

        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
