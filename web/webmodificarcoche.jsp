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
                    <h1>Modificar Coche</h1>
                    <html:form action="/ActionModificarCoche">
                        <html:hidden property="idcoche" value="${COCHE.idCoche}"
                                     styleClass="form-control"/>
                        <label>Marca </label>
                        <html:text property="marca" value="${COCHE.marca}"
                                   styleClass="form-control"/><br/>
                        <label>Modelo </label>
                        <html:text property="modelo" value="${COCHE.modelo}"
                                   styleClass="form-control"/><br/>
                        <label>Conductor: </label>
                        <html:text property="conductor" value="${COCHE.conductor}"
                                   styleClass="form-control"/><br/>
                        <label>Imagen </label>
                        <html:text property="imagen" value="${COCHE.imagen}"
                                   styleClass="form-control"/><br/>
                        <button type="submit" class="btn btn-info">
                            Modificar
                        </button>
                    </html:form>
                </div>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
