package stepdefinitions;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import utils.DriverFactory;
import utils.ConfigReader;


public class loginSteps {

    @Given("User is on login page")
    public void user_is_on_login_page() {
         DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {

        LoginPage.enterUsername(username);
        LoginPage.enterPassword(password);
        LoginPage.clickLogin();
    }

    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedErrorMsg) {
        System.out.println(expectedErrorMsg);
        String actualErrorMsg = LoginPage.getErrorMessage();
        System.out.println(actualErrorMsg);
        Assertions.assertEquals(expectedErrorMsg,actualErrorMsg,"The error message is not as expected");

    }

}
