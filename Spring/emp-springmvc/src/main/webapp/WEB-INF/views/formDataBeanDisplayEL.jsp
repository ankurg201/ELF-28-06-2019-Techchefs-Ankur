<%@page import="com.techchefs.emp.dto.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<% UserBean userBean = (UserBean)request.getAttribute("userBean");
%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
userId = <%=userBean.getUserId() %><br>
Password = <%=userBean.getPassword()%>
</body>
</html>