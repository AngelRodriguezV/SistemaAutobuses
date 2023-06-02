/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package amds;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import logica_negocio.LnUsuario;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Usuario;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;


/**
 *
 * @author veneg
 */
@Named(value = "addUsuario")
@SessionScoped
public class AddUsuario implements Serializable {
    
    @EJB
    private LnUsuario lnUsuario;
    
    private Usuario usuario;
    private Cliente cliente;
    private Administrador administrador;

    public AddUsuario() {
        usuario = new Usuario();
        cliente = new Cliente();
        administrador = new Administrador();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public void agregarUsuario() {
        lnUsuario.addUsuario(usuario);
        System.out.print(usuario.toString());
    }
}
