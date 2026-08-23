/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo;

/**
 *
 * @author kevin
 */
public enum Puesto {
    Administrador(950000),
    Recepcionista(700000),
    EncargadoBodega(650000),
    Mantenimiento(600000),
    OperarioCarga(575000);
    
    private final double salarioDefecto;
    
    Puesto(double salarioDefecto){
        this.salarioDefecto = salarioDefecto;
    }
    
    public double getSalarioDefecto(){
        return salarioDefecto;
    }
}
