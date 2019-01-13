
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page import="java.io.ByteArrayOutputStream"%>
    <%@page import="java.sql.Connection"%>
    <%@page import="java.sql.DriverManager"%>
    <%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.InputStream"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FileUpload</title>
</head>
<body>


<%

String name=request.getParameter("name");
Part filepath=request.getPart("image");
String sql="insert into user(user_name,user_item,file_data) values(?,?,?)";
try { Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vanisb", "root", "root");
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, name);
	ps.setString(2, filepath.getName());
	ps.setBinaryStream(3, filepath.getInputStream(),filepath.getSize());
	int i=ps.executeUpdate();
	System.out.println(i);
	if(i>0) {
		out.println("<h1>File uploaded successfully</h1>");
		out.println("<a href='index.jsp'>Back</a>");
	}
	con.close();
}catch (Exception e) {
	e.printStackTrace();
}

%>




</body>
</html>