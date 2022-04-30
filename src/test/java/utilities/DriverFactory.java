package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // Do not allow to initialize this class form outside
    private DriverFactory(){

    }

    private static final DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    //Thread Local driver object for WebDriver
    ThreadLocal <WebDriver> driver = ThreadLocal.withInitial(() -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

    });

    //Call this method to get driver object and lunch the browser
    public WebDriver getDriver() {
        return driver.get();
    }

    // Quit the driver and closes the browser
    public void  removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
