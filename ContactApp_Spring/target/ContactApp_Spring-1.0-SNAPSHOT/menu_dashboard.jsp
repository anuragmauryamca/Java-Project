

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.user==null}">
    HOME|Login|Register|About
</c:if>
<c:if test="${sessionScope.user!=null && sessionScope.role==1}">
    <!--admin menu-->
    HOME|User List|My Profile
</c:if>
<c:if test="${sessionScope.user!=null && sessionScope.role==1}">
   <!-- user menu-->
    HOME|Contact List|Contact Add |My Profile
</c:if>--%>

<html>
    <head>
        <style>
            a:hover{
              
                color: white;
                padding: auto;
            }
         
            a:visited{
                color: white;
                text-decoration: none;
            }
            
            .menu ul li{
               background-color: cadetblue;
                padding-top:4px;
                color:white;
                margin: 1px;
                float: left;
                list-style: none;
                  
                  height: 30px;
                  width: 100px;
                 text-align: center;
                  margin: 2px;
                 
               
            }
            .menu ul li:hover{background-color:darkcyan;};
        
     
            
        </style>
  
        
          </head>
    <body>
        
        
        
        
        
        <div class="menu">
            <ul> <li><a href="index.jsp" align="center">Home</li></a>
      
            
            <li>  <a href="add_contact.jsp">Add Contact</a></li>
            
            <li><a href="<c:url value="c_list_action.jsp"/>"> Contact List</a></li>
            <li>My profile</li>
            
            <a href="logout.jsp" style="margin-left: 400px">LogOut ${sessionScope.user.name}</a>
        
            </ul>
        </div>
        
        
        
        
        
        
    </body>
  
</html>
