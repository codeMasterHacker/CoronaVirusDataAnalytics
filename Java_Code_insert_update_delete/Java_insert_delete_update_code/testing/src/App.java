import java.io.File;
import java.io.FileNotFoundException;
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
        Scanner scanner = new Scanner(new File("COVID-19_Copy.csv"));
         
        //Set the delimiter used in file
        scanner.useDelimiter(",|\n");
         
        //Get all tokens and store them in some data structure 
        if (scanner.hasNext()) 
        {
            // skip header line
            scanner.nextLine();
        }
        
        while (scanner.hasNext()) 
        {
            list.add(scanner.next());
        }
       
        //Do not forget to close the scanner  
        scanner.close();
        
        // -- Scanner Ending -- 

        // Parsing all the data into accessable objects
        dataList = parse(list);

        // New Scanner for user search
        Scanner s = new Scanner(System.in);

      //  ****** Basic Search ********
      
        System.out.println("Enter Country to Search");
        String input = s.nextLine();
        search(input, dataList);
        

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
        */

        // ****** Delete Entire Row **********
        /*
        System.out.println("Enter Country to Delete");
        String country = s.nextLine();
        System.out.println("From which date? YYYY-MM-DD");
        String date = s.nextLine();
        delete(country, date, dataList);
        */

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
        */

    }

    public static void insert(String country, String date, String cases, String deaths, ArrayList<Data> dataList)
    {
        Data data = new Data();
        data.country = country;
        data.date = date;
        data.cases = cases;
        data.deaths = deaths;
        dataList.add(data);
    }

    public static void delete(String country, String date, ArrayList<Data> dataList)
    {
        for(int i = 0; i < dataList.size(); i++)
        {
            if(country.equals(dataList.get(i).country) && date.equals(dataList.get(i).date))
            {
                dataList.remove(i);
                dataList.remove(new Data());
            }
        } 
    }

    public static void update(String country, String date, String choice, String newData, ArrayList<Data> dataList)
    {
        for(int i = 0; i < dataList.size(); i++)
        {
            if(country.equals(dataList.get(i).country) && date.equals(dataList.get(i).date))
            {
                if(choice.equals("Cases"))
                {
                    dataList.get(i).cases = newData;
                }
                else if(choice.equals("Deaths"))
                {
                    dataList.get(i).deaths = newData;
                }
               
            }
        } 
    }

    public static void search(String input, ArrayList<Data> dataList)
    {
        for(int i = 0; i < dataList.size(); i++)
        {
            if(input.equals(dataList.get(i).country))
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
            data.iso = list.get(counter);
            counter++;
            data.country = list.get(counter);
            counter++;
            data.date = list.get(counter);
            counter++;
            data.grocery = list.get(counter);
            counter++;
            data.parks = list.get(counter);
            counter++;
            data.residential = list.get(counter);
            counter++;
            data.retail = list.get(counter);
            counter++;
            data.transit = list.get(counter);
            counter++;
            data.workplace = list.get(counter);
            counter++;
            data.cases = list.get(counter);
            counter++;
            data.deaths = list.get(counter);
            counter++;
            data.govResponses = list.get(counter);
            counter++;
            data.totalTest = list.get(counter);
            counter++;
            data.gdp = list.get(counter);
            counter++;
            data.population = list.get(counter);
            counter++;
            data.populationDensity = list.get(counter);
            counter++;
            data.humanDev = list.get(counter);
            counter++;
            data.popAge = list.get(counter);
            counter++;
            data.healthIndex = list.get(counter);
            counter++;
            dataList.add(data);
            
        }

        return dataList;
    }
}
