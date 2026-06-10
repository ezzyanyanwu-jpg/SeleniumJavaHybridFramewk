package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");

    public void enterCustomerDetails(String fn, String ln, String pc) {

        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(postalCode).sendKeys(pc);
        driver.findElement(continueBtn).click();
    }

    public void finishOrder() {

        driver.findElement(finishBtn).click();
    }
}