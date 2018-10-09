/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "estadocandidato")
@NamedQueries({
    @NamedQuery(name = "EstadocandidatoEntity.findAll", query = "SELECT e FROM EstadocandidatoEntity e")
    , @NamedQuery(name = "EstadocandidatoEntity.findByIdEstado", query = "SELECT e FROM EstadocandidatoEntity e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadocandidatoEntity.findByEstado", query = "SELECT e FROM EstadocandidatoEntity e WHERE e.estado = :estado")})
public class EstadocandidatoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private List<CandidatosEntity> candidatosEntityList;

    public EstadocandidatoEntity() {
    }

    public EstadocandidatoEntity(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadocandidatoEntity(Integer idEstado, String estado) {
        this.idEstado = idEstado;
        this.estado = estado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<CandidatosEntity> getCandidatosEntityList() {
        return candidatosEntityList;
    }

    public void setCandidatosEntityList(List<CandidatosEntity> candidatosEntityList) {
        this.candidatosEntityList = candidatosEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadocandidatoEntity)) {
            return false;
        }
        EstadocandidatoEntity other = (EstadocandidatoEntity) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.EstadocandidatoEntity[ idEstado=" + idEstado + " ]";
    }
    
}
