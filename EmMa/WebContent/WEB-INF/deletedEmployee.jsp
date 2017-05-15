<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">

<head>
<link href="<c:url value="/resources/css/Employee.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>EmMa - delete Employee</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div id="main">
		<div id="titleMsg">
			<a href="/EmMa/deleteEmployee.html"> <i
				class="fa fa-trash-o fa-lg"></a></i>${deletedEmployeeTitle} <a
				href="/EmMa/"><i class="fa fa-home fa-lg"> </i></a>
		</div>
		<h2>${deletedText}</h2>
		<table>
			<tr>
				<td>First name:</td>
				<td>${firstName}</td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td>${lastName}</td>
			</tr>
		</table>
	</div>
</body>
</html>