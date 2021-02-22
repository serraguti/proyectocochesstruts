<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/webhead.jsp"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="includes/webmenu.jsp"/>
        <section>
            <main role="main" class="container">
                <div class="starter-template">
                    <h1>Listado de coches</h1>
                    <table class="table table-bordered table-info">
                        <thead>
                            <tr>
                                <th>MARCA</th>
                                <th>MODELO</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <logic:iterate name="LISTCOCHES" id="car">
                                <tr>
                                    <td>
                                        <bean:write name="car" property="marca"/>
                                    </td>
                                    <td>
                                        <bean:write name="car" property="modelo"/>
                                    </td>
                                    <td>
                                        <html:link action="/ActionDetalleCoche"
                                                   paramId="id"
                                                   paramName="car"
                                                   paramProperty="idCoche" styleClass="btn btn-success">
                                            Detalles
                                        </html:link>
                                        <html:link action="/ActionModificarCoche"
                                                   paramId="id"
                                                   paramName="car"
                                                   paramProperty="idCoche" styleClass="btn btn-info">
                                            Modificar
                                        </html:link>
                                        <html:link action="/ActionEliminarCoche"
                                                   paramId="id"
                                                   paramName="car"
                                                   paramProperty="idCoche" styleClass="btn btn-danger">
                                            Eliminar
                                        </html:link>
                                    </td>
                                </tr>
                            </logic:iterate>
                        </tbody>
                    </table>
                </div>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
