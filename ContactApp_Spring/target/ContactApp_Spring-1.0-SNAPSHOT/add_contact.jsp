
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- 
    Document   : user_dashboard
    Created on : Aug 24, 2018, 6:01:15 AM
    Author     : Anurag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="static/css/addcontact.css"/>
    </head>
    <body>
      
        <table border="1" align="center" width="90%">
            <tr><td height="50" align="center">Welcome Contact App Service</td></tr>
            <tr><td height="20" ><jsp:include page="menu_dashboard.jsp"/></td></tr>
             
            
                    <tr><td height="200">
                            <form action="user_addcontact_action.jsp">
                                <input type="hidden" name="cid" value="${param.cid}"/>
                                <table cellpadding="5" align="center">
                                    <h4 style="margin-left: 450px; text-decoration: underline;">Contact Details</h4><c:if test="${err!=null}" >
                                        <p>${err}</p>
                                    </c:if>
                                    
                 
                                    <tr>
                                        <td>Name</td><td><input type="text" name="name" value="${param.name}"></td>
                                    </tr>
                                    
                                    <tr>
                                        <td>Phone</td><td><input type="text" name="phone" value="${param.phone}"></td>
                                    </tr>
                                    <tr>
                                        <td>Email</td><td><input type="email" name="email" placeholder="@gmail" value="${param.email}"></td>
                                    </tr>
                                    <tr>
                                        <td>Address</td><td><textarea name="address" placeholder="permanent Address">${param.address}</textarea></td>
                                    </tr>
                                    <tr>
                                        <td>Remark</td><td><textarea name="remark">${param.remark}</textarea></td>
                                    </tr>
                                    
                                    <tr>
                                        <td align="right" colspan="2"><button>save</button></td>
                                    </tr>
                                    
                                </table>
                            </form>
                            
                            
                </td></tr>
               <tr><td height="20"><jsp:include page="footer.jsp"></jsp:include></td></tr>
            
      
        
        </table>
    </body>
</html>
