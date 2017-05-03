<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="de">

<head>
<link href="<c:url value="/resources/css/newEmployee.css" />"
	rel="stylesheet">
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>EmMa - new Employee</title>
</head>

<body>
	<div id="main">
		<form action="/EmMa/registeredEmployee.html" method="post">
			<div id="title">${title}
				<input id="sub" type="submit" value="register" />
				<button id = "back" type="button">Back</button>
			</div>
			<div id="flexbox">
				<p>
					First name : <input type="text" name="firstName" />
				</p>
				<p>
					Last name : <input type="text" name="lastName" />
				</p>
				<p>
					Adress : <input type="text" name="adress" />
				</p>
				<p>
					Zip code : <input type="text" name="zip" />
				</p>
				<p>
					City : <input type="text" name="city" />
				</p>
			</div>
			<div id="flexbox">
				<p>
					Department : <input type="text" name="department" />
				</p>
				<p>
					Title : <input type="text" name="title" />
				</p>
				<p>
					Salary : <input type="text" name="salary" />
				</p>
				<p>
					Holidays : <input type="text" name="holidays" />
				</p>
			</div>
		</form>
	</div>
</body>
</html>