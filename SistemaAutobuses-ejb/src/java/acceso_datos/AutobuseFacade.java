/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Autobuse;

/**
 *
 * @author veneg
 */
@Stateless
public class AutobuseFacade extends AbstractFacade<Autobuse> {

    @PersistenceContext(unitName = "SistemaAutobuses-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AutobuseFacade() {
        super(Autobuse.class);
    }
    
}
