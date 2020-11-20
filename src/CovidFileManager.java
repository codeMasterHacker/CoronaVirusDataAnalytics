import java.io.*;
import java.util.*;

public class CovidFileManager implements Serializable
{
	private static final long serialVersionUID = 1L;
	private CovidFile[] covidFiles;
	private final int numFiles = 10;
	private int currentIndex = 0; //most recent file
	
	public CovidFileManager(String path)
	{
		File[] files = new File(path).listFiles(new FilenameFilter() 
		{
	        @Override
	        public boolean accept(File dir, String name) 
	        {
	            return !name.equals(".DS_Store");
	        }
	    });
		
		bubbleSort(files);
		
		int i;
		covidFiles = new CovidFile[numFiles];
		for (i = 0; i < files.length; i++)
			covidFiles[i] = new CovidFile(files[i]);
		
		currentIndex = i-1; //because a for loop is a pre-conditional loop
	}
	
	private static void bubbleSort(File[] array) 
	{
		int lastPos, index;
		File temp;
		
		for (lastPos = array.length - 1; lastPos >= 0; lastPos--)
		{
			for (index = 0; index <= lastPos - 1; index++)
			{
				if (array[index].lastModified() > array[index + 1].lastModified())
				{
					temp = array[index]; 
					array[index] = array[index + 1]; 
					array[index + 1] = temp;
				}
			}
		}
	}
	
	public CovidFile getCurrent_covidFile()
	{
		return covidFiles[currentIndex];
	}
	
