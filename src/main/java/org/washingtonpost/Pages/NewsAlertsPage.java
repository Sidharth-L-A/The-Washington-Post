package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsAlertsPage {
    WebDriver driver;
    SignInPage signInPage;
    HomePage homePage;
    NewsAlertsPage newsAlertsPage;
    WebElement page;

    public NewsAlertsPage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        newsAlertsPage = new NewsAlertsPage(driver);
    }

    public boolean verifyUserIsInNewsAlertsPage() {
        System.out.println("verifyUserIsInNewsAlertsPage Method");
        page = driver.findElement(By.xpath("//*[@class='wpds-c-bZeaQe wpds-c-bZeaQe-kpAhzw-density-compact wpds-c-bZeaQe-igRTvRh-css']"));
        System.out.println("'NewsAlerts' Page Header Found");
        return page.isDisplayed();
    }
}
