/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import AccesoADatos.DetalleVentaData;
import static AccesoADatos.DetalleVentaData.detalles;
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

        DetalleVentaData detalleVentaData = new DetalleVentaData();
         
        detalleVentaData.detalles(6);
         for (DetalleVenta detalle : detalles) {
             System.out.println(detalle.toString());
             
             
        }
    
    }

}
