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
@Table(name = "tipomiembro")
@NamedQueries({
    @NamedQuery(name = "TipomiembroEntity.findAll", query = "SELECT t FROM TipomiembroEntity t")
    , @NamedQuery(name = "TipomiembroEntity.findByIdTipoMiembro", query = "SELECT t FROM TipomiembroEntity t WHERE t.idTipoMiembro = :idTipoMiembro")
    , @NamedQuery(name = "TipomiembroEntity.findByTipoMiembro", query = "SELECT t FROM TipomiembroEntity t WHERE t.tipoMiembro = :tipoMiembro")})
public class TipomiembroEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idTipoMiembro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    private String tipoMiembro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoMiembro")
    private List<MiembrojrvEntity> miembrojrvEntityList;

    public TipomiembroEntity() {
    }

    public TipomiembroEntity(Integer idTipoMiembro) {
        this.idTipoMiembro = idTipoMiembro;
    }

    public TipomiembroEntity(Integer idTipoMiembro, String tipoMiembro) {
        this.idTipoMiembro = idTipoMiembro;
        this.tipoMiembro = tipoMiembro;
    }

    public Integer getIdTipoMiembro() {
        return idTipoMiembro;
    }

    public void setIdTipoMiembro(Integer idTipoMiembro) {
        this.idTipoMiembro = idTipoMiembro;
    }

    public String getTipoMiembro() {
        return tipoMiembro;
    }

    public void setTipoMiembro(String tipoMiembro) {
        this.tipoMiembro = tipoMiembro;
    }

    public List<MiembrojrvEntity> getMiembrojrvEntityList() {
        return miembrojrvEntityList;
    }

    public void setMiembrojrvEntityList(List<MiembrojrvEntity> miembrojrvEntityList) {
        this.miembrojrvEntityList = miembrojrvEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoMiembro != null ? idTipoMiembro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipomiembroEntity)) {
            return false;
        }
        TipomiembroEntity other = (TipomiembroEntity) object;
        if ((this.idTipoMiembro == null && other.idTipoMiembro != null) || (this.idTipoMiembro != null && !this.idTipoMiembro.equals(other.idTipoMiembro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.TipomiembroEntity[ idTipoMiembro=" + idTipoMiembro + " ]";
    }
    
}
