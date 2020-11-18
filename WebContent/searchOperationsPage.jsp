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
		
		<title>COVID-19 Mobility Trends</title>
	</head>
	
	
	
	<body>
		<div class="navbar"><h1>COVID-19 Mobility Trends</h1></div>
		
		<!-- top buttons -->
		<div class="wrapper">
			<div class="row">
				<div class="column">
					<div class="column1">
						<div class= "input-icons">
							<form action="SearchOperations" method="get">
								<i class="fa fa-eye icon"></i>
								<input type="submit" name="casesVsDeaths" value="View cases vs. deaths analytic" class="topbuttons"/>
							</form>
						</div>
					</div>
				</div>
		
				<div class="column">
					<div class="column2">
						<div class="input-icons">
							<form action="SearchOperations" method="get">
								<i class="fa fa-globe" aria-hidden="true"></i>
								<input type="submit" name="richPoor_testing" value="Compare testing between first world and developing countries" class="topbuttons"/>
							</form>
						</div>
					</div>
				</div>
		
				<div class="column">
					<div class="column3">
						<div class = "input-icons">
							<form action="SearchOperations" method="get">
								<i class="fa fa-cloud-upload" aria-hidden="true"></i>
								<input type="submit" name="importData" value=" Import previous versions of data" class="topbuttons"/>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!--  end top buttons -->
		<div class="wrapper">
			<div class="row">
				<div class="column">
					<div class="leftycolumn">
						<div class="allcountries" style="width:380px; height:200px; text-align:center;">
							<p><span style="font-weight:500;">Returns all fields for the country between those dates:</span></p>	
			
							<form action="SearchOperations" method="get">
								<label for="countries">Countries: </label> 
								<select name="countries">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
				  				</select>
				  				
				  				<br><br>
				  			
				  				<label for="startDate">From (YYYY-MM-DD):</label>
				  				<input type="text" name="startDate" required="required" size="10" maxlength="10"/>	
				  				
				  				<br><br>
				  			 		
								<label for="endDate">To (YYYY-MM-DD):</label> 
								<input type="text" name="endDate" required="required" size="10" maxlength="10"/> 
				  			
				  				<br><br>
				  				
								<input type="submit" name="submit1" value="Submit" class="gobutton"/>
						</form>
						</div>
					
					
						<div class="allcountries" style="width:380px; height:120px; text-align:center;">
							<p><span style="font-weight:500;">Click here to see Mobility Trends analytic</span></p>
							
							<form action="SearchOperations" method="get">
								<select name="countries">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
					  			</select>
					  			
					  			<br><br>
					  			
					  			<input type="submit" name="mobilityTrends" value="Submit" class="gobutton"/>
							</form>
						</div>
					
						<div class="allcountries" style="width:380px; height:120px; text-align:center;">
							<p><span style="font-weight:500;">Returns total tests and population for a country</span></p>
							
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
					  			
					  			<br><br>
					  			
								<input type="submit" name="submit3" value="Submit" class="gobutton"/>
							</form>
						</div>
					
					
					
						<div class="allcountries" style="width:380px; height:140px; text-align:center;">
							<p><span style="font-weight:500;">Returns all countries with a health index that is less than the one chosen</span></p>
							
							<form action="SearchOperations" method="get">
								<label for="healthIndices">Health Indices:</label> 
								<select name="healthIndices">
									<option value="0.9">0.9</option> 
									<option value="0.8">0.8</option> 
									<option value="0.7">0.7</option>
									<option value="0.6">0.6</option>
									<option value="0.5">0.5</option>
					  			</select>
					  			
					  			<br><br>
					  			
								<input type="submit" name="submit4" value="Submit" class="gobutton"/>
							</form>
						</div>
					
					
						<div class="allcountries" style="width:380px; height:120px; text-align:center;">
							<p><span style="font-weight:500;">Returns a countries baseline fields</span></p>
							
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
					  			
					  			<br><br>
					  			
								<input type="submit" name="submit5" value="Submit" class="gobutton"/>
							</form>
						</div>
		
					</div>
				</div>

		<!-- right wrapper -->
				<div class="column">
					<div class="rightycolumn">
						<div class="allcountries" style="width:380px; height:140px; text-align:center;">
							<p><span style="font-weight:500;">Returns all countries with a population age above 65 percentage greater than the one chosen</span></p>
							
							<form action="SearchOperations" method="get">
								<label for="percents">Percents:</label> 
								<select name="percents">
									<option value="10.0">10%</option> 
									<option value="30.0">30%</option> 
									<option value="50.0">50%</option>
									<option value="70.0">70%</option>
									<option value="90.0">90%</option>
					  			</select>
					  			
					  			<br><br>
				
								<input type="submit" name="submit6" value="Submit" class="gobutton"/>
							</form>
						
						</div>
						
						<div class="allcountries" style="width:380px; height:220px; text-align:center;">
							<p><span style="font-weight:500;">Returns confirmed cases and deaths for the country between those dates:</span></p>
							
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
					  			
					  			<br><br>
					  			
					  			<label for="startDate">From (YYYY-MM-DD):</label>
					  			<input type="text" name="startDate" required="required" size="10" maxlength="10"/>	
					  			
					  			<br><br>
					  			 		
								<label for="endDate">To (YYYY-MM-DD):</label> 
								<input type="text" name="endDate" required="required" size="10" maxlength="10"/> 
								
								<br><br>
					  			
								<input type="submit" name="submit2" value="Submit" class="gobutton"/>
							</form>
						</div>
						
						
						<div class="allcountries" style="width:380px; height:140px; text-align:center;">
							<p><span style="font-weight:500;">Choose a Mobility Trend to compare against the cases in that country</span></p>
							
							<form action="SearchOperations" method="get">
								<select name="mobility">
									<option value="Grocery and Pharmacy">Grocery and Pharmacy</option> 
									<option value="Parks">Parks</option> 
									<option value="Residential">Residential</option>
									<option value="Retail and Recreations">Retail and Recreations</option>
									<option value="Transit Stations">Transit Stations</option>
									<option value="Workplaces">Workplaces</option>
					  			</select>
					  			<select name="countries">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
					  			</select>
					  			
					  			<br><br>
					  			
					  			<input type="submit" name="casesVsMobility" value="Submit" class="gobutton"/>
							</form>
						</div>
						
						
						<div class="allcountries" style="width:380px; height:120px; text-align:center;">
							<p><span style="font-weight:500;">Click here to see the country case vs death analytic</span></p>
							
							<form action="SearchOperations" method="get">
								<select name="countries">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
					  			</select>
					  			
					  			<br><br>
					  			
					  			<input type="submit" name="countryCasesVSDeaths" value="Submit" class="gobutton"/>
							</form>
						</div>
						
						
						<div class="allcountries" style="width:380px; height:150px; text-align:center;">
							<p><span style="font-weight:500;">Click here to see the differences between mobility trends for workplaces and public transportation in the listed countries based on the specific month. </span></p>
							
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
					  			
					  			<br><br>
					  			
								<input type="submit" name="multiGraph" value="Submit" class="gobutton"/>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
			
	</body>
</html>