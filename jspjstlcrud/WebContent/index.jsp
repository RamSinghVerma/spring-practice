<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>

	<center>
		<form action="file_upload.jsp" method="post"  enctype="multipart/form-data">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>File</td>
					<td><input type="file" name="image" size="50"/></td>
				</tr>
				<tr>
					<td colspan=2 style="text-align: center;"><input type="submit"
						value="Login" ></td>
				</tr>
			</table>


		</form>
	</center>
	
	
</body>
</html>