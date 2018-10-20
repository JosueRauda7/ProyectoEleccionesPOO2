/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
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
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "UsuariosEntity.findAll", query = "SELECT u FROM UsuariosEntity u")
    , @NamedQuery(name = "UsuariosEntity.checkLogin", query = "SELECT u FROM UsuariosEntity u WHERE u.idUsuario=:usuario AND u.contrasena=:clave")
    , @NamedQuery(name = "UsuariosEntity.findByIdUsuario", query = "SELECT u FROM UsuariosEntity u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "UsuariosEntity.findByNombreUsuario", query = "SELECT u FROM UsuariosEntity u WHERE u.nombreUsuario = :nombreUsuario")
    , @NamedQuery(name = "UsuariosEntity.findByApellidoUsuario", query = "SELECT u FROM UsuariosEntity u WHERE u.apellidoUsuario = :apellidoUsuario")
    , @NamedQuery(name = "UsuariosEntity.findByContrasena", query = "SELECT u FROM UsuariosEntity u WHERE u.contrasena = :contrasena")
    , @NamedQuery(name = "UsuariosEntity.findByCorreo", query = "SELECT u FROM UsuariosEntity u WHERE u.correo = :correo")})
public class UsuariosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    private String idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String apellidoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String contrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String correo;
    @JoinColumn(name = "IdDepartamento", referencedColumnName = "IdDepartamento")
    @ManyToOne(optional = false)
    private DepartamentosEntity idDepartamento;
    @JoinColumn(name = "IdTipoUsuario", referencedColumnName = "IdTipoUsuario")
    @ManyToOne(optional = false)
    private TipousuarioEntity idTipoUsuario;
    @OneToMany(mappedBy = "idUsuario")
    private List<JrvEntity> jrvEntityList;

    public UsuariosEntity() {
    }

    public UsuariosEntity(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuariosEntity(String idUsuario, String nombreUsuario, String apellidoUsuario, String contrasena, String correo) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public DepartamentosEntity getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(DepartamentosEntity idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public TipousuarioEntity getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(TipousuarioEntity idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public List<JrvEntity> getJrvEntityList() {
        return jrvEntityList;
    }

    public void setJrvEntityList(List<JrvEntity> jrvEntityList) {
        this.jrvEntityList = jrvEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuariosEntity)) {
            return false;
        }
        UsuariosEntity other = (UsuariosEntity) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.UsuariosEntity[ idUsuario=" + idUsuario + " ]";
    }
    
}
