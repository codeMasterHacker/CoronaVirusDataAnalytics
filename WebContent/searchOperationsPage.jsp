<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		

		<!-- CSS -->
		<link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>

		<!--

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
		
		-->
		
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
								<i class="fa fa-eye icon" style="padding-top: 15px;"></i>
								<input type="submit" name="casesVsDeaths" value="View cases vs. deaths analytic" class="topbuttons"/>
							</form>
						</div>
					</div>
				</div>
		
				<div class="column">
					<div class="column2">
						<div class="input-icons">
							<form action="SearchOperations" method="get">
								<i class="fa fa-globe" aria-hidden="true" style="padding-top: 15px;"></i>
								<input type="submit" name="richPoor_testing" value="Compare testing between first world and developing countries" class="topbuttons"/>
							</form>
						</div>
					</div>
				</div>
		
				<div class="column">
					<div class="column3">
						<div class = "input-icons">
							<form action="SearchOperations" method="get">
								<i class="fa fa-cloud-upload" aria-hidden="true" style="padding-top: 15px;"></i>
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
							<p><span style="font-weight:500;">View all countries by date:</span></p>	
			
							<form action="SearchOperations" method="get">
								<label for="countries">Countries: </label> 
								<!-- 
								<select name="countries" style = "padding:0px;">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
				  				</select>
				  				-->
				  				<select name="countries" style = "padding:0px;">
									<option value="United Arab Emirates">United Arab Emirates</option>
									<option value="Afghanistan">Afghanistan</option>
									<option value="Antigua and Barbuda">Antigua and Barbuda</option>
									<option value="Angola">Angola</option>
									<option value="Argentina">Argentina</option>
									<option value="Austria">Austria</option>
									<option value="Australia">Australia</option>
									<option value="Aruba">Aruba</option>
									<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
									<option value="Barbados">Barbados</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Belgium">Belgium</option>
									<option value="Burkina Faso">Burkina Faso</option>
									<option value="Bulgaria">Bulgaria</option>
									<option value="Bahrain">Bahrain</option>
									<option value="Benin">Benin</option>
									<option value="Bolivia">Bolivia</option>
									<option value="Brazil">Brazil</option>
									<option value="Botswana">Botswana</option>
									<option value="Belarus">Belarus</option>
									<option value="Belize">Belize</option>
									<option value="Canada">Canada</option>
									<option value="Switzerland">Switzerland</option>
									<option value="Côte d'Ivoire">Côte d'Ivoire</option>
									<option value="Chile">Chile</option>
									<option value="Cameroon">Cameroon</option>
									<option value="Colombia">Colombia</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Cape Verde">Cape Verde</option>
									<option value="Czechia">Czechia</option>
									<option value="Germany">Germany</option>
									<option value="Denmark">Denmark</option>
									<option value="Dominican Republic">Dominican Republic</option>
									<option value="Ecuador">Ecuador</option>
									<option value="Estonia">Estonia</option>
									<option value="Egypt">Egypt</option>
									<option value="Spain">Spain</option>
									<option value="Finland">Finland</option>
									<option value="Fiji">Fiji</option>
									<option value="France">France</option>
									<option value="Gabon">Gabon</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Georgia">Georgia</option>
									<option value="Ghana">Ghana</option>
									<option value="Greece">Greece</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guinea-Bissau">Guinea-Bissau</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Honduras">Honduras</option>
									<option value="Croatia">Croatia</option>
									<option value="Haiti">Haiti</option>
									<option value="Hungary">Hungary</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Ireland">Ireland</option>
									<option value="Israel">Israel</option>
									<option value="India">India</option>
									<option value="Iraq">Iraq</option>
									<option value="Italy">Italy</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Jordan">Jordan</option>
									<option value="Japan">Japan</option>
									<option value="Kenya">Kenya</option>
									<option value="Kyrgyzstan">Kyrgyzstan</option>
									<option value="Cambodia">Cambodia</option>
									<option value="South Korea">South Korea</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Kazakhstan">Kazakhstan</option>
									<option value="Laos">Laos</option>
									<option value="Lebanon">Lebanon</option>
									<option value="Liechtenstein">Liechtenstein</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="Lithuania">Lithuania</option>
									<option value="Luxembourg">Luxembourg</option>
									<option value="Latvia">Latvia</option>
									<option value="Libya">Libya</option>
									<option value="Morocco">Morocco</option>
									<option value="Moldova">Moldova</option>
									<option value="North Macedonia">North Macedonia</option>
									<option value="Mali">Mali</option>
									<option value="Mongolia">Mongolia</option>
									<option value="Malta">Malta</option>
									<option value="Mauritius">Mauritius</option>
									<option value="Mexico">Mexico</option>
									<option value="Malaysia">Malaysia</option>
									<option value="Mozambique">Mozambique</option>
									<option value="Namibia">Namibia</option>
									<option value="Niger">Niger</option>
									<option value="Nigeria">Nigeria</option>
									<option value="Nicaragua">Nicaragua</option>
									<option value="Netherlands">Netherlands</option>
									<option value="Norway">Norway</option>
									<option value="Nepal">Nepal</option>
									<option value="New Zealand">New Zealand</option>
									<option value="Oman">Oman</option>
									<option value="Panama">Panama</option>
									<option value="Peru">Peru</option>
									<option value="Papua New Guinea">Papua New Guinea</option>
									<option value="Philippines">Philippines</option>
									<option value="Pakistan">Pakistan</option>
									<option value="Poland">Poland</option>
									<option value="Puerto Rico">Puerto Rico</option>
									<option value="Portugal">Portugal</option>
									<option value="Paraguay">Paraguay</option>
									<option value="Qatar">Qatar</option>
									<option value="Réunion">Réunion</option>
									<option value="Romania">Romania</option>
									<option value="Serbia">Serbia</option>
									<option value="Russia">Russia</option>
									<option value="Rwanda">Rwanda</option>
									<option value="Saudi Arabia">Saudi Arabia</option>
									<option value="Sweden">Sweden</option>
									<option value="Singapore">Singapore</option>
									<option value="Slovenia">Slovenia</option>
									<option value="Slovakia">Slovakia</option>
									<option value="Senegal">Senegal</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Togo">Togo</option>
									<option value="Thailand">Thailand</option>
									<option value="Tajikistan">Tajikistan</option>
									<option value="Turkey">Turkey</option>
									<option value="Trinidad and Tobago">Trinidad and Tobago</option>
									<option value="Taiwan">Taiwan</option>
									<option value="Tanzania">Tanzania</option>
									<option value="Ukraine">Ukraine</option>
									<option value="Uganda">Uganda</option>
									<option value="United States">United States</option>
									<option value="Uruguay">Uruguay</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Vietnam">Vietnam</option>
									<option value="Yemen">Yemen</option>
									<option value="South Africa">South Africa</option>
									<option value="Zambia">Zambia</option>
									<option value="Zimbabwe">Zimbabwe</option>
				  				</select>
				  				<br><br>
				  				<!--
				  				<label for="startDate">From (YYYY-MM-DD):</label>
				  				<input type="text" name="startDate" required="required" size="10" maxlength="10"/>	
				  				-->
				  				<label for="startDate">From:</label>
								<input type="date" name="startDate" required="required" value="2020-02-15" min="2020-02-15">
				  				<br><br>
				  			 	<!--
								<label for="endDate">To (YYYY-MM-DD):</label> 
								<input type="text" name="endDate" required="required" size="10" maxlength="10"/> 
				  				-->
				  				<label for="endDate">To:</label>
								<input type="date" name="endDate" required="required" value="2020-10-27" min="2020-02-15">
				  				<br><br>
				  				
								<input type="submit" name="submit1" value="Submit" class="gobutton"/>
						</form>
						</div>
					
					
						<div class="allcountries" style="width:380px; height:125px; text-align:center;">
							<p><span style="font-weight:500;">View mobility trends by country:</span></p>
							
							<form action="SearchOperations" method="get">
							<!--
								<select name="countries" style = "padding:0px;">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
					  			</select>
					  			-->
					  			<select name="countries" style = "padding:0px;">
									<option value="United Arab Emirates">United Arab Emirates</option>
									<option value="Afghanistan">Afghanistan</option>
									<option value="Antigua and Barbuda">Antigua and Barbuda</option>
									<option value="Angola">Angola</option>
									<option value="Argentina">Argentina</option>
									<option value="Austria">Austria</option>
									<option value="Australia">Australia</option>
									<option value="Aruba">Aruba</option>
									<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
									<option value="Barbados">Barbados</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Belgium">Belgium</option>
									<option value="Burkina Faso">Burkina Faso</option>
									<option value="Bulgaria">Bulgaria</option>
									<option value="Bahrain">Bahrain</option>
									<option value="Benin">Benin</option>
									<option value="Bolivia">Bolivia</option>
									<option value="Brazil">Brazil</option>
									<option value="Botswana">Botswana</option>
									<option value="Belarus">Belarus</option>
									<option value="Belize">Belize</option>
									<option value="Canada">Canada</option>
									<option value="Switzerland">Switzerland</option>
									<option value="Côte d'Ivoire">Côte d'Ivoire</option>
									<option value="Chile">Chile</option>
									<option value="Cameroon">Cameroon</option>
									<option value="Colombia">Colombia</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Cape Verde">Cape Verde</option>
									<option value="Czechia">Czechia</option>
									<option value="Germany">Germany</option>
									<option value="Denmark">Denmark</option>
									<option value="Dominican Republic">Dominican Republic</option>
									<option value="Ecuador">Ecuador</option>
									<option value="Estonia">Estonia</option>
									<option value="Egypt">Egypt</option>
									<option value="Spain">Spain</option>
									<option value="Finland">Finland</option>
									<option value="Fiji">Fiji</option>
									<option value="France">France</option>
									<option value="Gabon">Gabon</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Georgia">Georgia</option>
									<option value="Ghana">Ghana</option>
									<option value="Greece">Greece</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guinea-Bissau">Guinea-Bissau</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Honduras">Honduras</option>
									<option value="Croatia">Croatia</option>
									<option value="Haiti">Haiti</option>
									<option value="Hungary">Hungary</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Ireland">Ireland</option>
									<option value="Israel">Israel</option>
									<option value="India">India</option>
									<option value="Iraq">Iraq</option>
									<option value="Italy">Italy</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Jordan">Jordan</option>
									<option value="Japan">Japan</option>
									<option value="Kenya">Kenya</option>
									<option value="Kyrgyzstan">Kyrgyzstan</option>
									<option value="Cambodia">Cambodia</option>
									<option value="South Korea">South Korea</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Kazakhstan">Kazakhstan</option>
									<option value="Laos">Laos</option>
									<option value="Lebanon">Lebanon</option>
									<option value="Liechtenstein">Liechtenstein</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="Lithuania">Lithuania</option>
									<option value="Luxembourg">Luxembourg</option>
									<option value="Latvia">Latvia</option>
									<option value="Libya">Libya</option>
									<option value="Morocco">Morocco</option>
									<option value="Moldova">Moldova</option>
									<option value="North Macedonia">North Macedonia</option>
									<option value="Mali">Mali</option>
									<option value="Mongolia">Mongolia</option>
									<option value="Malta">Malta</option>
									<option value="Mauritius">Mauritius</option>
									<option value="Mexico">Mexico</option>
									<option value="Malaysia">Malaysia</option>
									<option value="Mozambique">Mozambique</option>
									<option value="Namibia">Namibia</option>
									<option value="Niger">Niger</option>
									<option value="Nigeria">Nigeria</option>
									<option value="Nicaragua">Nicaragua</option>
									<option value="Netherlands">Netherlands</option>
									<option value="Norway">Norway</option>
									<option value="Nepal">Nepal</option>
									<option value="New Zealand">New Zealand</option>
									<option value="Oman">Oman</option>
									<option value="Panama">Panama</option>
									<option value="Peru">Peru</option>
									<option value="Papua New Guinea">Papua New Guinea</option>
									<option value="Philippines">Philippines</option>
									<option value="Pakistan">Pakistan</option>
									<option value="Poland">Poland</option>
									<option value="Puerto Rico">Puerto Rico</option>
									<option value="Portugal">Portugal</option>
									<option value="Paraguay">Paraguay</option>
									<option value="Qatar">Qatar</option>
									<option value="Réunion">Réunion</option>
									<option value="Romania">Romania</option>
									<option value="Serbia">Serbia</option>
									<option value="Russia">Russia</option>
									<option value="Rwanda">Rwanda</option>
									<option value="Saudi Arabia">Saudi Arabia</option>
									<option value="Sweden">Sweden</option>
									<option value="Singapore">Singapore</option>
									<option value="Slovenia">Slovenia</option>
									<option value="Slovakia">Slovakia</option>
									<option value="Senegal">Senegal</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Togo">Togo</option>
									<option value="Thailand">Thailand</option>
									<option value="Tajikistan">Tajikistan</option>
									<option value="Turkey">Turkey</option>
									<option value="Trinidad and Tobago">Trinidad and Tobago</option>
									<option value="Taiwan">Taiwan</option>
									<option value="Tanzania">Tanzania</option>
									<option value="Ukraine">Ukraine</option>
									<option value="Uganda">Uganda</option>
									<option value="United States">United States</option>
									<option value="Uruguay">Uruguay</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Vietnam">Vietnam</option>
									<option value="Yemen">Yemen</option>
									<option value="South Africa">South Africa</option>
									<option value="Zambia">Zambia</option>
									<option value="Zimbabwe">Zimbabwe</option>
				  				</select>
					  			<br><br>
					  			
					  			<input type="submit" name="mobilityTrends" value="Submit" class="gobutton"/>
							</form>
						</div>
					
						<div class="allcountries" style="width:380px; height:125px; text-align:center;">
							<p><span style="font-weight:500;">View total tests and population by country:</span></p>
							
							<form action="SearchOperations" method="get">
								<label for="countries" style = "padding:0px;">Countries:</label> 
								<!--
								<select name="countries" style = "padding:0px;">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
					  			</select>
					  			-->
					  			<select name="countries" style = "padding:0px;">
									<option value="United Arab Emirates">United Arab Emirates</option>
									<option value="Afghanistan">Afghanistan</option>
									<option value="Antigua and Barbuda">Antigua and Barbuda</option>
									<option value="Angola">Angola</option>
									<option value="Argentina">Argentina</option>
									<option value="Austria">Austria</option>
									<option value="Australia">Australia</option>
									<option value="Aruba">Aruba</option>
									<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
									<option value="Barbados">Barbados</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Belgium">Belgium</option>
									<option value="Burkina Faso">Burkina Faso</option>
									<option value="Bulgaria">Bulgaria</option>
									<option value="Bahrain">Bahrain</option>
									<option value="Benin">Benin</option>
									<option value="Bolivia">Bolivia</option>
									<option value="Brazil">Brazil</option>
									<option value="Botswana">Botswana</option>
									<option value="Belarus">Belarus</option>
									<option value="Belize">Belize</option>
									<option value="Canada">Canada</option>
									<option value="Switzerland">Switzerland</option>
									<option value="Côte d'Ivoire">Côte d'Ivoire</option>
									<option value="Chile">Chile</option>
									<option value="Cameroon">Cameroon</option>
									<option value="Colombia">Colombia</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Cape Verde">Cape Verde</option>
									<option value="Czechia">Czechia</option>
									<option value="Germany">Germany</option>
									<option value="Denmark">Denmark</option>
									<option value="Dominican Republic">Dominican Republic</option>
									<option value="Ecuador">Ecuador</option>
									<option value="Estonia">Estonia</option>
									<option value="Egypt">Egypt</option>
									<option value="Spain">Spain</option>
									<option value="Finland">Finland</option>
									<option value="Fiji">Fiji</option>
									<option value="France">France</option>
									<option value="Gabon">Gabon</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Georgia">Georgia</option>
									<option value="Ghana">Ghana</option>
									<option value="Greece">Greece</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guinea-Bissau">Guinea-Bissau</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Honduras">Honduras</option>
									<option value="Croatia">Croatia</option>
									<option value="Haiti">Haiti</option>
									<option value="Hungary">Hungary</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Ireland">Ireland</option>
									<option value="Israel">Israel</option>
									<option value="India">India</option>
									<option value="Iraq">Iraq</option>
									<option value="Italy">Italy</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Jordan">Jordan</option>
									<option value="Japan">Japan</option>
									<option value="Kenya">Kenya</option>
									<option value="Kyrgyzstan">Kyrgyzstan</option>
									<option value="Cambodia">Cambodia</option>
									<option value="South Korea">South Korea</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Kazakhstan">Kazakhstan</option>
									<option value="Laos">Laos</option>
									<option value="Lebanon">Lebanon</option>
									<option value="Liechtenstein">Liechtenstein</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="Lithuania">Lithuania</option>
									<option value="Luxembourg">Luxembourg</option>
									<option value="Latvia">Latvia</option>
									<option value="Libya">Libya</option>
									<option value="Morocco">Morocco</option>
									<option value="Moldova">Moldova</option>
									<option value="North Macedonia">North Macedonia</option>
									<option value="Mali">Mali</option>
									<option value="Mongolia">Mongolia</option>
									<option value="Malta">Malta</option>
									<option value="Mauritius">Mauritius</option>
									<option value="Mexico">Mexico</option>
									<option value="Malaysia">Malaysia</option>
									<option value="Mozambique">Mozambique</option>
									<option value="Namibia">Namibia</option>
									<option value="Niger">Niger</option>
									<option value="Nigeria">Nigeria</option>
									<option value="Nicaragua">Nicaragua</option>
									<option value="Netherlands">Netherlands</option>
									<option value="Norway">Norway</option>
									<option value="Nepal">Nepal</option>
									<option value="New Zealand">New Zealand</option>
									<option value="Oman">Oman</option>
									<option value="Panama">Panama</option>
									<option value="Peru">Peru</option>
									<option value="Papua New Guinea">Papua New Guinea</option>
									<option value="Philippines">Philippines</option>
									<option value="Pakistan">Pakistan</option>
									<option value="Poland">Poland</option>
									<option value="Puerto Rico">Puerto Rico</option>
									<option value="Portugal">Portugal</option>
									<option value="Paraguay">Paraguay</option>
									<option value="Qatar">Qatar</option>
									<option value="Réunion">Réunion</option>
									<option value="Romania">Romania</option>
									<option value="Serbia">Serbia</option>
									<option value="Russia">Russia</option>
									<option value="Rwanda">Rwanda</option>
									<option value="Saudi Arabia">Saudi Arabia</option>
									<option value="Sweden">Sweden</option>
									<option value="Singapore">Singapore</option>
									<option value="Slovenia">Slovenia</option>
									<option value="Slovakia">Slovakia</option>
									<option value="Senegal">Senegal</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Togo">Togo</option>
									<option value="Thailand">Thailand</option>
									<option value="Tajikistan">Tajikistan</option>
									<option value="Turkey">Turkey</option>
									<option value="Trinidad and Tobago">Trinidad and Tobago</option>
									<option value="Taiwan">Taiwan</option>
									<option value="Tanzania">Tanzania</option>
									<option value="Ukraine">Ukraine</option>
									<option value="Uganda">Uganda</option>
									<option value="United States">United States</option>
									<option value="Uruguay">Uruguay</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Vietnam">Vietnam</option>
									<option value="Yemen">Yemen</option>
									<option value="South Africa">South Africa</option>
									<option value="Zambia">Zambia</option>
									<option value="Zimbabwe">Zimbabwe</option>
				  				</select>
					  			<br><br>
					  			
								<input type="submit" name="submit3" value="Submit" class="gobutton"/>
							</form>
						</div>
					
					
					
						<div class="allcountries" style="width:380px; height:125px; text-align:center;">
							<p><span style="font-weight:500;">View all countries with a health index less than the one chosen:</span></p>
							
							<form action="SearchOperations" method="get">
								<label for="healthIndices">Health Indices:</label> 
								<select name="healthIndices" style = "padding:0px;">
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
					
					
						<div class="allcountries" style="width:380px; height:125px; text-align:center;">
							<p><span style="font-weight:500;">View a country's baseline fields</span></p>
							
							<form action="SearchOperations" method="get">
								<label for="countries">Countries:</label> 
								<!--
								<select name="countries" style = "padding:0px;">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
					  			</select>
					  			-->
					  			<select name="countries" style = "padding:0px;">
									<option value="United Arab Emirates">United Arab Emirates</option>
									<option value="Afghanistan">Afghanistan</option>
									<option value="Antigua and Barbuda">Antigua and Barbuda</option>
									<option value="Angola">Angola</option>
									<option value="Argentina">Argentina</option>
									<option value="Austria">Austria</option>
									<option value="Australia">Australia</option>
									<option value="Aruba">Aruba</option>
									<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
									<option value="Barbados">Barbados</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Belgium">Belgium</option>
									<option value="Burkina Faso">Burkina Faso</option>
									<option value="Bulgaria">Bulgaria</option>
									<option value="Bahrain">Bahrain</option>
									<option value="Benin">Benin</option>
									<option value="Bolivia">Bolivia</option>
									<option value="Brazil">Brazil</option>
									<option value="Botswana">Botswana</option>
									<option value="Belarus">Belarus</option>
									<option value="Belize">Belize</option>
									<option value="Canada">Canada</option>
									<option value="Switzerland">Switzerland</option>
									<option value="Côte d'Ivoire">Côte d'Ivoire</option>
									<option value="Chile">Chile</option>
									<option value="Cameroon">Cameroon</option>
									<option value="Colombia">Colombia</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Cape Verde">Cape Verde</option>
									<option value="Czechia">Czechia</option>
									<option value="Germany">Germany</option>
									<option value="Denmark">Denmark</option>
									<option value="Dominican Republic">Dominican Republic</option>
									<option value="Ecuador">Ecuador</option>
									<option value="Estonia">Estonia</option>
									<option value="Egypt">Egypt</option>
									<option value="Spain">Spain</option>
									<option value="Finland">Finland</option>
									<option value="Fiji">Fiji</option>
									<option value="France">France</option>
									<option value="Gabon">Gabon</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Georgia">Georgia</option>
									<option value="Ghana">Ghana</option>
									<option value="Greece">Greece</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guinea-Bissau">Guinea-Bissau</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Honduras">Honduras</option>
									<option value="Croatia">Croatia</option>
									<option value="Haiti">Haiti</option>
									<option value="Hungary">Hungary</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Ireland">Ireland</option>
									<option value="Israel">Israel</option>
									<option value="India">India</option>
									<option value="Iraq">Iraq</option>
									<option value="Italy">Italy</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Jordan">Jordan</option>
									<option value="Japan">Japan</option>
									<option value="Kenya">Kenya</option>
									<option value="Kyrgyzstan">Kyrgyzstan</option>
									<option value="Cambodia">Cambodia</option>
									<option value="South Korea">South Korea</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Kazakhstan">Kazakhstan</option>
									<option value="Laos">Laos</option>
									<option value="Lebanon">Lebanon</option>
									<option value="Liechtenstein">Liechtenstein</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="Lithuania">Lithuania</option>
									<option value="Luxembourg">Luxembourg</option>
									<option value="Latvia">Latvia</option>
									<option value="Libya">Libya</option>
									<option value="Morocco">Morocco</option>
									<option value="Moldova">Moldova</option>
									<option value="North Macedonia">North Macedonia</option>
									<option value="Mali">Mali</option>
									<option value="Mongolia">Mongolia</option>
									<option value="Malta">Malta</option>
									<option value="Mauritius">Mauritius</option>
									<option value="Mexico">Mexico</option>
									<option value="Malaysia">Malaysia</option>
									<option value="Mozambique">Mozambique</option>
									<option value="Namibia">Namibia</option>
									<option value="Niger">Niger</option>
									<option value="Nigeria">Nigeria</option>
									<option value="Nicaragua">Nicaragua</option>
									<option value="Netherlands">Netherlands</option>
									<option value="Norway">Norway</option>
									<option value="Nepal">Nepal</option>
									<option value="New Zealand">New Zealand</option>
									<option value="Oman">Oman</option>
									<option value="Panama">Panama</option>
									<option value="Peru">Peru</option>
									<option value="Papua New Guinea">Papua New Guinea</option>
									<option value="Philippines">Philippines</option>
									<option value="Pakistan">Pakistan</option>
									<option value="Poland">Poland</option>
									<option value="Puerto Rico">Puerto Rico</option>
									<option value="Portugal">Portugal</option>
									<option value="Paraguay">Paraguay</option>
									<option value="Qatar">Qatar</option>
									<option value="Réunion">Réunion</option>
									<option value="Romania">Romania</option>
									<option value="Serbia">Serbia</option>
									<option value="Russia">Russia</option>
									<option value="Rwanda">Rwanda</option>
									<option value="Saudi Arabia">Saudi Arabia</option>
									<option value="Sweden">Sweden</option>
									<option value="Singapore">Singapore</option>
									<option value="Slovenia">Slovenia</option>
									<option value="Slovakia">Slovakia</option>
									<option value="Senegal">Senegal</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Togo">Togo</option>
									<option value="Thailand">Thailand</option>
									<option value="Tajikistan">Tajikistan</option>
									<option value="Turkey">Turkey</option>
									<option value="Trinidad and Tobago">Trinidad and Tobago</option>
									<option value="Taiwan">Taiwan</option>
									<option value="Tanzania">Tanzania</option>
									<option value="Ukraine">Ukraine</option>
									<option value="Uganda">Uganda</option>
									<option value="United States">United States</option>
									<option value="Uruguay">Uruguay</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Vietnam">Vietnam</option>
									<option value="Yemen">Yemen</option>
									<option value="South Africa">South Africa</option>
									<option value="Zambia">Zambia</option>
									<option value="Zimbabwe">Zimbabwe</option>
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
							<p><span style="font-weight:500;">View all countries with a population percentage (of ages 65+) greater than the one chosen:</span></p>
							
							<form action="SearchOperations" method="get">
								<label for="percents">Percentages:</label> 
								<select name="percents" style = "padding:0px;">
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
							<p><span style="font-weight:500;">View confirmed cases and deaths for the country by date range:</span></p>
							
							<form action="SearchOperations" method="get">
								<label for="countries">Countries:</label> 
								<!--
								<select name="countries" style = "padding:0px;">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
					  			</select>
					  			-->
					  			<select name="countries" style = "padding:0px;">
									<option value="United Arab Emirates">United Arab Emirates</option>
									<option value="Afghanistan">Afghanistan</option>
									<option value="Antigua and Barbuda">Antigua and Barbuda</option>
									<option value="Angola">Angola</option>
									<option value="Argentina">Argentina</option>
									<option value="Austria">Austria</option>
									<option value="Australia">Australia</option>
									<option value="Aruba">Aruba</option>
									<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
									<option value="Barbados">Barbados</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Belgium">Belgium</option>
									<option value="Burkina Faso">Burkina Faso</option>
									<option value="Bulgaria">Bulgaria</option>
									<option value="Bahrain">Bahrain</option>
									<option value="Benin">Benin</option>
									<option value="Bolivia">Bolivia</option>
									<option value="Brazil">Brazil</option>
									<option value="Botswana">Botswana</option>
									<option value="Belarus">Belarus</option>
									<option value="Belize">Belize</option>
									<option value="Canada">Canada</option>
									<option value="Switzerland">Switzerland</option>
									<option value="Côte d'Ivoire">Côte d'Ivoire</option>
									<option value="Chile">Chile</option>
									<option value="Cameroon">Cameroon</option>
									<option value="Colombia">Colombia</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Cape Verde">Cape Verde</option>
									<option value="Czechia">Czechia</option>
									<option value="Germany">Germany</option>
									<option value="Denmark">Denmark</option>
									<option value="Dominican Republic">Dominican Republic</option>
									<option value="Ecuador">Ecuador</option>
									<option value="Estonia">Estonia</option>
									<option value="Egypt">Egypt</option>
									<option value="Spain">Spain</option>
									<option value="Finland">Finland</option>
									<option value="Fiji">Fiji</option>
									<option value="France">France</option>
									<option value="Gabon">Gabon</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Georgia">Georgia</option>
									<option value="Ghana">Ghana</option>
									<option value="Greece">Greece</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guinea-Bissau">Guinea-Bissau</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Honduras">Honduras</option>
									<option value="Croatia">Croatia</option>
									<option value="Haiti">Haiti</option>
									<option value="Hungary">Hungary</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Ireland">Ireland</option>
									<option value="Israel">Israel</option>
									<option value="India">India</option>
									<option value="Iraq">Iraq</option>
									<option value="Italy">Italy</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Jordan">Jordan</option>
									<option value="Japan">Japan</option>
									<option value="Kenya">Kenya</option>
									<option value="Kyrgyzstan">Kyrgyzstan</option>
									<option value="Cambodia">Cambodia</option>
									<option value="South Korea">South Korea</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Kazakhstan">Kazakhstan</option>
									<option value="Laos">Laos</option>
									<option value="Lebanon">Lebanon</option>
									<option value="Liechtenstein">Liechtenstein</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="Lithuania">Lithuania</option>
									<option value="Luxembourg">Luxembourg</option>
									<option value="Latvia">Latvia</option>
									<option value="Libya">Libya</option>
									<option value="Morocco">Morocco</option>
									<option value="Moldova">Moldova</option>
									<option value="North Macedonia">North Macedonia</option>
									<option value="Mali">Mali</option>
									<option value="Mongolia">Mongolia</option>
									<option value="Malta">Malta</option>
									<option value="Mauritius">Mauritius</option>
									<option value="Mexico">Mexico</option>
									<option value="Malaysia">Malaysia</option>
									<option value="Mozambique">Mozambique</option>
									<option value="Namibia">Namibia</option>
									<option value="Niger">Niger</option>
									<option value="Nigeria">Nigeria</option>
									<option value="Nicaragua">Nicaragua</option>
									<option value="Netherlands">Netherlands</option>
									<option value="Norway">Norway</option>
									<option value="Nepal">Nepal</option>
									<option value="New Zealand">New Zealand</option>
									<option value="Oman">Oman</option>
									<option value="Panama">Panama</option>
									<option value="Peru">Peru</option>
									<option value="Papua New Guinea">Papua New Guinea</option>
									<option value="Philippines">Philippines</option>
									<option value="Pakistan">Pakistan</option>
									<option value="Poland">Poland</option>
									<option value="Puerto Rico">Puerto Rico</option>
									<option value="Portugal">Portugal</option>
									<option value="Paraguay">Paraguay</option>
									<option value="Qatar">Qatar</option>
									<option value="Réunion">Réunion</option>
									<option value="Romania">Romania</option>
									<option value="Serbia">Serbia</option>
									<option value="Russia">Russia</option>
									<option value="Rwanda">Rwanda</option>
									<option value="Saudi Arabia">Saudi Arabia</option>
									<option value="Sweden">Sweden</option>
									<option value="Singapore">Singapore</option>
									<option value="Slovenia">Slovenia</option>
									<option value="Slovakia">Slovakia</option>
									<option value="Senegal">Senegal</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Togo">Togo</option>
									<option value="Thailand">Thailand</option>
									<option value="Tajikistan">Tajikistan</option>
									<option value="Turkey">Turkey</option>
									<option value="Trinidad and Tobago">Trinidad and Tobago</option>
									<option value="Taiwan">Taiwan</option>
									<option value="Tanzania">Tanzania</option>
									<option value="Ukraine">Ukraine</option>
									<option value="Uganda">Uganda</option>
									<option value="United States">United States</option>
									<option value="Uruguay">Uruguay</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Vietnam">Vietnam</option>
									<option value="Yemen">Yemen</option>
									<option value="South Africa">South Africa</option>
									<option value="Zambia">Zambia</option>
									<option value="Zimbabwe">Zimbabwe</option>
				  				</select>
					  			<br><br>
					  			
					  			<label for="startDate">From:</label>
								<input type="date" name="startDate" required="required" value="2020-02-15" min="2020-02-15">
					  			
					  			<br><br>
								
								<label for="endDate">To:</label>
								<input type="date" name="endDate" required="required" value="2020-10-27" min="2020-02-15">
								
								<br><br>
					  			
								<input type="submit" name="submit2" value="Submit" class="gobutton"/>
							</form>
						</div>
						
						
						<div class="allcountries" style="width:380px; height:120px; text-align:center;">
							<p><span style="font-weight:500;">Compare a mobility trend to the number of cases in a country:</span></p>
							
							<form action="SearchOperations" method="get">
								<select name="mobility" style = "padding:0px;">
									<option value="Grocery and Pharmacy">Grocery and Pharmacy</option> 
									<option value="Parks">Parks</option> 
									<option value="Residential">Residential</option>
									<option value="Retail and Recreations">Retail and Recreations</option>
									<option value="Transit Stations">Transit Stations</option>
									<option value="Workplaces">Workplaces</option>
					  			</select>
					  			<!--
					  			<select name="countries" style = "padding:0px;">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
					  			</select>
					  			-->
					  			<select name="countries" style = "padding:0px;">
									<option value="United Arab Emirates">United Arab Emirates</option>
									<option value="Afghanistan">Afghanistan</option>
									<option value="Antigua and Barbuda">Antigua and Barbuda</option>
									<option value="Angola">Angola</option>
									<option value="Argentina">Argentina</option>
									<option value="Austria">Austria</option>
									<option value="Australia">Australia</option>
									<option value="Aruba">Aruba</option>
									<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
									<option value="Barbados">Barbados</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Belgium">Belgium</option>
									<option value="Burkina Faso">Burkina Faso</option>
									<option value="Bulgaria">Bulgaria</option>
									<option value="Bahrain">Bahrain</option>
									<option value="Benin">Benin</option>
									<option value="Bolivia">Bolivia</option>
									<option value="Brazil">Brazil</option>
									<option value="Botswana">Botswana</option>
									<option value="Belarus">Belarus</option>
									<option value="Belize">Belize</option>
									<option value="Canada">Canada</option>
									<option value="Switzerland">Switzerland</option>
									<option value="Côte d'Ivoire">Côte d'Ivoire</option>
									<option value="Chile">Chile</option>
									<option value="Cameroon">Cameroon</option>
									<option value="Colombia">Colombia</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Cape Verde">Cape Verde</option>
									<option value="Czechia">Czechia</option>
									<option value="Germany">Germany</option>
									<option value="Denmark">Denmark</option>
									<option value="Dominican Republic">Dominican Republic</option>
									<option value="Ecuador">Ecuador</option>
									<option value="Estonia">Estonia</option>
									<option value="Egypt">Egypt</option>
									<option value="Spain">Spain</option>
									<option value="Finland">Finland</option>
									<option value="Fiji">Fiji</option>
									<option value="France">France</option>
									<option value="Gabon">Gabon</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Georgia">Georgia</option>
									<option value="Ghana">Ghana</option>
									<option value="Greece">Greece</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guinea-Bissau">Guinea-Bissau</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Honduras">Honduras</option>
									<option value="Croatia">Croatia</option>
									<option value="Haiti">Haiti</option>
									<option value="Hungary">Hungary</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Ireland">Ireland</option>
									<option value="Israel">Israel</option>
									<option value="India">India</option>
									<option value="Iraq">Iraq</option>
									<option value="Italy">Italy</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Jordan">Jordan</option>
									<option value="Japan">Japan</option>
									<option value="Kenya">Kenya</option>
									<option value="Kyrgyzstan">Kyrgyzstan</option>
									<option value="Cambodia">Cambodia</option>
									<option value="South Korea">South Korea</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Kazakhstan">Kazakhstan</option>
									<option value="Laos">Laos</option>
									<option value="Lebanon">Lebanon</option>
									<option value="Liechtenstein">Liechtenstein</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="Lithuania">Lithuania</option>
									<option value="Luxembourg">Luxembourg</option>
									<option value="Latvia">Latvia</option>
									<option value="Libya">Libya</option>
									<option value="Morocco">Morocco</option>
									<option value="Moldova">Moldova</option>
									<option value="North Macedonia">North Macedonia</option>
									<option value="Mali">Mali</option>
									<option value="Mongolia">Mongolia</option>
									<option value="Malta">Malta</option>
									<option value="Mauritius">Mauritius</option>
									<option value="Mexico">Mexico</option>
									<option value="Malaysia">Malaysia</option>
									<option value="Mozambique">Mozambique</option>
									<option value="Namibia">Namibia</option>
									<option value="Niger">Niger</option>
									<option value="Nigeria">Nigeria</option>
									<option value="Nicaragua">Nicaragua</option>
									<option value="Netherlands">Netherlands</option>
									<option value="Norway">Norway</option>
									<option value="Nepal">Nepal</option>
									<option value="New Zealand">New Zealand</option>
									<option value="Oman">Oman</option>
									<option value="Panama">Panama</option>
									<option value="Peru">Peru</option>
									<option value="Papua New Guinea">Papua New Guinea</option>
									<option value="Philippines">Philippines</option>
									<option value="Pakistan">Pakistan</option>
									<option value="Poland">Poland</option>
									<option value="Puerto Rico">Puerto Rico</option>
									<option value="Portugal">Portugal</option>
									<option value="Paraguay">Paraguay</option>
									<option value="Qatar">Qatar</option>
									<option value="Réunion">Réunion</option>
									<option value="Romania">Romania</option>
									<option value="Serbia">Serbia</option>
									<option value="Russia">Russia</option>
									<option value="Rwanda">Rwanda</option>
									<option value="Saudi Arabia">Saudi Arabia</option>
									<option value="Sweden">Sweden</option>
									<option value="Singapore">Singapore</option>
									<option value="Slovenia">Slovenia</option>
									<option value="Slovakia">Slovakia</option>
									<option value="Senegal">Senegal</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Togo">Togo</option>
									<option value="Thailand">Thailand</option>
									<option value="Tajikistan">Tajikistan</option>
									<option value="Turkey">Turkey</option>
									<option value="Trinidad and Tobago">Trinidad and Tobago</option>
									<option value="Taiwan">Taiwan</option>
									<option value="Tanzania">Tanzania</option>
									<option value="Ukraine">Ukraine</option>
									<option value="Uganda">Uganda</option>
									<option value="United States">United States</option>
									<option value="Uruguay">Uruguay</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Vietnam">Vietnam</option>
									<option value="Yemen">Yemen</option>
									<option value="South Africa">South Africa</option>
									<option value="Zambia">Zambia</option>
									<option value="Zimbabwe">Zimbabwe</option>
				  				</select>
					  			<br><br>
					  			
					  			<input type="submit" name="casesVsMobility" value="Submit" class="gobutton"/>
							</form>
						</div>
						
						
						<div class="allcountries" style="width:380px; height:120px; text-align:center;">
							<p><span style="font-weight:500;">View number of cases vs. deaths by country:</span></p>
							
							<form action="SearchOperations" method="get">
							<!--
								<select name="countries" style = "padding:0px;">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
					  			</select>
					  			-->
					  			<select name="countries" style = "padding:0px;">
									<option value="United Arab Emirates">United Arab Emirates</option>
									<option value="Afghanistan">Afghanistan</option>
									<option value="Antigua and Barbuda">Antigua and Barbuda</option>
									<option value="Angola">Angola</option>
									<option value="Argentina">Argentina</option>
									<option value="Austria">Austria</option>
									<option value="Australia">Australia</option>
									<option value="Aruba">Aruba</option>
									<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
									<option value="Barbados">Barbados</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Belgium">Belgium</option>
									<option value="Burkina Faso">Burkina Faso</option>
									<option value="Bulgaria">Bulgaria</option>
									<option value="Bahrain">Bahrain</option>
									<option value="Benin">Benin</option>
									<option value="Bolivia">Bolivia</option>
									<option value="Brazil">Brazil</option>
									<option value="Botswana">Botswana</option>
									<option value="Belarus">Belarus</option>
									<option value="Belize">Belize</option>
									<option value="Canada">Canada</option>
									<option value="Switzerland">Switzerland</option>
									<option value="Côte d'Ivoire">Côte d'Ivoire</option>
									<option value="Chile">Chile</option>
									<option value="Cameroon">Cameroon</option>
									<option value="Colombia">Colombia</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Cape Verde">Cape Verde</option>
									<option value="Czechia">Czechia</option>
									<option value="Germany">Germany</option>
									<option value="Denmark">Denmark</option>
									<option value="Dominican Republic">Dominican Republic</option>
									<option value="Ecuador">Ecuador</option>
									<option value="Estonia">Estonia</option>
									<option value="Egypt">Egypt</option>
									<option value="Spain">Spain</option>
									<option value="Finland">Finland</option>
									<option value="Fiji">Fiji</option>
									<option value="France">France</option>
									<option value="Gabon">Gabon</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Georgia">Georgia</option>
									<option value="Ghana">Ghana</option>
									<option value="Greece">Greece</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guinea-Bissau">Guinea-Bissau</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Honduras">Honduras</option>
									<option value="Croatia">Croatia</option>
									<option value="Haiti">Haiti</option>
									<option value="Hungary">Hungary</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Ireland">Ireland</option>
									<option value="Israel">Israel</option>
									<option value="India">India</option>
									<option value="Iraq">Iraq</option>
									<option value="Italy">Italy</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Jordan">Jordan</option>
									<option value="Japan">Japan</option>
									<option value="Kenya">Kenya</option>
									<option value="Kyrgyzstan">Kyrgyzstan</option>
									<option value="Cambodia">Cambodia</option>
									<option value="South Korea">South Korea</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Kazakhstan">Kazakhstan</option>
									<option value="Laos">Laos</option>
									<option value="Lebanon">Lebanon</option>
									<option value="Liechtenstein">Liechtenstein</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="Lithuania">Lithuania</option>
									<option value="Luxembourg">Luxembourg</option>
									<option value="Latvia">Latvia</option>
									<option value="Libya">Libya</option>
									<option value="Morocco">Morocco</option>
									<option value="Moldova">Moldova</option>
									<option value="North Macedonia">North Macedonia</option>
									<option value="Mali">Mali</option>
									<option value="Mongolia">Mongolia</option>
									<option value="Malta">Malta</option>
									<option value="Mauritius">Mauritius</option>
									<option value="Mexico">Mexico</option>
									<option value="Malaysia">Malaysia</option>
									<option value="Mozambique">Mozambique</option>
									<option value="Namibia">Namibia</option>
									<option value="Niger">Niger</option>
									<option value="Nigeria">Nigeria</option>
									<option value="Nicaragua">Nicaragua</option>
									<option value="Netherlands">Netherlands</option>
									<option value="Norway">Norway</option>
									<option value="Nepal">Nepal</option>
									<option value="New Zealand">New Zealand</option>
									<option value="Oman">Oman</option>
									<option value="Panama">Panama</option>
									<option value="Peru">Peru</option>
									<option value="Papua New Guinea">Papua New Guinea</option>
									<option value="Philippines">Philippines</option>
									<option value="Pakistan">Pakistan</option>
									<option value="Poland">Poland</option>
									<option value="Puerto Rico">Puerto Rico</option>
									<option value="Portugal">Portugal</option>
									<option value="Paraguay">Paraguay</option>
									<option value="Qatar">Qatar</option>
									<option value="Réunion">Réunion</option>
									<option value="Romania">Romania</option>
									<option value="Serbia">Serbia</option>
									<option value="Russia">Russia</option>
									<option value="Rwanda">Rwanda</option>
									<option value="Saudi Arabia">Saudi Arabia</option>
									<option value="Sweden">Sweden</option>
									<option value="Singapore">Singapore</option>
									<option value="Slovenia">Slovenia</option>
									<option value="Slovakia">Slovakia</option>
									<option value="Senegal">Senegal</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Togo">Togo</option>
									<option value="Thailand">Thailand</option>
									<option value="Tajikistan">Tajikistan</option>
									<option value="Turkey">Turkey</option>
									<option value="Trinidad and Tobago">Trinidad and Tobago</option>
									<option value="Taiwan">Taiwan</option>
									<option value="Tanzania">Tanzania</option>
									<option value="Ukraine">Ukraine</option>
									<option value="Uganda">Uganda</option>
									<option value="United States">United States</option>
									<option value="Uruguay">Uruguay</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Vietnam">Vietnam</option>
									<option value="Yemen">Yemen</option>
									<option value="South Africa">South Africa</option>
									<option value="Zambia">Zambia</option>
									<option value="Zimbabwe">Zimbabwe</option>
				  				</select>
					  			<br><br>
					  			
					  			<input type="submit" name="countryCasesVSDeaths" value="Submit" class="gobutton"/>
							</form>
						</div>
						
						
						<div class="allcountries" style="width:380px; height:140px; text-align:center;">
							<p><span style="font-weight:500;">View the differences between mobility trends for work places and public transportation in listed countries by month: </span></p>
							
							<form action="SearchOperations" method="get">
							<!--
								<select name="countries" style = "padding:0px;">
									<option value="United States">United States of America</option> 
									<option value="Mexico">Mexico</option> 
									<option value="Canada">Canada</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Japan">Japan</option>
									<option value="United Arab Emirates">United Arab Emirates</option>
					  			</select>
					  			-->
					  			<select name="countries" style = "padding:0px;">
									<option value="United Arab Emirates">United Arab Emirates</option>
									<option value="Afghanistan">Afghanistan</option>
									<option value="Antigua and Barbuda">Antigua and Barbuda</option>
									<option value="Angola">Angola</option>
									<option value="Argentina">Argentina</option>
									<option value="Austria">Austria</option>
									<option value="Australia">Australia</option>
									<option value="Aruba">Aruba</option>
									<option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
									<option value="Barbados">Barbados</option>
									<option value="Bangladesh">Bangladesh</option>
									<option value="Belgium">Belgium</option>
									<option value="Burkina Faso">Burkina Faso</option>
									<option value="Bulgaria">Bulgaria</option>
									<option value="Bahrain">Bahrain</option>
									<option value="Benin">Benin</option>
									<option value="Bolivia">Bolivia</option>
									<option value="Brazil">Brazil</option>
									<option value="Botswana">Botswana</option>
									<option value="Belarus">Belarus</option>
									<option value="Belize">Belize</option>
									<option value="Canada">Canada</option>
									<option value="Switzerland">Switzerland</option>
									<option value="Côte d'Ivoire">Côte d'Ivoire</option>
									<option value="Chile">Chile</option>
									<option value="Cameroon">Cameroon</option>
									<option value="Colombia">Colombia</option>
									<option value="Costa Rica">Costa Rica</option>
									<option value="Cape Verde">Cape Verde</option>
									<option value="Czechia">Czechia</option>
									<option value="Germany">Germany</option>
									<option value="Denmark">Denmark</option>
									<option value="Dominican Republic">Dominican Republic</option>
									<option value="Ecuador">Ecuador</option>
									<option value="Estonia">Estonia</option>
									<option value="Egypt">Egypt</option>
									<option value="Spain">Spain</option>
									<option value="Finland">Finland</option>
									<option value="Fiji">Fiji</option>
									<option value="France">France</option>
									<option value="Gabon">Gabon</option>
									<option value="United Kingdom">United Kingdom</option>
									<option value="Georgia">Georgia</option>
									<option value="Ghana">Ghana</option>
									<option value="Greece">Greece</option>
									<option value="Guatemala">Guatemala</option>
									<option value="Guinea-Bissau">Guinea-Bissau</option>
									<option value="Hong Kong">Hong Kong</option>
									<option value="Honduras">Honduras</option>
									<option value="Croatia">Croatia</option>
									<option value="Haiti">Haiti</option>
									<option value="Hungary">Hungary</option>
									<option value="Indonesia">Indonesia</option>
									<option value="Ireland">Ireland</option>
									<option value="Israel">Israel</option>
									<option value="India">India</option>
									<option value="Iraq">Iraq</option>
									<option value="Italy">Italy</option>
									<option value="Jamaica">Jamaica</option>
									<option value="Jordan">Jordan</option>
									<option value="Japan">Japan</option>
									<option value="Kenya">Kenya</option>
									<option value="Kyrgyzstan">Kyrgyzstan</option>
									<option value="Cambodia">Cambodia</option>
									<option value="South Korea">South Korea</option>
									<option value="Kuwait">Kuwait</option>
									<option value="Kazakhstan">Kazakhstan</option>
									<option value="Laos">Laos</option>
									<option value="Lebanon">Lebanon</option>
									<option value="Liechtenstein">Liechtenstein</option>
									<option value="Sri Lanka">Sri Lanka</option>
									<option value="Lithuania">Lithuania</option>
									<option value="Luxembourg">Luxembourg</option>
									<option value="Latvia">Latvia</option>
									<option value="Libya">Libya</option>
									<option value="Morocco">Morocco</option>
									<option value="Moldova">Moldova</option>
									<option value="North Macedonia">North Macedonia</option>
									<option value="Mali">Mali</option>
									<option value="Mongolia">Mongolia</option>
									<option value="Malta">Malta</option>
									<option value="Mauritius">Mauritius</option>
									<option value="Mexico">Mexico</option>
									<option value="Malaysia">Malaysia</option>
									<option value="Mozambique">Mozambique</option>
									<option value="Namibia">Namibia</option>
									<option value="Niger">Niger</option>
									<option value="Nigeria">Nigeria</option>
									<option value="Nicaragua">Nicaragua</option>
									<option value="Netherlands">Netherlands</option>
									<option value="Norway">Norway</option>
									<option value="Nepal">Nepal</option>
									<option value="New Zealand">New Zealand</option>
									<option value="Oman">Oman</option>
									<option value="Panama">Panama</option>
									<option value="Peru">Peru</option>
									<option value="Papua New Guinea">Papua New Guinea</option>
									<option value="Philippines">Philippines</option>
									<option value="Pakistan">Pakistan</option>
									<option value="Poland">Poland</option>
									<option value="Puerto Rico">Puerto Rico</option>
									<option value="Portugal">Portugal</option>
									<option value="Paraguay">Paraguay</option>
									<option value="Qatar">Qatar</option>
									<option value="Réunion">Réunion</option>
									<option value="Romania">Romania</option>
									<option value="Serbia">Serbia</option>
									<option value="Russia">Russia</option>
									<option value="Rwanda">Rwanda</option>
									<option value="Saudi Arabia">Saudi Arabia</option>
									<option value="Sweden">Sweden</option>
									<option value="Singapore">Singapore</option>
									<option value="Slovenia">Slovenia</option>
									<option value="Slovakia">Slovakia</option>
									<option value="Senegal">Senegal</option>
									<option value="El Salvador">El Salvador</option>
									<option value="Togo">Togo</option>
									<option value="Thailand">Thailand</option>
									<option value="Tajikistan">Tajikistan</option>
									<option value="Turkey">Turkey</option>
									<option value="Trinidad and Tobago">Trinidad and Tobago</option>
									<option value="Taiwan">Taiwan</option>
									<option value="Tanzania">Tanzania</option>
									<option value="Ukraine">Ukraine</option>
									<option value="Uganda">Uganda</option>
									<option value="United States">United States</option>
									<option value="Uruguay">Uruguay</option>
									<option value="Venezuela">Venezuela</option>
									<option value="Vietnam">Vietnam</option>
									<option value="Yemen">Yemen</option>
									<option value="South Africa">South Africa</option>
									<option value="Zambia">Zambia</option>
									<option value="Zimbabwe">Zimbabwe</option>
				  				</select>
					  			<select name="months" style = "padding:0px;">
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