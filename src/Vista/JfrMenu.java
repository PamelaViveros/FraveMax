
package Vista;

import Vista.Facturar.NuevaVenta;
import Vista.Facturar.NuevoCliente;
import Vista.Producto.GestionProductos;
import Vista.Producto.NuevoProducto;
import Vista.ReporteDeVentas.PorProducto;
import Vista.ReporteDeVentas.PorFecha;
import Vista.ReporteDeVentas.PorCliente;
import Vista.ReporteDeVentas.PorUsuario;
import java.awt.Dimension;

/**
 *
 * @author chexs
 */
public class JfrMenu extends javax.swing.JFrame {

    
    public JfrMenu() {
        initComponents();
        this.setSize(new Dimension(1050,600));
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("SISTEMA DE VENTAS");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmItem4_nuevo_usuario = new javax.swing.JMenuItem();
        jmItem5_gestinar_usuarios = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6_nuevo_cliente = new javax.swing.JMenuItem();
        jMenuItem7_gest_clientes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu8_buscar_ventas = new javax.swing.JMenu();
        jMenuItem1_buscar_por_cliente = new javax.swing.JMenuItem();
        jMenuItem2_buscar_por_producto = new javax.swing.JMenuItem();
        jMenuItem3_buscar_por_fecha = new javax.swing.JMenuItem();
        jMenuItem10_buscar_por_usuario = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8_nuevo_producto = new javax.swing.JMenuItem();
        jMenuItem9_gest_producto = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11_nueva_venta = new javax.swing.JMenuItem();
        jMenuItem12_gest_venta = new javax.swing.JMenuItem();
        jMenu6_historial = new javax.swing.JMenu();
        jMenu7_cerrar_sesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 550));

        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/usuario.png"))); // NOI18N
        jMenu1.setText("Usuario");
        jMenu1.setToolTipText("");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(130, 50));

        jmItem4_nuevo_usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jmItem4_nuevo_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/nuevo.png"))); // NOI18N
        jmItem4_nuevo_usuario.setText("Nuevo Usuario");
        jMenu1.add(jmItem4_nuevo_usuario);

        jmItem5_gestinar_usuarios.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jmItem5_gestinar_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/configuraciones.png"))); // NOI18N
        jmItem5_gestinar_usuarios.setText("Gestionar Usuarios");
        jMenu1.add(jmItem5_gestinar_usuarios);

        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/cliente.png"))); // NOI18N
        jMenu2.setText("Cliente");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem6_nuevo_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem6_nuevo_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/nuevo-cliente.png"))); // NOI18N
        jMenuItem6_nuevo_cliente.setText("Nuevo Cliente");
        jMenuItem6_nuevo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6_nuevo_clienteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6_nuevo_cliente);

        jMenuItem7_gest_clientes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem7_gest_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/configuraciones.png"))); // NOI18N
        jMenuItem7_gest_clientes.setText("Gestionar Clientes");
        jMenu2.add(jMenuItem7_gest_clientes);

        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/reportes.png"))); // NOI18N
        jMenu3.setText("Reporte de Ventas");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(175, 50));

        jMenu8_buscar_ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/reporte1.png"))); // NOI18N
        jMenu8_buscar_ventas.setText("Buscar Ventas");
        jMenu8_buscar_ventas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem1_buscar_por_cliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem1_buscar_por_cliente.setText("Por Cliente");
        jMenuItem1_buscar_por_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1_buscar_por_clienteActionPerformed(evt);
            }
        });
        jMenu8_buscar_ventas.add(jMenuItem1_buscar_por_cliente);

        jMenuItem2_buscar_por_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem2_buscar_por_producto.setText("Por Producto");
        jMenuItem2_buscar_por_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2_buscar_por_productoActionPerformed(evt);
            }
        });
        jMenu8_buscar_ventas.add(jMenuItem2_buscar_por_producto);

        jMenuItem3_buscar_por_fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem3_buscar_por_fecha.setText("Por Fecha");
        jMenuItem3_buscar_por_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3_buscar_por_fechaActionPerformed(evt);
            }
        });
        jMenu8_buscar_ventas.add(jMenuItem3_buscar_por_fecha);

        jMenuItem10_buscar_por_usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem10_buscar_por_usuario.setText("Por Usuario");
        jMenuItem10_buscar_por_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10_buscar_por_usuarioActionPerformed(evt);
            }
        });
        jMenu8_buscar_ventas.add(jMenuItem10_buscar_por_usuario);

        jMenu3.add(jMenu8_buscar_ventas);

        jMenuBar1.add(jMenu3);

        jMenu4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/producto.png"))); // NOI18N
        jMenu4.setText("Producto");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem8_nuevo_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem8_nuevo_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/nuevo-producto.png"))); // NOI18N
        jMenuItem8_nuevo_producto.setText("Nuevo Producto");
        jMenuItem8_nuevo_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8_nuevo_productoActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8_nuevo_producto);

        jMenuItem9_gest_producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem9_gest_producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/configuraciones.png"))); // NOI18N
        jMenuItem9_gest_producto.setText("Gestionar Productos");
        jMenuItem9_gest_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9_gest_productoActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9_gest_producto);

        jMenuBar1.add(jMenu4);

        jMenu5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/carrito.png"))); // NOI18N
        jMenu5.setText("Facturar");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(150, 50));

        jMenuItem11_nueva_venta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem11_nueva_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/anadir.png"))); // NOI18N
        jMenuItem11_nueva_venta.setText("Nueva Venta");
        jMenuItem11_nueva_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11_nueva_ventaActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11_nueva_venta);

        jMenuItem12_gest_venta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jMenuItem12_gest_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/configuraciones.png"))); // NOI18N
        jMenuItem12_gest_venta.setText("Gestionar Ventas");
        jMenu5.add(jMenuItem12_gest_venta);

        jMenuBar1.add(jMenu5);

        jMenu6_historial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu6_historial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/historial1.png"))); // NOI18N
        jMenu6_historial.setText("Historial");
        jMenu6_historial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu6_historial.setPreferredSize(new java.awt.Dimension(150, 50));
        jMenuBar1.add(jMenu6_historial);

        jMenu7_cerrar_sesion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu7_cerrar_sesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/cerrar-sesion.png"))); // NOI18N
        jMenu7_cerrar_sesion.setText("Cerrar Sesión");
        jMenu7_cerrar_sesion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jMenu7_cerrar_sesion.setPreferredSize(new java.awt.Dimension(160, 30));
        jMenu7_cerrar_sesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7_cerrar_sesionMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7_cerrar_sesion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1_buscar_por_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1_buscar_por_clienteActionPerformed
        PorCliente pc = new PorCliente();
        
        Fondo.removeAll();
        Fondo.repaint();
         pc.setVisible(true);
        Fondo.add(pc);
    }//GEN-LAST:event_jMenuItem1_buscar_por_clienteActionPerformed

    private void jMenuItem2_buscar_por_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2_buscar_por_productoActionPerformed
        PorProducto pp = new PorProducto();
        
        Fondo.removeAll();
        Fondo.repaint();
         pp.setVisible(true);
        Fondo.add(pp);
    }//GEN-LAST:event_jMenuItem2_buscar_por_productoActionPerformed

    private void jMenuItem3_buscar_por_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3_buscar_por_fechaActionPerformed
         PorFecha pf = new PorFecha();
        
        Fondo.removeAll();
        Fondo.repaint();
         pf.setVisible(true);
        Fondo.add(pf);
    }//GEN-LAST:event_jMenuItem3_buscar_por_fechaActionPerformed

    private void jMenu7_cerrar_sesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7_cerrar_sesionMouseClicked
        
    }//GEN-LAST:event_jMenu7_cerrar_sesionMouseClicked

    private void jMenuItem10_buscar_por_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10_buscar_por_usuarioActionPerformed
        PorUsuario pu = new PorUsuario();
        
        Fondo.removeAll();
        Fondo.repaint();
         pu.setVisible(true);
        Fondo.add(pu);
    }//GEN-LAST:event_jMenuItem10_buscar_por_usuarioActionPerformed

    private void jMenuItem11_nueva_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11_nueva_ventaActionPerformed
        NuevaVenta nuevaVenta = new NuevaVenta();
        
         Fondo.removeAll();
        Fondo.repaint();
         nuevaVenta.setVisible(true);
        Fondo.add(nuevaVenta);
    }//GEN-LAST:event_jMenuItem11_nueva_ventaActionPerformed

    private void jMenuItem6_nuevo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6_nuevo_clienteActionPerformed
        NuevoCliente nuevoCliente = new NuevoCliente();
         Fondo.removeAll();
        Fondo.repaint();
        nuevoCliente.setVisible(true);
        Fondo.add(nuevoCliente);
    }//GEN-LAST:event_jMenuItem6_nuevo_clienteActionPerformed

    private void jMenuItem8_nuevo_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8_nuevo_productoActionPerformed
        NuevoProducto nuevoProducto = new NuevoProducto();
        
        Fondo.removeAll();
        Fondo.repaint();
        nuevoProducto.setVisible(true);
        Fondo.add(nuevoProducto);
    }//GEN-LAST:event_jMenuItem8_nuevo_productoActionPerformed

    private void jMenuItem9_gest_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9_gest_productoActionPerformed
        GestionProductos gestionProductos = new GestionProductos();
        
        Fondo.removeAll();
        Fondo.repaint();
        gestionProductos.setVisible(true);
        Fondo.add(gestionProductos);
    }//GEN-LAST:event_jMenuItem9_gest_productoActionPerformed

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
            java.util.logging.Logger.getLogger(JfrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JfrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JfrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JfrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel Fondo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6_historial;
    private javax.swing.JMenu jMenu7_cerrar_sesion;
    private javax.swing.JMenu jMenu8_buscar_ventas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10_buscar_por_usuario;
    private javax.swing.JMenuItem jMenuItem11_nueva_venta;
    private javax.swing.JMenuItem jMenuItem12_gest_venta;
    private javax.swing.JMenuItem jMenuItem1_buscar_por_cliente;
    private javax.swing.JMenuItem jMenuItem2_buscar_por_producto;
    private javax.swing.JMenuItem jMenuItem3_buscar_por_fecha;
    private javax.swing.JMenuItem jMenuItem6_nuevo_cliente;
    private javax.swing.JMenuItem jMenuItem7_gest_clientes;
    private javax.swing.JMenuItem jMenuItem8_nuevo_producto;
    private javax.swing.JMenuItem jMenuItem9_gest_producto;
    private javax.swing.JMenuItem jmItem4_nuevo_usuario;
    private javax.swing.JMenuItem jmItem5_gestinar_usuarios;
    // End of variables declaration//GEN-END:variables
}
