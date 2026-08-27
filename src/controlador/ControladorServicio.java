/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.ServicioAdicional;
import Modelo.SistemaStorageBox;
import java.util.ArrayList;

/*,*
 *
 * @author monto
 */
public class ControladorServicio {
 
    private SistemaStorageBox sistema;
 
    public ControladorServicio(SistemaStorageBox sistema) {
        this.sistema = sistema;
    }
 
    public ServicioAdicional agregarServicio(String nombre,
            String descripcion, double precio) {
 
        return sistema.agregarServicio(nombre, descripcion, precio);
    }
 
    public ServicioAdicional buscarServicio(String codigo) {
        return sistema.buscarServicio(codigo);
    }
 
    public boolean actualizarServicio(String codigo,
            String descripcion, double precio) {
 
        return sistema.actualizarServicio(codigo, descripcion, precio);
    }
 
    public boolean eliminarServicio(String codigo) {
        return sistema.eliminarServicio(codigo);
    }
 
    public ArrayList<ServicioAdicional> listarServicios() {
        return sistema.getGestorServicios().getServicios();
    }
 
}