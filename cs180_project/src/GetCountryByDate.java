import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetCountryByDate extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public GetCountryByDate() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		
		CSVparser parser = (CSVparser)session.getAttribute("parser");
		
		if(parser == null)
			parser = new CSVparser("/Users/Enrique/Downloads/COVID-19.csv", 31965, 19);
		
		String country = request.getParameter("countries");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		
		String[][]countryByDateTable = parser.parse(country, startDate, endDate);
		
		session.setAttribute("columnNames", parser.getColumnNames());
		session.setAttribute("countryByDateTable", countryByDateTable);
		
		response.sendRedirect("displayResultsPage.jsp");
	}
}
