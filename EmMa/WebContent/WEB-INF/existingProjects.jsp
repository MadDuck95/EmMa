<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="de">

<head>
<link href="<c:url value="/resources/css/Projects.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="<c:url value="/resources/js/main.js" />"></script>
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>EmMa - new Project</title>
</head>


<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<form:form action="/EmMa/existingProjectsSelect.html"
			modelAttribute="initProjects" method="POST">
			<div id="title">
				<a href="/EmMa/existingProjects.html"> <i
					class="fa fa-book fa-lg"></i></a>${existingProjects}
			</div>
			<div id="flexbox">
				<table>
					<tr>
					<td><form:select path="pDesc">
								<form:option value="" label="Select project ..." />
								<form:options items="${projectsTable}" />
							</form:select> 
<%-- 						<td><form:errors path="lastName"
								cssStyle="background-color:#FFAAAA; border:1px solid red;" /></td> --%>
					</tr>
					<tr>
						<td><input type="submit" value="Show details" /></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>
</body>
</html>