<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>

<body bgcolor="grey">
	<center>
		<h1>Login Page</h1>
		<h3>Incorrect LOGIN!</h3>
		<form action="loginAgain" method="post" name="myForm">

			Username: <input name="username" type="text" value="" required><br>
			<br> Password: <input name="password" type="password" value=""
				required><br>
			<br> <br>
			<br> <input type="submit" value="Login" name="submit">

		</form>
	</center>
</body>
</html>