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
	<table border="1">
		<tr>
			<th>Team Name</th>
			<th>Wallet</th>
			<th>Status</th>
			<th>Change Status</th>
			<th>Add Amount</th>
			<th>Team Players</th>
		</tr>

		<special:forEach var="team" items="${teams}">
			<tr>
				<th>${team.getName()}</th>
				<th>${team.getWallet()}</th>
				<th>${team.isStatus()}</th>
				<th><a href="changestatus?id=${team.getId()}"><button>Change Status</button> </a></th> <!-- url rewritting -->
				<th><a href="addAmount.jsp?id=${team.getId()}"><button>Add Amount</button></a></th>
				<th> <button>Team Players</button> </th>
			</tr>
		</special:forEach>

      
	</table>
	<a href="managementHome.jsp"><button>Back</button></a>
</body>
</html>