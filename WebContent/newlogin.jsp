<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0"> 


<title>Insert title here</title>

	<!-- <script type = "text/javascript" >
    function preventBack() { window.history.forward(); }
    setTimeout("preventBack()", 0);
    //window.onunload = function () { null; }
    
</script>
 -->
</head>
<body bgcolor="pink" onunload="preventBack()">


<%


/* response.setHeader("Cache-Control", "no-cache");

//Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control", "no-store");

//Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0);

//Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma", "no-cache"); */





//response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); 

if(session.getAttribute("userId")==null)
	
	response.sendRedirect("login.html");


%>

<%-- <% 
if(session.getAttribute("userId")==null)

	response.sendRedirect("login.html");

%> --%>




<center>

<form>

<table align="center" bgcolor="#E6E6FA">



<tr><td><a href="HomePage.html"><b>AddProduct</b></a></td></tr><br>
<tr><td><a href="ViewProduct"><b>ViewProduct</b></a></td></tr><br>
<tr><td><a href="Searchproduct.html"><b>SearchProduct</b></a></td></tr><br>
<tr><td><a href="SearchByAjax.html"><b>SearchbyAjax</b></a></td></tr><br>
<tr><td><a href="upload.html"><b>UploadFile</b></a></td></tr>
<tr><td><a href="Download"><b>DownloadFile</b></a></td></tr>
<tr><td><a href="Logout"><b>Logout</b></a>

</table>


</form>


</center>

</body>
</html>