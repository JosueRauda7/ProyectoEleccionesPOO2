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
@Table(name = "ciudadanojrv")
@NamedQueries({
    @NamedQuery(name = "CiudadanojrvEntity.findAll", query = "SELECT c FROM CiudadanojrvEntity c")
    , @NamedQuery(name = "CiudadanojrvEntity.findByIdCiudadanoJrv", query = "SELECT c FROM CiudadanojrvEntity c WHERE c.idCiudadanoJrv = :idCiudadanoJrv")})
public class CiudadanojrvEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idCiudadanoJrv;
    @JoinColumn(name = "duiCiudadano", referencedColumnName = "DuiCiudadano")
    @ManyToOne(optional = false)
    private CiudadanosEntity duiCiudadano;
    @JoinColumn(name = "idJrv", referencedColumnName = "IdJrv")
    @ManyToOne(optional = false)
    private JrvEntity idJrv;

    public CiudadanojrvEntity() {
    }

    public CiudadanojrvEntity(Integer idCiudadanoJrv) {
        this.idCiudadanoJrv = idCiudadanoJrv;
    }

    public Integer getIdCiudadanoJrv() {
        return idCiudadanoJrv;
    }

    public void setIdCiudadanoJrv(Integer idCiudadanoJrv) {
        this.idCiudadanoJrv = idCiudadanoJrv;
    }

    public CiudadanosEntity getDuiCiudadano() {
        return duiCiudadano;
    }

    public void setDuiCiudadano(CiudadanosEntity duiCiudadano) {
        this.duiCiudadano = duiCiudadano;
    }

    public JrvEntity getIdJrv() {
        return idJrv;
    }

    public void setIdJrv(JrvEntity idJrv) {
        this.idJrv = idJrv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiudadanoJrv != null ? idCiudadanoJrv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiudadanojrvEntity)) {
            return false;
        }
        CiudadanojrvEntity other = (CiudadanojrvEntity) object;
        if ((this.idCiudadanoJrv == null && other.idCiudadanoJrv != null) || (this.idCiudadanoJrv != null && !this.idCiudadanoJrv.equals(other.idCiudadanoJrv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.CiudadanojrvEntity[ idCiudadanoJrv=" + idCiudadanoJrv + " ]";
    }
    
}
