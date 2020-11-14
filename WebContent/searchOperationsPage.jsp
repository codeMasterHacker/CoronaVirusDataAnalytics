<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Search Operations Page</title>
	</head>
	
	<body>
		<h1>This is the Search Operations Page</h1>	
		
		<p>Returns all fields for the country between those dates</p>	
		
		<form action="SearchOperations" method="get">
			<label for="countries">Countries:</label> 
			<select name="countries">
				<option value="United States">United States of America</option> 
				<option value="Mexico">Mexico</option> 
				<option value="Canada">Canada</option>
				<option value="United Kingdom">United Kingdom</option>
				<option value="Japan">Japan</option>
				<option value="United Arab Emirates">United Arab Emirates</option>
  			</select>
  			
  			<label for="startDate">From (YYYY-MM-DD):</label>
  			<input type="text" name="startDate" required="required" size="10" maxlength="10"/>	
  			 		
			<label for="endDate">To (YYYY-MM-DD):</label> 
			<input type="text" name="endDate" required="required" size="10" maxlength="10"/> 
  			
			<input type="submit" name="submit1" value="Submit"/>
		</form>
		
		
		<p>Returns confirmed cases and deaths for the country between those dates</p>
		
		<form action="SearchOperations" method="get">
			<label for="countries">Countries:</label> 
			<select name="countries">
				<option value="United States">United States of America</option> 
				<option value="Mexico">Mexico</option> 
				<option value="Canada">Canada</option>
				<option value="United Kingdom">United Kingdom</option>
				<option value="Japan">Japan</option>
				<option value="United Arab Emirates">United Arab Emirates</option>
  			</select>
  			
  			<label for="startDate">From (YYYY-MM-DD):</label>
  			<input type="text" name="startDate" required="required" size="10" maxlength="10"/>	
  			 		
			<label for="endDate">To (YYYY-MM-DD):</label> 
			<input type="text" name="endDate" required="required" size="10" maxlength="10"/> 
  			
			<input type="submit" name="submit2" value="Submit"/>
		</form>
		
		
		
		<p>Returns total tests and population for a country</p>
		
		<form action="SearchOperations" method="get">
			<label for="countries">Countries:</label> 
			<select name="countries">
				<option value="United States">United States of America</option> 
				<option value="Mexico">Mexico</option> 
				<option value="Canada">Canada</option>
				<option value="United Kingdom">United Kingdom</option>
				<option value="Japan">Japan</option>
				<option value="United Arab Emirates">United Arab Emirates</option>
  			</select>
  			
			<input type="submit" name="submit3" value="Submit"/>
		</form>
		
		
		
		
		
		<p>Returns all countries with a health index that is less than the one chosen</p>
		
		<form action="SearchOperations" method="get">
			<label for="healthIndices">Health Indices:</label> 
			<select name="healthIndices">
				<option value="0.9">0.9</option> 
				<option value="0.8">0.8</option> 
				<option value="0.7">0.7</option>
				<option value="0.6">0.6</option>
				<option value="0.5">0.5</option>
  			</select>
  			
			<input type="submit" name="submit4" value="Submit"/>
		</form>
		
		
		
		
		<p>Returns a countries baseline fields</p>
		
		<form action="SearchOperations" method="get">
			<label for="countries">Countries:</label> 
			<select name="countries">
				<option value="United States">United States of America</option> 
				<option value="Mexico">Mexico</option> 
				<option value="Canada">Canada</option>
				<option value="United Kingdom">United Kingdom</option>
				<option value="Japan">Japan</option>
				<option value="United Arab Emirates">United Arab Emirates</option>
  			</select>
  			
			<input type="submit" name="submit5" value="Submit"/>
		</form>
		
		
		
		
		<p>Returns all countries with a population age above 65 percentage greater than the one chosen</p>
		
		<form action="SearchOperations" method="get">
			<label for="percents">Percents:</label> 
			<select name="percents">
				<option value="10.0">10%</option> 
				<option value="30.0">30%</option> 
				<option value="50.0">50%</option>
				<option value="70.0">70%</option>
				<option value="90.0">90%</option>
  			</select>
  			
			<input type="submit" name="submit6" value="Submit"/>
		</form>
		
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
		
		<p>Click here to see Worldwide Mobility Trends analytic</p>
		
		<form action="SearchOperations" method="get">
			<input type="submit" name="worldwideMobilityTrends" value="Submit"/>
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
		<form action="SearchOperations" method="get">
			<input type="submit" name="richPoor_testing" value="Compare Testing"/>
		</form>
		
		<p>Click here if you would like to import the previous version of the data</p>
		<form action="SearchOperations" method="get">
			<input type="submit" name="importData" value="Import Data"/>
		</form>
		
		
		
	</body>
</html>