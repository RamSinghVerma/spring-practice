<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate ");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader("Expires", 0);
	
%>

<% if(session.getAttribute("user")==null || session.getAttribute("user")==""){
	
response.sendRedirect("login.jsp");

}
%>
<h1>Signout</h1>
<%
if(session.getAttribute("user")!=null){
	session.removeAttribute("user");
	request.getSession(false);
	session.setAttribute("user", null);
	session.invalidate();
response.sendRedirect("login.jsp");
}
%>