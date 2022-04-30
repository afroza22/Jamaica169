package automation_test.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities.DateUtils;

import java.time.Duration;

public class CalculateMortgageRate extends BaseClass{

    @Test
    public void calculateMonthlyPayment(){
        String date = DateUtils.returnNextMonth();
        String[] dateArray = date.split("-");
        String month = dateArray [0];
        String year = dateArray [1];

       new Home(driver)
               .enterHomeValue("300000")
               .clickOnDollarSign()
               .enterDownPayment("60000")
               .enterInterestRate("3")
               .enterLoanTerm("30")
               .selectStartMonth(month)
               .enterStartYear(year)
               .enterPropertyTex("5000")
               .enterPMI("0.5")
               .enterHomeIns("1000")
               .enterHOA("100")
               .selectLoanType("FHA")
               .selectBuyOrRefinance("Buy")
               .clickOnCalculate()
               .validateTotalMonthlyPayment("1,611.85");



    }
}
