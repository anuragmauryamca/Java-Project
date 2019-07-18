<%@page import="org.springframework.dao.DuplicateKeyException"%>
<%@page import="net.ezeon.capp.domain.User"%>
<%@page import="net.ezeon.capp.service.SpringUtil"%>
<%@page import="net.ezeon.capp.service.UserService"%>
<%!
    UserService userService = SpringUtil.ctx.getBean(UserService.class);
%>

<%
    User u = new User();
    u.setName(request.getParameter("name"));
    u.setPhone(request.getParameter("phone"));
    u.setEmail(request.getParameter("email"));
    u.setAddress(request.getParameter("address"));
    u.setLoginName(request.getParameter("username"));
    u.setPassword(request.getParameter("password")); //Encrypt : TODO
    u.setRole(UserService.ROLE_USER);
    u.setStatus(UserService.LOGIN_STATUS_ACTIVE);
    try {
        userService.userRegistration(u);
        //redirect when success
    
        response.sendRedirect("index.jsp?act=reg");
    } catch (DuplicateKeyException e) {
        e.printStackTrace();
        //forward when failed
        request.setAttribute("err", "Username is already exists. Please select another username.");
        pageContext.forward("reg_form.jsp");
    } catch (Exception e) {
        e.printStackTrace();
        //forward when failed
        request.setAttribute("err", "Unexpected error");
        pageContext.forward("reg_form.jsp");
    }
%>