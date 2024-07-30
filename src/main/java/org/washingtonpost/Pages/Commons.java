package org.washingtonpost.Pages;

import org.openqa.selenium.WebDriver;

public class Commons {
    /*
    This class is intended to contain all the elements & objects
    that are common for all pages
    */

    WebDriver driver;

    // Constructor to initialize WebDriver
    public Commons(WebDriver driver) {
        this.driver = driver;
    }

    public boolean googleSearch(String URL) {
        System.out.println("Commons.googleSearch() method");
        driver.get(URL);
        System.out.println("Called URL: " + URL);
        return true;
    }

    public boolean reloadSite() {
        System.out.println("Commons.reloadSite() method");
        driver.navigate().refresh();
        return true;
    }
}