<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<%@ include file="check_session.jsp" %>

<c:if test="${param.un!=null}">
		<sql:query dataSource="${db}" var="rs">
	SELECT * FROM user where user_name=?
<sql:param value="${param.un}"></sql:param>
		</sql:query>
	</c:if>



	<center>
		<form 
			method="post">
			<table>

				<c:forEach items="${rs.rows}" var="record">

					<tr>
						<td>Name</td>
						<td><input type="text" name="name"
							value="${record.user_name}" /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="text" name="email"
							value="${record.user_email}" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="password"
							value="${record.user_pass}" /></td>
					</tr>
					<tr>
						<td>Select</td>
						<td><select name="items" style="min-width: 100%">
								<option selected>${record.user_item}</option>
								<option>Item 1</option>
								<option>Item 2</option>
								<option>Item 3</option>
								<option>Item 4</option>
								<option>Item 5</option>
						</select></td>
					</tr>
					<tr>
						<td>Gender</td>
						<td><input type="radio" name="gender" value="Male"
							<c:if test="${record.gender=='Male'}">checked</c:if> /> <label>Male</label>
							<input type="radio" name="gender" value="Female"
							<c:if test="${record.gender=='Female'}">checked</c:if> /> <label>Female</label></td>
					</tr>
					<tr>
						<td colspan=2 style="text-align: center;"><input
							type="submit" name="update" value="Update"></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</center>
	<c:if
		test="${param.update!=null and  param.name!=null and param.password!=null and param.email!=null}">
		<sql:update dataSource="${db}" var="result">
	UPDATE user SET user_pass=?,user_email=?,user_item=?,gender=? WHERE user_name=?
	<sql:param value="${param.password}"></sql:param>
			<sql:param value="${param.email}"></sql:param>
			<sql:param value="${param.items}"></sql:param>
			<sql:param value="${param.gender}"></sql:param>
			<sql:param value="${param.name}"></sql:param>
		</sql:update>
		<c:if test="${result>0}">
		<c:redirect url="result.jsp"></c:redirect>
		</c:if>
	</c:if>

	
	<footer>
	<%@ include file="footer.jsp" %>
	</footer>
</body>
</html>