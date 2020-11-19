<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Home Page</title>
	</head>
	<body>
		<h1>Welcome to Our Corona Virus In-Memory Data Store</h1>
		<p>This web application will provide you with analytics about Corona Virus.</p>
		
		<p>Click on the button below to continue to our analytic page.</p>
		<form action="OperationsServlet" method="get">
			<input type="submit" name="analytic" value="Continue to Analytic Page"/>
		</form>
		
		<p>Click on the button below to continue to our search page.</p>
		<form action="OperationsServlet" method="get">
			<input type="submit" name="search" value="Continue to Search Page"/>
		</form>
		
		<p>Click on the button below to continue to our edit page.</p>
		<form action="OperationsServlet" method="get">
			<input type="submit" name="edit" value="Continue to Edit Page"/>
		</form>		
	</body>
</html>