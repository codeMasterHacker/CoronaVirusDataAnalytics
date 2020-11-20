<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>
		
		<!-- ICONS -->
		<link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
		<link rel="stylesheet" href= "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"> 
		
		<title>Edit Files</title>
	</head>
	
	<body>
		<h1>Edit Files</h1>
		
		<div class="wrapper">
			<div class="row">
				<div class="column">
					<div class="column1">
						<form action="SearchOperationsPage" method="get"> 
							<input type="submit" name="SearchOperationsPage" value="Go back to homepage" class="gobutton"/>
						</form>
					</div>
				</div>
			</div>
		</div>
		
		<div class="wrapper">
			<div class="row">
				<div class="column">
					<div class="leftycolumn">
						<div class="editfiles" style="width:550px; height:580px;">
							<p><center><span style="font-weight:500; font-size:13px;">Would you like to insert a new row?</span></center></p>
							
							<form action="EditFiles" method="post">
					  			<label for="iso">ISO:</label>
					  			<input type="text" name="iso" required="required" size="3" maxlength="5"/>	
					  			</br>
								<label for="country">Country:</label> 
								<input type="text" name="country" required="required" size="50" maxlength="60"/> 
								</br>
								<label for="date">Date:</label> 
								<input type="text" name="date" required="required" size="10" maxlength="10"/> 
								</br>
								<label for="groceryPharmacy_percentChange">Grocery and Pharmacy Percent Change from Baseline:</label> 
								<input type="text" name="groceryPharmacy_percentChange" required="required" size="7" maxlength="7"/> 
								</br>
								<label for="parks_percentChange">Parks Percent Change from Baseline:</label> 
								<input type="text" name="parks_percentChange" required="required" size="7" maxlength="7"/> 
								</br>
								<label for="residential_percentChange">Residential Percent Change from Baseline:</label> 
								<input type="text" name="residential_percentChange" required="required" size="7" maxlength="7"/> 
								</br>
								<label for="retailRec_percentChange">Retail and Recreation Percent Change from Baseline:</label> 
								<input type="text" name="retailRec_percentChange" required="required" size="7" maxlength="7"/> 
								</br>
								<label for="transitStations_percentChange">Transit Stations Percent Change from Baseline:</label> 
								<input type="text" name="transitStations_percentChange" required="required" size="7" maxlength="7"/>
								</br>
								<label for="workPlaces_percentChange">Work Places Percent Change from Baseline:</label> 
								<input type="text" name="workPlaces_percentChange" required="required" size="7" maxlength="7"/>
								</br>
								<label for="confirmedCases">Number of Confirmed Cases:</label> 
								<input type="text" name="confirmedCases" required="required" size="10" maxlength="10"/>
								</br>
								<label for="confirmedDeaths">Number of Confirmed Deaths:</label> 
								<input type="text" name="confirmedDeaths" required="required" size="10" maxlength="10"/>
								</br>
								<label for="govRes_stringIndex">Government Response Stringency Index:</label> 
								<input type="text" name="govRes_stringIndex" required="required" size="10" maxlength="10"/>
								</br>
								<label for="totalTests">Number of Total Tests:</label> 
								<input type="text" name="totalTests" required="required" size="10" maxlength="10"/>
								</br>
								<label for="gdpCapita">GPD per Capita:</label> 
								<input type="text" name="gdpCapita" required="required" size="14" maxlength="14"/>
								</br>
								<label for="population">Population:</label> 
								<input type="text" name="population" required="required" size="10" maxlength="10"/>
								</br>
								<label for="populationDensity">Population Density:</label> 
								<input type="text" name="populationDensity" required="required" size="7" maxlength="7"/>
								</br>
								<label for="humanDev_index">Human Development Index:</label> 
								<input type="text" name="humanDev_index" required="required" size="7" maxlength="7"/>
								</br>
								<label for="percentPop_above65">Percentage of Population Above the Age of 65:</label> 
								<input type="text" name="percentPop_above65" required="required" size="7" maxlength="7"/>
								</br>
								<label for="healthIndex">Health Index:</label> 
								<input type="text" name="healthIndex" required="required" size="7" maxlength="7"/>
					  			</br>
					  			<br><br>
								<center><input type="submit" name="submit1" value="Submit" class="gobutton"/></center>
							</form>
						</div>
					</div>
				</div>
		
		<div class="column">
					<div class="rightycolumn">
						<div class="editfiles" style="width:550px; height:580px;">
							<p><center><span style="font-weight:500; font-size:13px;">Would you like to update an existing row?</center></span></p>	
							
							<form action="EditFiles" method="post">
					  			<label for="iso">ISO:</label>
					  			<input type="text" name="iso" size="3" maxlength="5"/>	
					  			</br>	
								<label for="country">Country:</label> 
								<input type="text" name="country" required="required" size="50" maxlength="60"/> 
								</br>
								<label for="date">Date:</label> 
								<input type="text" name="date" required="required" size="10" maxlength="10"/> 
								</br>
								<label for="groceryPharmacy_percentChange">Grocery and Pharmacy Percent Change from Baseline:</label> 
								<input type="text" name="groceryPharmacy_percentChange" size="7" maxlength="7"/> 
								</br>
								<label for="parks_percentChange">Parks Percent Change from Baseline:</label> 
								<input type="text" name="parks_percentChange" size="7" maxlength="7"/> 
								</br>
								<label for="residential_percentChange">Residential Percent Change from Baseline:</label> 
								<input type="text" name="retailresidential_percentChangeRec_percentChange" size="7" maxlength="7"/> 
								</br>
								<label for="retailRec_percentChange">Retail and Recreation Percent Change from Baseline:</label> 
								<input type="text" name="retailRec_percentChange" size="7" maxlength="7"/> 
								</br>
								<label for="transitStations_percentChange">Transit Stations Percent Change from Baseline:</label> 
								<input type="text" name="retailRec_percentChange" size="7" maxlength="7"/>
								</br>
								<label for="workPlaces_percentChange">Work Places Percent Change from Baseline:</label> 
								<input type="text" name="workPlaces_percentChange" size="7" maxlength="7"/>
								</br>
								<label for="confirmedCases">Number of Confirmed Cases:</label> 
								<input type="text" name="confirmedCases" size="10" maxlength="10"/>
								</br>
								<label for="confirmedDeaths">Number of Confirmed Deaths:</label> 
								<input type="text" name="confirmedDeaths" size="10" maxlength="10"/>
								</br>
								<label for="govRes_stringIndex">Government Response Stringency Index:</label> 
								<input type="text" name="govRes_stringIndex" size="10" maxlength="10"/>
								</br>
								<label for="totalTests">Number of Total Tests:</label> 
								<input type="text" name="confirmedCases" size="10" maxlength="10"/>
								</br>
								<label for="gdpCapita">GPD per Capita:</label> 
								<input type="text" name="gdpCapita" size="14" maxlength="14"/>
								</br>
								<label for="population">Population:</label> 
								<input type="text" name="population" size="10" maxlength="10"/>
								</br>
								<label for="populationDensity">Population Density:</label> 
								<input type="text" name="populationDensity" size="7" maxlength="7"/>
								</br>
								<label for="humanDev_index">Human Development Index:</label> 
								<input type="text" name="humanDev_index" size="7" maxlength="7"/>
								</br>
								<label for="percentPop_above65">Percentage of Population Above the Age of 65:</label> 
								<input type="text" name="percentPop_above65" size="7" maxlength="7"/>
								</br>
								<label for="healthIndex">Health Index:</label> 
								<input type="text" name="perchealthIndexentPop_above65" size="7" maxlength="7"/>
					  			</br>
					  			<br><br>
								<center><input type="submit" name="submit2" value="Submit" class="gobutton"/></center>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="wrapper">
			<div class="row">
				<div class="column">
					<div class="leftycolumn">
						<div class="editfiles" style="width:550px; height:140px;">
							<p><center><span style="font-weight:500; font-size:13px;">Would you like to delete an existing row?</span></center></p>	
							
							<form action="EditFiles" method="post">
								<label for="country">Country:</label> 
								<input type="text" name="country" required="required" size="50" maxlength="60"/> 
								
								<label for="date">Date:</label> 
								<input type="text" name="date" required="required" size="10" maxlength="10"/> 
					  			<br><br>
					  			<center><input type="submit" name="submit3" value="Submit" class="gobutton"/></center>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</body>
</html>