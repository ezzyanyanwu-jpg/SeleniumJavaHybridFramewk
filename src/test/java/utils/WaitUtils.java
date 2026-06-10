package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static final int TIMEOUT = 30;

    public static WebElement waitForVisibility(
            WebDriver driver,
            By locator) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(
            WebDriver driver,
            By locator) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions
                        .elementToBeClickable(locator));
    }

    public static boolean waitForUrlContains(
            WebDriver driver,
            String partialUrl) {

        return new WebDriverWait(
                driver,
                Duration.ofSeconds(TIMEOUT))
                .until(ExpectedConditions
                        .urlContains(partialUrl));
    }
}