	private boolean dates_areSequential(String previousDate, String nextDate)
	{
		int previousYear = Integer.parseInt(previousDate.substring(0, 4));
		int nextYear = Integer.parseInt(nextDate.substring(0, 4));
		
		int previousMonth = Integer.parseInt(previousDate.substring(5, 7));
		int nextMonth = Integer.parseInt(nextDate.substring(5, 7));
		
		int previousDay = Integer.parseInt(previousDate.substring(8)) - 1;
		int nextDay = Integer.parseInt(nextDate.substring(8)) - 1; // - 1 helps with modulo
		
		//if -> expected case; previous: 2020-10-29, next: 2020-10-30
		//else if -> edge cases; previous: 2020-10-31, next: 2020-11-01; previous: 2020-12-31, next: 2021-01-01
		if (nextDay == previousDay + 1 || nextDay == ((previousDay + 1) % 30) || nextDay == ((previousDay + 1) % 31))
		{
			if (nextMonth == previousMonth)
			{
				if (nextYear == previousYear)
					return true;
				else
					return false;
			}
			else if (nextMonth == 1 && previousMonth == 12) //checks for December to January dates
			{
				if (nextYear == previousYear + 1)
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean insert(String csv) //country and date order
	{
		final int countryIndex = 1, dateIndex = 2;
		
		String[] row = csv.split(",");
		
		String currentPath = covidFiles[currentIndex].getFile().getAbsolutePath();
		char ch = currentPath.charAt(currentPath.length()-5);
		int fileNum = ch - '0';	
		int i = 0, new_fileNum = (fileNum+1) % numFiles;
		boolean inserted = false, datesSeq = false;
		
		// /Users/Enrique/Desktop/covidFiles/COVID-19_0.csv after cleaning original
		StringBuilder path = new StringBuilder(currentPath);
		path.replace(currentPath.length()-5, currentPath.length()-4, String.valueOf(new_fileNum));
		
		String newPath = path.toString();
		String[] tokens = null;
		
		Scanner inputFile = null;
		PrintWriter outputFile = null;
		File newFile = new File(newPath);
		
		try
		{
			inputFile = new Scanner(covidFiles[currentIndex].getFile());
			outputFile = new PrintWriter(newFile);
			outputFile.flush();
			
			tokens = inputFile.nextLine().split(","); //reads the column names
			for (i = 0; i < tokens.length-1; i++)
			{
				outputFile.print(tokens[i] + ","); //writes column names to new file
				outputFile.flush();
			}
			outputFile.println(tokens[i]);
			outputFile.flush();
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				for (i = 0; i < tokens.length-1; i++)
				{
					outputFile.print(tokens[i] + ",");
					outputFile.flush();
				}
				outputFile.println(tokens[i]);
				outputFile.flush();
				
				datesSeq = dates_areSequential(tokens[dateIndex], row[dateIndex]);
				
				if (!inserted && tokens[countryIndex].equals(row[countryIndex]) && datesSeq)
				{
					inserted = true;
					
					for (i = 0; i < row.length-1; i++)
					{
						outputFile.print(row[i] + ",");
						outputFile.flush();
					}
					outputFile.println(row[i]);
					outputFile.flush();
				}
			}
			
			currentIndex = (currentIndex + 1) % numFiles;
			covidFiles[currentIndex] = new CovidFile(newFile);
			
			inputFile.close();
			outputFile.close();
		}
		catch(IOException e) 
		{ 
			e.printStackTrace(); 
			inputFile.close();
			return false;
		}
		
		if (inserted)
			return true;
		else //meaning we just copied
			return false;
	}
	
	public boolean update(String csv) //check for non update values
	{
		final int countryIndex = 1, dateIndex = 2;
		
		String[] row = csv.split(",");
		
		String currentPath = covidFiles[currentIndex].getFile().getAbsolutePath();
		
		char ch = currentPath.charAt(currentPath.length()-5);
		int fileNum = ch - '0';	
		int i = 0, new_fileNum = (fileNum+1) % numFiles;
		boolean updated = false;
		
		// /Users/Enrique/Desktop/covidFiles/COVID-19_0.csv after cleaning original
		StringBuilder path = new StringBuilder(currentPath);
		path.replace(currentPath.length()-5, currentPath.length()-4, String.valueOf(new_fileNum));
		
		String nonupdateValue = "*";
		String newPath = path.toString();
		String[] tokens = null;
		
		Scanner inputFile = null;
		PrintWriter outputFile = null;
		File newFile = new File(newPath);
		
		try
		{
			inputFile = new Scanner(covidFiles[currentIndex].getFile());
			outputFile = new PrintWriter(newFile);
			outputFile.flush();
			
			tokens = inputFile.nextLine().split(","); //reads the column names
			for (i = 0; i < tokens.length-1; i++)
			{
				outputFile.print(tokens[i] + ","); //writes column names to new file
				outputFile.flush();
			}
			outputFile.println(tokens[i]);
			outputFile.flush();
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!updated && tokens[countryIndex].equals(row[countryIndex]) && tokens[dateIndex].equals(row[dateIndex]))
				{
					updated = true;
					
					for (i = 0; i < row.length-1; i++) //check for non update values, maybe the user doesn't want to update everything
					{
						if (row[i].equals(nonupdateValue))
							outputFile.print(tokens[i] + ",");
						else
							outputFile.print(row[i] + ",");
						outputFile.flush();
					}
					
					if (row[i].equals(nonupdateValue))
						outputFile.println(tokens[i]);
					else
						outputFile.println(row[i]);
					outputFile.flush();
				}
				else //not the row we want to update
				{
					for (i = 0; i < tokens.length-1; i++)
					{
						outputFile.print(tokens[i] + ",");
						outputFile.flush();
					}
					outputFile.println(tokens[i]);
					outputFile.flush();
				}
			}
			
			currentIndex = (currentIndex + 1) % numFiles;
			covidFiles[currentIndex] = new CovidFile(newFile);
			
			inputFile.close();
			outputFile.close();
		}
		catch(IOException e) 
		{ 
			e.printStackTrace(); 
			inputFile.close();
			return false;
		}
		
		if (updated)
			return true;
		else //meaning we just copied
			return false;
	}
	
