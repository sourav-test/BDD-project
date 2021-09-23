package com.chorus.framework.controllers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author p.a.kumar.banerjee
 * 
 *  This class is responsible for Selenium Webdriver Initialization
 *  according to the browser mentioned in the Config.properties file.
 */

public class WebDriverController {

    private WebDriver driver;

    private String chromedriverpath = System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\chromedriver.exe";

    private String firefoxdriverpath = System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\geckodriver.exe";

    private static String browserType;

    /**
     * This method will call the createDriver method
     * @return driver
     */
    
    public WebDriver getDriver() {

        if(driver==null)
        driver = createDriver();
        return driver;
    }

    /**
     * This method will initialize the driver
     * @return driver
     */

    private WebDriver createDriver() {

        browserType = FileReaderController.getInstance().getPropertiesReader().getBrowserType();

        switch(browserType) {

            case "CHROME" :
            System.setProperty("webdriver.chrome.driver", chromedriverpath);
            //WebDriverManager.chromedriver().setup();  (Use This For Web Drvier Manager, Need To take Confirmation)
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-features=VizDisplayCompositor");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
            break;

            case "FIREFOX" :
            System.setProperty("webdriver.gecko.driver", firefoxdriverpath);
            //WebDriverManager.firefoxdriver().setup();  (Use This For Web Drvier Manager, Need To take Confirmation)
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--ignore-certificate-errors");
            firefoxOptions.addArguments("disable-infobars");
            firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new FirefoxDriver(firefoxOptions);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            break;
        }

        return driver;
    }

    /**
     * This method will close and quit the driver session
     * 
     */
    
    public void quitDriver() {

        driver.close();
        driver.quit();
    }
    
}
