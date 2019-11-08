/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author angel
 */
public class vistaContabilidad extends javax.swing.JFrame {

    /**
     * Creates new form vistaContabilidad
     */
    public vistaContabilidad() {
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

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProductos = new javax.swing.JTable();
        BotonProductos = new javax.swing.JButton();
        BotonContabilidad = new javax.swing.JButton();
        BotonInventario = new javax.swing.JButton();
        BotonPedidos = new javax.swing.JButton();
        BotonConfiguracion = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BotonBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        BotonDiaria = new javax.swing.JButton();
        BotonSemanal = new javax.swing.JButton();
        BotonMensual = new javax.swing.JButton();
        BotonAnual = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Contabilidad");

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
                "Cantidad", "Producto", "Precio de Venta", "Precio de Compra", "Ganancia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TableProductos);

        BotonProductos.setBackground(new java.awt.Color(255, 255, 255));
        BotonProductos.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonProductos.setText("Productos");

        BotonContabilidad.setBackground(new java.awt.Color(153, 153, 255));
        BotonContabilidad.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonContabilidad.setText("Contabilidad");

        BotonInventario.setBackground(new java.awt.Color(255, 255, 255));
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

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        BotonDiaria.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonDiaria.setText("Diaria");

        BotonSemanal.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonSemanal.setText("Semanal");

        BotonMensual.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonMensual.setText("Mensual");

        BotonAnual.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonAnual.setText("Anual");

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Grafica");

        ComboBox.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diaria\t\t", "Semanal", "Mensual", "Anual" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(BotonProductos)
                .addGap(122, 122, 122)
                .addComponent(BotonContabilidad)
                .addGap(127, 127, 127)
                .addComponent(BotonInventario)
                .addGap(144, 144, 144)
                .addComponent(BotonPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonConfiguracion)
                .addGap(120, 120, 120))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 842, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonDiaria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonSemanal, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonMensual, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonAnual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(132, 132, 132))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotonBuscar)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel5)))
                .addGap(69, 69, 69))
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
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(BotonBuscar)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(BotonDiaria)
                        .addGap(18, 18, 18)
                        .addComponent(BotonSemanal)
                        .addGap(18, 18, 18)
                        .addComponent(BotonMensual)
                        .addGap(18, 18, 18)
                        .addComponent(BotonAnual))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(vistaContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaContabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaContabilidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonAnual;
    public javax.swing.JButton BotonBuscar;
    public javax.swing.JButton BotonConfiguracion;
    public javax.swing.JButton BotonContabilidad;
    public javax.swing.JButton BotonDiaria;
    public javax.swing.JButton BotonInventario;
    public javax.swing.JButton BotonMensual;
    public javax.swing.JButton BotonPedidos;
    public javax.swing.JButton BotonProductos;
    public javax.swing.JButton BotonSemanal;
    public javax.swing.JComboBox<String> ComboBox;
    public javax.swing.JTable TableProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
