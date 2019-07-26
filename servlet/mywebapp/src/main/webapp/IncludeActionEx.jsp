<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
11111111111111111111111111111111111
<br>
<jsp:include page="index.jsp"/>
<br> 22222222222222222222222222222222
<br>
<jsp:include page="currentdate"/>
<br> 333333333333333333333333333333333333

<br>
<jsp:include page="currentdate?fname=ankur"/>

<br>
44444444444444444444444444444444444444444444
<br>

<jsp:include page="currentdate">
	<jsp:param value="ankur" name="fname"/>
	<jsp:param value="gupta" name="lname"/>
</jsp:include>

</body>
</html>