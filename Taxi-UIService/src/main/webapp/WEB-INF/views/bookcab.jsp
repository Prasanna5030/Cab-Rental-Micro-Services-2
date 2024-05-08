<%@page import="java.util.ArrayList"%>
<%@page import="com.sl.model.DriverDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="../../styles.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h1 align="center">City Cabs Services </h1>

<hr> 


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

<form:form action="booktrip"  method="POST"  modelAttribute="tripBooking">

<h1> Book Cab </h1>
<form:input type="hidden"  path="customerId"   value="${user.getId() }"/>

from<form:input type="date" path="tripStartDate" />

to<form:input type="date" path="tripEndDate" />

<hr>

<p> List Of Cabs </p>


<input type="submit" value="submit" />
 </form:form>
 
<%--  <c:forEach var="driver"  items="${availableDrivers}"> --%>
<!-- <table> -->
<!-- <tr> -->
<!-- <th>Driver Name</th> -->
<!-- <th> mobile</th> -->
<!-- <th> Liscence No</th> -->
<!-- <th> Rating</th> -->
<!-- <th> Vehicle </th> -->
<!-- <th> Seating Capacity</th> -->
<!-- <th> Vehicle No</th> -->
<!-- <th> ratePerKm</th> -->
<!-- </tr> -->
<!-- <tr> -->
<%-- <td><c:out value="${ driver.name} "></c:out> </td> --%>
<%-- <td><c:out value="${ driver.mobile} "></c:out> </td> --%>
<%-- <td><c:out value="${ driver.lisenceNo} "></c:out> </td> --%>
<%-- <td><c:out value="${ driver.rating} "></c:out> </td> --%>
<%-- <td><c:out value="${ driver.cab.carModel} "></c:out> </td> --%>
<%-- <td><c:out value="${ driver.cab.cabType} "></c:out> </td> --%>
<%-- <td><c:out value="${ driver.cab.vehicleNo} "></c:out> </td> --%>
<%-- <td><c:out value="${ driver.cab.ratePerKm} "></c:out> </td> --%>
<!-- </tr> -->
<!-- </table> -->

<%-- </c:forEach> --%>
    <!-- Icon -->
    <div class="fadeIn first">
      <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
    </div>

   
  </div>
</div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>

<hr> 



</body>
</html>