<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="check_session.jsp" %>
<c:if test="${param.un!=null}">
		<sql:update dataSource="${db}" var="result">
		DELETE FROM user WHERE user_name=?
		<sql:param value="${param.un}"></sql:param>
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