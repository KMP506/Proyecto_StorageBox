/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author kevin
 */
public abstract class Persona {
    protected String id;
    protected String nombreCompleto;
    protected String telefono;
    
    public Persona(String id,String nombreCompleto,String telefono){
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getNombreCompleto(){
        return this.nombreCompleto;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public void setTelefono(){
        this.telefono = telefono;
    }
    
    public abstract String mostrarResumen();
}
