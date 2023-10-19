/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Facturar;

import AccesoADatos.Conexion;
import Entidades.DetalleVenta;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author chexs
 */
public class JInternalNuevaVenta extends javax.swing.JInternalFrame {

    private DefaultTableModel modeloTabla;
    
    //Lista para detalle de venta productos
    ArrayList<DetalleVenta> listaProductos = new ArrayList<>();
    private DetalleVenta producto;
    
    private int id_Producto = 0;
    private String nombre = "";
    private int cantidadProducto_BD = 0;
    private double precioUnitario = 0.0;
    
    private int cantidad = 0;   //Cantidad a comp
    private double subtotal = 0.0; 
    private double descuento = 0.0;
    private double totalPagar = 0.0;
    
    private int auxIdDetalleVent = 1;
    
    public JInternalNuevaVenta() {
        initComponents();
        
        this.setSize(new Dimension(800, 600));
        this.setTitle("Facturacion - Nueva Venta");
        
        this.cargarCBCliente();
        this.cargarCBProductos();
        
        this.cargarTablaProducto();
        
        ImageIcon wallpaper = new ImageIcon("src/Imag/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(800, 600, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();
        
    }
    
    private void cargarTablaProducto(){
        
        modeloTabla = new DefaultTableModel();
        
        modeloTabla.addColumn("N°");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Cantidad");      
        modeloTabla.addColumn("Stock");
        modeloTabla.addColumn("P. Unitario");
        modeloTabla.addColumn("SubTotal");
        modeloTabla.addColumn("Descuento");
        modeloTabla.addColumn("Total Pagar");
        modeloTabla.addColumn("Eliminar");
        
        this.jTable_Productos.setModel(modeloTabla);
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
        jBut_AgregProd = new javax.swing.JButton();
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
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Facturación - Nueva Venta");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 60, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 90, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
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
        jBut_buscaCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBut_buscaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_buscaClienteActionPerformed(evt);
            }
        });
        getContentPane().add(jBut_buscaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 55, 95, 25));

        jBut_AgregProd.setBackground(new java.awt.Color(0, 102, 0));
        jBut_AgregProd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBut_AgregProd.setForeground(new java.awt.Color(255, 255, 255));
        jBut_AgregProd.setText("Agregar Producto");
        jBut_AgregProd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBut_AgregProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_AgregProdActionPerformed(evt);
            }
        });
        getContentPane().add(jBut_AgregProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 88, 165, 25));

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
        jBut_CalcularCambio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(jBut_CalcularCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 100, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 400, 200));

        jBut_Cobrar.setBackground(new java.awt.Color(204, 204, 204));
        jBut_Cobrar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBut_Cobrar.setForeground(new java.awt.Color(0, 0, 153));
        jBut_Cobrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/ImpresoraImg.png"))); // NOI18N
        jBut_Cobrar.setText("Cobrar");
        jBut_Cobrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBut_Cobrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBut_Cobrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jBut_Cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 135, 130));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBut_buscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_buscaClienteActionPerformed
        
        String Cliente_a_Buscar = jtxtCilente_busqueda.getText().trim();
        Connection con = Conexion.getConexion();
        String sql = "SELECT Apellido, Nombre FROM Cliente WHERE Dni = '"+ Cliente_a_Buscar +"' ";
        Statement st;
        
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                
                jCB_Cliente.setSelectedItem(rs.getString("Apellido") + "" + rs.getString("Nombre"));
                            
            } else{
                jCB_Cliente.setSelectedItem("Seleccione Cliente:");
                JOptionPane.showMessageDialog(null, "DNI no encontrado ó Cliente no Registrado");
            }
            
            jtxtCilente_busqueda.setText("");
            con.close();
        } catch (Exception e) {
            System.out.println("Error al buscar Cliente: " + e);
        }
        
    }//GEN-LAST:event_jBut_buscaClienteActionPerformed

    private void jBut_AgregProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_AgregProdActionPerformed
        
        String combo = this.jCB_producto.getSelectedItem().toString();
        
        //validacion de seleccion
        if (combo.equalsIgnoreCase("Seleccione Producto!!")){
        
            JOptionPane.showMessageDialog(null, "Seleccione un Producto");
            
        } else {
            //validar una cantidad
            if(!jtxt_Cantidad.getText().isEmpty()){
                //validar q ingreso caracteres num
                boolean val = validar(jtxt_Cantidad.getText());
                if (val == true){
                    //valido cantidad mayor a cero
                    if (Integer.parseInt(jtxt_Cantidad.getText()) > 0){
                        cantidad = Integer.parseInt(jtxt_Cantidad.getText());
                        
                        this.datosDeProducto();
                        //Validar cantida no mayor al stock
                        if (cantidad <= cantidadProducto_BD) {
                            
                            subtotal = precioUnitario * cantidad;
                            subtotal = (double) Math.round(subtotal * 100) / 100;
                            totalPagar = subtotal + descuento;
                            descuento = (double) Math.round(descuento * 100) / 100;
                            totalPagar = (double) Math.round(totalPagar * 100) / 100;
                            
                            //nuevo producto
                            producto = new DetalleVenta(auxIdDetalleVent,
                                1,
                                id_Producto,
                                nombre,
                                Integer.parseInt(jtxt_Cantidad.getText()),
                                precioUnitario,
                                subtotal,
                                descuento,
                                totalPagar,
                                1
                            );
                            
                            listaProductos.add(producto);
                            JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
                            auxIdDetalleVent++;
                            jtxt_Cambio.setText("");
                            
                            this.cargarCBProductos();
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "Cantidad superior al Stock");
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese una Cantidad mayor a 0");  
                    }
                              
                } else{
                    JOptionPane.showMessageDialog(null, "Ingrese un caracter numerico en Cantidad");
                }
                
            } else{
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad a cargar");
            }
            
            
        }
    }//GEN-LAST:event_jBut_AgregProdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBut_AgregProd;
    private javax.swing.JButton jBut_CalcularCambio;
    private javax.swing.JButton jBut_Cobrar;
    private javax.swing.JButton jBut_buscaCliente;
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
    private javax.swing.JLabel jLabel_wallpaper;
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

    
    //Cargar clientes en combobox
    
    private void cargarCBCliente(){
    
        Connection con = Conexion.getConexion();
        String sql =  "SELECT * FROM `Cliente`";
        Statement st;
        
        try {
            
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jCB_Cliente.removeAllItems();
            jCB_Cliente.addItem("Seleccione Cliente:");
            
            while (rs.next()){
                
                jCB_Cliente.addItem(rs.getString("Apellido") + "" + rs.getString("Nombre"));
            
            }
            con.close();
            
        } catch (SQLException e) {
            System.out.println("Error al cargar Clientes " + e);
        }
    
    }
    
    private void cargarCBProductos(){
    
        Connection con = Conexion.getConexion();
        String sql =  "SELECT * FROM Producto";
        Statement st;
        
        try {
            
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jCB_producto.removeAllItems();
            jCB_producto.addItem("Seleccione Producto:");
            
            while (rs.next()){
                
                jCB_producto.addItem(rs.getString("NombreProducto"));
            
            }
            con.close();
            
        } catch (SQLException e) {
            System.out.println("Error al cargar Producto " + e);
        }
    
    }

    private boolean validar(String valor){
        
        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
       
    }
    
    private void datosDeProducto(){
        
        try {
            
            String sql = "SELECT * FROM Producto WHERE NombreProducto = '"+ this.jCB_producto.getSelectedItem() +"'";
            Connection con = Conexion.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("NombreProducto");
                cantidadProducto_BD = rs.getInt("Stock");
                precioUnitario = rs.getDouble("PrecioActual");
            
            }
            
            
        } catch (SQLException e) {
            System.out.println("Error al obtener datos del producto");
        }
    
    }
    
}