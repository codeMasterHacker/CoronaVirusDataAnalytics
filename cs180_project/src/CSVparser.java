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
	
	public String[][] parse()
	{
		String[] tokens = null;
		String token = null;
		final String notApplicable = "N/A";
		
		Scanner inputFile = null;
		
		int i = 0, j = 0;
		
		try 
		{
			inputFile = new Scanner(new File(filePath));
			
			while (inputFile.hasNext() && i < rows)
			{
				tokens = inputFile.nextLine().split(",");
				
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
		catch (FileNotFoundException e) 
		{ 
			e.printStackTrace(); 
			return null;
		}
		
		return values;
	}
	
	
	
	public String[][] parse(String country, String startDate, String endDate)
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
}
