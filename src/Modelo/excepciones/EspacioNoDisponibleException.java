/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author efrai
 */
public class EspacioNoDisponibleException extends NegocioException {
    public EspacioNoDisponibleException(String numeroEspacio) {
        super("El espacio número " + numeroEspacio
          + " no está disponible durante el periodo seleccionado.");
    }
}
