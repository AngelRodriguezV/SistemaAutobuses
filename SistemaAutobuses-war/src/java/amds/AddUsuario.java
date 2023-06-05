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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import logica_negocio.LnAdministrador;
import logica_negocio.LnCliente;


/**
 *
 * @author veneg
 */
@Named(value = "addUsuario")
@SessionScoped
public class AddUsuario implements Serializable {
    
    @EJB
    private LnUsuario lnUsuario;
    @EJB
    private LnCliente lnCliente;
    @EJB
    private LnAdministrador lnAdmin;
    
    private Usuario usuario;
    private Cliente cliente;
    private Administrador administrador;

    private List<String> tiposUsuarios;
    private String tipoUsuario;
    
    public AddUsuario() {
        usuario = new Usuario();
        cliente = new Cliente();
        administrador = new Administrador();
        tiposUsuarios = new ArrayList<String>();
        tiposUsuarios.add("Cliente");
        tiposUsuarios.add("Administrador");
        tipoUsuario = "";
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

    public List<String> getTiposUsuarios() {
        return tiposUsuarios;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public void agregarUsuario() {
        lnUsuario.addUsuario(usuario);
        System.out.print(usuario.toString());
        if (tipoCliente()) {
            cliente.setIdUsuario(usuario);
            cliente.setFechaIngreso(new Date());
            lnCliente.addCliente(cliente);
        }
        if (tipoAdmin()) {
            administrador.setIdUsuario(usuario);
            lnAdmin.addAdministrador(administrador);
        }
        usuario = new Usuario();
        cliente = new Cliente();
        administrador = new Administrador();
    }
    
    public boolean tipoCliente() {
        return tipoUsuario.equals("Cliente");
    }
    
    public boolean tipoAdmin() {
        return tipoUsuario.equals("Administrador");
    }
}
