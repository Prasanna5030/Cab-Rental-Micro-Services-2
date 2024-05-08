<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"  href="../../styles.css">
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
                  <h1 style="margin:20%;text-align:center ; padding:20px"> It was a great journey with you ${tripBooking.customerName} , Trip ended successfully</h1>
                </header>
            </div>
        </div><!-- END -->


        <div class="row">
            <div class="col-lg-6 mx-auto">

			<a href="/api/home"> Back to Home</a>
            </div>
        </div>
    </div>
</section></body>
</html>