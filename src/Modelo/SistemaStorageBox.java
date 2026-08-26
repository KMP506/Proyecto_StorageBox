/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.gestores.GestorClientes;
import Modelo.gestores.GestorContratos;
import Modelo.gestores.GestorEmpleados;
import Modelo.gestores.GestorEspacios;
import Modelo.gestores.GestorServicios;
import Modelo.excepciones.ClienteConContratosException;
import Modelo.excepciones.IdentificacionDuplicadaException;

/**
 *
 * @author kevin
 */
public class SistemaStorageBox {

    private GestorClientes gestorClientes;
    private GestorEspacios gestorEspacios;
    private GestorServicios gestorServicios;
    private GestorEmpleados gestorEmpleados;
    private GestorContratos gestorContratos;

    public SistemaStorageBox() {
        gestorClientes = new GestorClientes();
        gestorEspacios = new GestorEspacios();
        gestorServicios = new GestorServicios();
        gestorEmpleados = new GestorEmpleados();
        gestorContratos = new GestorContratos();
    }

    public GestorClientes getGestorClientes() {
        return gestorClientes;
    }

    public GestorEspacios getGestorEspacios() {
        return gestorEspacios;
    }

    public GestorServicios getGestorServicios() {
        return gestorServicios;
    }

    public GestorEmpleados getGestorEmpleados() {
        return gestorEmpleados;
    }

    public GestorContratos getGestorContratos() {
        return gestorContratos;
    }

    public void agregarCliente(Cliente cliente)
            throws IdentificacionDuplicadaException {
        if (gestorClientes.buscar(cliente.getId()) != null) {
            throw new IdentificacionDuplicadaException(cliente.getId());
        }
        gestorClientes.agregar(cliente);
    }

    public Cliente buscarCliente(String id) {
        return gestorClientes.buscar(id);
    }

    public boolean actualizarCliente(String id, String nombre,
            String telefono, String correo) {
        return gestorClientes.actualizar(id, nombre, telefono, correo);
    }

    public boolean eliminarCliente(String id)
            throws ClienteConContratosException {
        for (Contrato contrato : gestorContratos.getContratos()) {
            if (contrato.getCliente().getId().equals(id)) {
                if (contrato.getEstado() == EstadoContrato.Pendiente
                        || contrato.getEstado() == EstadoContrato.Activo) {
                    throw new ClienteConContratosException(id);
                }
            }
        }
        return gestorClientes.eliminar(id);
    }
}
