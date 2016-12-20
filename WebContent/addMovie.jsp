<!DOCTYPE html>
<html>
<head>
<title>Mafia Movies Website by Travis Cynor: Add New Mafia Movie</title>
<meta name="description" content="This is a JSP demonstrates how to use
a form to add a new mafia Movie to the database.">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file='includes/styles.jsp' %>
</head>
<body>
<div class="container" align="center">
	<div class="hero-unit">
		<h1>Add Movie</h1>
	</div>
<%@ include file='includes/navigation.jsp' %>
	<div class="container">
		<br><br><form action="AddMovie">
			<label for="title" ><strong>Movie Title</strong></label>
			<input name="title">
			
			<label for="director"><strong>Director</strong></label>
			<input name="director">
			
			<label for="duration"><strong>Duration</strong></label>
			<input name="duration">
		
			<input type="submit" value="Add Movie">
		</form><br><br>
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file='includes/scripts.jsp' %>
</body>
</html>