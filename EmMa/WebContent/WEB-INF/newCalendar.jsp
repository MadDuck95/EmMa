<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="de">

<head>
<!-- javascript -->
<script src="<c:url value="/resources/js/event.js" />"></script>
<script src="<c:url value="/resources/js/sweetalert.min.js" />"></script>

<!-- css -->
<link href="<c:url value="/resources/css/Employee.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/sweetalert.css"/>"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>EmMa - new Calendar Event</title>

<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<form:form name="eventForm" action="/EmMa/registeredCalendar.html"
			modelAttribute="initCalendar" onsubmit="return validateEvent()"
			method="POST">
			<div id="titleMsg">
				<a href="/EmMa/newCalendar.html"><i class="fa fa-plus fa-lg"></i></a>
				${newCalendarTitle}
			</div>

			<div id="flexbox">
				<table>
					<tr>
						<td><form:label path="calTitle" name="calTitle">Event name :</form:label></td>
						<td><form:input path="calTitle" type="text"></form:input>
					</tr>
					<tr>
						<td><form:label path="startDate" name="startDate">Start date:</form:label></td>
						<td><form:input path="startDate" type="date"></form:input>
					</tr>
					<tr>
						<td><form:label path="endDate" name="endDate">End date:</form:label></td>
						<td><form:input path="endDate" type="date"></form:input>
					</tr>
					<tr>
						<td><input type="submit" id="sub" value="register event" /></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>

</body>
</html>