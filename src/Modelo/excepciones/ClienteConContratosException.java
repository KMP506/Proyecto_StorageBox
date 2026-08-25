/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author efrai
 */
public class ClienteConContratosException extends NegocioException{
    public ClienteConContratosException(String identificacion) {
      super("No se puede eliminar el cliente con identificación "+ identificacion
          + " porque tiene contratos pendientes o activos.");
    }
}
