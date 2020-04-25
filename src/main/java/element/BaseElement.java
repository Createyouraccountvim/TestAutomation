package element;

import driver.BaseDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement {

    private WebDriver driver = BaseDriver.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, 30);
    private By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    WebElement waitUntilVisible() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    WebElement waitUntilClickable() {

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isDisplayed() {
        return waitUntilVisible().isDisplayed();
    }


    public String getAttribute(String attribute) {
        return waitUntilVisible().getAttribute(attribute);
    }

    protected List<WebElement> getElements() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

    public void hover() {
        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(locator);
        builder.moveToElement(element).build().perform();
    }

}