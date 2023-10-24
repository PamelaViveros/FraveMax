/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Facturar;

import AccesoADatos.Conexion;
import AccesoADatos.DetalleVentaData;
import AccesoADatos.VentaData;
import Entidades.DetalleVenta;
import Entidades.Venta;
import Vista.JfrmLogin;
import com.sun.jndi.cosnaming.CNCtx;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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

    private int idCliente = 0; // Cliente Seleccionado
    private int idUsuario = 0; // Usuario logeado
    private String nom_vendedor = "";
    
    private int id_Producto = 0;
    private String nombre = "";
    private int cantidadProducto_BD = 0;
    private double precioUnitario = 0.0;

    private int cantidad = 0;   //Cantidad a comp
    private double subtotal = 0.0;
    private double descuento = 0.0;
    private double totalPagar = 0.0;

    //variales para calculo
    private double subtotalFinal = 0.0;
    private double descuentoFinal = 0.0;
    private double totalPagarFinal = 0.0;

    private int auxIdDetalleVent = 1;

    private int idArrayList = 0;

    public JInternalNuevaVenta() throws SQLException {
        initComponents();

        this.setSize(new Dimension(800, 600));
        this.setTitle("Facturacion - Nueva Venta");

        this.cargarCBCliente();
        this.cargarCBProductos();

        this.cargarTablaProducto();

        jtxt_efectivo.setEnabled(false);
        jBut_CalcularCambio.setEnabled(false);
        
        jtxt_vendedor = new JTextField();
        jtxt_subTotal.setText("00000.0");
        jtxt_descuento.setText("00000.0");
        jtxt_total_A_Pagar.setText("00000.0");
        
        ImageIcon wallpaper = new ImageIcon("src/Imag/fondo3.jpg");
        Icon icono = new ImageIcon(wallpaper.getImage().getScaledInstance(800, 600, WIDTH));
        jLabel_wallpaper.setIcon(icono);
        this.repaint();

    }

    private void cargarTablaProducto() {

        modeloTabla = new DefaultTableModel();

        modeloTabla.addColumn("N°");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("P. Unitario");
        modeloTabla.addColumn("SubTotal");
        modeloTabla.addColumn("Descuento");
        modeloTabla.addColumn("Total Pagar");
        modeloTabla.addColumn("Eliminar");

        this.jTable_Productos.setModel(modeloTabla);
    }

    private void listaTablaProducto() {

        this.modeloTabla.setRowCount(listaProductos.size());
        for (int i = 0; i < listaProductos.size(); i++) {
            this.modeloTabla.setValueAt(i + 1, i, 0);
            this.modeloTabla.setValueAt(listaProductos.get(i).getNombre(), i, 1);
            this.modeloTabla.setValueAt(listaProductos.get(i).getCantidad(), i, 2);
            this.modeloTabla.setValueAt(listaProductos.get(i).getPrecioUnitario(), i, 3);
            this.modeloTabla.setValueAt(listaProductos.get(i).getSubTotal(), i, 4);
            this.modeloTabla.setValueAt(listaProductos.get(i).getDescuento(), i, 5);
            this.modeloTabla.setValueAt(listaProductos.get(i).getTotalPagar(), i, 6);
            this.modeloTabla.setValueAt("Eliminar", i, 7);//Boton de eliminar
        }
        jTable_Productos.setModel(modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCB_Cliente = new javax.swing.JComboBox<>();
        jCB_Producto = new javax.swing.JComboBox<>();
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
        jtxt_subTotal = new javax.swing.JTextField();
        jtxt_descuento = new javax.swing.JTextField();
        jtxt_total_A_Pagar = new javax.swing.JTextField();
        jtxt_efectivo = new javax.swing.JTextField();
        jtxt_cambio = new javax.swing.JTextField();
        jBut_CalcularCambio = new javax.swing.JButton();
        jBut_Cobrar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jtxt_vendedor = new javax.swing.JTextField();
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

        jCB_Producto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jCB_Producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Producto:", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jCB_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 85, 200, -1));

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
        jTable_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_ProductosMouseClicked(evt);
            }
        });
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

        jtxt_subTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_subTotal.setEnabled(false);
        jPanel2.add(jtxt_subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 15, 160, -1));

        jtxt_descuento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_descuento.setEnabled(false);
        jPanel2.add(jtxt_descuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 45, 160, -1));

        jtxt_total_A_Pagar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_total_A_Pagar.setEnabled(false);
        jPanel2.add(jtxt_total_A_Pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 75, 160, -1));

        jtxt_efectivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(jtxt_efectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 150, -1));

        jtxt_cambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_cambio.setEnabled(false);
        jPanel2.add(jtxt_cambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 155, 150, -1));

        jBut_CalcularCambio.setBackground(new java.awt.Color(255, 51, 51));
        jBut_CalcularCambio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBut_CalcularCambio.setForeground(new java.awt.Color(204, 204, 204));
        jBut_CalcularCambio.setText("Cambio $");
        jBut_CalcularCambio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jBut_CalcularCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_CalcularCambioActionPerformed(evt);
            }
        });
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
        jBut_Cobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBut_CobrarActionPerformed(evt);
            }
        });
        getContentPane().add(jBut_Cobrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 135, 130));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Vendedor:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jtxt_vendedor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxt_vendedor.setForeground(new java.awt.Color(102, 255, 204));
        jtxt_vendedor.setEnabled(false);
        getContentPane().add(jtxt_vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 150, -1));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBut_buscaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_buscaClienteActionPerformed

        String Cliente_a_Buscar = jtxtCilente_busqueda.getText().trim();
        Connection con = null;
        try {
            con = Conexion.getConexion();
        } catch (SQLException ex) {
            Logger.getLogger(JInternalNuevaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT Apellido, Nombre FROM `Cliente` WHERE Dni = '" + Cliente_a_Buscar + "' ";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {

                jCB_Cliente.setSelectedItem(rs.getString("Apellido") + " " + rs.getString("Nombre"));

            } else {
                jCB_Cliente.setSelectedItem("Seleccione Cliente:");
                JOptionPane.showMessageDialog(null, "DNI no encontrado ó Cliente no Registrado");
            }

            //jtxtCilente_busqueda.setText("");
            //con.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar Cliente: " + e);
        }

    }//GEN-LAST:event_jBut_buscaClienteActionPerformed

    private void jBut_AgregProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_AgregProdActionPerformed

        String combo = this.jCB_Producto.getSelectedItem().toString();

        //validacion de seleccion
        if (combo.equalsIgnoreCase("Seleccione Producto!!")) {

            JOptionPane.showMessageDialog(null, "Seleccione un Producto");

        } else {
            //validar una cantidad
            if (!jtxt_Cantidad.getText().isEmpty()) {
                //validar q ingreso caracteres num
                boolean val = validar(jtxt_Cantidad.getText());
                if (val == true) {
                    //valido cantidad mayor a cero
                    try {

                        cantidad = Integer.parseInt(jtxt_Cantidad.getText());
                                                                                                  
                        if (cantidad > 0) {

                            this.ObtenerDdatosDeProducto();

                            System.out.println("cantidad: " + cantidad);
                            System.out.println(id_Producto + " " + nombre);
                            //Validar cantida no mayor al stock
                            if (cantidad <= cantidadProducto_BD) {

                                subtotal = precioUnitario * cantidad;
                                totalPagar = subtotal + descuento;

                                subtotal = (double) Math.round(subtotal * 100) / 100;
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
                                jtxt_cambio.setText("");

                                this.cargarCBProductos();
                                this.calculoTotalPagar();
                                jtxt_efectivo.setEnabled(true);
                                jBut_CalcularCambio.setEnabled(true);

                            } else {
                                JOptionPane.showMessageDialog(null, "Cantidad superior al Stock");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese una Cantidad mayor a 0");
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");

                    } catch (SQLException ex) {
                        System.out.println("Error " + ex );
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un caracter numerico en Cantidad");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese la cantidad a cargar");
            }
        }
        this.listaTablaProducto();
    }//GEN-LAST:event_jBut_AgregProdActionPerformed

    private void jBut_CalcularCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_CalcularCambioActionPerformed

        if (!jtxt_efectivo.getText().isEmpty()) {
            //validacion numerica
            boolean val = validarDouble(jtxt_efectivo.getText());
            if (val == true) {
                //validacion mayor al total a pagar
                double efec = Double.parseDouble(jtxt_efectivo.getText().trim());
                double totpag = Double.parseDouble(jtxt_total_A_Pagar.getText());

                if (efec < totpag) {
                    JOptionPane.showMessageDialog(null, "Dinero ingresado insuficiente");
                } else {
                    double cambio = (efec - totpag);
                    double cambio2 = (double) Math.round(cambio * 100) / 100;
                    String cambioF = String.valueOf(cambio2);
                    jtxt_cambio.setText(cambioF);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese caranteres Numericos");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el Dinero a recibir");
        }
    }//GEN-LAST:event_jBut_CalcularCambioActionPerformed

    private void jTable_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_ProductosMouseClicked

        int filaP = jTable_Productos.rowAtPoint(evt.getPoint());
        int columnaP = 0; // id del producto en la tabla

        if (filaP > -1) {
            idArrayList = (int) modeloTabla.getValueAt(filaP, columnaP);
        }

        int op = JOptionPane.showConfirmDialog(null, "¿Eliminar Producto seleccionado?");
        // op captura un valor dependiendo de la resp (si = 0 ; no = 1 ; cancel = 2 ; close = -1)

        switch (op) {
            case 0: // Precionó SI
                listaProductos.remove(idArrayList - 1);
                this.calculoTotalPagar();
                this.listaTablaProducto();
                break;
            case 1: // precionó NO
                break;
            default: // precionó cancel ó close
                break;
        }

    }//GEN-LAST:event_jTable_ProductosMouseClicked

    private void jBut_CobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBut_CobrarActionPerformed
        DetalleVenta detalleVenta = new DetalleVenta();
        Venta venta = new Venta();      
        
        try {
            VentaData vData = new VentaData();
            DetalleVentaData dDetalleVentaData = new DetalleVentaData();
            
            String fecha_actual = "";
            Date date = new Date();
            fecha_actual = new SimpleDateFormat("yyyy/MM/dd").format(date);

            if(!jCB_Cliente.getSelectedItem().equals("Seleccione cliente:")){
                if (listaProductos.size() > 0) {
                    
                    this.obtenerIdClienteSeleccionado();
                    
                    venta.setIdVenta(0);
                    venta.setIdCliente(idCliente);
                    venta.setFechaVenta(LocalDate.parse(fecha_actual));
                    venta.setIdUsuario(idUsuario);
                    venta.setEstado(true);
                    
                    if (dDetalleVentaData.guardarDetalle(detalleVenta)) {
                        
                        JOptionPane.showMessageDialog(null, "¡Detalle Cargado exitosamente!");
                        for (DetalleVenta elem : listaProductos) {
                            detalleVenta.setIdDetalleVenta(0);
                            detalleVenta.setIdProducto(elem.getIdProducto());
                            detalleVenta.setCantidad(elem.getCantidad());
                            detalleVenta.setPrecioUnitario(elem.getPrecioUnitario());
                            detalleVenta.setSubTotal(elem.getSubTotal());
                            detalleVenta.setTotalPagar(elem.getTotalPagar());
                            detalleVenta.setEstado(1);
                        }
                    }else{
                       JOptionPane.showMessageDialog(null, "Error al guardar detalleVenta"); 
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "¡Antes debe seleccionar almenos un Producto!");
                }
            } else{
                JOptionPane.showMessageDialog(null, "¡Antes debe seleccionar un Cliente!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JInternalNuevaVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
                
          
    }//GEN-LAST:event_jBut_CobrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBut_AgregProd;
    private javax.swing.JButton jBut_CalcularCambio;
    private javax.swing.JButton jBut_Cobrar;
    private javax.swing.JButton jBut_buscaCliente;
    private javax.swing.JComboBox<String> jCB_Cliente;
    private javax.swing.JComboBox<String> jCB_Producto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField jtxt_Cantidad;
    private javax.swing.JTextField jtxt_cambio;
    private javax.swing.JTextField jtxt_descuento;
    private javax.swing.JTextField jtxt_efectivo;
    private javax.swing.JTextField jtxt_subTotal;
    private javax.swing.JTextField jtxt_total_A_Pagar;
    private javax.swing.JTextField jtxt_vendedor;
    // End of variables declaration//GEN-END:variables

    /*
    *Cargar clientes en combobox
    *
     */
    private void cargarCBCliente() throws SQLException {

        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM `Cliente`";
        Statement st;

        try {

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jCB_Cliente.removeAllItems();
            jCB_Cliente.addItem("Seleccione Cliente:");

            while (rs.next()) {

                jCB_Cliente.addItem(rs.getString("Apellido") + " " + rs.getString("Nombre"));

            }
            //con.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar Clientes " + e);
        }

    }

    /*
    *Cargar productos al comboProductos
    *
     */
    private void cargarCBProductos() throws SQLException {

        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM Producto";
        Statement st;

        try {

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jCB_Producto.removeAllItems();
            jCB_Producto.addItem("Seleccione Producto:");

            while (rs.next()) {
                
                jCB_Producto.addItem(rs.getString("NombreProducto") + " " + rs.getString("Descripcion"));
                
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar Producto " + e);
        } finally{
            Conexion.cerrarConexion(con);
        }

    }

    private boolean validar(String valor) {

        try {
            int num = Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    /*
    *Para mostrar los datos del Producto
     */
    private void ObtenerDdatosDeProducto() throws SQLException {
        
        try {
            Connection con = Conexion.getConexion();
            
            String sql = "SELECT * FROM Producto WHERE concat (NombreProducto,' ',Descripcion) = '" + this.jCB_Producto.getSelectedItem() + "'";
            
            Statement st = con.createStatement();            
            ResultSet rs = st.executeQuery(sql);           
            
            while (rs.next()) {             
                id_Producto = rs.getInt("idProducto");
                nombre = rs.getString("NombreProducto");
                cantidadProducto_BD = rs.getInt("Stock");
                precioUnitario = rs.getDouble("PrecioActual");
                System.out.println("paso 4");
            }
            //con.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar Producto " + e);
        } 
        
    }

    private void calculoTotalPagar() {

        subtotalFinal = 0;
        descuentoFinal = 0;
        totalPagarFinal = 0;

        for (DetalleVenta elem : listaProductos) {
            subtotalFinal += elem.getSubTotal();
            descuentoFinal += elem.getDescuento();
            totalPagarFinal += elem.getTotalPagar();
        }
        subtotalFinal = (double) Math.round(subtotalFinal * 100) / 100;
        descuentoFinal = (double) Math.round(descuentoFinal * 100) / 100;
        totalPagarFinal = (double) Math.round(totalPagarFinal * 100) / 100;

        jtxt_subTotal.setText(String.valueOf(subtotalFinal));
        jtxt_descuento.setText(String.valueOf(descuentoFinal));
        jtxt_total_A_Pagar.setText(String.valueOf(totalPagarFinal));
    }
    
    public void setIdUsuarioApellido(int idUsuario, String apellido){
        
        jtxt_vendedor.setText(idUsuario+" "+apellido);
                     
    }
    
    private boolean validarDouble(String valor) {

        try {
            double num = Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
    
    private void obtenerIdClienteSeleccionado(){
        
        try {
            String sql = "SELECT * FROM cliente WHERE concat (Apellido,' ',Nombre) = '" + this.jCB_Cliente.getSelectedItem() + "'";
            Connection con = Conexion.getConexion();
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                idCliente = rs.getInt("idCliente");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al Obtener id del cliente, " + e.getMessage());
        }
    }
    
    
}
