/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package amds;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import logica_negocio.LnRecibo;
import modelo.Recibo;

/**
 *
 * @author veneg
 */
@Named(value = "listRecibos")
@SessionScoped
public class listRecibos implements Serializable {

    @EJB
    private LnRecibo lnRecibo;
    
    public listRecibos() {
    }
    
    public List<Recibo> getRecibos() {
        return lnRecibo.findRecibos();
    }
}
