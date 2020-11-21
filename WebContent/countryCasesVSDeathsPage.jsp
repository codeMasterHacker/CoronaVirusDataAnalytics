<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>  
<%@ page import="java.util.*" %>  

<!DOCTYPE HTML>
<html>
<head> 
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>

<script>

window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme:"light2",
	
	title:{
		text: "Cases Vs Deaths in the ${Country}"
	},
	axisX:{
		interval: 1
	},
	axisY2:{
		interlacedColor: "rgba(1,77,101,.2)",
		gridColor: "rgba(1,77,101,.1)",
		title: ""
	},
	data: [{
		type: "bar",
		name: "companies",
		axisYType: "secondary",
		color: "#014D65",
		dataPoints: [
			{ y: ${Cases}, label: "Cases" },
			{ y: ${Deaths}, label: "Deaths" }
		]
	}]
});
chart.render();

}
</script>
</head>
<body>
<div id="chartContainer" style="height: 300px; width: 100%;"></div>

<h4>The data shows that out of the people that have caught COVID-19,<br>
 <strong>${CountryCasesVsDeathPercent}%</strong> of people have died from it.</h4>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>

<br><br>
<form action="SearchOperationsPage" method="get"> 
		<input type="submit" name="SearchOperationsPage" value="Go back to homepage" class="gobutton"/>
	</form>
</html>