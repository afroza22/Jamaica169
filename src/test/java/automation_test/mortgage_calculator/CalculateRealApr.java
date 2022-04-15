package automation_test.mortgage_calculator;

import command_providers.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;

import java.time.Duration;

public class CalculateRealApr {

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager. chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org");
    }

    @Test
    public void calculateRealAprRate(){
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .enterHomePrice("200000")
                .selectDownPaymentInDollar()
                .enterDownPayment("15000")
                .enterInterestRate("3")
                .clickOnCalculateButton()
                .validateAprRate("3.130%");
    }

    @AfterMethod
    public void closeBrowser(){
        ActOn.browser(driver).closeBrowser();

    }
}
