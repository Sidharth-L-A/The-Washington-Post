package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SportsPage {
    WebDriver driver;
    SignInPage signInPage;
    HomePage homePage;
    SportsPage  sportsPage ;
    WebElement page;

    public SportsPage  (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        sportsPage  = new SportsPage (driver);
    }

    public boolean verifyUserIsInSportsPage () {
        System.out.println("verifyUserIsInSportsPage  Method");
        page = driver.findElement(By.xpath("//h1[@class='font--headline lh-sm uppercase gray-darkest']"));
        System.out.println("'SPORTS' Page Header Found");
        return page.getText().equalsIgnoreCase("Sports");
    }
}
