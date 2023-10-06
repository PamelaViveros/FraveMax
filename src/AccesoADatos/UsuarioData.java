/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public UsuarioData(){
        con= Conexion.getConexion();
    }
    
    public void guardarUsuario(Usuario u){
        
        String sql="INSERT INTO usuario (apellido, nombre, password, estado) VALUES (?, ?, ?, ?)";
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
        String sql = "UPDATE usuario SET apellido=?, nombre=?,password=? , Estado=? WHERE idUsuario=?";
        
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
    
    
}
