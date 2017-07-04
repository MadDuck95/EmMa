<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="de">

<head>
<!-- javascript -->
<script src="<c:url value="/resources/js/project.js" />"></script>

<!-- css -->
<link href="<c:url value="/resources/css/Projects.css" />"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>

<title>EmMa - delete calendar event</title>

<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<div id="titleMsg">
			<a href="/EmMa/deleteProject.html"> <i
				class="fa fa-trash-o fa-lg"></i></a>${deletedEventTitle}
		</div>
	</div>
</body> 
</html>