

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<!--        css_connection-->
<link href="logincss.css" rel="stylesheet" type="text/css"/>

<style>
 input{
    width:500px;
    height:20px;
    border-radius: 3px;
   
}
input:hover{border-color: darkred;}
textArea{
    width: 300px;
    height: 60px;
    margin-right: 200px;
  
}
textArea:hover{border-color: aqua;}
button:hover{border-color: aqua;border-radius: 2px;}
</style>

    </head>
    <body  bgcolor="#dcffeff">
        
        <table border="1" width="90%" align="center" >
<!--            Header-->
              <tr>
                  <td height="50" id="tr1"><h2 align="center" style="color:red;">Contact App user Registration</h2> </td>
            </tr>
<!--            Menu-->
            <tr>
                  <td height="30px" id="tr2" style="background-color:cadetblue;"><jsp:include page="menu.jsp"/></td>
            </tr>
<!--            Work-->
            <tr>
                <td height="400px" >
                    <!--<c:url var="url_reg value="/user_reg.jsp"/>-->
                   
                    <table cellpadding="8" class="log">
                        <form action="user_reg_action.jsp">
                            <tr><td colspan="8px" style=" color:darkcyan;font-size: 18px;"><u>New User Registrations</u></td> </tr>
                        <tr>
                            <td>Name</td> <td><input type="text" name="name" value="${param.name}"/></td>
                           
                        </tr>
                         <tr>
                          
                            <td>Phone</td> <td><input type="number" name="phone" value="${param.phone}"/></td>
                        </tr>
                         <tr>
                          
                             <td>Email</td> <td><input type="email" name="email" placeholder="@gmail" value="${param.email}"/></td>
                         </tr>
                         
                        <tr>
                          
                            <td>Address</td> <td><textarea name="address" placeholder="Address type here..." value="${param.address}"></textarea></td>
                            </tr>
                         
                      <tr>
                          
                          <td>User Name</td> <td><input type="text" name="username" placeholder="User name" value="${param.username}"/></td>
                            </tr>
                            <tr>
                          
                                <td>Password</td> <td><input type="password" name="password" placeholder="password"/></td>
                            </tr>
                             <tr>
                          
                                 <td colspan="2" align="right"><button>Sign</button></td>
                            </tr>
                             </form>
                    </table>
                       
                </td>
            </tr>
            <!--footer-->
            <tr>
                <td  height="20px" ><jsp:include page="footer.jsp"/></td>
            </tr>
        </table>
    </body>
</html>
