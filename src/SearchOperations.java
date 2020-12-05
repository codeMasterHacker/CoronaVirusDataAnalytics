import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.awt.*;
import java.awt.image.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.*;


public class SearchOperations extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public SearchOperations() 
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		long startTime = System.currentTimeMillis(); //start time starts here; call endtime in your respective else if statement, where you implement your analytic
		
		HttpSession session = request.getSession(true);
		
		CovidFileManager fileManager = (CovidFileManager)session.getAttribute("fileManager");
		
		if (fileManager == null) //first time using
		{
			//fileManager = new CovidFileManager("/Users/cristinalawson/eclipse-workspace/cs180_project/WebContent/covidFiles");

			//fileManager = new CovidFileManager("E:\\Luccas\\Documents\\docs_2\\UCR Docs\\Fall_2020\\cs180\\cs180_project\\cs180project-022-it-s-corona-time\\WebContent\\covidFiles");

			//fileManager = new CovidFileManager("/Users/jesword/git/cs180project-022-it-s-corona-time/WebContent/covidFiles");

			//fileManager = new CovidFileManager("/Users/Enrique/Desktop/codeFolders/Java/cs180project-022-it-s-corona-time/WebContent/covidFiles");
			
			//fileManager = new CovidFileManager("/Users/celyna/cs180project-022-it-s-corona-time/WebContent/covidFiles/");
			
			fileManager = new CovidFileManager("C:\\Users\\Enrique Munoz\\eclipse-workspace\\cs180project-022-it-s-corona-time\\WebContent\\covidFiles");
			session.setAttribute("fileManager", fileManager);
			session.setAttribute("dataStruct_IncrDesign", fileManager.getCurrent_covidFile().get_dataStruct_incrDesign());
			session.setAttribute("globalDeaths", fileManager.getCurrent_covidFile().get_globalDeaths());
			session.setAttribute("globalCases", fileManager.getCurrent_covidFile().get_globalCases());
		}

		DataStruct_IncrDesign[] dataStruct_IncrDesign = (DataStruct_IncrDesign[])session.getAttribute("dataStruct_IncrDesign");
		double globalDeaths = (double)session.getAttribute("globalDeaths");
		double globalCases = (double)session.getAttribute("globalCases");
		
		String searchOp1 = request.getParameter("submit1");
		String searchOp2 = request.getParameter("submit2");
		String searchOp3 = request.getParameter("submit3");
		String searchOp4 = request.getParameter("submit4");
		String searchOp5 = request.getParameter("submit5");
		String searchOp6 = request.getParameter("submit6");
		String importData = request.getParameter("importData");
		String casesVsDeaths = request.getParameter("casesVsDeaths");
		String allMobilityTrends = request.getParameter("mobilityTrends");
		String worldwideMobilityTrends = request.getParameter("worldwideMobilityTrends");
		String countryCasesVSDeaths = request.getParameter("countryCasesVSDeaths");
		String multiGraph = request.getParameter("multiGraph");
		String casesVsMobility = request.getParameter("casesVsMobility");

		
		boolean isMultiGraph = false;
		boolean isCasesVsDeaths = false;
		boolean isAllMobilityTrends = false;
		boolean isWorldwideMobilityTrends = false;
		boolean isCountryCasesVSDeaths = false;
		boolean search = false;
		boolean isCasesVsMobility = false;
		String country = null;
		String startDate = null;
		String endDate = null;
		String month = null;
		
		String[][] table = null;
		ArrayList<String> monthDays = 
				new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
				"twentyone","twentytwo","twentythree","twentyfour","twentyfive","twentysix","twentyseven","twentyeight","twentynine",
				"thirty","thirtyone"));
		ArrayList<String> monthDays1 = 
				new ArrayList<>(Arrays.asList("one1", "two1", "three1", "four1", "five1", "six1", "seven1", "eight1", "nine1", "ten1",
				"eleven1", "twelve1", "thirteen1","fourteen1","fifteen1","sixteen1","seventeen1","eighteen1","nineteen1","twenty1",
				"twentyone1","twentytwo1","twentythree1","twentyfour1","twentyfive1","twentysix1","twentyseven1","twentyeight1","twentynine1",
				"thirty1","thirtyone1"));
		//String[][] table1 = null;
		//String[][] table2 = null;
		
		
		
		
		String richPoor_testing = request.getParameter("richPoor_testing");
		DefaultPieDataset pieChart_dataSet = null;
		JFreeChart testing_pieChart = null;
		String label = null;
		String[] labels = null;
		BufferedImage bufferedImage = null;
		
		
		
		
		
		if (searchOp1 != null)
		{
			country = request.getParameter("countries");
			startDate = request.getParameter("startDate");
			endDate = request.getParameter("endDate");
			
			search = true;
			table = fileManager.getCurrent_covidFile().read_allColumns(country, startDate, endDate);
		}
		else if (searchOp2 != null)
		{
			country = request.getParameter("countries");
			startDate = request.getParameter("startDate");
			endDate = request.getParameter("endDate");
			
			search = true;
			table = fileManager.getCurrent_covidFile().read_casesDeaths(country, startDate, endDate);
		}
		else if (searchOp3 != null)
		{
			search = true;
			table = fileManager.getCurrent_covidFile().read_testsPop(request.getParameter("countries"));
		}
		else if (searchOp4 != null)
		{
			search = true;
			table = fileManager.getCurrent_covidFile().readCountries_lessHealth(Double.parseDouble(request.getParameter("healthIndices")));
		}
		else if (searchOp5 != null)
		{
			search = true;
			table = fileManager.getCurrent_covidFile().read_baseLines(request.getParameter("countries"));
		}
		else if (searchOp6 != null)
		{
			search = true;
			table = fileManager.getCurrent_covidFile().readCountries_greater65pop(Double.parseDouble(request.getParameter("percents")));
		}
		else if (importData != null)
		{
			search = true;
			if(fileManager.goto_previousFile())
				response.sendRedirect("searchOperationsPage.jsp");
			else
				response.sendError(404, "This is the only file left, there are no more previous versions of the data");
			return;
		}
		else if(casesVsDeaths != null)
		{
//			isCasesVsDeaths = true;
//			double cases = 0;
//			double deaths = 0;
//			double casesVsDeathPercent = 0.0;
//			
//			//long startTime = System.nanoTime();
//			
//			cases = fileManager.getCurrent_covidFile().getCases();
//			deaths = fileManager.getCurrent_covidFile().getDeaths();
//			casesVsDeathPercent = (deaths / cases) * 100;	
//			
//			DecimalFormat roundedAnswer = new DecimalFormat("#.###");
//	        roundedAnswer.setRoundingMode(RoundingMode.CEILING);
//			session.setAttribute("Cases", cases);
//			session.setAttribute("Deaths", deaths);
//			session.setAttribute("CasesVsDeathPercent", roundedAnswer.format(casesVsDeathPercent));
//			
//			long endTime = System.nanoTime();
//			long executionTime = (endTime - startTime) / 1000000;
//			System.out.println("Execution Time: " + executionTime + " milliseconds");
			
			isCasesVsDeaths = true;
			
			//long startTime = System.nanoTime();
			double casesVsDeathPercent = (globalDeaths / globalCases) * 100;	
			
			DecimalFormat roundedAnswer = new DecimalFormat("#.##");
	        roundedAnswer.setRoundingMode(RoundingMode.CEILING);
			session.setAttribute("Cases", globalCases);
			session.setAttribute("Deaths", globalDeaths);
			session.setAttribute("CasesVsDeathPercent", roundedAnswer.format(casesVsDeathPercent));
			
			long endTime = System.currentTimeMillis();
			System.out.println("Elapsed Time in milliseconds: " + (endTime - startTime));
			
		} else if (worldwideMobilityTrends != null) {
			System.out.print("wwnull selected\n");
			
			isWorldwideMobilityTrends = true;
			
//			// Grocery and Pharmacy Mobility
//			ArrayList<Double> groceryAvgAll = fileManager.getCurrent_covidFile().getAllGroceryMobilityAvg();
//			session.setAttribute("febGroceryAll", groceryAvgAll.get(0));
//			session.setAttribute("marchGroceryAll", groceryAvgAll.get(1));
//			session.setAttribute("aprilGroceryAll", groceryAvgAll.get(2));
//			session.setAttribute("mayGroceryAll", groceryAvgAll.get(3));
//			session.setAttribute("juneGroceryAll", groceryAvgAll.get(4));
//			session.setAttribute("julyGroceryAll", groceryAvgAll.get(5));
//			session.setAttribute("augGroceryAll", groceryAvgAll.get(6));
//			session.setAttribute("sepGroceryAll", groceryAvgAll.get(7));
//			
//			// Parks mobility
//			ArrayList<Double> parksAvgAll = fileManager.getCurrent_covidFile().getAllParksMobilityAvg();
//			session.setAttribute("febParksAll", parksAvgAll.get(0));
//			session.setAttribute("marchParksAll", parksAvgAll.get(1));
//			session.setAttribute("aprilParksAll", parksAvgAll.get(2));
//			session.setAttribute("mayParksAll", parksAvgAll.get(3));
//			session.setAttribute("juneParksAll", parksAvgAll.get(4));
//			session.setAttribute("julyParksAll", parksAvgAll.get(5));
//			session.setAttribute("augParksAll", parksAvgAll.get(6));
//			session.setAttribute("sepParksAll", parksAvgAll.get(7));
//			
//			// Parks mobility
//			ArrayList<Double> resAvgAll = fileManager.getCurrent_covidFile().getAllResidentialMobilityAvg();
//			session.setAttribute("febResAll", resAvgAll.get(0));
//			session.setAttribute("marchResAll", resAvgAll.get(1));
//			session.setAttribute("aprilResAll", resAvgAll.get(2));
//			session.setAttribute("mayResAll", resAvgAll.get(3));
//			session.setAttribute("juneResAll", resAvgAll.get(4));
//			session.setAttribute("julyResAll", resAvgAll.get(5));
//			session.setAttribute("augResAll", resAvgAll.get(6));
//			session.setAttribute("sepResAll", resAvgAll.get(7));
//						
//			// retail mobility
//			ArrayList<Double> retailAvgAll = fileManager.getCurrent_covidFile().getAllRetailMobilityAvg();
//			session.setAttribute("febRetailAll", retailAvgAll.get(0));
//			session.setAttribute("marchRetailAll", retailAvgAll.get(1));
//			session.setAttribute("aprilRetailAll", retailAvgAll.get(2));
//			session.setAttribute("mayRetailAll", retailAvgAll.get(3));
//			session.setAttribute("juneRetailAll", retailAvgAll.get(4));
//			session.setAttribute("julyRetailAll", retailAvgAll.get(5));
//			session.setAttribute("augRetailAll", retailAvgAll.get(6));
//			session.setAttribute("sepRetailAll", retailAvgAll.get(7));
//						
//			// Transit mobility
//			ArrayList<Double> transitAvgAll = fileManager.getCurrent_covidFile().getAllTransitMobilityAvg();
//			session.setAttribute("febTransitAll", transitAvgAll.get(0));
//			session.setAttribute("marchTransitAll", transitAvgAll.get(1));
//			session.setAttribute("aprilTransitAll", transitAvgAll.get(2));
//			session.setAttribute("mayTransitAll", transitAvgAll.get(3));
//			session.setAttribute("juneTransitAll", transitAvgAll.get(4));
//			session.setAttribute("julyTransitAll", transitAvgAll.get(5));
//			session.setAttribute("augTransitAll", transitAvgAll.get(6));
//			session.setAttribute("sepTransitAll", transitAvgAll.get(7));
//						
//			// Workplace mobility
//			ArrayList<Double> workplaceAvgAll = fileManager.getCurrent_covidFile().getAllWorkplaceMobilityAvg();
//			session.setAttribute("febWorkplaceAll", workplaceAvgAll.get(0));
//			session.setAttribute("marchWorkplaceAll", workplaceAvgAll.get(1));
//			session.setAttribute("aprilWorkplaceAll", workplaceAvgAll.get(2));
//			session.setAttribute("mayWorkplaceAll", workplaceAvgAll.get(3));
//			session.setAttribute("juneWorkplaceAll", workplaceAvgAll.get(4));
//			session.setAttribute("julyWorkplaceAll", workplaceAvgAll.get(5));
//			session.setAttribute("augWorkplaceAll", workplaceAvgAll.get(6));
//			session.setAttribute("sepWorkplaceAll", workplaceAvgAll.get(7));
			
			country = "United States";
			
			// Grocery and Pharmacy Mobility
			ArrayList<Double> groceryAvg = fileManager.getCurrent_covidFile().getGroceryMobilityAvg(country);
			session.setAttribute("febGrocery", groceryAvg.get(0));
			session.setAttribute("marchGrocery", groceryAvg.get(1));
			session.setAttribute("aprilGrocery", groceryAvg.get(2));
			session.setAttribute("mayGrocery", groceryAvg.get(3));
			session.setAttribute("juneGrocery", groceryAvg.get(4));
			session.setAttribute("julyGrocery", groceryAvg.get(5));
			session.setAttribute("augGrocery", groceryAvg.get(6));
			session.setAttribute("sepGrocery", groceryAvg.get(7));
			
			// Parks mobility
			ArrayList<Double> parksAvg = fileManager.getCurrent_covidFile().getParksMobilityAvg(country);
			session.setAttribute("febParks", parksAvg.get(0));
			session.setAttribute("marchParks", parksAvg.get(1));
			session.setAttribute("aprilParks", parksAvg.get(2));
			session.setAttribute("mayParks", parksAvg.get(3));
			session.setAttribute("juneParks", parksAvg.get(4));
			session.setAttribute("julyParks", parksAvg.get(5));
			session.setAttribute("augParks", parksAvg.get(6));
			session.setAttribute("sepParks", parksAvg.get(7));
			
			// Parks mobility
			ArrayList<Double> resAvg = fileManager.getCurrent_covidFile().getResidentialMobilityAvg(country);
			session.setAttribute("febRes", resAvg.get(0));
			session.setAttribute("marchRes", resAvg.get(1));
			session.setAttribute("aprilRes", resAvg.get(2));
			session.setAttribute("mayRes", resAvg.get(3));
			session.setAttribute("juneRes", resAvg.get(4));
			session.setAttribute("julyRes", resAvg.get(5));
			session.setAttribute("augRes", resAvg.get(6));
			session.setAttribute("sepRes", resAvg.get(7));
						
			// retail mobility
			ArrayList<Double> retailAvg = fileManager.getCurrent_covidFile().getRetailMobilityAvg(country);
			session.setAttribute("febRetail", retailAvg.get(0));
			session.setAttribute("marchRetail", retailAvg.get(1));
			session.setAttribute("aprilRetail", retailAvg.get(2));
			session.setAttribute("mayRetail", retailAvg.get(3));
			session.setAttribute("juneRetail", retailAvg.get(4));
			session.setAttribute("julyRetail", retailAvg.get(5));
			session.setAttribute("augRetail", retailAvg.get(6));
			session.setAttribute("sepRetail", retailAvg.get(7));
						
			// Transit mobility
			ArrayList<Double> transitAvg = fileManager.getCurrent_covidFile().getTransitMobilityAvg(country);
			session.setAttribute("febTransit", transitAvg.get(0));
			session.setAttribute("marchTransit", transitAvg.get(1));
			session.setAttribute("aprilTransit", transitAvg.get(2));
			session.setAttribute("mayTransit", transitAvg.get(3));
			session.setAttribute("juneTransit", transitAvg.get(4));
			session.setAttribute("julyTransit", transitAvg.get(5));
			session.setAttribute("augTransit", transitAvg.get(6));
			session.setAttribute("sepTransit", transitAvg.get(7));
						
			// Workplace mobility
			ArrayList<Double> workplaceAvg = fileManager.getCurrent_covidFile().getWorkplaceMobilityAvg(country);
			session.setAttribute("febWorkplace", workplaceAvg.get(0));
			session.setAttribute("marchWorkplace", workplaceAvg.get(1));
			session.setAttribute("aprilWorkplace", workplaceAvg.get(2));
			session.setAttribute("mayWorkplace", workplaceAvg.get(3));
			session.setAttribute("juneWorkplace", workplaceAvg.get(4));
			session.setAttribute("julyWorkplace", workplaceAvg.get(5));
			session.setAttribute("augWorkplace", workplaceAvg.get(6));
			session.setAttribute("sepWorkplace", workplaceAvg.get(7));
			
			
			
		}
		else if(allMobilityTrends != null)
		{
			isAllMobilityTrends = true;
			country = request.getParameter("countries");
			session.setAttribute("country", country);
			
			ArrayList<Double> groceryAvg = new ArrayList<Double>();
			ArrayList<Double> parksAvg = new ArrayList<Double>();
			ArrayList<Double> resAvg = new ArrayList<Double>();
			ArrayList<Double> retailAvg = new ArrayList<Double>();
			ArrayList<Double> transitAvg = new ArrayList<Double>();
			ArrayList<Double> workplaceAvg = new ArrayList<Double>();
			
	
				groceryAvg = fileManager.getCurrent_covidFile().getGroceryMobilityAvg(country);
				parksAvg = fileManager.getCurrent_covidFile().getParksMobilityAvg(country);
				resAvg = fileManager.getCurrent_covidFile().getResidentialMobilityAvg(country);
				retailAvg = fileManager.getCurrent_covidFile().getRetailMobilityAvg(country);
				transitAvg = fileManager.getCurrent_covidFile().getTransitMobilityAvg(country);
				workplaceAvg = fileManager.getCurrent_covidFile().getWorkplaceMobilityAvg(country);
			
		
			// Grocery
			session.setAttribute("febGrocery", groceryAvg.get(0));
			session.setAttribute("marchGrocery", groceryAvg.get(1));
			session.setAttribute("aprilGrocery", groceryAvg.get(2));
			session.setAttribute("mayGrocery", groceryAvg.get(3));
			session.setAttribute("juneGrocery", groceryAvg.get(4));
			session.setAttribute("julyGrocery", groceryAvg.get(5));
			session.setAttribute("augGrocery", groceryAvg.get(6));
			session.setAttribute("sepGrocery", groceryAvg.get(7));
			
			// Parks
			session.setAttribute("febParks", parksAvg.get(0));
			session.setAttribute("marchParks", parksAvg.get(1));
			session.setAttribute("aprilParks", parksAvg.get(2));
			session.setAttribute("mayParks", parksAvg.get(3));
			session.setAttribute("juneParks", parksAvg.get(4));
			session.setAttribute("julyParks", parksAvg.get(5));
			session.setAttribute("augParks", parksAvg.get(6));
			session.setAttribute("sepParks", parksAvg.get(7));
			
			// Parks mobility

			session.setAttribute("febRes", resAvg.get(0));
			session.setAttribute("marchRes", resAvg.get(1));
			session.setAttribute("aprilRes", resAvg.get(2));
			session.setAttribute("mayRes", resAvg.get(3));
			session.setAttribute("juneRes", resAvg.get(4));
			session.setAttribute("julyRes", resAvg.get(5));
			session.setAttribute("augRes", resAvg.get(6));
			session.setAttribute("sepRes", resAvg.get(7));
						
			// retail mobility

			session.setAttribute("febRetail", retailAvg.get(0));
			session.setAttribute("marchRetail", retailAvg.get(1));
			session.setAttribute("aprilRetail", retailAvg.get(2));
			session.setAttribute("mayRetail", retailAvg.get(3));
			session.setAttribute("juneRetail", retailAvg.get(4));
			session.setAttribute("julyRetail", retailAvg.get(5));
			session.setAttribute("augRetail", retailAvg.get(6));
			session.setAttribute("sepRetail", retailAvg.get(7));
						
			// Transit mobility
	
			session.setAttribute("febTransit", transitAvg.get(0));
			session.setAttribute("marchTransit", transitAvg.get(1));
			session.setAttribute("aprilTransit", transitAvg.get(2));
			session.setAttribute("mayTransit", transitAvg.get(3));
			session.setAttribute("juneTransit", transitAvg.get(4));
			session.setAttribute("julyTransit", transitAvg.get(5));
			session.setAttribute("augTransit", transitAvg.get(6));
			session.setAttribute("sepTransit", transitAvg.get(7));
						
			// Workplace mobility

			session.setAttribute("febWorkplace", workplaceAvg.get(0));
			session.setAttribute("marchWorkplace", workplaceAvg.get(1));
			session.setAttribute("aprilWorkplace", workplaceAvg.get(2));
			session.setAttribute("mayWorkplace", workplaceAvg.get(3));
			session.setAttribute("juneWorkplace", workplaceAvg.get(4));
			session.setAttribute("julyWorkplace", workplaceAvg.get(5));
			session.setAttribute("augWorkplace", workplaceAvg.get(6));
			session.setAttribute("sepWorkplace", workplaceAvg.get(7));
				
			
		}
		else if(casesVsMobility != null)
		{
			isCasesVsMobility = true;
			country = request.getParameter("countries");
			String mobility = request.getParameter("mobility");
			
			//long startTime = System.nanoTime();
			ArrayList<Double> cases = fileManager.getCurrent_covidFile().getCasesPerMonth(country);
			ArrayList<Double> mobilityAvg = new ArrayList<Double>();
			
			if(mobility.equals("Grocery and Pharmacy"))
				mobilityAvg = fileManager.getCurrent_covidFile().getGroceryMobilityAvg(country);
			else if (mobility.equals("Parks"))
				mobilityAvg = fileManager.getCurrent_covidFile().getParksMobilityAvg(country);
			else if (mobility.equals("Residential"))
				mobilityAvg = fileManager.getCurrent_covidFile().getResidentialMobilityAvg(country);
			else if (mobility.equals("Retail and Recreations"))
				mobilityAvg = fileManager.getCurrent_covidFile().getRetailMobilityAvg(country);
			else if (mobility.equals("Transit Stations"))
				mobilityAvg = fileManager.getCurrent_covidFile().getTransitMobilityAvg(country);
			else if (mobility.equals("Workplaces"))
				mobilityAvg = fileManager.getCurrent_covidFile().getWorkplaceMobilityAvg(country);
			
			session.setAttribute("country", country);
			session.setAttribute("mobility", mobility);
			
			
			// cases per month
			session.setAttribute("febCases", cases.get(0));
			session.setAttribute("marchCases", cases.get(1));
			session.setAttribute("aprilCases", cases.get(2));
			session.setAttribute("mayCases", cases.get(3));
			session.setAttribute("juneCases", cases.get(4));
			session.setAttribute("julyCases", cases.get(5));
			session.setAttribute("augCases", cases.get(6));
			session.setAttribute("sepCases", cases.get(7));
			
			// avg mobility per month
			session.setAttribute("febMobility", mobilityAvg.get(0));
			session.setAttribute("marchMobility", mobilityAvg.get(1));
			session.setAttribute("aprilMobility", mobilityAvg.get(2));
			session.setAttribute("mayMobility", mobilityAvg.get(3));
			session.setAttribute("juneMobility", mobilityAvg.get(4));
			session.setAttribute("julyMobility", mobilityAvg.get(5));
			session.setAttribute("augMobility", mobilityAvg.get(6));
			session.setAttribute("sepMobility", mobilityAvg.get(7));
			
			long endTime = System.nanoTime();
			long executionTime = (endTime - startTime) / 1000000;
			System.out.println("Execution Time: " + executionTime + " milliseconds");
	
			
		}
		else if (countryCasesVSDeaths != null) 
		{
			isCountryCasesVSDeaths = true;
			double cases = 0;
			double deaths = 0;
			double countryCasesVSDeathPercent = 0.0;
			
			
			for (int i = 0; i < dataStruct_IncrDesign.length; ++i) {
				if (dataStruct_IncrDesign[i].countryName.equals(request.getParameter("countries"))) {
					cases = dataStruct_IncrDesign[i].totalCases;
					//System.out.print(cases);
				}
			}
			
			for (int j = 0; j < dataStruct_IncrDesign.length; ++j) {
				if (dataStruct_IncrDesign[j].countryName.equals(request.getParameter("countries"))) {
					deaths = dataStruct_IncrDesign[j].totalDeaths;
					//System.out.print(deaths);
				}
			}
			
			
			//cases = fileManager.getCurrent_covidFile().getCountryCases(request.getParameter("countries"));
			//deaths = fileManager.getCurrent_covidFile().getCountryDeaths(request.getParameter("countries"));
			countryCasesVSDeathPercent = (deaths / cases) * 100;
			session.setAttribute("Cases", cases);
			session.setAttribute("Deaths", deaths);
			session.setAttribute("Country", request.getParameter("countries"));
			session.setAttribute("CountryCasesVsDeathPercent", countryCasesVSDeathPercent);
			
			long endTime = System.currentTimeMillis();
			System.out.println("Elapsed Time in milliseconds: " + (endTime - startTime));
		
		} else if (multiGraph != null) {
			//double workPlaces = 0;
			//double transportation = 0;
			//double countryCasesVSDeathPercent = 0.0;
			//transport on col 7, public on 8
			
			//workPlaces = fileManager.getCurrent_covidFile().getCountryWorkplaceTrends(request.getParameter("countries"));
			//transportation = fileManager.getCurrent_covidFile().getCountryPublicTransportTrends(request.getParameter("countries"));
			/*countryCasesVSDeathPercent = (deaths / cases) * 100;
			session.setAttribute("Cases", cases);
			session.setAttribute("Deaths", deaths);
			session.setAttribute("CountryCasesVsDeathPercent", countryCasesVSDeathPercent);
			*/
			//search = true;
			country = request.getParameter("countries");
			month = request.getParameter("months");
			int dayTrack = 0;
			int dayTrack1 = 0;
					
			ArrayList<Double> workplaceMobility = new ArrayList<Double>();
			ArrayList<Double> publicTransitMobility = new ArrayList<Double>();
			
			isMultiGraph = true;
			workplaceMobility = fileManager.getCurrent_covidFile().getCountryWorkplaceTrends(country, month);
			publicTransitMobility = fileManager.getCurrent_covidFile().getCountryPublicTransportTrendsMonthly(country, month);
			
			session.setAttribute("country", country);
			session.setAttribute("month", month);
			/*System.out.print("print data\n");
			for(int i = 0; i < workplaceMobility.size(); ++i) {
				System.out.print(workplaceMobility.get(i)+"\n");
			}
			System.out.print("print data end\n");
			*/
			/*session.setAttribute("one", workplaceMobility.get(0));
			session.setAttribute("two", workplaceMobility.get(1));
			session.setAttribute("three", workplaceMobility.get(2));
			session.setAttribute("four", workplaceMobility.get(3));
			session.setAttribute("five", workplaceMobility.get(4)); 
			session.setAttribute("six", workplaceMobility.get(5)); 
			session.setAttribute("seven", workplaceMobility.get(6)); 
			session.setAttribute("eight", workplaceMobility.get(7)); 
			session.setAttribute("nine", workplaceMobility.get(8)); 
			session.setAttribute("ten", workplaceMobility.get(9)); 
			session.setAttribute("eleven", workplaceMobility.get(10)); 
			session.setAttribute("twelve", workplaceMobility.get(11)); 
			session.setAttribute("thirteen", workplaceMobility.get(12)); 
			session.setAttribute("fourteen", workplaceMobility.get(13)); 
			session.setAttribute("fifteen", workplaceMobility.get(14)); 
			session.setAttribute("sixteen", workplaceMobility.get(15));
			session.setAttribute("seventeen", workplaceMobility.get(16));
			session.setAttribute("eighteen", workplaceMobility.get(17));
			session.setAttribute("nineteen", workplaceMobility.get(18));
			session.setAttribute("twenty", workplaceMobility.get(19)); 
			session.setAttribute("twentyone", workplaceMobility.get(20)); 
			session.setAttribute("twentytwo", workplaceMobility.get(21)); 
			session.setAttribute("twentythree", workplaceMobility.get(22)); 
			session.setAttribute("twentyfour", workplaceMobility.get(23)); 
			session.setAttribute("twentyfive", workplaceMobility.get(24)); 
			session.setAttribute("twentysix", workplaceMobility.get(25)); 
			session.setAttribute("twentyseven", workplaceMobility.get(26)); 
			session.setAttribute("twentyeight", workplaceMobility.get(27)); 
			session.setAttribute("twentynine", workplaceMobility.get(28)); 
			session.setAttribute("thirty", workplaceMobility.get(29));
			session.setAttribute("thirtyone", workplaceMobility.get(30));
			*/
			dayTrack = 0;
			for(int i = 0; i < workplaceMobility.size(); ++i) {
				session.setAttribute(monthDays.get(i), workplaceMobility.get(i));
				//System.out.print(monthDays.get(i)+": "+workplaceMobility.get(i) + "\n");
				dayTrack = i;
			}
			for(int i = 0; i < publicTransitMobility.size(); ++i) {
				session.setAttribute(monthDays1.get(i), publicTransitMobility.get(i));
				System.out.print(monthDays1.get(i)+": "+publicTransitMobility.get(i) + "\n");
				dayTrack1 = i;
			}
			System.out.print("days accounted: "+ (dayTrack+1) + "\n");
			System.out.print("workplaceMobility.size: "+workplaceMobility.size() + "\n");
			System.out.print("publicTransitMobility.size: "+publicTransitMobility.size() + "\n");
			System.out.print("monthDays.size: "+monthDays.size() + "\n");
			
			if( workplaceMobility.size() < 31) {
				System.out.print("zero fill entered\n");
				for(int i = dayTrack; i < monthDays.size(); ++i) {
					session.setAttribute(monthDays.get(i), 0.0);
					++dayTrack;
				}
			}
			if( publicTransitMobility.size() < 31) {
				System.out.print("second zero fill entered\n");
				for(int i = dayTrack1; i < monthDays1.size(); ++i) {
					session.setAttribute(monthDays1.get(i), 0.0);
					++dayTrack1;
				}
			}
		}
