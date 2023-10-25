/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Vista.JfrmLogin;
import java.sql.SQLException;

/**
 *
 * @author Gaming
 */
public class FraveMax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        JfrmLogin Login = new JfrmLogin();
        
       Login.setVisible(true);
       Login.setLocationRelativeTo(null);
         
    
    }

}
