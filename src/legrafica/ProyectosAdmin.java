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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author davox
 */
public class ProyectosAdmin extends javax.swing.JFrame {

    int id = 0;

    /**
     * Creates new form ProyectosAdmin
     */
    DefaultTableModel modelo = new DefaultTableModel();

    public ProyectosAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Proyectos");
        llenarTabla();

        radioPorHacer.setSelected(true);
        radioPaginaWeb.setSelected(true);
        btnSeleccionar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnAbrirCrono.setEnabled(false);

    }

    private void llenarTabla() {
        Connection con = ConnectDB.getConnection();
        Statement consulta = null;

        if (con != null) {
            try {
                consulta = con.createStatement();
                String nulo = "ninguno";
                ResultSet rs = consulta.executeQuery("Select * FROM proyecto");
                modelo.setColumnCount(7);
                modelo.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Cliente", "Categoria", "Encargado", "Estado", "Cronograma"});

                Statement consultaCliente = con.createStatement();
                ResultSet rsCliente = consultaCliente.executeQuery("Select id, nombre FROM cliente");

                while (rsCliente.next()) {
                    cbxCliente.addItem(rsCliente.getString(2));
                }
                rsCliente.close();

                Statement consultaEncargado = con.createStatement();
                ResultSet rsEncargado = consultaEncargado.executeQuery("Select id, usuario FROM admin");

                while (rsEncargado.next()) {
                    cbxEncargado.addItem(rsEncargado.getString(2));
                }
                rsEncargado.close();

                while (rs.next()) {
                    int idCronograma = rs.getInt(7);
                    if (idCronograma == 0) {
                        modelo.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 0});
                    } else {
                        modelo.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        cbxCliente.setSelectedIndex(0);
        cbxEncargado.setSelectedIndex(0);

        radioPaginaWeb.setSelected(true);
        radioTerminado.setSelected(true);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        radioPaginaWeb = new javax.swing.JRadioButton();
        radioTiendaLinea = new javax.swing.JRadioButton();
        radioApp = new javax.swing.JRadioButton();
        radioTerminado = new javax.swing.JRadioButton();
        radioProceso = new javax.swing.JRadioButton();
        radioPorHacer = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        btnCrearProyecto = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        btnCrearCrono = new javax.swing.JButton();
        btnAbrirCrono = new javax.swing.JButton();
        radioAppTienda = new javax.swing.JRadioButton();
        radioRedes = new javax.swing.JRadioButton();
        radioGoogle = new javax.swing.JRadioButton();
        radioBranding = new javax.swing.JRadioButton();
        radioDiseno = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxCliente = new javax.swing.JComboBox<>();
        cbxEncargado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel1.setText("Nombre");

        jLabel2.setText("Categoría");

        jLabel4.setText("Estado");

        buttonGroup1.add(radioPaginaWeb);
        radioPaginaWeb.setText("Pagina Web");

        buttonGroup1.add(radioTiendaLinea);
        radioTiendaLinea.setText("Tienda en Linea");

        buttonGroup1.add(radioApp);
        radioApp.setText("App Movil");

        buttonGroup2.add(radioTerminado);
        radioTerminado.setText("Terminado");

        buttonGroup2.add(radioProceso);
        radioProceso.setText("En Proceso");
        radioProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioProcesoActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioPorHacer);
        radioPorHacer.setText("Por Hacer");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        btnCrearProyecto.setBackground(new java.awt.Color(0, 153, 255));
        btnCrearProyecto.setText("Crear Proyecto");
        btnCrearProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProyectoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar Proyecto");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnSeleccionar.setText("Seleccionar Proyecto");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnCrearCrono.setText("Crear Cronograma");
        btnCrearCrono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearCronoActionPerformed(evt);
            }
        });

        btnAbrirCrono.setText("Abrir Cronograma");
        btnAbrirCrono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCronoActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioAppTienda);
        radioAppTienda.setText("App Movil Tienda");

        buttonGroup1.add(radioRedes);
        radioRedes.setText("Redes Sociales");

        buttonGroup1.add(radioGoogle);
        radioGoogle.setText("Google Ads");

        buttonGroup1.add(radioBranding);
        radioBranding.setText("Branding");

        buttonGroup1.add(radioDiseno);
        radioDiseno.setText("Diseño");

        jLabel5.setText("Cliente");

        jLabel6.setText("Encargado");

        cbxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Cliente" }));

        cbxEncargado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Encargado" }));

        jLabel3.setText("Cronograma");

        txtId.setEditable(false);
        txtId.setText("jTextField1");
        txtId.setUI(null);
        txtId.setAutoscrolls(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jTable1.setModel(modelo);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1usuarioSelecionado(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrearProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4))
                            .addComponent(cbxEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioProceso)
                            .addComponent(radioPorHacer)
                            .addComponent(radioTerminado))
                        .addGap(69, 69, 69)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioRedes)
                            .addComponent(radioPaginaWeb)
                            .addComponent(radioApp)
                            .addComponent(radioAppTienda)
                            .addComponent(radioDiseno)
                            .addComponent(radioGoogle)
                            .addComponent(radioTiendaLinea)
                            .addComponent(radioBranding)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnAbrirCrono, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCrearCrono)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbxEncargado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAbrirCrono)
                            .addComponent(btnCrearCrono))
                        .addGap(62, 62, 62))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(radioPaginaWeb)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioApp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioAppTienda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioDiseno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioGoogle))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(radioPorHacer))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioProceso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioTerminado)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioTiendaLinea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBranding)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioRedes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearProyecto)
                    .addComponent(btnModificar)
                    .addComponent(btnSeleccionar))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioProcesoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCrearProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProyectoActionPerformed
        String categoria = "pagina_web";
             

        if (radioPaginaWeb.isSelected() == true) {
            categoria = "pagina_web";

        }
        if (radioTiendaLinea.isSelected() == true) {
            categoria = "tienda_en_linea";

        }
        if (radioApp.isSelected() == true) {
            categoria = "app_movil";

        }
        if (radioAppTienda.isSelected() == true) {
            categoria = "app_movil_tienda";

        }
        if (radioRedes.isSelected() == true) {
            categoria = "redes_sociales";

        }
        if (radioGoogle.isSelected() == true) {
            categoria = "google_ads";

        }
        if (radioBranding.isSelected() == true) {
            categoria = "branding";

        }
        if (radioDiseno.isSelected() == true) {
            categoria = "diseno";

        }
        if (txtNombre.getText().equals("") || 
            cbxCliente.getSelectedItem().toString().equals("Seleccionar Cliente") || 
            cbxEncargado.getSelectedItem().toString().equals("Seleccionar Encargado")) {
            JDialog frame = new JDialog();
            JOptionPane.showMessageDialog(frame, "Favor de llenar todos los campos para continuar.");
        } else {
            try {
                Connection con = ConnectDB.getConnection();
                String sql = "INSERT INTO `proyecto` (`id`, `nombre`, `cliente`, `categoria`, `encargado`, `status`, `cronograma`) "
                        + "VALUES (NULL, ?, ?, '" + categoria + "', ?, 'por_hacer', NULL);";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, txtNombre.getText());
                ps.setString(2, cbxCliente.getSelectedItem().toString());
                ps.setString(3, cbxEncargado.getSelectedItem().toString());

                ps.executeUpdate();
                limpiarCampos();
                llenarTabla();
            } catch (SQLException ex) {
                Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_btnCrearProyectoActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int fila = jTable1.getSelectedRow();
        txtId.setText(Integer.toString((Integer) jTable1.getValueAt(fila, 0)));
        txtNombre.setText((String) jTable1.getValueAt(fila, 1));
        cbxCliente.setSelectedItem(jTable1.getValueAt(fila, 2));

        String categoria = ((String) jTable1.getValueAt(fila, 3));
        cbxEncargado.setSelectedItem(jTable1.getValueAt(fila, 4));
        String estado = ((String) jTable1.getValueAt(fila, 5));
        int cronograma = (Integer) jTable1.getValueAt(fila, 6);

        if (categoria.equals("pagina_web")) {
            radioPaginaWeb.setSelected(true);
        }
        if (categoria.equals("tienda_en_linea")) {
            radioTiendaLinea.setSelected(true);
        }
        if (categoria.equals("app_movil")) {
            radioApp.setSelected(true);
        }
        if (categoria.equals("app_movil_tienda")) {
            radioAppTienda.setSelected(true);
        }
        if (categoria.equals("redes_sociales")) {
            radioRedes.setSelected(true);
        }
        if (categoria.equals("google_ads")) {
            radioGoogle.setSelected(true);
        }
        if (categoria.equals("branding")) {
            radioBranding.setSelected(true);
        }
        if (categoria.equals("diseno")) {
            radioDiseno.setSelected(true);
        }

        if (estado.equals("terminado")) {
            radioTerminado.setSelected(true);
            btnCrearCrono.setEnabled(false);
            btnAbrirCrono.setEnabled(true);
        }
        if (estado.equals("en_proceso")) {
            radioProceso.setSelected(true);
            btnCrearCrono.setEnabled(false);
            btnAbrirCrono.setEnabled(true);
        }
        if (estado.equals("por_hacer")) {
            radioPorHacer.setSelected(true);
            btnCrearCrono.setEnabled(true);
            btnAbrirCrono.setEnabled(false);

        }

        if (cronograma == 0) {
            btnCrearCrono.setEnabled(true);
            btnAbrirCrono.setEnabled(false);
        } else {
            btnCrearCrono.setEnabled(false);
            btnAbrirCrono.setEnabled(true);
        }

        btnModificar.setEnabled(true);
        btnCrearProyecto.setEnabled(false);

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //int idProyecto = Integer.parseInt(txtId.getText());
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "UPDATE `proyecto` SET `nombre` = ?, `cliente` = ?, `encargado`= ? WHERE `proyecto`.`id` = ?; ";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, txtNombre.getText());
            ps.setString(2, cbxCliente.getSelectedItem().toString());
            ps.setString(3, cbxEncargado.getSelectedItem().toString());
            ps.setString(4, txtId.getText());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "UPDATE `proyecto` SET `encargado` = ? WHERE `proyecto`.`id` = ?; ";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, cbxCliente.getSelectedItem().toString());
            ps.setString(2, txtId.getText());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "UPDATE `proyecto` SET `cliente` = ? WHERE `proyecto`.`id` = ?; ";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, cbxEncargado.getSelectedItem().toString());
            ps.setString(2, txtId.getText());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (radioTerminado.isSelected() == true) {
            try {
                Connection con = ConnectDB.getConnection();
                String sql = "UPDATE `proyecto` SET `status` = 'terminado' WHERE `proyecto`.`id` = ?; ";
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
                String sql = "UPDATE `proyecto` SET `status` = 'en_proceso' WHERE `proyecto`.`id` = ?; ";
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
                String sql = "UPDATE `proyecto` SET `status` = 'por_hacer' WHERE `proyecto`.`id` = ?; ";
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

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCrearCronoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCronoActionPerformed
        int idProyecto = (Integer.parseInt(txtId.getText()));
        String nombreTabla = "crono_proyecto_" + idProyecto;
        try {
            Connection con = ConnectDB.getConnection();
            String sql = "CREATE TABLE `legrafica`.`" + nombreTabla + "` ( `id` INT(11)"
                    + " NOT NULL AUTO_INCREMENT , `etapa` VARCHAR(50) NOT NULL , "
                    + "`fecha_inicio` VARCHAR(20) NOT NULL , `fecha_termino` VARCHAR(20) "
                    + "NOT NULL , `status` ENUM('terminado','en_proceso','por_hacer') "
                    + "NOT NULL , `encargado` VARCHAR(50) NOT NULL , PRIMARY KEY (`id`)) "
                    + "ENGINE = InnoDB;";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        FasesAdmin fases = new FasesAdmin();
        fases.idProyecto = idProyecto;
        fases.setVisible(true);

        try {
            Connection con = ConnectDB.getConnection();
            String sql = "UPDATE `proyecto` SET `cronograma` = ? WHERE `proyecto`.`id` = ?;  ";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, Integer.toString(idProyecto));
            ps.setString(2, Integer.toString(idProyecto));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnCrearCronoActionPerformed

    private void btnAbrirCronoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirCronoActionPerformed
        int idProyecto = (Integer.parseInt(txtId.getText()));
        FasesAdmin fases = new FasesAdmin();
        fases.idProyecto = idProyecto;
        fases.setVisible(true);

    }//GEN-LAST:event_btnAbrirCronoActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void jTable1usuarioSelecionado(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1usuarioSelecionado
        btnSeleccionar.setEnabled(true);
    }//GEN-LAST:event_jTable1usuarioSelecionado

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
            java.util.logging.Logger.getLogger(ProyectosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProyectosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProyectosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProyectosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProyectosAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirCrono;
    private javax.swing.JButton btnCrearCrono;
    private javax.swing.JButton btnCrearProyecto;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbxCliente;
    private javax.swing.JComboBox<String> cbxEncargado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radioApp;
    private javax.swing.JRadioButton radioAppTienda;
    private javax.swing.JRadioButton radioBranding;
    private javax.swing.JRadioButton radioDiseno;
    private javax.swing.JRadioButton radioGoogle;
    private javax.swing.JRadioButton radioPaginaWeb;
    private javax.swing.JRadioButton radioPorHacer;
    private javax.swing.JRadioButton radioProceso;
    private javax.swing.JRadioButton radioRedes;
    private javax.swing.JRadioButton radioTerminado;
    private javax.swing.JRadioButton radioTiendaLinea;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
