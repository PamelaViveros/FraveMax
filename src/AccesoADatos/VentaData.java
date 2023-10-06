/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Producto;
import Entidades.Venta;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaming
 */
public class VentaData {
    
    private Connection con = null;
    public static List<Venta> ventas =new ArrayList<>();
        
    public VentaData(){
    
        con = Conexion.getConexion();
    }
    
    public void guardarVenta(Venta v) {
        
        String sql="INSERT INTO Ventas (IdCliente, FechaVent) VALUES (?,?)";
        PreparedStatement ps=null;
        try{
             ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, v.getIdCliente());
            ps.setDate(2, Date.valueOf(v.getFechaVenta())); //Parseo LocalDate a Date
            int res=ps.executeUpdate();
            if (res==1) {
                JOptionPane.showMessageDialog(null, "Venta guardada con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar la venta");
            }
            
            
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"No se pudo acceder a la tabla Ventas" +ex.getMessage());
        } 
        
        
    }
    
    public List<Venta> listarVentas(){
         String sql="SELECT * FROM ventas ";
        PreparedStatement ps=null;
        
        try {
            ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()) {
                 Venta venta=new Venta();
                 venta.setIdVenta(rs.getInt("idVenta"));
                 venta.setIdCliente(rs.getInt("idCliente"));
                  venta.setFechaVenta(rs.getDate("FechaVent").toLocalDate());
                  
                 ventas.add(venta);
             }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"No se pudo acceder a la tabla Ventas" +ex.getMessage());
        }
        return ventas;
    }
    
    
    public Venta buscarVenta(int idVenta){
         Venta venta=new Venta();
        
        String sql="SELECT  FechaVent , idCliente FROM ventas WHERE idVenta= ?";
        PreparedStatement ps=null;
          try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();
              if (rs.next()) {
                 venta.setFechaVenta(rs.getDate("FechaVent").toLocalDate()); 
                   venta.setIdCliente(rs.getInt("idCliente"));
                 
                  
                 }
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo acceder a la tabla Ventas" +ex.getMessage());
        }
          return venta;
    }
    
    
    public List<Venta> buscarVentasxCliente(int idCliente){
       
        
        String sql="SELECT idVenta, FechaVent FROM ventas WHERE idCliente= ?";
        PreparedStatement ps=null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()) {
                 Venta venta=new Venta();
                 venta.setIdVenta(rs.getInt("idVenta"));
                  venta.setFechaVenta(rs.getDate("FechaVent").toLocalDate());
                  
                 ventas.add(venta);
             }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"No se pudo acceder a la tabla Ventas" +ex.getMessage());
        }
        return ventas;
    }
    
    public List <Venta> buscarVentasxFecha(LocalDate fecha){
         
       
        String sql="SELECT idVenta, idCliente FROM ventas WHERE FechaVent= ?";
        PreparedStatement ps=null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Venta venta=new Venta();
                 venta.setIdVenta(rs.getInt("idVenta"));
                venta.setIdCliente(rs.getInt("idCliente"));
                  venta.setFechaVenta(fecha);
                  
                 ventas.add(venta);
             }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"No se pudo acceder a la tabla Ventas" +ex.getMessage());
        }
        
        return ventas;
        
        
    }
    
    public void  limpiarLista(){
            ventas.clear();
            
        }
    
    
    ///////////////////////////////////////////////////Este metodo no va aca///////////////////////////////////////////////////////////////
    public void actualizarStock(int idProducto, int cantVendida){
         Producto prod=new Producto();
        String sql="SELECT Stock  FROM producto WHERE idProducto = ?;";
        PreparedStatement ps=null;
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProducto);
            ResultSet rs = ps.executeQuery();
             if (rs.next()) {
                
                 prod.setStock(rs.getInt("Stock")-cantVendida);
                            }
          sql="UPDATE Producto SET Stock ="+prod.getStock()+" WHERE idProducto= "+idProducto+" ";
            ps = con.prepareStatement(sql);
            int res=ps.executeUpdate();
            if (res==1) {
                JOptionPane.showMessageDialog(null, "Stock actualizado. Restante: "+ prod.getStock());
            }else{
                JOptionPane.showMessageDialog(null, "Error al actualizar el Stock");
            }
             
             
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "No fue posible actualizar");
        }
            
       
    }
        
      
}
