<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	background-image:
		url(https://www.myscbc.org/wp-content/uploads/2013/03/background-images-for-websites-hd-background-wallpaper-40.jpg);
}

a {
	font-size: 20px;
	color: snow;
}

h2 {
	color: limegreen;
}

p {
	color: seashell;
}

label {
	font-size: 20px;
}
</style>
<title>Donor Details</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="user" value="${sessionScope.user}" />
	<c:set var="donor" value="${sessionScope.donor}" />
	<c:set var="donations" value="${sessionScope.donations}"></c:set>
	<a href="${contextPath}/logout.htm">Logout</a>
	<br />
	<div class="container">
		<h2>Donor Details</h2>
		<h3>Previous Donations</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<td style="color: linen;" width="10%">Donation Id</td>
					<td style="color: linen;" width="30%">Amount donated</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${donations}" var="d">
					<tr>
						<td style="color: linen;">${d.donationId}</td>
						<td style="color: linen;">${d.amount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form action="${contextPath}/donorDetails.htm" method="post">
			<div class="form-group">
				<label for="pic" style="color: linen;">Employee:</label> <img
					name="pic" id="pic" height="150" width="150" src="${user.filename}" />
			</div>
			<div class="form-group">
				<label for="fname" style="color: linen;">First name:</label> <input
					class="form-control" id="fname" name="fname"
					value="${user.firstName}" disabled="disabled" />
			</div>
			<div class="form-group">
				<label for="lname" style="color: linen;">Last name:</label> <input
					class="form-control" id="lname" name="lname"
					value="${user.lastName}" disabled="disabled" />
			</div>
			<div class="form-group">
				<label for="donorId" style="color: linen;">Donor Id:</label> <input
					class="form-control" id="donorId" name="donorId"
					value="${donor.donorId}" disabled="disabled" />
			</div>
			<div class="form-group" style="background-color: ghostwhite;">
				<label for="isSelfEmployed" >Is Self
					Employed?</label> <br/> <input type="radio" name="isSelfEmployed"
					id="isSelfEmployed" value="Yes" checked="checked"
					style="color: linen;"> Yes<br> <input type="radio"
					name="isSelfEmployed" id="isSelfEmployed" value="No"
					style="color: linen;"> No<br>
			</div>
			<div class="form-group">
				<label for="company" style="color: linen;">Company:</label> <input
					type="text" class="form-control" pattern="^[a-zA-Z ]{2,30}$"
					id="company" name="company" value="${donor.companyName}" />
			</div>
			<div class="form-group">
				<label for="donate" style="color: linen;">Donation:</label> <input
					type="number" pattern="^\d{10}$" class="form-control" id="donate"
					name="donate" />
			</div>
			<input type="submit" class="btn btn-lg" value="Update Donor details" />
		</form>
	</div>
</body>
</html>