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
    
    private int idVenta;
    private int cantidad;
    private LocalDate fechaVenta;
    private Venta venta;
    private double precioVenta;
    private Producto producto;

    public DetalleVenta(int idVenta, int cantidad, LocalDate fechaVenta, Venta venta, double precioVenta, Producto producto) {
        this.idVenta = idVenta;
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
    }

    public DetalleVenta(int cantidad, LocalDate fechaVenta, Venta venta, double precioVenta, Producto producto) {
        this.cantidad = cantidad;
        this.fechaVenta = fechaVenta;
        this.venta = venta;
        this.precioVenta = precioVenta;
        this.producto = producto;
    }

    public DetalleVenta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idVenta=" + idVenta + ", cantidad=" + cantidad + ", fechaVenta=" + fechaVenta + ", venta=" + venta + ", precioVenta=" + precioVenta + ", producto=" + producto + '}';
    }
    
    
    

   
}
