    <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.google.gson.Gson"%>
    <%@ page import="com.google.gson.JsonObject"%>
     
    <%
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
    %>
     
    <!DOCTYPE HTML>
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
    window.onload = function() { 
     
    var chart = new CanvasJS.Chart("chartContainer", {  
    	theme: "light2",
    	title: {
    		text: "Energy-Related CO2 Emission - 2000 to 2015"
    	},
    	subtitles: [{
    		text: "in Million Metric Tons of Carbon Dioxide"
    	}],
    	toolTip: {
    		shared: true
    	},
    	legend:{
    		cursor: "pointer",
    		itemclick: toggleDataSeries
    	},
    	data: [{
    		type: "area",
    		name: "Arizona",
    		showInLegend: true,
    		xValueType: "dateTime",
    		xValueFormatString: "YYYY",
    		dataPoints: <%out.print(dataPoints1);%>
    	},
    	{
    		type: "area",
    		name: "Massachusetts",
    		showInLegend: true,
    		xValueType: "dateTime",
    		xValueFormatString: "YYYY",
    		dataPoints: <%out.print(dataPoints2);%>
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
    <div id="chartContainer" style="height: 370px; width: 100%;"></div>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    </body>
    </html>                              