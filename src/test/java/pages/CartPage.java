package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    public int getCartItemCount(){

        return driver.findElements(By.className("cart_item")).size();
    }

    public void checkout()
    {

        driver.findElement(By.id("checkout")).click();
    }
}