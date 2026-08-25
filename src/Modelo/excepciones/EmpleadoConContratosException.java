/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author efrai
 */
public class EmpleadoConContratosException extends NegocioException {
  public EmpleadoConContratosException(String identificacion) {
     super("No se puede eliminar el empleado con identificación "+ identificacion
   + " porque tiene contratos asociados.");
    }
}
