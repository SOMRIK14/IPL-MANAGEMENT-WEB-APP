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
 <h1>WELCOME TO BUY PLAYERS PAGE</h1>
 <table border="1">
     <tr>
       <th>PLAYER NAME</th>
       <th>ROLE</th>
       <th>COUNTRY</th>
       <th>BASE PRICE</th>
       <th>STATUS</th>
       <th>BUY PLAYER</th>
     </tr>
     
     <special:forEach var="player" items="${players}">
			<tr>
				<th>${player.getName()}</th>
				<th>${player.getRole()}</th>
				<th>${player.getCountry()}</th>
				<th>${player.getPrice()}</th>
				<th>${player.getStatus()}</th>
				
				<th><a href="buyplayer?id=${player.getId()}"><button>BUY PLAYER</button> </a></th> <!-- url rewritting -->
				
				
			</tr>
		</special:forEach>
     
   </table>
</body>
</html>