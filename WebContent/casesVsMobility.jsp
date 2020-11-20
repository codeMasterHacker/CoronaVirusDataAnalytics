<!DOCTYPE HTML>
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>

<script>
window.onload = function () {
	var chart = new CanvasJS.Chart("chartContainer", {
	title:{
		text: "Cases Per Month vs Average ${mobility} Mobility Per Month in ${country}",
		theme: "light2"
	},
	axisY:[{
		lineColor: "#C24642",
		tickColor: "#C24642",
		labelFontColor: "#C24642",
		titleFontColor: "#C24642",
		includeZero: true,
	},
	{
		title: "Cases",
		lineColor: "#369EAD",
		tickColor: "#369EAD",
		labelFontColor: "#369EAD",
		titleFontColor: "#369EAD",
		includeZero: true,
	}],
	axisY2: {
		title: "Mobility Percent",
		lineColor: "#7F6084",
		tickColor: "#7F6084",
		labelFontColor: "#7F6084",
		titleFontColor: "#7F6084",
		includeZero: true,
		suffix: "%"
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
		name: "Cases",
		color: "#369EAD",
		showInLegend: true,
		axisYIndex: 1,
		dataPoints: [
			{ x: new Date(2020, 01, 30), y: ${febCases} },
			{ x: new Date(2020, 02, 30), y: ${marchCases} },
			{ x: new Date(2020, 03, 30), y: ${aprilCases} },
			{ x: new Date(2020, 04, 30), y: ${mayCases} },
			{ x: new Date(2020, 05, 30), y: ${juneCases} },
			{ x: new Date(2020, 06, 30), y: ${julyCases} },
			{ x: new Date(2020, 07, 30), y: ${augCases} },
			{ x: new Date(2020, 08, 30), y: ${sepCases} },
		]
	},
	{
		type: "line",
		name: "Mobility Percent",
		color: "#7F6084",
		axisYType: "secondary",
		showInLegend: true,
		dataPoints: [ 
			{ x: new Date(2020, 01, 30), y: ${febMobility} },
			{ x: new Date(2020, 02, 30), y: ${marchMobility} },
			{ x: new Date(2020, 03, 30), y: ${aprilMobility} },
			{ x: new Date(2020, 04, 30), y: ${mayMobility} },
			{ x: new Date(2020, 05, 30), y: ${juneMobility} },
			{ x: new Date(2020, 06, 30), y: ${julyMobility} },
			{ x: new Date(2020, 07, 30), y: ${augMobility} },
			{ x: new Date(2020, 08, 30), y: ${sepMobility} },
		]
	}]
});
chart.render();

function toggleDataSeries(e) {
	if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	} else {
		e.dataSeries.visible = true;
	}
	e.chart.render();
}

}
</script>
</head>
<body>
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<br>
<form action="SearchOperationsPage" method="get"> 
		<input type="submit" name="SearchOperationsPage" value="Go back to homepage" class="gobutton"/>
	</form>
</body>
</html>