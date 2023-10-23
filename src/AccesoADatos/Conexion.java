/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaming
 */
public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String DB = "FraveMax";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    private Conexion() {
    }

    public static Connection getConexion() throws SQLException{

        if (connection == null || connection.isClosed()) {

            try {
              
               Class.forName("org.mariadb.jdbc.Driver");
                connection= DriverManager.getConnection(URL + DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + USUARIO + "&password=" + PASSWORD);
            } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Error al cargar los Drivers"+ ex.getMessage());
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Error al conectar a la base de datos"+ ex.getMessage());
            }

        }
        return connection;
    }
    
    public static void cerrarConexion(Connection conexion){
        
        try {
            if (conexion != null && !conexion.isClosed()){
                conexion.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    
    }

}