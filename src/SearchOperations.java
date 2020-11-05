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
		String countryCasesVSDeaths = request.getParameter("countryCasesVSDeaths");
		String multiGraph = request.getParameter("multiGraph");
		
		boolean isMultiGraph = false;
		boolean isCasesVsDeaths = false;
		boolean isCountryCasesVSDeaths = false;
		boolean search = false;
		String country = null;
		String startDate = null;
		String endDate = null;
		
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
			
		} else if (countryCasesVSDeaths != null) {
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
			double[][] table1;
			double[][] table2;
			
			isMultiGraph = true;
			table1 = fileManager.getCurrent_covidFile().getCountryWorkplaceTrends(request.getParameter("countries"));
			table2 = fileManager.getCurrent_covidFile().getCountryPublicTransportTrends(request.getParameter("countries"));
			
			session.setAttribute("Workplace Mobility Trends", table1);
			session.setAttribute("Public Transit Mobility Trends", table2);
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
		else if(isCountryCasesVSDeaths) {
			request.getRequestDispatcher("countryCasesVSDeathsPage.jsp").forward(request,response);
		}
		else if (isMultiGraph) {
			request.getRequestDispatcher("workPlacesVSTransportation.jsp").forward(request, response);
		}
	}
}