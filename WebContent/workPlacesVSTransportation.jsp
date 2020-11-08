<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript">
window.onload = function() { 
	var chart = new CanvasJS.Chart("chartContainer", {
	title:{
		text: "Workplace Mobility Trends in ${country} on ${month}"
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
		<button>Return to Search Operations Page</button>
	</form>
</body>
</html>                           