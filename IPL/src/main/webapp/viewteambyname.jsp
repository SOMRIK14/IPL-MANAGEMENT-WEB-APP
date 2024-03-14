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
   <h1>WELCOME TO VIEW TEAM by NAME PAGE</h1>
   <h2>Select team</h2>
   
   <form action="fetchbyusingteamname" method="post">
     <select name="name">

      <special:forEach var="team" items="${teams}">
         
         <option value="${team.getName()}">${team.getName()}</option>
      
      </special:forEach>
 
     </select>
   
   <button>Search</button>
   
   </form>
   
   <a href="managementHome.jsp"><button>Back</button></a>
</body>
</html>