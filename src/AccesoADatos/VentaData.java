/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

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
    public static List<Venta> ventas = new ArrayList<>();

    public VentaData() throws SQLException {

        con = Conexion.getConexion();
    }

    public void guardarVenta(Venta v) {

        String sql = "INSERT INTO Ventas (idCliente, FechaVent, idUsuario, Estado) VALUES (?,?,?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, v.getIdCliente());
            ps.setDate(2, Date.valueOf(v.getFechaVenta())); //Parseo LocalDate a Date
            ps.setInt(3, v.getIdUsuario());
            ps.setBoolean(4, true);
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                v.setIdVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Venta guardada con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar la venta");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ventas" + ex.getMessage());
        }

    }

   
    public List<Venta> listarVentas(){
         String sql="SELECT * FROM Ventas WHERE Estado=1";
        PreparedStatement ps=null;
        

        try {
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setIdCliente(rs.getInt("idCliente"));
                venta.setFechaVenta(rs.getDate("FechaVent").toLocalDate());
                venta.setIdUsuario(rs.getInt("idUsuario"));
                ventas.add(venta);
            }           
               
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ventas" + ex.getMessage());
        }
        return ventas;
    }
   
       
    public Venta buscarVenta(int idVenta){
         Venta venta=new Venta();
        
        String sql="SELECT  * FROM Ventas WHERE idVenta= ? AND Estado=1";
        PreparedStatement ps=null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                venta.setFechaVenta(rs.getDate("FechaVent").toLocalDate());
                venta.setIdCliente(rs.getInt("idCliente"));
                venta.setIdUsuario(rs.getInt("idUsuario"));

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ventas " + ex.getMessage());
        }
        return venta;
    }
         
    public List<Venta> buscarVentasxCliente(int idCliente){
       
        
        String sql="SELECT * FROM Ventas WHERE idCliente= ? AND Estado=1";
        PreparedStatement ps=null;
     

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setFechaVenta(rs.getDate("FechaVent").toLocalDate());
                venta.setIdUsuario(rs.getInt("idUsuario"));
                ventas.add(venta);
            }                      
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ventas " + ex.getMessage());
        }
        return ventas;
    }

       
    public List <Venta> buscarVentasxFecha(LocalDate fecha){

       
        String sql="SELECT * FROM Ventas WHERE FechaVent= ? AND Estado=1";
        PreparedStatement ps=null;
        

        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setIdCliente(rs.getInt("idCliente"));
                venta.setFechaVenta(fecha);
                venta.setIdUsuario(rs.getInt("idUsuario"));

                ventas.add(venta);
            }                          

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ventas " + ex.getMessage());
        }

        return ventas;


    }
        
    public List<Venta> ventasPorUsuario(int idUsuario){
        
        String sql="SELECT * FROM Ventas WHERE idUsuario=? AND Estado=1";
        PreparedStatement ps=null;
      

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Venta venta = new Venta();            

                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setIdCliente(rs.getInt("idCliente"));
                venta.setFechaVenta(rs.getDate("FechaVent").toLocalDate());
                venta.setIdUsuario(rs.getInt("idUsuario"));

                ventas.add(venta);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ventas " + ex.getMessage());
        }

        return ventas;

    }
      
    public List<Venta> porProducto(int idProd){
        
         String sql="SELECT Ventas.idVenta, Ventas.idCliente, Ventas.FechaVent, Ventas.idUsuario FROM Ventas  JOIN DetalleVenta ON "
                 + "(Ventas.idVenta = DetalleVenta.idVenta) WHERE IdProducto=? And Ventas.Estado=1";
        PreparedStatement ps=null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProd);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setIdCliente(rs.getInt("idCliente"));
                venta.setFechaVenta(rs.getDate("FechaVent").toLocalDate());
                venta.setIdUsuario(rs.getInt("idUsuario"));
                ventas.add(venta);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ventas " + ex.getMessage());
        }

        return ventas;

    }

    public void eliminarVenta(int idVenta) {

        String sql = "UPDATE Ventas SET Estado=0 WHERE idVenta=?";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Venta eliminada con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la Venta");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ventas " + ex.getMessage());
        }

    }
    
    public static int idDetalleRegistro;
    java.math.BigDecimal iDColVar;
    
    public boolean cargarVenta(Venta v) {
        boolean resp = false;
        
        String sql = "INSERT INTO Ventas (idCliente, FechaVent, idUsuario, Estado) VALUES (?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, v.getIdCliente());
            ps.setDate(2, Date.valueOf(v.getFechaVenta())); //Parseo LocalDate a Date           
            ps.setInt(3, v.getIdUsuario());
            ps.setBoolean(4, true);            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                v.setIdVenta(rs.getInt(1));
                iDColVar = rs.getBigDecimal(1);
                idDetalleRegistro = iDColVar.intValue();
                resp = true;
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Ventas" + ex.getMessage());
        }
        return resp;
    }

}
