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
                    <h1>DETALLE COCHE</h1>
                    <h1 style="color:red">
                        <bean:write name="COCHE" property="marca"/>  
                        <bean:write name="COCHE" property="modelo"/>
                    </h1>
                    <h2 style="color:blue">
                        <bean:write name="COCHE" property="conductor"/>
                    </h2>
                    <img src="${COCHE.imagen}" style="width: 260px; height: 220px"/>
                </div>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
