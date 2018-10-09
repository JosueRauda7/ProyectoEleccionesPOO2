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
@Table(name = "tipousuario")
@NamedQueries({
    @NamedQuery(name = "TipousuarioEntity.findAll", query = "SELECT t FROM TipousuarioEntity t")
    , @NamedQuery(name = "TipousuarioEntity.findByIdTipoUsuario", query = "SELECT t FROM TipousuarioEntity t WHERE t.idTipoUsuario = :idTipoUsuario")
    , @NamedQuery(name = "TipousuarioEntity.findByTipoUsuario", query = "SELECT t FROM TipousuarioEntity t WHERE t.tipoUsuario = :tipoUsuario")})
public class TipousuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idTipoUsuario;
    @Size(max = 50)
    private String tipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoUsuario")
    private List<UsuariosEntity> usuariosEntityList;

    public TipousuarioEntity() {
    }

    public TipousuarioEntity(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<UsuariosEntity> getUsuariosEntityList() {
        return usuariosEntityList;
    }

    public void setUsuariosEntityList(List<UsuariosEntity> usuariosEntityList) {
        this.usuariosEntityList = usuariosEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipousuarioEntity)) {
            return false;
        }
        TipousuarioEntity other = (TipousuarioEntity) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.TipousuarioEntity[ idTipoUsuario=" + idTipoUsuario + " ]";
    }
    
}
