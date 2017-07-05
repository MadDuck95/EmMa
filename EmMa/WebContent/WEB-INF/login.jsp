<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">

<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/main.js" />"></script>
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
</head>

<body onload='document.loginForm.username.focus();' onload="startTime()">

	<div id="main">
		
		<h1 id="title">Welcome to the Employee Manager (EmMa)</h1>	
		<div id="login-box">

			<h2>Login with Username and Password</h2>

		<form name='loginForm'
		  action="<c:url value='/j_spring_security_check' />" method='POST'>

			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username'></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>	
					<td colspan='2' id="submit"><input name="submit" type="submit"
				  	value="submit" /></td>
				</tr>
		  </table>

		</form>
	</div>
	</div>
</body>
</html>