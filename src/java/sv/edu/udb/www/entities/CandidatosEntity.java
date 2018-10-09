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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "candidatos")
@NamedQueries({
    @NamedQuery(name = "CandidatosEntity.findAll", query = "SELECT c FROM CandidatosEntity c")
    , @NamedQuery(name = "CandidatosEntity.findByIdCandidato", query = "SELECT c FROM CandidatosEntity c WHERE c.idCandidato = :idCandidato")})
public class CandidatosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idCandidato;
    @JoinColumn(name = "CodigoPartido", referencedColumnName = "CodigoPartido")
    @ManyToOne(optional = false)
    private PartidosEntity codigoPartido;
    @JoinColumn(name = "DuiCiudadano", referencedColumnName = "DuiCiudadano")
    @ManyToOne(optional = false)
    private CiudadanosEntity duiCiudadano;
    @JoinColumn(name = "IdEleccion", referencedColumnName = "IdEleccion")
    @ManyToOne(optional = false)
    private EleccionesEntity idEleccion;
    @JoinColumn(name = "IdEstado", referencedColumnName = "IdEstado")
    @ManyToOne(optional = false)
    private EstadocandidatoEntity idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCandidato")
    private List<DetallevotoEntity> detallevotoEntityList;

    public CandidatosEntity() {
    }

    public CandidatosEntity(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    public Integer getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(Integer idCandidato) {
        this.idCandidato = idCandidato;
    }

    public PartidosEntity getCodigoPartido() {
        return codigoPartido;
    }

    public void setCodigoPartido(PartidosEntity codigoPartido) {
        this.codigoPartido = codigoPartido;
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

    public EstadocandidatoEntity getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadocandidatoEntity idEstado) {
        this.idEstado = idEstado;
    }

    public List<DetallevotoEntity> getDetallevotoEntityList() {
        return detallevotoEntityList;
    }

    public void setDetallevotoEntityList(List<DetallevotoEntity> detallevotoEntityList) {
        this.detallevotoEntityList = detallevotoEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCandidato != null ? idCandidato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidatosEntity)) {
            return false;
        }
        CandidatosEntity other = (CandidatosEntity) object;
        if ((this.idCandidato == null && other.idCandidato != null) || (this.idCandidato != null && !this.idCandidato.equals(other.idCandidato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.CandidatosEntity[ idCandidato=" + idCandidato + " ]";
    }
    
}
