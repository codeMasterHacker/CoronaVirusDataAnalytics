<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Search Operations Page</title>
	</head>
	
	<body>
		<h1>This is the Search Operations Page</h1>	
		
		<form action="GetCountryByDate" method="get">
			<label for="countries">Countries:</label> 
			<select name="countries">
				<option value="United States">United States of America</option> 
				<option value="Mexico">Mexico</option> 
				<option value="Canada">Canada</option>
  			</select>
  			
  			<label for="startDate">From (YYYY-MM-DD):</label>
  			<input type="text" name="startDate" required="required" size="10" maxlength="10"/>	
  			 		
			<label for="endDate">To (YYYY-MM-DD):</label> 
			<input type="text" name="endDate" required="required" size="10" maxlength="10"/> 
  			
			<input type="submit" value="Submit"/>
		</form>
		
	</body>
</html>
