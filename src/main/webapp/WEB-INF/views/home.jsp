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
		url(http://www.gllu.org/imgs/wallpapercave.com/wp/dllTcep.jpg);
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
<title>Humanitarian Aid</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<br />
	<div class="container">
		<div class="jumbotron"
			style="background-image: url(http://thefabhouse.com/android-central/wallpaper/droidx-blue-floor.png);">
			<h2>Boston Health and Public Services</h2>
			<p>Founded by Dr. Samuel Adams. The aim of the organization is to
				coordinate and communicate efficiently for a common goal of welfare
				of people in need. The different departments of the organizations
				like food, health, education, shelter work and coordinate with each
				other for this purpose.</p>
		</div>
	</div>
	<br />
	<div class="container">
		<a href="${contextPath}/register.htm"><span
			style="text-decoration: underline;">Click here to register a
				new user</span></a> <br />
		<h2>Login</h2>
	</div>
	<div class="container">
		<form action="${contextPath}/login.htm" method="post">
			<div class="form-group">
				<label for="username" style="color: linen;">User name:</label> <input class="form-control"
					id="username" name="username" size="30" required="required" />
			</div>
			<div class="form-group">
				<label for="password" style="color: linen;">Password:</label> <input type="password"
					class="form-control" id="password" name="password" size="30"
					required="required" />
			</div>
			<input type="submit" class="btn btn-lg" value="Login" />
		</form>
	</div>
</body>
</html>

