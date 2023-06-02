/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.AutobuseFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Autobuse;

/**
 *
 * @author veneg
 */
@Stateless
@LocalBean
public class LnAutobuse {

    @EJB
    private AutobuseFacade autobuseFacade;

    /**
     * Metodo para obtener la lista de autobuses
     * @return 
     */
    public List<Autobuse> findAutobuses() {
        return autobuseFacade.findAll();
    }
    
    /**
     * Metodo para agregar un autobuse a la base de datos
     * @param autobuse 
     */
    public void addAutobuse(Autobuse autobuse) {
        autobuseFacade.create(autobuse);
    }
    
    /**
     * Metodo para recuperar un autobuse mediante el id
     * @param idAutobuse
     * @return 
     */
    public Autobuse finAutobuse(int idAutobuse) {
        return autobuseFacade.find(idAutobuse);
    }
    
    /**
     * Metodo para actualizar un autobuse
     * @param autobuse 
     */
    public void editAutobuse(Autobuse autobuse) {
        autobuseFacade.edit(autobuse);
    }
}
