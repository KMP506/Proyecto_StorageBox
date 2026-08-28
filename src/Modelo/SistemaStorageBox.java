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
import Modelo.excepciones.EspacioDuplicadoException;
import Modelo.excepciones.EspacioOcupadoException;
import Modelo.excepciones.IdentificacionDuplicadaException;
import Modelo.excepciones.CambioEstadoNoPermitidoException;
import Modelo.excepciones.EspacioNoDisponibleException;
import Modelo.excepciones.FechaInvalidaException;
import Modelo.excepciones.NegocioException;
import java.time.LocalDate;
import java.util.LinkedList;

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
    public boolean eliminarCliente(String id)throws ClienteConContratosException {
        return gestorClientes.eliminar(id, gestorContratos);
    }
    public void agregarEspacio(Espacio espacio) throws EspacioDuplicadoException {

    boolean agregado= gestorEspacios.agregar(espacio);

    if (agregado == false) {
        throw new EspacioDuplicadoException(espacio.getNumeroEspacio());
    }
}
public Espacio buscarEspacio(String numeroEspacio) {
    return gestorEspacios.buscar(numeroEspacio);
}
public boolean actualizarEspacio(String numeroEspacio,TipoEspacio tipo, double tamano, double precio) {

    return gestorEspacios.actualizar(
            numeroEspacio, tipo, tamano, precio
    );
}
public boolean eliminarEspacio(String numeroEspacio)
        throws EspacioOcupadoException {
    return gestorEspacios.eliminar(numeroEspacio);
}
public ServicioAdicional agregarServicio(String nombre,
        String descripcion, double precio) {

    return gestorServicios.agregar(nombre, descripcion, precio);
}
public ServicioAdicional buscarServicio(String codigo) {
    return gestorServicios.buscar(codigo);
}
public boolean actualizarServicio(String codigo, String nombre, String descripcion, double precio) {

    return gestorServicios.actualizar(codigo,nombre, descripcion, precio);
}
public boolean eliminarServicio(String codigo) {
    return gestorServicios.eliminar(codigo);
}
public void agregarEmpleado(Empleado empleado)
        throws IdentificacionDuplicadaException {

    if (gestorEmpleados.buscar(empleado.getId()) != null) {
        throw new IdentificacionDuplicadaException(
                empleado.getId()
        );
    }

    gestorEmpleados.agregar(empleado);
}
public Empleado buscarEmpleado(String id) {
    return gestorEmpleados.buscar(id);
}
public boolean actualizarEmpleado(String id, String nombre,
        String telefono, Puesto puesto) {

    return gestorEmpleados.actualizar(
            id, nombre, telefono, puesto
    );
}
public boolean eliminarEmpleado(String id) {
    return gestorEmpleados.eliminar(id);
}
public int cantidadEspaciosDisponibles(TipoEspacio tipo,
        LocalDate fechaInicio, LocalDate fechaFin) {
    int cantidad = 0;
    for (Espacio espacio
            : gestorEspacios.getEspacios().values()) {
        if (espacio.getTipo() == tipo) {
            if (gestorContratos.espacioDisponible(
                    espacio, fechaInicio, fechaFin)) {
                cantidad++;
            }
        }
    }
    return cantidad;
}
private Espacio buscarEspacioDisponible(TipoEspacio tipo,
        LocalDate fechaInicio, LocalDate fechaFin) {
    for (Espacio espacio
            : gestorEspacios.getEspacios().values()) {
        if (espacio.getTipo() == tipo) {
            if (gestorContratos.espacioDisponible(
                    espacio, fechaInicio, fechaFin)) {
                return espacio;
            }
        }
    }
    return null;
}
public Contrato crearContrato(String idCliente,
        TipoEspacio tipo, LocalDate fechaInicio,
        LocalDate fechaFin) throws NegocioException {
    Cliente cliente = gestorClientes.buscar(idCliente);
    if (cliente == null) {
        throw new NegocioException(
                "El cliente no se encuentra registrado."
        );
    }
    if (fechaInicio == null || fechaFin == null) {
        throw new FechaInvalidaException();
    }
    if (gestorContratos.fechasValidas(
            fechaInicio, fechaFin) == false) {
        throw new FechaInvalidaException(
                "La fecha final debe ser posterior a la fecha inicial."
        );
    }
    Espacio espacio = buscarEspacioDisponible(
            tipo, fechaInicio, fechaFin
    );
    if (espacio == null) {
        throw new EspacioNoDisponibleException(
                tipo.toString()
        );
    }
    return gestorContratos.agregar(
            cliente, espacio, fechaInicio, fechaFin
    );
}
public Contrato buscarContrato(int numeroContrato) {
    return gestorContratos.buscar(numeroContrato);
}
public void agregarServicioContrato(int numeroContrato,
        String codigoServicio, int cantidad)
        throws NegocioException {
    Contrato contrato
            = gestorContratos.buscar(numeroContrato);
    ServicioAdicional servicio
            = gestorServicios.buscar(codigoServicio);
    if (contrato == null) {
        throw new NegocioException(
                "El contrato no se encuentra registrado."
        );
    }
    if (servicio == null) {
        throw new NegocioException(
                "El servicio no se encuentra registrado."
        );
    }
    if (cantidad <= 0) {
        throw new NegocioException(
                "La cantidad debe ser mayor que cero."
        );
    }
    ServicioContratado servicioContratado
            = new ServicioContratado(servicio, cantidad);
    contrato.agregarServicio(servicioContratado);
}
public boolean activarContrato(int numeroContrato)
        throws CambioEstadoNoPermitidoException {
    Contrato contrato
            = gestorContratos.buscar(numeroContrato);
    if (contrato == null) {
        return false;
    }
    contrato.activar();
    return true;
}
public boolean finalizarContrato(int numeroContrato)
        throws CambioEstadoNoPermitidoException {
    Contrato contrato
            = gestorContratos.buscar(numeroContrato);
    if (contrato == null) {
        return false;
    }
    contrato.finalizar();
    return true;
}
public boolean cancelarContrato(int numeroContrato)
        throws CambioEstadoNoPermitidoException {
    Contrato contrato
            = gestorContratos.buscar(numeroContrato);
    if (contrato == null) {
        return false;
    }
    contrato.cancelar();
    return true;
}

    public LinkedList<Contrato> filtrarContratos(int numeroContrato, String cliente, String espacio, LocalDate fecha, EstadoContrato estado){
         
        return gestorContratos.filtrar(numeroContrato, cliente, espacio, fecha, estado);
    }
}
