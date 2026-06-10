package stepdefinitions;

import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import pages.*;
import utils.DriverFactory;

public class SauceDemoSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    CheckoutCompletePage completePage = new CheckoutCompletePage(driver);

    @Given("User launches SauceDemo website")
    public void launchSite() {

        driver.get("https://www.saucedemo.com");
    }

    @When("User logs in with username {string} and password {string}")
    public void login(String username, String password) {

        loginPage.login(username,password);
    }

    @And("User adds {string} to the cart")
    public void addProduct(String product) {

        inventoryPage.addProductToCart(product);
    }

    @And("User proceeds to the cart")
    public void proceedToCart() {

        inventoryPage.openCart();
    }

    @Then("The cart should contain {string} products")
    public void verifyCartCount(String expectedCount) {

        Assertions.assertEquals(Integer.parseInt(expectedCount),
                cartPage.getCartItemCount());
    }

    @When("User proceeds to checkout")
    public void checkout() {

        cartPage.checkout();
    }

    @And("User enters checkout information with first name {string} and last name {string} and postal code {string}")
    public void enterDetails(String firstName, String lastName, String postalCode) {

        checkoutPage.enterCustomerDetails(firstName, lastName, postalCode);
    }

    @And("User completes the purchase")
    public void finishOrder() {

        checkoutPage.finishOrder();
    }

    @Then("Order confirmation message should be {string}")
    public void verifyOrderMessage(String expected) {

        Assertions.assertEquals(expected, completePage.getConfirmationMessage());
    }

    @Then("Login outcome should be {string}")
    public void verifyOutcome(String outcome) {

        if(outcome.equalsIgnoreCase("SUCCESS")){

            Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));
        }
    }

    @And("Expected message should be {string}")
    public void verifyExpectedMessage(String expected) {

        if(!expected.equalsIgnoreCase("inventory")){

            Assertions.assertEquals(expected, loginPage.getErrorMessage());
        }
    }
}