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
    private int idVenta;
    private int idProducto;
    
    private String nombre;
    private int cantidad;       
    private double precioUnitario;
    private double subTotal;
    private double descuento;
    private double totalPagar;
    private double estado;
    
      
    public DetalleVenta(){
        this.idDetalleVenta = 0;
        this.idVenta = 0;
        this.idProducto = 0;
        this.nombre = "";
        this.cantidad = 0;
        this.precioUnitario = 0.0;
        this.subTotal = 0.0;
        this.descuento = 0.0;
        this.totalPagar = 0.0;
        this.estado = 0;
    }

    public DetalleVenta(int idDetalleVenta, int idVenta, int idProducto, String nombre, int cantidad, double precioUnitario, double subTotal, double descuento, double totalPagar, double estado) {
        this.idDetalleVenta = idDetalleVenta;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subTotal = subTotal;
        this.descuento = descuento;
        this.totalPagar = totalPagar;
        this.estado = estado;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public double getEstado() {
        return estado;
    }

    public void setEstado(double estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVenta=" + idDetalleVenta + ", idVenta=" + idVenta + ", idProducto=" + idProducto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subTotal=" + subTotal + ", descuento=" + descuento + ", totalPagar=" + totalPagar + ", estado=" + estado + '}';
    }

    
}
