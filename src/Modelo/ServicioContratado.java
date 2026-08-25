/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author kevin
 */
public class ServicioContratado implements Cobrable {
    private ServicioAdicional servicio;
    private int cantidad;
    
    public ServicioContratado(ServicioAdicional servicio, int cantidad){
        this.servicio = servicio;
        this.cantidad = cantidad;
    }
    
    public ServicioAdicional getServicio(){
        return this.servicio;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }

    @Override
    public double calcularMonto() {
       return servicio.getPrecio()*cantidad;
    }
}
