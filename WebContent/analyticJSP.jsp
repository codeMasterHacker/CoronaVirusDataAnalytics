<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Analytic Page</title>
</head>
<body>
	<p>Click here to see the worldwide cases vs deaths analytic</p>
		
		<form action="SearchOperations" method="get">
			<input type="submit" name="casesVsDeaths" value="Submit"/>
		</form>
		
	<p>Click here to see Mobility Trends analytic</p>
		
		<form action="SearchOperations" method="get">
			<select name="countries">
				<option value="United States">United States of America</option> 
				<option value="Mexico">Mexico</option> 
				<option value="Canada">Canada</option>
				<option value="United Kingdom">United Kingdom</option>
				<option value="Japan">Japan</option>
				<option value="United Arab Emirates">United Arab Emirates</option>
  			</select>
  			<input type="submit" name="mobilityTrends" value="Submit"/>
		</form>
		
	<p>Choose a Mobility Trend to compare against the cases in that country</p>
		
		<form action="SearchOperations" method="get">
			<select name="countries">
				<option value="United States">United States of America</option> 
				<option value="Mexico">Mexico</option> 
				<option value="Canada">Canada</option>
				<option value="United Kingdom">United Kingdom</option>
				<option value="Japan">Japan</option>
				<option value="United Arab Emirates">United Arab Emirates</option>
  			</select>
  			<select name="mobility">
				<option value="Grocery and Pharmacy">Grocery and Pharmacy</option> 
				<option value="Parks">Parks</option> 
				<option value="Residential">Residential</option>
				<option value="Retail and Recreations">Retail and Recreations</option>
				<option value="Transit Stations">Transit Stations</option>
				<option value="Workplaces">Workplaces</option>
  			</select>
  			<input type="submit" name="casesVsMobility" value="Submit"/>
		</form>
		
	<p>Click here to see the country case vs death analytic</p>
		
		<form action="SearchOperations" method="get">
			<select name="countries">
				<option value="United States">United States of America</option> 
				<option value="Mexico">Mexico</option> 
				<option value="Canada">Canada</option>
				<option value="United Kingdom">United Kingdom</option>
				<option value="Japan">Japan</option>
				<option value="United Arab Emirates">United Arab Emirates</option>
  			</select>
  			<input type="submit" name="countryCasesVSDeaths" value="Submit"/>
		</form>
		
	<p>Click here to see the differences between mobility trends for workplaces and public transportation in the listed countries based on the specific month. </p>
		<form action="SearchOperations" method="get">
			<select name="countries">
				<option value="United States">United States of America</option> 
				<option value="Mexico">Mexico</option> 
				<option value="Canada">Canada</option>
				<option value="United Kingdom">United Kingdom</option>
				<option value="Japan">Japan</option>
				<option value="United Arab Emirates">United Arab Emirates</option>
  			</select>
  			<select name="months">
				<option value="February">February</option> 
				<option value="March">March</option> 
				<option value="April">April</option>
				<option value="May">May</option>
				<option value="June">June</option>
				<option value="July">July</option>
				<option value="August">August</option>
				<option value="September">September</option>
  			</select>
			<input type="submit" name="multiGraph" value="Submit"/>
		</form>
		
	<p>Click here to see how rich countries tested compared to poor countries.</p>
		<form action="ChartServlet" method="get">
			<input type="submit" name="richPoor_testing" value="Compare Testing"/>
		</form>
</body>
</html>