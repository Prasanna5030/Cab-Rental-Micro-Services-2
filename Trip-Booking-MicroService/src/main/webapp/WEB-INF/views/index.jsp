<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> hello user </h1>
<hr>
<form:form action="/addtrip"  modelAttribute="TripBooking tb">

<form:input type="date"  path="" />

</form:form>

</body>
</html>