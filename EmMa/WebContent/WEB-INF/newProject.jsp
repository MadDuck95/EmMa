<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="de">

<head>
<script src="<c:url value="/resources/js/main.js" />"></script>
<link href="<c:url value="/resources/css/Projects.css" />"
	rel="stylesheet">

<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>EmMa - new Project</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body onload="startTime()">
	<div id="main">
		<div id="clock"></div>
		<div id="home">
			<a href="/EmMa/"> <i class="fa fa-home fa-lg"> </i></a>
		</div>
		<div id="title">
			<a href="/EmMa/newProject.html"> <i class="fa fa-plus fa-lg"></i></a>
			${newProject}
		</div>

		<form method="POST" action="/EmMa/registeredProject.html">
			<div id="flexbox">
				<table>
					<tr>
						<td><spring:bind path="pro.pDesc">
								<form:label path="pro.pDesc">Name: </form:label>
							</spring:bind></td>
						<td><spring:bind path="pro.pDesc">
								<form:input value="" path="pro.pDesc" />
							</spring:bind></td>
					</tr>
					<tr>
						<td><spring:bind path="pro.startDate">
								<form:label path="pro.startDate">Beginn date: </form:label>
							</spring:bind></td>
						<td><spring:bind path="pro.startDate">
								<form:input path="pro.startDate" type="date"></form:input>
							</spring:bind></td>
					</tr>
					<tr>
						<td><spring:bind path="pro.endDate">
								<form:label path="pro.endDate">End date: </form:label>
							</spring:bind></td>
						<td><spring:bind path="pro.endDate">
								<form:input path="pro.endDate" type="date"></form:input>
							</spring:bind></td>
					</tr>
					<tr>
						<td><spring:bind path="emp.lastName">
								<form:label path="emp.lastName">Team Member 1:</form:label>
							</spring:bind></td>

						<td><spring:bind path="emp.lastName">
								<form:select path="emp.lastName">
									<form:option value="" label="Select employee ..." />
									<form:options items="${employeeHashTable}" />
								</form:select>
								<%-- <td><form:errors path="lastName" --%>
							</spring:bind></td>
					</tr>
					<tr>
						<td><spring:bind path="emp.lastName">
								<form:label path="emp.lastName">Team Member 2:</form:label>
							</spring:bind></td>


						<td><spring:bind path="emp.lastName">
								<form:select path="emp.lastName">
									<form:option value="" label="Select employee ..." />
									<form:options items="${employeeHashTable}" />
								</form:select>
								<%-- <td><form:errors path="lastName" --%>
							</spring:bind></td>
					</tr>
					<tr>
						<td><spring:bind path="emp.lastName">
								<form:label path="emp.lastName">Team Member 3:</form:label>
							</spring:bind></td>

						<td><spring:bind path="emp.lastName">
								<form:select path="emp.lastName">
									<form:option value="" label="Select employee ..." />
									<form:options items="${employeeHashTable}" />
									<%-- <td><form:errors path="lastName" --%>
								</form:select>
							</spring:bind></td>
					</tr>
					<tr>
						<td><spring:bind path="emp.lastName">
								<form:label path="emp.lastName">Team Member 4:</form:label>
							</spring:bind></td>

						<td><spring:bind path="emp.lastName">
								<form:select path="emp.lastName">
									<form:option value="" label="Select employee ..." />
									<form:options items="${employeeHashTable}" />
									<%--<td><form:errors path="lastName" --%>
								</form:select>
							</spring:bind></td>
					</tr>
					<tr>
						<td><spring:bind path="pro.pText">
								<form:label path="pro.pText">Description (250 Characters):</form:label>
							</spring:bind></td>
						<td><form:textarea path="pro.pText" rows="5" cols="30" /></td>
					</tr>

					<tr>
						<td><input type="submit" id="sub" value="register project" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>