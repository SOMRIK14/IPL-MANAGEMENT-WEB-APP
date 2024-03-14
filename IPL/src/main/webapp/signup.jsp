<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="signup" method="post">
		<h1>Choose your role</h1>
		<input type="radio" name="role" value="Management">Management<br>
		<br> <input type="radio" name="role" value="Team">Team<br>
		<br> <input type="radio" name="role" value="Player">Player<br>
		<br>
		<button>Submit</button>
		<button type="reset">Cancel</button>
	</form>
</body>
</html>