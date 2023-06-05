/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package amds;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import logica_negocio.LnAdministrador;
import logica_negocio.LnCliente;
import logica_negocio.LnUsuario;
import modelo.Usuario;

/**
 *
 * @author veneg
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {
    
    @EJB
    private LnUsuario lnUsuario;
    
    @EJB
    private LnCliente lnCliente;
    
    @EJB
    private LnAdministrador lnAdministrador;
    
    
    private Usuario usuario;
    
    @Inject
    private ExternalContext externalContext;

    public Login() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void validarUsuario() {
        Usuario aux = lnUsuario.finUsuarioValidar(usuario.getEmail(), usuario.getPassword());
        if (aux != null) {
            System.out.println("Usuario Valido");
            usuario = aux;
            if (lnCliente.finClienteByUsuario((int)usuario.getIdUsuario()) != null) {
                try {
                    System.out.print("Session cliente");
                    externalContext.redirect("faces/vista/InicioCliente.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (lnAdministrador.finAdministradorByUsuario((int)usuario.getIdUsuario()) != null) {
                try {
                    System.out.print("Session Administrador");
                    externalContext.redirect("InicioAdmin.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("Usuario Invalido");
    }
}
