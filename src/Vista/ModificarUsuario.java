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

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(26, 56, 48));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificando usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 6, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Apellido");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 55, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 101, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contraseña");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 147, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Confirme contraseña");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 193, 130, -1));

        tApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tApellidoKeyPressed(evt);
            }
        });
        jPanel1.add(tApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 48, 170, 30));

        tNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tNombreKeyPressed(evt);
            }
        });
        jPanel1.add(tNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 94, 170, 30));

        bSalir.setBackground(new java.awt.Color(153, 0, 0));
        bSalir.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        bSalir.setForeground(new java.awt.Color(255, 255, 255));
        bSalir.setText("Salir");
        bSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });
        jPanel1.add(bSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 80, 30));

        bGuardar.setBackground(new java.awt.Color(51, 153, 0));
        bGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bGuardar.setText("Guardar");
        bGuardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(bGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 80, 30));

        tPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tPassKeyPressed(evt);
            }
        });
        jPanel1.add(tPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 170, 30));

        tCpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tCpassKeyPressed(evt);
            }
        });
        jPanel1.add(tCpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 186, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 300));

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
