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

public class ActionInsertarCoche extends org.apache.struts.action.Action {
    RepositoryCoches repo;
    
    public ActionInsertarCoche(){
        this.repo = new RepositoryCoches();
    }
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm f = (DynaActionForm)form;
        String dato = f.get("idcoche").toString();
        int idcoche = Integer.parseInt(dato);
        String marca = f.get("marca").toString();
        String modelo = f.get("modelo").toString();
        String conductor = f.get("conductor").toString();
        String imagen = f.get("imagen").toString();
        this.repo.insertarCoche(idcoche, marca, modelo, conductor, imagen);
        ArrayList<Coche> coches = this.repo.getCoches();
        request.getServletContext().setAttribute("LISTCOCHES", coches);
        return mapping.findForward("webcoches");
    }
}
