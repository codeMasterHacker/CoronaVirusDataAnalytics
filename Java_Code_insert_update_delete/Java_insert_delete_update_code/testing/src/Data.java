
public class Data 
{
    String iso = "";
    String country = "";
    String date = "";
    String grocery = "";
    String parks = "";
    String residential = ""; 
    String retail = "";
    String transit = "";
    String workplace = "";
    String cases = "";
    String deaths = "";
    String govResponses = "";
    String totalTest = "";
    String gdp = "";
    String population = "";
    String populationDensity = "";
    String humanDev = "";
    String popAge = "";
    String healthIndex = "";

    public void print()
    {
        System.out.println(iso + " | " + country + " | " + date + " | " + grocery + " | " + parks + " | " + residential + " | "
        + retail + " | " + transit + " | " + workplace + " | " + cases + " | " + deaths + " | " + govResponses + " | " + totalTest + " | " + gdp + " | "
        + population + " | " + populationDensity + " | " + humanDev + " | " + popAge + " | " + healthIndex);
    }

    public void printSpaced()
    {
        // For testing purposes
        System.out.println("ISO: " + iso);
        System.out.println("Country: " + country);
        System.out.println("Date: " + date);
        System.out.println("Grocery: " + grocery);
        System.out.println("Parks: " + parks);
        System.out.println("Residential: " + residential);
        System.out.println("Retail: " + retail);
        System.out.println("Transit: " + transit);
        System.out.println("Workplace: " + workplace);
        System.out.println("Cases: " + cases);
        System.out.println("Deaths: " + deaths);
        System.out.println("GovRes: " + govResponses);
        System.out.println("Total Test: " + totalTest);
        System.out.println("GDP: " + gdp);
        System.out.println("Population: " + population);
        System.out.println("PopuplationDens: " + populationDensity);
        System.out.println("HumanDev: " + humanDev);
        System.out.println("PopAge: " + popAge);
        System.out.println("HealthInd: " + healthIndex);
    }

}


