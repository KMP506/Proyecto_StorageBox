/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.excepciones;

/**
 *
 * @author efrai
 */
public class EspacioOcupadoException extends NegocioException {
    public EspacioOcupadoException (String numeroEspacio){
        super("No se puede eliminar el espacion numero"+numeroEspacio+"porque se encuentra ocupado");
    }
}
