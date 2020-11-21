import java.io.*;
import java.util.*;

public class CovidFile implements Serializable //will handle only reads
{
	private static final long serialVersionUID = 1L;
	private int cols; //no setters for this field
	private int rows; //no setters for this field
	
	private String[][] table; //no getters and setters for this field
	private String[] columnNames; //no setters for this field
	
	private DataStruct_IncrDesign[] dataStruct_incrDesign;
	
	private double[][] table1; //table for graphs
	
	private File covidFile; //no setters for this field
	
	
	public CovidFile(File file)
	{
		covidFile = file;
		cols = readColumns();
		
		String filePath = covidFile.getAbsolutePath();
		char ch = filePath.charAt(filePath.length()-6);
		// 6 because i want to look at the 6th char from the end, which will either be a digit or _
		// /Users/Enrique/Desktop/covidFiles/COVID-19.csv original
		// /Users/Enrique/Desktop/covidFiles/COVID-19_0.csv after cleaning original
		if (Character.isDigit(ch))
			rows = cleanData();
		else
			rows = countRows();
		
		columnNames = null; //will be set inside different read function and retrievable by its getter
		table = null; //will be set inside different read functions and be returned by them
	}
	
	public String[] getColumnNames() { return columnNames; }
	public int get_colNum() { return cols; }
	public int get_rowNum() { return rows; }
	public String[] get_columnNames() { return columnNames; }
	public File getFile() { return covidFile; }
	public DataStruct_IncrDesign[] get_dataStruct_incrDesign() { return dataStruct_incrDesign; }
	
	private int readColumns()
	{
		Scanner inputFile = null;
		
		try
		{
			inputFile = new Scanner(covidFile);
			columnNames = inputFile.nextLine().split(",");
			inputFile.close();
		}
		catch(IOException e) 
		{ 
			e.printStackTrace(); 
			return 0;
		}
		
		return columnNames.length;
	}
	
//	private int countRows() //original
//	{
//		Scanner inputFile = null;
//		int count = -1; ////-1 because I'm not counting the column names at the beginning
//		
//		try
//		{
//			inputFile = new Scanner(covidFile);
//			
//			while (inputFile.hasNext())
//			{
//				inputFile.nextLine();
//				count++;
//			}
//			
//			inputFile.close();
//		}
//		catch(IOException e) 
//		{ 
//			e.printStackTrace(); 
//			return 0;
//		}
//		
//		System.out.println(count);
//		return count;
//	}
	
	private int countRows() //copy
	{
		Scanner inputFile = null;
		int i = 0, count = -1; //-1 because I'm not counting the column names at the beginning
		
		final int isoIndex = 1, casesIndex = 9, deathsIndex = 10, testIndex = 12, gdpIndex = 13, numCountries = 133;
		String[] tokens = null;
		String[] previousTokens = null;
		
		dataStruct_incrDesign = null;
		
		try
		{
			inputFile = new Scanner(covidFile);
			dataStruct_incrDesign = new DataStruct_IncrDesign[numCountries];
			
			inputFile.nextLine(); //skips over the column names, which don't count toward the number of rows
			
			previousTokens = inputFile.nextLine().split(",");
			count++;
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				count++;
				
				//create the dataStruct_incrDesign array, which has fields countryName, totalTests, GDP, and gdpRank
				if (tokens[isoIndex].equals(previousTokens[isoIndex]))
				{
					previousTokens = tokens;
					continue;
				}
				
				if (i < numCountries)
				{
					dataStruct_incrDesign[i] = new DataStruct_IncrDesign();
					dataStruct_incrDesign[i].countryName = previousTokens[isoIndex];
					dataStruct_incrDesign[i].totalTests = (int) Double.parseDouble(previousTokens[testIndex]);
					dataStruct_incrDesign[i].GDP = Double.parseDouble(previousTokens[gdpIndex]);
					dataStruct_incrDesign[i].gdpRank = i;
					dataStruct_incrDesign[i].totalCases = (int) Double.parseDouble(previousTokens[casesIndex]);
					dataStruct_incrDesign[i].totalDeaths = (int) Double.parseDouble(previousTokens[deathsIndex]);
					i++;
				
					previousTokens = tokens;
				}
			}
			
			if (i < numCountries) //for last country
			{
				dataStruct_incrDesign[i] = new DataStruct_IncrDesign();
				dataStruct_incrDesign[i].countryName = previousTokens[isoIndex];
				dataStruct_incrDesign[i].totalTests =(int) Double.parseDouble(previousTokens[testIndex]);
				dataStruct_incrDesign[i].GDP = Double.parseDouble(previousTokens[gdpIndex]);
				dataStruct_incrDesign[i].gdpRank = i;
				dataStruct_incrDesign[i].totalCases = (int) Double.parseDouble(previousTokens[casesIndex]);
				dataStruct_incrDesign[i].totalDeaths = (int) Double.parseDouble(previousTokens[deathsIndex]);
				i++;
			
				previousTokens = tokens;
			}
			
			//sort dataStruct_incrDesign array based on gdp
			bubbleSort(dataStruct_incrDesign);
			
			inputFile.close();
		}
		catch(IOException e) 
		{ 
			e.printStackTrace(); 
			return 0;
		}
		
		System.out.println(count);
		return count;
	}
	
