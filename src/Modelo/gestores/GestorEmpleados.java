/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.gestores;

import Modelo.Empleado;
import java.util.ArrayList;

/**
 *
 * @author isaac
 */
public class GestorEmpleados {
    
    
    private ArrayList<Empleado> empleados;
    
    public GestorEmpleados(){
        empleados= new ArrayList<>();
    }
    
    public void agregar(Empleado empleado){
        empleados.add(empleado);
    }
    public Empleado buscar(String id){
        
        for(Empleado empleado: empleados){
            if(empleado.getId().equals(id)){
                return empleado;
            }
        }
        return null;
    }
    
    
}
