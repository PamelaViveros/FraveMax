package AccesoADatos;

import Entidades.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class DetalleVentaData {
    
    private Connection con = null;
    public static List<DetalleVenta> detalles=new ArrayList<>();
   
    public DetalleVentaData() throws SQLException{

        con = Conexion.getConexion();

    }
    
    public void guardarDetalleVenta(DetalleVenta dv){
    
       String sql = "INSERT INTO DetalleVenta( Cantidad, idVenta, PrecioVenta, idProducto, SubTotal, Descuento, TotalPagar)  VALUES (?, ?, ?, ?, ?, ?, ?)";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dv.getCantidad());
            ps.setInt(2, dv.getIdVenta());
            ps.setDouble(3, dv.getPrecioUnitario());
            ps.setInt(4, dv.getIdProducto());
            ps.setDouble(5, dv.getSubTotal());
            ps.setDouble(6, dv.getDescuento());
            ps.setDouble(7, dv.getTotalPagar());
                                 
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
            
                dv.setIdDetalleVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle de venta guardado.");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Detalle de venta.");
        }
    
    }

    
    public boolean guardarDetalle(DetalleVenta dv) throws SQLException{
        
        boolean resp = false;
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO `DetalleVenta`(`Cantidad`, `idVenta`, `PrecioVenta`, `idProducto`, `SubTotal`, `Descuento`, `TotalPagar`, `Estado`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
       
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dv.getCantidad());
            ps.setInt(2, dv.getIdVenta());
            ps.setDouble(3, dv.getPrecioUnitario());
            ps.setInt(4, dv.getIdProducto());
            ps.setDouble(5, dv.getSubTotal());
            ps.setDouble(6, dv.getDescuento());
            ps.setDouble(7, dv.getTotalPagar());
            ps.setInt(8, 1);
                                 
                       
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar Detalle de venta." + ex.getMessage());
        }
        return resp;
    }
    
    public DetalleVenta detallarVenta(int id){
    
        DetalleVenta dv =new DetalleVenta();
        
        String sql = "SELECT idDetalleVent, idVenta , idProducto , PrecioVenta , Cantidad, SubTotal, Descuento, TotalPagar"
                + " FROM DetalleVenta WHERE idVenta = ? LIMIT 1";
    
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            
                
                dv.setIdDetalleVenta(rs.getInt("idDetalleVent"));
                dv.setCantidad(rs.getInt("Cantidad"));
                dv.setIdVenta(rs.getInt("idventa"));
                dv.setPrecioUnitario(rs.getDouble("PrecioVenta"));
                dv.setIdProducto(rs.getInt("idProducto"));
                dv.setSubTotal(rs.getDouble("SubTotal"));
                dv.setDescuento(rs.getDouble("Descuento"));
                dv.setTotalPagar(rs.getDouble("TotalPagar"));
            
            } else {
            
                JOptionPane.showMessageDialog(null, "No existe el detalle que busca.");
            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al entrar a la tabla detalleventa.");
        }
        
        return dv;
    }
    
    public DetalleVenta ventaDetallada(int idDetalle){
    
        DetalleVenta dv =new DetalleVenta();
        
        String sql = "SELECT idDetalleVent,  idVenta , idProducto , PrecioVenta , Cantidad, SubTotal, Descuento, TotalPagar"
                + " FROM DetalleVenta WHERE idDetalleVent = ? LIMIT 1";
    
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDetalle);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            
                
                dv.setIdDetalleVenta(rs.getInt("idDetalleVent"));
                dv.setCantidad(rs.getInt("Cantidad"));
                dv.setIdVenta(rs.getInt("idventa"));
                dv.setPrecioUnitario(rs.getDouble("PrecioVenta"));
                dv.setIdProducto(rs.getInt("idProducto"));
                dv.setSubTotal(rs.getDouble("SubTotal"));
                dv.setDescuento(rs.getDouble("Descuento"));
                dv.setTotalPagar(rs.getDouble("TotalPagar"));
            
            } else {
            
                JOptionPane.showMessageDialog(null, "No existe el detalle que busca.");
            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al entrar a la tabla detalleventa. " + ex);
        }
        
        return dv;
    }
    
    public void eliminarDetalleVenta(int id){
        
        String sql = "UPDATE DetalleVenta SET Estado = 0 WHERE idDetalleVenta = ? ";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el detalle de la venta.");
            }
            ps.close();            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al entrar a la tabla detalleventa.");
        } 
    }
    
    public List detalles( int idVenta){
        
        String sql="SELECT * FROM DetalleVenta WHERE idVenta=? AND Estado=1";
        PreparedStatement ps=null;
        

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DetalleVenta detalle= new DetalleVenta();
                detalle.setIdDetalleVenta(rs.getInt("idDetalleVent"));
                detalle.setCantidad(rs.getInt("Cantidad"));
                detalle.setIdVenta(rs.getInt("idVenta"));
                detalle.setPrecioUnitario(rs.getDouble("PrecioVenta"));
                detalle.setIdProducto(rs.getInt("idProducto"));
                detalle.setSubTotal(rs.getDouble("Subtotal"));
                detalle.setDescuento(rs.getDouble("descuento"));
                detalle.setTotalPagar(rs.getDouble("TotalPagar"));
                detalle.setEstado(rs.getDouble("Estado"));
                detalles.add(detalle);
                
            }           
               
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Detalle de Venta" + ex.getMessage());
        }
        return detalles;
        
    }
    
    
}

