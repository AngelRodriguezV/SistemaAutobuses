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
import modelo.Administrador;

/**
 *
 * @author veneg
 */
@Stateless
public class AdministradorFacade extends AbstractFacade<Administrador> {

    @PersistenceContext(unitName = "SistemaAutobuses-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdministradorFacade() {
        super(Administrador.class);
    }
    
    public Administrador getAdministradorByUsuario(int idUsuario) {
        TypedQuery<Administrador> query = em.createNamedQuery("Administrador.findByIdUsuario", Administrador.class);
        query.setParameter("idUsuario", idUsuario);
        List<Administrador> clientes = query.getResultList();
        if (!clientes.isEmpty()) {
            return clientes.get(0);
        }
        return null;
    }
    
}
