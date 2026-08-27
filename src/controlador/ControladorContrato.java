/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import Modelo.Cliente;
import Modelo.Contrato;
import Modelo.SistemaStorageBox;
import Modelo.TipoEspacio;
import Modelo.excepciones.CambioEstadoNoPermitidoException;
import Modelo.excepciones.NegocioException;
import java.time.LocalDate;
import java.util.LinkedList;
import Modelo.EstadoContrato;
/**
 *
 * @author monto
 */
public class ControladorContrato {
 
    private SistemaStorageBox sistema;
 
    public ControladorContrato(SistemaStorageBox sistema) {
        this.sistema = sistema;
    }
 
    public Contrato crearContrato(String idCliente, TipoEspacio tipo,
            LocalDate fechaInicio, LocalDate fechaFin)
            throws NegocioException {
 
        return sistema.crearContrato(idCliente, tipo, fechaInicio, fechaFin);
    }
 
    public Contrato buscarContrato(int numeroContrato) {
        return sistema.buscarContrato(numeroContrato);
    }
 
    public void agregarServicioContrato(int numeroContrato,
            String codigoServicio, int cantidad)
            throws NegocioException {
 
        sistema.agregarServicioContrato(numeroContrato, codigoServicio, cantidad);
    }
 
    public boolean activarContrato(int numeroContrato)
            throws CambioEstadoNoPermitidoException {
 
        return sistema.activarContrato(numeroContrato);
    }
 
    public boolean finalizarContrato(int numeroContrato)
            throws CambioEstadoNoPermitidoException {
 
        return sistema.finalizarContrato(numeroContrato);
    }
 
    public boolean cancelarContrato(int numeroContrato)
            throws CambioEstadoNoPermitidoException {
 
        return sistema.cancelarContrato(numeroContrato);
    }
 
    public LinkedList<Contrato> listarContratos() {
        return sistema.getGestorContratos().getContratos();
    }
    public LinkedList<Contrato> filtrarContratos(int numeroContrato, String cliente, String espacio, LocalDate fecha, EstadoContrato estado) {

    return sistema.filtrarContratos(numeroContrato, cliente, espacio, fecha,estado);
    }
    public Cliente buscarCliente(String id) {
        return sistema.buscarCliente(id);
    }
    public int cantidadEspaciosDisponibles(TipoEspacio tipo, LocalDate fechaInicio, LocalDate fechaFin) {
        return sistema.cantidadEspaciosDisponibles(tipo, fechaInicio, fechaFin);
}
 
}
 