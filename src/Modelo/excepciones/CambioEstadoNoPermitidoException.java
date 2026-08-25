/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author efrai
 */
public class CambioEstadoNoPermitidoException extends NegocioException {
  public CambioEstadoNoPermitidoException() {
    super("El cambio de estado solicitado no está permitido.");
    }
public CambioEstadoNoPermitidoException(String estadoActual,String estadoNuevo) {
     super("No se permite cambiar el contrato del estado "+ estadoActual + " al estado " + estadoNuevo + ".");
    }
} 
