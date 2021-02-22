package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Coche;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import repositories.RepositoryCoches;

public class ActionDetalleCoche extends org.apache.struts.action.Action {
    RepositoryCoches repo;
    
    public ActionDetalleCoche(){
        this.repo = new RepositoryCoches();
    }
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String dato = request.getParameter("id");
        int idcoche = Integer.parseInt(dato);
        Coche car = this.repo.buscarCoche(idcoche);
        request.setAttribute("COCHE", car);
        return mapping.findForward("webdetallecoche");
    }
}
