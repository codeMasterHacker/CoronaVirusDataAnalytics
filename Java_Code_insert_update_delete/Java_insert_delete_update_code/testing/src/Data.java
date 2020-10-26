
public class Data 
{
    private String iso = "";
    private String country = "";
    private String date = "";
    private String grocery = "";
    private String parks = "";
    private String residential = ""; 
    private String retail = "";
    private String transit = "";
    private String workplace = "";
    private String cases = "";
    private String deaths = "";
    private String govResponses = "";
    private String totalTest = "";
    private String gdp = "";
    private String population = "";
    private String populationDensity = "";
    private String humanDev = "";
    private String popAge = "";
    private String healthIndex = "";

    public void setIso(String iso)
    {
        this.iso = iso;
    }

    public String getIso()
    {
        return iso;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCountry()
    {
        return country;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getDate()
    {
        return date;
    }

    public void setGrocery(String grocery)
    {
        this.grocery = grocery;
    }

    public String getGrocery()
    {
        return grocery;
    }

    public void setParks(String parks)
    {
        this.parks = parks;
    }

    public String getParks()
    {
        return parks;
    }

    public void setResidential(String residential)
    {
        this.residential = residential;
    }

    public String getResidential()
    {
        return residential;
    }

    public void setRetail(String retail)
    {
        this.retail = retail;
    }

    public String getRetail()
    {
        return retail;
    }

    public void setTransit(String transit)
    {
        this.transit = transit;
    }

    public String getTransit()
    {
        return transit;
    }

    public void setWorkplace(String workplace)
    {
        this.workplace = workplace;
    }

    public String getWorkplace()
    {
        return workplace;
    }

    public void setCases(String cases)
    {
        this.cases = cases;
    }

    public String getCases()
    {
        return cases;
    }

    public void setDeaths(String deaths)
    {
        this.deaths = deaths;
    }

    public String getDeaths()
    {
        return deaths;
    }

    public void setGovResponses(String govResponses)
    {
        this.govResponses = govResponses;
    }

    public String getGovResponses()
    {
        return govResponses;
    }

    public void setTotalTest(String totalTest)
    {
        this.totalTest = totalTest;
    }

    public String getTotalTest()
    {
        return totalTest;
    }

    public void setGdp(String gdp)
    {
        this.gdp = gdp;
    }

    public String getGdp()
    {
        return gdp;
    }

    public void setPopulation(String population)
    {
        this.population = population;
    }

    public String getPopulation()
    {
        return population;
    }

    public void setPopulationDensity(String populationDensity)
    {
        this.populationDensity = populationDensity;
    }

    public String getPopulationDenstiy()
    {
        return populationDensity;
    }

    public void setHumanDev(String humanDev)
    {
        this.humanDev = humanDev;
    }

    public String getHumanDev()
    {
        return humanDev;
    }

    public void setPopAge(String popAge)
    {
        this.popAge = popAge;
    }

    public String getPopAge()
    {
        return popAge;
    }

    public void setHealthIndex(String healthIndex)
    {
        this.healthIndex = healthIndex;
    }

    public String getHealthIndex()
    {
        return healthIndex;
    }

  

    

    public void print()
    {
        System.out.println(iso + " | " + country + " | " + date + " | " + grocery + " | " + parks + " | " + residential + " | "
        + retail + " | " + transit + " | " + workplace + " | " + cases + " | " + deaths + " | " + govResponses + " | " + totalTest + " | " + gdp + " | "
        + population + " | " + populationDensity + " | " + humanDev + " | " + popAge + " | " + healthIndex);
    }
    
    public String toCSV()
    {
        String line;
        
        line = iso + "," + country + "," + date + "," + grocery + "," + parks + "," + residential + ","
        + retail + "," + transit + "," + workplace + "," + cases + "," + deaths + "," + govResponses + "," + totalTest + "," + gdp + ","
        + population + "," + populationDensity + "," + humanDev + "," + popAge + "," + healthIndex + "\n";

        return line;
    }

}


