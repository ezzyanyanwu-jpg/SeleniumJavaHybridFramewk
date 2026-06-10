package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    public CheckoutCompletePage(WebDriver driver)
    {
        super(driver);
    }

    By confirmationMessage = By.className("complete-header");

    public String getConfirmationMessage(){

        return driver.findElement(confirmationMessage).getText();
    }
}