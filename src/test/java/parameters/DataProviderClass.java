package parameters;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderClass {
    @DataProvider(name = "SingleValue")
    public Object[][] storeSingleValue() {
        return new Object[][]{
                {"Seyum"},
                {"Karim"},
                {"Minar"}

        };

    }

    @DataProvider(name = "MultipleValue")
    public Object[][] StoreMultipleValues(){
        return new Object[][] {
                {"Seyum", "NewYork", 11432},
                {"Karim", "Delware", 12345},
                {"Minar", "Florida", 11350}


        };
    }

    @DataProvider(name = "RealApr")
    public Object[][] RealAprData(){
        return new Object[][]{
                {"200000", "15000", "3", "3.130%"},
                {"250000", "17000", "3.2", "3.321%"}
        };

    }


        }












