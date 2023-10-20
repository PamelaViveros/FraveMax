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
public class Cliente {

    private int idCliente;
    private String apellido;
    private String nombre;
    private int dni;
    private String domicilio;
    private int telefono;
    private boolean estadoCliente;

    public Cliente() {
    }

    public Cliente(String apellido, String nombre, int dni, String domicilio, int telefono, boolean estadoCliente) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estadoCliente = estadoCliente;
    }

    public Cliente(int idCliente, String apellido, String nombre, int dni, String domicilio, int telefono, boolean estadoCliente) {
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estadoCliente = estadoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(boolean estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", domicilio=" + domicilio + ", telefono=" + telefono + ", estadoCliente=" + estadoCliente + '}';
    }
      
}
