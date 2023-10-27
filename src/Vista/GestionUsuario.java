/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import AccesoADatos.UsuarioData;
import static AccesoADatos.UsuarioData.usuarios;
import Entidades.Usuario;
import static Vista.JfrMenu1.jDesktopPaneMenu;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaming
 */
public class GestionUsuario extends javax.swing.JInternalFrame {

    UsuarioData uData;
    /**
     * Creates new form GestionUsuario
     */
    public GestionUsuario() throws SQLException {
        this.uData = new UsuarioData();
        initComponents();
         
         cargaCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbUsuarios = new javax.swing.JComboBox<>();
        bEliminar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bSalir = new javax.swing.JButton();

        jLabel1.setText("Gestion de Usuarios");

        jLabel2.setText("Seleccione un usuario");

        jcbUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbUsuariosActionPerformed(evt);
            }
        });

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        bModificar.setText("Modificar");
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        bSalir.setText("Salir");
        bSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bEliminar)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(bModificar)
                        .addGap(60, 60, 60)
                        .addComponent(bSalir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bEliminar, bModificar, bSalir});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEliminar)
                    .addComponent(bModificar)
                    .addComponent(bSalir))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbUsuariosActionPerformed
       
    }//GEN-LAST:event_jcbUsuariosActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        Usuario u=(Usuario)jcbUsuarios.getSelectedItem();
        ModificarUsuario mUsuario =null;
        try {
         mUsuario =   new ModificarUsuario(u);
         this.dispose();
        } catch (Exception e) {
        }

        jDesktopPaneMenu.add(mUsuario);
        
        mUsuario.setVisible(true);
    }//GEN-LAST:event_bModificarActionPerformed

    private void bSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSalirActionPerformed
      this.dispose();
    }//GEN-LAST:event_bSalirActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
       
        Usuario u=(Usuario)jcbUsuarios.getSelectedItem();
       int returnValue = 0;
    	returnValue = JOptionPane.showConfirmDialog(null, "Eliminar usuario?", "Confirme la eliminacion de usuario ",JOptionPane.YES_NO_OPTION);
    		
    	if (returnValue == JOptionPane.YES_OPTION)
    		 uData.eliminarUsuario(u.getIdUsuario());
        
    	else if (returnValue == JOptionPane.NO_OPTION)
    		JOptionPane.showMessageDialog(null, "No se elimino el usuario");
       
        cargaCombo();
        
    }//GEN-LAST:event_bEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<Usuario> jcbUsuarios;
    // End of variables declaration//GEN-END:variables

public void cargaCombo(){
    uData.listarUsuarios();
    for (Usuario usuario : usuarios) {
        jcbUsuarios.addItem(usuario);
    }
    usuarios.clear();
}



}