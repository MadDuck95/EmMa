<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">

<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="<c:url value="/resources/js/main.js" />"></script>
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>EmMa - Calendar</title>
</head>


<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<div id="title">${calendarMainTitle}</div>

		<div id="flexbox">
			<a href="/EmMa/newCalendar.html">
				<div id="divTile">
					<div id=divTileContent>
						<p>
							<i class="fa fa-plus fa-4x"></i>
						</p>
						${newCalendar}
					</div>
				</div>
			</a> <a href="/EmMa/calendar.html">
				<div id="divTile">
					<div id="divTileContent">
						<p>
							<i class="fa fa-calendar fa-4x"></i>
						</p>${viewExisting}
					</div>
				</div>
		</div>
		<div id="flexbox">
			<a href="/EmMa/deleteEvent.html">
				<div id="divTile">
					<div id="divTileContent">
						<p>
							<i class="fa fa-trash fa-4x"></i>
						</p>${deleteEvent}
					</div>
				</div>
		</div>
	</div>
</body>
</html>