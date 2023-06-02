/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author veneg
 */
@Entity
@Table(name = "terminal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Terminal.findAll", query = "SELECT t FROM Terminal t"),
    @NamedQuery(name = "Terminal.findByIdTerminal", query = "SELECT t FROM Terminal t WHERE t.idTerminal = :idTerminal"),
    @NamedQuery(name = "Terminal.findByNombre", query = "SELECT t FROM Terminal t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Terminal.findByEstado", query = "SELECT t FROM Terminal t WHERE t.estado = :estado"),
    @NamedQuery(name = "Terminal.findByCiudad", query = "SELECT t FROM Terminal t WHERE t.ciudad = :ciudad"),
    @NamedQuery(name = "Terminal.findByDireccion", query = "SELECT t FROM Terminal t WHERE t.direccion = :direccion")})
public class Terminal implements Serializable {

    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "estado")
    private String estado;
    @Size(max = 30)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_terminal")
    private Integer idTerminal;
    @OneToMany(mappedBy = "terminalOrigen")
    private List<Horario> horarioList;
    @OneToMany(mappedBy = "terminalDestino")
    private List<Horario> horarioList1;

    public Terminal() {
    }

    public Terminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }


    @XmlTransient
    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    @XmlTransient
    public List<Horario> getHorarioList1() {
        return horarioList1;
    }

    public void setHorarioList1(List<Horario> horarioList1) {
        this.horarioList1 = horarioList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTerminal != null ? idTerminal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terminal)) {
            return false;
        }
        Terminal other = (Terminal) object;
        if ((this.idTerminal == null && other.idTerminal != null) || (this.idTerminal != null && !this.idTerminal.equals(other.idTerminal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Terminal[ idTerminal=" + idTerminal + " ]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
