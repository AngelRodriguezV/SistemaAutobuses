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
@Table(name = "autobuse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autobuse.findAll", query = "SELECT a FROM Autobuse a"),
    @NamedQuery(name = "Autobuse.findByIdAutobuse", query = "SELECT a FROM Autobuse a WHERE a.idAutobuse = :idAutobuse"),
    @NamedQuery(name = "Autobuse.findByMatricula", query = "SELECT a FROM Autobuse a WHERE a.matricula = :matricula"),
    @NamedQuery(name = "Autobuse.findByNombre", query = "SELECT a FROM Autobuse a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Autobuse.findByNoAsientos", query = "SELECT a FROM Autobuse a WHERE a.noAsientos = :noAsientos")})
public class Autobuse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autobuse")
    private Integer idAutobuse;
    @Size(max = 13)
    @Column(name = "matricula")
    private String matricula;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "no_asientos")
    private Integer noAsientos;
    @OneToMany(mappedBy = "idAutobuse")
    private List<Horario> horarioList;

    public Autobuse() {
    }

    public Autobuse(Integer idAutobuse) {
        this.idAutobuse = idAutobuse;
    }

    public Integer getIdAutobuse() {
        return idAutobuse;
    }

    public void setIdAutobuse(Integer idAutobuse) {
        this.idAutobuse = idAutobuse;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNoAsientos() {
        return noAsientos;
    }

    public void setNoAsientos(Integer noAsientos) {
        this.noAsientos = noAsientos;
    }

    @XmlTransient
    public List<Horario> getHorarioList() {
        return horarioList;
    }

    public void setHorarioList(List<Horario> horarioList) {
        this.horarioList = horarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutobuse != null ? idAutobuse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autobuse)) {
            return false;
        }
        Autobuse other = (Autobuse) object;
        if ((this.idAutobuse == null && other.idAutobuse != null) || (this.idAutobuse != null && !this.idAutobuse.equals(other.idAutobuse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Autobuse[ idAutobuse=" + idAutobuse + " ]";
    }
    
}
