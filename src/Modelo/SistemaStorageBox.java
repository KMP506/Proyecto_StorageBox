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
}