	public boolean update(String csv, int[] tests) //check for non update values
	{
		final int countryIndex = 1, dateIndex = 2, testIndex = 12;
		
		String[] row = csv.split(",");
		
		String currentPath = covidFiles[currentIndex].getFile().getAbsolutePath();
		
		char ch = currentPath.charAt(currentPath.length()-5);
		int fileNum = ch - '0';	
		int i = 0, new_fileNum = (fileNum+1) % numFiles, currTests = 0, prevTests = 0;
		boolean updated = false;
		
		// /Users/Enrique/Desktop/covidFiles/COVID-19_0.csv after cleaning original
		StringBuilder path = new StringBuilder(currentPath);
		path.replace(currentPath.length()-5, currentPath.length()-4, String.valueOf(new_fileNum));
		
		String nonupdateValue = "*";
		String newPath = path.toString();
		String[] tokens = null;
		
		Scanner inputFile = null;
		PrintWriter outputFile = null;
		File newFile = new File(newPath);
		
		try
		{
			inputFile = new Scanner(covidFiles[currentIndex].getFile());
			outputFile = new PrintWriter(newFile);
			outputFile.flush();
			
			tokens = inputFile.nextLine().split(","); //reads the column names
			for (i = 0; i < tokens.length-1; i++)
			{
				outputFile.print(tokens[i] + ","); //writes column names to new file
				outputFile.flush();
			}
			outputFile.println(tokens[i]);
			outputFile.flush();
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!updated && tokens[countryIndex].equals(row[countryIndex]))
				{
					currTests = (int)Double.parseDouble(tokens[testIndex]);
					if (currTests == -404)
						currTests = 0;
					
					if (tokens[dateIndex].equals(row[dateIndex]))
					{
						updated = true;
						
						for (i = 0; i < row.length-1; i++) //check for non update values, maybe the user doesn't want to update everything
						{
							if (row[i].equals(nonupdateValue))
								outputFile.print(tokens[i] + ",");
							else
								outputFile.print(row[i] + ",");
							outputFile.flush();
						}
						
						if (row[i].equals(nonupdateValue))
							outputFile.println(tokens[i]);
						else
							outputFile.println(row[i]);
						outputFile.flush();
						
						if (currTests == 0)
							tests[0] = (int)Double.parseDouble(row[testIndex]) - prevTests;
						else
							tests[0] = (int)Double.parseDouble(row[testIndex]) - currTests;
					}
					else //not the row we want to update
					{
						for (i = 0; i < tokens.length-1; i++)
						{
							outputFile.print(tokens[i] + ",");
							outputFile.flush();
						}
						outputFile.println(tokens[i]);
						outputFile.flush();
					}
					
					if (currTests != 0)
						prevTests = currTests;
				}
				else //not the row we want to update
				{
					for (i = 0; i < tokens.length-1; i++)
					{
						outputFile.print(tokens[i] + ",");
						outputFile.flush();
					}
					outputFile.println(tokens[i]);
					outputFile.flush();
				}
			}
			
			currentIndex = (currentIndex + 1) % numFiles;
			covidFiles[currentIndex] = new CovidFile(newFile);
			
