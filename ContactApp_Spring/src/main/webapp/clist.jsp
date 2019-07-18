



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

<!--                      Css-->
<link href="mycss.css" rel="stylesheet" type="text/css"/>





    <body>
      
      
        <table align="center" width="90%" border="2">
            
            <tr ><td height="50" align="center"><h1>Welcome Contact App List Service</h1></td></tr>
            <tr><td height="30" ><jsp:include page="menu_dashboard.jsp"/></td></tr>
            
                    <tr ><td height="200">
                  <!-- searching---->
                            <form action="search.jsp">
                                <input type="text" name="criteria" value="" placeholder="search"/ >
                                <button>Find</button>
                            </form>
                            
                         
                            <table border="2"  cellpadding="5px" style="background-color: chocolate;"  align="center">
                                <c:if test="${param.act=='up'}">
                                    <p style="color: green">Updata Successfully   </p>
                                        
                                    </c:if>
                                        <c:if  test="${param.act=='del'}">
                                            <p style="color:green"> Delete Successfully</p>
                                        </c:if>
                                       <c:if  test="${param.act=='sv'}">
                                           <p style="color:green">  Data Saved Successfully</p>
                                        </c:if>
                                      
                              
                             
                                
                                <tr id="tr1">
                            <td>SR</td>
                            <td>CID</td>
                            <td>NAME</td>
                            <td>PHONE</td>
                            <td>EMAIL</td>
                            <td>ADDRESS</td>
                            <td>REMARK</td>
                            <td colspan="2px">ACTION</td>
                        </tr>
                        <c:forEach varStatus="st" var="c" items="${contactList}" >
                            <tr id="tr2" style="font-size: 13px">
                                <td>${st.count}</td>
                                <td>${c.contactId}</td>
                                <td>${c.name}</td>
                                <td>${c.phone}</td>
                                <td>${c.email}</td>
                                <td>${c.address}</td>
                                <td>${c.remark}</td>
                                
                                <c:url var="del" value="del_user_list.jsp">
                                    <c:param name="cid" value="${c.contactId}">
                                        
                                    </c:param>
                                </c:url>
                                <td ><a href="${del}">Delete</a></td>
                                
                                 <c:url var="edit" value="edit_user.jsp">
                                    <c:param name="cid" value="${c.contactId}">
                                        
                                    </c:param>
                                </c:url>
                                
                                 <td><a href="${edit}">Edit</a></td>
                                
                                
                                
                            </tr>
                        </c:forEach>
                    </table> 

                      
                            
                                       
                </td></tr>
               <tr><td height="20"></td></tr>
                     </table>
    </body>
</html>
      
                            
 