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
    
       String sql = "INSERT INTO detalleventa( Cantidad, idVenta, PrecioVenta, idProducto)  VALUES (?,?,?,?)";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dv.getCantidad());
            ps.setInt(2, dv.getIdVenta());
            ps.setDouble(3, dv.getPrecioUnitario());
            ps.setInt(4, dv.getIdProducto());
            
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
            
                dv.setIdDetalleVenta(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Detalle de venta guardado.");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al entrar a la tabla detalleventa.");
        }
    
    }
    
    public DetalleVenta detallarVenta(int id){
    
        DetalleVenta dv =new DetalleVenta();
        
        String sql = "SELECT idVenta , idProducto , PrecioVenta , Cantidad FROM detalleventa WHERE idDetalleVent = ? ";
    
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
        
        String sql = "UPDATE detalleventa SET estado = 0 WHERE idDetalleVenta = ? ";
        
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

