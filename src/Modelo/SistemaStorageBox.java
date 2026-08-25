/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.gestores.GestorClientes;

/**
 *
 * @author kevin
 */
public class SistemaStorageBox {
     private GestorClientes gestorClientes;
    public SistemaStorageBox() {
        gestorClientes = new GestorClientes();
    }
    public GestorClientes getGestorClientes() {
        return gestorClientes;
    }
}
