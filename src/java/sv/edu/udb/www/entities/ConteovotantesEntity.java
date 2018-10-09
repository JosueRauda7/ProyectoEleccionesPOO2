/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "conteovotantes")
@NamedQueries({
    @NamedQuery(name = "ConteovotantesEntity.findAll", query = "SELECT c FROM ConteovotantesEntity c")
    , @NamedQuery(name = "ConteovotantesEntity.findByIdConteoVotantes", query = "SELECT c FROM ConteovotantesEntity c WHERE c.idConteoVotantes = :idConteoVotantes")})
public class ConteovotantesEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idConteoVotantes;
    @JoinColumn(name = "DuiCiudadano", referencedColumnName = "DuiCiudadano")
    @ManyToOne(optional = false)
    private CiudadanosEntity duiCiudadano;
    @JoinColumn(name = "IdEleccion", referencedColumnName = "IdEleccion")
    @ManyToOne(optional = false)
    private EleccionesEntity idEleccion;

    public ConteovotantesEntity() {
    }

    public ConteovotantesEntity(Integer idConteoVotantes) {
        this.idConteoVotantes = idConteoVotantes;
    }

    public Integer getIdConteoVotantes() {
        return idConteoVotantes;
    }

    public void setIdConteoVotantes(Integer idConteoVotantes) {
        this.idConteoVotantes = idConteoVotantes;
    }

    public CiudadanosEntity getDuiCiudadano() {
        return duiCiudadano;
    }

    public void setDuiCiudadano(CiudadanosEntity duiCiudadano) {
        this.duiCiudadano = duiCiudadano;
    }

    public EleccionesEntity getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(EleccionesEntity idEleccion) {
        this.idEleccion = idEleccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConteoVotantes != null ? idConteoVotantes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConteovotantesEntity)) {
            return false;
        }
        ConteovotantesEntity other = (ConteovotantesEntity) object;
        if ((this.idConteoVotantes == null && other.idConteoVotantes != null) || (this.idConteoVotantes != null && !this.idConteoVotantes.equals(other.idConteoVotantes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.ConteovotantesEntity[ idConteoVotantes=" + idConteoVotantes + " ]";
    }
    
}
