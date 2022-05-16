package com.demoblaze.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class WelcomePage extends BasePageObject{
    private String pageUrl = "https://www.redbus.in/";

    public WelcomePage(WebDriver driver)
    {
        super(driver);
    }

    public void openPage()
    {

        openUrl(pageUrl);
    }



    public SearchResultsPage reservationDetails() throws InterruptedException {
        Thread.sleep(1000);  // Time to see the window
        String month = "Jun 2022";
        String day="20";
        By fromLocator= By.xpath("//input[@id='src']");
        By toLocator = By.xpath("//input[@id='dest']");
        By dateLocator = By.xpath("//input[@id='onward_cal']");

        By fromDropDownListLocator = By.xpath("//body[1]/section[1]/div[2]/main[1]/section[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[1]");
        By destDropDownListLocator = By.xpath("//body[1]/section[1]/div[2]/main[1]/section[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/ul[1]/li[1]");
        By dayLocator = By.xpath("//body[1]/div[4]/table[1]/tbody[1]/tr/td[contains(text() , '15')]");
        By searchButtonLocator = By.xpath("//button[@id='search_btn']");
        sendKeys("Egmore, Chennai",fromLocator);
        click(fromDropDownListLocator);
        sendKeys("Arappalayam, Madurai", toLocator);
        click(destDropDownListLocator);
        driver.findElement(dateLocator).click();

        //check if month and year are expected and click the right click based on it
        //condition will be true untill we find the expected month and then it breaks by setting the boolean value false
        while(true)
        {
            String month_year_Value = driver.findElement(By.xpath("//body[1]/div[4]/table[1]/tbody[1]/tr[1]/td[2]")).getText();
            System.out.println("Expected: " +month_year_Value+ "Actual: " +month);
            if(month_year_Value.equals(month)) {break;}
            else {driver.findElement(By.xpath("//body[1]/div[4]/table[1]/tbody[1]/tr[1]/td[3]/button[1]")).click();}
        }
        Thread.sleep(1000);
        click(dayLocator);
        Thread.sleep(1000);

//        By searchButtonLocator1 = By.tagName("button");
//        click(searchButtonLocator1);
        WebElement element = driver.findElement(By.tagName("button"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        WebElement webElement = driver.findElement(By.tagName("button"));
        Actions builder = new Actions(driver);
        builder.moveToElement(webElement).click(webElement);
        builder.perform();
        //System.out.println(driver.findElement(By.tagName("button")).getText());

        //sendKeys("17-Apr-2022", dateLocator);
        // click(searchButtonLocator);
        Thread.sleep(1000);  // Time to see the window


        //click(logInButtonLocator);
        return new SearchResultsPage(driver);
    }
}
