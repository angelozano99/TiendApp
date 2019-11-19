/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Componentes.Increment;
import Modelo.ProcesarBD;
import Vista.vistaConfiguracion;
import Vista.vistaContabilidad;
import Vista.vistaInicio2;
import Vista.vistaInventario;
import Vista.vistaPedidos;
import Vista.vistaProducto;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
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
    private int ganancia=0;
    int total=0;
    
    
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
        this.vistaProducto.BotonConfirmar.addActionListener(this);
        
        
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
        
        boolean a = true;
        if(table.getValueAt(row, column) == null){
            a=false;  
        }else if(table.getValueAt(row, column).equals(false)){
            a=false; 
        }
        
        return a;
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
                    String cant1=String.valueOf(this.vistaProducto.jTableproductos.getValueAt(i, 4));
                     int cant=Integer.valueOf(cant1);
                        int pre=Integer.valueOf(String.valueOf(this.vistaProducto.jTableproductos.getValueAt(i, 3)));
                        int to=cant*pre;
                        total+=to;
                        datos[2]=String.valueOf(to);
                        model.addRow(datos);
                    
                    
                    //int ganancia2=procesarBD.leerTablaProducto2(datos[0]);
                    //ganancia+=ganancia2*cant;
                }
            }
            
           
            this.vistaProducto.tablaVenta.setModel(model);
            
            this.vistaProducto.Totaltext.setText(String.valueOf(total));
            
            //System.out.println(ganancia);
            
        }
        if(e.getSource()==this.vistaProducto.BotonConfirmar){
            
            //ID
            Increment incre=new Increment();
            int id;
            id=incre.id_increment2();
            
            //Fecha
            Calendar c1 = Calendar.getInstance();
            String dia = Integer.toString(c1.get(Calendar.DATE));
            int mes = c1.get(Calendar.MONTH);
            String annio = Integer.toString(c1.get(Calendar.YEAR));
            mes = mes + 1;
            String fecha = dia + "-" + String.valueOf(mes) + "-" + annio;
            
            //Total
            DefaultTableModel model= new DefaultTableModel();
            model = (DefaultTableModel) this.vistaProducto.tablaVenta.getModel();
            int p = model.getRowCount();

            for (int i3 = 0; i3 < p; i3++) {
                String nom_producto = String.valueOf(model.getValueAt(i3, 0));
                int cantidad = Integer.valueOf(String.valueOf(model.getValueAt(i3, 1)));

                int ganancia2=procesarBD.leerTablaProducto2(nom_producto);
                int unidades=procesarBD.ProductoC(nom_producto);
                unidades=unidades-cantidad;
                procesarBD.updateProductoVenta(nom_producto, unidades);
                
                ganancia+=ganancia2*cantidad;
                
            }
            
            procesarBD.ingresarVenta(id, fecha, total, ganancia);
            for (int i3 = 0; i3 < p; i3++) {
                String nom_producto = String.valueOf(model.getValueAt(i3, 0));
                int cantidad = Integer.valueOf(String.valueOf(model.getValueAt(i3, 1)));

               
                
                procesarBD.ingresarVenta_producto(id,nom_producto, cantidad);
            }
            
            ganancia=0;
            total=0;
            
        }
            
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

