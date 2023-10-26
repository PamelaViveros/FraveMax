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
    
    public ClienteData() throws SQLException{
    
        con = Conexion.getConexion();
    }
    
    public boolean guardarCliente( Cliente c){
        
        boolean resp = false;
        String sql = "INSERT INTO Cliente( Apellido, Nombre, Dni, Domicilio, Telefono, Estado) "
                + "VALUES ( ?, ?, ?, ?, ?,?)";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //ps.setInt(1, 0);// es el id y es autoincrement
            ps.setString(1, c.getApellido());
            ps.setString(2, c.getNombre());
            ps.setInt(3, c.getDni());
            ps.setString(4, c.getDomicilio());
            ps.setInt(5, c.getTelefono());
            ps.setInt(6, 1);
            
            
            
            if (ps.executeUpdate() > 0){
                resp = true;
            }
            
            ResultSet rs = ps.getGeneratedKeys();
            
                      
            //ps.close();
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente" + ex.getMessage());
        
        }
        
        return resp;
        
    }
    
    public boolean averiguarCliente(int dni){
        boolean resp = false;
        
        String sql = "SELECT  Dni FROM `Cliente` WHERE Dni = '" + dni +"'; ";
        Statement st;
        
        try {
            Connection con = Conexion.getConexion();
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                resp = true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al consultar Cliente: " + e);
        }
        return  resp;
    }
    
    public Cliente buscarCliente(int Dni){
    
        Cliente c = null;
        String sql = "SELECT Apellido, Nombre, Dni, Domicilio, Telefono FROM `Cliente` "
                + "WHERE Dni = ? ";
        PreparedStatement ps = null;
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, Dni);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
            
                c = new Cliente();
                
                c.setApellido(rs.getString("Apellido"));
                c.setNombre(rs.getString("Nombre"));
                c.setDni(rs.getInt("Dni"));
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
    
    
    public Cliente buscarClienteXid(int idCliente){
    
        Cliente c = null;
        String sql = "SELECT Apellido, Nombre, Dni, Domicilio, Telefono FROM `Cliente` "
                + "WHERE idCliente = ? ";
        PreparedStatement ps = null;
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
            
                c = new Cliente();
                
                c.setApellido(rs.getString("Apellido"));
                c.setNombre(rs.getString("Nombre"));
                c.setDni(rs.getInt("Dni"));
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
        String sql = " SELECT Apellido, Nombre, Dni, Domicilio, Telefono FROM `Cliente` "
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
                c.setDni(rs.getInt("Dni"));
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
        
        String sql = "SELECT * FROM `Cliente` WHERE `Estado`= 1";        
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while( rs.next() ){
                
                Cliente c = new Cliente();
                
                c.setIdCliente(rs.getInt("idCliente"));
                c.setApellido(rs.getString("Apellido"));
                c.setNombre(rs.getString("Nombre"));
                c.setDni(rs.getInt("Dni"));
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
        
        String sql = "UPDATE `Cliente` SET Apellido=?, Nombre=?, Dni=?, Domicilio = ?, "
                + "Telefono = ?, Estado = ? WHERE idCliente = ?";
        PreparedStatement ps = null;
        
        try {
            ps = con.prepareStatement(sql);
            
            ps.setString(1, c.getApellido());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDomicilio());
            ps.setInt(4, c.getDni());
            ps.setInt(5, c.getTelefono());
            ps.setBoolean(6, c.isEstadoCliente());
            
            int cont = ps.executeUpdate();
            
            if (cont == 1) {
                JOptionPane.showMessageDialog(null, "Cliente Modificado con Exito");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente Inexistente ó Error al Modificar Datos del Cliente");
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar Cliente" + ex);
        }
          
    }
    
    public boolean actualizarDatoCliente(Cliente c, int idCliente){  //// Para GestionCliente
        boolean resp = false;
        String sql = "UPDATE `Cliente` SET Apellido=?, Nombre=?, Dni=?, Domicilio = ?, "
                + "Telefono = ?, Estado = ? WHERE idCliente = '" + idCliente + "'";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, c.getApellido());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDomicilio());
            ps.setInt(4, c.getDni());
            ps.setInt(5, c.getTelefono());
            ps.setBoolean(6, c.isEstadoCliente());
            
            if (ps.executeUpdate() > 0){
                resp = true;
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error al actualizar Cliente" + ex);
        }
        return resp;
    }
    
    public void bajaDeCliente(int dni){
        
        String sql = "UPDATE `Cliente` SET Estado = 0 WHERE Dni = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
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
    
    public boolean eliminar(int idCliente){ /////Para GestionCliente
        boolean resp = false;
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM cliente WHERE idCliente = '" + idCliente + "'");
            ps.executeUpdate();
            
            if (ps.executeUpdate() > 0){
                resp = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar Cliente" + e);
        }
        return resp;
    }
}
