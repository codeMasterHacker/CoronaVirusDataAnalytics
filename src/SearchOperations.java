import java.io.*;
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
			fileManager = new CovidFileManager("/Users/Enrique/Desktop/codeFolders/Java/cs180project-022-it-s-corona-time/WebContent/covidFiles");
		
		String searchOp1 = request.getParameter("submit1");
		String searchOp2 = request.getParameter("submit2");
		String searchOp3 = request.getParameter("submit3");
		String searchOp4 = request.getParameter("submit4");
		String searchOp5 = request.getParameter("submit5");
		String searchOp6 = request.getParameter("submit6");
		String importData = request.getParameter("importData");
		
		String country = null;
		String startDate = null;
		String endDate = null;
		
		String[][] table = null;
		
		if (searchOp1 != null)
		{
			country = request.getParameter("countries");
			startDate = request.getParameter("startDate");
			endDate = request.getParameter("endDate");
			
			table = fileManager.getCurrent_covidFile().read_allColumns(country, startDate, endDate);
		}
		else if (searchOp2 != null)
		{
			country = request.getParameter("countries");
			startDate = request.getParameter("startDate");
			endDate = request.getParameter("endDate");
			
			table = fileManager.getCurrent_covidFile().read_casesDeaths(country, startDate, endDate);
		}
		else if (searchOp3 != null)
			table = fileManager.getCurrent_covidFile().read_testsPop(request.getParameter("countries"));
		else if (searchOp4 != null)
			table = fileManager.getCurrent_covidFile().readCountries_lessHealth(Double.parseDouble(request.getParameter("healthIndices")));
		else if (searchOp5 != null)
			table = fileManager.getCurrent_covidFile().read_baseLines(request.getParameter("countries"));
		else if (searchOp6 != null)
			table = fileManager.getCurrent_covidFile().readCountries_greater65pop(Double.parseDouble(request.getParameter("percents")));
		else if (importData != null)
		{
			if(fileManager.goto_previousFile())
				response.sendRedirect("searchOperationsPage.jsp");
			else
				response.sendError(404, "This is the only file left, there are no more previous versions of the data");
			return;
		}
		else
		{
			response.sendError(404, "Error!!!");
			return;
		}
		
		session.setAttribute("columnNames", fileManager.getCurrent_covidFile().getColumnNames());
		session.setAttribute("table", table);
		
		response.sendRedirect("displayResultsPage.jsp");
	}
}