<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Java Web Programming: Search Results</title>
<meta name="description" content="This is a JSP example of a search results page.">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file='includes/styles.jsp' %>
</head>
<body>
<div class="container" align="center">
	<div class="hero-unit">
		<h1>Search Results</h1>
	</div>
	<%@ include file='includes/navigation.jsp' %>
	<div class="container" align="center">
		<jsp:include page="includes/movies.jsp"></jsp:include>
	</div>
	<hr>
	<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file='includes/scripts.jsp' %>
</body>
</html>