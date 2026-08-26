/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.SistemaStorageBox;
/**
 *
 * @author monto
 */
public class ControladorPrincipal {
 
    private SistemaStorageBox sistema;
    private ControladorCliente controladorCliente;
    private ControladorEspacio controladorEspacio;
    private ControladorServicio controladorServicio;
    private ControladorEmpleado controladorEmpleado;
    private ControladorContrato controladorContrato;
 
    public ControladorPrincipal() {
        sistema = new SistemaStorageBox();
        controladorCliente = new ControladorCliente(sistema);
        controladorEspacio = new ControladorEspacio(sistema);
        controladorServicio = new ControladorServicio(sistema);
        controladorEmpleado = new ControladorEmpleado(sistema);
        controladorContrato = new ControladorContrato(sistema);
    }
 
    public SistemaStorageBox getSistema() {
        return sistema;
    }
 
    public ControladorCliente getControladorCliente() {
        return controladorCliente;
    }
 
    public ControladorEspacio getControladorEspacio() {
        return controladorEspacio;
    }
 
    public ControladorServicio getControladorServicio() {
        return controladorServicio;
    }
 
    public ControladorEmpleado getControladorEmpleado() {
        return controladorEmpleado;
    }
 
    public ControladorContrato getControladorContrato() {
        return controladorContrato;
    }
 
}