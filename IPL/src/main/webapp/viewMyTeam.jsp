<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>WELCOME TO MY VIEW TEAM PAGE</h1>
<h1>${teamname}players are:</h1>

<% String msg =request.getParameter("msg");

  if(msg!=null)
  {%>
	 <h1>${msg}</h1>
  <%}
  
  else
  {%>
  <table border="1">
    <tr>
      <th>Player Name</th>
      <th>Player Role</th>
    </tr>
    
    <special:forEach var="player" items="${players}">
     <tr>
       <td>${player.getName()}</td>
       <td>${player.getRole()}</td>
     </tr>
    </special:forEach>
    
  </table>
	  
  <%}

%>
<a href="managementHome.jsp"><button>Back</button></a>

</body>
</html>