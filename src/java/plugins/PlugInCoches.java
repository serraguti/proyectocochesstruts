package plugins;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import models.Coche;
import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;
import repositories.RepositoryCoches;

public class PlugInCoches implements PlugIn {
    RepositoryCoches repo;
    
    public PlugInCoches(){
        this.repo = new RepositoryCoches();
    }
    
    @Override
    public void destroy() {}

    @Override
    public void init(ActionServlet servlet, ModuleConfig config) throws ServletException {
        try{
            ArrayList<Coche> coches = this.repo.getCoches();
            servlet.getServletContext().setAttribute("LISTCOCHES", coches);
        }catch (SQLException ex){
            throw new ServletException("ERROR SQL: " + ex);
        }
    }
    
}
