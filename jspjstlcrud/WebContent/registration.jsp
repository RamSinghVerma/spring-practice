<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<%@ include file="check_session.jsp" %>
<div style="align-content: right; width: 100%">
<a href="${pageContext.request.contextPath}/result.jsp">Show User Details</a>|
<a href="${pageContext.request.contextPath}">Log out</a>
</div>

<center>
		<form action="RegisterServlet" method="post">
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text"  name ="email"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"/></td>
				</tr>
				<tr>
					<td>Select</td>
					<td><select name="items" style="min-width: 100%" >
					<option selected>Select</option>
					<option>Item 1</option>
					<option>Item 2</option>
					<option>Item 3</option>
					<option>Item 4</option>
					<option>Item 5</option>
					</select>
					</td>
				</tr>
				<tr>
				<td>Gender</td>
				<td>
				<input type="radio" name="gender" value="Male"/>
				<label>Male</label>
				<input type="radio" name="gender" value="Female"/>
				<label>Female</label></td>
				</tr>
				<tr>
					<td colspan=2 style="text-align: center;"><input type="submit"
						value="Register"></td>
				</tr>
			</table>


		</form>
	</center>
	<footer>
	<%@ include file="footer.jsp" %>
	</footer>
</body>
</html>