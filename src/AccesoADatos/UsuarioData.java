/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaming
 */
public class UsuarioData {
    
    private Connection con = null;
    public static List<Usuario> usuarios = new ArrayList<>();
    
    public UsuarioData() throws SQLException{
        con= Conexion.getConexion();
    }
    
    public void guardarUsuario(Usuario u){
        
        String sql="INSERT INTO usuario (Apellido, Nombre, Password, Estado) VALUES (?, ?, ?, ?)";
        PreparedStatement ps=null;
        try{
            
             ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setString(1, u.getApellido());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getPassword());
            ps.setBoolean(4, true);
            int res=ps.executeUpdate();
            if (res==1) {
                JOptionPane.showMessageDialog(null, "Usuario guardad con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar el usuario");
            }
            ps.close();
        
    }   catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se pudo acceder a la tabla Usuario" +ex.getMessage());
        }
    }
        
    
    public void eliminarUsuario(int idUsuario){
        
        String sql = "UPDATE Producto SET Estado=0 WHERE idUsuario=?";
         PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            
            int res = ps.executeUpdate();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No existe el usuario");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Usario " + ex.getMessage());
        }
    }
    
    public void modificarUsuario(Usuario u){
        String sql = "UPDATE usuario SET Apellido=?, Nombre=?, Password=? , Estado=? WHERE idUsuario=?";
        
         try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getApellido());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getPassword());
            ps.setBoolean(4, u.isEstado());
           
            
            int res = ps.executeUpdate();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Usuario modificado con éxito");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el usuario");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla usuario " + ex.getMessage());
        }
    }
    
    public List<Usuario> listarUsuarios(){
       
        String sql="SELECT * FROM Usuario WHERE Estado=1";
        
         PreparedStatement ps=null;
        
        try {
            ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()) {
               Usuario usuario= new Usuario();
                 usuario.setIdUsuario(rs.getInt("idUsuario"));
                 usuario.setApellido(rs.getString("Apellido"));
                 usuario.setNombre(rs.getString("Nombre"));
                 usuario.setPassword(rs.getString("Password"));
                 usuarios.add(usuario);
             }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No fue posible listar los usuarios"+ ex.getMessage());
        }
        return usuarios;
    }
    
    
    public boolean loginUsuario (Usuario obj) throws SQLException{
    
        boolean resp = false;
        
        Connection con = Conexion.getConexion();
        String sql = "SELECT `Apellido`, `Password` FROM `usuario` WHERE"
                + " `Apellido` = '"+ obj.getApellido() +"' AND `Password` = '"+ obj.getPassword() +"'";
        
        Statement st;
        
        try {
            
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                resp = true;
            }
            
        } catch (Exception e) {
            System.out.println("Error al Iniciar Sesión");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesión" + e.getMessage());
        }
        
        return resp;
    }
}
