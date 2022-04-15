package automation_test.php_travel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGWebdriver {

    WebDriver driver;

    @BeforeMethod
    public void BrowserInitiation(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Launch the Browser
        driver.get("https://phptravels.com/demo/");
        // Maximize the Browser
        driver.manage().window().maximize();

    }

    @Test
    public void VerifyHomePageTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo/");
        String expectedResult = "Demo Script Test drive - PHPTRAVELS";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    @AfterMethod
    public void CloseBrowser (){
       driver.quit();

    }
}
