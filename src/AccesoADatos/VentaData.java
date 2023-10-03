/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Cliente;
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
        
        String sql="INSERT INTO Venta (IdCliente, FechaVent) VALUES (?,?)";
        
        try{
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, v.getCliente().getIdCliente());
            ps.setDate(2, Date.valueOf(v.getFechaVenta())); //Parseo LocalDate a Date
            
            ps.close();
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"No se pudo acceder a la tabla Ventas" +ex.getMessage());
        } 
        
        
    }
    
    
    public Venta buscarVenta(int idVenta){
         Venta venta=null;
        
        String sql="SELECT  FechaVent , idCliente FROM ventas WHERE idVenta= ?";
        PreparedStatement ps=null;
          try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();
              if (rs.next()) {
                 venta.setFechaVenta(rs.getDate("FechaVent").toLocalDate()); 
                   venta.setCliente((Cliente) rs.getObject("idCliente"));  //Casteo el id cliente a Cliente
                 
                  
                 }
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo acceder a la tabla Ventas" +ex.getMessage());
        }
          return venta;
    }
    
    
    public List<Venta> buscarVentasxCliente(int idCliente){
        Venta venta=null;
        
        String sql="SELECT idVenta, FechaVenta FROM ventas WHERE idCliente= ?";
        PreparedStatement ps=null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            
             if (rs.next()) {
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
         Venta venta=null;
       
        String sql="SELECT idVenta, idCliente FROM ventas WHERE FechaVent= ?";
        PreparedStatement ps=null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            
             if (rs.next()) {
                 venta.setIdVenta(rs.getInt("idVenta"));
                 venta.setCliente((Cliente) rs.getObject("idCliente"));
                  
                  
                 ventas.add(venta);
             }
            
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"No se pudo acceder a la tabla Ventas" +ex.getMessage());
        }
        
        return ventas;
        
        
    }
}