//	private int cleanData() //original
//	{
//		String[] tokens = null;
//		String[] temp = null;
//		String oldPath = covidFile.getAbsolutePath();
//		String newPath = null;
//		String missingValue = "-404.0";
//		
//		Scanner inputFile = null;
//		PrintWriter outputFile = null;
//		File newFile = null;
//		
//		StringBuilder path = null;
//		
//		int i = 0, fileSize = -1; //-1 because I'm not counting the column names at the beginning
//		
//		try
//		{
//			inputFile = new Scanner(covidFile);
//			
//			path = new StringBuilder(oldPath);
//			path.insert(oldPath.length()-4, "_0"); // ".csv" has 4 characters
//			
//			newPath = path.toString();
//			newFile = new File(newPath);
//			
//			outputFile = new PrintWriter(newFile);
//			
//			while (inputFile.hasNext())
//			{
//				tokens = inputFile.nextLine().split(",");
//				
//				for (i = 0; i < tokens.length; i++) //checks for empty strings
//				{
//					if (tokens[i].isEmpty())
//						tokens[i] = missingValue;
//				}
//				
//				if (tokens.length != cols) //missing values
//				{
//					temp = new String[cols];
//					
//					for (i = 0; i < tokens.length; i++) //copy tokens to temp
//						temp[i] = tokens[i];
//					
//					for (; i < temp.length; i++) //add missing value filler at the end
//						temp[i] = missingValue;
//					
//					tokens = temp;
//				}
//				
//				for (i = 0; i < tokens.length-1; i++)
//					outputFile.print(tokens[i] + ",");
//				outputFile.println(tokens[i]);
//				
//				fileSize++;
//			}
//			
//			inputFile.close();
//			outputFile.close();
//			
//			covidFile.delete(); //deletes bad data
//			covidFile = newFile; //reference covidFile to the new file created by the PrintWriter object
//			
//			System.out.println(fileSize);
//			
//			return fileSize;
//		}
//		catch(IOException e) 
//		{ 
//			e.printStackTrace(); 
//			inputFile.close();
//			return 0;
//		}
//	}
	
	
	
	private int cleanData() //copy
	{
		final int isoIndex = 1, casesIndex = 9, deathsIndex = 10, testIndex = 12, gdpIndex = 13, numCountries = 133;
		String[] tokens = null;
		String[] previousTokens = null;
		String[] temp = null;
		String oldPath = covidFile.getAbsolutePath();
		String newPath = null;
		String missingValue = "-404.0";
		
		Scanner inputFile = null;
		PrintWriter outputFile = null;
		File newFile = null;
		
		StringBuilder path = null;
		
		int i = 0, j = 0, fileSize = -1; //-1 because I'm not counting the column names at the beginning
		
		dataStruct_incrDesign = null;
		
		try
		{
			inputFile = new Scanner(covidFile);
			dataStruct_incrDesign = new DataStruct_IncrDesign[numCountries];
			
			path = new StringBuilder(oldPath);
			path.insert(oldPath.length()-4, "_0"); // ".csv" has 4 characters
			
			newPath = path.toString();
			newFile = new File(newPath);
			
			outputFile = new PrintWriter(newFile);
			
			previousTokens = inputFile.nextLine().split(","); //column names, which have perfect formatting
			
			for (i = 0; i < previousTokens.length-1; i++)
				outputFile.print(previousTokens[i] + ",");
			outputFile.println(previousTokens[i]);
			
			previousTokens = inputFile.nextLine().split(",");
			
			for (i = 0; i < previousTokens.length; i++) //checks for empty strings
			{
				if (previousTokens[i].isEmpty())
					previousTokens[i] = missingValue;
			}
			
			if (previousTokens.length != cols) //missing values
			{
				temp = new String[cols];
				
				for (i = 0; i < previousTokens.length; i++) //copy tokens to temp
					temp[i] = previousTokens[i];
				
				for (; i < temp.length; i++) //add missing value filler at the end
					temp[i] = missingValue;
				
				previousTokens = temp;
			}
			
			for (i = 0; i < previousTokens.length-1; i++)
				outputFile.print(previousTokens[i] + ",");
			outputFile.println(previousTokens[i]);
			
			fileSize++;
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				for (i = 0; i < tokens.length; i++) //checks for empty strings
				{
					if (tokens[i].isEmpty())
						tokens[i] = missingValue;
				}
				
				if (tokens.length != cols) //missing values
				{
					temp = new String[cols];
					
					for (i = 0; i < tokens.length; i++) //copy tokens to temp
						temp[i] = tokens[i];
					
					for (; i < temp.length; i++) //add missing value filler at the end
						temp[i] = missingValue;
					
					tokens = temp;
				}
				
				for (i = 0; i < tokens.length-1; i++)
					outputFile.print(tokens[i] + ",");
				outputFile.println(tokens[i]);
				
				fileSize++;
				
				//create the dataStruct_incrDesign array, which has fields countryName, totalTests, GDP, and gdpRank
				if (tokens[isoIndex].equals(previousTokens[isoIndex]))
				{
					previousTokens = tokens;
					continue;
				}
				
				if (j < numCountries)
				{
					dataStruct_incrDesign[j] = new DataStruct_IncrDesign();
					dataStruct_incrDesign[j].countryName = previousTokens[isoIndex];
					dataStruct_incrDesign[j].totalTests =(int) Double.parseDouble(previousTokens[testIndex]);
					dataStruct_incrDesign[j].GDP = Double.parseDouble(previousTokens[gdpIndex]);
					dataStruct_incrDesign[j].gdpRank = j;
					dataStruct_incrDesign[i].totalCases = (int) Double.parseDouble(previousTokens[casesIndex]);
					dataStruct_incrDesign[i].totalDeaths = (int) Double.parseDouble(previousTokens[deathsIndex]);
					j++;
				
					previousTokens = tokens;
				}
			}
			
			if (j < numCountries) //for last country
			{
				dataStruct_incrDesign[j] = new DataStruct_IncrDesign();
				dataStruct_incrDesign[j].countryName = previousTokens[isoIndex];
				dataStruct_incrDesign[j].totalTests =(int) Double.parseDouble(previousTokens[testIndex]);
				dataStruct_incrDesign[j].GDP = Double.parseDouble(previousTokens[gdpIndex]);
				dataStruct_incrDesign[j].gdpRank = j;
				dataStruct_incrDesign[i].totalCases = (int) Double.parseDouble(previousTokens[casesIndex]);
				dataStruct_incrDesign[i].totalDeaths = (int) Double.parseDouble(previousTokens[deathsIndex]);
				j++;
			
				previousTokens = tokens;
			}
			
			//sort dataStruct_incrDesign array based on gdp
			bubbleSort(dataStruct_incrDesign);
			
			inputFile.close();
			outputFile.close();
			
			covidFile.delete(); //deletes bad data
			covidFile = newFile; //reference covidFile to the new file created by the PrintWriter object
			
			System.out.println(fileSize);
			
			return fileSize;
		}
		catch(IOException e) 
		{ 
			e.printStackTrace(); 
			inputFile.close();
			return 0;
		}
	}
	
	
	
	private void printTable()
	{
		int i = 0;
		boolean nonemptyRow = false;
		
		if (table != null)
		{
			for(i = 0; i < get_colNum(); i++)
			{
				if (get_columnNames()[i] != null)
					System.out.print(get_columnNames()[i] + " ");
			}
			System.out.println();
			
			for(i = 0; i < table.length; i++)
			{
				for(int j = 0; j < table[j].length; j++)
				{
					if (table[i][j] != null)
					{
						System.out.print(table[i][j] + " ");
						nonemptyRow = true;
					}
				}
				
				if (nonemptyRow)
					System.out.println();
				
				nonemptyRow = false;
			}
		}
		else
			System.out.println("Error");
	}
	
	
	
	public String[][] read_allColumns(String country, String startDate, String endDate)
	{
		table = new String[rows][cols]; //clear values in case a previous read function set values to something else
		final int countryIndex = 1, dateIndex = 2;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				if (!tokens[dateIndex].equals(startDate) && flag)
					continue;
				
				flag = false;
				
				for (j = 0; j < tokens.length; j++)
					table[i][j] = tokens[j];
				
				i++;
				
				if (tokens[dateIndex].equals(endDate))
					break;
			}
			
			inputFile.close();
			
			System.out.println(i);
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		printTable();
		
		return table;
	}
	
	public ArrayList<Double> getAllGroceryMobilityAvg()
	{
		String[] countries = {"United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Angola", "Argentina", "Austria", "Australia", "Aruba", "Bosnia and Herzegovina", "Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Benin", "Bolivia", "Brazil", "Botswana", "Belarus", "Belize", "Canada", "Switzerland", "Côte d'Ivoire", "Chile", "Cameroon", "Colombia", "Costa Rica", "Czechia", "Germany", "Denmark", "Dominican Republic", "Ecuador", "Estonia", "Egypt", "Spain", "Finland", "Fiji", "France", "Gabon", "United Kingdom", "Ghana", "Greece", "Guatemala"};
		int i = 0;
		ArrayList<Double> groceryAvg = new ArrayList<Double>();
		ArrayList<Double> groceryAvgAll = new ArrayList<Double>();
		double feb = 0;
		double march = 0;
		double april = 0;
		double may = 0;
		double june = 0;
		double july = 0;
		double aug = 0;
		double sep = 0;
		
		for (i = 0; i < countries.length; i++)
		{	
			groceryAvg = getGroceryMobilityAvg(countries[i]);
			feb = feb + groceryAvg.get(0);
			march = march + groceryAvg.get(1);
			april = april + groceryAvg.get(2);
			may = may + groceryAvg.get(3);
			june = june + groceryAvg.get(4);
			july = july + groceryAvg.get(5);
			aug = aug + groceryAvg.get(6);
			sep = sep + groceryAvg.get(7);
		}
		
		feb = feb/countries.length;
		march = march/countries.length;
		april = april/countries.length;
		may = may/countries.length;
		june = june/countries.length;
		july = july/countries.length;
		aug = aug/countries.length;
		sep = sep/countries.length;
		
		groceryAvgAll.add(Math.round(feb * 100.0) / 100.0);
		groceryAvgAll.add(Math.round(march * 100.0) / 100.0);
		groceryAvgAll.add(Math.round(april * 100.0) / 100.0);
		groceryAvgAll.add(Math.round(may * 100.0) / 100.0);
		groceryAvgAll.add(Math.round(june * 100.0) / 100.0);
		groceryAvgAll.add(Math.round(july * 100.0) / 100.0);
		groceryAvgAll.add(Math.round(aug * 100.0) / 100.0);
		groceryAvgAll.add(Math.round(sep * 100.0) / 100.0);
		
		
		return groceryAvg;
		
	}
	
	public ArrayList<Double> getGroceryMobilityAvg(String country)
	{
		ArrayList<Double> groceryAvg = new ArrayList<Double>();
		ArrayList<Double> feb = new ArrayList<Double>();
		ArrayList<Double> march = new ArrayList<Double>();
		ArrayList<Double> april = new ArrayList<Double>();
		ArrayList<Double> may = new ArrayList<Double>();
		ArrayList<Double> june = new ArrayList<Double>();
		ArrayList<Double> july = new ArrayList<Double>();
		ArrayList<Double> aug = new ArrayList<Double>();
		ArrayList<Double> sep = new ArrayList<Double>();

		final int countryIndex = 1, dateIndex = 2, groceryIndex = 3;
		String startDate = null;
		String endDate = null;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		int monthCount = 1;
		
		
		while(monthCount < 9)
		{
			
			if(monthCount == 1)
			{
				startDate = "2020-02-15";
				endDate = "2020-02-29";
			}
			else if(monthCount == 2)
			{
				startDate = "2020-03-01";
				endDate = "2020-03-31";
			}
			else if(monthCount == 3)
			{
				startDate = "2020-04-01";
				endDate = "2020-04-30";
			}
			else if(monthCount == 4)
			{
				startDate = "2020-05-01";
				endDate = "2020-05-31";
			}
			else if(monthCount == 5)
			{
				startDate = "2020-06-01";
				endDate = "2020-06-30";
			}
			else if(monthCount == 6)
			{
				startDate = "2020-07-01";
				endDate = "2020-07-31";
			}
			else if(monthCount == 7)
			{
				startDate = "2020-08-01";
				endDate = "2020-08-31";
			}
			else if(monthCount == 8)
			{
				startDate = "2020-09-01";
				endDate = "2020-09-30";
			}
			
			try 
			{
				inputFile = new Scanner(covidFile);
				columnNames = inputFile.nextLine().split(",");
				while (inputFile.hasNext())
				{
					tokens = inputFile.nextLine().split(",");
					
					if (!tokens[countryIndex].equals(country))
						continue;
					
					if (!tokens[dateIndex].equals(startDate) && flag)
						continue;
					
					flag = false;
					for (j = 0; j < tokens.length; j++)
					{	
						if(j == groceryIndex)
						{
							if(monthCount == 1)
								feb.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 2)
								march.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 3)
								april.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 4)
								may.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 5)
								june.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 6)
								july.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 7)
								aug.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 8)
								sep.add(Double.parseDouble(tokens[j]));
						}
					}
					i++;
					
					if (tokens[dateIndex].equals(endDate))
					{
						monthCount++;
						break;
					}
				}
				
				inputFile.close();
				
			} 
			catch (FileNotFoundException e) 
			{ 
				e.printStackTrace(); 
			}
		}
		groceryAvg.add(Math.round(calculateAvg(feb) * 100.0) / 100.0);
		groceryAvg.add(Math.round(calculateAvg(march) * 100.0) / 100.0);
		groceryAvg.add(Math.round(calculateAvg(april) * 100.0) / 100.0);
		groceryAvg.add(Math.round(calculateAvg(may) * 100.0) / 100.0);
		groceryAvg.add(Math.round(calculateAvg(june) * 100.0) / 100.0);
		groceryAvg.add(Math.round(calculateAvg(july) * 100.0) / 100.0);
		groceryAvg.add(Math.round(calculateAvg(aug) * 100.0) / 100.0);
		groceryAvg.add(Math.round(calculateAvg(sep) * 100.0) / 100.0);

		
		return groceryAvg;
	}
	
	public ArrayList<Double> getAllParksMobilityAvg()
	{
		String[] countries = {"United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Angola", "Argentina", "Austria", "Australia", "Aruba", "Bosnia and Herzegovina", "Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Benin", "Bolivia", "Brazil", "Botswana", "Belarus", "Belize", "Canada", "Switzerland", "Côte d'Ivoire", "Chile", "Cameroon", "Colombia", "Costa Rica", "Czechia", "Germany", "Denmark", "Dominican Republic", "Ecuador", "Estonia", "Egypt", "Spain", "Finland", "Fiji", "France", "Gabon", "United Kingdom", "Ghana", "Greece", "Guatemala"};
		int i = 0;
		ArrayList<Double> parksAvg = new ArrayList<Double>();
		ArrayList<Double> parksAvgAll = new ArrayList<Double>();
		double feb = 0;
		double march = 0;
		double april = 0;
		double may = 0;
		double june = 0;
		double july = 0;
		double aug = 0;
		double sep = 0;
		
		for (i = 0; i < countries.length; i++)
		{	
			parksAvg = getGroceryMobilityAvg(countries[i]);
			feb = feb + parksAvg.get(0);
			march = march + parksAvg.get(1);
			april = april + parksAvg.get(2);
			may = may + parksAvg.get(3);
			june = june + parksAvg.get(4);
			july = july + parksAvg.get(5);
			aug = aug + parksAvg.get(6);
			sep = sep + parksAvg.get(7);
		}
		
		feb = feb/countries.length;
		march = march/countries.length;
		april = april/countries.length;
		may = may/countries.length;
		june = june/countries.length;
		july = july/countries.length;
		aug = aug/countries.length;
		sep = sep/countries.length;
		
		parksAvgAll.add(Math.round(feb * 100.0) / 100.0);
		parksAvgAll.add(Math.round(march * 100.0) / 100.0);
		parksAvgAll.add(Math.round(april * 100.0) / 100.0);
		parksAvgAll.add(Math.round(may * 100.0) / 100.0);
		parksAvgAll.add(Math.round(june * 100.0) / 100.0);
		parksAvgAll.add(Math.round(july * 100.0) / 100.0);
		parksAvgAll.add(Math.round(aug * 100.0) / 100.0);
		parksAvgAll.add(Math.round(sep * 100.0) / 100.0);
		
		
		return parksAvg;
		
	}
	
	public ArrayList<Double> getParksMobilityAvg(String country)
	{
		ArrayList<Double> parksAvg = new ArrayList<Double>();
		ArrayList<Double> feb = new ArrayList<Double>();
		ArrayList<Double> march = new ArrayList<Double>();
		ArrayList<Double> april = new ArrayList<Double>();
		ArrayList<Double> may = new ArrayList<Double>();
		ArrayList<Double> june = new ArrayList<Double>();
		ArrayList<Double> july = new ArrayList<Double>();
		ArrayList<Double> aug = new ArrayList<Double>();
		ArrayList<Double> sep = new ArrayList<Double>();

		final int countryIndex = 1, dateIndex = 2, parksIndex = 4;
		String startDate = null;
		String endDate = null;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		int monthCount = 1;
		
		
		while(monthCount < 9)
		{
			
			if(monthCount == 1)
			{
				startDate = "2020-02-15";
				endDate = "2020-02-29";
			}
			else if(monthCount == 2)
			{
				startDate = "2020-03-01";
				endDate = "2020-03-31";
			}
			else if(monthCount == 3)
			{
				startDate = "2020-04-01";
				endDate = "2020-04-30";
			}
			else if(monthCount == 4)
			{
				startDate = "2020-05-01";
				endDate = "2020-05-31";
			}
			else if(monthCount == 5)
			{
				startDate = "2020-06-01";
				endDate = "2020-06-30";
			}
			else if(monthCount == 6)
			{
				startDate = "2020-07-01";
				endDate = "2020-07-31";
			}
			else if(monthCount == 7)
			{
				startDate = "2020-08-01";
				endDate = "2020-08-31";
			}
			else if(monthCount == 8)
			{
				startDate = "2020-09-01";
				endDate = "2020-09-30";
			}
			
			try 
			{
				inputFile = new Scanner(covidFile);
				columnNames = inputFile.nextLine().split(",");
				while (inputFile.hasNext())
				{
					tokens = inputFile.nextLine().split(",");
					
					if (!tokens[countryIndex].equals(country))
						continue;
					
					if (!tokens[dateIndex].equals(startDate) && flag)
						continue;
					
					flag = false;
					for (j = 0; j < tokens.length; j++)
					{	
						if(j == parksIndex)
						{
							if(monthCount == 1)
								feb.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 2)
								march.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 3)
								april.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 4)
								may.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 5)
								june.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 6)
								july.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 7)
								aug.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 8)
								sep.add(Double.parseDouble(tokens[j]));
						}
					}
					i++;
					
					if (tokens[dateIndex].equals(endDate))
					{
						monthCount++;
						break;
					}
				}
				
				inputFile.close();
				
			} 
			catch (FileNotFoundException e) 
			{ 
				e.printStackTrace(); 
			}
		}
		parksAvg.add(Math.round(calculateAvg(feb) * 100.0) / 100.0);
		parksAvg.add(Math.round(calculateAvg(march) * 100.0) / 100.0);
		parksAvg.add(Math.round(calculateAvg(april) * 100.0) / 100.0);
		parksAvg.add(Math.round(calculateAvg(may) * 100.0) / 100.0);
		parksAvg.add(Math.round(calculateAvg(june) * 100.0) / 100.0);
		parksAvg.add(Math.round(calculateAvg(july) * 100.0) / 100.0);
		parksAvg.add(Math.round(calculateAvg(aug) * 100.0) / 100.0);
		parksAvg.add(Math.round(calculateAvg(sep) * 100.0) / 100.0);

		
		return parksAvg;
	}
	
	public ArrayList<Double> getAllResidentialMobilityAvg()
	{
		String[] countries = {"United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Angola", "Argentina", "Austria", "Australia", "Aruba", "Bosnia and Herzegovina", "Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Benin", "Bolivia", "Brazil", "Botswana", "Belarus", "Belize", "Canada", "Switzerland", "Côte d'Ivoire", "Chile", "Cameroon", "Colombia", "Costa Rica", "Czechia", "Germany", "Denmark", "Dominican Republic", "Ecuador", "Estonia", "Egypt", "Spain", "Finland", "Fiji", "France", "Gabon", "United Kingdom", "Ghana", "Greece", "Guatemala"};
		int i = 0;
		ArrayList<Double> resAvg = new ArrayList<Double>();
		ArrayList<Double> resAvgAll = new ArrayList<Double>();
		double feb = 0;
		double march = 0;
		double april = 0;
		double may = 0;
		double june = 0;
		double july = 0;
		double aug = 0;
		double sep = 0;
		
		for (i = 0; i < countries.length; i++)
		{	
			resAvg = getGroceryMobilityAvg(countries[i]);
			feb = feb + resAvg.get(0);
			march = march + resAvg.get(1);
			april = april + resAvg.get(2);
			may = may + resAvg.get(3);
			june = june + resAvg.get(4);
			july = july + resAvg.get(5);
			aug = aug + resAvg.get(6);
			sep = sep + resAvg.get(7);
		}
		
		feb = feb/countries.length;
		march = march/countries.length;
		april = april/countries.length;
		may = may/countries.length;
		june = june/countries.length;
		july = july/countries.length;
		aug = aug/countries.length;
		sep = sep/countries.length;
		
		resAvgAll.add(Math.round(feb * 100.0) / 100.0);
		resAvgAll.add(Math.round(march * 100.0) / 100.0);
		resAvgAll.add(Math.round(april * 100.0) / 100.0);
		resAvgAll.add(Math.round(may * 100.0) / 100.0);
		resAvgAll.add(Math.round(june * 100.0) / 100.0);
		resAvgAll.add(Math.round(july * 100.0) / 100.0);
		resAvgAll.add(Math.round(aug * 100.0) / 100.0);
		resAvgAll.add(Math.round(sep * 100.0) / 100.0);
		
		
		return resAvg;
		
	}
	
	public ArrayList<Double> getResidentialMobilityAvg(String country)
	{
		ArrayList<Double> resAvg = new ArrayList<Double>();
		ArrayList<Double> feb = new ArrayList<Double>();
		ArrayList<Double> march = new ArrayList<Double>();
		ArrayList<Double> april = new ArrayList<Double>();
		ArrayList<Double> may = new ArrayList<Double>();
		ArrayList<Double> june = new ArrayList<Double>();
		ArrayList<Double> july = new ArrayList<Double>();
		ArrayList<Double> aug = new ArrayList<Double>();
		ArrayList<Double> sep = new ArrayList<Double>();

		final int countryIndex = 1, dateIndex = 2, resIndex = 5;
		String startDate = null;
		String endDate = null;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		int monthCount = 1;
		
		
		while(monthCount < 9)
		{
			
			if(monthCount == 1)
			{
				startDate = "2020-02-15";
				endDate = "2020-02-29";
			}
			else if(monthCount == 2)
			{
				startDate = "2020-03-01";
				endDate = "2020-03-31";
			}
			else if(monthCount == 3)
			{
				startDate = "2020-04-01";
				endDate = "2020-04-30";
			}
			else if(monthCount == 4)
			{
				startDate = "2020-05-01";
				endDate = "2020-05-31";
			}
			else if(monthCount == 5)
			{
				startDate = "2020-06-01";
				endDate = "2020-06-30";
			}
			else if(monthCount == 6)
			{
				startDate = "2020-07-01";
				endDate = "2020-07-31";
			}
			else if(monthCount == 7)
			{
				startDate = "2020-08-01";
				endDate = "2020-08-31";
			}
			else if(monthCount == 8)
			{
				startDate = "2020-09-01";
				endDate = "2020-09-30";
			}
			
			try 
			{
				inputFile = new Scanner(covidFile);
				columnNames = inputFile.nextLine().split(",");
				while (inputFile.hasNext())
				{
					tokens = inputFile.nextLine().split(",");
					
					if (!tokens[countryIndex].equals(country))
						continue;
					
					if (!tokens[dateIndex].equals(startDate) && flag)
						continue;
					
					flag = false;
					for (j = 0; j < tokens.length; j++)
					{	
						if(j == resIndex)
						{
							if(monthCount == 1)
								feb.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 2)
								march.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 3)
								april.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 4)
								may.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 5)
								june.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 6)
								july.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 7)
								aug.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 8)
								sep.add(Double.parseDouble(tokens[j]));
						}
					}
					i++;
					
					if (tokens[dateIndex].equals(endDate))
					{
						monthCount++;
						break;
					}
				}
				
				inputFile.close();
				
			} 
			catch (FileNotFoundException e) 
			{ 
				e.printStackTrace(); 
			}
		}
		resAvg.add(Math.round(calculateAvg(feb) * 100.0) / 100.0);
		resAvg.add(Math.round(calculateAvg(march) * 100.0) / 100.0);
		resAvg.add(Math.round(calculateAvg(april) * 100.0) / 100.0);
		resAvg.add(Math.round(calculateAvg(may) * 100.0) / 100.0);
		resAvg.add(Math.round(calculateAvg(june) * 100.0) / 100.0);
		resAvg.add(Math.round(calculateAvg(july) * 100.0) / 100.0);
		resAvg.add(Math.round(calculateAvg(aug) * 100.0) / 100.0);
		resAvg.add(Math.round(calculateAvg(sep) * 100.0) / 100.0);

		
		return resAvg;
	}
	
	public ArrayList<Double> getAllRetailMobilityAvg()
	{
		String[] countries = {"United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Angola", "Argentina", "Austria", "Australia", "Aruba", "Bosnia and Herzegovina", "Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Benin", "Bolivia", "Brazil", "Botswana", "Belarus", "Belize", "Canada", "Switzerland", "Côte d'Ivoire", "Chile", "Cameroon", "Colombia", "Costa Rica", "Czechia", "Germany", "Denmark", "Dominican Republic", "Ecuador", "Estonia", "Egypt", "Spain", "Finland", "Fiji", "France", "Gabon", "United Kingdom", "Ghana", "Greece", "Guatemala"};
		int i = 0;
		ArrayList<Double> retailAvg = new ArrayList<Double>();
		ArrayList<Double> retailAvgAll = new ArrayList<Double>();
		double feb = 0;
		double march = 0;
		double april = 0;
		double may = 0;
		double june = 0;
		double july = 0;
		double aug = 0;
		double sep = 0;
		
		for (i = 0; i < countries.length; i++)
		{	
			retailAvg = getGroceryMobilityAvg(countries[i]);
			feb = feb + retailAvg.get(0);
			march = march + retailAvg.get(1);
			april = april + retailAvg.get(2);
			may = may + retailAvg.get(3);
			june = june + retailAvg.get(4);
			july = july + retailAvg.get(5);
			aug = aug + retailAvg.get(6);
			sep = sep + retailAvg.get(7);
		}
		
		feb = feb/countries.length;
		march = march/countries.length;
		april = april/countries.length;
		may = may/countries.length;
		june = june/countries.length;
		july = july/countries.length;
		aug = aug/countries.length;
		sep = sep/countries.length;
		
		retailAvgAll.add(Math.round(feb * 100.0) / 100.0);
		retailAvgAll.add(Math.round(march * 100.0) / 100.0);
		retailAvgAll.add(Math.round(april * 100.0) / 100.0);
		retailAvgAll.add(Math.round(may * 100.0) / 100.0);
		retailAvgAll.add(Math.round(june * 100.0) / 100.0);
		retailAvgAll.add(Math.round(july * 100.0) / 100.0);
		retailAvgAll.add(Math.round(aug * 100.0) / 100.0);
		retailAvgAll.add(Math.round(sep * 100.0) / 100.0);
		
		
		return retailAvg;
	}
	
	public ArrayList<Double> getRetailMobilityAvg(String country)
	{
		ArrayList<Double> retailAvg = new ArrayList<Double>();
		ArrayList<Double> feb = new ArrayList<Double>();
		ArrayList<Double> march = new ArrayList<Double>();
		ArrayList<Double> april = new ArrayList<Double>();
		ArrayList<Double> may = new ArrayList<Double>();
		ArrayList<Double> june = new ArrayList<Double>();
		ArrayList<Double> july = new ArrayList<Double>();
		ArrayList<Double> aug = new ArrayList<Double>();
		ArrayList<Double> sep = new ArrayList<Double>();

		final int countryIndex = 1, dateIndex = 2, retailIndex = 6;
		String startDate = null;
		String endDate = null;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		int monthCount = 1;
		
		
		while(monthCount < 9)
		{
			
			if(monthCount == 1)
			{
				startDate = "2020-02-15";
				endDate = "2020-02-29";
			}
			else if(monthCount == 2)
			{
				startDate = "2020-03-01";
				endDate = "2020-03-31";
			}
			else if(monthCount == 3)
			{
				startDate = "2020-04-01";
				endDate = "2020-04-30";
			}
			else if(monthCount == 4)
			{
				startDate = "2020-05-01";
				endDate = "2020-05-31";
			}
			else if(monthCount == 5)
			{
				startDate = "2020-06-01";
				endDate = "2020-06-30";
			}
			else if(monthCount == 6)
			{
				startDate = "2020-07-01";
				endDate = "2020-07-31";
			}
			else if(monthCount == 7)
			{
				startDate = "2020-08-01";
				endDate = "2020-08-31";
			}
			else if(monthCount == 8)
			{
				startDate = "2020-09-01";
				endDate = "2020-09-30";
			}
			
			try 
			{
				inputFile = new Scanner(covidFile);
				columnNames = inputFile.nextLine().split(",");
				while (inputFile.hasNext())
				{
					tokens = inputFile.nextLine().split(",");
					
					if (!tokens[countryIndex].equals(country))
						continue;
					
					if (!tokens[dateIndex].equals(startDate) && flag)
						continue;
					
					flag = false;
					for (j = 0; j < tokens.length; j++)
					{	
						if(j == retailIndex)
						{
							if(monthCount == 1)
								feb.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 2)
								march.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 3)
								april.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 4)
								may.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 5)
								june.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 6)
								july.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 7)
								aug.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 8)
								sep.add(Double.parseDouble(tokens[j]));
						}
					}
					i++;
					
					if (tokens[dateIndex].equals(endDate))
					{
						monthCount++;
						break;
					}
				}
				
				inputFile.close();
				
			} 
			catch (FileNotFoundException e) 
			{ 
				e.printStackTrace(); 
			}
		}
		retailAvg.add(Math.round(calculateAvg(feb) * 100.0) / 100.0);
		retailAvg.add(Math.round(calculateAvg(march) * 100.0) / 100.0);
		retailAvg.add(Math.round(calculateAvg(april) * 100.0) / 100.0);
		retailAvg.add(Math.round(calculateAvg(may) * 100.0) / 100.0);
		retailAvg.add(Math.round(calculateAvg(june) * 100.0) / 100.0);
		retailAvg.add(Math.round(calculateAvg(july) * 100.0) / 100.0);
		retailAvg.add(Math.round(calculateAvg(aug) * 100.0) / 100.0);
		retailAvg.add(Math.round(calculateAvg(sep) * 100.0) / 100.0);

		
		return retailAvg;
	}
	
	public ArrayList<Double> getAllTransitMobilityAvg()
	{
		String[] countries = {"United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Angola", "Argentina", "Austria", "Australia", "Aruba", "Bosnia and Herzegovina", "Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Benin", "Bolivia", "Brazil", "Botswana", "Belarus", "Belize", "Canada", "Switzerland", "Côte d'Ivoire", "Chile", "Cameroon", "Colombia", "Costa Rica", "Czechia", "Germany", "Denmark", "Dominican Republic", "Ecuador", "Estonia", "Egypt", "Spain", "Finland", "Fiji", "France", "Gabon", "United Kingdom", "Ghana", "Greece", "Guatemala"};
		int i = 0;
		ArrayList<Double> transitAvg = new ArrayList<Double>();
		ArrayList<Double> transitAvgAll = new ArrayList<Double>();
		double feb = 0;
		double march = 0;
		double april = 0;
		double may = 0;
		double june = 0;
		double july = 0;
		double aug = 0;
		double sep = 0;
		
		for (i = 0; i < countries.length; i++)
		{	
			transitAvg = getGroceryMobilityAvg(countries[i]);
			feb = feb + transitAvg.get(0);
			march = march + transitAvg.get(1);
			april = april + transitAvg.get(2);
			may = may + transitAvg.get(3);
			june = june + transitAvg.get(4);
			july = july + transitAvg.get(5);
			aug = aug + transitAvg.get(6);
			sep = sep + transitAvg.get(7);
		}
		
		feb = feb/countries.length;
		march = march/countries.length;
		april = april/countries.length;
		may = may/countries.length;
		june = june/countries.length;
		july = july/countries.length;
		aug = aug/countries.length;
		sep = sep/countries.length;
		
		transitAvgAll.add(Math.round(feb * 100.0) / 100.0);
		transitAvgAll.add(Math.round(march * 100.0) / 100.0);
		transitAvgAll.add(Math.round(april * 100.0) / 100.0);
		transitAvgAll.add(Math.round(may * 100.0) / 100.0);
		transitAvgAll.add(Math.round(june * 100.0) / 100.0);
		transitAvgAll.add(Math.round(july * 100.0) / 100.0);
		transitAvgAll.add(Math.round(aug * 100.0) / 100.0);
		transitAvgAll.add(Math.round(sep * 100.0) / 100.0);
		
		
		return transitAvg;
	}
	
	public ArrayList<Double> getTransitMobilityAvg(String country)
	{
		ArrayList<Double> transitAvg = new ArrayList<Double>();
		ArrayList<Double> feb = new ArrayList<Double>();
		ArrayList<Double> march = new ArrayList<Double>();
		ArrayList<Double> april = new ArrayList<Double>();
		ArrayList<Double> may = new ArrayList<Double>();
		ArrayList<Double> june = new ArrayList<Double>();
		ArrayList<Double> july = new ArrayList<Double>();
		ArrayList<Double> aug = new ArrayList<Double>();
		ArrayList<Double> sep = new ArrayList<Double>();

		final int countryIndex = 1, dateIndex = 2, transitIndex = 7;
		String startDate = null;
		String endDate = null;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		int monthCount = 1;
		
		
		while(monthCount < 9)
		{
			
			if(monthCount == 1)
			{
				startDate = "2020-02-15";
				endDate = "2020-02-29";
			}
			else if(monthCount == 2)
			{
				startDate = "2020-03-01";
				endDate = "2020-03-31";
			}
			else if(monthCount == 3)
			{
				startDate = "2020-04-01";
				endDate = "2020-04-30";
			}
			else if(monthCount == 4)
			{
				startDate = "2020-05-01";
				endDate = "2020-05-31";
			}
			else if(monthCount == 5)
			{
				startDate = "2020-06-01";
				endDate = "2020-06-30";
			}
			else if(monthCount == 6)
			{
				startDate = "2020-07-01";
				endDate = "2020-07-31";
			}
			else if(monthCount == 7)
			{
				startDate = "2020-08-01";
				endDate = "2020-08-31";
			}
			else if(monthCount == 8)
			{
				startDate = "2020-09-01";
				endDate = "2020-09-30";
			}
			
			try 
			{
				inputFile = new Scanner(covidFile);
				columnNames = inputFile.nextLine().split(",");
				while (inputFile.hasNext())
				{
					tokens = inputFile.nextLine().split(",");
					
					if (!tokens[countryIndex].equals(country))
						continue;
					
					if (!tokens[dateIndex].equals(startDate) && flag)
						continue;
					
					flag = false;
					for (j = 0; j < tokens.length; j++)
					{	
						if(j == transitIndex)
						{
							if(monthCount == 1)
								feb.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 2)
								march.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 3)
								april.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 4)
								may.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 5)
								june.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 6)
								july.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 7)
								aug.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 8)
								sep.add(Double.parseDouble(tokens[j]));
						}
					}
					i++;
					
					if (tokens[dateIndex].equals(endDate))
					{
						monthCount++;
						break;
					}
				}
				
				inputFile.close();
				
			} 
			catch (FileNotFoundException e) 
			{ 
				e.printStackTrace(); 
			}
		}
		transitAvg.add(Math.round(calculateAvg(feb) * 100.0) / 100.0);
		transitAvg.add(Math.round(calculateAvg(march) * 100.0) / 100.0);
		transitAvg.add(Math.round(calculateAvg(april) * 100.0) / 100.0);
		transitAvg.add(Math.round(calculateAvg(may) * 100.0) / 100.0);
		transitAvg.add(Math.round(calculateAvg(june) * 100.0) / 100.0);
		transitAvg.add(Math.round(calculateAvg(july) * 100.0) / 100.0);
		transitAvg.add(Math.round(calculateAvg(aug) * 100.0) / 100.0);
		transitAvg.add(Math.round(calculateAvg(sep) * 100.0) / 100.0);

		
		return transitAvg;
	}
	
	public ArrayList<Double> getAllWorkplaceMobilityAvg()
	{
		String[] countries = {"United Arab Emirates", "Afghanistan", "Antigua and Barbuda", "Angola", "Argentina", "Austria", "Australia", "Aruba", "Bosnia and Herzegovina", "Barbados", "Bangladesh", "Belgium", "Burkina Faso", "Bulgaria", "Bahrain", "Benin", "Bolivia", "Brazil", "Botswana", "Belarus", "Belize", "Canada", "Switzerland", "Côte d'Ivoire", "Chile", "Cameroon", "Colombia", "Costa Rica", "Czechia", "Germany", "Denmark", "Dominican Republic", "Ecuador", "Estonia", "Egypt", "Spain", "Finland", "Fiji", "France", "Gabon", "United Kingdom", "Ghana", "Greece", "Guatemala"};
		int i = 0;
		ArrayList<Double> workplaceAvg = new ArrayList<Double>();
		ArrayList<Double> workplaceAvgAll = new ArrayList<Double>();
		double feb = 0;
		double march = 0;
		double april = 0;
		double may = 0;
		double june = 0;
		double july = 0;
		double aug = 0;
		double sep = 0;
		
		for (i = 0; i < countries.length; i++)
		{	
			workplaceAvg = getGroceryMobilityAvg(countries[i]);
			feb = feb + workplaceAvg.get(0);
			march = march + workplaceAvg.get(1);
			april = april + workplaceAvg.get(2);
			may = may + workplaceAvg.get(3);
			june = june + workplaceAvg.get(4);
			july = july + workplaceAvg.get(5);
			aug = aug + workplaceAvg.get(6);
			sep = sep + workplaceAvg.get(7);
		}
		
		feb = feb/countries.length;
		march = march/countries.length;
		april = april/countries.length;
		may = may/countries.length;
		june = june/countries.length;
		july = july/countries.length;
		aug = aug/countries.length;
		sep = sep/countries.length;
		
		workplaceAvgAll.add(Math.round(feb * 100.0) / 100.0);
		workplaceAvgAll.add(Math.round(march * 100.0) / 100.0);
		workplaceAvgAll.add(Math.round(april * 100.0) / 100.0);
		workplaceAvgAll.add(Math.round(may * 100.0) / 100.0);
		workplaceAvgAll.add(Math.round(june * 100.0) / 100.0);
		workplaceAvgAll.add(Math.round(july * 100.0) / 100.0);
		workplaceAvgAll.add(Math.round(aug * 100.0) / 100.0);
		workplaceAvgAll.add(Math.round(sep * 100.0) / 100.0);
		
		
		return workplaceAvg;
	}
	
	public ArrayList<Double> getWorkplaceMobilityAvg(String country)
	{
		ArrayList<Double> workplaceAvg = new ArrayList<Double>();
		ArrayList<Double> feb = new ArrayList<Double>();
		ArrayList<Double> march = new ArrayList<Double>();
		ArrayList<Double> april = new ArrayList<Double>();
		ArrayList<Double> may = new ArrayList<Double>();
		ArrayList<Double> june = new ArrayList<Double>();
		ArrayList<Double> july = new ArrayList<Double>();
		ArrayList<Double> aug = new ArrayList<Double>();
		ArrayList<Double> sep = new ArrayList<Double>();

		final int countryIndex = 1, dateIndex = 2, workplaceIndex = 8;
		String startDate = null;
		String endDate = null;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		int monthCount = 1;
		
		
		while(monthCount < 9)
		{
			
			if(monthCount == 1)
			{
				startDate = "2020-02-15";
				endDate = "2020-02-29";
			}
			else if(monthCount == 2)
			{
				startDate = "2020-03-01";
				endDate = "2020-03-31";
			}
			else if(monthCount == 3)
			{
				startDate = "2020-04-01";
				endDate = "2020-04-30";
			}
			else if(monthCount == 4)
			{
				startDate = "2020-05-01";
				endDate = "2020-05-31";
			}
			else if(monthCount == 5)
			{
				startDate = "2020-06-01";
				endDate = "2020-06-30";
			}
			else if(monthCount == 6)
			{
				startDate = "2020-07-01";
				endDate = "2020-07-31";
			}
			else if(monthCount == 7)
			{
				startDate = "2020-08-01";
				endDate = "2020-08-31";
			}
			else if(monthCount == 8)
			{
				startDate = "2020-09-01";
				endDate = "2020-09-30";
			}
			
			try 
			{
				inputFile = new Scanner(covidFile);
				columnNames = inputFile.nextLine().split(",");
				while (inputFile.hasNext())
				{
					tokens = inputFile.nextLine().split(",");
					
					if (!tokens[countryIndex].equals(country))
						continue;
					
					if (!tokens[dateIndex].equals(startDate) && flag)
						continue;
					
					flag = false;
					for (j = 0; j < tokens.length; j++)
					{	
						if(j == workplaceIndex)
						{
							if(monthCount == 1)
								feb.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 2)
								march.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 3)
								april.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 4)
								may.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 5)
								june.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 6)
								july.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 7)
								aug.add(Double.parseDouble(tokens[j]));
							else if(monthCount == 8)
								sep.add(Double.parseDouble(tokens[j]));
						}
					}
					i++;
					
					if (tokens[dateIndex].equals(endDate))
					{
						monthCount++;
						break;
					}
				}
				
				inputFile.close();
				
			} 
			catch (FileNotFoundException e) 
			{ 
				e.printStackTrace(); 
			}
		}
		workplaceAvg.add(Math.round(calculateAvg(feb) * 100.0) / 100.0);
		workplaceAvg.add(Math.round(calculateAvg(march) * 100.0) / 100.0);
		workplaceAvg.add(Math.round(calculateAvg(april) * 100.0) / 100.0);
		workplaceAvg.add(Math.round(calculateAvg(may) * 100.0) / 100.0);
		workplaceAvg.add(Math.round(calculateAvg(june) * 100.0) / 100.0);
		workplaceAvg.add(Math.round(calculateAvg(july) * 100.0) / 100.0);
		workplaceAvg.add(Math.round(calculateAvg(aug) * 100.0) / 100.0);
		workplaceAvg.add(Math.round(calculateAvg(sep) * 100.0) / 100.0);

		
		return workplaceAvg;
	}
	
	/*
	 * +++++ AVERAGE FUNCTION +++++++
	 */
	public Double calculateAvg(ArrayList<Double> list)
	{
		double sum = 0;
		
		for (int i = 1; i < list.size(); i++)
			sum = sum + list.get(i);
		
		return (sum / list.size());
	}
	
	public ArrayList<Double> getCasesPerMonth(String country)
	{
		ArrayList<Double> cases = new ArrayList<Double>();
		final int countryIndex = 1, dateIndex = 2, caseIndex = 9;
		String startDate = null;
		String endDate = null;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		int monthCount = 1;
		String feb = "2020-02-29";
		String march = "2020-03-31";
		String april = "2020-04-30";
		String may = "2020-05-31";
		String june = "2020-06-30";
		String july = "2020-07-31";
		String aug = "2020-08-31";
		String sep = "2020-09-30";
		
			try 
			{
				inputFile = new Scanner(covidFile);
				columnNames = inputFile.nextLine().split(",");
				while (inputFile.hasNext())
				{
					tokens = inputFile.nextLine().split(",");
					
					if (!tokens[countryIndex].equals(country))
						continue;
					
					flag = false;
					for (j = 0; j < tokens.length; j++)
					{
						if (j == caseIndex && tokens[dateIndex].equals(feb))
						{
							cases.add(Double.parseDouble(tokens[j]));
						}
						else if (j == caseIndex && tokens[dateIndex].equals(march))
						{
							double temp = Double.parseDouble(tokens[j]);
							double monthlyCases = temp - cases.get(cases.size() - 1);
							cases.add(monthlyCases);
						}
						else if (j == caseIndex && tokens[dateIndex].equals(april))
						{
							double temp = Double.parseDouble(tokens[j]);
							double monthlyCases = temp - cases.get(cases.size() - 1);
							cases.add(monthlyCases);
						}
						else if (j == caseIndex && tokens[dateIndex].equals(may))
						{
							double temp = Double.parseDouble(tokens[j]);
							double monthlyCases = temp - cases.get(cases.size() - 1);
							cases.add(monthlyCases);
						}
						else if (j == caseIndex && tokens[dateIndex].equals(june))
						{
							double temp = Double.parseDouble(tokens[j]);
							double monthlyCases = temp - cases.get(cases.size() - 1);
							cases.add(monthlyCases);
						}
						else if (j == caseIndex && tokens[dateIndex].equals(july))
						{
							double temp = Double.parseDouble(tokens[j]);
							double monthlyCases = temp - cases.get(cases.size() - 1);
							cases.add(monthlyCases);
						}
						else if (j == caseIndex && tokens[dateIndex].equals(aug))
						{
							double temp = Double.parseDouble(tokens[j]);
							double monthlyCases = temp - cases.get(cases.size() - 1);
							cases.add(monthlyCases);
						}
						else if (j == caseIndex && tokens[dateIndex].equals(sep))
						{
							double temp = Double.parseDouble(tokens[j]);
							double monthlyCases = temp - cases.get(cases.size() - 1);
							cases.add(monthlyCases);
						}
					}
					
					i++;
				}
				
				inputFile.close();
				
			} 
			catch (FileNotFoundException e) 
			{ 
				e.printStackTrace(); 
			}
		
	
		return cases;
	}

	public double getCases()
	{
		final int countryIndex = 1, dateIndex = 2, caseIndex = 9;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		String feb = "2020-02-29";
		String march = "2020-03-31";
		String april = "2020-04-30";
		String may = "2020-05-31";
		String june = "2020-06-30";
		String july = "2020-07-31";
		String aug = "2020-08-31";
		String sep = "2020-09-30";
		double cases = 0.0;
		
			try 
			{
				inputFile = new Scanner(covidFile);
				columnNames = inputFile.nextLine().split(",");
				while (inputFile.hasNext())
				{
					tokens = inputFile.nextLine().split(",");
					
					flag = false;
					for (j = 0; j < tokens.length; j++)
					{
						if (j == caseIndex && (tokens[dateIndex].equals(feb) | tokens[dateIndex].equals(march))
								| tokens[dateIndex].equals(april) | tokens[dateIndex].equals(may)
								| tokens[dateIndex].equals(june) | tokens[dateIndex].equals(july)
								| tokens[dateIndex].equals(aug) | tokens[dateIndex].equals(sep))
						{
							cases = cases + (Double.parseDouble(tokens[j]));
						}
					}
					
					i++;
					
				}
			
				inputFile.close();
			} 
				catch (FileNotFoundException e) 
				{ 
					e.printStackTrace(); 
				}
			
		return cases;
	}
	
	
	public double getCountryCases(String country)
	{
		final int countryIndex = 1, casesIndex = 9;
		String[] tokens = null;
		Scanner inputFile = null;
		//int i = 0, j = 0;
		boolean flag = true;
		double cases = 0;
		
		for (int i = 0; i < dataStruct_incrDesign.length; ++i) {
			if (dataStruct_incrDesign[i].countryName.equals(country)) {
				cases = dataStruct_incrDesign[i].totalCases;
				System.out.print(cases);
			}
		}
		
//		try 
//		{
//			inputFile = new Scanner(covidFile);
//			
//			columnNames = inputFile.nextLine().split(",");
//			
//			while (inputFile.hasNext())
//			{
//				tokens = inputFile.nextLine().split(",");
//				
//				flag = false;
//				
//				if (!tokens[countryIndex].equals(country))
//					continue;
//				
//				for (j = 0; j < tokens.length; j++)
//				{
//					if (j == casesIndex)
//					{
//						cases = cases + Double.parseDouble(tokens[j]);
//					}
//				}
//				
//				i++;
//				
//			}
//			
//			inputFile.close();
//			
//			System.out.println(i);
//		} 
//		catch (FileNotFoundException e) 
//		{ 
//			e.printStackTrace(); 
//		}
		
		return cases;
	}
	
	
	public double get_globalCases()
	{
		final int isoIndex = 0, casesIndex = 9;
		String[] tokens = null;
		String[] prevTokens = null;
		Scanner inputFile = null;
		double temp = 0, cases = 0;
		
		try
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			prevTokens = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (tokens[isoIndex].equals(prevTokens[isoIndex]))
				{
					prevTokens = tokens;
					continue;
				}
				
				temp = Double.parseDouble(prevTokens[casesIndex]);
				if (temp != -404)
					cases = cases + temp;
				
				prevTokens = tokens;
			}
			
			temp = Double.parseDouble(prevTokens[casesIndex]); // for the last country
			if (temp != -404)
				cases = cases + temp;
			
			inputFile.close();
		}
		catch (FileNotFoundException e) { e.printStackTrace(); }
		
		return cases;
	}
	
	
	public double get_globalDeaths()
	{
		final int isoIndex = 0, deathIndex = 10;
		String[] tokens = null;
		String[] prevTokens = null;
		Scanner inputFile = null;
		double temp = 0, deaths = 0;
		
		try
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			prevTokens = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (tokens[isoIndex].equals(prevTokens[isoIndex]))
				{
					prevTokens = tokens;
					continue;
				}
				
				temp = Double.parseDouble(prevTokens[deathIndex]);
				if (temp != -404)
					deaths = deaths + temp;
				
				prevTokens = tokens;
			}
			
			temp = Double.parseDouble(prevTokens[deathIndex]);
			if (temp != -404)
				deaths = deaths + temp; // for the last country
			
			inputFile.close();
		}
		catch (FileNotFoundException e) { e.printStackTrace(); }
		
		return deaths;
	}
	
	
	public double getDeaths()
	{final int countryIndex = 1, dateIndex = 2, deathIndex = 10;
	String[] tokens = null;
	Scanner inputFile = null;
	int i = 0, j = 0;
	boolean flag = true;
	String feb = "2020-02-29";
	String march = "2020-03-31";
	String april = "2020-04-30";
	String may = "2020-05-31";
	String june = "2020-06-30";
	String july = "2020-07-31";
	String aug = "2020-08-31";
	String sep = "2020-09-30";
	double deaths = 0.0;
	
	
		try 
		{
			inputFile = new Scanner(covidFile);
			columnNames = inputFile.nextLine().split(",");
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				flag = false;
				for (j = 0; j < tokens.length; j++)
				{
					if (j == deathIndex && (tokens[dateIndex].equals(feb) | tokens[dateIndex].equals(march))
							| tokens[dateIndex].equals(april) | tokens[dateIndex].equals(may)
							| tokens[dateIndex].equals(june) | tokens[dateIndex].equals(july)
							| tokens[dateIndex].equals(aug) | tokens[dateIndex].equals(sep))
					{
						deaths = deaths + (Double.parseDouble(tokens[j]));
					}
				}
				
				i++;
				
			}
		
			inputFile.close();
		} 
			catch (FileNotFoundException e) 
			{ 
				e.printStackTrace(); 
			}
	
		return deaths;

	}
	
	public double getCountryDeaths(String country)
	{
		
		final int countryIndex = 1, deathsIndex = 10;
		String[] tokens = null;
		Scanner inputFile = null;
		//int i = 0, j = 0;
		boolean flag = true;
		double cases = 0;
		double deaths = 0;
		
		for (int i = 0; i < dataStruct_incrDesign.length; ++i) {
			if (dataStruct_incrDesign[i].countryName.equals(country)) {
				deaths = dataStruct_incrDesign[i].totalDeaths;
				System.out.print(deaths);
			}
		}
		
//		try 
//		{
//			inputFile = new Scanner(covidFile);
//			
//			columnNames = inputFile.nextLine().split(",");
//			
//			while (inputFile.hasNext())
//			{
//				tokens = inputFile.nextLine().split(",");
//				
//				flag = false;
//				
//				if (!tokens[countryIndex].equals(country))
//					continue;
//				
//				for (j = 0; j < tokens.length; j++)
//				{
//					if (j == deathsIndex)
//					{
//						deaths = deaths + Double.parseDouble(tokens[j]);
//					}
//				}
//				
//				i++;
//				
//			}
//			
//			inputFile.close();
//			
//			System.out.println(i);
//		} 
//		catch (FileNotFoundException e) 
//		{ 
//			e.printStackTrace(); 
//		}
		
		return deaths;
	}
	
	public ArrayList<Double> getCountryWorkplaceTrends(String country, String month)
	{
		
		ArrayList<Double> workplaceMonthlyTrend = new ArrayList<Double>(); //clear values in case a previous read function set values to something else
		final int countryIndex = 1, dateIndex = 2, workplaceIndex = 8;
		String startDate = null;
		String endDate = null;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;

		if (month.equals("February")) {
			System.out.print("February selected\n");
			startDate = "2020-02-15";
			endDate = "2020-02-29";
		} else if (month.equals("March")) {
			System.out.print("March selected\n");
			startDate = "2020-03-01";
			endDate = "2020-03-31";
		} else if (month.equals("April")) {
			System.out.print("April selected\n");
			startDate = "2020-04-01";
			endDate = "2020-04-30";
		} else if (month.equals("May")) {
			System.out.print("May selected\n");
			startDate = "2020-05-01";
			endDate = "2020-05-31";
		} else if (month.equals("June")) {
			System.out.print("June selected\n");
			startDate = "2020-06-01";
			endDate = "2020-06-30";
		} else if (month.equals("July")) {
			System.out.print("July selected\n");
			startDate = "2020-07-01";
			endDate = "2020-07-31";
		} else if (month.equals("August")) {
			System.out.print("August selected\n");
			startDate = "2020-08-01";
			endDate = "2020-08-31";
		} else if (month.equals("September")) {
			System.out.print("September selected\n");
			startDate = "2020-09-01";
			endDate = "2020-09-30";
		}
		
		
		try {
			inputFile = new Scanner(covidFile);
			columnNames = inputFile.nextLine().split(",");
			
			while(inputFile.hasNext()) {
				tokens = inputFile.nextLine().split(","); //assn tokens with a line from csv broken by commas
				
				if(!tokens[countryIndex].equals(country)) {
					continue;
					//row is not desired country, skip to next line
				}
				
				if(!tokens[dateIndex].equals(startDate) && flag) {
					//flag already set to false and date doesn't match target date
					//therefore, skip to newline
					continue;
				}
				
				flag = false; //we've gone past the start date; we need to skip the above if-stmt
				
				for (j = 0; j < tokens.length; ++j) { //iterate thru tokens/vals in tokens array or csv line
					
					if(j == workplaceIndex) {
						//ID'd column with workPlaxe value? add it into list, then
						workplaceMonthlyTrend.add(Double.parseDouble(tokens[j]));
						//System.out.print(tokens[countryIndex]+" "+tokens[dateIndex]+" "+workplaceMonthlyTrend.get(i) + "\n");
						break;
						//escape initial for loop
					}
				} 
				if(tokens[dateIndex].equals(endDate)) {
					//System.out.print("end selected\n");
					break;
				}
				++i; //indexes actual return array
			}
			inputFile.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		return workplaceMonthlyTrend;
	}
	
	public ArrayList<Double> getCountryPublicTransportTrendsMonthly(String country, String month)
	{
		
		ArrayList<Double> publicTransitMonthlyTrend = new ArrayList<Double>(); //clear values in case a previous read function set values to something else
		final int countryIndex = 1, dateIndex = 2, publicTransitIndex = 7;
		String startDate = null;
		String endDate = null;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;

		if (month.equals("February")) {
			System.out.print("February selected\n");
			startDate = "2020-02-15";
			endDate = "2020-02-29";
		} else if (month.equals("March")) {
			System.out.print("March selected\n");
			startDate = "2020-03-01";
			endDate = "2020-03-31";
		} else if (month.equals("April")) {
			System.out.print("April selected\n");
			startDate = "2020-04-01";
			endDate = "2020-04-30";
		} else if (month.equals("May")) {
			System.out.print("May selected\n");
			startDate = "2020-05-01";
			endDate = "2020-05-31";
		} else if (month.equals("June")) {
			System.out.print("June selected\n");
			startDate = "2020-06-01";
			endDate = "2020-06-30";
		} else if (month.equals("July")) {
			System.out.print("July selected\n");
			startDate = "2020-07-01";
			endDate = "2020-07-31";
		} else if (month.equals("August")) {
			System.out.print("August selected\n");
			startDate = "2020-08-01";
			endDate = "2020-08-31";
		} else if (month.equals("September")) {
			System.out.print("September selected\n");
			startDate = "2020-09-01";
			endDate = "2020-09-30";
		}
		
		
		try {
			inputFile = new Scanner(covidFile);
			columnNames = inputFile.nextLine().split(",");
			
			while(inputFile.hasNext()) {
				tokens = inputFile.nextLine().split(","); //assn tokens with a line from csv broken by commas
				
				if(!tokens[countryIndex].equals(country)) {
					continue;
					//row is not desired country, skip to next line
				}
				
				if(!tokens[dateIndex].equals(startDate) && flag) {
					//flag already set to false and date doesn't match target date
					//therefore, skip to newline
					continue;
				}
				
				flag = false; //we've gone past the start date; we need to skip the above if-stmt
				
				for (j = 0; j < tokens.length; ++j) { //iterate thru tokens/vals in tokens array or csv line
					
					if(j == publicTransitIndex) {
						//ID'd column with workPlaxe value? add it into list, then
						publicTransitMonthlyTrend.add(Double.parseDouble(tokens[j]));
						System.out.print(tokens[countryIndex]+" "+tokens[dateIndex]+" "+publicTransitMonthlyTrend.get(i) + "\n");
						break;
						//escape initial for loop
					}
				} 
				if(tokens[dateIndex].equals(endDate)) {
					//System.out.print("end selected\n");
					break;
				}
				++i; //indexes actual return array
			}
			inputFile.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		return publicTransitMonthlyTrend;
	}
	
	public double[][] getCountryPublicTransportTrends(String country)
	{
		table1 = new double[rows][cols]; //clear values in case a previous read function set values to something else
		final int countryIndex = 1, workplaceIndex = 7;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				
				//check if token has right date range?
				/*if (!tokens[dateIndex].equals(startDate) && flag)
					continue;
				*/
				
				flag = false;
				
				for (j = 0; j < tokens.length; j++)
					table1[i][j] = Double.parseDouble(tokens[j]);
				
				i++;
			}
			
			inputFile.close();
			
			System.out.println(i);
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		printTable();
		
		return table1;
	}
	
	public String[][] read_casesDeaths(String country, String startDate, String endDate)
	{
		table = new String[rows][cols]; //clear values in case a previous read function set values to something else
		final int countryIndex = 1, dateIndex = 2, casesIndex = 9, deathsIndex = 10;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			for(j = 0; j < columnNames.length; j++)
			{
				if (j != countryIndex && j != dateIndex && j != casesIndex && j != deathsIndex)
					columnNames[j] = null;
			}
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				if (!tokens[dateIndex].equals(startDate) && flag)
					continue;
				
				flag = false;
				
				for (j = 0; j < tokens.length; j++)
				{
					if (j == countryIndex || j == dateIndex || j == casesIndex || j == deathsIndex)
						table[i][j] = tokens[j];
				}
				
				i++;
				
				if (tokens[dateIndex].equals(endDate))
					break;
			}
			
			inputFile.close();
			
			System.out.println(i);
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		printTable();
		
		return table;
	}
	
	
	
	public String[][] read_testsPop(String country)
	{
		table = new String[rows][cols]; //clear values in case a previous read function set values to something else
		final int countryIndex = 1, testsIndex = 12, popIndex = 14;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			for(j = 0; j < columnNames.length; j++)
			{
				if (j != countryIndex && j != testsIndex && j != popIndex)
					columnNames[j] = null;
			}
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				for (j = 0; j < tokens.length; j++)
				{
					if (j == countryIndex || j == testsIndex || j == popIndex)
						table[i][j] = tokens[j];
				}
				
				i++;
			}
			
			inputFile.close();
			
			System.out.println(i);
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		printTable();
		
		return table;
	}
	
	
	
	public String[][] read_baseLines(String country)
	{
		table = new String[rows][cols]; //clear values in case a previous read function set values to something else
		final int countryIndex = 1, b1index = 3, b2index = 4, b3index = 5, b4index = 6, b5index = 7, b6index = 8;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			for(j = 0; j < columnNames.length; j++)
			{
				if (j != countryIndex && j != b1index && j != b2index && j != b3index && j != b4index && j != b5index && j != b6index)
					columnNames[j] = null;
			}
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				for (j = 0; j < tokens.length; j++)
				{
					if (j == countryIndex || j == b1index || j == b2index || j == b3index || j == b4index || j == b5index || j == b6index)
						table[i][j] = tokens[j];
				}
				
				i++;
			}
			
			inputFile.close();
			
			System.out.println(i);
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		printTable();
		
		return table;
	}
	
	
	
	public String[][] readCountries_lessHealth(double health)
	{
		table = new String[rows][cols]; //clear values in case a previous read function set values to something else
		final int countryIndex = 1, healthIndex = 18;
		String country = null;
		String previousCountry = "United Arab Emirates";
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0, count = 0;
		double healthI = 0.0, sum = 0.0;
		final double missingValue = -404.0;
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			for(j = 0; j < columnNames.length; j++)
			{
				if (j != countryIndex && j != healthIndex)
					columnNames[j] = null;
			}
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				country = tokens[countryIndex];
				
				if (!country.equals(previousCountry))
				{
					if (count != 0 && (sum / count) < health)
					{
						for (j = 0; j < tokens.length; j++)
						{
							if (j == countryIndex)
								table[i][j] = previousCountry;
							
							if (j == healthIndex)
								table[i][j] = String.format("%.3g", (sum / count));
						}
						
						i++;
					}
					
					count = 0;
					sum = 0.0;
				}
				
				healthI = Double.parseDouble(tokens[healthIndex]);
				
				if (healthI != missingValue)
				{
					sum += healthI;
					count++;
				}
				
				previousCountry = country;
			}
			
			inputFile.close();
			
			System.out.println(i);
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		printTable();
		
		return table;
	}
	
	
	
	public String[][] readCountries_greater65pop(double percent)
	{
		table = new String[rows][cols]; //clear values in case a previous read function set values to something else
		final int countryIndex = 1, index65 = 17;
		String country = null;
		String previousCountry = "United Arab Emirates";
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0, count = 0;
		double percent65 = 0.0, sum = 0.0;
		final double missingValue = -404.0;
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			for(j = 0; j < columnNames.length; j++)
			{
				if (j != countryIndex && j != index65)
					columnNames[j] = null;
			}
			
			while (inputFile.hasNext() && i < rows)
			{
				tokens = inputFile.nextLine().split(",");
				
				country = tokens[countryIndex];			

				if (!country.equals(previousCountry))
				{
					if (count != 0 && (sum / count) > percent)
					{
						for (j = 0; j < tokens.length; j++)
						{
							if (j == countryIndex)
								table[i][j] = previousCountry;
							
							if (j == index65)
								table[i][j] = String.format("%.3g", (sum / count));
						}
						
						i++;
					}
					
					count = 0;
					sum = 0.0;
				}
				
				percent65 = Double.parseDouble(tokens[index65]);
				
				if (percent65 != missingValue)
				{
					sum += percent65;
					count++;
				}
				
				previousCountry = country;
			}
			
			inputFile.close();
			
			System.out.println(i);
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		printTable();
		
		return table;
	}
	
	public double[] getPop65_perCountry()
	{
		final int isoIndex = 0, index65 = 17, numCountries = 133;
		int i = 0;
		String[] tokens = null;
		String[] previousTokens = null;
		Scanner inputFile = null;
		double percent = 0.0;
		final double missingValue = -404.0;
		double[] populationsOver65 = new double[numCountries];
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			previousTokens = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (tokens[isoIndex].equals(previousTokens[isoIndex]))
				{
					previousTokens = tokens;
					continue;
				}
				
				percent = Double.parseDouble(previousTokens[index65]);
				if (percent == missingValue)
					percent = 0.0;
				
				populationsOver65[i] = percent;
				i++;
				
				previousTokens = tokens;
			}
			
			percent = Double.parseDouble(previousTokens[index65]);
			if (percent == missingValue)
				percent = 0.0;
			
			populationsOver65[i] = percent; //for the last country
			
			inputFile.close();
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		return populationsOver65;
	}
	
	public int[] getDeaths_perCountry()
	{
		final int isoIndex = 0, deathIndex = 10, numCountries = 133;
		int i = 0;
		String[] tokens = null;
		String[] previousTokens = null;
		Scanner inputFile = null;
		int deaths = 0;
		double temp = 0.0;
		final double missingValue = -404.0;
		int[] totalDeaths = new int[numCountries];
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			previousTokens = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (tokens[isoIndex].equals(previousTokens[isoIndex]))
				{
					previousTokens = tokens;
					continue;
				}
				
				temp = Double.parseDouble(previousTokens[deathIndex]);
				if (temp == missingValue)
					deaths = 0;
				else
					deaths = (int)temp;
				
				totalDeaths[i] = deaths;
				i++;
				
				previousTokens = tokens;
			}
			
			temp = Double.parseDouble(previousTokens[deathIndex]);
			if (temp == missingValue)
				deaths = 0;
			else
				deaths = (int)temp;
			
			totalDeaths[i] = deaths; //for the last country
			
			inputFile.close();
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		return totalDeaths;
	}
	
	public double[] getGDP_perCountry()
	{
		final int isoIndex = 0, gdpIndex = 13, numCountries = 133;
		int i = 0;
		String[] tokens = null;
		String[] previousTokens = null;
		Scanner inputFile = null;
		double gdp = 0.0;
		final double missingValue = -404.0;
		double[] countriesGDP = new double[numCountries];
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			previousTokens = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (tokens[isoIndex].equals(previousTokens[isoIndex]))
				{
					previousTokens = tokens;
					continue;
				}
				
				gdp = Double.parseDouble(previousTokens[gdpIndex]);
				if (gdp == missingValue)
					gdp = 0.0;
				
				countriesGDP[i] = gdp;
				i++;
				
				previousTokens = tokens;
			}
			
			gdp = Double.parseDouble(previousTokens[gdpIndex]);
			if (gdp == missingValue)
				gdp = 0.0;
			
			countriesGDP[i] = gdp; //for the last country
			
			inputFile.close();
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		return countriesGDP;
	}
	
	public int[] getTests_perCountry()
	{
		final int isoIndex = 0, testIndex = 12, numCountries = 133;
		int i = 0;
		String[] tokens = null;
		String[] previousTokens = null;
		Scanner inputFile = null;
		int tests = 0;
		double temp = 0.0;
		final double missingValue = -404.0;
		int[] totalTests = new int[numCountries];
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			previousTokens = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (tokens[isoIndex].equals(previousTokens[isoIndex]))
				{
					previousTokens = tokens;
					continue;
				}
				
				temp = Double.parseDouble(previousTokens[testIndex]);
				if (temp == missingValue)
					tests = 0;
				else
					tests = (int)temp;
				
				totalTests[i] = tests;
				i++;
				
				previousTokens = tokens;
			}
			
			temp = Double.parseDouble(previousTokens[testIndex]);
			if (temp == missingValue)
				tests = 0;
			else
				tests = (int)temp;
			
			totalTests[i] = tests; //for the last country
			
			inputFile.close();
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		return totalTests;
	}
	
	public String[] getIsos()
	{
		final int isoIndex = 1, numCountries = 133;
		int i = 0;
		String[] tokens = null;
		String[] previousTokens = null;
		Scanner inputFile = null;
		String[] isos = new String[numCountries];
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			previousTokens = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (tokens[isoIndex].equals(previousTokens[isoIndex]))
				{
					previousTokens = tokens;
					continue;
				}
				
				isos[i] = previousTokens[isoIndex];
				i++;
				
				previousTokens = tokens;
			}
			
			isos[i] = previousTokens[isoIndex]; //for the last country
			
			inputFile.close();
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		return isos;
	}
	
	
	
	public static void bubbleSort(DataStruct_IncrDesign[] array)
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