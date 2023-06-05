/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acceso_datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import modelo.Cliente;

/**
 *
 * @author veneg
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    @PersistenceContext(unitName = "SistemaAutobuses-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }
    
    public Cliente findByIdUsuario(Integer idUsuario) {
        TypedQuery<Cliente> query = em.createNamedQuery("Cliente.findByIdUsuario", Cliente.class);
        query.setParameter("idUsuario", idUsuario);
        List<Cliente> clientes = query.getResultList();
        if (!clientes.isEmpty()) {
            return clientes.get(0);
        }
        return null;
    }
    
}