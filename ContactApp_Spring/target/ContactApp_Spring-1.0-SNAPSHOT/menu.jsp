                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    


  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%! Date d=new Date();
SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


   %>
   <html>
       <head>
           <style>
               #menu ul li{
                background-color: cadetblue;
                
                color:white;
                margin: 1px;
                float: left;
                list-style: none;
                  
                  height: 20px;
                  width: 100px;
                 text-align: center;
                  margin: 2px;
               border-top-style:  ridge;
                
               }
               #menu ul li:hover{
                  background-color: white;
                  padding:auto;
               }
            
               a:visited{color:red;}
           </style> 
       </head>
       <body><div id="menu">
           <ul>
               <li><c:url var="ind" value="/index.jsp"/>
                   <a href="${ind}">Home</a>
               </li>
               
                <li><c:url var="reg" value="/reg_form.jsp"/>
                   <a href="${reg}">Register</a>
               </li>
               
                <li><c:url var="ind" value="/index.jsp"/>
                   <a href="${ind}"> Login</a>
               </li>
               
               <li>About</li>
               <li>Contact</li>
                
           </ul>
           </div>
       </body>
   </html>

<!--    Home|Register|Login|About |contact -->
   
   
   
   <div style="margin-left: 750px;font-size: 12px;"> <%=formatter.format(d)%> Time</div>