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

<title>EmMa - new Employee</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value="/resources/css/Employee.css" />"
	rel="stylesheet">
</head>

<body>
	<div id="main">
		<form:form action="/EmMa/registeredEmployee.html"
			modelAttribute="initEmployee" method="POST">
			<div id="titleMsg">
				<a href="/EmMa/newEmployee.html">
					<i class="fa fa-user-plus fa-lg">
				</a></i>${newEmployeeTitle}
				
				<input type="submit" id = "sub" value="register"/> 
				<a href="/EmMa/"><i class="fa fa-home fa-lg"> </i></a>
			</div>
			<form:errors path="employee.*" />
			<table>
				<tr>
					<td><form:label path="firstName">First name:</form:label></td>
					<td><form:input path="firstName" type="text"
							value="enter first name"></form:input>
				</tr>
				<tr>
					<td><form:label path="lastName">Last name:</form:label></td>
					<td><form:input path="lastName" type="text"
							value="enter last name"></form:input>
				</tr>
				<tr>
					<td><form:label path="adress">Adress:</form:label></td>
					<td><form:input path="adress" type="text" value="enter adress"></form:input>
				</tr>
				<tr>
					<td><form:label path="zip">Zip code:</form:label></td>
					<td><form:input path="zip" type="text" value="enter zip"></form:input>
				</tr>
				<tr>
					<td><form:label path="city">City:</form:label></td>
					<td><form:input path="city" type="text" value="enter city"></form:input>
				</tr>
				<tr>
					<td><form:label path="title">Title:</form:label></td>
					<td><form:input path="title" type="text" value="enter title"></form:input>
				</tr>
				<tr>
					<td><form:label path="department">DepartmentNr:</form:label></td>
					<td><form:input path="department" type="text"
							value="select department"></form:input>
				</tr>
				<tr>
					<td><form:label path="salary">Salary:</form:label></td>
					<td><form:input path="salary" type="text" value="enter salary"></form:input>
				</tr>
				<tr>
					<td><form:label path="holidays">Holidays:</form:label></td>
					<td><form:input path="holidays" type="number"></form:input>
				</tr>
			</table>
		</form:form>

	</div>
</body>
</html>