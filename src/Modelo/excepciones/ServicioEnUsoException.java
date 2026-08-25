/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author efrai
 */
public class ServicioEnUsoException extends NegocioException {
  public ServicioEnUsoException(String codigo) {
     super("No se puede eliminar el servicio con código" +codigo +" porque está asociado a un contrato.");
    }
}
