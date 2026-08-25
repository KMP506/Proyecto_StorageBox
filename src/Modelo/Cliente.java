/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author kevin
 */
public class Cliente extends Persona{
    private LocalDate fechaNacimiento;
    private String correoElectronico;
    
    public Cliente(String id, String nombreCompleto, String telefono,
            LocalDate fechaNacimiento, String correoElectronico){
        super(id,nombreCompleto, telefono);
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
    }
    
    
    public LocalDate getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    
    public String getCorreoElectronico(String correoElectronico){
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico){
        this.correoElectronico = correoElectronico;
    }
    
    public int calcularEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    @Override
    public String mostrarResumen() {
       return nombreCompleto + "("+id+")-"+calcularEdad()+"años";
    }
    
}
