<%-- 
    Document   : user_dashboard
    Created on : Aug 24, 2018, 6:01:15 AM
    Author     : Anurag
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        <table border="1" align="center" width="90%" style="border-collapse: collapse">
            <tr><td height="50" align="center">Welcome Contact App Service</td></tr>
            <tr><td height="20" ><jsp:include page="menu_dashboard.jsp"/></td></tr>
            <tr><td height="3" >
                     <table align="center"><tr><td><h5 style="color:white;font-size: 20px;border-radius: 105px;background-color: cadetblue; padding: 10px;text-decoration: underline">Welcome  ${sessionScope.user.name}</h5></td></tr></table>
                   
                    
                    <!--save Message--->
                   
                        <c:if  test="${param.act=='sv'}">
                            <h3 style="color:green">Data Saved Successfully</h3>
                        </c:if>
                        
                    
                
                
                
                
                </td></tr> 
              <tr><td height="200"></td></tr>
              <tr><td height="20"><jsp:include page="footer.jsp"></jsp:include></td></tr>
                     </table>
    </body>
</html>
