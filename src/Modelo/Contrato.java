/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.excepciones.CambioEstadoNoPermitidoException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class Contrato implements Cobrable{
    private static final double iva=0.13;
    
    private int numeroContrato;
    private Cliente cliente;
    private Espacio espacio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private EstadoContrato estado;
    private List<ServicioContratado> servicios;
    
    public Contrato(int numeroContrato, Cliente cliente, Espacio espacio, LocalDate fechaInicio, LocalDate fechaFin){
        this.numeroContrato = numeroContrato;
        this.cliente = cliente;
        this.espacio = espacio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = EstadoContrato.Pendiente;
        this.servicios = new ArrayList<>();
    }
    
    public int getNumeroContrato(){
        return this.numeroContrato;
    }
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    public Espacio getEspacio(){
        return this.espacio;
    }
    
    public LocalDate getFechaInicio(){
        return this.fechaInicio;
    }
    
    public LocalDate getFechaFin(){
        return this.fechaFin;
    }
    
    public EstadoContrato getEstado(){
        return this.estado;
    }
    
    public List<ServicioContratado> getServicios(){
        return this.servicios;
    }
    
    public void agregarServicio(ServicioContratado sc){
        servicios.add(sc);
    }
    
    private boolean esBisiesto(int anio){
        if (anio % 4 !=0){
            return false;
        }
        if (anio % 100 !=0){
            return true;
        }
        if (anio % 400 ==0){
            return true;
        }
        return false;
    }
      
    private int diasAnio(int anio) {
        if (esBisiesto(anio)) {
            return 366;
        } else {
            return 365;
        }
    }
    
    public int calcularDias(){
        if (fechaInicio.getYear() == fechaFin.getYear()){
            return fechaFin.getDayOfYear() - fechaInicio.getDayOfYear();
        }
        
        int dias = 0;
        dias = dias + diasAnio(fechaInicio.getYear()) - fechaInicio.getDayOfYear();
        for (int anio = fechaInicio.getYear() + 1; anio < fechaFin.getYear(); anio++){
            dias = dias +diasAnio(anio);
        }
        dias = dias + fechaFin.getDayOfYear();
        return dias;
    }
    
    public int calcularPeriodos(){
        int dias = calcularDias();
        int periodos = dias / 30;
        int resto = dias % 30;
        if (resto > 0){
            periodos = periodos +1;
        }
        return periodos;
    }
    
    private double calcularTotalServicios(){
        double total = 0;
        for(ServicioContratado sc : servicios){
            total = total + sc.calcularMonto();
        }
        return total;
    }

    @Override
    public double calcularMonto() {
        return (espacio.getPrecioMensual() * calcularPeriodos())+calcularTotalServicios();
    }
    
    public double calcularSubtotal(){
        return calcularMonto() / (1+iva);
    }
    
    public double calcularImpuesto(){
        return calcularMonto() - calcularSubtotal();
    }
    
    public double calcularTotal(){
        return calcularMonto();
    }
    
   public void activar() throws CambioEstadoNoPermitidoException {
    if (estado != EstadoContrato.Pendiente) {
        throw new CambioEstadoNoPermitidoException(estado.toString(), EstadoContrato.Activo.toString());
    }
    estado = EstadoContrato.Activo;
    espacio.cambiarEstado(EstadoEspacio.Ocupado);
}

public void finalizar() throws CambioEstadoNoPermitidoException {
    if (estado != EstadoContrato.Activo) {
        throw new CambioEstadoNoPermitidoException(estado.toString(), EstadoContrato.Finalizado.toString());
    }
    estado = EstadoContrato.Finalizado;
    espacio.cambiarEstado(EstadoEspacio.Disponible);
}

public void cancelar() throws CambioEstadoNoPermitidoException {
    if (estado != EstadoContrato.Pendiente) {
        throw new CambioEstadoNoPermitidoException(estado.toString(), EstadoContrato.Cancelado.toString());
    }
    estado = EstadoContrato.Cancelado;
    espacio.cambiarEstado(EstadoEspacio.Disponible);
}
 
}
