/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.gestores;
import Modelo.Cliente;
import java.util.ArrayList;

/**
 *
 * @author isaac
 */
public class GestorClientes {
    
    
    private ArrayList<Cliente> clientes;
    
    public GestorClientes(){
        clientes= new ArrayList<>();
    }
    
    public void agregar(Cliente cliente){
            clientes.add(cliente);
    }
    
    public Cliente buscar(String id){
        for(Cliente cliente:clientes){
            if(cliente.getId().equals(id)){
                return cliente;
            }
        }
        return null;
    }
    public boolean actualizar(String id, String nombre, String telefono, String correo){
        Cliente cliente= buscar(id);
        
        if(cliente !=null){
            cliente.setNombreCompleto(nombre);
            cliente.setTelefono(telefono);
            cliente.setCorreoElectronico(correo);
            return true;
        }
        return false;
    }
    
    public boolean eliminar(String id){
        Cliente cliente=buscar(id);
        
        if(cliente!=null){
            clientes.remove(cliente);
            return true;
        }
        return false;
    }
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
}
