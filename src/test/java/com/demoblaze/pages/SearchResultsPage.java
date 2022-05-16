package com.demoblaze.pages;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePageObject {
    private String pageUrl = "https://amalarichu97.pythonanywhere.com/admin/";

    public SearchResultsPage(WebDriver driver)
    {
        super(driver);
    }

    public void getPageHeader()
    {
        String pageTitleLocator = driver.getCurrentUrl();
//        String headerText = getText(pageTitleLocator);
        System.out.println(pageTitleLocator);
    }

}
