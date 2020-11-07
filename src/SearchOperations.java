import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SearchOperations extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public SearchOperations() 
    {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		
		CovidFileManager fileManager = (CovidFileManager)session.getAttribute("fileManager");
		
		if (fileManager == null)
		{
			//fileManager = new CovidFileManager("/Users/cristinalawson/eclipse-workspace/cs180_project/WebContent/covidFiles");

			fileManager = new CovidFileManager("E:\\Luccas\\Documents\\docs_2\\UCR Docs\\Fall_2020\\cs180\\cs180_project\\cs180project-022-it-s-corona-time\\WebContent\\covidFiles");

			//fileManager = new CovidFileManager("/Users/jesword/git/cs180project-022-it-s-corona-time/WebContent/covidFiles");

			//fileManager = new CovidFileManager("/Users/jesword/git/cs180project-022-it-s-corona-time/WebContent/covidFiles");

			//fileManager = new CovidFileManager("/Users/Enrique/Desktop/codeFolders/Java/cs180project-022-it-s-corona-time/WebContent/covidFiles");
		}
		
		String searchOp1 = request.getParameter("submit1");
		String searchOp2 = request.getParameter("submit2");
		String searchOp3 = request.getParameter("submit3");
		String searchOp4 = request.getParameter("submit4");
		String searchOp5 = request.getParameter("submit5");
		String searchOp6 = request.getParameter("submit6");
		String importData = request.getParameter("importData");
		String casesVsDeaths = request.getParameter("casesVsDeaths");
		String allMobilityTrends = request.getParameter("mobilityTrends");
		String countryCasesVSDeaths = request.getParameter("countryCasesVSDeaths");
		String multiGraph = request.getParameter("multiGraph");
		String casesVsMobility = request.getParameter("casesVsMobility");

		
		boolean isMultiGraph = false;
		boolean isCasesVsDeaths = false;
		boolean isAllMobilityTrends = false;
		boolean isCountryCasesVSDeaths = false;
		boolean search = false;
		boolean isCasesVsMobility = false;
		String country = null;
		String startDate = null;
		String endDate = null;
		String month = null;
		
		String[][] table = null;
		//String[][] table1 = null;
		//String[][] table2 = null;
		
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
			isCasesVsDeaths = true;
			double cases = 0;
			double deaths = 0;
			double casesVsDeathPercent = 0.0;
			
			cases = fileManager.getCurrent_covidFile().getCases();
			deaths = fileManager.getCurrent_covidFile().getDeaths();
			casesVsDeathPercent = (deaths / cases) * 100;
			session.setAttribute("Cases", cases);
			session.setAttribute("Deaths", deaths);
			session.setAttribute("CasesVsDeathPercent", casesVsDeathPercent);
			
		} 
		else if(allMobilityTrends != null)
		{
			isAllMobilityTrends = true;
			country = request.getParameter("countries");
			session.setAttribute("country", country);
			
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
		else if(casesVsMobility != null)
		{
			isCasesVsMobility = true;
			country = request.getParameter("countries");
			String mobility = request.getParameter("mobility");
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
			
			for(int i = 0; i < cases.size(); i++)
			{
				System.out.println("Cases: " + cases.get(i) + " |  Mobility: " + mobilityAvg.get(i));
			}
				
			
		}
		else if (countryCasesVSDeaths != null) {
			isCountryCasesVSDeaths = true;
			double cases = 0;
			double deaths = 0;
			double countryCasesVSDeathPercent = 0.0;
			
			cases = fileManager.getCurrent_covidFile().getCountryCases(request.getParameter("countries"));
			deaths = fileManager.getCurrent_covidFile().getCountryDeaths(request.getParameter("countries"));
			countryCasesVSDeathPercent = (deaths / cases) * 100;
			session.setAttribute("Cases", cases);
			session.setAttribute("Deaths", deaths);
			session.setAttribute("CountryCasesVsDeathPercent", countryCasesVSDeathPercent);
			
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
					
			ArrayList<Double> workplaceMobility = new ArrayList<Double>();
			ArrayList<Double> publicTransitMobility = new ArrayList<Double>();
			
			isMultiGraph = true;
			workplaceMobility = fileManager.getCurrent_covidFile().getCountryWorkplaceTrends(country, month);
			//table2 = fileManager.getCurrent_covidFile().getCountryPublicTransportTrends(request.getParameter("countries"));
			
			session.setAttribute("country", country);
			session.setAttribute("mobility", month);
			
			session.setAttribute("1", workplaceMobility.get(0));
			session.setAttribute("2", workplaceMobility.get(1));
			session.setAttribute("3",workplaceMobility.get(2));
			session.setAttribute("4", workplaceMobility.get(3));
			session.setAttribute("5", workplaceMobility.get(4));
			/*for(int i = 0; i < workplaceMobility.size(); ++i) {
				if(workplaceMobility.size() < 31)
				session.setAttribute(String.valueOf(i), workplaceMobility.get(i));
			}
			if(workplaceMobility.size() < 31) {
				for(int i = workplaceMobility.size(); i < 31; ++i) {
					session.setAttribute(String.valueOf(i), 0.0);
				}
			}*/
			//session.setAttribute("Workplace Mobility Trends", table1);
			//session.setAttribute("Public Transit Mobility Trends", table2);
		}
		else
		{
			response.sendError(404, "Error!!!");
			return;
		}
		
		if(search)
		{
			session.setAttribute("columnNames", fileManager.getCurrent_covidFile().getColumnNames());
			session.setAttribute("table", table);
			
			response.sendRedirect("displayResultsPage.jsp");
		}
		else if(isCasesVsDeaths)
		{
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
			request.getRequestDispatcher("workPlacesVSTransportation.jsp").forward(request, response);
		}
		else if(isCasesVsMobility)
		{
			request.getRequestDispatcher("casesVsMobility.jsp").forward(request,response);
		}
	}
}