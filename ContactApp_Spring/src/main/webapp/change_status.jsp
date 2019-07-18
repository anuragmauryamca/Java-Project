<%@page import="net.ezeon.capp.service.UserService"%>
<%@page import="net.ezeon.capp.service.SpringUtil"%>
<%!
UserService service=SpringUtil.ctx.getBean(UserService.class);

%>
<%
     //Get Logged in user from session scope
    Integer userId = (Integer)request.getAttribute("userId");  
    Integer status = (Integer)request.getAttribute("status"); 
//    service.changeStatus(userId, status); 
out.println("success");//read form ajax

%>
