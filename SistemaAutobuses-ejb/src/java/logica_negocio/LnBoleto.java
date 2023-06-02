/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.BoletoFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Boleto;

/**
 *
 * @author veneg
 */
@Stateless
@LocalBean
public class LnBoleto {

    @EJB
    private BoletoFacade boletoFacade;

    /**
     * Metodo para obtener la lista de boletos
     * @return 
     */
    public List<Boleto> findBoletos() {
        return boletoFacade.findAll();
    }
    
    /**
     * Metodo para agregar un boleto a la base de datos
     * @param boleto 
     */
    public void addBoleto(Boleto boleto) {
        boletoFacade.create(boleto);
    }
    
    /**
     * Metodo para recuperar un boleto mediante el id
     * @param idBoleto
     * @return 
     */
    public Boleto finBoleto(int idBoleto) {
        return boletoFacade.find(idBoleto);
    }
    
    /**
     * Metodo para actualizar un boleto
     * @param boleto 
     */
    public void editBoleto(Boleto boleto) {
        boletoFacade.edit(boleto);
    }
}
