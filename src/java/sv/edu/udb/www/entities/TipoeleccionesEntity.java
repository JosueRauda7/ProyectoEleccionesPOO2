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
import javax.validation.constraints.Size;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "tipoelecciones")
@NamedQueries({
    @NamedQuery(name = "TipoeleccionesEntity.findAll", query = "SELECT t FROM TipoeleccionesEntity t")
    , @NamedQuery(name = "TipoeleccionesEntity.findByIdTipoEleccion", query = "SELECT t FROM TipoeleccionesEntity t WHERE t.idTipoEleccion = :idTipoEleccion")
    , @NamedQuery(name = "TipoeleccionesEntity.findByTipoEleccion", query = "SELECT t FROM TipoeleccionesEntity t WHERE t.tipoEleccion = :tipoEleccion")})
public class TipoeleccionesEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idTipoEleccion;
    @Size(max = 50)
    private String tipoEleccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoEleccion")
    private List<EleccionesEntity> eleccionesEntityList;

    public TipoeleccionesEntity() {
    }

    public TipoeleccionesEntity(Integer idTipoEleccion) {
        this.idTipoEleccion = idTipoEleccion;
    }

    public Integer getIdTipoEleccion() {
        return idTipoEleccion;
    }

    public void setIdTipoEleccion(Integer idTipoEleccion) {
        this.idTipoEleccion = idTipoEleccion;
    }

    public String getTipoEleccion() {
        return tipoEleccion;
    }

    public void setTipoEleccion(String tipoEleccion) {
        this.tipoEleccion = tipoEleccion;
    }

    public List<EleccionesEntity> getEleccionesEntityList() {
        return eleccionesEntityList;
    }

    public void setEleccionesEntityList(List<EleccionesEntity> eleccionesEntityList) {
        this.eleccionesEntityList = eleccionesEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEleccion != null ? idTipoEleccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoeleccionesEntity)) {
            return false;
        }
        TipoeleccionesEntity other = (TipoeleccionesEntity) object;
        if ((this.idTipoEleccion == null && other.idTipoEleccion != null) || (this.idTipoEleccion != null && !this.idTipoEleccion.equals(other.idTipoEleccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.TipoeleccionesEntity[ idTipoEleccion=" + idTipoEleccion + " ]";
    }
    
}
