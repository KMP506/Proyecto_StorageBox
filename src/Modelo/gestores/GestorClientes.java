/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.gestores;
import Modelo.Cliente;
import Modelo.excepciones.ClienteConContratosException;
import java.util.ArrayList;
import Modelo.gestores.GestorContratos;

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
    
    public boolean eliminar(String id, GestorContratos gestorContratos) throws ClienteConContratosException{
        Cliente cliente=buscar(id);
        
        if (cliente != null){
            if (gestorContratos != null && gestorContratos.tieneContratosActivosOPendientes(id)){
                throw new ClienteConContratosException("No se puede eliminar el cliente con ID " 
                        + id + " porque posee contratos activos o pendientes.");
            }
            clientes.remove(cliente);
            return true;
        }
        return false;
    }    
    public ArrayList<Cliente> getClientes(){
        return clientes;
    }
}
