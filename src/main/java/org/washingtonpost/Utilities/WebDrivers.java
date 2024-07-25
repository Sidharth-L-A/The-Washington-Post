package org.washingtonpost.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDrivers {
    WebDriver driver;

//    public WebDriver getDriver() {
//        return driver;
//    }
//    public static void main(String[] args) {
//        chromeBrowserDriverInit();
//        firefoxBrowserDriverInit();
//    }

    public WebDriver chromeBrowserDriverInit() {
        System.out.println("chromeBrowserDriverInit Method");

        System.setProperty("webdriver.chrome.driver", "C:\\SIDHARTH\\New folder\\Google Chrome\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
        System.out.println("Chrome Driver Located");

        ChromeOptions cops = new ChromeOptions();
        cops.setBinary("\\SIDHARTH\\New folder\\Google Chrome\\Chrome Browser\\Test Browser\\chrome-win64\\chrome.exe");
        System.out.println("Chrome Test Browser Located");

        driver = new ChromeDriver(cops);
        System.out.println("Chrome Browser Launched");
        return driver;
    }

//    public WebDriver firefoxBrowserDriverInit() {
//        return driver;
//    }
}
