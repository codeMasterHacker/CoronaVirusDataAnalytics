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
//		HttpSession session = request.getSession(true);
//		
//		CovidFileManager fileManager = (CovidFileManager)session.getAttribute("fileManager");
//		
//		if (fileManager == null)
//		{
//			//fileManager = new CovidFileManager("/Users/Enrique/Desktop/codeFolders/Java/cs180project-022-it-s-corona-time/WebContent/covidFiles");
//			//fileManager = new CovidFileManager("C:\\Users\\Enrique Munoz\\eclipse-workspace\\cs180project-022-it-s-corona-time\\WebContent\\covidFiles");
//
//			//fileManager = new CovidFileManager("/Users/celyna/cs180project-022-it-s-corona-time/WebContent/covidFiles/");
//			//fileManager = new CovidFileManager("/Users/jesword/git/cs180project-022-it-s-corona-time/WebContent/covidFiles");
//
//			fileManager = new CovidFileManager("/Users/jesword/git/cs180project-022-it-s-corona-time/WebContent/covidFiles");
//
//			//fileManager = new CovidFileManager("E:\\Luccas\\Documents\\docs_2\\UCR Docs\\Fall_2020\\cs180\\cs180_project\\cs180project-022-it-s-corona-time\\WebContent\\covidFiles");
//			//fileManager = new CovidFileManager("/Users/cristinalawson/eclipse-workspace/cs180_project/WebContent/covidFiles");
//			session.setAttribute("fileManager", fileManager);
//		}
		
		response.sendRedirect("searchOperationsPage.jsp");
	}
}