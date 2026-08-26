/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import Modelo.Cliente;
import Modelo.SistemaStorageBox;
import Modelo.excepciones.ClienteConContratosException;
import Modelo.excepciones.IdentificacionDuplicadaException;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author monto
 */
public class ControladorCliente {
 
    private SistemaStorageBox sistema;
 
    public ControladorCliente(SistemaStorageBox sistema) {
        this.sistema = sistema;
    }
 
    public void agregarCliente(String id, String nombreCompleto, String telefono,
            LocalDate fechaNacimiento, String correoElectronico)
            throws IdentificacionDuplicadaException {
 
        Cliente cliente = new Cliente(id, nombreCompleto, telefono,
                fechaNacimiento, correoElectronico);
 
        sistema.agregarCliente(cliente);
    }
 
    public Cliente buscarCliente(String id) {
        return sistema.buscarCliente(id);
    }
 
    public boolean actualizarCliente(String id, String nombre,
            String telefono, String correo) {
 
        return sistema.actualizarCliente(id, nombre, telefono, correo);
    }
 
    public boolean eliminarCliente(String id)
            throws ClienteConContratosException {
 
        return sistema.eliminarCliente(id);
    }
 
    public ArrayList<Cliente> listarClientes() {
        return sistema.getGestorClientes().getClientes();
    }
 
}