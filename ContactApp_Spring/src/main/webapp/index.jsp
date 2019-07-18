

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="logincss.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>welcome contact app</title>
        <style>
            input{
                width: 200px;
                border-radius: 5px;
            }
/*            <!---Fb Ld --->*/


        </style>
       
    
    </head>

    <body>

        <table border="1" width="90%" align="center">


            <!--header-->
            <tr id="tr1"><td height="50px"><h2 align="center">
                        <jsp:include page="header.jsp"/>
                        <div style="width:150px;height: 35px;margin-left: 900px;">
                            <table align="center" >
                              
                                <tr>  <u>
                                    <td width="50"><a href="<c:url value="https://www.facebook.com"/>"><img src="static/css/img/facebookIcon.jpg"/></a> </td>
                                    <td width="50px"><a href="<c:url value="https://www.linkedin.com"/>"><img src="static/css/img/linkedinIcon.jpg"/></a></td>
                                    <td  width="50px"><a href="<c:url value="https://www.twitter.com"/>"><img src="static/css/img/twitterIcon.jpg"/></a></td>
                                    
                                    </u>
                                </tr>
                               
                            </table>
                            </div>
                        </div>


                </td></tr>

            <!--manu-->
            <tr id="tr2" height="20px" style="background-color:cadetblue;"><td height="8px" valign="top">
                    <jsp:include page="menu.jsp"/>

                </td></tr>
            <tr><td><marquee scrollamount="7px" style="color:darkblue"> This is a contact App Application it used to use Managed your Contact Details ...!  </marquee></td></tr>


            <!--work aria-->    
            <tr><td height="400px" valign="top">

                    <!--login Aria-->
                    <form action="user_login_action.jsp">
                        <table cellpadding="5" class="log">
                            <c:if test="${err!=null}">
                                <p style="color:red">${err}</p>
                            </c:if>
                                  <c:if test="${param.act=='ad'}">
                                <p style="color:red">Access Denied Please Login to  perform </p>
                            </c:if>


                            <tr>

                            <tr><td colspan="8px">User Authentication</td></tr>
                            <td>User Name</td><td ><input type="text" name="username" placeholder="user name"  id="td1"/></td>
                            </tr><br/>
                            <tr>

                                <td>Password</td><td ><input type="password" name="password" placeholder="password" id="td2"/></td>
                            </tr><br/>
                            <tr>  
                                <td align="right" colspan="2"><button id="td1">Login</button>

                                    <!--    <a href="">New User</a>-->
                                    <a href="reg_form.jsp">New User</a>

                                </td>

                            </tr>


                        </table>



                    </form>




                </td></tr>











            <!--footer-->
            <tr id="tr2"><td height="5px"><jsp:include page="footer.jsp"/>

                </td></tr>
        </table>


    </body>
</html>
