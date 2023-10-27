package AccesoADatos;

import Entidades.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class DetalleVentaData {
    
    private Connection con = null;
    
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
        String sql = "INSERT INTO `detalleventa`(`Cantidad`, `idVenta`, `PrecioVenta`, `idProducto`, `SubTotal`, `Descuento`, `TotalPagar`, `Estado`) VALUES (?, ?, ?, ?, ?, ?, ?)";
       System.out.println(sql);
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);System.out.println("000");
            ps.setInt(1, dv.getCantidad());System.out.println("1");
            ps.setInt(2, dv.getIdVenta());System.out.println("2");
            ps.setDouble(3, dv.getPrecioUnitario());System.out.println("3");
            ps.setInt(4, dv.getIdProducto());System.out.println("4");
            ps.setDouble(5, dv.getSubTotal());System.out.println("5");
            ps.setDouble(6, dv.getDescuento());System.out.println("6");
            ps.setDouble(7, dv.getTotalPagar());System.out.println("7");
            //ps.setDouble(7, dv.getEstado());System.out.println("8");
                     
            
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en Guardar Detalle en la BD: " + ex.getMessage());
        }
        return resp;
    }
    
    public DetalleVenta detallarVenta(int id){
    
        DetalleVenta dv =new DetalleVenta();
        
        String sql = "SELECT idVenta , idProducto , PrecioVenta , Cantidad, SubTotal, Descuento, TotalPagar"
                + " FROM DetalleVenta WHERE idDetalleVent = ? ";
    
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
            
                
                dv.setIdDetalleVenta(id);
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
}

