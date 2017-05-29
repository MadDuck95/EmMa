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

<title>EmMa - delete Employee</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<form:form action="/EmMa/deletedEmployee.html"
			modelAttribute="getEmployee" method="POST">
			<div id="titleMsg">
				<a href="/EmMa/deleteEmployee.html"> <i
					class="fa fa-trash-o fa-lg"></a></i> ${deleteEmployeeTitle}
			</div>

			<div id="flexbox">
				<table>
					<tr>
						<td><form:select path="lastName">
								<form:option value="" label="Select employee ..." />
								<form:options items="${employeeHashTable}" />
							</form:select>
						<td><form:errors path="lastName"
								cssStyle="background-color:#FFAAAA; border:1px solid red;" /></td>
					</tr>
					<td><input type="submit" id="del" value="delete" /></td>

				</table>
			</div>
		</form:form>
	</div>

</body>
</html>