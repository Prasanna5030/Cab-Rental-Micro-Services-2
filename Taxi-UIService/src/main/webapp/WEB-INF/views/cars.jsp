<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.util.ArrayList"%>
<%@page import="com.sl.model.DriverDto"%>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"  href="../../styles.css">
<style>
td {
	text-align:center;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<section class="py-5">
    <div class="container">
        <!-- FOR DEMO PURPOSE -->
        <div class="row">
            <div class="col-lg-6 mx-auto">
                <header class=" pb-5">
                    <h1 class="h2 text-center"  style="text-align:center;">Cabs available now </h1>
                  <hr>
                </header>
            </div>
        </div><!-- END -->


        <div class="row">
            <div class="col-lg-6 mx-auto">

				<p> please book the cab below to start the trip </p>
					
			


<table border="1"  text-align="center"  width="100%" >
<tr>
<th>Driver Name</th>
<th> mobile</th>
<th> Liscence No</th>
<th> Rating</th>
<th> Vehicle </th>
<th> Seating Capacity</th>
<th> Vehicle No</th>
<th> ratePerKm</th>
<th> Book driver</th>
</tr>




 <c:forEach var="driver"  items="${availableDrivers}">
 <tr  >
<td><c:out value="${ driver.name} "></c:out> </td>
<td><c:out value="${ driver.mobile} "></c:out> </td>
<td><c:out value="${ driver.lisenceNo} "></c:out> </td>
<td><c:out value="${ driver.rating} "></c:out> </td>
<td><c:out value="${ driver.cab.carModel} "></c:out> </td>
<td><c:out value="${ driver.cab.cabType} "></c:out> </td>
<td><c:out value="${ driver.cab.vehicleNo} "></c:out> </td>
<td><c:out value="${ driver.cab.ratePerKm} "></c:out> </td>
<td> <form:form method="POST" action="bookcab"  modelAttribute="tripBooking"> 
 <form:input  type="hidden" path="customerId"  value=" ${tripBooking.customerId }"  />
<br>
<form:input  type="hidden"  path="driverId"  value="${driver.id }"  />
         <input type="submit"  value="Book cab" >
          </form:form></td>
</tr>

</c:forEach>

 <h3> your booking starts from "${tripBooking.tripStartDate }"
 
 to  "${tripBooking.tripEndDate }"
 </h3>
 
<h3> Trip booking no: ${tripBooking.customerId } </h3>
</table>
					
            </div>
        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>

</body>
</html>