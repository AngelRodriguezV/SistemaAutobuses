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
import logica_negocio.LnCliente;

/**
 *
 * @author veneg
 */
@Named(value = "controladorCliente")
@SessionScoped
public class ControladorCliente implements Serializable {

    @EJB
    private LnCliente lnCliente;
    
    @Inject
    private ExternalContext externalContext;
    
    private int panel;
    
    public ControladorCliente() {
        panel = 1;
    }

    public int getPanel() {
        return panel;
    }

    public void setPanel(int panel) {
        this.panel = panel;
    }
   
    public void horariosLink(){
        try {
            externalContext.redirect("faces/vista/horariosCliente.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControladorCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
