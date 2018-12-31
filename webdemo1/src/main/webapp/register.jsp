<%@ page import="webdemo1.UserDao" %>
<jsp:useBean id="obj" class="webdemo1.User" ></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>

<%
int i=UserDao.register(obj);
if(i>0)
	out.println("Registered successfulyy!");
else
	out.println("Registration failed!");

%>
