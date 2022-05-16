package com.demoblaze.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDriverFactory {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser,Logger log) {
        this.browser = browser.toLowerCase();
        this.log = log;
    }

    public WebDriver createDriver() {


        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/Executables/geckodriver.exe");
                driver.set(new FirefoxDriver());
                break;



            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/Executables/chromedriver.exe");
                driver.set(new ChromeDriver());
        }

        return driver.get();
    }
}