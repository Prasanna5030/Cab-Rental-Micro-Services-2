	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"  href="../../styles.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<section class="py-5">
    <div class="container">
        <!-- FOR DEMO PURPOSE -->
        <div class="row">
            <div class="col-lg-6 mx-auto">
                <header class="text-center pb-5">
                    
                </header>
            </div>
        </div><!-- END -->


        <div class="row">
            <div class="col-lg-6 mx-auto">

         <h1 style="text-align:center;"> Welcome ${tb.customerName}, your booking is success</h1>
<h2 align="center"> DETAILS</h2>

<div align="center">
<p>trip- id : ${tb.tripId } </p>
<p>Driver  : ${tb.driverName } </p>
<p> Trip start date: ${tb.tripStartDate }</p>
<p>Distance : ${tb.totalKms }</p>
<p> total fare : ${tb.fare }</p>

<form:form method ="POST" action="tripends"  modelAttribute="tripBooking">
<form:input type="hidden"  path="customerId"   value="${tb.customerId}"/>
<form:input type="hidden"  path="customerName"   value="${tb.customerName }"/>
<form:input type="hidden"  path="driverName"  value="${tb.driverName }" />
<form:input type="hidden"  path="tripId"   value="${tb.tripId }"/><br>
Amount to be paid<form:input path="fare"  value="${tb.fare }"/><br>
Rating<form:input path="rating"  value="${tb.rating }"/>

<input type="submit"  value="submit"/>
</form:form>
</div>
            </div>
        </div>
    </div>
</section>


</body>
</html>