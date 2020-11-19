<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Files Page</title>
	</head>
	
	<body>
		<h1>This is the Edit Files Page</h1>
		
		<p>Would you like to insert a new row?</p>
		
		<form action="EditServlet" method="post">
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
			<input type="submit" name="insert" value="Insert"/>
		</form>
		
		
		<p>Would you like to update an existing row?</p>	
		
		<form action="EditServlet" method="post">
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
			<input type="text" name="totalTests" size="10" maxlength="10"/>
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
			<input type="submit" name="update" value="Update"/>
		</form>
		
		
		
		<p>Would you like to delete an existing row?</p>	
		
		<form action="EditServlet" method="post">
			<label for="country">Country:</label> 
			<input type="text" name="country" required="required" size="50" maxlength="60"/> 
			</br>
			<label for="date">Date:</label> 
			<input type="text" name="date" required="required" size="10" maxlength="10"/> 
  			</br>
			<input type="submit" name="delete" value="Delete"/>
		</form>
		
		
	</body>
</html>