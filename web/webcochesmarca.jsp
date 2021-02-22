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
                    <h1>Coches Marca</h1>
                    <logic:present name="COCHESMARCA">
                        <table class="table table-danger">
                            <thead>
                                <tr>
                                    <th>Marca</th>
                                    <th>Modelo</th>
                                    <th>Conductor</th>
                                    <th>Imagen</th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:iterate name="COCHESMARCA" id="car">
                                    <tr>
                                        <td>
                                            <bean:write name="car" property="marca"/>
                                        </td>
                                        <td>
                                            <bean:write name="car" property="modelo"/>
                                        </td>
                                        <td>
                                            <bean:write name="car" property="conductor"/>
                                        </td>
                                        <td>
                                            <img src="${car.imagen}"
                                                 style="width:200px;height:200px"/>
                                        </td>
                                    </tr>
                                </logic:iterate>
                            </tbody>
                        </table>
                    </logic:present>
                </div>
            </main><!-- /.container -->            
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
    </body>
</html>
