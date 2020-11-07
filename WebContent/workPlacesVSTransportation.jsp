    <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%-- page import="com.google.gson.Gson"--%>
    <%-- page import="com.google.gson.JsonObject"--%>
     
    <%--
    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
     
    map = new HashMap<Object,Object>(); map.put("x", 946665000000L); map.put("y", 86.1); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 978287400000L); map.put("y", 88.4); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1009823400000L); map.put("y", 87.8); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1041359400000L); map.put("y", 89.6); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1072895400000L); map.put("y", 96.6); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1104517800000L); map.put("y", 96.7); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1136053800000L); map.put("y", 99.9); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1167589800000L); map.put("y", 101.9); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1199125800000L); map.put("y", 102.3); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1230748200000L); map.put("y", 93.4); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1262284200000L); map.put("y", 95.2); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1293820200000L); map.put("y", 93.3); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1325356200000L); map.put("y", 91.3); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1356978600000L); map.put("y", 95.1); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1388514600000L); map.put("y", 93.1); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1420050600000L); map.put("y", 90.9); list.add(map);
     
    String dataPoints1 = gsonObj.toJson(list);
     
    list = new ArrayList<Map<Object,Object>>();
    map = new HashMap<Object,Object>(); map.put("x", 946665000000L); map.put("y", 82.5); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 978287400000L); map.put("y", 82.4); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1009823400000L); map.put("y", 83.2); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1041359400000L); map.put("y", 84.5); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1072895400000L); map.put("y", 82.9); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1104517800000L); map.put("y", 84.5); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1136053800000L); map.put("y", 76.5); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1167589800000L); map.put("y", 79.9); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1199125800000L); map.put("y", 76.7); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1230748200000L); map.put("y", 70.3); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1262284200000L); map.put("y", 71.8); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1293820200000L); map.put("y", 68); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1325356200000L); map.put("y", 61.7); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1356978600000L); map.put("y", 65.6); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1388514600000L); map.put("y", 63.7); list.add(map);
    map = new HashMap<Object,Object>(); map.put("x", 1420050600000L); map.put("y", 65.6); list.add(map);
     
    String dataPoints2 = gsonObj.toJson(list);
    --%>
     
    <!DOCTYPE HTML>
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
    window.onload = function() { 
     
   	var chart = new CanvasJS.Chart("chartContainer", {
   		title:{
   			text: "Workplace Mobility Trends in ${country} on ${month}"
   		},
   		axisX:[{
   			title: "Day"
   		},
   		axisY:[{
   			lineColor: "#C24642",
   			tickColor: "#C24642",
   			labelFontColor: "#C24642",
   			titleFontColor: "#C24642",
   			includeZero: true,
   		},
   		{
   			title: "Mobility Trends for Workplaces In Percentage",
   			lineColor: "#369EAD",
   			tickColor: "#369EAD",
   			labelFontColor: "#369EAD",
   			titleFontColor: "#369EAD",
   			includeZero: true,
   		}],
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
   			axisYIndex: 1,
   			dataPoints: [
   				{ x: new Date(2020, 2, 1), y: ${1} },
   				{ x: new Date(2020, 2, 2), y: ${2} },
   				{ x: new Date(2020, 2, 3), y: ${3} },
   				{ x: new Date(2020, 2, 4), y: ${4} },
   				{ x: new Date(2020, 2, 5), y: ${5} },
   				<%--{ x: new Date(2020, ${month}, 6), y: ${6} },
   				{ x: new Date(2020, ${month}, 7), y: ${7} },
   				{ x: new Date(2020, ${month}, 8), y: ${8} },
   				{ x: new Date(2020, ${month}, 9), y: ${9} },
   				{ x: new Date(2020, ${month}, 10), y: ${10} },
   				{ x: new Date(2020, ${month}, 11), y: ${11} },
   				{ x: new Date(2020, ${month}, 12), y: ${12} },
   				{ x: new Date(2020, ${month}, 13), y: ${13} },
   				{ x: new Date(2020, ${month}, 14), y: ${14} },
   				{ x: new Date(2020, ${month}, 15), y: ${15} },
   				{ x: new Date(2020, ${month}, 16), y: ${16} },
   				{ x: new Date(2020, ${month}, 17), y: ${17} },
   				{ x: new Date(2020, ${month}, 18), y: ${18} },
   				{ x: new Date(2020, ${month}, 19), y: ${19} },
   				{ x: new Date(2020, ${month}, 20), y: ${20} },
   				{ x: new Date(2020, ${month}, 21), y: ${21} },
   				{ x: new Date(2020, ${month}, 22), y: ${22} },
   				{ x: new Date(2020, ${month}, 23), y: ${23} },
   				{ x: new Date(2020, ${month}, 24), y: ${24} },
   				{ x: new Date(2020, ${month}, 25), y: ${25} },
   				{ x: new Date(2020, ${month}, 26), y: ${26} },
   				{ x: new Date(2020, ${month}, 27), y: ${27} },
   				{ x: new Date(2020, ${month}, 28), y: ${28} },
   				{ x: new Date(2020, ${month}, 29), y: ${29} },
   				{ x: new Date(2020, ${month}, 30), y: ${30} },
   				{ x: new Date(2020, ${month}, 31), y: ${31} }, --%>
   			]
   		},
   		]
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
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    <form action="SearchOperationsPage" method="get"> 
    		<button>Return to Search Operations Page</button>
    	</form>
    </body>
    </html>                           