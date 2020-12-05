import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EditServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public EditServlet() 
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		
		CovidFileManager fileManager = (CovidFileManager)session.getAttribute("fileManager");
		
		if (fileManager == null) //first time using
		{
			fileManager = new CovidFileManager("C:\\Users\\Enrique Munoz\\eclipse-workspace\\cs180project-022-it-s-corona-time\\WebContent\\covidFiles");
			//fileManager = new CovidFileManager("/Users/jesword/git/cs180project-022-it-s-corona-time/WebContent/covidFiles");
			session.setAttribute("fileManager", fileManager);
			session.setAttribute("dataStruct_IncrDesign", fileManager.getCurrent_covidFile().get_dataStruct_incrDesign());
		}
		
		DataStruct_IncrDesign[] dataStruct_IncrDesign = (DataStruct_IncrDesign[])session.getAttribute("dataStruct_IncrDesign");
		int[] tests  = {0};
		
		String insert = request.getParameter("insert");
		String update = request.getParameter("update");
		String delete = request.getParameter("delete");
		String nonupdateValue = "*";
		
		String iso = request.getParameter("iso");
		if (iso == null || iso.isEmpty())
			iso = nonupdateValue;
		
		String country = request.getParameter("country");
		if (country == null || country.isEmpty())
			country = nonupdateValue;
		
		String date = request.getParameter("date");
		if (date == null || date.isEmpty())
			date = nonupdateValue;
		
		String groceryPharmacy_percentChange = request.getParameter("groceryPharmacy_percentChange");
		if (groceryPharmacy_percentChange == null || groceryPharmacy_percentChange.isEmpty())
			groceryPharmacy_percentChange = nonupdateValue;
		
		String parks_percentChange = request.getParameter("parks_percentChange");
		if (parks_percentChange == null || parks_percentChange.isEmpty())
			parks_percentChange = nonupdateValue;
		
		String residential_percentChange = request.getParameter("residential_percentChange");
		if (residential_percentChange == null || residential_percentChange.isEmpty())
			residential_percentChange = nonupdateValue;
		
		String retailRec_percentChange = request.getParameter("retailRec_percentChange");
		if (retailRec_percentChange == null || retailRec_percentChange.isEmpty())
			retailRec_percentChange = nonupdateValue;
		
		String transitStations_percentChange = request.getParameter("transitStations_percentChange");
		if (transitStations_percentChange == null || transitStations_percentChange.isEmpty())
			transitStations_percentChange = nonupdateValue;
		
		String workPlaces_percentChange = request.getParameter("workPlaces_percentChange");
		if (workPlaces_percentChange == null || workPlaces_percentChange.isEmpty())
			workPlaces_percentChange = nonupdateValue;
		
		String confirmedCases = request.getParameter("confirmedCases");
		if (confirmedCases == null || confirmedCases.isEmpty())
			confirmedCases = nonupdateValue;
		
		String confirmedDeaths = request.getParameter("confirmedDeaths");
		if (confirmedDeaths == null || confirmedDeaths.isEmpty())
			confirmedDeaths = nonupdateValue;
		
		String govRes_stringIndex = request.getParameter("govRes_stringIndex");
		if (govRes_stringIndex == null || govRes_stringIndex.isEmpty())
			govRes_stringIndex = nonupdateValue;
		
		String totalTests = request.getParameter("totalTests");
		if (totalTests == null || totalTests.isEmpty())
			totalTests = nonupdateValue;
		
		String gdpCapita = request.getParameter("gdpCapita");
		if (gdpCapita == null || gdpCapita.isEmpty())
			gdpCapita = nonupdateValue;
		
		String population = request.getParameter("population");
		if (population == null || population.isEmpty())
			population = nonupdateValue;
		
		String populationDensity = request.getParameter("populationDensity");
		if (populationDensity == null || populationDensity.isEmpty())
			populationDensity = nonupdateValue;
		
		String humanDev_index = request.getParameter("humanDev_index");
		if (humanDev_index == null || humanDev_index.isEmpty())
			humanDev_index = nonupdateValue;
		
		String percentPop_above65 = request.getParameter("percentPop_above65");
		if (percentPop_above65 == null || percentPop_above65.isEmpty())
			percentPop_above65 = nonupdateValue;
		
		String healthIndex = request.getParameter("healthIndex");
		if (healthIndex == null || healthIndex.isEmpty())
			healthIndex = nonupdateValue;
		
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
		{
			worked = fileManager.insert(row);
			
			if (!totalTests.equals(nonupdateValue))
			{
				for(int i = 0; i < dataStruct_IncrDesign.length; i++)
				{
					if (country.equals(dataStruct_IncrDesign[i].countryName))
					{
						dataStruct_IncrDesign[i].totalTests = Integer.parseInt(totalTests);
						break;
					}
				}
			}
		}
		else if (update != null)
		{
			//worked = fileManager.update(row, tests);
			
			if (!totalTests.equals(nonupdateValue))
			{
				for(int i = 0; i < dataStruct_IncrDesign.length; i++)
				{
					if (country.equals(dataStruct_IncrDesign[i].countryName))
					{
						dataStruct_IncrDesign[i].totalTests = dataStruct_IncrDesign[i].totalTests + tests[0];
						break;
					}
				}
			}
			
			if (!gdpCapita.equals(nonupdateValue)) //if some decides to update the GDP of a country, then sort the array, but this is HIGHLY HIGHLY HIGHLY UNREALISTIC
				bubbleSort(dataStruct_IncrDesign); //since the GDP of a country does not change in a single day, but you never know though
		}
		else if (delete != null)
		{
			//worked = fileManager.delete(country, date, tests);
			
			for(int i = 0; i < dataStruct_IncrDesign.length; i++)
			{
				if (country.equals(dataStruct_IncrDesign[i].countryName))
				{
					dataStruct_IncrDesign[i].totalTests = dataStruct_IncrDesign[i].totalTests - tests[0];
					break;
				}
			}
		}
		
		if (!worked)
			response.sendError(404, "Edit Operation Failed!!!");
		else
			response.sendRedirect("index.jsp");
	}
	
	private void bubbleSort(DataStruct_IncrDesign[] array)
	{
		int lastPos, index;
		DataStruct_IncrDesign temp;
		
		for (lastPos = array.length - 1; lastPos >= 0; lastPos--)
		{
			for (index = 0; index <= lastPos - 1; index++)
			{
				if (array[index].GDP > array[index + 1].GDP)
				{
					temp = array[index];
					array[index] = array[index + 1];
					array[index + 1] = temp;
					
					array[index].gdpRank = index+1;
					array[index + 1].gdpRank = index+2;
				}
			}
		}
	}
}