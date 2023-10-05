/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Cliente;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author chexs
 */
public class ClienteData {
    
    private Connection con = null;
    
    public static List<Cliente> clientes = new ArrayList<>();
    
    public ClienteData(){
    
        con = Conexion.getConexion();
    }
    
    public void guardarCliente( Cliente c){
    
        String sql = "INSERT INTO cliente(Apellido, Nombre, Domicilio, Telefono, Estado) "
                + "VALUES ( ?, ?, ?, ?, ?, ? )";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getApellido());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDomicilio());
            ps.setInt(4, c.getTelefono());
            ps.setBoolean(5, c.getEstadoCliente());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Cliente cargado con éxito");          
            ps.close();
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente" + ex.getMessage());
        
        }
        
    }
    
    public Cliente buscarCliente(int id){
    
        Cliente c = null;
        String sql = "SELECT Apellido, Nombre, Domicilio, Telefono FROM `cliente` "
                + "WHERE idCliente = ? OR Telefono = ?";
        PreparedStatement ps = null;
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
            
                c = new Cliente();
                
                c.setApellido(rs.getString("Apellido"));
                c.setNombre(rs.getString("Nombre"));
                c.setDomicilio(rs.getString("Domicilio"));
                c.setTelefono(rs.getInt("Telefono"));                        
            
            } else {
            
                JOptionPane.showMessageDialog(null, "No existe el Cliente en la Base de Datos");
                ps.close();
                
            }
                       
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al intentar Acceder a la "
                    + "base de datos Clientes" + ex.getMessage());
                      
        }
        
        return c;
        
    }
    
    public Cliente buscarCliente(String apell){
    
        Cliente c = null;
        String sql = " SELECT Apellido, Nombre, Domicilio, Telefono FROM `cliente` "
                + "WHERE Apellido LIKE '?%' ";
        PreparedStatement ps = null;
        
        try {
            
            ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            int cont = 0;
            while (rs.next()){
            
                c = new Cliente();
                
                c.setApellido(rs.getString("Apellido"));
                c.setNombre(rs.getString("Nombre"));
                c.setDomicilio(rs.getString("Domicilio"));
                c.setTelefono(rs.getInt("Telefono"));                        
                cont++;
                
            } 
            if( cont == 0) {
            
                JOptionPane.showMessageDialog(null, "No existe el Cliente en la Base de Datos");
                ps.close();
                
            } 
                                   
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Error al intentar Acceder a la "
                    + "base de datos Clientes" + ex.getMessage());
                      
        }
        
        return c;
        
    }
    
    public List<Cliente> listaClientes(){
        
        String sql = "SELECT * FROM `cliente` WHERE `Estado`= 1";        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while( rs.next() ){
                
                Cliente c = new Cliente();
                
                c.setIdCliente(rs.getInt("idCliente"));
                c.setApellido(rs.getString("Apellido"));
                c.setNombre(rs.getString("Nombre"));
                c.setDomicilio(rs.getString("Domicilio"));
                c.setTelefono(rs.getInt("Telefono"));
                c.setEstadoCliente(rs.getBoolean("Estado"));
                clientes.add(c);
            
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al intentar Acceder a la "
                    + "base de datos Clientes" + ex.getMessage());
        }
        
        return clientes;
    
    }
    
    public void modificarDatoCliente(Cliente c){
        
        String sql = "UPDATE `cliente` SET Apellido=?, Nombre=?, Domicilio = ?, "
                + "Telefono = ?, Estado = ? WHERE idCliente = ?";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, c.getApellido());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDomicilio());
            ps.setInt(4, c.getTelefono());
            ps.setBoolean(5, c.getEstadoCliente());
            
            int cont = ps.executeUpdate();
            
            if (cont == 1) {
                JOptionPane.showMessageDialog(null, "Cliente Modificado con Exito");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente Inexistente ó Error al Modificar Datos del Cliente");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
    public void bajaDeCliente(int id){
        
        String sql = "UPDATE `cliente` SET Estado = 0 WHERE idCliente = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int cont = ps.executeUpdate();
            
            if (cont == 1) {
                JOptionPane.showMessageDialog(null, "Cliente dado de Baja con Exito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al dar de baja al Cliente");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clientes" + ex.getMessage());
        }
    }
}
