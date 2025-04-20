package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverFactory;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class LoginPage {
    static WebDriver driver= DriverFactory.driver;

    static WebElement usernameField = driver.findElement(By.id("user-name"));
    static WebElement passwordField = driver.findElement(By.id("password"));
    static WebElement loginButton = driver.findElement(By.id("login-button"));
    static WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void enterUsername(String username) { usernameField.clear(); usernameField.sendKeys(username); }
    public static void enterPassword(String password) { passwordField.clear();passwordField.sendKeys(password); }
    public static void clickLogin() { loginButton.click(); }
    public static String getErrorMessage() { return errorMessage.getText(); }
}

