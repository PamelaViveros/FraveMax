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

    public UsuarioData() throws SQLException {
        con = Conexion.getConexion();
    }

    public void guardarUsuario(Usuario u) {

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
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el usuario");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla Usuario" + ex.getMessage());
        }
    }

    public Usuario buscarUsuario(int idUsuario) {

        Usuario usuario = new Usuario();

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

    public void modificarUsuario(Usuario u) {
        String sql = "UPDATE Usuario SET Apellido=?, Nombre=?, Password=? , Estado=? WHERE idUsuario=?";

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

    public boolean loginUsuario(Usuario obj) throws SQLException {

        boolean resp = false;

        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM `Usuario` WHERE"
                + " `Apellido` = '" + obj.getApellido() + "' AND `Password` = '" + obj.getPassword() + "' AND Estado=1";

        Statement st;
        try {

            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()){
                  uActivo.setIdUsuario(rs.getInt("idUsuario"));
                uActivo.setApellido(rs.getString("Apellido")); 
                resp = true;
            }
//            while (rs.next()) {
//              
//               
//            }

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
}
