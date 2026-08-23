/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Modelo;

/**
 *
 * @author kevin
 */
public enum TipoEspacio {
    Pequeño(5,25000),
    Mediano(10,45000),
    Grande(20,70000);
    
    private final int tamanoM2;
    private final double precioDefecto;
    
    TipoEspacio(int tamanoM2, double  precioDefecto){
        this.tamanoM2 = tamanoM2;
        this.precioDefecto = precioDefecto;
    }
    
    public int getTamanoM2(){
        return this.tamanoM2;
    }
    public double getPrecioDefecto(){
        return this.precioDefecto;
    }
}
