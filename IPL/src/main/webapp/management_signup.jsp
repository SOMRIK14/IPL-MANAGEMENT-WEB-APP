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
<body>
	<h1>Welcome to Management signup Page</h1>
	
	<special:form action="managementsignup" method="post" modelAttribute="management">
     Name:<special:input path="name" />

     Password:<special:input path="password" />
		<special:button>Submit</special:button>
		<special:button type="reset">Cancel</special:button>
	</special:form>
	
	<a href="managmentLogin.jsp">Already have an account</a>

</body>
</html>