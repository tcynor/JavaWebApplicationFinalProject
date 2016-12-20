<%@page import="edu.cvtc.web.dao.impl.MovieDaoImpl"%>
<%@page import="edu.cvtc.web.dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Mafia Movies Website by Travis Cynor: Create Database</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="This webpage is used to create the mafia Movie database. ">
<link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container" align="center">
	<div class="hero-unit">
		<h1>Create Database</h1>	
	</div>
	<%@ include file="includes/navigation.jsp" %>
	<div class="container">
	
	<% 
	if (null != request.getParameter("create")) {
		
		try {
			final MovieDao movieDao = new MovieDaoImpl();
			movieDao.createDatabase();
			
			%>
			<br><br><p>Success! The database was created.</p>
			<%
			
		} catch (Exception e) {
			%>
			<br><br><p>Sorry, there was a problem creating the database.</p>
			<br><br><p>Error: <%=e.getMessage() %></p>
			<%
		}		
		
	} else {
		%>
		<br><br><p>To create the Movie database, click on the form below </p>
		<form method="post">
			<div class="form-group">
				<input type="submit" name="create" value="Create!">
			</div>
		</form>
		<%
	}	
	%>	
	</div>	
	<hr>
	<%@ include file='includes/footer.jsp' %>
</div>
<%@ include file='includes/scripts.jsp' %>
</body>
</html>