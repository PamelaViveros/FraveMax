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
public class Venta {
    
    private  int idVenta;
    private int idCliente;
    private LocalDate fechaVenta;
    public int idUsuario;

    public Venta() {
    }

    public Venta(int idCliente, LocalDate fechaVenta, int idUsuario) {
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
        this.idUsuario = idUsuario;
    }

    public Venta(int idVenta, int idCliente, LocalDate fechaVenta, int idUsuario) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
        this.idUsuario = idUsuario;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    
    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idCliente=" + idCliente + ", fechaVenta=" + fechaVenta + '}';
    }

   
}
