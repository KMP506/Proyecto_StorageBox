/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author kevin
 */
public class Espacio implements Cobrable{
    private String numeroEspacio;
    private TipoEspacio tipo;
    private double tamanoM2;
    private double precioMensual;
    private EstadoEspacio estado;
    
    public Espacio(String numeroEspacio, TipoEspacio tipo) {
        this.numeroEspacio = numeroEspacio;
        this.tipo = tipo;
        this.tamanoM2 = tipo.getTamanoM2();
        this.precioMensual = tipo.getPrecioDefecto();
        this.estado = EstadoEspacio.Disponible;
    }
    
    public String getNumeroEspacio(){
        return this.numeroEspacio;
    }
    
    public TipoEspacio getTipo(){
        return this.tipo;
    }
    
    public double getTamanoM2(){
        return this.tamanoM2;
    }
    
    public double getPrecioMensual(){
        return this.precioMensual;
    }
    
    public EstadoEspacio getEstado(){
        return this.estado;
    }
    
    public void setTipo(TipoEspacio tipo){
        this.tipo = tipo;
        this.tamanoM2 = tipo.getTamanoM2();
        this.precioMensual = tipo.getPrecioDefecto();
    }
    
    public void setTamanoM2(double tamanoM2){
        this.tamanoM2 = tamanoM2;
    }
    
    public void setPrecioMensual(double precioMensual){
        this.precioMensual = precioMensual;
    }
    
    public void cambiarEstado(EstadoEspacio nuevoEstado){
        this.estado  = nuevoEstado;
    }

    @Override
    public double calcularMonto() {
       return precioMensual;
    }
    
}
