/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author efrai
 */
public class EspacioDuplicadoException extends NegocioException {
    public  EspacioDuplicadoException(String numeroEspacio) {
        super("Ya existe un espacio registrado con el número: "
                + numeroEspacio);
    }
}
