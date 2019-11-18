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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author angel
 */
public class controladorProductos implements ActionListener{
    
    private vistaProducto vistaProducto;
    
    private vistaConfiguracion vistaConfiguracion;
    
    private vistaContabilidad vistaContabilidad;
    private vistaInventario vistaInventario;
    private vistaPedidos vistaPedidos;
    private vistaInicio2 vistaInicio;
    private ProcesarBD procesarBD = new ProcesarBD();
    private String globalNombre;
    
    
    
    public controladorProductos (vistaProducto vistaProducto, String nombre){
        
        this.vistaProducto = new vistaProducto();
        
        this.vistaProducto.BotonProductos4.addActionListener(this);
        this.vistaProducto.BotonContabilidad4.addActionListener(this);
        this.vistaProducto.BotonInventario4.addActionListener(this);
        this.vistaProducto.BotonPedidos4.addActionListener(this);
        this.vistaProducto.BotonConfiguracion4.addActionListener(this);
        
        this.vistaProducto.BotonAnadir.addActionListener(this);
        this.vistaProducto.BotonDevolucion.addActionListener(this);
        this.vistaProducto.BotonBuscar.addActionListener(this);
        
        
        this.vistaProducto.ButonSalir.addActionListener(this);

        this.vistaProducto.setVisible(true);
        
        this.globalNombre=nombre;
        
        evaluarUsuario();
        llenarTabla();
        
    }
    
    public void evaluarUsuario(){
        
        boolean a = procesarBD.tipoUsuario(globalNombre);
        //System.out.println("a ->" + a);
        if (a && !this.vistaProducto.BotonConfiguracion4.isEnabled()) {
            this.vistaProducto.BotonConfiguracion4.setEnabled(true);
         }else if(!a && this.vistaProducto.BotonConfiguracion4.isEnabled()){
            this.vistaProducto.BotonConfiguracion4.setEnabled(false);
        }
    }
    public void addCheckBox (int column, JTable table){
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));    
    }
    
    public boolean IsSelected(int row,int column,JTable table){
        return table.getValueAt(row, column) != null;
    }
    
    public void llenarTabla(){
        DefaultTableModel tabla = (DefaultTableModel) vistaProducto.jTableproductos.getModel();
        vistaProducto.jTableproductos.setModel(procesarBD.listar(tabla));
        addCheckBox(5, vistaProducto.jTableproductos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==this.vistaProducto.BotonPedidos4){
            this.vistaProducto.dispose();
            controladorPedidos controladorPedidos = new controladorPedidos(vistaPedidos, globalNombre);
        }
        
        if(e.getSource()==this.vistaProducto.BotonContabilidad4){
            this.vistaProducto.dispose();
            controladorContabilidad controladorContabilidad = new controladorContabilidad(vistaContabilidad, globalNombre);
        }
        
        if(e.getSource()==this.vistaProducto.BotonConfiguracion4){
            this.vistaProducto.dispose();
            controladorConfiguracion controladorConfiguracion = new controladorConfiguracion(vistaConfiguracion, globalNombre); 
        }   
        
        if(e.getSource()==this.vistaProducto.BotonInventario4){
            this.vistaProducto.dispose();
            controladorInventario controladorInventario = new controladorInventario(vistaInventario, globalNombre);
            
        }
        if(e.getSource()==this.vistaProducto.ButonSalir){
            this.vistaProducto.dispose();
            controladorInicio controladorInicio = new controladorInicio(vistaInicio);
            
        }
        if(e.getSource()==this.vistaProducto.BotonBuscar){
            String text=this.vistaProducto.jtextBuscar.getText();
            DefaultTableModel tabla = new DefaultTableModel();
            tabla=procesarBD.filtrar(this.vistaProducto.jTableproductos,text);
            
            this.vistaProducto.jTableproductos.setModel(tabla);
            addCheckBox(5,vistaProducto.jTableproductos);
            
            
        }
        if(e.getSource()==this.vistaProducto.BotonAnadir){
            String[] datos=new String[3];
            DefaultTableModel model= new DefaultTableModel();
            model = (DefaultTableModel) this.vistaProducto.tablaVenta.getModel();
            for(int i=0;i<this.vistaProducto.jTableproductos.getRowCount();i++){
                if(IsSelected(i, 5, this.vistaProducto.jTableproductos)){
                    datos[0]=String.valueOf(this.vistaProducto.jTableproductos.getValueAt(i, 0));
                    datos[1]=String.valueOf(this.vistaProducto.jTableproductos.getValueAt(i, 4));
                    int cant=Integer.valueOf(String.valueOf(this.vistaProducto.jTableproductos.getValueAt(i, 4)));
                    int pre=Integer.valueOf(String.valueOf(this.vistaProducto.jTableproductos.getValueAt(i, 3)));
                    int to=cant*pre;
                    datos[2]=String.valueOf(to);
                    model.addRow(datos);
                    
                }
            }
            this.vistaProducto.tablaVenta.setModel(model);
            
        }
            
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

