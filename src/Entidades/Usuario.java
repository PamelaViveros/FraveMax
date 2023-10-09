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
public class Usuario {
    
    private int idUsuario;
    private String apellido;
    private String nombre;
    private String password;
    private boolean estado;

    public Usuario() {
    }

    public Usuario(String apellido, String nombre, String password, boolean estado) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.password = password;
        this.estado = estado;
    }

    public Usuario(int idUsuario, String apellido, String nombre, String password, boolean estado) {
        this.idUsuario = idUsuario;
        this.apellido = apellido;
        this.nombre = nombre;
        this.password = password;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    @Override
    public String toString() {
        return idUsuario + ", " + apellido + ", " + nombre ;
    }

    
    
    
    
}
