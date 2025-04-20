package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverFactory;

import java.util.Set;

public class Hooks {
    WebDriver driver;

    @Before
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        driver = DriverFactory.initDriver(browser);
    }

    @After
    public void tearDown(Scenario scenario) {

//         if (DriverFactory.getDriver() != null) {
//            DriverFactory.getDriver().quit();
//        }

      //  DriverFactory.quitDriver();
    }
}
