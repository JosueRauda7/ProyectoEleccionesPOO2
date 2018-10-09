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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "centrovotacion")
@NamedQueries({
    @NamedQuery(name = "CentrovotacionEntity.findAll", query = "SELECT c FROM CentrovotacionEntity c")
    , @NamedQuery(name = "CentrovotacionEntity.findByIdCentroVotacion", query = "SELECT c FROM CentrovotacionEntity c WHERE c.idCentroVotacion = :idCentroVotacion")
    , @NamedQuery(name = "CentrovotacionEntity.findByCentroVotacion", query = "SELECT c FROM CentrovotacionEntity c WHERE c.centroVotacion = :centroVotacion")
    , @NamedQuery(name = "CentrovotacionEntity.findByDireccion", query = "SELECT c FROM CentrovotacionEntity c WHERE c.direccion = :direccion")})
public class CentrovotacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idCentroVotacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String centroVotacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentroVotacion")
    private List<CiudadanosEntity> ciudadanosEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCentroVotacion")
    private List<JrvEntity> jrvEntityList;
    @JoinColumn(name = "IdMunicipio", referencedColumnName = "IdMunicipio")
    @ManyToOne(optional = false)
    private MunicipiosEntity idMunicipio;

    public CentrovotacionEntity() {
    }

    public CentrovotacionEntity(Integer idCentroVotacion) {
        this.idCentroVotacion = idCentroVotacion;
    }

    public CentrovotacionEntity(Integer idCentroVotacion, String centroVotacion, String direccion) {
        this.idCentroVotacion = idCentroVotacion;
        this.centroVotacion = centroVotacion;
        this.direccion = direccion;
    }

    public Integer getIdCentroVotacion() {
        return idCentroVotacion;
    }

    public void setIdCentroVotacion(Integer idCentroVotacion) {
        this.idCentroVotacion = idCentroVotacion;
    }

    public String getCentroVotacion() {
        return centroVotacion;
    }

    public void setCentroVotacion(String centroVotacion) {
        this.centroVotacion = centroVotacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<CiudadanosEntity> getCiudadanosEntityList() {
        return ciudadanosEntityList;
    }

    public void setCiudadanosEntityList(List<CiudadanosEntity> ciudadanosEntityList) {
        this.ciudadanosEntityList = ciudadanosEntityList;
    }

    public List<JrvEntity> getJrvEntityList() {
        return jrvEntityList;
    }

    public void setJrvEntityList(List<JrvEntity> jrvEntityList) {
        this.jrvEntityList = jrvEntityList;
    }

    public MunicipiosEntity getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(MunicipiosEntity idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCentroVotacion != null ? idCentroVotacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CentrovotacionEntity)) {
            return false;
        }
        CentrovotacionEntity other = (CentrovotacionEntity) object;
        if ((this.idCentroVotacion == null && other.idCentroVotacion != null) || (this.idCentroVotacion != null && !this.idCentroVotacion.equals(other.idCentroVotacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.CentrovotacionEntity[ idCentroVotacion=" + idCentroVotacion + " ]";
    }
    
}
