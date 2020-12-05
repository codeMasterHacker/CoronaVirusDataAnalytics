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
					  			<!-- <input type="text" name="iso" required="required" size="3" maxlength="5"/> -->
					  			<select name="iso" required="required">
									<option value="AE">United Arab Emirates</option>
									<option value="AF">Afghanistan</option>
									<option value="AG">Antigua and Barbuda</option>
									<option value="AO">Angola</option>
									<option value="AR">Argentina</option>
									<option value="AT">Austria</option>
									<option value="AU">Australia</option>
									<option value="AW">Aruba</option>
									<option value="BA">Bosnia and Herzegovina</option>
									<option value="BB">Barbados</option>
									<option value="BD">Bangladesh</option>
									<option value="BE">Belgium</option>
									<option value="BF">Burkina Faso</option>
									<option value="BG">Bulgaria</option>
									<option value="BH">Bahrain</option>
									<option value="BJ">Benin</option>
									<option value="BO">Bolivia</option>
									<option value="BR">Brazil</option>
									<option value="BW">Botswana</option>
									<option value="BY">Belarus</option>
									<option value="BZ">Belize</option>
									<option value="CA">Canada</option>
									<option value="CH">Switzerland</option>
									<option value="CI">Côte d'Ivoire</option>
									<option value="CL">Chile</option>
									<option value="CM">Cameroon</option>
									<option value="CO">Colombia</option>
									<option value="CR">Costa Rica</option>
									<option value="CV">Cape Verde</option>
									<option value="CZ">Czechia</option>
									<option value="DE">Germany</option>
									<option value="DK">Denmark</option>
									<option value="DO">Dominican Republic</option>
									<option value="EC">Ecuador</option>
									<option value="EE">Estonia</option>
									<option value="EG">Egypt</option>
									<option value="ES">Spain</option>
									<option value="FI">Finland</option>
									<option value="FJ">Fiji</option>
									<option value="FR">France</option>
									<option value="GA">Gabon</option>
									<option value="GB">United Kingdom</option>
									<option value="GE">Georgia</option>
									<option value="GH">Ghana</option>
									<option value="GR">Greece</option>
									<option value="GT">Guatemala</option>
									<option value="GW">Guinea-Bissau</option>
									<option value="HK">Hong Kong</option>
									<option value="HN">Honduras</option>
									<option value="HR">Croatia</option>
									<option value="HT">Haiti</option>
									<option value="HU">Hungary</option>
									<option value="ID">Indonesia</option>
									<option value="IE">Ireland</option>
									<option value="IL">Israel</option>
									<option value="IN">India</option>
									<option value="IQ">Iraq</option>
									<option value="IT">Italy</option>
									<option value="JM">Jamaica</option>
									<option value="JO">Jordan</option>
									<option value="JP">Japan</option>
									<option value="KE">Kenya</option>
									<option value="KG">Kyrgyzstan</option>
									<option value="KH">Cambodia</option>
									<option value="KR">South Korea</option>
									<option value="KW">Kuwait</option>
									<option value="KZ">Kazakhstan</option>
									<option value="LA">Laos</option>
									<option value="LB">Lebanon</option>
									<option value="LI">Liechtenstein</option>
									<option value="LK">Sri Lanka</option>
									<option value="LT">Lithuania</option>
									<option value="LU">Luxembourg</option>
									<option value="LV">Latvia</option>
									<option value="LY">Libya</option>
									<option value="MA">Morocco</option>
									<option value="MD">Moldova</option>
									<option value="MK">North Macedonia</option>
									<option value="ML">Mali</option>
									<option value="MN">Mongolia</option>
									<option value="MT">Malta</option>
									<option value="MU">Mauritius</option>
									<option value="MX">Mexico</option>
									<option value="MY">Malaysia</option>
									<option value="MZ">Mozambique</option>
									<option value="NA">Namibia</option>
									<option value="NE">Niger</option>
									<option value="NG">Nigeria</option>
									<option value="NI">Nicaragua</option>
									<option value="NL">Netherlands</option>
									<option value="NO">Norway</option>
									<option value="NP">Nepal</option>
									<option value="NZ">New Zealand</option>
									<option value="OM">Oman</option>
									<option value="PA">Panama</option>
									<option value="PE">Peru</option>
									<option value="PG">Papua New Guinea</option>
									<option value="PH">Philippines</option>
									<option value="PK">Pakistan</option>
									<option value="PL">Poland</option>
									<option value="PR">Puerto Rico</option>
									<option value="PT">Portugal</option>
									<option value="PY">Paraguay</option>
									<option value="QA">Qatar</option>
									<option value="RE">Réunion</option>
									<option value="RO">Romania</option>
									<option value="RS">Serbia</option>
									<option value="RU">Russia</option>
									<option value="RW">Rwanda</option>
									<option value="SA">Saudi Arabia</option>
									<option value="SE">Sweden</option>
									<option value="SG">Singapore</option>
									<option value="SI">Slovenia</option>
									<option value="SK">Slovakia</option>
									<option value="SN">Senegal</option>
									<option value="SV">El Salvador</option>
									<option value="TG">Togo</option>
									<option value="TH">Thailand</option>
									<option value="TJ">Tajikistan</option>
									<option value="TR">Turkey</option>
									<option value="TT">Trinidad and Tobago</option>
									<option value="TW">Taiwan</option>
									<option value="TZ">Tanzania</option>
									<option value="UA">Ukraine</option>
									<option value="UG">Uganda</option>
									<option value="US">United States</option>
									<option value="UY">Uruguay</option>
									<option value="VE">Venezuela</option>
									<option value="VN">Vietnam</option>
									<option value="YE">Yemen</option>
									<option value="ZA">South Africa</option>
									<option value="ZM">Zambia</option>
									<option value="ZW">Zimbabwe</option>
				  				</select>
					  			</br>
								<label for="country">Country:</label> 
								<!-- <input type="text" name="country" required="required" size="50" maxlength="60"/> -->
								<select name="country" required="required">
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
								</br>
								<!-- <label for="date">Date:</label> 
								<input type="text" name="date" required="required" size="10" maxlength="10"/> -->
								<label for="date">Date:</label>
								<input type="date" name="date" required="required" value="2020-10-28" min="2020-10-28">
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
					  			<!-- <input type="text" name="iso" size="3" maxlength="5"/>	-->
					  			<select name="iso">
									<option value="AE">United Arab Emirates</option>
									<option value="AF">Afghanistan</option>
									<option value="AG">Antigua and Barbuda</option>
									<option value="AO">Angola</option>
									<option value="AR">Argentina</option>
									<option value="AT">Austria</option>
									<option value="AU">Australia</option>
									<option value="AW">Aruba</option>
									<option value="BA">Bosnia and Herzegovina</option>
									<option value="BB">Barbados</option>
									<option value="BD">Bangladesh</option>
									<option value="BE">Belgium</option>
									<option value="BF">Burkina Faso</option>
									<option value="BG">Bulgaria</option>
									<option value="BH">Bahrain</option>
									<option value="BJ">Benin</option>
									<option value="BO">Bolivia</option>
									<option value="BR">Brazil</option>
									<option value="BW">Botswana</option>
									<option value="BY">Belarus</option>
									<option value="BZ">Belize</option>
									<option value="CA">Canada</option>
									<option value="CH">Switzerland</option>
									<option value="CI">Côte d'Ivoire</option>
									<option value="CL">Chile</option>
									<option value="CM">Cameroon</option>
									<option value="CO">Colombia</option>
									<option value="CR">Costa Rica</option>
									<option value="CV">Cape Verde</option>
									<option value="CZ">Czechia</option>
									<option value="DE">Germany</option>
									<option value="DK">Denmark</option>
									<option value="DO">Dominican Republic</option>
									<option value="EC">Ecuador</option>
									<option value="EE">Estonia</option>
									<option value="EG">Egypt</option>
									<option value="ES">Spain</option>
									<option value="FI">Finland</option>
									<option value="FJ">Fiji</option>
									<option value="FR">France</option>
									<option value="GA">Gabon</option>
									<option value="GB">United Kingdom</option>
									<option value="GE">Georgia</option>
									<option value="GH">Ghana</option>
									<option value="GR">Greece</option>
									<option value="GT">Guatemala</option>
									<option value="GW">Guinea-Bissau</option>
									<option value="HK">Hong Kong</option>
									<option value="HN">Honduras</option>
									<option value="HR">Croatia</option>
									<option value="HT">Haiti</option>
									<option value="HU">Hungary</option>
									<option value="ID">Indonesia</option>
									<option value="IE">Ireland</option>
									<option value="IL">Israel</option>
									<option value="IN">India</option>
									<option value="IQ">Iraq</option>
									<option value="IT">Italy</option>
									<option value="JM">Jamaica</option>
									<option value="JO">Jordan</option>
									<option value="JP">Japan</option>
									<option value="KE">Kenya</option>
									<option value="KG">Kyrgyzstan</option>
									<option value="KH">Cambodia</option>
									<option value="KR">South Korea</option>
									<option value="KW">Kuwait</option>
									<option value="KZ">Kazakhstan</option>
									<option value="LA">Laos</option>
									<option value="LB">Lebanon</option>
									<option value="LI">Liechtenstein</option>
									<option value="LK">Sri Lanka</option>
									<option value="LT">Lithuania</option>
									<option value="LU">Luxembourg</option>
									<option value="LV">Latvia</option>
									<option value="LY">Libya</option>
									<option value="MA">Morocco</option>
									<option value="MD">Moldova</option>
									<option value="MK">North Macedonia</option>
									<option value="ML">Mali</option>
									<option value="MN">Mongolia</option>
									<option value="MT">Malta</option>
									<option value="MU">Mauritius</option>
									<option value="MX">Mexico</option>
									<option value="MY">Malaysia</option>
									<option value="MZ">Mozambique</option>
									<option value="NA">Namibia</option>
									<option value="NE">Niger</option>
									<option value="NG">Nigeria</option>
									<option value="NI">Nicaragua</option>
									<option value="NL">Netherlands</option>
									<option value="NO">Norway</option>
									<option value="NP">Nepal</option>
									<option value="NZ">New Zealand</option>
									<option value="OM">Oman</option>
									<option value="PA">Panama</option>
									<option value="PE">Peru</option>
									<option value="PG">Papua New Guinea</option>
									<option value="PH">Philippines</option>
									<option value="PK">Pakistan</option>
									<option value="PL">Poland</option>
									<option value="PR">Puerto Rico</option>
									<option value="PT">Portugal</option>
									<option value="PY">Paraguay</option>
									<option value="QA">Qatar</option>
									<option value="RE">Réunion</option>
									<option value="RO">Romania</option>
									<option value="RS">Serbia</option>
									<option value="RU">Russia</option>
									<option value="RW">Rwanda</option>
									<option value="SA">Saudi Arabia</option>
									<option value="SE">Sweden</option>
									<option value="SG">Singapore</option>
									<option value="SI">Slovenia</option>
									<option value="SK">Slovakia</option>
									<option value="SN">Senegal</option>
									<option value="SV">El Salvador</option>
									<option value="TG">Togo</option>
									<option value="TH">Thailand</option>
									<option value="TJ">Tajikistan</option>
									<option value="TR">Turkey</option>
									<option value="TT">Trinidad and Tobago</option>
									<option value="TW">Taiwan</option>
									<option value="TZ">Tanzania</option>
									<option value="UA">Ukraine</option>
									<option value="UG">Uganda</option>
									<option value="US">United States</option>
									<option value="UY">Uruguay</option>
									<option value="VE">Venezuela</option>
									<option value="VN">Vietnam</option>
									<option value="YE">Yemen</option>
									<option value="ZA">South Africa</option>
									<option value="ZM">Zambia</option>
									<option value="ZW">Zimbabwe</option>
				  				</select>
					  			</br>	
								<label for="country">Country:</label> 
								<!--  <input type="text" name="country" required="required" size="50" maxlength="60"/> -->
								<select name="country" required="required">
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
								</br>
								<label for="date">Date:</label> 
								<!-- <input type="text" name="date" required="required" size="10" maxlength="10"/> -->
								<input type="date" name="date" required="required" value="2020-02-15" min="2020-02-15">	
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
								<!-- <input type="text" name="country" required="required" size="50" maxlength="60"/> -->
								<select name="country" required="required">
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
								
								<label for="date">Date:</label> 
								<!-- <input type="text" name="date" required="required" size="10" maxlength="10"/> -->
								<input type="date" name="date" required="required" value="2020-02-15" min="2020-02-15">	
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