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
    public static Usuario uActivo = new Usuario();
Usuario usuario = new Usuario();
    public UsuarioData() throws SQLException {
        con = Conexion.getConexion();
    }

    public boolean guardarUsuario(Usuario u) {
boolean resp =false;
        String sql = "INSERT INTO Usuario (Apellido, Nombre, Password, Estado) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, u.getApellido());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getPassword());
            ps.setBoolean(4, true);
            int res = ps.executeUpdate();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Usuario guardado con éxito");
                resp=true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el usuario");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Usuario" + ex.getMessage());
        }
        return resp;
    }

    public Usuario buscarUsuario(int idUsuario) {

        

        String sql = "SELECT Apellido , Nombre FROM Usuario WHERE idUsuario= ? AND Estado=1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setApellido(rs.getNString("Apellido"));
                usuario.setNombre(rs.getNString("Nombre"));

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Usuarios " + ex.getMessage());
        }
        return usuario;

    }

    public void eliminarUsuario(int idUsuario) {

        String sql = "UPDATE Usuario SET Estado=0 WHERE idUsuario=?";
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Usuario " + ex.getMessage());
        }
    }

    public boolean modificarUsuario(Usuario u) {
        boolean resp=false;
        String sql = "UPDATE Usuario SET Apellido=?, Nombre=?, Password=?  WHERE idUsuario=?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getApellido());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getPassword());
            ps.setInt(4, u.getIdUsuario());

            int res = ps.executeUpdate();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Usuario modificado con éxito");
                resp=true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el usuario");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla usuario " + ex.getMessage());
        }
        return resp;
    }

    public List<Usuario> listarUsuarios() {

        String sql = "SELECT * FROM Usuario WHERE Estado=1";

        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setApellido(rs.getString("Apellido"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setPassword(rs.getString("Password"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No fue posible listar los usuarios" + ex.getMessage());
        }
        return usuarios;
    }

    public boolean loginUsuario(Usuario obj) {

        boolean resp = false;

      
        String sql = "SELECT * FROM `Usuario` WHERE"
                + " `Apellido` = ? AND `Password` = ? AND Estado=1";

        
        try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1,obj.getApellido());
             ps.setString(2, obj.getPassword());
             ResultSet rs =ps.executeQuery();
             
            if (rs.next()){
                  uActivo.setIdUsuario(rs.getInt("idUsuario"));
                uActivo.setApellido(rs.getString("Apellido")); 
                resp = true;
            }
            ps.close();

        } catch (Exception e) {
            System.out.println("Error al Iniciar Sesión");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesión" + e.getMessage());
        }

        return resp;
    }
    /*
    public Usuario ObtenerDatosUsuario (Usuario obj) throws SQLException{
        
        Usuario vendedor = null;
        boolean resp = false;
        
        Connection con = Conexion.getConexion();
        String sql = "SELECT `Apellido`, `Password` FROM `Usuario` WHERE"
                + " `Apellido` = '"+ obj.getApellido() +"' AND `Password` = '"+ obj.getPassword() +"'";
        
        Statement st;
        
        try {
            
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                vendedor = new Usuario();
                vendedor.setIdUsuario(rs.getInt("idUsuario"));
                vendedor.setNombre(rs.getString("Apellido"));
            }
            while (rs.next()) {                
                resp = true;
            }
            
        } catch (Exception e) {
            System.out.println("Error al Iniciar Sesión");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesión" + e.getMessage());
        }
        
        return vendedor;
    }
     */

    public boolean  buscarUsuario(String apellido, String nombre, String password) {
        boolean res=true;
         String sql = "SELECT * FROM Usuario WHERE Apellido = ? AND Nombre= ? AND Password= ? AND Estado=1;";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, apellido);
            ps.setString(2, nombre);
            ps.setString(3, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setApellido(rs.getNString("Apellido"));
                usuario.setNombre(rs.getNString("Nombre"));
                usuario.setPassword(rs.getString("Password"));
                res=false;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Usuarios " + ex.getMessage());
        }
        
        return res;
    }
    public Usuario buscarPorPassword(String password){
        Usuario u = null;
        String sql = "SELECT * FROM Usuario WHERE Password = ? AND Estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setApellido(rs.getString("Apellido"));
                usuario.setNombre(rs.getString("Nombre"));
                
            }
            ps.close();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla usuario");
        }
        return usuario;
        
    }
}
