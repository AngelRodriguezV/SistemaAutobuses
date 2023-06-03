/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.ClienteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Cliente;

/**
 *
 * @author veneg
 */
@Stateless
@LocalBean
public class LnCliente {

    @EJB
    private ClienteFacade clienteFacade;

    /**
     * Metodo para obtener la lista de clientes
     * @return 
     */
    public List<Cliente> findClientes() {
        return clienteFacade.findAll();
    }
    
    /**
     * Metodo para agregar un cliente a la base de datos
     * @param cliente
     */
    public void addCliente(Cliente cliente) {
        clienteFacade.create(cliente);
    }
    
    /**
     * Metodo para recuperar un cliente mediante el id
     * @param idCliente
     * @return 
     */
    public Cliente finCliente(int idCliente) {
        return clienteFacade.find(idCliente);
    }
    
    /**
     * Metodo para actualizar un cliente
     * @param cliente
     */
    public void editCliente(Cliente cliente) {
        clienteFacade.edit(cliente);
    }
    
    public Cliente finClienteByUsuario(int idUsuario) {
        return clienteFacade.getClienteByUsuario(idUsuario);
    }
    
}
