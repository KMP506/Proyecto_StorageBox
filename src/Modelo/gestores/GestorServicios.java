/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.gestores;
import Modelo.ServicioAdicional;
import java.util.ArrayList;

/**
 *
 * @author isaac
 */
public class GestorServicios {
 
    private ArrayList<ServicioAdicional> servicios;
    private int siguienteCodigo;
    public GestorServicios(){
        servicios= new ArrayList<>();
        siguienteCodigo= 1;
    }
    
    public ServicioAdicional agregar(String nombre, String descipcion, double precio){
        
        String codigo= "S"+siguienteCodigo;
        
        ServicioAdicional servicio= new ServicioAdicional(codigo, nombre, descipcion, precio);
        
        servicios.add(servicio);
        siguienteCodigo++;
        
        return servicio;
    }
    
    public ServicioAdicional buscar(String codigo){
        
        for(ServicioAdicional servicio: servicios){
            if(servicio.getCodigo().equals(codigo)){
                return servicio;
            }
        }
        return null;
    }
    
    public boolean actualizar(String codigo, String nombre, String descripcion, double precio){
        
        ServicioAdicional servicio=buscar(codigo);
        
        if(servicio!=null){
            servicio.setNombre(nombre);
            servicio.setDescripcion(descripcion);
            servicio.setPrecio(precio);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String codigo){
        
        ServicioAdicional servicio=buscar(codigo);
        
        if(servicio!=null){
            servicios.remove(servicio);
            return true;
        }
        return false;
    }
    public ArrayList<ServicioAdicional> getServicios(){
        return servicios;
    }
}
