<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="de">

<head>
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>EmMa - delete Employee</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value="/resources/css/Employee.css" />"
	rel="stylesheet">
</head>

<body>
	<div id="main">
		<form:form action="/EmMa/deletedEmployee.html"
		modelAttribute="getEmployee" method="POST">
		<div id="titleMsg">
			<a href="/EmMa/deleteEmployee.html">
			 <i class="fa fa-trash-o fa-lg">
			 </a></i> ${deleteEmployeeTitle}
			 
			<input type="submit" id = "del" value="delete"/> 
			<a href="/EmMa/"><i class="fa fa-home fa-lg"> </i></a>
		</div>

			<table>
				<tr>
					<td><form:label path="firstName">First Name:</form:label></td>
					<td><form:select path="firstName">
						<form:option value="" label="..." />
						<form:options items="${employeeFirstName}" />
					</form:select></td>
				</tr>
				<tr>
					<td><form:label path="lastName">Last name:</form:label></td>
					<td><form:select path="lastName">
						<form:option value="" label="..." />
						<form:options items="${employeeLastName}" />
					</form:select></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>