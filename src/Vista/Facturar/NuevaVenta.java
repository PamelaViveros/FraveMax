/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Facturar;

import AccesoADatos.ClienteData;
import static AccesoADatos.ClienteData.clientes;
import AccesoADatos.DetalleVentaData;
import AccesoADatos.ProductoData;
import static AccesoADatos.ProductoData.productos;
import AccesoADatos.UsuarioData;
import AccesoADatos.VentaData;
import Entidades.Cliente;
import Entidades.Producto;
import static Vista.JfrMenu.Fondo;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaming
 */
public class NuevaVenta extends javax.swing.JInternalFrame {
    DefaultTableModel modelo = new DefaultTableModel();
    UsuarioData uData = new UsuarioData();
    VentaData vData = new VentaData();
    DetalleVentaData dvData = new DetalleVentaData();
    ProductoData pData = new ProductoData();
        ClienteData cData = new ClienteData();
    
    public NuevaVenta() {
        initComponents();
        cargaCombo();
        cabecera();
        cargaTabla();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcbClientes = new javax.swing.JComboBox<>();
        bNuevoCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProductos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setTitle("Nueva venta");

        jLabel1.setText("Seleccione cliente");

        bNuevoCliente.setText("Nuevo");
        bNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoClienteActionPerformed(evt);
            }
        });

        jLabel2.setText("Seleccione producto");

        tProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tProductos);

        jButton1.setText("Salir");

        jButton2.setText("Guardar");

        jButton3.setText("jButton3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(bNuevoCliente)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNuevoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoClienteActionPerformed
       this.dispose();
        
             NuevoCliente nuevoCliente = new NuevoCliente();
         Fondo.removeAll();
        Fondo.repaint();
        nuevoCliente.setVisible(true);
        Fondo.add(nuevoCliente);
    }//GEN-LAST:event_bNuevoClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bNuevoCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Cliente> jcbClientes;
    private javax.swing.JTable tProductos;
    // End of variables declaration//GEN-END:variables

public void cargaCombo(){
    cData.listaClientes();
    
    for (Cliente cliente : clientes) {
        jcbClientes.addItem(cliente);
    }
    
    clientes.clear();
    jcbClientes.setSelectedIndex(-1);
}

public void cabecera(){
    modelo.addColumn("ID");
    modelo.addColumn("Nombre");
    modelo.addColumn("Descripción");
    modelo.addColumn("Precio");
    modelo.addColumn("Stock");
    
    
    tProductos.setModel(modelo);
}

public void cargaTabla(){
    pData.listarProductos();
    
    for (Producto prod : productos) {
        modelo.addRow(new Object[]{
            prod.getIdProducto(),
            prod.getNombreProducto(),
            prod.getDescripcion(),
            prod.getPrecioActual(),
            prod.getStock()
        });
    }
    
    productos.clear();
}

}