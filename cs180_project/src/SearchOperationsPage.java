import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SearchOperationsPage extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public SearchOperationsPage() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		
		CSVparser parser = new CSVparser("/Users/Enrique/Desktop/codeFolders/Java/cs180_project/WebContent/COVID-19.csv", 31965, 19);
		
		session.setAttribute("parser", parser);
		
		response.sendRedirect("searchOperationsPage.jsp");
	}
}
