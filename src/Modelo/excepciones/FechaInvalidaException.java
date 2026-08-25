/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author efrai
 */
public class FechaInvalidaException extends NegocioException {
    public FechaInvalidaException(){
        super("La fecha ingresada no es valida.");
    }
    public FechaInvalidaException(String mensaje){
        super(mensaje);
    }
}
