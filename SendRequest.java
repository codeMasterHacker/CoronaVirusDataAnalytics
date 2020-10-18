package cs180_lab3;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendRequest extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public SendRequest() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Request Received From Client");
		response.setContentType("text/html");
		PrintWriter output = response.getWriter();
		output.println("<html>");
		output.println("<head>");
		output.println("<title>" + "Corona Virus Data" + "</title>"); 
		output.println("</head>");
		output.println("<body>");
		output.println("<h1>Welcome to Our Corona Virus Website</h1>");
		output.println("<form action=\"SendRequest\" method=\"get\"> ");
		output.println("<button>Send Request to Server</button></form>");
		output.println("<h2>Hello From Server</h2>");
		output.println("</body>");
		output.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}