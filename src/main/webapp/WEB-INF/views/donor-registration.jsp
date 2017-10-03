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
<title>Donor Registration</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="user" value="${sessionScope.user}" />
	<br />
	<div class="container">
		<h2>Donor Registration</h2>
		<form:form action="${contextPath}/donorRegister.htm"
			commandName="donor" method="post">
			<div class="container">
				<table class="table table-hover">
					<tr>
						<td style="color: linen;">Company Name:</td>
						<td><form:input path="companyName" size="30"
								pattern="^[a-zA-Z ]{2,30}$" /> <font color="red"><form:errors
									path="companyName" /></font></td>
					</tr>
					<tr>
						<td style="color: linen;">Is donor Of Legal Age?</td>
						<td><form:radiobutton path="isLegalAge" value="yes"
								checked="checked" />Yes <form:radiobutton path="isLegalAge"
								value="no" />No</td>
					</tr>
					<tr>
						<td style="color: linen;">Is donor Of Self-employed?</td>
						<td><form:radiobutton path="isSelfEmployed" value="yes"
								checked="checked" />Yes <form:radiobutton path="isSelfEmployed"
								value="no" />No</td>
					</tr>
					<tr>
						<td style="color: linen;">SSN:</td>
						<td><form:input path="ssn" pattern="^\d{10}$" /> <font
							color="red"><form:errors path="ssn" /></font></td>
					</tr>
					<tr>
						<td colspan="2"><input class="btn btn-lg" type="submit"
							value="Register Donor" /></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>
</body>
</html>