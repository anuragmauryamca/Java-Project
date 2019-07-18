



<%@page import="java.util.List"%>
<%@page import="net.ezeon.capp.domain.User"%>
<%@page import="net.ezeon.capp.service.UserService"%>
<%@page import="net.ezeon.capp.service.SpringUtil"%>
<%-- 
    Document   : user_dashboard
    Created on : Aug 24, 2018, 6:01:15 AM
    Author     : Anurag
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    UserService userService = SpringUtil.ctx.getBean(UserService.class);
%>
<%
    request.setAttribute("userList", userService.findAll());

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User List</title>

        <!--                      Css-->
        <link href="mycss.css" rel="stylesheet" type="text/css"/>
        <script src=<c:url value="static/jquery-3.3.1.min.js"/>></script>
        <script>
            $(document).ready(function () {
                //alert('jquery is configured yes');
                alert("---");
            });

            function changeActiveBlockStatus(userId, status, id_res) {
                alert(userId + " " + status + " " + id_res );
                $.ajax({
                    url: "change_status.jsp",
                    data: {
                        userId: userId,
                        status: status,
                        id_res: id_res
                    },
                    success: function (serverResp) {
                        $("#" + id_res).html(serverResp);
                    }
                });


            }
            function check() {
                alert("ffffff");
            }



        </script>





    <body>


        <table align="center" width="90%" border="2">

            <tr ><td height="50" align="center"><h1>Welcome Contact App User List Service</h1></td></tr>
            <tr><td height="30" ><a href="<c:url value="admin_dashboard.jsp"/>">Home</a></td></tr>

            <tr ><td height="200">


                    <table border="2"  cellpadding="5px" style="background-color: chocolate;"  align="center">



                        <tr id="tr1">
                            <td>SR</td>
                            <td>User ID</td>
                            <td>NAME</td>
                            <td>PHONE</td>
                            <td>EMAIL</td>
                            <td>ADDRESS</td>
                            <td>Login Name</td>
                            <td>Role</td>
                            <td>Status</td>
                            <td colspan="2px">ACTION</td>
                        </tr>
                        <c:forEach varStatus="st" var="c" items="${userList}" >
                            <tr id="tr2" style="font-size: 13px">
                                <td>${st.count}</td>
                                <td>${c.userId}</td>

                                <td>
                                    <c:if test="${c.status==1}">
                                        <span style="color:red;background-color: wheat">   ${c.name}</span>
                                    </c:if>
                                    <c:if test="${c.status==2}">
                                        <span style="color:black">   ${c.name}</span>
                                    </c:if>




                                </td>



                                <td>${c.phone}</td>
                                <td>${c.email}</td>
                                <td>${c.address}</td>

                                <td>
                                    <c:if test="${c.role==1}">
                                        ${c.loginName} <span style="color:green">|A|</span>

                                    </c:if>
                                    <c:if test="${c.role==2}">
                                        ${c.loginName} <span style="color:blue">|U|</span>

                                    </c:if>


                                </td>
                                <td>${c.role}</td>
                                <td>${c.status}</td>


                                <td id="id_${c.userId}">

                                    <c:if test="${c.status==2}">
                                        <a href="javascript:void(0);" onclick="changeActiveBlockStatus('${c.userId}', '1', 'id_${c.userId}');">Active</a>
                                        
                                    </c:if>
                                    <c:if test="${c.status==1}">
                                      <a href="javascript:void(0);" onclick="changeActiveBlockStatus('${c.userId}', 2, 'id_${c.userId}')">Block</a> 
                                    </c:if>
                                </td>



                            </tr>
                        </c:forEach>
                    </table> 




                </td></tr>
            <tr><td height="20"></td></tr>
        </table>
    </body>
</html>


