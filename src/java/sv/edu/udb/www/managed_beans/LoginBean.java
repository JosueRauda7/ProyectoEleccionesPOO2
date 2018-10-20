package sv.edu.udb.www.managed_beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.entities.CiudadanosEntity;
import sv.edu.udb.www.entities.MiembrojrvEntity;
import sv.edu.udb.www.entities.UsuariosEntity;
import sv.edu.udb.www.model.MiembrosJrvModel;
import sv.edu.udb.www.model.UsuariosModel;
import sv.edu.udb.www.utils.JsfUtils;

@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    @EJB
    private MiembrosJrvModel miembrosJrvModel;

    @EJB
    private UsuariosModel usuariosModel;

    private String usuario;
    private String password;

    public LoginBean() {

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String iniciarSesion() {
        UsuariosEntity user = usuariosModel.verificarCredenciales(usuario, password);
        if (user == null) {
            JsfUtils.addErrorMessage(null, "Usuario y/o password incorrecto");
            return null;
        } else {
            HttpServletRequest request = JsfUtils.getRequest();
            request.getSession().setAttribute("user", user.getIdUsuario());
            request.getSession().setAttribute("rol", user.getIdTipoUsuario().getIdTipoUsuario());
            if (null == user.getIdTipoUsuario().getIdTipoUsuario()) {
                return "/login?faces-redirect=true";
            }
            switch (user.getIdTipoUsuario().getIdTipoUsuario()) {
                case 1:
                    return "/administradorGeneral/index?faces-redirect=true";
                case 2:
                    return "/administradorDepartamental/index?faces-redirect=true";
                case 3:
                    MiembrojrvEntity miembro = new MiembrojrvEntity();
                    if (miembrosJrvModel.obtenerMiembroJRV2(user) != null) {
                        miembro = miembrosJrvModel.obtenerMiembroJRV2(user);
                        request.getSession().setAttribute("usuario",miembro.getIdMiembroJrv());
                        return "/procesoVoto/indexVotantes?faces-redirect=true";
                    }
                    return "/login?faces-redirect=true";
                case 4:
                    return "/gestionVotantes/inicioRNPN?faces-redirect=true";

                default:
                    return "/login?faces-redirect=true";
            }
        }
    }

    public String cerrarSesion() {
        JsfUtils.getRequest().getSession().invalidate();
        return"/login?faces-redirect=true";
    }

}
