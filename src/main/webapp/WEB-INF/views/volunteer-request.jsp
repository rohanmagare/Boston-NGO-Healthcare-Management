<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript">
function myFunction(projectName) {
	location.href = "volunteerProjectRequest.htm?proId=" + projectName; 
	alert("Email will be sent to an employee with the assignment request.");
	}
	</script>
<title>Project Request</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="projects" value="${sessionScope.projects}" />
	<a href="${contextPath}/logout.htm">Logout</a>
	<br />
	<div class="container">
		<h2>Current projects</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<td style="color: linen;">Project Id</td>
					<td style="color: linen;">Project Name</td>
					<td style="color: linen;">Project Aim</td>
					<td style="color: linen;">Project Description</td>
					<td style="color: linen;">Assign Project Request</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${projects}" var="p">
					<tr>
						<td style="color: linen;">${p.projectId}</td>
						<td style="color: linen;">${p.projectName}</td>
						<td style="color: linen;">${p.projectAim}</td>
						<td style="color: linen;">${p.projectDescription}</td>

						<td><button type="submit"
								onClick="myFunction(${p.projectId})" class="btn btn-lg"
								value="Assign Project Request"></button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>