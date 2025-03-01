package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement waitForElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void click(By by) {
        WebElement element = waitForElement(by);
        element.click();
    }

    protected void enterText(By by, String text) {
        WebElement element = waitForElement(by);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By by) {
        return waitForElement(by).getText();
    }

    protected boolean isElementDisplayed(By by) {
        try {
            return waitForElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    
    public void pressKey(AndroidKey key) {
        driver.pressKey(new KeyEvent(key));
    }
    

public void waitForElementToBeClickable2(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // 10 seconds wait
    wait.until(ExpectedConditions.elementToBeClickable(locator));
}



public void enterText2(By by, String text) {
    WebElement element = waitForElementToBeVisible(by);
   // element.clear();
    element.sendKeys(text);
}

public WebElement waitForElementToBeVisible(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3)); // Adjust timeout as needed
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
}
