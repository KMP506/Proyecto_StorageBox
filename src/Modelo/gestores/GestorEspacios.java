/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.gestores;

import Modelo.Espacio;
import java.util.HashMap;
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
}
