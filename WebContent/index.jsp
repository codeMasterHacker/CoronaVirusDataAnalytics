
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>
		
		<!-- FONTS -->
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Poppins&display=swap" rel="stylesheet">
		
		<!-- ICONS -->
		<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
		<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
		
		<title>Home Page</title>
	</head>
	<body>
		<h1>Welcome to Our Corona Virus ​In-Memory Data Store</h1>
		<center><p>This web application will provide you with COVID-19 analytics.</p>
		<p>Click on the button below to continue to our search operations page.</p><br>
		<div class= "input-icons">
			<form action="SearchOperationsPage" method="get"> 
				<i class="fa fa-arrow-circle-right" style="padding-top: 15px;"></i>
					<input type="submit" name="SearchOperationsPage" value="Continue to the COVID-19 Mobility Homepage" class="topbuttons"/>
			</form></center>
	</body>

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