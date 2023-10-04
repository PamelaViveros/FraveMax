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

    public Venta(int idCliente, LocalDate fechaVenta) {
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
    }

    public Venta(int idVenta, int idCliente, LocalDate fechaVenta) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.fechaVenta = fechaVenta;
    }

    

    public Venta() {
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

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idCliente=" + idCliente + ", fechaVenta=" + fechaVenta + '}';
    }

   
}
