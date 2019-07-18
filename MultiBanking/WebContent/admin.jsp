<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml+++++1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>UNIVERSAL NATIONAL BANK</title>
<link href="col_font.css" rel="stylesheet" type="text/css" />
<script >
function call()
{
if(document.f.name.value==""){
alert("Please Enter Name");
document.f.name.setFocus=true;
return false;
}
if(document.f.pwd.value==""){
alert("Please Enter Ur Password");
return false;
}
}
</script>
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
 



<form  method=post action="admincheck.jsp" name="f" onSubmit='return call()'>
 <table>
 <tr>
 <font color="#262626"><h1>ADMIN LOGIN</h1>
 </font>
 <td><b>Name:</b></td><td><input type="text" name="name" ></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr> 
<td><b> Password:</b></td><td><input type="password" name="pwd"></td>
</tr>
</table>
<br> <BR>
 <input type="submit" value="submit">&nbsp;&nbsp;&nbsp;
 <input type="reset" value="reset">&nbsp;&nbsp;&nbsp;
 <input type="button" name=back  value="Home" onClick="window.location='index.jsp'">
 
 </form>
<br>

</center>
<tr>

</tr>
  
</table>

<map name="Map" id="Map"><area shape="poly" coords="26,32" href="#" />
<area shape="poly" coords="48,69" href="#" />
</map></body>
</html>



