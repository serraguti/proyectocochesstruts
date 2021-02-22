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
                    <h1>Insertar coche</h1>
                    <html:form action="/ActionInsertarCoche">
                        <label>Id Coche: </label>
                        <html:text property="idcoche" styleClass="form-control"/><br/>
                        <label>Marca: </label>
                        <html:text property="marca" styleClass="form-control"/><br/>
                        <label>Modelo: </label>
                        <html:text property="modelo" styleClass="form-control"/><br/>
                        <label>Conductor: </label>
                        <html:text property="conductor" styleClass="form-control"/><br/>
                        <label>Imagen: </label>
                        <html:text property="imagen" styleClass="form-control"/><br/>
                        <button type="submit" class="btn btn-info">
                            Insertar coche
                        </button>
                    </html:form>
                </div>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