//		else if (richPoor_testing != null)
//		{
//			gdps = currentFile.getGDP_perCountry();
//			isos = currentFile.getIsos();
//			tests = currentFile.getTests_perCountry();
//			
//			bubbleSort(gdps, isos, tests);
//			
//			pieChart_dataSet = new DefaultPieDataset();
//			
//			labels = new String[10];
//			
//			int i  = 0, j = tests.length-1;
//			while (i < 5 && j > -1) //top 5 richest countries with tests greater than 0
//			{
//				if (tests[j] > 0)
//				{
//					//label = "Rich Country: " + isos[j] + "\n" + "Tests: " + tests[j] + "\n" + "GDP: " + gdps[j];
//					label = "First World Country: " + isos[j];
//					labels[i] = label;
//					
//					pieChart_dataSet.setValue(label, tests[j]);
//					i++;
//					
//					System.out.println("Country: " + isos[j]);
//					System.out.println("Tests: " + tests[j]);
//					System.out.println("GDP: " + gdps[j]);
//				}
//				
//				j--;
//			}
//			
//			//i  = 0;
//			j = 0;
//			while (i < 10 && j < tests.length) //top 5 poorest countries with tests greater than 0
//			{
//				if (tests[j] > 0)
//				{
//					//label = "Poor Country: " + isos[j] + "\n" + "Tests: " + tests[j] + "\n" + "GDP: " + gdps[j];
//					label = "Developing Country: " + isos[j];
//					labels[i] = label;
//					
//					pieChart_dataSet.setValue(label, tests[j]);
//					i++;
//					
//					System.out.println("Country: " + isos[j]);
//					System.out.println("Number of Tests: " + tests[j]);
//					System.out.println("GDP: " + gdps[j]);
//				}
//				
//				j++;
//			}
//			
//			testing_pieChart = ChartFactory.createPieChart("Top 5 First World and Developing Countries With Their Respective Test Count Proportions", pieChart_dataSet, true, true, false);
//			
//			PiePlot plot = (PiePlot) testing_pieChart.getPlot();
//			for (i = 0; i < 10; i++)
//			{
//				if (i < 5)
//					plot.setSectionPaint(labels[i], new Color(1.0f, 0.0f, 0.0f, 0.2f*(i+1))); 
//				else
//					plot.setSectionPaint(labels[i], new Color(0.0f, 0.0f, 1.0f, 0.2f*((i%5)+1)));
//			}
//			
//			bufferedImage = testing_pieChart.createBufferedImage(500, 500);
//			ChartUtilities.writeBufferedImageAsPNG(response.getOutputStream(), bufferedImage);
//					
//			response.getOutputStream().close();
//		}
		else if (richPoor_testing != null)
		{
			pieChart_dataSet = new DefaultPieDataset();
			
			labels = new String[10];
			
			int i  = 0, j = dataStruct_IncrDesign.length-1;
			while (i < 5 && j > -1) //top 5 richest countries with tests greater than 0
			{
				if (dataStruct_IncrDesign[j].totalTests > 0)
				{
					//label = "Rich Country: " + isos[j] + "\n" + "Tests: " + tests[j] + "\n" + "GDP: " + gdps[j];
					label = "Rich Country: " + dataStruct_IncrDesign[j].countryName +  "\n" + "Tests: " + dataStruct_IncrDesign[j].totalTests;
					labels[i] = label;
					
					pieChart_dataSet.setValue(label, dataStruct_IncrDesign[j].totalTests);
					i++;
					
					System.out.println("Country: " + dataStruct_IncrDesign[j].countryName);
					System.out.println("Tests: " + dataStruct_IncrDesign[j].totalTests);
					System.out.println("GDP: " + dataStruct_IncrDesign[j].GDP);
				}
				
				j--;
			}
			
			j = 0;
			while (i < 10 && j < dataStruct_IncrDesign.length) //top 5 poorest countries with tests greater than 0
			{
				if (dataStruct_IncrDesign[j].totalTests > 0)
				{
					//label = "Poor Country: " + isos[j] + "\n" + "Tests: " + tests[j] + "\n" + "GDP: " + gdps[j];
					label = "Poor Country: " + dataStruct_IncrDesign[j].countryName +  "\n" + "Tests: " + dataStruct_IncrDesign[j].totalTests;
					labels[i] = label;
					
					pieChart_dataSet.setValue(label, dataStruct_IncrDesign[j].totalTests);
					i++;
					
					System.out.println("Country: " + dataStruct_IncrDesign[j].countryName);
					System.out.println("Tests: " + dataStruct_IncrDesign[j].totalTests);
					System.out.println("GDP: " + dataStruct_IncrDesign[j].GDP);
				}
				
				j++;
			}
			
			testing_pieChart = ChartFactory.createPieChart("Top 5 Richest and Poorest Countries With Their Respective Test Count Proportions", pieChart_dataSet, true, true, false);
			
			PiePlot plot = (PiePlot) testing_pieChart.getPlot();
			for (i = 0; i < 10; i++)
			{
				if (i < 5)
					plot.setSectionPaint(labels[i], new Color(1.0f, 0.0f, 0.0f, 0.2f*(i+1))); //red = rich
				else
					plot.setSectionPaint(labels[i], new Color(0.0f, 0.0f, 1.0f, 0.2f*((i%5)+1))); //blue = poor
			}
			
			bufferedImage = testing_pieChart.createBufferedImage(1000, 1000);
			ChartUtilities.writeBufferedImageAsPNG(response.getOutputStream(), bufferedImage);
			
			long endTime = System.currentTimeMillis();
			System.out.println("Elapsed Time in milliseconds: " + (endTime - startTime));
					
			response.getOutputStream().close();
		}
		else
		{
			response.sendError(404, "Error!!!");
			return;
		}
		
		if(search)
		{
			//System.out.print("search selected\n");
			session.setAttribute("columnNames", fileManager.getCurrent_covidFile().getColumnNames());
			session.setAttribute("table", table);
			
			
			response.sendRedirect("displayResultsPage.jsp");
		}
		else if(isCasesVsDeaths)
		{
			//System.out.print("iscasevsdeath selected\n");
			request.getRequestDispatcher("casesVsDeathsPage.jsp").forward(request,response);
		}
		else if(isAllMobilityTrends)
		{	
			request.getRequestDispatcher("allMobilityTrendsPage.jsp").forward(request,response);
		}
		else if(isCountryCasesVSDeaths) {
			request.getRequestDispatcher("countryCasesVSDeathsPage.jsp").forward(request,response);
		}
		else if (isMultiGraph) {
			System.out.print("multigraph selected\n");
			request.getRequestDispatcher("workPlacesVSTransportation.jsp").forward(request, response);
		}
		else if(isCasesVsMobility)
		{
			request.getRequestDispatcher("casesVsMobility.jsp").forward(request,response);
		}
		else if (isWorldwideMobilityTrends) {
			request.getRequestDispatcher("worldwideMobilityTrendsPage.jsp").forward(request,response);
		}
	}
	
//	private static void bubbleSort(double[] gdps, String[] isos, int[] tests) 
//	{
//		int lastPos, index, tempTest;
//		double tempGDP;
//		String tempISO;
//		
//		for (lastPos = gdps.length - 1; lastPos >= 0; lastPos--)
//		{
//			for (index = 0; index <= lastPos - 1; index++)
//			{
//				if (gdps[index] > gdps[index + 1]) 
//				{
//					tempGDP = gdps[index]; 
//					gdps[index] = gdps[index + 1]; 
//					gdps[index + 1] = tempGDP;
//					
//					tempISO = isos[index];
//					isos[index] = isos[index + 1];
//					isos[index + 1] = tempISO;
//					
//					tempTest = tests[index];
//					tests[index] = tests[index + 1];
//					tests[index + 1] = tempTest;
//				}
//			}
//		}
//	}
}