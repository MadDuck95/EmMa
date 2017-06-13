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

<title>EmMa - new Calendar Event</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home"><a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a></div>
		<div id="titleMsg">
			<a href="/EmMa/newCalendar.html"> <i
				class="fa fa-plus fa-lg"></a></i>${registeredCalendarTitle}
		</div>
		<div id="flexbox">
			<table>
				<tr>
					<td>Event Title:</td>
					<td>${calTitle}</td>
				</tr>
				<tr>
					<td>Start Date:</td>
					<td>${startDate}</td>
				</tr>
				<tr>
					<td>End Date:</td>
					<td>${endDate}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>