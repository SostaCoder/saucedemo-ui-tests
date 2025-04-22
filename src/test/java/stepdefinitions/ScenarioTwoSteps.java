package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.junit.Assert;
import utils.ConfigReader;
import utils.DriverFactory;

import java.util.*;
import static org.junit.Assert.*;

public class ScenarioTwoSteps {
    WebDriver driver = DriverFactory.getDriver();
   // WebDriverWait wait = new WebDriverWait(driver,10);
    List<String> selectedProducts = new ArrayList<>();
    double expectedTotal = 0.0;

    @Given("I navigate to the website")
    public void i_navigate_to_the_website() {
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should be navigated to the products page")
    public void i_should_be_navigated_to_the_products_page() {
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @When("I add the two most expensive products to the cart")
    public void i_add_the_two_most_expensive_products_to_the_cart() {
        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        List<WebElement> addButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));

        List<Double> priceValues = new ArrayList<>();
        for (WebElement price : prices) {
            priceValues.add(Double.parseDouble(price.getText().replace("$", "")));
        }

        List<Double> sortedPrices = new ArrayList<>(priceValues);
        sortedPrices.sort(Collections.reverseOrder());

        for (int i = 0; i < prices.size(); i++) {
            double currentPrice = Double.parseDouble(prices.get(i).getText().replace("$", ""));
            if (currentPrice == sortedPrices.get(0) || currentPrice == sortedPrices.get(1)) {
                addButtons.get(i).click();
                expectedTotal += currentPrice;
                String productName = driver.findElements(By.className("inventory_item_name")).get(i).getText();
                selectedProducts.add(productName);
            }
        }
    }

    @When("I click on the cart button")
    public void i_click_on_the_cart_button() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @Then("I should be on the Cart page with the selected products")
    public void i_should_be_on_the_cart_page_with_the_selected_products() {
        assertTrue(driver.getCurrentUrl().contains("cart"));
        List<WebElement> cartItems = driver.findElements(By.className("inventory_item_name"));
        for (String product : selectedProducts) {
            assertTrue(cartItems.stream().anyMatch(e -> e.getText().equals(product)));
        }
    }

    @When("I click on the Checkout button")
    public void i_click_on_the_checkout_button() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("I should be on the Checkout page")
    public void i_should_be_on_the_checkout_page() {
        assertTrue(driver.getCurrentUrl().contains("checkout-step-one"));
    }

    @When("I fill in the checkout form with first name {string}, last name {string}, and postal code {string}")
    public void i_fill_checkout_form(String firstName, String lastName, String postalCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(postalCode);
    }

    @When("I click the Continue button")
    public void i_click_continue_button() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("I should be on the Overview page")
    public void i_should_be_on_the_overview_page() {
        assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
    }

    @Then("I should see the correct item total before tax")
    public void i_should_see_correct_total() {
        String itemTotalText = driver.findElement(By.className("summary_subtotal_label")).getText();
        double actualTotal = Double.parseDouble(itemTotalText.replace("Item total: $", ""));
        assertEquals(expectedTotal, actualTotal, 0.01);
    }

    @Then("the URL should be {string}")
    public void the_url_should_be(String expectedUrl) {
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }

    @When("I click the Finish button")
    public void i_click_finish_button() {
        driver.findElement(By.id("finish")).click();
    }

    @Then("I should see the {string} message")
    public void i_should_see_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.className("complete-header")).getText();
        assertEquals(expectedMessage, actualMessage);
    }

    @Then("I should see the message {string}")
    public void i_should_see_order_dispatched_message(String expectedMessage) {
        String actualMessage = driver.findElement(By.className("complete-text")).getText();
        assertTrue(actualMessage.contains("dispatched"));
    }

}
