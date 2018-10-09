/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "elecciones")
@NamedQueries({
    @NamedQuery(name = "EleccionesEntity.findAll", query = "SELECT e FROM EleccionesEntity e")
    , @NamedQuery(name = "EleccionesEntity.findByIdEleccion", query = "SELECT e FROM EleccionesEntity e WHERE e.idEleccion = :idEleccion")
    , @NamedQuery(name = "EleccionesEntity.findByDescripcionEleccion", query = "SELECT e FROM EleccionesEntity e WHERE e.descripcionEleccion = :descripcionEleccion")
    , @NamedQuery(name = "EleccionesEntity.findByFechaInicio", query = "SELECT e FROM EleccionesEntity e WHERE e.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "EleccionesEntity.findByFechaRegistro", query = "SELECT e FROM EleccionesEntity e WHERE e.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "EleccionesEntity.findByFechaFinRegistro", query = "SELECT e FROM EleccionesEntity e WHERE e.fechaFinRegistro = :fechaFinRegistro")})
public class EleccionesEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    private String idEleccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String descripcionEleccion;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaFinRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEleccion")
    private List<CandidatosEntity> candidatosEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEleccion")
    private List<JrvEntity> jrvEntityList;
    @JoinColumn(name = "IdTipoEleccion", referencedColumnName = "IdTipoEleccion")
    @ManyToOne(optional = false)
    private TipoeleccionesEntity idTipoEleccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEleccion")
    private List<ConteovotantesEntity> conteovotantesEntityList;

    public EleccionesEntity() {
    }

    public EleccionesEntity(String idEleccion) {
        this.idEleccion = idEleccion;
    }

    public EleccionesEntity(String idEleccion, String descripcionEleccion, Date fechaInicio, Date fechaRegistro, Date fechaFinRegistro) {
        this.idEleccion = idEleccion;
        this.descripcionEleccion = descripcionEleccion;
        this.fechaInicio = fechaInicio;
        this.fechaRegistro = fechaRegistro;
        this.fechaFinRegistro = fechaFinRegistro;
    }

    public String getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(String idEleccion) {
        this.idEleccion = idEleccion;
    }

    public String getDescripcionEleccion() {
        return descripcionEleccion;
    }

    public void setDescripcionEleccion(String descripcionEleccion) {
        this.descripcionEleccion = descripcionEleccion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaFinRegistro() {
        return fechaFinRegistro;
    }

    public void setFechaFinRegistro(Date fechaFinRegistro) {
        this.fechaFinRegistro = fechaFinRegistro;
    }

    public List<CandidatosEntity> getCandidatosEntityList() {
        return candidatosEntityList;
    }

    public void setCandidatosEntityList(List<CandidatosEntity> candidatosEntityList) {
        this.candidatosEntityList = candidatosEntityList;
    }

    public List<JrvEntity> getJrvEntityList() {
        return jrvEntityList;
    }

    public void setJrvEntityList(List<JrvEntity> jrvEntityList) {
        this.jrvEntityList = jrvEntityList;
    }

    public TipoeleccionesEntity getIdTipoEleccion() {
        return idTipoEleccion;
    }

    public void setIdTipoEleccion(TipoeleccionesEntity idTipoEleccion) {
        this.idTipoEleccion = idTipoEleccion;
    }

    public List<ConteovotantesEntity> getConteovotantesEntityList() {
        return conteovotantesEntityList;
    }

    public void setConteovotantesEntityList(List<ConteovotantesEntity> conteovotantesEntityList) {
        this.conteovotantesEntityList = conteovotantesEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEleccion != null ? idEleccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EleccionesEntity)) {
            return false;
        }
        EleccionesEntity other = (EleccionesEntity) object;
        if ((this.idEleccion == null && other.idEleccion != null) || (this.idEleccion != null && !this.idEleccion.equals(other.idEleccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.EleccionesEntity[ idEleccion=" + idEleccion + " ]";
    }
    
}
