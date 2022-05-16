package com.demoblaze.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePageObject  {

    protected WebDriver driver; // other pages can still use these variables

    public BasePageObject(WebDriver driver)
    {
        this.driver = driver;
    }

    //Open the Url, receives URL
    protected void openUrl(String url)
    {
        driver.get(url);
    }

    //Find element using given locator
    protected WebElement find(By locator)
    {
        return driver.findElement(locator);
    }

    //Type given text into an element
    protected void sendKeys(String text, By locator){
        // waitForVisibilityOf(locator , 5); //wait for page reloading

        find(locator).sendKeys(text);
    }


    //    protected selectInputFromDropDown()
//    {
//
//    }
    protected String getText(By locator)
    {
        return find(locator).getText();
    }
    //Click on an element when its visible
    protected void click(By locator){
        waitForVisibilityOf(locator , 5); //wait for page reloading
        find(locator).click();
    }

    //to get current URL from the browser
    public String getCurrentUrl()
    {
        return driver.getCurrentUrl();
    }

    /**
     * Wait for specific ExpectedCondition for the given amount of time in seconds
     */
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
        timeOutInSeconds = (timeOutInSeconds != null) ? timeOutInSeconds : 30;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
        wait.until(condition);
    }

    //Waits for the locator to be visible
    protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
    }
    /** Switch to iFrame using it's locator */
    protected void switchToFrame(By frameLocator) {

        driver.switchTo().frame(find(frameLocator));
    }


    /** Find all elements using given locator */
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /** Perform scroll to the bottom */
    public void scrollToBottom() {

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


}
