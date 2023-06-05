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
import logica_negocio.LnBoleto;
import modelo.Boleto;

/**
 *
 * @author veneg
 */
@Named(value = "listBoleto")
@SessionScoped
public class listBoleto implements Serializable {

    @EJB
    private LnBoleto lnBoleto;
    
    public listBoleto() {
    }
    
    public List<Boleto> getBoletos() {
        return lnBoleto.findBoletos();
    }
}
