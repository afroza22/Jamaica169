package automation_test.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities.DateUtils;

import java.time.Duration;

public class CalculateMortgageRate {

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager. chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org");
    }


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

    @AfterMethod
    public void closeBrowser(){
        ActOn.browser(driver).closeBrowser();

    }
}
