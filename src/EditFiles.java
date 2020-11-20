import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EditFiles extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public EditFiles() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		
		CovidFileManager fileManager = (CovidFileManager)session.getAttribute("fileManager");
		
		if (fileManager == null)
		{
			//fileManager = new CovidFileManager("/Users/Enrique/Desktop/codeFolders/Java/cs180project-022-it-s-corona-time/WebContent/covidFiles");
			//fileManager = new CovidFileManager("C:\\Users\\Enrique Munoz\\eclipse-workspace\\cs180project-022-it-s-corona-time\\WebContent\\covidFiles");
			fileManager = new CovidFileManager("/Users/jesword/git/cs180project-022-it-s-corona-time/WebContent/covidFiles");
		}
		
		String insert = request.getParameter("submit1");
		String update = request.getParameter("submit2");
		String delete = request.getParameter("submit3");
		
		String iso = request.getParameter("iso");
		if (iso == null || iso.isEmpty())
			iso = "*";
		
		String country = request.getParameter("country");
		if (country == null || country.isEmpty())
			country = "*";
		
		String date = request.getParameter("date");
		if (date == null || date.isEmpty())
			date = "*";
		
		String groceryPharmacy_percentChange = request.getParameter("groceryPharmacy_percentChange");
		if (groceryPharmacy_percentChange == null || groceryPharmacy_percentChange.isEmpty())
			groceryPharmacy_percentChange = "*";
		
		String parks_percentChange = request.getParameter("parks_percentChange");
		if (parks_percentChange == null || parks_percentChange.isEmpty())
			parks_percentChange = "*";
		
		String residential_percentChange = request.getParameter("residential_percentChange");
		if (residential_percentChange == null || residential_percentChange.isEmpty())
			residential_percentChange = "*";
		
		String retailRec_percentChange = request.getParameter("retailRec_percentChange");
		if (retailRec_percentChange == null || retailRec_percentChange.isEmpty())
			retailRec_percentChange = "*";
		
		String transitStations_percentChange = request.getParameter("transitStations_percentChange");
		if (transitStations_percentChange == null || transitStations_percentChange.isEmpty())
			transitStations_percentChange = "*";
		
		String workPlaces_percentChange = request.getParameter("workPlaces_percentChange");
		if (workPlaces_percentChange == null || workPlaces_percentChange.isEmpty())
			workPlaces_percentChange = "*";
		
		String confirmedCases = request.getParameter("confirmedCases");
		if (confirmedCases == null || confirmedCases.isEmpty())
			confirmedCases = "*";
		
		String confirmedDeaths = request.getParameter("confirmedDeaths");
		if (confirmedDeaths == null || confirmedDeaths.isEmpty())
			confirmedDeaths = "*";
		
		String govRes_stringIndex = request.getParameter("govRes_stringIndex");
		if (govRes_stringIndex == null || govRes_stringIndex.isEmpty())
			govRes_stringIndex = "*";
		
		String totalTests = request.getParameter("totalTests");
		if (totalTests == null || totalTests.isEmpty())
			totalTests = "*";
		
		String gdpCapita = request.getParameter("gdpCapita");
		if (gdpCapita == null || gdpCapita.isEmpty())
			gdpCapita = "*";
		
		String population = request.getParameter("population");
		if (population == null || population.isEmpty())
			population = "*";
		
		String populationDensity = request.getParameter("populationDensity");
		if (populationDensity == null || populationDensity.isEmpty())
			populationDensity = "*";
		
		String humanDev_index = request.getParameter("humanDev_index");
		if (humanDev_index == null || humanDev_index.isEmpty())
			humanDev_index = "*";
		
		String percentPop_above65 = request.getParameter("percentPop_above65");
		if (percentPop_above65 == null || percentPop_above65.isEmpty())
			percentPop_above65 = "*";
		
		String healthIndex = request.getParameter("healthIndex");
		if (healthIndex == null || healthIndex.isEmpty())
			healthIndex = "*";
		
		String row = iso + "," + 
				 	 country + "," + 
				 	 date + "," +
				 	 groceryPharmacy_percentChange + "," +
				 	 parks_percentChange + "," +
				 	 residential_percentChange + "," +
				 	 retailRec_percentChange + "," +
				 	 transitStations_percentChange + "," +
				 	 workPlaces_percentChange + "," +
				 	 confirmedCases + "," +
				 	 confirmedDeaths + "," +
				 	 govRes_stringIndex + "," +
				 	 totalTests + "," +
				 	 gdpCapita + "," +
				 	 population + "," +
				 	 populationDensity + "," +
				 	 humanDev_index + "," +
				 	 percentPop_above65 + "," +
				 	 healthIndex;
		
		boolean worked = false;
		
		if (insert != null)
			worked = fileManager.insert(row);
		else if (update != null)
			worked = fileManager.update(row);
		else if (delete != null)
			worked = fileManager.delete(country, date);
		else
		{
			response.sendError(404, "Error!!!");
			return;
		}
		
		session.setAttribute("worked", worked);
		
		response.sendRedirect("searchOperationsPage.jsp");
	}
}