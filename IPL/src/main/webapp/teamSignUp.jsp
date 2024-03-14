<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="special"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Welcome to Team Sign Up</h1>
<body>
	<special:form action="teamsignup" method="post" modelAttribute="team">
	
      Name:<special:input path="name" />
      UserName:<special:input path="username" />
      Password:<special:input path="password" />
      Logo:<special:input path="imageLink" />


		<special:button>Submit</special:button>
		<special:button type="reset">Cancel</special:button>
	</special:form>
	
		<a href="teamLogin.jsp">Already have an account</a>
	
</body>
</html>