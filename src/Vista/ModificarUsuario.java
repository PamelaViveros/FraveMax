/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import AccesoADatos.UsuarioData;
import Entidades.Usuario;
import static Vista.JfrMenu1.jDesktopPaneMenu;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaming
 */
public class ModificarUsuario extends javax.swing.JInternalFrame {

    Usuario u;
    UsuarioData uData;

    /**
     * Creates new form ModificarUsuario
     */
    public ModificarUsuario(Usuario u) throws SQLException {
        this.uData = new UsuarioData();
        this.u = u;
        initComponents();
        tApellido.setText(u.getApellido());
        tNombre.setText(u.getNombre());
        
        tPass.setText("");
        tCpass.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tApellido = new javax.swing.JTextField();
        tNombre = new javax.swing.JTextField();
        bSalir = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        tPass = new javax.swing.JPasswordField();
        tCpass = new javax.swing.JPasswordField();

        jPanel1.setBackground(new java.awt.Color(26, 56, 48));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Modificando usuario");

        jLabel2.setText("Apellido");

        jLabel3.setText("Nombre");

        jLabel4.setText("Contraseña");

        jLabel5.setText("Confirme contraseña");

        tApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tApellidoKeyPressed(evt);
            }
        });

        tNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tNombreKeyPressed(evt);
            }
        });

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        tPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tPassKeyPressed(evt);
            }
        });

        tCpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCpassKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(bSalir)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tNombre)
                            .addComponent(tApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(tPass)
                            .addComponent(tCpass))
                        .addGap(42, 42, 42))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addGap(0, 102, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bGuardar, bSalir});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tCpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSalir)
                    .addComponent(bGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tApellidoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            tNombre.requestFocus();
        }
    }//GEN-LAST:event_tApellidoKeyPressed

    private void tNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tNombreKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            tPass.requestFocus();
        }
    }//GEN-LAST:event_tNombreKeyPressed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
        ModificarUsuario mUsuario = null;
        try {
            new ModificarUsuario(u);
            this.dispose();
        } catch (Exception e) {
        }

        jDesktopPaneMenu.add(mUsuario);
        mUsuario.setVisible(true);
    }//GEN-LAST:event_bSalirActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed

        guardarModificacion();
    }//GEN-LAST:event_bGuardarActionPerformed

    private void tPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPassKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            tCpass.requestFocus();
            tCpass.selectAll();
        }
    }//GEN-LAST:event_tPassKeyPressed

    private void tCpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCpassKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            guardarModificacion();
        }
    }//GEN-LAST:event_tCpassKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tApellido;
    private javax.swing.JPasswordField tCpass;
    private javax.swing.JTextField tNombre;
    private javax.swing.JPasswordField tPass;
    // End of variables declaration//GEN-END:variables

    public boolean guardarModificacion() {
        boolean resp = false;
        String apellido = tApellido.getText().trim();
        String nombre = tNombre.getText().trim();
        
        String pass = tPass.getText().trim();
        String cPass = tCpass.getText().trim();

        if (apellido.isEmpty() || nombre.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, complete todos los campos");
        } else {
           
            if (!cPass.equals(pass) ) {
                tPass.setBackground(Color.red);
                tCpass.setBackground(Color.red);
                JOptionPane.showMessageDialog(rootPane, "Las contraseñas no coinciden");
                tPass.requestFocus();
                tPass.selectAll();
                tPass.setBackground(Color.white);
                tCpass.setBackground(Color.white);

            } else {
                u.setApellido(apellido);
                u.setNombre(nombre);
                u.setPassword(pass);
                if (uData.buscarUsuario(u.getApellido(), u.getNombre(), u.getPassword()) == false) {
                    JOptionPane.showMessageDialog(rootPane, "El nombre de usuario no esta disponible");

                } else {
                    if (uData.modificarUsuario(u)) {
                        tApellido.setBackground(Color.green);
                        tNombre.setBackground(Color.green);
                        tPass.setBackground(Color.green);
                        tCpass.setBackground(Color.green);
                    }
                }
            }
        }
        return resp;
    }

}