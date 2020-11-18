<!DOCTYPE HTML>
<html>
<head>

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>

<script type="text/javascript">
window.onload = function() { 
	var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme:"light2",
		
	title:{
		text: "Workplace and Public Transportation Mobility Trends in ${country} on ${month}"
	},
	axisX:{
		
	},
	axisY:
	{
		title: "Mobility Trends for Workplaces In Percentage",
		includeZero: true,
	},
	axisY2:
	{
		title: "Mobility Trends for Public Transits In Percentage",
		includeZero: true,
	},
	toolTip: {
		shared: true
	},
	legend: {
		cursor: "pointer",
		itemclick: toggleDataSeries
	},
	data: [{
		type: "line",
		name: "Workplace Mobility Trend",
		color: "#369EAD",
		showInLegend: true,
		axisYIndex: 0,
		dataPoints: [
			{ x: 1, y: ${one} },
			{ x: 2, y: ${two} },
			{ x: 3, y: ${three} },
			{ x: 4, y: ${four} },
			{ x: 5, y: ${five} },
			{ x: 6, y: ${six} },
			{ x: 7, y: ${seven} },
			{ x: 8, y: ${eight} },
			{ x: 9, y: ${nine} },
			{ x: 10, y: ${ten} },
			{ x: 11, y: ${eleven} },
			{ x: 12, y: ${twelve} },
			{ x: 13, y: ${thirteen} },
			{ x: 14, y: ${fourteen} },
			{ x: 15, y: ${fifteen} },
			{ x: 16, y: ${sixteen} },
			{ x: 17, y: ${seventeen} },
			{ x: 18, y: ${eighteen} },
			{ x: 19, y: ${nineteen} },
			{ x: 20, y: ${twenty} },
			{ x: 21, y: ${twentyone} },
			{ x: 22, y: ${twentytwo} },
			{ x: 23, y: ${twentythree} },
			{ x: 24, y: ${twentyfour} },
			{ x: 25, y: ${twentyfive} },
			{ x: 26, y: ${twentysix} },
			{ x: 27, y: ${twentyseven} },
			{ x: 28, y: ${twentyeight} },
			{ x: 29, y: ${twentynine} },
			{ x: 30, y: ${thirty} },
			{ x: 31, y: ${thirtyone} }
		]
	},
	{
		type: "line",
		name: "Public Transport Mobility Trend",
		color: "#7F6084",
		showInLegend: true,
		axisYIndex: 0,
		dataPoints: [
			{ x: 1, y: ${one1} },
			{ x: 2, y: ${two1} },
			{ x: 3, y: ${three1} },
			{ x: 4, y: ${four1} },
			{ x: 5, y: ${five1} },
			{ x: 6, y: ${six1} },
			{ x: 7, y: ${seven1} },
			{ x: 8, y: ${eight1} },
			{ x: 9, y: ${nine1} },
			{ x: 10, y: ${ten1} },
			{ x: 11, y: ${eleven1} },
			{ x: 12, y: ${twelve1} },
			{ x: 13, y: ${thirteen1} },
			{ x: 14, y: ${fourteen1} },
			{ x: 15, y: ${fifteen1} },
			{ x: 16, y: ${sixteen1} },
			{ x: 17, y: ${seventeen1} },
			{ x: 18, y: ${eighteen1} },
			{ x: 19, y: ${nineteen1} },
			{ x: 20, y: ${twenty1} },
			{ x: 21, y: ${twentyone1} },
			{ x: 22, y: ${twentytwo1} },
			{ x: 23, y: ${twentythree1} },
			{ x: 24, y: ${twentyfour1} },
			{ x: 25, y: ${twentyfive1} },
			{ x: 26, y: ${twentysix1} },
			{ x: 27, y: ${twentyseven1} },
			{ x: 28, y: ${twentyeight1} },
			{ x: 29, y: ${twentynine1} },
			{ x: 30, y: ${thirty1} },
			{ x: 31, y: ${thirtyone1} }
		]
	}]
});
chart.render();
 
function toggleDataSeries(e){
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	}
	else{
		e.dataSeries.visible = true;
	}
	chart.render();
}
 
}
</script>
</head>
<body>
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
<script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<form action="SearchOperationsPage" method="get"> 
		<input type="submit" name="SearchOperationsPage" value="Go back to homepage" class="gobutton"/>
	</form>
</body>
</html>                           