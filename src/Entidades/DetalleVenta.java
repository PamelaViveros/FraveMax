/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author Gaming
 */
public class DetalleVenta {
    
    private int idDetalleVenta;
    private int cantidad;
    private String fechaVenta;
    private int idVenta;
    private double precioVenta;
    private int idProducto;

    public DetalleVenta(int idDetalleVenta, int cantidad, String fechaVenta, int idVenta, double precioVenta, int idProducto) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
        this.idVenta = idVenta;
        this.precioVenta = precioVenta;
        this.idProducto = idProducto;
    }

    public DetalleVenta(int cantidad, String fechaVenta, int idVenta, double precioVenta, int idProducto) {
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
        this.idVenta = idVenta;
        this.precioVenta = precioVenta;
        this.idProducto = idProducto;
    }

    public DetalleVenta(){}

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    
    
    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", cantidad=" + cantidad + ", fechaVenta=" + fechaVenta + ", idVenta=" + idVenta + ", precioVenta=" + precioVenta + ", idProducto=" + idProducto + '}';
    }
    
    
    

   
}
