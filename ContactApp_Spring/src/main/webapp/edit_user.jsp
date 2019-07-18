



<%@page import="net.ezeon.capp.domain.Contact"%>
<%@page import="net.ezeon.capp.service.ContactService"%>
<%@page import="net.ezeon.capp.service.SpringUtil"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="net.ezeon.capp.domain.Contact"%>
<%!


ContactService service=SpringUtil.ctx.getBean(ContactService.class);


%>

   <%
   int contactId=Integer.parseInt(request.getParameter("cid"));
    Contact c=service.findById(contactId);//find exiting contact show profieks 
    
request.setAttribute("ec", c);
//request.setAttribute("c", contact);

   %>
   
  
   
   <jsp:forward page="add_contact.jsp">
                     <jsp:param name="name"  value="${ec.name}"/>
                     <jsp:param name="phone"  value="${ec.phone}"/>
                     <jsp:param name="emial"  value="${ec.email}"/>
                     <jsp:param name="address"  value="${ec.address}"/>
                     <jsp:param name="remark"  value="${ec.remark}"/>
                      <jsp:param name="cid"  value="${ec.contactId}"/>
                     
                     
                    
   </jsp:forward>>
     
               
        
   
    
   


       
   
