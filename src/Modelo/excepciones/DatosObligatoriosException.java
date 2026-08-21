/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author efrai
 */
public class DatosObligatoriosException extends NegocioException {
    public DatosObligatoriosException(){
        super("Debe ingresar todos los datos obligatorios.");
    }
    public DatosObligatoriosException(String campo ){
        super("El campo " + campo + " es obligatorio.");
    }
}
