import java.io.*;
import java.util.*;

public class CSVparser implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private int rows;
	private int cols;
	
	private String[][] values = null;
	private String[] columnNames = null;
	private String filePath = null;
	
	public CSVparser(String path, int rows, int columns)
	{
		this.rows = rows;
		cols = columns;
		
		values = new String[this.rows][cols];
		
		filePath = path;
	}
	
	public String[] getColumnNames() { return columnNames; }
	/*
	private void align()
	{
		String[] tokens = null;
		String[] temp = null;
		String line = null;
		final String notApplicable = "N/A";
		
		Scanner inputFile = null;
		
		int i = 0, j = 0;
		
		try 
		{
			inputFile = new Scanner(new File(filePath));
			
			while (inputFile.hasNext() && i < rows)
			{
				tokens = inputFile.nextLine().split(",");
				
				if (tokens.length != cols) //has empty string or no last value
				{
					temp = new String[cols];
					
					for (j = 0; j < tokens.length; j++) //takes cares of empty strings
					{
						if (tokens[j].isEmpty())
							temp[j] = notApplicable;
						else
							temp[j] = tokens[j];
						
						line = temp[j] + "," + line;
					}
					
					if (j == (cols-1)) //takes care of no last value
						line = notApplicable + "," + line;
				}
				
				
				
				
				for (j = 0; j < tokens.length; j++)
				{
					token = tokens[j];
					
					if (token.isEmpty())
						values[i][j] = notApplicable;
					else
						values[i][j] = token;
					
					System.out.print(values[i][j] + " ");
				}
				
				if (j == cols-1)
				{
					values[i][j] = notApplicable;
					System.out.print(values[i][j]);
				}
				System.out.println();
				
				i++;
			}
			
			inputFile.close();
			
			System.out.println(i);
		} 
		catch (FileNotFoundException e) { e.printStackTrace(); }
	}
	*/
	
	
	public String[][] getAll(String country, String startDate, String endDate)
	{
		final int countryIndex = 1, dateIndex = 2;
		
		String[] tokens = null;
		String token = null;
		final String notApplicable = "N/A";
		
		Scanner inputFile = null;
		
		int i = 0, j = 0;
		
		boolean flag = true;
		
		try 
		{
			inputFile = new Scanner(new File(filePath));
			
			columnNames = inputFile.nextLine().split(",");
			
			while (inputFile.hasNext() && i < rows)
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				if (!tokens[dateIndex].equals(startDate) && flag)
					continue;
				
				flag = false;
				
				for (j = 0; j < tokens.length; j++)
				{
					token = tokens[j];
					
					if (token.isEmpty())
						values[i][j] = notApplicable;
					else
						values[i][j] = token;
					
					System.out.print(values[i][j] + " ");
				}
				
				if (j == cols-1)
				{
					values[i][j] = notApplicable;
					System.out.print(values[i][j]);
				}
				System.out.println();
				
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
		
		return values;
	}
	
	
	
	public String[][] get_casesDeaths(String country, String startDate, String endDate)
	{
		final int countryIndex = 1, dateIndex = 2, casesIndex = 9, deathsIndex = 10;
		
		String[] tokens = null;
		String token = null;
		final String notApplicable = "N/A";
		
		Scanner inputFile = null;
		
		int i = 0, j = 0;
		
		boolean flag = true;
		
		try 
		{
			inputFile = new Scanner(new File(filePath));
			
			columnNames = inputFile.nextLine().split(",");
			
			columnNames[0] = null; 
			columnNames[3] = null; 
			columnNames[4] = null; 
			columnNames[5] = null; 
			columnNames[6] = null; 
			columnNames[7] = null; 
			columnNames[8] = null; 
			columnNames[11] = null; 
			columnNames[12] = null; 
			columnNames[13] = null; 
			columnNames[14] = null; 
			columnNames[15] = null; 
			columnNames[16] = null; 
			columnNames[17] = null; 
			columnNames[18] = null;
			
			while (inputFile.hasNext() && i < rows)
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				if (!tokens[dateIndex].equals(startDate) && flag)
					continue;
				
				flag = false;
				
				for (j = 0; j < tokens.length; j++)
				{
					if (j != countryIndex && j != dateIndex && j != casesIndex && j != deathsIndex)
						continue;
					
					token = tokens[j];
					
					if (token.isEmpty())
						values[i][j] = notApplicable;
					else
						values[i][j] = token;
					
					System.out.print(values[i][j] + " ");
				}
				
				if (j == cols-1)
				{
					values[i][j] = notApplicable;
					System.out.print(values[i][j]);
				}
				System.out.println();
				
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
		
		return values;
	}
	
	
	
	
	public String[][] get_testsPop(String country)
	{
		final int countryIndex = 1, testsIndex = 12, popIndex = 14;
		
		String[] tokens = null;
		String token = null;
		final String notApplicable = "N/A";
		
		Scanner inputFile = null;
		
		int i = 0, j = 0;
		
		try 
		{
			inputFile = new Scanner(new File(filePath));
			
			columnNames = inputFile.nextLine().split(",");
			
			columnNames[0] = null; 
			columnNames[2] = null; 
			columnNames[3] = null; 
			columnNames[4] = null; 
			columnNames[5] = null; 
			columnNames[6] = null; 
			columnNames[7] = null; 
			columnNames[8] = null; 
			columnNames[9] = null; 
			columnNames[10] = null; 
			columnNames[11] = null; 
			columnNames[13] = null; 
			columnNames[15] = null; 
			columnNames[16] = null; 
			columnNames[17] = null; 
			columnNames[18] = null;
			
			while (inputFile.hasNext() && i < rows)
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				for (j = 0; j < tokens.length; j++)
				{
					if (j != countryIndex && j != testsIndex && j != popIndex)
						continue;
					
					token = tokens[j];
					
					if (token.isEmpty())
						values[i][j] = notApplicable;
					else
						values[i][j] = token;
					
					System.out.print(values[i][j] + " ");
				}
				
				if (j == cols-1)
				{
					values[i][j] = notApplicable;
					System.out.print(values[i][j]);
				}
				System.out.println();
				
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
		
		return values;
	}
	
	
	
	
	
	public String[][] getCountries_healthIndex(double health)
	{
		final int countryIndex = 1, healthIndex = 18;
		
		final String notApplicable = "N/A";
		String[] tokens = null;
		String[] temp = null;
		
		double healthI = 0.0, prevHealth = -1.0;
		
		Scanner inputFile = null;
		
		int i = 0, j = 0;
		
		try 
		{
			inputFile = new Scanner(new File(filePath));
			
			columnNames = inputFile.nextLine().split(",");
			
			columnNames[0] = null; 
			columnNames[2] = null; 
			columnNames[3] = null; 
			columnNames[4] = null; 
			columnNames[5] = null; 
			columnNames[6] = null; 
			columnNames[7] = null; 
			columnNames[8] = null; 
			columnNames[9] = null; 
			columnNames[10] = null; 
			columnNames[11] = null; 
			columnNames[12] = null; 
			columnNames[13] = null; 
			columnNames[14] = null; 
			columnNames[15] = null; 
			columnNames[16] = null; 
			columnNames[17] = null; 
			
			while (inputFile.hasNext() && i < rows)
			{
				tokens = inputFile.nextLine().split(",");
				
				if (tokens.length != cols) //has no last value
				{
					temp = new String[cols];
					
					for (j = 0; j < tokens.length; j++) //takes cares of empty strings
					{
						if (tokens[j].isEmpty())
							temp[j] = notApplicable;
						else
							temp[j] = tokens[j];
					}
					
					for (; j < cols; j++) //takes cares of extra empty strings
					{
						if (temp[j] == null)
							temp[j] = notApplicable;
					}
					
					tokens = temp;
				}
				
				if (tokens[healthIndex].equals(notApplicable))
					healthI = 0.0;
				else
					healthI = Double.parseDouble(tokens[healthIndex]);
				
				if (healthI >= health || healthI == 0.0 || prevHealth == healthI)
					continue;
				
				prevHealth = healthI;
				
				for (j = 0; j < tokens.length; j++)
				{
					if (j != countryIndex && j != healthIndex)
						continue;
					
					values[i][j] = tokens[j];
					
					System.out.print(values[i][j] + " ");
				}
				
				System.out.println();
				
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
		catch (NullPointerException e)
		{
			e.printStackTrace(); 
			return null;
		}
		
		return values;
	}
	
	
	
	
	
	public String[][] getBaselines(String country)
	{
		final int countryIndex = 1, b1index = 3, b2index = 4, b3index = 5, b4index = 6, b5index = 7, b6index = 8;
		
		String[] tokens = null;
		String token = null;
		final String notApplicable = "N/A";
		
		Scanner inputFile = null;
		
		int i = 0, j = 0;
		
		try 
		{
			inputFile = new Scanner(new File(filePath));
			
			columnNames = inputFile.nextLine().split(",");
			
			columnNames[0] = null; 
			columnNames[2] = null;  
			columnNames[9] = null; 
			columnNames[10] = null; 
			columnNames[11] = null; 
			columnNames[12] = null; 
			columnNames[13] = null; 
			columnNames[14] = null; 
			columnNames[15] = null; 
			columnNames[16] = null; 
			columnNames[17] = null; 
			columnNames[18] = null;
			
			while (inputFile.hasNext() && i < rows)
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!tokens[countryIndex].equals(country))
					continue;
				
				for (j = 0; j < tokens.length; j++)
				{
					if (j != countryIndex && j != b1index && j != b2index && j != b3index && j != b4index && j != b5index && j != b6index)
						continue;
					
					token = tokens[j];
					
					if (token.isEmpty())
						values[i][j] = notApplicable;
					else
						values[i][j] = token;
					
					System.out.print(values[i][j] + " ");
				}
				
				if (j == cols-1)
				{
					values[i][j] = notApplicable;
					System.out.print(values[i][j]);
				}
				System.out.println();
				
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
		
		return values;
	}
	
	
	
	
	
	
	public String[][] getCountries_65pop(double percent)
	{
		final int countryIndex = 1, index65 = 17;
		
		final String notApplicable = "N/A";
		String[] tokens = null;
		String[] temp = null;
		
		double percent65 = 0.0, prevPercent65 = -1.0;
		
		Scanner inputFile = null;
		
		int i = 0, j = 0;
		
		try 
		{
			inputFile = new Scanner(new File(filePath));
			
			columnNames = inputFile.nextLine().split(",");
			
			columnNames[0] = null; 
			columnNames[2] = null; 
			columnNames[3] = null; 
			columnNames[4] = null; 
			columnNames[5] = null; 
			columnNames[6] = null; 
			columnNames[7] = null; 
			columnNames[8] = null; 
			columnNames[9] = null; 
			columnNames[10] = null; 
			columnNames[11] = null; 
			columnNames[12] = null; 
			columnNames[13] = null; 
			columnNames[14] = null; 
			columnNames[15] = null; 
			columnNames[16] = null; 
			columnNames[18] = null; 
			
			while (inputFile.hasNext() && i < rows)
			{
				tokens = inputFile.nextLine().split(",");
				
				for (j = 0; j < tokens.length; j++) //takes cares of empty strings
				{
					if (tokens[j].isEmpty())
						tokens[j] = notApplicable;
				}
				
				
				
				
				if (tokens.length != cols) //has no last value
				{
					temp = new String[cols];
					
					for (j = 0; j < tokens.length; j++) //takes cares of empty strings
					{
						if (tokens[j].isEmpty())
							temp[j] = notApplicable;
						else
							temp[j] = tokens[j];
					}
					
					for (; j < cols; j++) //takes cares of extra empty strings
					{
						if (temp[j] == null)
							temp[j] = notApplicable;
					}
					
					tokens = temp;
				}
				
				
				
				
				
				if (tokens[index65].equals(notApplicable))
					percent65 = 0.0;
				else
					percent65 = Double.parseDouble(tokens[index65]);
				
				if (percent65 <= percent || percent65 == 0.0 || prevPercent65 == percent65)
					continue;
				
				prevPercent65 = percent65;
				
				for (j = 0; j < tokens.length; j++)
				{
					if (j != countryIndex && j != index65)
						continue;
					
					values[i][j] = tokens[j];
					
					System.out.print(values[i][j] + " ");
				}
				
				System.out.println();
				
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
		catch (NullPointerException e)
		{
			e.printStackTrace(); 
			return null;
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace(); 
			return null;
		}
		
		return values;
	}
}