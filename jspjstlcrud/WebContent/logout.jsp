<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("user")==null || session.getAttribute("user")==""){
	
response.sendRedirect(request.getContextPath());

}
	%>


<%  
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate ");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader("Expires", 0);
%>

<%
if(session.getAttribute("user")!=null){
	
	request.getSession(false);
	session.setAttribute("user", null);
	session.removeAttribute("user");
	session.invalidate();
	response.sendRedirect(request.getContextPath());
}
%>
<h1>Logout</h1>
<a href="signout.jsp">Logout</a>
<h1>Logout</h1>


</body>
</html>