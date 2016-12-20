<!doctype html>
<html>
<head>
<title>Mafia Movie Website: Search</title>
<meta name="description" content="This is a JSP for a simple search page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file='includes/styles.jsp' %>
</head>
<body>
<div class="container" align="center">
	<div class="hero-unit">
		<h1>Search</h1>
	</div>
	<%@ include file='includes/navigation.jsp' %>
	<div class="container">
		<br><br><form action="Search">
			<label for="title"><strong>Search by Movie Title:</strong></label>
			<input name="title">
			<input type="hidden" name="searchType" value="title">
			<input type="submit" value="Search">
		</form>
		<form action="Search">
			<label for="director"><strong>Search by Movie Director:</strong></label>
			<input name="director">
			<input type="hidden" name="searchType" value="director">
			<input type="submit" value="Search">
		</form><br><br>
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file='includes/scripts.jsp' %>
</body>
</html>