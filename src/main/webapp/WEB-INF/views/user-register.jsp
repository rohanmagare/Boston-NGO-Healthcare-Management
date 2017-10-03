<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
<title>Register New User</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<br />
	<div class="container">
		<h2>Register New User</h2>
		<form:form action="${contextPath}/register.htm" commandName="user"
			enctype="multipart/form-data" method="post">
			<div class="container">
				<table class="table table-hover">
					<tr>
						<td style="color: linen;">Photo:</td>
						<td><form:input type="file" class="filestyle" path="photo" /></td>
					</tr>
					<tr>
						<td style="color: linen;">First Name:</td>
						<td><form:input path="firstName" pattern="^[a-zA-Z ]{2,30}$"
								size="30" /> <font color="red"><form:errors
									path="firstName" /></font></td>
					</tr>
					<tr>
						<td style="color: linen;">Last Name:</td>
						<td><form:input path="lastName" pattern="^[a-zA-Z ]{2,30}$"
								size="30" /> <font color="red"><form:errors
									path="lastName" /></font></td>
					</tr>
					<tr>
						<td style="color: linen;">Middle Name:</td>
						<td><form:input path="middleName" pattern="^[a-zA-Z ]{2,30}$"
								size="30" /> <font color="red"><form:errors
									path="middleName" /></font></td>
					</tr>
					<tr>
						<td style="color: linen;">User Name:</td>
						<td><form:input path="userName" pattern="^[A-z0-9À-ž\s]{2,}$"
								size="30" /> <font color="red"><form:errors
									path="userName" /></font></td>
					</tr>
					<tr>
						<td style="color: linen;">Password:</td>
						<td><form:password path="password" size="30" pattern=".{6,}" />
							<font color="red"><form:errors path="password" /></font></td>
					</tr>
					<tr>
						<td style="color: linen;">Email Id:</td>
						<td><form:input path="email.emailAddress" size="30"
								pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" type="email" />
							<font color="red"><form:errors path="email.emailAddress" /></font></td>
					</tr>
					<tr>
						<td style="color: linen;">Role:</td>
						<td><form:radiobutton path="role" value="employee"
								checked="checked" />Employee <br /> <form:radiobutton
								path="role" value="volunteer" />Volunteer <br /> <form:radiobutton
								path="role" value="donor" />Donor <br /></td>
					</tr>
					<tr>
						<td style="color: linen;">Address:</td>
						<td><form:textarea path="address" size="150"
								pattern="^[A-z0-9À-ž\s]{2,150}$" /> <font color="red"><form:errors
									path="address" /></font></td>
					</tr>
					<tr>
						<td style="color: linen;">Phone Number:</td>
						<td><form:input path="phoneNumber" size="10"
								pattern="^\d{10}$" /> <font color="red"><form:errors
									path="phoneNumber" /></font></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" class="btn btn-lg"
							value="Register User" /></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>
</body>
</html>