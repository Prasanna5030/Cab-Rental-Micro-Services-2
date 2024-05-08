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
<h1>Hello driver home  </h1>

<hr> 

<form:form action="driverlogin"  method="POST"  modelAttribute="driverDto">

username<form:input path="name" />
password<form:input type="password"  path="password" />
email<form:input path="email" />
mobile<form:input path="mobile" />
Lisense No: <form:input path="lisenceNo" />
Cab Model: <form:input path="cab.carModel"/>
Cab type: <form:input path="cab.cabType"/>
Vehicle Number: <form:input path="cab.vehicleNo"/>
ratePerKm:<form:input path="cab.ratePerKm"/>
address<form:input path="address.city" />
state<form:input path="address.state" />
pincode<form:input path="address.pincode" />
<input type="submit"  value ="submit">
 
</form:form>
</body>
</html>