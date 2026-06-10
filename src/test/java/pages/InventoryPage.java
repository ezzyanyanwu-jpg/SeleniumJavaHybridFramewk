package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver)
    {
        super(driver);
    }

    public void addProductToCart(String product) {

        String xpath =
                "//div[normalize-space()='" + product + "']" +
                        "//ancestor::div[contains(@class,'inventory_item')]" +
                        "//button";

        driver.findElement(By.xpath(xpath)).click();
    }

    public void openCart()
    {

        driver.findElement(By.className("shopping_cart_link")).click();

    }
}