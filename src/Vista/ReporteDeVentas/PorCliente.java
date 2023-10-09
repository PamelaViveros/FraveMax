/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.ReporteDeVentas;

import AccesoADatos.ClienteData;
import static AccesoADatos.ClienteData.clientes;
import AccesoADatos.VentaData;
import static AccesoADatos.VentaData.ventas;
import Entidades.Cliente;
import Entidades.Venta;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaming
 */
public class PorCliente extends javax.swing.JInternalFrame {

   DefaultTableModel modelo = new DefaultTableModel();
    VentaData vd = new VentaData();
    ClienteData cd = new ClienteData();
   
    public boolean isCellEditable(int f, int c) {
        return false;
    }
    public PorCliente() {
        initComponents();
         cd.listaClientes();
        cabecera();
        
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

        jLabel2 = new javax.swing.JLabel();
        jcbClientes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tVentasxCliente = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setTitle("Ventas por cliente");

        jLabel2.setText("Seleccione cliente");

        jcbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClientesActionPerformed(evt);
            }
        });

        tVentasxCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tVentasxCliente);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ver detalle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jcbClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClientesActionPerformed
       borrarFilas();
        if (jcbClientes.getSelectedIndex()==-1) {
            CargaTabla();
        }else{
            VentasPorCliente();
        }

    }//GEN-LAST:event_jcbClientesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<Cliente> jcbClientes;
    private javax.swing.JTable tVentasxCliente;
    // End of variables declaration//GEN-END:variables

private void cabecera() {
        modelo.addColumn("ID Venta");
        modelo.addColumn("Fecha de Venta");
        

        tVentasxCliente.setModel(modelo);
    }

public void cargaCombo(){
    
    for (Cliente cliente : clientes) {
        jcbClientes.addItem(cliente);
    }
    jcbClientes.setSelectedIndex(-1);
    clientes.clear();
}

public void VentasPorCliente(){
     
     
     Cliente c=(Cliente)jcbClientes.getSelectedItem();
    int id=c.getIdCliente();
    vd.buscarVentasxCliente(id);
    
    for (Venta venta : ventas) {
        modelo.addRow(new Object[]{
        venta.getIdVenta(),
        venta.getFechaVenta()
    });
    }
   ventas.clear();
}

public void CargaTabla(){
    vd.listarVentas();
    for (Venta venta : ventas) {
        modelo.addRow(new Object[]{
        venta.getIdVenta(),
        venta.getFechaVenta()
    });
    }
    ventas.clear();
}

public void borrarFilas(){
     int f = (tVentasxCliente.getRowCount() - 1);
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
}

}
