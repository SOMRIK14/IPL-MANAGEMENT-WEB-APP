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
<h1>${msg}</h1>
   <h1>WELCOME TO VIEW ALL PLAYERS PAGE</h1>
   
   <table border="1">
     <tr>
       <th>PLAYER NAME</th>
       <th>ROLE</th>
       <th>COUNTRY</th>
       <th>BASE PRICE</th>
       <th>STATUS</th>
       <th>CHANGE STATUS</th>
     </tr>
     
     <special:forEach var="player" items="${players}">
			<tr>
				<th>${player.getName()}</th>
				<th>${player.getRole()}</th>
				<th>${player.getCountry()}</th>
				<th>${player.getPrice()}</th>
				<th>${player.getStatus()}</th>
				
				<th><a href="changeplayerstatus?id=${player.getId()}"><button>Change Status</button> </a></th> <!-- url rewritting -->
				
				
			</tr>
		</special:forEach>
     
   </table>
   
   <a href="managementHome.jsp">Back</a>
   
   
</body>
</html>