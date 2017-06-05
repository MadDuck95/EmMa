<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">

<head>
<script src="<c:url value="/resources/js/main.js" />"></script>
<link href="<c:url value="/resources/css/Projects.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>EmMa - registered Project</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<div id="title">
			<a href="/EmMa/newProject.html"> <i class="fa fa-plus fa-lg"></i></a>
			${registeredProject}
		</div>
		<div id="flexbox">
			<table>
				<tr>
					<td>${pText}</td>
				</tr>
				<tr>
					<td>Start date:</td>
					<td>${startDate}</td>
				</tr>
				<tr>
					<td>End date:</td>
					<td>${endDate}</td>
				</tr>
				<tr>
					<td>Employee ID's:</td>
					<td>${lastName}</td>
				</tr>
			</table>
		</div>
		<div id="flexbox">
			<table>
				<tr>
					<td>Project:</td>
					<td>${proDesc}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>