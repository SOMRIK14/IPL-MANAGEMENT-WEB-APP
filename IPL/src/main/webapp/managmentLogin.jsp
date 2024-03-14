<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <h1>${msg2}</h1>
	<form action="managementlogin" method="post">
		UserName:<input type="text" name="name"> Password:<input
			type="password" name="password">
		<button>Login</button>
		<button type="reset">Cancel</button>
	</form>
</body>
</html>