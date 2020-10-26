import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList; 

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        ArrayList<Data> dataList = new ArrayList<Data>();
        ArrayList<String> list = new ArrayList<String>();

        // -- Inputting CSV to the scanner -- 
        //Get scanner instance
        Scanner scanner = new Scanner(new File("COVID-19_SaveFile.txt"));
         
        //Set the delimiter used in file
        scanner.useDelimiter(",|\n");
         
        //Get all tokens and store them in some data structure 
        if (scanner.hasNext()) 
        {
            scanner.nextLine(); // skip header
        }
        
        while (scanner.hasNext()) 
            list.add(scanner.next());
       
        scanner.close();

        // Parsing all the data into accessable objects
        dataList = parse(list);

        // ------ END PARSING -------
        // All objects are stored in dataList
        

        // New Scanner for user search
        Scanner s = new Scanner(System.in);

      //  ****** Basic Search ********
        
      /*
        System.out.println("Enter Country to Search");
        String input = s.nextLine();
        search(input, dataList);
      */  

        // ****** Update *************
        /*
        System.out.println("Enter Country to update");
        String country = s.nextLine();
        System.out.println("From which date? YYYY-MM-DD");
        String date = s.nextLine();
        System.out.println("Which would you like to update? Cases/Deaths");
        String choice = s.nextLine();
        System.out.println("Enter the new Data?");
        String newData = s.nextLine();
        update(country, date, choice, newData, dataList);
        saveToFile(dataList);
        
       

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Country to Search");
        String input = sc.nextLine();
        search(input, dataList);
        */
        

        // ****** Delete Entire Row **********
        
        System.out.println("Enter Country to Delete");
        String country = s.nextLine();
        System.out.println("From which date? YYYY-MM-DD");
        String date = s.nextLine();
        delete(country, date, dataList);
        saveToFile(dataList);

        System.out.println("Enter Country to Search");
        String input = s.nextLine();
        search(input, dataList);
        

        // ********* Insert **********
        // Only inserting a few inputs
        
        /*
        System.out.println("Enter Country to Insert");
        String country = s.nextLine();
        System.out.println("Enter New date? YYYY-MM-DD");
        String date = s.nextLine();
        System.out.println("Enter Cases?");
        String cases = s.nextLine();
        System.out.println("Enter Deaths?");
        String deaths = s.nextLine();
        insert(country, date, cases, deaths, dataList);
        saveToFile(dataList);

        System.out.println("Enter Country to Search");
        String input = s.nextLine();
        search(input, dataList);
        */

        s.close();
    }

    public static void saveToFile(ArrayList<Data> dataList)
    {
        ArrayList<String> strings = new ArrayList<String>();

        for(int i = 0; i < dataList.size(); i++)
        {
            String temp = dataList.get(i).toCSV();
            strings.add(temp);
        }
        
        try 
        {
            FileWriter myWriter = new FileWriter("COVID-19_SaveFile.txt");

            for(int i = 0; i < strings.size(); i++)
            {
                myWriter.write(strings.get(i));
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void insert(String country, String date, String cases, String deaths, ArrayList<Data> dataList)
    {
        // Setting only 3 fields just for now
        Data data = new Data();
        data.setCountry(country);
        data.setDate(date);
        data.setCases(cases);
        data.setDeaths(deaths);
        dataList.add(data);
    }

    public static void delete(String country, String date, ArrayList<Data> dataList)
    {
        for(int i = 0; i < dataList.size(); i++)
        {
            if(country.equals(dataList.get(i).getCountry()) && date.equals(dataList.get(i).getDate()))
            {
                dataList.remove(i);
                dataList.remove(new Data());
            }
        } 

        System.out.println("Row Deleted");
    }

    public static void update(String country, String date, String choice, String newData, ArrayList<Data> dataList)
    {
        // Only updating cases or deaths for simplicity. Can change later
        for(int i = 0; i < dataList.size(); i++)
        {
            if(country.equals(dataList.get(i).getCountry()) && date.equals(dataList.get(i).getDate()))
            {
                if(choice.equals("Cases"))
                {
                    dataList.get(i).setCases(newData);
                }
                else if(choice.equals("Deaths"))
                {
                    dataList.get(i).setDeaths(newData);
                }
               
            }
        } 
    }

    public static void search(String input, ArrayList<Data> dataList)
    {
        for(int i = 0; i < dataList.size(); i++)
        {
            if(input.equals(dataList.get(i).getCountry()))
            {
                dataList.get(i).print();
            }
        } 
    }

    public static ArrayList<Data> parse(ArrayList<String> list)
    {
        ArrayList<Data> dataList = new ArrayList<Data>();

        int counter = 0;
        while(counter < list.size())
        {
            Data data = new Data();
            data.setIso(list.get(counter));
            counter++;
            data.setCountry(list.get(counter));
            counter++;
            data.setDate(list.get(counter));
            counter++;
            data.setGrocery(list.get(counter));
            counter++;
            data.setParks(list.get(counter));
            counter++;
            data.setResidential(list.get(counter));
            counter++;
            data.setRetail(list.get(counter));
            counter++;
            data.setTransit(list.get(counter));
            counter++;
            data.setWorkplace(list.get(counter));
            counter++;
            data.setCases(list.get(counter));
            counter++;
            data.setDeaths(list.get(counter));
            counter++;
            data.setGovResponses(list.get(counter));
            counter++;
            data.setTotalTest(list.get(counter));
            counter++;
            data.setGdp(list.get(counter));
            counter++;
            data.setPopulation(list.get(counter));
            counter++;
            data.setPopulationDensity(list.get(counter));
            counter++;
            data.setHumanDev(list.get(counter));
            counter++;
            data.setPopAge(list.get(counter));
            counter++;
            data.setHealthIndex(list.get(counter));
            counter++;
            dataList.add(data);
            
        }

        return dataList;
    }
}
