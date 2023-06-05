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
import modelo.Administrador;
import modelo.Cliente;
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
    private Boolean loginSession = false;
    
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

    public Boolean getLoginSession() {
        return loginSession;
    }

    public void setLoginSession(Boolean loginSession) {
        this.loginSession = loginSession;
    }
    
    public String validarUsuario() {
        Usuario aux = lnUsuario.finUsuarioValidar(usuario.getEmail(), usuario.getPassword());
        if (aux != null) {
            System.out.println("Usuario Valido");
            usuario = aux;
            loginSession = true;
            if (lnCliente.finClienteByUsuario((int)usuario.getIdUsuario()) != null) {
                System.out.print("Session cliente");
                return "index";
            }
            if (lnAdministrador.finAdministradorByUsuario((int)usuario.getIdUsuario()) != null) {
                System.out.print("Session Administrador");
                return "index";
            }
        }
        System.out.println("Usuario Invalido");
        return null;
    }
    
    public boolean isCliente(){
        if (loginSession) {
            return lnCliente.finClienteByUsuario((int)usuario.getIdUsuario()) != null;
        }
        return false;
    }
    
    public boolean isAdmin() {
        if (loginSession) {
            return lnAdministrador.finAdministradorByUsuario((int)usuario.getIdUsuario()) != null;
        }
        return false;
    }
    
    public Cliente getCliente() {
        if (loginSession) {
            return (Cliente)lnCliente.finClienteByUsuario((int)usuario.getIdUsuario());
        }
        return null;
    }
    
    public Administrador getAdmin() {
        if (loginSession) {
            return lnAdministrador.finAdministradorByUsuario((int)usuario.getIdUsuario());
        }
        return null;
    }
}
