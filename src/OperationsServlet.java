import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OperationsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public OperationsServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		HttpSession session = request.getSession(true);
//		
//		CovidFileManager fileManager = (CovidFileManager)session.getAttribute("fileManager");
//		
//		if (fileManager == null) //first time using
//		{
//			fileManager = new CovidFileManager("C:\\Users\\Enrique Munoz\\eclipse-workspace\\cs180project-022-it-s-corona-time\\WebContent\\covidFiles");
//			session.setAttribute("fileManager", fileManager);
//			session.setAttribute("dataStruct_IncrDesign", fileManager.getCurrent_covidFile().get_dataStruct_incrDesign());
//		}
		
		String analytic = request.getParameter("analytic");
		String search = request.getParameter("search");
		String edit = request.getParameter("edit");
		
		if (analytic != null)
			response.sendRedirect("analyticJSP.jsp");
		else if (search != null)
			response.sendRedirect("searchJSP.jsp");
		else if (edit != null)
			response.sendRedirect("editJSP.jsp");
		else
			response.sendError(505, "A button was not selected. ERROR!!!");
	}
}