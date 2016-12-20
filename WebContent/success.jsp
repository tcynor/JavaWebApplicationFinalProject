<!DOCTYPE html>
<html>
<head>
<title>Mafia Movie Portal: Success</title>
<meta name="description" content="This is a JSP that demonstrates how a success response page for successful actions performed in our movie application.">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file='includes/styles.jsp' %>
</head>
<body>
<div class="container" align="center">
	<div class="hero-unit">
		<h1>Success</h1>
	</div>
	<%@ include file='includes/navigation.jsp' %>
	<div class="container" align="center">
		<p>${success}</p>
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file='includes/scripts.jsp' %>
</body>
</html>