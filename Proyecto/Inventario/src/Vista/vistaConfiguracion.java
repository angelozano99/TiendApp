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
public class vistaConfiguracion extends javax.swing.JFrame {

    /**
     * Creates new form vistaConfiguracion
     */
    public vistaConfiguracion() {
        initComponents();
        
        
        buttonGroup4.add(Usuario);
        
        buttonGroup4.add(Administrador);
        
        
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

        buttonGroup4 = new javax.swing.ButtonGroup();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        BotonCrear = new javax.swing.JButton();
        BotonModificar = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextNombre = new javax.swing.JTextField();
        TextContraseña = new javax.swing.JPasswordField();
        butonSalir = new javax.swing.JButton();
        BotonProductos = new javax.swing.JButton();
        BotonContabilidad = new javax.swing.JButton();
        BotonInventario = new javax.swing.JButton();
        BotonConfiguracion4 = new javax.swing.JButton();
        BotonPedidos = new javax.swing.JButton();
        Usuario = new javax.swing.JRadioButton();
        Administrador = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuración");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setName("Configuración"); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Tiendapp.png"))); // NOI18N

        BotonCrear.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonCrear.setText("Crear");
        BotonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearActionPerformed(evt);
            }
        });

        BotonModificar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonModificar.setText("Modificar");

        BotonEliminar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonEliminar.setText("Eliminar");

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setText("Tipo");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel2.setText("Nombre de Usuario:");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña:");

        TextNombre.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        TextContraseña.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        TextContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextContraseñaActionPerformed(evt);
            }
        });

        butonSalir.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        butonSalir.setText("Salir");
        butonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonSalirActionPerformed(evt);
            }
        });

        BotonProductos.setBackground(new java.awt.Color(255, 255, 255));
        BotonProductos.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonProductos.setText("Productos");

        BotonContabilidad.setBackground(new java.awt.Color(255, 255, 255));
        BotonContabilidad.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonContabilidad.setText("Contabilidad");
        BotonContabilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonContabilidadActionPerformed(evt);
            }
        });

        BotonInventario.setBackground(new java.awt.Color(255, 255, 255));
        BotonInventario.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonInventario.setText("Inventario");

        BotonConfiguracion4.setBackground(new java.awt.Color(153, 153, 255));
        BotonConfiguracion4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonConfiguracion4.setText("Configuración");

        BotonPedidos.setBackground(new java.awt.Color(255, 255, 255));
        BotonPedidos.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        BotonPedidos.setText("Registro de Pedidos");

        Usuario.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        Usuario.setText("Usuario");
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });

        Administrador.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        Administrador.setText("Administrador");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TextContraseña)
                            .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5)
                    .addComponent(butonSalir))
                .addGap(69, 69, 69))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BotonCrear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BotonEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(179, 179, 179)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Administrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel1)))
                .addGap(0, 885, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(BotonProductos)
                .addGap(122, 122, 122)
                .addComponent(BotonContabilidad)
                .addGap(127, 127, 127)
                .addComponent(BotonInventario)
                .addGap(144, 144, 144)
                .addComponent(BotonPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(BotonConfiguracion4)
                .addGap(119, 119, 119))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonProductos)
                    .addComponent(BotonContabilidad)
                    .addComponent(BotonInventario)
                    .addComponent(BotonPedidos)
                    .addComponent(BotonConfiguracion4))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TextContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotonCrear)
                        .addGap(18, 18, 18)
                        .addComponent(BotonModificar)
                        .addGap(18, 18, 18)
                        .addComponent(BotonEliminar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Administrador)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(butonSalir)
                .addGap(78, 78, 78))
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

    private void BotonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonCrearActionPerformed

    private void TextContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextContraseñaActionPerformed

    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioActionPerformed

    private void BotonContabilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonContabilidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonContabilidadActionPerformed

    private void butonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butonSalirActionPerformed

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
            java.util.logging.Logger.getLogger(vistaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaConfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaConfiguracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton Administrador;
    public javax.swing.JButton BotonConfiguracion4;
    public javax.swing.JButton BotonContabilidad;
    public javax.swing.JButton BotonCrear;
    public javax.swing.JButton BotonEliminar;
    public javax.swing.JButton BotonInventario;
    public javax.swing.JButton BotonModificar;
    public javax.swing.JButton BotonPedidos;
    public javax.swing.JButton BotonProductos;
    public javax.swing.JPasswordField TextContraseña;
    public javax.swing.JTextField TextNombre;
    public javax.swing.JRadioButton Usuario;
    public javax.swing.JButton butonSalir;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
