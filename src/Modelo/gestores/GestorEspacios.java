/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.gestores;

import Modelo.Espacio;
import java.util.HashMap;
import Modelo.EstadoEspacio;
import Modelo.excepciones.EspacioOcupadoException;
import Modelo.TipoEspacio;

/**
 *
 * @author isaac
 */
public class GestorEspacios {
    

    private HashMap<String, Espacio> espacios;
        
        
    public GestorEspacios(){
        
        espacios= new HashMap<>();
    }
    
    public boolean agregar(Espacio espacio){
        if(espacios.containsKey(espacio.getNumeroEspacio())){
            return false;
        }
        espacios.put(espacio.getNumeroEspacio(), espacio);
        return true;
    }
    public Espacio buscar(String numeroEspacio){
        return espacios.get(numeroEspacio);
    }
    
   
    public boolean eliminar(String numeroEspacio) throws EspacioOcupadoException{
        
        Espacio espacio= buscar(numeroEspacio);
        
        if(espacio==null){
            return false;
        }
        if(espacio.getEstado()==EstadoEspacio.Ocupado){
            throw new EspacioOcupadoException(numeroEspacio);
        }
        espacios.remove(numeroEspacio);
        return true;
    }
    
    public boolean actualizar(String numeroEspacio, TipoEspacio tipo, double tamanoM2, double precioMensual){
        
        Espacio espacio= buscar(numeroEspacio);
        if(espacio!= null){
            espacio.setTipo(tipo);
            espacio.setTamanoM2(tamanoM2);
            espacio.setPrecioMensual(precioMensual);
            return true;
        }
        return false;
    }
    
    public HashMap<String, Espacio> getEspacios(){
        return espacios;
    }
}
