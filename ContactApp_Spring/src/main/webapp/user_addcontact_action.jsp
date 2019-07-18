


<%@page import="net.ezeon.capp.domain.Contact"%>
<%@page import="net.ezeon.capp.service.SpringUtil"%>
<%@page import="net.ezeon.capp.service.ContactService"%>
<%

 ContactService contactService = SpringUtil.ctx.getBean(ContactService.class);

%>
<%
Contact c=new Contact();
c.setName(request.getParameter("name"));
c.setPhone(request.getParameter("phone"));
c.setEmail(request.getParameter("email"));
c.setAddress(request.getParameter("address"));
c.setRemark(request.getParameter("remark"));
//get logged in useer from sessin scope
Integer uid=(Integer)session.getAttribute("userId");
c.setUserId(uid);//fk
try{
    String cid=request.getParameter("cid");//hidden field
    if(cid!=null && !cid.isEmpty()){
        //update
        c.setContactId(new Integer(cid));//bind primary ker fro update
        contactService.update(c);
        response.sendRedirect("clist.jsp?act=up");//ed :edit
    }else{
    //save
   contactService.save(c);
    response.sendRedirect("clist.jsp?act=sv");
    }
}catch(Exception ex){
    ex.getStackTrace();
    request.setAttribute("err","Faild to save");
    pageContext.forward("add_contact.jsp");
    
}


%>