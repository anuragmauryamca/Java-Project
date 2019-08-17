<%-- 
    Document   : index
    Created on : Jul 21, 2019, 12:49:47 PM
    Author     : Amit Upadhyay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="cent">Welcome In Registration Page</h1>
        <h3><h1>
                <a href="#">Home</a> |
                <a href="view.jsp">View Record</a></h1></h3>
        <form action="UserService.jsp">
            <table border="5">
                <tr><td>ID</td><td><input type="text" name="id" ></td></tr>
                <tr><td>Name</td><td><input type="text" name="name" ></td></tr>
                <tr><td>Emial</td><td><input type="text" name="email" ></td></tr>
                <tr><td>Password</td><td><input type="text" name="pass" ></td></tr>
                <tr><td><button>Save</button></td></tr>
              
                
            </table>
        
            
        </form>
    </body>
</html>
