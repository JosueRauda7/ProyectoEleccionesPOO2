package sv.edu.udb.www.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


public class JsfUtils {

    public static void addErrorMessage(String id, String mensaje) {
        FacesContext.getCurrentInstance().addMessage(id, new FacesMessage(mensaje));
    }

    public static void addFlashMessage(String id, Object obj) {
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put(id, obj);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

}
