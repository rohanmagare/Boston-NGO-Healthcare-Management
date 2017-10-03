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
<title>Employee Registration</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="user" value="${sessionScope.user}" />
	<br />
	<div class="container">
		<h2>Employee Registration</h2>
		<form:form action="${contextPath}/employeeRegister.htm"
			commandName="employee" method="post">
			<h4>Organization Projects</h4>
			<input type="radio" name="task" value="1" checked="checked"> Homeless Shelter<br>
			<input type="radio" name="task" value="2"> Emergency Services<br>
			<input type="radio" name="task" value="3"> Health and Public Services<br>
			<table class="table table-hover">
				<tr>
					<td style="color: linen;">Salary:</td>
					<td><form:input path="salary" size="30" pattern="^\d{2,10}$" />
						<font color="red"><form:errors path="salary" /></font></td>
				</tr>
				<tr>
					<td style="color: linen;">Employment Type:</td>
					<td><form:radiobutton path="employmentType" value="FullTime"
							checked="checked" />Full-Time <form:radiobutton
							path="employmentType" value="Contractor" />Contractor <form:radiobutton
							path="employmentType" value="donor" />Donor</td>
				</tr>
				<tr>
					<td style="color: linen;">Bonus:</td>
					<td><form:input path="bonus" size="30" pattern="^\d{2,10}$" />
						<font color="red"><form:errors path="bonus" /></font></td>
				</tr>
				<tr>
					<td style="color: linen;">SSN:</td>
					<td><form:input path="ssn" size="30" pattern="^\d{10}$" /> <font
						color="red"><form:errors path="ssn" /></font></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-lg"
						value="Register Employee" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>