/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Labing
 */
public class vistaInventario extends javax.swing.JFrame {

    /**
     * Creates new form vistaProductos
     */
    public vistaInventario() {
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

        jLabel1 = new javax.swing.JLabel();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel4 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProductos = new javax.swing.JTable();
        BotonCrear = new javax.swing.JButton();
        BotonModificar = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        BotonProductos = new javax.swing.JButton();
        BotonContabilidad = new javax.swing.JButton();
        BotonInventario = new javax.swing.JButton();
        BotonPedidos = new javax.swing.JButton();
        BotonConfiguracion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BotonBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textBuscar = new javax.swing.JTextField();
        ButonSalir = new javax.swing.JButton();
        BotonAñadirFila = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        BotonProductosDisponibles = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jLabel1.setText("Inventario");

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inventario");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TableProductos.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "P. Compra", "P. venta", "Unidades", "Proveedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableProductos);
        if (TableProductos.getColumnModel().getColumnCount() > 0) {
            TableProductos.getColumnModel().getColumn(1).setPreferredWidth(123);
        }

        BotonCrear.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonCrear.setText("Crear");

        BotonModificar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonModificar.setText("Modificar");

        BotonEliminar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonEliminar.setText("Eliminar");

        BotonProductos.setBackground(new java.awt.Color(255, 255, 255));
        BotonProductos.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonProductos.setText("Ventas");
        BotonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonProductosActionPerformed(evt);
            }
        });

        BotonContabilidad.setBackground(new java.awt.Color(255, 255, 255));
        BotonContabilidad.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonContabilidad.setText("Contabilidad");

        BotonInventario.setBackground(new java.awt.Color(153, 153, 255));
        BotonInventario.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonInventario.setText("Inventario");

        BotonPedidos.setBackground(new java.awt.Color(255, 255, 255));
        BotonPedidos.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonPedidos.setText("Registro de Pedidos");

        BotonConfiguracion.setBackground(new java.awt.Color(255, 255, 255));
        BotonConfiguracion.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonConfiguracion.setText("Configuración");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 22)); // NOI18N
        jLabel2.setText("Buscar:");

        BotonBuscar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonBuscar.setText("Buscar");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Tiendapp.png"))); // NOI18N

        textBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscarActionPerformed(evt);
            }
        });

        ButonSalir.setText("Salir");

        BotonAñadirFila.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonAñadirFila.setText("Añadir Fila");

        BotonLimpiar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonLimpiar.setText("Limpiar Tabla");

        BotonProductosDisponibles.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonProductosDisponibles.setText("Productos Disponibles");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonBuscar)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel5))
                            .addComponent(ButonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BotonProductosDisponibles)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BotonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BotonCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BotonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)
                                .addComponent(BotonContabilidad)
                                .addGap(109, 109, 109)
                                .addComponent(BotonInventario)
                                .addGap(102, 102, 102)
                                .addComponent(BotonPedidos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotonConfiguracion)
                                .addGap(52, 52, 52)))))
                .addGap(68, 68, 68))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(BotonAñadirFila)
                .addGap(64, 64, 64)
                .addComponent(BotonLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonProductos)
                    .addComponent(BotonContabilidad)
                    .addComponent(BotonInventario)
                    .addComponent(BotonPedidos)
                    .addComponent(BotonConfiguracion))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(BotonBuscar)
                        .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(BotonCrear)
                        .addGap(18, 18, 18)
                        .addComponent(BotonModificar)
                        .addGap(18, 18, 18)
                        .addComponent(BotonEliminar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(BotonProductosDisponibles)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonAñadirFila)
                    .addComponent(BotonLimpiar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(ButonSalir)
                .addGap(40, 40, 40))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textBuscarActionPerformed

    private void BotonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonProductosActionPerformed

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
            java.util.logging.Logger.getLogger(vistaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonAñadirFila;
    public javax.swing.JButton BotonBuscar;
    public javax.swing.JButton BotonConfiguracion;
    public javax.swing.JButton BotonContabilidad;
    public javax.swing.JButton BotonCrear;
    public javax.swing.JButton BotonEliminar;
    public javax.swing.JButton BotonInventario;
    public javax.swing.JButton BotonLimpiar;
    public javax.swing.JButton BotonModificar;
    public javax.swing.JButton BotonPedidos;
    public javax.swing.JButton BotonProductos;
    public javax.swing.JButton BotonProductosDisponibles;
    public javax.swing.JButton ButonSalir;
    public javax.swing.JTable TableProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField textBuscar;
    // End of variables declaration//GEN-END:variables
}