			inputFile.close();
			outputFile.close();
		}
		catch(IOException e) 
		{ 
			e.printStackTrace(); 
			inputFile.close();
			return false;
		}
		
		if (updated)
			return true;
		else //meaning we just copied
			return false;
	}
	
	public boolean delete(String country, String date)
	{
		final int countryIndex = 1, dateIndex = 2;
		
		String currentPath = covidFiles[currentIndex].getFile().getAbsolutePath();
		
		char ch = currentPath.charAt(currentPath.length()-5);
		int fileNum = ch - '0';
		int new_fileNum = (fileNum+1) % numFiles;
		int i = 0;
		boolean deleted = false;
		
		// /Users/Enrique/Desktop/covidFiles/COVID-19_0.csv after cleaning original
		StringBuilder path = new StringBuilder(currentPath);
		path.replace(currentPath.length()-5, currentPath.length()-4, String.valueOf(new_fileNum));
		
		String newPath = path.toString();
		String[] tokens = null;
		
		Scanner inputFile = null;
		PrintWriter outputFile = null;
		File newFile = new File(newPath);
		
		try
		{
			inputFile = new Scanner(covidFiles[currentIndex].getFile());
			outputFile = new PrintWriter(newFile);
			outputFile.flush();
			
			tokens = inputFile.nextLine().split(","); //reads the column names
			for (i = 0; i < tokens.length-1; i++)
			{
				outputFile.print(tokens[i] + ","); //writes column names to new file
				outputFile.flush();
			}
			outputFile.println(tokens[i]);
			outputFile.flush();
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!deleted && tokens[countryIndex].equals(country) && tokens[dateIndex].equals(date))
				{
					deleted = true;
					continue;
				}
				
				for (i = 0; i < tokens.length-1; i++)
				{
					outputFile.print(tokens[i] + ","); //writes column names to new file
					outputFile.flush();
				}
				outputFile.println(tokens[i]);
				outputFile.flush();
			}
			
			currentIndex = (currentIndex + 1) % numFiles;
			covidFiles[currentIndex] = new CovidFile(newFile);
			
			inputFile.close();
			outputFile.close();
		}
		catch(IOException e) 
		{ 
			e.printStackTrace(); 
			inputFile.close();
			return false;
		}
		
		if (deleted)
			return true;
		else //meaning we just copied
			return false;
	}
	
	public boolean delete(String country, String date, int[] tests)
	{
		final int countryIndex = 1, dateIndex = 2, testIndex = 12;
		
		String currentPath = covidFiles[currentIndex].getFile().getAbsolutePath();
		
		char ch = currentPath.charAt(currentPath.length()-5);
		int fileNum = ch - '0';
		int new_fileNum = (fileNum+1) % numFiles;
		int i = 0, currTests = 0, prevTests = 0;
		boolean deleted = false;
		
		// /Users/Enrique/Desktop/covidFiles/COVID-19_0.csv after cleaning original
		StringBuilder path = new StringBuilder(currentPath);
		path.replace(currentPath.length()-5, currentPath.length()-4, String.valueOf(new_fileNum));
		
		String newPath = path.toString();
		String[] tokens = null;
		
		Scanner inputFile = null;
		PrintWriter outputFile = null;
		File newFile = new File(newPath);
		
		try
		{
			inputFile = new Scanner(covidFiles[currentIndex].getFile());
			outputFile = new PrintWriter(newFile);
			outputFile.flush();
			
			tokens = inputFile.nextLine().split(","); //reads the column names
			for (i = 0; i < tokens.length-1; i++)
			{
				outputFile.print(tokens[i] + ","); //writes column names to new file
				outputFile.flush();
			}
			outputFile.println(tokens[i]);
			outputFile.flush();
			
			while (inputFile.hasNext())
			{
				tokens = inputFile.nextLine().split(",");
				
				if (!deleted && tokens[countryIndex].equals(country))
				{
					currTests = (int)Double.parseDouble(tokens[testIndex]);
					if (currTests == -404)
						currTests = 0;
					
					if (tokens[dateIndex].equals(date))
					{
						deleted = true;
						
						if (currTests == 0)
							tests[0] = currTests;
						else
							tests[0] = currTests - prevTests;
						
						continue;
					}
					
					if (currTests != 0)
						prevTests = currTests;
				}
				
				for (i = 0; i < tokens.length-1; i++)
				{
					outputFile.print(tokens[i] + ","); //writes column names to new file
					outputFile.flush();
				}
				outputFile.println(tokens[i]);
				outputFile.flush();
			}
			
			currentIndex = (currentIndex + 1) % numFiles;
			covidFiles[currentIndex] = new CovidFile(newFile);
			
			inputFile.close();
			outputFile.close();
		}
		catch(IOException e) 
		{ 
			e.printStackTrace(); 
			inputFile.close();
			return false;
		}
		
		if (deleted)
			return true;
		else //meaning we just copied
			return false;
	}
	
	public boolean goto_previousFile()
	{
		if (currentIndex > 0)
		{
			covidFiles[currentIndex].getFile().delete();
			covidFiles[currentIndex] = null;
			
			currentIndex -= 1; 
			
			return true;
		}
		else
			return false;
	}
}