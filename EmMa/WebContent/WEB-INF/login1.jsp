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
<body onload='document.f.j_username.focus();'>
	<h1>Login</h1>
   <form name='f' action='/EmMa/j_spring_security_check' method='POST'>
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='j_username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='j_password' /></td>
         </tr>
         <tr>
            <td colspan='2'><input name="submit" type="submit" value="login" /></td>
         </tr>
      </table>
  </form>
</body>

</body>
</html>