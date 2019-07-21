<%-- 
    Document   : view
    Created on : Jul 21, 2019, 3:15:20 PM
    Author     : Amit Upadhyay
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h4> 
        <a href="index.jsp">Home |</a>
        <a href="#">View Details |</a>
        <a href="index.jsp">Add-Contact |</a></h4>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
            </tr>
        
        
        <%
          
        try{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
       Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mycurd","root","root");
            System.out.println("Success");
 
      
        String sql="select *from auth";
        PreparedStatement pst=con.prepareStatement(sql);
    
        ResultSet rs=pst.executeQuery();
        while(rs.next())
        {
        %>
        <tr>
            <td><%=rs.getInt(1)%></td>
            <td><%=rs.getString(2)%></td>
            <td><%=rs.getString(3)%></td>
            <td><%=rs.getString(4)%></td>
            <td>Delete | Update</td>
        </tr>
          
          
      <%  }
        
      
        con.close();
        pst.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        %>
        
        </table>
    </body>
</html>
