import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.general.*;

public class ChartServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ChartServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		long startTime = System.currentTimeMillis();
		
		HttpSession session = request.getSession(true);
		
		CovidFileManager fileManager = (CovidFileManager)session.getAttribute("fileManager");
		
		if (fileManager == null) //first time using
		{
			fileManager = new CovidFileManager("C:\\Users\\Enrique Munoz\\eclipse-workspace\\cs180project-022-it-s-corona-time\\WebContent\\covidFiles");
			session.setAttribute("fileManager", fileManager);
			session.setAttribute("dataStruct_IncrDesign", fileManager.getCurrent_covidFile().get_dataStruct_incrDesign());
		}
		
		DataStruct_IncrDesign[] dataStruct_IncrDesign = (DataStruct_IncrDesign[])session.getAttribute("dataStruct_IncrDesign");
		
		String richPoor_testing = request.getParameter("richPoor_testing");
		String label = null;
		String[] labels = null;
		DefaultPieDataset pieChart_dataSet = null;
		JFreeChart testing_pieChart = null;
		BufferedImage bufferedImage = null;
		
		if (richPoor_testing != null)
		{
			pieChart_dataSet = new DefaultPieDataset();
			
			labels = new String[10];
			
			int i  = 0, j = dataStruct_IncrDesign.length-1;
			while (i < 5 && j > -1) //top 5 richest countries with tests greater than 0
			{
				if (dataStruct_IncrDesign[j].totalTests > 0)
				{
					//label = "Rich Country: " + isos[j] + "\n" + "Tests: " + tests[j] + "\n" + "GDP: " + gdps[j];
					label = "Rich Country: " + dataStruct_IncrDesign[j].countryName;
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
					label = "Poor Country: " + dataStruct_IncrDesign[j].countryName;
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
			
			bufferedImage = testing_pieChart.createBufferedImage(500, 500);
			ChartUtilities.writeBufferedImageAsPNG(response.getOutputStream(), bufferedImage);
			
			long endTime = System.currentTimeMillis();
			System.out.println("Elapsed Time in milliseconds: " + (endTime - startTime));
					
			response.getOutputStream().close();
		}
		else
			response.sendError(404, "Error!!!");
	}
}