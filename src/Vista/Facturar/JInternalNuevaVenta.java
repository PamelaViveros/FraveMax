/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Facturar;

import java.awt.Dimension;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author chexs
 */
public class JInternalNuevaVenta extends javax.swing.JInternalFrame {

    
    public JInternalNuevaVenta() {
        initComponents();
        
        this.setSize(new Dimension(800, 600));
        this.setTitle("Facturacion - Nueva Venta");
        
        ImageIcon wallpaper = new ImageIcon("src/Imag/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(800, 600, WIDTH));
        jLabel_Wallpaper.setIcon(icono);
        this.repaint();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCB_Cliente = new javax.swing.JComboBox<>();
        jCB_producto = new javax.swing.JComboBox<>();
        jtxtCilente_busqueda = new javax.swing.JTextField();
        jtxt_Cantidad = new javax.swing.JTextField();
        jBut_buscaCliente = new javax.swing.JButton();
        jBut_buscaCliente1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtxt_Subtotal = new javax.swing.JTextField();
        jtxt_Descuento = new javax.swing.JTextField();
        jtxt_Total_A_Pagar = new javax.swing.JTextField();
        jtxt_Efectivo = new javax.swing.JTextField();
        jtxt_Cambio = new javax.swing.JTextField();
        jBut_CalcularCambio = new javax.swing.JButton();
        jBut_Cobrar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Facturación - Nueva Venta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 90, 70, -1));

        jCB_Cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCB_Cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione cliente:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jCB_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 55, 200, -1));

        jCB_producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCB_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione producto:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jCB_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 85, 200, -1));

        jtxtCilente_busqueda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jtxtCilente_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 55, 150, -1));

        jtxt_Cantidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        getContentPane().add(jtxt_Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 85, 65, -1));

        jBut_buscaCliente.setBackground(new java.awt.Color(51, 204, 255));
        jBut_buscaCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBut_buscaCliente.setText("Buscar");
        jBut_buscaCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jBut_buscaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 55, 95, -1));

        jBut_buscaCliente1.setBackground(new java.awt.Color(0, 153, 51));
        jBut_buscaCliente1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBut_buscaCliente1.setText("Agregar Producto");
        jBut_buscaCliente1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jBut_buscaCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 88, 165, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_Productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 750, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 770, 220));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 102, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Subtotal:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Descuento:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Total a Pagar:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Efectivo:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 125, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Cambio:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jtxt_Subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_Subtotal.setEnabled(false);
        jPanel2.add(jtxt_Subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 15, 160, -1));

        jtxt_Descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_Descuento.setEnabled(false);
        jPanel2.add(jtxt_Descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 45, 160, -1));

        jtxt_Total_A_Pagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_Total_A_Pagar.setEnabled(false);
        jPanel2.add(jtxt_Total_A_Pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 75, 160, -1));

        jtxt_Efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(jtxt_Efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 150, -1));

        jtxt_Cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_Cambio.setEnabled(false);
        jPanel2.add(jtxt_Cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 155, 150, -1));

        jBut_CalcularCambio.setBackground(new java.awt.Color(255, 51, 51));
        jBut_CalcularCambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBut_CalcularCambio.setForeground(new java.awt.Color(204, 204, 204));
        jBut_CalcularCambio.setText("Cambio $");
        jBut_CalcularCambio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jBut_CalcularCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 100, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 400, 200));

        jBut_Cobrar.setBackground(new java.awt.Color(204, 204, 204));
        jBut_Cobrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBut_Cobrar.setForeground(new java.awt.Color(0, 0, 153));
        jBut_Cobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/ImpresoraImg.png"))); // NOI18N
        jBut_Cobrar.setText("Cobrar");
        jBut_Cobrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBut_Cobrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBut_Cobrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jBut_Cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 135, 130));
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBut_CalcularCambio;
    private javax.swing.JButton jBut_Cobrar;
    private javax.swing.JButton jBut_buscaCliente;
    private javax.swing.JButton jBut_buscaCliente1;
    private javax.swing.JComboBox<String> jCB_Cliente;
    private javax.swing.JComboBox<String> jCB_producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_Productos;
    private javax.swing.JTextField jtxtCilente_busqueda;
    private javax.swing.JTextField jtxt_Cambio;
    private javax.swing.JTextField jtxt_Cantidad;
    private javax.swing.JTextField jtxt_Descuento;
    private javax.swing.JTextField jtxt_Efectivo;
    private javax.swing.JTextField jtxt_Subtotal;
    private javax.swing.JTextField jtxt_Total_A_Pagar;
    // End of variables declaration//GEN-END:variables
}
