<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h1>${msg}</h1>
  <h1>WELCOME TON PLAYER LOGIN</h1>
  <form action="playerlogin">
     User Name:<input type="text" name="username">
     Password:<input type="password" name="password"> <br>
     <button>Submit</button>  <button type="reset">Cancel</button>
  </form>
</body>
</html>