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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author davox
 */
public class EmpleadosAdmin extends javax.swing.JFrame {

    /**
     * Creates new form EmpleadosAdmin
     */
    DefaultTableModel modelo = new DefaultTableModel();
    private String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private Pattern patternEmail = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);

    public EmpleadosAdmin() {
        setTitle("Empleados");
        initComponents();
        llenarTabla();
        this.setLocationRelativeTo(null);

        btnSeleccionar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(false);

    }

    private void llenarTabla() {
        Connection con = ConnectDB.getConnection();
        Statement consulta = null;
        if (con != null) {
            try {
                consulta = con.createStatement();
                String nulo = "ninguno";
                ResultSet rs = consulta.executeQuery("Select * FROM admin");
                modelo.setColumnCount(5);
                modelo.setColumnIdentifiers(new Object[]{"Id", "Usuario", "Contraseña", "E-mail", "Estado"});
                while (rs.next()) {

                    modelo.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)});

                }
            } catch (SQLException ex) {
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtUsuario.setText("");
        txtContrasena.setText("");
        txtEmail.setText("");

        radioActivo.setSelected(true);
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
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radioActivo = new javax.swing.JRadioButton();
        radioInactivo = new javax.swing.JRadioButton();
        txtId = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        jTable1.setModel(modelo);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empleadoSeleccionado(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Usuario");

        jLabel3.setText("Contraseña");

        jLabel4.setText("Estado");

        buttonGroup1.add(radioActivo);
        radioActivo.setText("Activo");

        buttonGroup1.add(radioInactivo);
        radioInactivo.setText("Inactivo");

        txtId.setEditable(false);
        txtId.setUI(null);
        txtId.setEnabled(false);

        btnSeleccionar.setText("Seleccionar Empleado");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnCrear.setBackground(new java.awt.Color(0, 153, 255));
        btnCrear.setText("Crear Empleado");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar Empleado");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel5.setText("E-mail");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnSeleccionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 14, Short.MAX_VALUE)
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                    .addComponent(txtUsuario)
                                    .addComponent(txtEmail))
                                .addGap(100, 100, 100)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioActivo)
                                    .addComponent(radioInactivo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(radioActivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioInactivo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(18, 18, 18)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnCrear)
                    .addComponent(btnModificar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed

        btnCrear.setEnabled(false);
        btnModificar.setEnabled(true);
        btnCancelar.setEnabled(true);

        int fila = jTable1.getSelectedRow();
        txtId.setText(Integer.toString((Integer) jTable1.getValueAt(fila, 0)));
        txtUsuario.setText((String) jTable1.getValueAt(fila, 1));
        txtContrasena.setText((String) jTable1.getValueAt(fila, 2));
        txtEmail.setText((String) jTable1.getValueAt(fila, 3));

        String estado = ((String) jTable1.getValueAt(fila, 4));
        if (estado.equals("activo")) {
            radioActivo.setSelected(true);

        }
        if (estado.equals("inactivo")) {
            radioInactivo.setSelected(true);

        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        Matcher matcher = patternEmail.matcher(txtEmail.getText());
        String estado = "activo";
        JDialog frame = new JDialog();

        if (radioActivo.isSelected()) {
            estado = "activo";
        }
        if (radioInactivo.isSelected()) {
            estado = "inactivo";
        }

        if (txtUsuario.getText().equals("") || txtContrasena.getText().equals("") || txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Favor de llenar todos los campos para continuar.");
        } else if (!matcher.matches()) {
            JOptionPane.showMessageDialog(frame, "Favor de ingresar un e-mail valido");
        } else {
            try {
                Connection con = ConnectDB.getConnection();
                String sql = "INSERT INTO `admin` (`id`, `usuario`, `contrasena`, `correo_electronico`, `estado`) VALUES (NULL, ?, ?, ?, '" + estado + "'); ";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, txtUsuario.getText());
                ps.setString(2, txtContrasena.getText());
                ps.setString(3, (txtEmail.getText()));

                ps.executeUpdate();
                limpiarCampos();
                llenarTabla();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        Matcher matcher = patternEmail.matcher(txtEmail.getText());
        JDialog frame = new JDialog();
        String estado = "activo";

        if (radioActivo.isSelected()) {
            estado = "activo";
        }
        if (radioInactivo.isSelected()) {
            estado = "inactivo";
        }

        if (txtUsuario.getText().equals("") || txtContrasena.getText().equals("") || txtEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(frame, "Favor de llenar todos los campos para continuar.");
        }else if(!matcher.matches()){
            JOptionPane.showMessageDialog(frame, "Favor de ingresar un e-mail valido");
        } else {
            try {
                Connection con = ConnectDB.getConnection();
                String sql = "UPDATE `admin` SET `usuario` = ?, `contrasena` = ?, `correo_electronico` = ?, `estado` = ? WHERE `admin`.`id` = ?; ";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, txtUsuario.getText());
                ps.setString(2, txtContrasena.getText());
                ps.setString(3, (txtEmail.getText()));
                ps.setString(4, estado);

                ps.setString(5, txtId.getText());

                ps.executeUpdate();
                limpiarCampos();
                llenarTabla();

                btnSeleccionar.setEnabled(false);
                btnModificar.setEnabled(false);
                btnCancelar.setEnabled(false);
                btnCrear.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void empleadoSeleccionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empleadoSeleccionado
        btnSeleccionar.setEnabled(true);
    }//GEN-LAST:event_empleadoSeleccionado

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        btnSeleccionar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnCrear.setEnabled(true);

        limpiarCampos();
        llenarTabla();

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
            java.util.logging.Logger.getLogger(EmpleadosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmpleadosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmpleadosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmpleadosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmpleadosAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioActivo;
    private javax.swing.JRadioButton radioInactivo;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
