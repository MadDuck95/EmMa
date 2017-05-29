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


<title>EmMa - new Employee</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<form:form action="/EmMa/registeredEmployee.html"
			modelAttribute="initEmployee" method="POST">
			<div id="titleMsg">
				<a href="/EmMa/newEmployee.html"> <i
					class="fa fa-user-plus fa-lg"></a></i> ${newEmployeeTitle}
			</div>

			<div id="flexbox">
				<table>
					<tr>
						<td><form:label path="firstName">First name:</form:label></td>
						<td><form:input path="firstName" type="text"></form:input>
						<td><form:errors path="firstName"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<tr>
						<td><form:label path="lastName">Last name:</form:label></td>
						<td><form:input path="lastName" type="text"></form:input>
						<td><form:errors path="lastName"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<tr>
						<td><form:label path="adress">Adress:</form:label></td>
						<td><form:input path="adress" type="text"></form:input>
						<td><form:errors path="adress"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<tr>
						<td><form:label path="zip">Zip code:</form:label></td>
						<td><form:input path="zip" type="text"></form:input>
						<td><form:errors path="zip"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<tr>
						<td><form:label path="city">City:</form:label></td>
						<td><form:input path="city" type="text" text="enter city..."></form:input>
						<td><form:errors path="city"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<tr>
						<td><form:label path="title">Title:</form:label></td>
						<td><form:input path="title" type="text"></form:input>
						<td><form:errors path="title"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<tr>
						<td><form:label path="department">Department</form:label></td>
						<td><form:select path="department">
								<form:option value="" label="--- Select department ---" />
								<form:options items="${departmentHashTable}" />
							</form:select></td>
						<td><form:errors path="department"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<tr>
						<td><form:label path="salary">Salary:</form:label></td>
						<td><form:input path="salary" type="text"></form:input>
						<td><form:errors path="salary"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<tr>
						<td><form:label path="holidays">Holidays:</form:label></td>
						<td><form:input path="holidays" type="number"></form:input>
						<td><form:errors path="holidays"
								cssStyle="background-color: #FFAAAA; border: 1px solid red;" /></td>
					</tr>
					<td><input type="submit" id="sub" value="register" /> <a
						href="/EmMa/"></a></td>
				</table>
			</div>
		</form:form>
	</div>

</body>
</html>