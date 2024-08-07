package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WellBeingPage {
    WebDriver driver;
    SignInPage signInPage;
    HomePage homePage;
    WellBeingPage wellBeingPage;
    WebElement page;

    public WellBeingPage (WebDriver driver) {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        wellBeingPage = new WellBeingPage(driver);
    }

    public boolean verifyUserIsInWellBeingPage() {
        System.out.println("verifyUserIsInWellBeingPage Method");
        page = driver.findElement(By.xpath("//h1[@class='font--headline lh-sm uppercase gray-darkest']"));
        System.out.println("'WELL+BEING' Page Header Found");
        return page.getText().equalsIgnoreCase("Well+Being");
    }
}
