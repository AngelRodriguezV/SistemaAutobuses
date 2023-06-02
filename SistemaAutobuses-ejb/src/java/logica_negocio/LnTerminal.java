/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.TerminalFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Terminal;

/**
 *
 * @author veneg
 */
@Stateless
@LocalBean
public class LnTerminal {

    @EJB
    private TerminalFacade terminalFacade;

    /**
     * Metodo para obtener la lista de terminales
     * @return 
     */
    public List<Terminal> findTerminales() {
        return terminalFacade.findAll();
    }
    
    /**
     * Metodo para agregar un terminal a la base de datos
     * @param terminal 
     */
    public void addTerminal(Terminal terminal) {
        terminalFacade.create(terminal);
    }
    
    /**
     * Metodo para recuperar un terminal mediante el id
     * @param idTerminal
     * @return 
     */
    public Terminal finTerminal(int idTerminal) {
        return terminalFacade.find(idTerminal);
    }
    
    /**
     * Metodo para actualizar un terminal
     * @param terminal 
     */
    public void editTerminal(Terminal terminal) {
        terminalFacade.edit(terminal);
    }
}
