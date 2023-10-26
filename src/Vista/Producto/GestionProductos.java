package Vista.Producto;

import AccesoADatos.ProductoData;
import Entidades.Producto;
import static Vista.JfrMenu1.jDesktopPaneMenu;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class GestionProductos extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    private ProductoData data;
    private List<Producto> productos;
    private NuevoProducto editor;

    
    /**
     * Creates new form GestionProductos
     */
    public GestionProductos() throws SQLException {
        this.editor = new NuevoProducto();
        this.data = new ProductoData();
        initComponents();
        armarCabecera();
        cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jbNuevo = new javax.swing.JButton();
        jbEditar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jlTitle = new javax.swing.JLabel();
        jlFiltro = new javax.swing.JLabel();
        jfFiltro = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 78, 477, 263));

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(jbNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 359, -1, -1));

        jbEditar.setText("Editar");
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 359, -1, -1));

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(jbEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 359, -1, -1));

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jbCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 359, -1, -1));

        jlTitle.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        jlTitle.setForeground(new java.awt.Color(204, 204, 204));
        jlTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitle.setText("Gestión de Productos");
        jlTitle.setToolTipText("");
        jlTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jlTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 477, -1));

        jlFiltro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlFiltro.setText("Escriba un texto para filtar");
        getContentPane().add(jlFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 50, 169, -1));

        jfFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jfFiltroKeyReleased(evt);
            }
        });
        getContentPane().add(jfFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 44, 189, -1));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imag/Fondo black.jpeg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        NuevoProducto nuevoProducto = null;
        try {
            nuevoProducto = new NuevoProducto();
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jDesktopPaneMenu.removeAll();
        jDesktopPaneMenu.repaint();
        nuevoProducto.setVisible(true);
        jDesktopPaneMenu.add(nuevoProducto);
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        int fila = jtProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila.");
            return;
        }

        int idProducto = (Integer)jtProductos.getModel().getValueAt(fila, 4);
        Producto producto = data.buscarPorId(idProducto);
        if (producto == null) {
            return;
        }

        NuevoProducto nuevoProducto = null;
        try {
            nuevoProducto = new NuevoProducto();
        } catch (SQLException ex) {
            Logger.getLogger(GestionProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        nuevoProducto.editar(producto);
        
        jDesktopPaneMenu.removeAll();
        jDesktopPaneMenu.repaint();
        nuevoProducto.setVisible(true);
        jDesktopPaneMenu.add(nuevoProducto);
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int fila = jtProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila.");
            return;
        }

        int resultado = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar el producto", "Eliminar producto", JOptionPane.YES_NO_OPTION);
        if (resultado != 0) {
            return;
        }

        int idProducto = (Integer)jtProductos.getModel().getValueAt(fila, 4);
        Producto producto = data.buscarPorId(idProducto);
        if (producto != null) {
            modelo.removeRow(fila);
            data.eliminarProducto(producto.getIdProducto());
            productos.remove(fila);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jfFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jfFiltroKeyReleased
        String filtro = jfFiltro.getText().toLowerCase();
        borrarFilas();

        for (Producto producto : productos) {
            if (filtro.isEmpty() || producto.getNombreProducto().toLowerCase().startsWith(filtro)) {
                modelo.addRow(new Object[]{
                    producto.getNombreProducto(),
                    producto.getDescripcion(),
                    producto.getPrecioActual(),
                    producto.getStock(),
                    producto.getIdProducto(),
                });
            }
        }
    }//GEN-LAST:event_jfFiltroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JTextField jfFiltro;
    private javax.swing.JLabel jlFiltro;
    private javax.swing.JLabel jlTitle;
    private javax.swing.JTable jtProductos;
    // End of variables declaration//GEN-END:variables

    
    private void armarCabecera() {
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio actual");
        modelo.addColumn("Stock");
        modelo.addColumn("Código");
        
        jtProductos.setModel(modelo);
        TableColumnModel model = jtProductos.getColumnModel();
        model.getColumn(2).setPreferredWidth(10);
        model.getColumn(3).setPreferredWidth(10);
        jtProductos.removeColumn(model.getColumn(4));
    }
    
    private void cargarDatos() {
        productos = data.listarProductos();

        for (Producto producto : productos) {
            modelo.addRow(new Object[]{
                producto.getNombreProducto(),
                producto.getDescripcion(),
                producto.getPrecioActual(),
                producto.getStock(),
                producto.getIdProducto(),
            });
        }
    }
    
    private void borrarFilas() {
        int filas = jtProductos.getRowCount() - 1;
        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
    
    public void actualizar() {
        borrarFilas();
        cargarDatos();
    }
}
