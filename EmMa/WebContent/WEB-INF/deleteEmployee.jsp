<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="de">

<head>
<!-- javascript -->
<script src="<c:url value="/resources/js/employee.js" />"></script>
<script src="<c:url value="/resources/js/sweetalert.min.js" />"></script>

<!-- css -->
<link href="<c:url value="/resources/css/Employee.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/sweetalert.css"/>"
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

<title>EmMa - delete Employee</title>

<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<form:form name="employeeSelect" onsubmit="return validateEmployee()"
			action="/EmMa/deletedEmployee.html" modelAttribute="getEmployee"
			method="POST">
			<div id="titleMsg">
				<a href="/EmMa/deleteEmployee.html"> <i
					class="fa fa-trash-o fa-lg"></i></a> ${deleteEmployeeTitle}
			</div>

			<div id="flexbox">
				<table>
					<tr>
						<td><form:select path="lastName" name = "lastName">
								<form:option value="" label="Select employee ..." />
								<form:options items="${employeeHashTable}" />
							</form:select>
					</tr>
					<tr>
						<td><input type="submit" id="del" value="delete" /></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>

</body>
</html>