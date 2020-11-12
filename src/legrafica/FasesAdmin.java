/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legrafica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author davox
 */
public class FasesAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FasesAdmin
     */
    String nombreTabla;
    DefaultTableModel modelo = new DefaultTableModel();
    public legrafica.Modelos.Proyectos idProyecto;

    public FasesAdmin(legrafica.Modelos.Proyectos parametro) {
        initComponents();
        idProyecto = parametro;
        this.setLocationRelativeTo(null);
        radioPorHacer.setSelected(true);
        setTitle("Cronograma");
        llenarTabla();
    }

    private void llenarTabla() {
        nombreTabla = "proyecto" + idProyecto.getId();
        Connection con = ConnectDB.getConnection();
        Statement consulta = null;
        if (con != null) {
            try {
                consulta = con.createStatement();

                ResultSet rs = consulta.executeQuery("Select * FROM " + nombreTabla);
                System.out.println(nombreTabla);
                modelo.setColumnCount(6);
                modelo.setColumnIdentifiers(new Object[]{"Id", "Etapa", "Fecha Inicio", "Fecha Termino", "Status", "Encargado"});
                while (rs.next()) {

                    modelo.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});

                }
            } catch (SQLException ex) {
                System.out.println("no se pudo suckker");
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtEtapa.setText("");
        txtFechaInicio.setText("");
        txtFechaTermino.setText("");
        txtEncargado.setText("");
        radioPorHacer.setSelected(true);
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFases = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radioTerminado = new javax.swing.JRadioButton();
        radioProceso = new javax.swing.JRadioButton();
        radioPorHacer = new javax.swing.JRadioButton();
        txtId = new javax.swing.JTextField();
        txtEtapa = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaTermino = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtEncargado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        tableFases.setModel(modelo);
        jScrollPane1.setViewportView(tableFases);

        jLabel1.setText("Etapa");

        jLabel2.setText("Fecha Inicio");

        jLabel3.setText("Fecha Termino");

        jLabel4.setText("Encargado");

        buttonGroup1.add(radioTerminado);
        radioTerminado.setText("Terminado");

        buttonGroup1.add(radioProceso);
        radioProceso.setText("En Proceso");

        buttonGroup1.add(radioPorHacer);
        radioPorHacer.setText("Por Hacer");

        txtId.setEditable(false);

        txtEtapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEtapaActionPerformed(evt);
            }
        });

        btnSeleccionar.setText("Seleccionar Etapa");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnCrear.setBackground(new java.awt.Color(0, 153, 255));
        btnCrear.setText("Crear Etapa");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar Etapa");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel5.setText("Id");

        jLabel6.setText("Estado");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(35, 35, 35))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(txtEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(txtEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioProceso)
                            .addComponent(radioTerminado)
                            .addComponent(radioPorHacer)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(btnActualizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(radioPorHacer))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtFechaTermino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioProceso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioTerminado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(btnActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnModificar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEtapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEtapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEtapaActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        radioTerminado.setEnabled(true);
        radioProceso.setEnabled(true);
        radioPorHacer.setEnabled(true);

        int fila = tableFases.getSelectedRow();
        txtId.setText(Integer.toString((Integer) tableFases.getValueAt(fila, 0)));
        txtEtapa.setText((String) tableFases.getValueAt(fila, 1));
        txtFechaInicio.setText((String) tableFases.getValueAt(fila, 2));
        txtFechaTermino.setText((String) tableFases.getValueAt(fila, 3));
        txtEncargado.setText((String) tableFases.getValueAt(fila, 5));
        String estado = ((String) tableFases.getValueAt(fila, 4));
        if (estado.equals("terminado")) {
            radioTerminado.setSelected(true);

        }
        if (estado.equals("en_proceso")) {
            radioProceso.setSelected(true);

        }
        if (estado.equals("por_hacer")) {
            radioPorHacer.setSelected(true);

        }


    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        if (txtEtapa.getText().equals("") || txtFechaInicio.getText().equals("") || txtFechaTermino.getText().equals("")
                || txtEncargado.getText().equals("")) {
            JDialog frame = new JDialog();
            JOptionPane.showMessageDialog(frame, "Favor de llenar todos los campos para continuar.");
        } else {
            try {
                nombreTabla = "proyecto" + idProyecto.getId();
                Connection con = ConnectDB.getConnection();
                String sql = "INSERT INTO `" + nombreTabla + "` (`id`, `etapa`, `fecha_inicio`, `fecha_termino`, `status`, "
                        + "`encargado`) VALUES (NULL, ?, ?, ?, 'por_hacer', ?);";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, txtEtapa.getText());
                ps.setString(2, txtFechaInicio.getText());
                ps.setString(3, (txtFechaTermino.getText()));
                ps.setString(4, (txtEncargado.getText()));

                ps.executeUpdate();
                limpiarCampos();
                llenarTabla();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        radioTerminado.setEnabled(false);
        radioProceso.setEnabled(false);
        radioPorHacer.setEnabled(false);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        nombreTabla = "proyecto" + idProyecto.getId();
        if (txtEtapa.getText().equals("") || txtFechaInicio.getText().equals("") || txtFechaTermino.getText().equals("")
                || txtEncargado.getText().equals("")) {
            JDialog frame = new JDialog();
            JOptionPane.showMessageDialog(frame, "Favor de llenar todos los campos para continuar.");
        } else {
            try {
                Connection con = ConnectDB.getConnection();
                String sql = "UPDATE `" + nombreTabla + "` SET `etapa` = ?, `fecha_inicio` = ?, `fecha_termino` = ?, `encargado` = ? WHERE `" + nombreTabla + "`.`id` = ?; ";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, txtEtapa.getText());
                ps.setString(2, txtFechaInicio.getText());
                ps.setString(3, (txtFechaTermino.getText()));
                ps.setString(4, (txtEncargado.getText()));
                ps.setString(5, txtId.getText());

                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (radioTerminado.isSelected() == true) {

            try {
                Connection con = ConnectDB.getConnection();
                String sql = "UPDATE `" + nombreTabla + "` SET `status` = 'terminado' WHERE `" + nombreTabla + "`.`id` = ?; ";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                ps.setString(1, txtId.getText());
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (radioProceso.isSelected() == true) {

            try {
                Connection con = ConnectDB.getConnection();
                String sql = "UPDATE `" + nombreTabla + "` SET `status` = 'en_proceso' WHERE `" + nombreTabla + "`.`id` = ?; ";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                ps.setString(1, txtId.getText());
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (radioPorHacer.isSelected() == true) {

            try {
                Connection con = ConnectDB.getConnection();
                String sql = "UPDATE `" + nombreTabla + "` SET `status` = 'por_hacer' WHERE `" + nombreTabla + "`.`id` = ?; ";
                PreparedStatement ps;
                ps = con.prepareStatement(sql);
                ps.setString(1, txtId.getText());
                ps.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        limpiarCampos();
        llenarTabla();
        radioTerminado.setEnabled(false);
        radioProceso.setEnabled(false);
        radioPorHacer.setEnabled(false);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        limpiarCampos();
        llenarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(FasesAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FasesAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FasesAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FasesAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new FasesAdmin().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioPorHacer;
    private javax.swing.JRadioButton radioProceso;
    private javax.swing.JRadioButton radioTerminado;
    private javax.swing.JTable tableFases;
    private javax.swing.JTextField txtEncargado;
    private javax.swing.JTextField txtEtapa;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtFechaTermino;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
