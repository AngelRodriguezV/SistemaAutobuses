/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package amds;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import logica_negocio.LnBoleto;
import logica_negocio.LnHorario;
import logica_negocio.LnRecibo;
import modelo.Boleto;
import modelo.Horario;
import modelo.Recibo;

/**
 *
 * @author veneg
 */
@Named(value = "addComprarBoleto")
@SessionScoped
public class AddComprarBoleto implements Serializable {

    @EJB
    private LnHorario lnHorario;
    @EJB
    private LnRecibo lnRecibo;
    @EJB
    private LnBoleto lnBoleto;
    @Inject
    private Login login;
    
    private Horario horario;
    private Recibo recibo;
    
    public AddComprarBoleto() {
    }

    public List<Horario> getHorarios() {
        return lnHorario.findHorarios();
    }

    public Recibo getRecibo() {
        return recibo;
    }

    public void setRecibo(Recibo recibo) {
        this.recibo = recibo;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
    
    public String prepararCompra(Horario h){
        horario = h;
        recibo = new Recibo();
        return "boletoCompra";
    }
    
    public String comprarBoleto() {
        recibo.setIdCliente(login.getCliente());
        recibo.setIdHorario(horario);
        recibo.setFechaRegistro(new Date());
        lnRecibo.addRecibo(recibo);
        for (int i = 0; i < recibo.getCantidadAsientos(); i++) {
            Boleto boleto = new Boleto();
            boleto.setIdRecibo(recibo);
            lnBoleto.addBoleto(boleto);
        }
        horario.setAsientosDisponibles(horario.getAsientosDisponibles() - recibo.getCantidadAsientos());
        lnHorario.editHorario(horario);
        return "clienteBoletos";
    }
    
    public void calcularImporte() {
        recibo.setImporte(horario.getPrecio() * recibo.getCantidadAsientos());
    }
    
}
