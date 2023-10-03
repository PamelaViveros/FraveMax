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
    private String domicilio;
    private int telefono;
    private boolean estadoCliente;

    public Cliente(int idCliente, String apellido, String nombre, String domicilio, int telefono, boolean estadoCliente) {
        this.idCliente = idCliente;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estadoCliente = estadoCliente;
    }

    public Cliente(String apellido, String nombre, String domicilio, int telefono, boolean estadoCliente) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.estadoCliente = estadoCliente;
    }

    public Cliente() {
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
    
    public boolean getEstadoCliente(){
        return estadoCliente;
    }
    
    public void setEstadoCliente(boolean estadoCliente){
        this.estadoCliente = estadoCliente;
    }
    
    
    //dejo el paquete para hacer la interfaz entonces

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", domicilio=" + domicilio + ", telefono=" + telefono + '}';
    }//cualquier cosa lo editamos segun convenga
    
}
