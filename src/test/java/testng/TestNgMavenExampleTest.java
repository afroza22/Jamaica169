package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNgMavenExampleTest {

    WebDriver driver;

    @BeforeMethod
    public void BrowserInitiation(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        // Launch the Browser
        driver.get("https://phptravels.com/demo");

        // Maximise the Browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void VerifyHomePageTitle(){
        String expectedResult= "Demo Script Test drive - PHPTRAVELS";
        String actualResult = driver.getTitle();
        Assert.assertEquals(actualResult, expectedResult);
        driver.findElement(By.id("PHPTRAVELS"));
      

    }

    @AfterMethod
    public void CloseBrowser(){
        //driver.quit();


    }
}
