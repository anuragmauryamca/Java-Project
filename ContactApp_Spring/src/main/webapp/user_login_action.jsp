<%@page import="net.ezeon.capp.service.UserBlockedException"%>
<%@page import="net.ezeon.capp.domain.User"%>
<%@page import="net.ezeon.capp.service.UserService"%>
<%@page import="net.ezeon.capp.service.SpringUtil"%>
<%

UserService service=SpringUtil.ctx.getBean(UserService.class);

%>

<%
//User u=new User();
try{
String uname=request.getParameter("username");
String upwd=request.getParameter("password");

User user=service.authenticate(uname,upwd);


if(user==null){
    request.setAttribute("err","Login Faild-Invalid Credentionl");
    pageContext.forward("index.jsp");
   out.println("faild");
}else{
    if(user.getRole()==UserService.ROLE_ADMIN){
        session.setAttribute("user", user);
        session.setAttribute("userid", user.getUserId());
        session.setAttribute("role", user.getRole());
        response.sendRedirect("admin_dashboard.jsp");
        
    }
       else if (user.getRole() == UserService.ROLE_USER) {
                session.setAttribute("user", user);
                session.setAttribute("userId", user.getUserId());
                session.setAttribute("role", user.getRole());                
                response.sendRedirect("user_dashboard.jsp");
         }
        }
}catch (UserBlockedException ex) {
        request.setAttribute("err", ex.getMessage());
        pageContext.forward("index.jsp");
    }

%>