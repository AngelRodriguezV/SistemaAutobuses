/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.AdministradorFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Administrador;

/**
 *
 * @author veneg
 */
@Stateless
@LocalBean
public class LnAdministrador {

    @EJB
    private AdministradorFacade administradorFacade;

    /**
     * Metodo para obtener la lista de administradores
     * @return 
     */
    public List<Administrador> findAdministradores() {
        return administradorFacade.findAll();
    }
    
    /**
     * Metodo para agregar un administrador a la base de datos
     * @param administrador 
     */
    public void addAdministrador(Administrador administrador) {
        administradorFacade.create(administrador);
    }
    
    /**
     * Metodo para recuperar un administrador mediante el id
     * @param idAdministrador
     * @return 
     */
    public Administrador finAdministrador(int idAdministrador) {
        return administradorFacade.find(idAdministrador);
    }
    
    /**
     * Metodo para actualizar un administrador
     * @param administrador 
     */
    public void editAdministrador(Administrador administrador) {
        administradorFacade.edit(administrador);
    }
    
}
