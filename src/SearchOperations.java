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
		
		CSVparser parser = (CSVparser)session.getAttribute("parser");
		
		if (parser == null)
			parser = new CSVparser("/Users/Enrique/Desktop/codeFolders/Java/cs180project-022-it-s-corona-time/WebContent/COVID-19.csv", 31965, 19);
		
		String searchOp1 = request.getParameter("submit1");
		String searchOp2 = request.getParameter("submit2");
		String searchOp3 = request.getParameter("submit3");
		String searchOp4 = request.getParameter("submit4");
		String searchOp5 = request.getParameter("submit5");
		String searchOp6 = request.getParameter("submit6");
		
		String country = null;
		String startDate = null;
		String endDate = null;
		
		String[][] table = null;
		
		if (searchOp1 != null)
		{
			country = request.getParameter("countries");
			startDate = request.getParameter("startDate");
			endDate = request.getParameter("endDate");
			
			table = parser.getAll(country, startDate, endDate);
		}
		else if (searchOp2 != null)
		{
			country = request.getParameter("countries");
			startDate = request.getParameter("startDate");
			endDate = request.getParameter("endDate");
			
			table = parser.get_casesDeaths(country, startDate, endDate);
		}
		else if (searchOp3 != null)
			table = parser.get_testsPop(request.getParameter("countries"));
		else if (searchOp4 != null)
			table = parser.getCountries_healthIndex(Double.parseDouble(request.getParameter("healthIndices")));
		else if (searchOp5 != null)
			table = parser.getBaselines(request.getParameter("countries"));
		else if (searchOp6 != null)
			table = parser.getCountries_65pop(Double.parseDouble(request.getParameter("percents")));
		else
		{
			response.sendError(404, "Error!!!");
			return;
		}
		
		session.setAttribute("columnNames", parser.getColumnNames());
		session.setAttribute("table", table);
		
		response.sendRedirect("displayResultsPage.jsp");
	}
}