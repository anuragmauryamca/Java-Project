

<%@page import="net.ezeon.capp.service.SpringUtil"%>
<%@page import="net.ezeon.capp.service.ContactService"%>
<%!

ContactService service=SpringUtil.ctx.getBean(ContactService.class);

%>
<%
 Integer contactId=Integer.parseInt(request.getParameter("cid"));
 service.delContactList(contactId);
 response.sendRedirect("clist.jsp?act=del");//delete Action

%>