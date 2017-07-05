<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">

<head>
<!-- css -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- javascript -->
<script src="<c:url value="/resources/js/main.js" />"></script>

<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>

<title>Employee Manager - EmMa</title>

<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/login"> <i class="fa fa-sign-out fa-lg"> </i></a>
		</div>

	<div id="title">
			<img src="<c:url value="/resources/pictures/EmMaLogo.PNG"/>"></img>
		</div>

		<div id="flexbox">
			<a href="/EmMa/newEmployee.html">
				<div id="divTile">
					<div id=divTileContent>
						<p>
							<i class="fa fa-user-plus fa-4x"></i>
						</p>
						${newEmployee}
					</div>
				</div>
			</a> <a href="/EmMa/calendarMain.html">
				<div id="divTile">
					<div id="divTileContent">
						<p>
							<i class="fa fa-calendar fa-4x"></i>
						</p>${calendar}
					</div>
				</div>
		</div>
		</a>
		<div id="flexbox">
			<a href="/EmMa/deleteEmployee.html">
				<div id="divTile">
					<div id="divTileContent">
						<p>
							<i class="fa fa-trash-o fa-4x"></i>
						</p>
						${deleteEmployee}
					</div>
				</div>
			</a> <a href="/EmMa/projectsMain.html">
				<div id="divTile">
					<div id="divTileContent">
						<p>
							<i class="fa fa-users fa-4x"></i>
						</p>
						${projects}
					</div>
				</div>
			</a>
		</div>
	</div>
</body>