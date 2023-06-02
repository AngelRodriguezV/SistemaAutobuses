/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.ReciboFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Recibo;

/**
 *
 * @author veneg
 */
@Stateless
@LocalBean
public class LnRecibo {

    @EJB
    private ReciboFacade reciboFacade;

    /**
     * Metodo para obtener la lista de recibos
     * @return 
     */
    public List<Recibo> findRecibos() {
        return reciboFacade.findAll();
    }
    
    /**
     * Metodo para agregar un recibo a la base de datos
     * @param recibo 
     */
    public void addRecibo(Recibo recibo) {
        reciboFacade.create(recibo);
    }
    
    /**
     * Metodo para recuperar un recibo mediante el id
     * @param idRecibo
     * @return 
     */
    public Recibo finRecibo(int idRecibo) {
        return reciboFacade.find(idRecibo);
    }
    
    /**
     * Metodo para actualizar un recibo
     * @param recibo 
     */
    public void editRecibo(Recibo recibo) {
        reciboFacade.edit(recibo);
    }
}
