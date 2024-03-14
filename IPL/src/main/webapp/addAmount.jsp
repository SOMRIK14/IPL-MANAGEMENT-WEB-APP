<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addamount"  method="post">
<%int id=Integer.parseInt(request.getParameter("id")); %>

  Enter Amount: <input type="text" name="wallet">
  <input type="text" name="tid" value="<%=id%>" hidden="hidden">
  <br>
  <button>Add</button> <button type="reset">Cancel</button>
  
</form>
</body>
</html>