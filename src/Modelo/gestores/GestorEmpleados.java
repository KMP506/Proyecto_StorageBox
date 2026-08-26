/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.gestores;

import Modelo.Empleado;
import java.util.ArrayList;
import Modelo.Puesto;

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
    
    public boolean actualizar(String id, String nombre, String telefono, Puesto puesto){
        
        Empleado empleado= buscar(id);
        
        if(empleado!= null){
            empleado.setNombreCompleto(nombre);
            empleado.setTelefono(telefono);
            empleado.setPuesto(puesto);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String id){
        
        Empleado empleado= buscar(id);
        if(empleado!= null){
            empleados.remove(empleado);
            return true;
        }
        return false;
        
    }
    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }
    
    
}
