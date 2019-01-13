<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
<script>
function go() {
window.location.replace("/vanisbweb/view/logout.jsp",'window','toolbar=1,location=1,directories=1,status=1,menubar=1,scrollbars=1,resizable=1');
self.close()
}
</script>
</head>
<body>
<%@ include file="check_session.jsp" %>
	<h1>User Details</h1>
	<sql:setDataSource driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/vanisb" user="root" password="root"
		var="db" scope="application" />
	<sql:query dataSource="${db}" var="rs">SELECT * FROM user</sql:query>
	<%
		String[] columns = new String[] { "Name", "Password", "Emails", "Items", "Gender", "Update", "Delete" };
		request.setAttribute("arr", columns);
	%>
	

	<table border=1>
		<thead>
			<tr>
				<c:forEach var="col" items="${arr}">
					<th><c:out value="${col}"></c:out></th>
				</c:forEach>
			</tr>
		</thead>


		<c:forEach items="${rs.rows}" var="record">
			<tr>
				<td><c:out value="${record.user_name}"></c:out></td>
				<td><c:out value="${record.user_pass}"></c:out></td>
				<td><c:out value="${record.user_email}"></c:out></td>
				<td><c:out value="${record.user_item}"></c:out></td>
				<td><c:out value="${record.gender}"></c:out></td>
				<td><a
					href="${pageContext.request.contextPath}/update.jsp?un=${record.user_name}">update</a>
				</td>
				<td>
				
				<a
					href="${pageContext.request.contextPath}/delete.jsp?un=${record.user_name}">delete</a>
				</td>
			</tr>

		</c:forEach>
	</table>
	
<footer>
	<%@ include file="footer.jsp" %>
	</footer>
</body>
</html>