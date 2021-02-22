package controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Coche;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import repositories.RepositoryCoches;

public class ActionBuscarCoches extends org.apache.struts.action.Action {
    RepositoryCoches repo;
    public ActionBuscarCoches(){
        this.repo = new RepositoryCoches();
    }
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm f = (DynaActionForm)form;
        String marca = f.get("search").toString();
        ArrayList<Coche> coches = this.repo.buscarCochesMarca(marca);
        //SI TENEMOS COCHES, SE LOS MANDAMOS A LA PAGINA
        if (coches != null){
            request.setAttribute("COCHESMARCA", coches);
        }
        return mapping.findForward("webcochesmarca");
    }
}
