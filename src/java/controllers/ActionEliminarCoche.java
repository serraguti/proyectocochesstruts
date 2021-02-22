package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Coche;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import repositories.RepositoryCoches;

public class ActionEliminarCoche extends org.apache.struts.action.Action {
    RepositoryCoches repo;
    public ActionEliminarCoche(){
        this.repo = new RepositoryCoches();
    }
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String dato = request.getParameter("id");
        int idcoche = Integer.parseInt(dato);
        this.repo.eliminarCoche(idcoche);
        ArrayList<Coche> coches = this.repo.getCoches();
        request.getServletContext().setAttribute("LISTCOCHES", coches);
        return mapping.findForward("webcoches");
    }
}
