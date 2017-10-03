<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Add victim</title>
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
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<br />
	<div class="container">
		<h2>Add Victim Details</h2>
		<form:form action="${contextPath}/registervictim.htm"
			commandName="victim" method="post">
			<table class="table table-hover">
				<tr>
					<td style="color: linen;">Victim Name:</td>
					<td><form:input path="victimName" pattern="^[a-zA-Z ]{2,30}$"
							size="30" /> <font color="red"><form:errors
								path="victimName" /></font></td>
				</tr>
				<tr>
					<td style="color: linen;">Age:</td>
					<td><form:input path="victimAge" size="2" pattern="^\d{2}$" />
						<font color="red"><form:errors path="victimAge" /></font></td>
				</tr>
				<tr>
					<td style="color: linen;">Category:</td>
					<td><form:radiobutton path="category" value="1"
							checked="checked" />Homeless Shelter <br /> <form:radiobutton
							path="category" value="2" />Emergency services <br /> <form:radiobutton
							path="category" value="3" />Health and public services <br /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-lg"
						value="Add Victim" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>