/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.HorarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Horario;

/**
 *
 * @author veneg
 */
@Stateless
@LocalBean
public class LnHorario {

    @EJB
    private HorarioFacade horarioFacade;

    /**
     * Metodo para obtener la lista de horarios
     * @return 
     */
    public List<Horario> findHorarios() {
        return horarioFacade.findAll();
    }
    
    /**
     * Metodo para agregar un horario a la base de datos
     * @param horario 
     */
    public void addHorario(Horario horario) {
        horarioFacade.create(horario);
    }
    
    /**
     * Metodo para recuperar un horario mediante el id
     * @param idHorario
     * @return 
     */
    public Horario finHorario(int idHorario) {
        return horarioFacade.find(idHorario);
    }
    
    /**
     * Metodo para actualizar un horario
     * @param horario 
     */
    public void editHorario(Horario horario) {
        horarioFacade.edit(horario);
    }
}
