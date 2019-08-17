<%-- 
    Document   : UserService
    Created on : Jul 21, 2019, 2:49:28 PM
    Author     : Amit Upadhyay
--%>

<%@page import="com.curd.pojo.Auth"%>
<%@page import="com.curd.pojo.DaoUser"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Home</h1>
        <%
            int uid=Integer.parseInt(request.getParameter("id"));
            String uname=request.getParameter("name");
            String uemail=request.getParameter("email");
            String upass=request.getParameter("pass");
            
           
            Auth auth=new Auth();
             auth.setId(uid);
             auth.setName(uname);
             auth.setEmail(uemail);
             auth.setPassword(upass);
            
            DaoUser daoUser=new DaoUser();
                daoUser.saveUser(auth);
                response.sendRedirect("dash.jsp");

        
        %>
    </body>
</html>
