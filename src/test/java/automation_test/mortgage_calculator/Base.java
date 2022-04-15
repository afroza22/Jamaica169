package automation_test.mortgage_calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Base {

    public WebDriver driver;
    Logger LOGGER = LogManager.getLogger(this.getClass().getName());
}
