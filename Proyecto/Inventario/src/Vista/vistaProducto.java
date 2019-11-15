/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author angel
 */
public class vistaProducto extends javax.swing.JFrame {

    /**
     * Creates new form vistaProducto
     */
    public vistaProducto() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel6 = new javax.swing.JPanel();
        BotonProductos4 = new javax.swing.JButton();
        BotonContabilidad4 = new javax.swing.JButton();
        BotonInventario4 = new javax.swing.JButton();
        BotonPedidos4 = new javax.swing.JButton();
        BotonConfiguracion4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        BotonAnadir = new javax.swing.JButton();
        BotonDevolucion = new javax.swing.JButton();
        ButonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableproductos = new javax.swing.JTable();
        jtextBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        BotonProductos4.setBackground(new java.awt.Color(153, 153, 255));
        BotonProductos4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonProductos4.setText("Ventas");

        BotonContabilidad4.setBackground(new java.awt.Color(255, 255, 255));
        BotonContabilidad4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonContabilidad4.setText("Contabilidad");

        BotonInventario4.setBackground(new java.awt.Color(255, 255, 255));
        BotonInventario4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonInventario4.setText("Inventario");

        BotonPedidos4.setBackground(new java.awt.Color(255, 255, 255));
        BotonPedidos4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonPedidos4.setText("Registro de Pedidos");

        BotonConfiguracion4.setBackground(new java.awt.Color(255, 255, 255));
        BotonConfiguracion4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonConfiguracion4.setText("Configuración");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel10.setText("Producto");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Tiendapp.png"))); // NOI18N

        BotonAnadir.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonAnadir.setText("Añadir al carrito");
        BotonAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAnadirActionPerformed(evt);
            }
        });

        BotonDevolucion.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonDevolucion.setText("Devolución");

        ButonSalir.setText("Salir");

        jTableproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre de Productos", "Proveedor", "Unidades Disponibles", "Precio $", "Seleccionar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableproductos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(BotonProductos4)
                        .addGap(122, 122, 122)
                        .addComponent(BotonContabilidad4)
                        .addGap(127, 127, 127)
                        .addComponent(BotonInventario4)
                        .addGap(144, 144, 144)
                        .addComponent(BotonPedidos4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(BotonConfiguracion4)
                        .addGap(120, 120, 120))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jtextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonDevolucion)
                                    .addComponent(BotonAnadir))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(ButonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60))))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonProductos4)
                    .addComponent(BotonContabilidad4)
                    .addComponent(BotonInventario4)
                    .addComponent(BotonPedidos4)
                    .addComponent(BotonConfiguracion4))
                .addGap(60, 60, 60)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(BotonDevolucion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButonSalir)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(BotonAnadir))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jtextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAnadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonAnadirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaProducto().setVisible(true);
            }
        });
       
    }
    
    public void addCheckBox (int column, JTable table){
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));    
    }
    
    public boolean IsSelected(int row,int column,JTable table){
        return table.getValueAt(row, column) != null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonAnadir;
    public javax.swing.JButton BotonConfiguracion4;
    public javax.swing.JButton BotonContabilidad4;
    public javax.swing.JButton BotonDevolucion;
    public javax.swing.JButton BotonInventario4;
    public javax.swing.JButton BotonPedidos4;
    public javax.swing.JButton BotonProductos4;
    public javax.swing.JButton ButonSalir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableproductos;
    private javax.swing.JTextField jtextBuscar;
    // End of variables declaration//GEN-END:variables
}
