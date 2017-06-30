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

<title>EmMa - new Employee</title>

<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<form:form name="employeeForm" onsubmit="return validateForm()"
			action="/EmMa/registeredEmployee.html" modelAttribute="initEmployee"
			method="POST">
			<div id="titleMsg">
				<a href="/EmMa/newEmployee.html"> <i
					class="fa fa-user-plus fa-lg"></i></a> ${newEmployeeTitle}
			</div>

			<div id="flexbox">
				<table>
					<tr>
						<td><form:label path="firstName">First name:</form:label></td>
						<td><form:input name="firstName" placeholder="enter first name..." path="firstName" type="text"></form:input>
					</tr>
					<tr>
						<td><form:label path="lastName">Last name:</form:label></td>
						<td><form:input name="lastName" placeholder="enter last name..." path="lastName" type="text"></form:input>
					</tr>
					<tr>
						<td><form:label path="adress">Adress:</form:label></td>
						<td><form:input name="adress" placeholder="enter adress..." path="adress" type="text"></form:input>
					</tr>
					<tr>
						<td><form:label path="zip">Zip code:</form:label></td>
						<td><form:input name="zip" placeholder="enter zip code..." path="zip" value="" type="text"></form:input>
					</tr>
					<tr>
						<td><form:label path="city">City:</form:label></td>
						<td><form:input name="city" placeholder="enter city..." path="city" type="text"
								text="enter city..."></form:input>
					</tr>
					<tr>
						<td><form:label path="title">Title:</form:label></td>
						<td><form:input name="title" placeholder="enter title..." path="title" type="text"></form:input>
					</tr>
					<tr>
						<td><form:label path="department">Department</form:label></td>
						<td><form:select name="department" path="department">
								<form:option value="" label="--- Select department ---" />
								<form:options items="${departmentHashTable}" />
							</form:select></td>

					</tr>
					<tr>
						<td><form:label path="salary">Salary:</form:label></td>
						<td><form:input name="salary" path="salary" type="number"></form:input>
					</tr>
					<tr>
						<td><form:label path="holidays">Holidays:</form:label></td>
						<td><form:input name="holidays" path="holidays" type="number"></form:input>
					</tr>
					<tr>
						<td><input type="submit" id="sub" value="register" /></td>
					</tr>
				</table>
			</div>
		</form:form>
	</div>

</body>
</html>