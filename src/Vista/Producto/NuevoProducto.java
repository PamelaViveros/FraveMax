package Vista.Producto;

import AccesoADatos.ProductoData;
import Entidades.Producto;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class NuevoProducto extends javax.swing.JInternalFrame {

    private ProductoData data;
    private Producto producto = null;

    /**
     * Creates new form NuevoProducto
     */
    public NuevoProducto() throws SQLException {
        this.data = new ProductoData();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitle = new javax.swing.JLabel();
        jbCancelar = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbBorrar = new javax.swing.JButton();
        jfStock = new javax.swing.JTextField();
        jfNombre = new javax.swing.JTextField();
        jlDescripcion = new javax.swing.JLabel();
        jlStock = new javax.swing.JLabel();
        jfDescripcion = new javax.swing.JTextField();
        jlNombre = new javax.swing.JLabel();
        jlPrecioActual = new javax.swing.JLabel();
        jfPrecioActual = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(204, 204, 204));
        jlTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitle.setText("Nuevo Producto");
        jlTitle.setToolTipText("");
        jlTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jlTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 6, -1, -1));

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 233, -1, -1));

        jbEditar.setText("Nuevo");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 233, -1, -1));

        jbBorrar.setText("Borrar");
        jbBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(jbBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(136, 233, -1, -1));
        getContentPane().add(jfStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 176, 152, -1));
        getContentPane().add(jfNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 44, 152, -1));

        jlDescripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        jlDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlDescripcion.setText("Descripción:");
        getContentPane().add(jlDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 90, 90, -1));

        jlStock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlStock.setForeground(new java.awt.Color(255, 255, 255));
        jlStock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlStock.setText("Stock:");
        getContentPane().add(jlStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 182, 90, -1));
        getContentPane().add(jfDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 84, 152, -1));

        jlNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(255, 255, 255));
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlNombre.setText("Nombre:");
        getContentPane().add(jlNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 50, 90, -1));

        jlPrecioActual.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlPrecioActual.setForeground(new java.awt.Color(255, 255, 255));
        jlPrecioActual.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlPrecioActual.setText("Precio actual:");
        getContentPane().add(jlPrecioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 136, 90, -1));
        getContentPane().add(jfPrecioActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 130, 152, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/fondo2.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBorrarActionPerformed
        borrarDatos();
    }//GEN-LAST:event_jbBorrarActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        String nombre = jfNombre.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar el nombre del producto.");
            return;
        }

        String descripcion = jfDescripcion.getText();
        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar la descripción del producto.");
            return;
        }

        String precioTexto = jfPrecioActual.getText();
        if (precioTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar el precio actual del producto.");
            return;
        }

        float precioActual = 0;
        try {
            precioActual = Float.parseFloat(precioTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El precio actual debe debe ser un número.");
            return;
        }

        String stockTexto = jfStock.getText();
        if (stockTexto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe completar el stock del producto.");
            return;
        }

        int stock = 0;
        try {
            stock = Integer.parseInt(stockTexto);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "El stock debe debe ser un número.");
            return;
        }

        if (producto != null) {
            producto.setNombreProducto(nombre);
            producto.setDescripcion(descripcion);
            producto.setPrecioActual(precioActual);
            producto.setStock(stock);
            data.modificarProducto(producto);
        } else {
            Producto nuevoProducto = new Producto(nombre, descripcion, precioActual, stock, true);
            data.nuevoProducto(nuevoProducto);
        }

        if (producto == null) {
            borrarDatos();
        }
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jbCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JButton jbBorrar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JTextField jfDescripcion;
    private javax.swing.JTextField jfNombre;
    private javax.swing.JTextField jfPrecioActual;
    private javax.swing.JTextField jfStock;
    private javax.swing.JLabel jlDescripcion;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlPrecioActual;
    private javax.swing.JLabel jlStock;
    private javax.swing.JLabel jlTitle;
    // End of variables declaration//GEN-END:variables

    
    public void editar(Producto producto) {
        this.producto = producto;
        
        jlTitle.setText("Editar producto");
        jbEditar.setText("Editar");
        jbBorrar.setVisible(false);
        
        jfNombre.setText(producto.getNombreProducto());
        jfDescripcion.setText(producto.getDescripcion());
        jfPrecioActual.setText(producto.getPrecioActual() + "");
        jfStock.setText(producto.getStock() + "");
    }
    
    public void borrarDatos() {
        jfNombre.setText("");
        jfDescripcion.setText("");
        jfPrecioActual.setText("");
        jfStock.setText("");
    }

   
}
