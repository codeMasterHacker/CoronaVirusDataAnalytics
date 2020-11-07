import java.io.*;
import java.util.*;

public class CovidFile implements Serializable //will handle only reads
{
	private static final long serialVersionUID = 1L;
	private int cols; //no setters for this field
	private int rows; //no setters for this field
	
	private String[][] table; //no getters and setters for this field
	private String[] columnNames; //no setters for this field
	
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
	
	private int countRows()
	{
		Scanner inputFile = null;
		int count = -1; ////-1 because I'm not counting the column names at the beginning
		
		try
		{
			inputFile = new Scanner(covidFile);
			
			while (inputFile.hasNext())
			{
				inputFile.nextLine();
				count++;
			}
			
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
	
	private int cleanData()
	{
		String[] tokens = null;
		String[] temp = null;
		String oldPath = covidFile.getAbsolutePath();
		String newPath = null;
		String missingValue = "-404.0";
		
		Scanner inputFile = null;
		PrintWriter outputFile = null;
		File newFile = null;
		
		StringBuilder path = null;
		
		int i = 0, fileSize = -1; //-1 because I'm not counting the column names at the beginning
		
		try
		{
			inputFile = new Scanner(covidFile);
			
			path = new StringBuilder(oldPath);
			path.insert(oldPath.length()-4, "_0"); // ".csv" has 4 characters
			
			newPath = path.toString();
			newFile = new File(newPath);
			
			outputFile = new PrintWriter(newFile);
			
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
			}
			
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
						if (j == caseIndex && tokens[dateIndex].equals(endDate))
						{
							cases.add(Double.parseDouble(tokens[j]));
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
		
	
		return cases;
	}

	public double getCases()
	{
		final int casesIndex = 9;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		double cases = 0;
		
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
					if (j == casesIndex)
					{
						cases = cases + Double.parseDouble(tokens[j]);
					}
				}
				
				i++;
				
			}
			
			inputFile.close();
			System.out.println(i);
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
		int i = 0, j = 0;
		boolean flag = true;
		double cases = 0;
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				flag = false;
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				for (j = 0; j < tokens.length; j++)
				{
					if (j == casesIndex)
					{
						cases = cases + Double.parseDouble(tokens[j]);
					}
				}
				
				i++;
				
			}
			
			inputFile.close();
			
			System.out.println(i);
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
		}
		
		return cases;
	}
	
	
	public double getDeaths()
	{
		final int deathsIndex = 10;
		String[] tokens = null;
		Scanner inputFile = null;
		int i = 0, j = 0;
		boolean flag = true;
		double cases = 0;
		double deaths = 0;
		
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
					if (j == deathsIndex)
					{
						deaths = deaths + Double.parseDouble(tokens[j]);
					}
				}
				
				i++;
				
			}
			
			inputFile.close();
			
			System.out.println(i);
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
		int i = 0, j = 0;
		boolean flag = true;
		double cases = 0;
		double deaths = 0;
		
		try 
		{
			inputFile = new Scanner(covidFile);
			
			columnNames = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				flag = false;
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				for (j = 0; j < tokens.length; j++)
				{
					if (j == deathsIndex)
					{
						deaths = deaths + Double.parseDouble(tokens[j]);
					}
				}
				
				i++;
				
			}
			
			inputFile.close();
			
			System.out.println(i);
		} 
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
		}
		
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
			startDate = "2020-02-15";
			endDate = "2020-2-29";
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
				
				flag = false;
				for (j = 0; j < tokens.length; ++j) { //iterate thru tokens/vals in tokens array or csv line
					if(j == workplaceIndex) {
						//ID'd column with workPlaxe value? add it into list, then
						workplaceMonthlyTrend.add(Double.parseDouble(tokens[j]));
						System.out.print(workplaceMonthlyTrend.get(i) + "\n");
						break;
						//escape initial for loop
					}
				}
				++i; //not sure what this is for atm
				
				if(tokens[dateIndex].equals(endDate)) {
					break;
				}
				
			}
			inputFile.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		return workplaceMonthlyTrend;
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
}