<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">

<head>
<script src="<c:url value="/resources/js/main.js" />"></script>
<link href="<c:url value="/resources/css/Employee.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>EmMa - new Employee</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home"><a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a></div>
		<div id="titleMsg">
			<a href="/EmMa/newEmployee.html"> <i
				class="fa fa-user-plus fa-lg"></a></i>${registeredEmployeeTitle}
		</div>
		<div id="flexbox">
			<table>
				<tr>
					<td>First name:</td>
					<td>${firstName}</td>
				</tr>
				<tr>
					<td>Last name:</td>
					<td>${lastName}</td>
				</tr>
				<tr>
					<td>Adress:</td>
					<td>${adress}</td>
				</tr>
				<tr>
					<td>Zip code:</td>
					<td>${zip}</td>
				</tr>
				<tr>
					<td>City:</td>
					<td>${city}</td>
				</tr>
				<tr>
					<td>Department:</td>
					<td>${department}</td>
				</tr>
				<tr>
					<td>Title:</td>
					<td>${title}</td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td>${salary}</td>
				</tr>
				<tr>
					<td>Holidays:</td>
					<td>${holidays}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>