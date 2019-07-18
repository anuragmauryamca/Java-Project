<%@page import="net.ezeon.capp.domain.Contact"%>
<%@page import="net.ezeon.capp.service.SpringUtil"%>
<%@page import="net.ezeon.capp.service.ContactService"%>
<%!
    ContactService contactService = SpringUtil.ctx.getBean(ContactService.class);
%>
<%
     //Get Logged in user from session scope
    Integer userId = (Integer) session.getAttribute("userId");  
    String criteria=request.getParameter("criteria");
    request.setAttribute("contactList", contactService.search(userId,criteria));
    pageContext.forward("clist.jsp");
%>
