<%@ page session = "false"%>
<%@ page import="java.sql.*" %>
<%@ page import ="p1.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script >
function call()
{
if(document.f.bid.value==""){
alert("Please Enter Ur Name");
return false;
}
if(document.f.pwd.value==""){
alert("Please Enter Ur Password");
return false;
}
if((document.f.bid.value=="")||(document.f.pwd.value==""))
	{
alert("Please Enter Username& password");
return false;
}
}
</script>

<title>UNIVERSAL NATIONAL BANK</title>
<link href="col_font.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
.style1 {
	color: #990000;
	font-weight: bold;
	font-size: 24px;
}
.style2 {color: #990000}
.style4 {
	color: #990000;
	font-size: 16px;
	font-weight: bold;
}
.style8 {font-size: 12px}
.style9 {font-weight: bold}
-->
</style>
<link href="img.css" rel="stylesheet" type="text/css" />
</head>

<body bgcolor="#007289">
<jsp:include page="header.jsp"/>
 
  <center>
<BR>
<font size="+2" color="#262626"><h2><b>WELCOME TO UNIVERSAL BANKING SERVICES</b></h2></font>
 
 
<br>
 
 

<br>
<form  method=post action="bloginch.jsp" name="f" onSubmit='return call()'>
 <table width="40%" cellpadding="5" cellspacing="5">
 <colgroup span=2 >
 <tr>
 
 <font color="#262626"><h1>EMPLOYEE LOGIN</h1>
 </font>
 <td><b>Username:</b></td><td><input type="text" name="bid" ></td>
</tr>
 
<tr> 
<td><b> Password:</b></td><td><input type="password" name="pwd"></td>
</tr><tr> 
<td><b> Select Bank:</b></td><td><SELECT NAME="bl">
<%
try
{
//Class.forName("oracle.jdbc.driver.OracleDriver");
//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bank","bank");
Connection con = DB.getCon();


Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from  bank");
while(rs.next())
{
	%>
<option><%=rs.getString(2)%></option>
<%} %>
 </SELECT></td>
 <%
}
catch(Exception e)
{
	System.out.println(e);
}
	%>
</tr>
</table>
<br> <BR>
 <input type="submit" value="   Login   "> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="reset" value="   reset   ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" name=back  

value="Home" onClick="window.location='index.jsp'"><BR>
 <center><h2><b><a href="newbankuser.jsp" style="text-decoration : none"><font size="5" font color="#262626"><BR>New EMPLOYEE..?<image src="signup.gif"/image></font> 

</a></b></h2></center>    
 </form>

 

</center>

  <tr>
    
  </tr>
</table>

<map name="Map" id="Map"><area shape="poly" coords="26,32" href="#" />
<area shape="poly" coords="48,69" href="#" />
</map></body>
</html>
