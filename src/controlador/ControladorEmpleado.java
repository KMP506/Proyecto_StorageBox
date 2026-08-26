/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import Modelo.Empleado;
import Modelo.Puesto;
import Modelo.SistemaStorageBox;
import Modelo.excepciones.IdentificacionDuplicadaException;
import java.util.ArrayList;
/**
 *
 * @author monto
 */
public class ControladorEmpleado {
 
    private SistemaStorageBox sistema;
 
    public ControladorEmpleado(SistemaStorageBox sistema) {
        this.sistema = sistema;
    }
 
    public void agregarEmpleado(String id, String nombreCompleto,
            String telefono, Puesto puesto)
            throws IdentificacionDuplicadaException {
 
        Empleado empleado = new Empleado(id, nombreCompleto, telefono, puesto);
        sistema.agregarEmpleado(empleado);
    }
 
    public Empleado buscarEmpleado(String id) {
        return sistema.buscarEmpleado(id);
    }
 
    public boolean actualizarEmpleado(String id, String nombre,
            String telefono, Puesto puesto) {
 
        return sistema.actualizarEmpleado(id, nombre, telefono, puesto);
    }
 
    public boolean eliminarEmpleado(String id) {
        return sistema.eliminarEmpleado(id);
    }
 
    public ArrayList<Empleado> listarEmpleados() {
        return sistema.getGestorEmpleados().getEmpleados();
    }
 
}
 