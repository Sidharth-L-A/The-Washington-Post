package org.washingtonpost.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class WebDrivers {
    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver chromeBrowserDriverInit() {
        System.out.println("chromeBrowserDriverInit Method");

        System.setProperty("webdriver.chrome.driver", "C:\\SIDHARTH\\Required Files for Environment\\Google Chrome\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
        System.out.println("Chrome Driver Located");

        ChromeOptions cops = new ChromeOptions();
        cops.setBinary("C:\\SIDHARTH\\Required Files for Environment\\Google Chrome\\Chrome Browser\\Test Browser\\chrome-win64\\chrome.exe");

        cops.addArguments("--disable-blink-features=AutomationControlled");
        cops.addArguments("--disable-infobars");
        cops.addArguments("--disable-notifications");
        cops.addArguments("--start-maximized");
//        cops.addArguments("--headless");

        driver = new ChromeDriver(cops);
        System.out.println("Chrome Browser Launched");
        return driver;
    }

//    public WebDriver firefoxBrowserDriverInit() {
//        return driver;
//    }
}
