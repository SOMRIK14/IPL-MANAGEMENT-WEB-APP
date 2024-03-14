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
     <h1>WELCOME TO PLAYERS DETAILS EDIT PAGE</h1>
     
     
   <special:form action="updateplayer" method="post" modelAttribute="player">
    Name: <special:input path="name"/>
    User Name: <special:input path="username"/>
    Password: <special:input path="password"/>
    Role: <special:select path="role" id="xc">
                <special:option value="">select</special:option>
                <special:option value="Batsman">Batsman</special:option>
                <special:option value="Bowler">Bowler</special:option>
                <special:option value="WicketKeeper">Wicket Keeper</special:option>
                <special:option value="AllRounder">All Rounder</special:option>
         </special:select>
         
    Country: <special:input path="country" hidden="true"/>
    Base Price: <special:input path="price"/>
    
    <special:button>UPDATE</special:button>  <special:button type="reset">Cancel</special:button>
       
  </special:form>
  
  <a href="loginArea.jsp"><button>Back</button></a>
</body>
</html>