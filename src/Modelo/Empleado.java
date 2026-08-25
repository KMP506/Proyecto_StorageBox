/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author kevin
 */
public class Empleado extends Persona {
    private Puesto puesto;
    private double salario;
    
    public Empleado(String id,String nombreCompleto, String telefono, Puesto puesto){
        super(id,nombreCompleto,telefono);
        this.puesto = puesto;
        this.salario = puesto.getSalarioDefecto();
    }
    
    public Puesto getPuesto(){
        return this.puesto;
    }
    
    public double getSalario(){
        return this.salario;
    }
    
    public void setPuesto(Puesto puesto){
        this.puesto = puesto;
        this.salario = puesto.getSalarioDefecto();
    }

    @Override
    public String mostrarResumen() {
       return nombreCompleto +"("+ id +")-"+ puesto;
    }
    
}
