<!DOCTYPE HTML>
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>

<script>


window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "light2",
	title:{
		text: "Average Mobility Per Month in ${country}"
	},
	axisX:{
		valueFormatString: "DD MMM",
		crosshair: {
			enabled: true,
			snapToDataPoint: true
		}
	},
	axisY: {
		title: "Number by Percentage",
		includeZero: true,
		crosshair: {
			enabled: true
		}
	},
	toolTip:{
		shared:true
	},  
	legend:{
		cursor:"pointer",
		verticalAlign: "bottom",
		horizontalAlign: "left",
		dockInsidePlotArea: true,
		itemclick: toogleDataSeries
	},
	data: [{
		type: "line",
		showInLegend: true,
		name: "Grocery and Pharmacy",
		markerType: "square",
		xValueFormatString: "DD MMM, YYYY",
		color: "#F08080",
		dataPoints: [
			{ x: new Date(2020, 1, 30), y: ${febGrocery}  },
			{ x: new Date(2020, 2, 30), y: ${marchGrocery}  },
			{ x: new Date(2020, 3, 30), y: ${aprilGrocery}  },
			{ x: new Date(2020, 4, 30), y: ${mayGrocery}  },
			{ x: new Date(2020, 5, 30), y: ${juneGrocery}  },
			{ x: new Date(2020, 6, 30), y: ${julyGrocery}  },
			{ x: new Date(2020, 7, 30), y: ${augGrocery}  },
			{ x: new Date(2020, 8, 30), y: ${sepGrocery}  }
		]
	},
	
	{
		type: "line",
		showInLegend: true,
		name: "Parks",
		lineDashType: "line",
		dataPoints: [
			{ x: new Date(2020, 1, 30), y: ${febParks}  },
			{ x: new Date(2020, 2, 30), y: ${marchParks}  },
			{ x: new Date(2020, 3, 30), y: ${aprilParks}  },
			{ x: new Date(2020, 4, 30), y: ${mayParks}  },
			{ x: new Date(2020, 5, 30), y: ${juneParks}  },
			{ x: new Date(2020, 6, 30), y: ${julyParks}  },
			{ x: new Date(2020, 7, 30), y: ${augParks}  },
			{ x: new Date(2020, 8, 30), y: ${sepParks}  }

		]
	},
	
	{
		type: "line",
		showInLegend: true,
		name: "Residential",
		lineDashType: "line",
		dataPoints: [
			{ x: new Date(2020, 1, 30), y: ${febRes}  },
			{ x: new Date(2020, 2, 30), y: ${marchRes}  },
			{ x: new Date(2020, 3, 30), y: ${aprilRes}  },
			{ x: new Date(2020, 4, 30), y: ${mayRes}  },
			{ x: new Date(2020, 5, 30), y: ${juneRes}  },
			{ x: new Date(2020, 6, 30), y: ${julyRes}  },
			{ x: new Date(2020, 7, 30), y: ${augRes}  },
			{ x: new Date(2020, 8, 30), y: ${sepRes}  }

		]
	},

	{
		type: "line",
		showInLegend: true,
		name: "Retail and Recreation",
		lineDashType: "line",
		dataPoints: [
			{ x: new Date(2020, 1, 30), y: ${febRetail}  },
			{ x: new Date(2020, 2, 30), y: ${marchRetail}  },
			{ x: new Date(2020, 3, 30), y: ${aprilRetail}  },
			{ x: new Date(2020, 4, 30), y: ${mayRetail}  },
			{ x: new Date(2020, 5, 30), y: ${juneRetail}  },
			{ x: new Date(2020, 6, 30), y: ${julyRetail}  },
			{ x: new Date(2020, 7, 30), y: ${augRetail}  },
			{ x: new Date(2020, 8, 30), y: ${sepRetail}  }

		]
	},

	{
		type: "line",
		showInLegend: true,
		name: "Transit Stations",
		lineDashType: "line",
		dataPoints: [
			{ x: new Date(2020, 1, 30), y: ${febTransit}  },
			{ x: new Date(2020, 2, 30), y: ${marchTransit}  },
			{ x: new Date(2020, 3, 30), y: ${aprilTransit}  },
			{ x: new Date(2020, 4, 30), y: ${mayTransit}  },
			{ x: new Date(2020, 5, 30), y: ${juneTransit}  },
			{ x: new Date(2020, 6, 30), y: ${julyTransit}  },
			{ x: new Date(2020, 7, 30), y: ${augTransit}  },
			{ x: new Date(2020, 8, 30), y: ${sepTransit}  }

		]
	},

	{
		type: "line",
		showInLegend: true,
		name: "Work Places",
		lineDashType: "line",
		dataPoints: [
			{ x: new Date(2020, 1, 30), y: ${febWorkplace}  },
			{ x: new Date(2020, 2, 30), y: ${marchWorkplace}  },
			{ x: new Date(2020, 3, 30), y: ${aprilWorkplace}  },
			{ x: new Date(2020, 4, 30), y: ${mayWorkplace}  },
			{ x: new Date(2020, 5, 30), y: ${juneWorkplace}  },
			{ x: new Date(2020, 6, 30), y: ${julyWorkplace}  },
			{ x: new Date(2020, 7, 30), y: ${augWorkplace}  },
			{ x: new Date(2020, 8, 30), y: ${sepWorkplace}  }

		]
	
	}]

});
chart.render();

function toogleDataSeries(e){
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	} else{
		e.dataSeries.visible = true;
	}
	chart.render();
}

}
</script>

</head>

<body>
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<br><br>

<form action="SearchOperationsPage" method="get">
	<input type="submit" name="SearchOperationsPage" value="Go back to homepage" class="gobutton"/>
</form>

</body>
</html>