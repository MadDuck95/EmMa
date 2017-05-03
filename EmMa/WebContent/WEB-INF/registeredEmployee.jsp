<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">

<head>
<link href="<c:url value="/resources/css/newEmployee.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>EmMa - new Employee</title>
</head>
<body>
	<div id="main">
		<div id="title">${title}</div>
		<h1>${headerMessage}</h1>
		<table>
			<tr>
				<td>First name:</td>
				<td>${e1.firstName}</td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td>${e1.lastName}</td>
			</tr>
			<tr>
				<td>Adress:</td>
				<td>${e1.adress}</td>
			</tr>
			<tr>
				<td>Zip code:</td>
				<td>${e1.zip}</td>
			</tr>
			<tr>
				<td>City:</td>
				<td>${e1.city}</td>
			</tr>
			<tr>
				<td>Department:</td>
				<td>${e1.department}</td>
			</tr>
			<tr>
				<td>Title:</td>
				<td>${e1.title}</td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td>${e1.salary}</td>
			</tr>
			<tr>
				<td>Holidays:</td>
				<td>${e1.holidays}</td>
			</tr>
		</table>
	</div>
</body>
</html>