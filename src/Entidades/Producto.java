/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Gaming
 */
public class Producto {
    
    private int idProducto;
    private String nombreProducto;
    private String descripcion;
    private double precioActual;
    private int stock;
    private boolean estado;

    public Producto(int idProducto, String nombreProducto, String descripcion, double precioActual, int stock, boolean estado) {//con id
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(String nombreProducto, String descripcion, double precioActual, int stock, boolean estado) {//sin id
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto() {//tres constructores este vacio
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {//igual que el cliente puede estar sujeto a ediciones
       return  idProducto + ", " + nombreProducto + ", " + descripcion ;
    } 
    
    
    
}
