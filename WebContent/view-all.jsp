<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Mafia Movie Portal: Movie List</title>
<meta name="description" content="This is a JSP that demonstrates 
how to output every Movie in our database to a webpage.">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file='includes/styles.jsp' %>
</head>
<body>
<div class="container" align="center">
	<div class="hero-unit">
		<h1>Movie List</h1>
	</div>
	<%@ include file='includes/navigation.jsp' %>
	<div class="container">
		<jsp:include page="includes/movies.jsp"></jsp:include>
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file='includes/scripts.jsp' %>
</body>
</html>