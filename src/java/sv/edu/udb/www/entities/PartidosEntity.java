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
@Table(name = "partidos")
@NamedQueries({
    @NamedQuery(name = "PartidosEntity.findAll", query = "SELECT p FROM PartidosEntity p")
    , @NamedQuery(name = "PartidosEntity.findByCodigoPartido", query = "SELECT p FROM PartidosEntity p WHERE p.codigoPartido = :codigoPartido")
    , @NamedQuery(name = "PartidosEntity.findByNombrePartido", query = "SELECT p FROM PartidosEntity p WHERE p.nombrePartido = :nombrePartido")})
public class PartidosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String codigoPartido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nombrePartido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPartido")
    private List<CandidatosEntity> candidatosEntityList;

    public PartidosEntity() {
    }

    public PartidosEntity(String codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    public PartidosEntity(String codigoPartido, String nombrePartido) {
        this.codigoPartido = codigoPartido;
        this.nombrePartido = nombrePartido;
    }

    public String getCodigoPartido() {
        return codigoPartido;
    }

    public void setCodigoPartido(String codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    public String getNombrePartido() {
        return nombrePartido;
    }

    public void setNombrePartido(String nombrePartido) {
        this.nombrePartido = nombrePartido;
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
        hash += (codigoPartido != null ? codigoPartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartidosEntity)) {
            return false;
        }
        PartidosEntity other = (PartidosEntity) object;
        if ((this.codigoPartido == null && other.codigoPartido != null) || (this.codigoPartido != null && !this.codigoPartido.equals(other.codigoPartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.PartidosEntity[ codigoPartido=" + codigoPartido + " ]";
    }
    
}
