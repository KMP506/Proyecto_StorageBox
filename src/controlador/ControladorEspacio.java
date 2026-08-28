/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import Modelo.Espacio;
import Modelo.SistemaStorageBox;
import Modelo.TipoEspacio;
import Modelo.excepciones.EspacioDuplicadoException;
import Modelo.excepciones.EspacioOcupadoException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author monto
 */
public class ControladorEspacio {
 
    private SistemaStorageBox sistema;
 
    public ControladorEspacio(SistemaStorageBox sistema) {
        this.sistema = sistema;
    }
 
    public void agregarEspacio(String numeroEspacio, TipoEspacio tipo, double precio)
            throws EspacioDuplicadoException {
 
        Espacio espacio = new Espacio(numeroEspacio, tipo);
        espacio.setPrecioMensual(precio);
        sistema.agregarEspacio(espacio);
    }
 
    public Espacio buscarEspacio(String numeroEspacio) {
        return sistema.buscarEspacio(numeroEspacio);
    }
 
    public boolean actualizarEspacio(String numeroEspacio,
            TipoEspacio tipo, double tamano, double precio) {
 
        return sistema.actualizarEspacio(numeroEspacio, tipo, tamano, precio);
    }
 
    public boolean eliminarEspacio(String numeroEspacio)
            throws EspacioOcupadoException {
 
        return sistema.eliminarEspacio(numeroEspacio);
    }
 
    public ArrayList<Espacio> listarEspacios() {
        HashMap<String, Espacio> espacios = sistema.getGestorEspacios().getEspacios();
        return new ArrayList<>(espacios.values());
    }
 
    public int cantidadEspaciosDisponibles(TipoEspacio tipo,
            LocalDate fechaInicio, LocalDate fechaFin) {
 
        return sistema.cantidadEspaciosDisponibles(tipo, fechaInicio, fechaFin);
    }
 
}
 