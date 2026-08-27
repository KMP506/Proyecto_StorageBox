    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.gestores;

import Modelo.Cliente;
import Modelo.Contrato;
import Modelo.Espacio;
import java.time.LocalDate;
import java.util.LinkedList;
import Modelo.EstadoContrato;
/**
 *
 * @author isaac
 */
public class GestorContratos {
    
    private LinkedList<Contrato> contratos;
    private int siguienteNumero;
    
    public GestorContratos(){
        contratos= new LinkedList<>();
        siguienteNumero=1;
    }
    
    public Contrato agregar(Cliente cliente, Espacio espacio, LocalDate fechaInicio, LocalDate fechaFin){
        
        Contrato contrato= new Contrato(siguienteNumero, cliente, espacio, fechaInicio, fechaFin);
        
        contratos.add(contrato);
        siguienteNumero++;
        return contrato;
    }
    
    public Contrato buscar(int numeroContrato){
        
        for(Contrato contrato: contratos){
            if(contrato.getNumeroContrato()==numeroContrato){
                return contrato;
            }
        }
        return null;
    }
    public LinkedList<Contrato> getContratos(){
        return contratos;
    }
    public boolean hayConflicto(Espacio espacio, LocalDate fechaInicio, LocalDate fechaFin){
        
        for (Contrato contrato : contratos) {

        if (contrato.getEspacio()== espacio&& contrato.getEstado()!= EstadoContrato.Cancelado) {

            if (!fechaFin.isBefore(contrato.getFechaInicio())&& !fechaInicio.isAfter(contrato.getFechaFin())) {
                return true;
                }
            }
        }
    return false;
    }
    public boolean fechasValidas(LocalDate fechaInicio, LocalDate fechaFin){
        
        if(fechaFin.isAfter(fechaInicio)){
            return true;
        }
        return false;
    }
    
    public boolean espacioDisponible(Espacio espacio, LocalDate fechaInicio,LocalDate fechaFin){
        
        if(!fechasValidas(fechaInicio, fechaFin)){
            return false;
        }
        if(hayConflicto(espacio, fechaInicio, fechaFin)){
            return false;
        }
        return true;
    }
    
    public LinkedList<Contrato> filtrar(int numeroContrato, String cliente, String espacio, LocalDate fecha, EstadoContrato estado){
        
        LinkedList<Contrato> resultado= new LinkedList<>();
        for(Contrato contrato: contratos){
            
            boolean cumple= true;
            
            if(!cliente.isEmpty() && !contrato.getCliente().getId().contains(cliente) && !contrato.getCliente().getNombreCompleto().toLowerCase().contains(cliente.toLowerCase())){
                cumple= false;
            }
            if(!espacio.isEmpty() &&  !contrato.getEspacio().getNumeroEspacio().equalsIgnoreCase(espacio)){
                cumple=false;
            }
            if(fecha!= null && (fecha.isBefore(contrato.getFechaInicio()) || fecha.isAfter(contrato.getFechaFin()))){
                cumple= false;
            }
            if(estado!= null && contrato.getEstado()!= estado){
                cumple = false;
            }
            if(cumple){
                resultado.add(contrato);
            }
        }
        return resultado;
    }
}
