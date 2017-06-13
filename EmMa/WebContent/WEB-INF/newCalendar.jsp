<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<form:form action="/EmMa/registeredCalendar.html"
			modelAttribute="initCalendar" method="POST">
			<div id="titleMsg">
				<a href="/EmMa/newCalendar.html"><i
					class="fa fa-plus fa-lg"></i></a> ${newCalendarTitle}
			</div>

			<div id="flexbox">
				<table>
					<tr>
						<td><form:label path="calTitle">Event Title (250 characters):</form:label></td>
						<td><form:input path="calTitle" type="text"></form:input>
						<td><form:errors path="calTitle"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<tr>
						<td><form:label path="startDate">Start Date (YYYY-MM-DD):</form:label></td>
						<td><form:input path="startDate" type="text"></form:input>
						<td><form:errors path="startDate"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<tr>
						<td><form:label path="endDate">End Date (YYYY-MM-DD):</form:label></td>
						<td><form:input path="endDate" type="text"></form:input>
						<td><form:errors path="endDate"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
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