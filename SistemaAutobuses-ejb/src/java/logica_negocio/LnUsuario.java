/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package logica_negocio;

import acceso_datos.UsuarioFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Usuario;

/**
 *
 * @author veneg
 */
@Stateless
@LocalBean
public class LnUsuario {

    @EJB
    private UsuarioFacade usuarioFacade;
    
    /**
     * Metodo para obtener la lista de usuarios
     * @return 
     */
    public List<Usuario> findUsuarios() {
        return usuarioFacade.findAll();
    }
    
    /**
     * Metodo para agregar un usuario a la base de datos
     * @param usuario 
     */
    public void addUsuario(Usuario usuario) {
        usuarioFacade.create(usuario);
    }
    
    /**
     * Metodo para recuperar un usuario mediante el id
     * @param idUsuario
     * @return 
     */
    public Usuario finUsuario(int idUsuario) {
        return usuarioFacade.find(idUsuario);
    }
    
    /**
     * Metodo para actualizar un usuario
     * @param usuario 
     */
    public void editUsuario(Usuario usuario) {
        usuarioFacade.edit(usuario);
    }
    
    public Usuario finUsuarioByEmail(String email) {
        return usuarioFacade.getUsuarioByEmail(email);
    }
    
    public Usuario finUsuarioValidar(String email, String password) {
        return usuarioFacade.getUsuarioBySession(email, password);
    }
}
