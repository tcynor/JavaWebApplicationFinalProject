<!DOCTYPE html>
<html>
<head>
<title>Mafia Movies Website by Travis Cynor: Error</title>
<meta name="description" content="This is a JSP demonstrates a error response page for when we encounter problems in our web application.">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file='includes/styles.jsp' %>
</head>
<body>
<div class="container" align="center">
	<div class="hero-unit">
		<h1>Error</h1>
	</div>
	<%@ include file='includes/navigation.jsp' %>
	<div class="container" align="center">
		<br><br><p>${error}</p>
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file='includes/scripts.jsp' %>
</body>
</html>