/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Cliente;
import java.awt.List;
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
    
    
    
    public ClienteData(){
    
        con = Conexion.getConexion();
    }
    
    public void guardarCliente( Cliente c){
    
        String sql = "INSERT INTO cliente(Apellido, Nombre, Domicilio, Telefono) "
                + "VALUES ( ?, ?, ?, ?, ? )";
        
        try {
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getApellido());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDomicilio());
            ps.setInt(4, c.getTelefono());
            
            ResultSet rs = ps.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Cliente cargado con éxito");          
            ps.close();
        
        } catch (SQLException ex) {
        
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Cliente" + ex.getMessage());
        
        }
    }
}
