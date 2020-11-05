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
	
	public double[][] getCountryWorkplaceTrends(String country)
	{
		
		table1 = new double[rows][cols]; //clear values in case a previous read function set values to something else
		final int countryIndex = 1, workplaceIndex = 8;
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