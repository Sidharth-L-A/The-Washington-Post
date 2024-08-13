package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsAlertsPage {
    WebDriver driver;
    WebElement page;

    public NewsAlertsPage (WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyUserIsInNewsAlertsPage() {
        System.out.println("verifyUserIsInNewsAlertsPage Method");
        page = driver.findElement(By.xpath("//*[@class='wpds-c-bZeaQe wpds-c-bZeaQe-kpAhzw-density-compact wpds-c-bZeaQe-igRTvRh-css']"));
        System.out.println("'NewsAlerts' Page Header Found");
        return page.isDisplayed();
    }
}
