package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PoliticsPage {

    WebDriver driver;
    SignInPage signInPage;
    HomePage homePage;
    PoliticsPage politicsPage;
    WebElement page;

    public PoliticsPage (WebDriver driver) {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        politicsPage = new PoliticsPage(driver);
    }

    public boolean verifyUserIsInPoliticsPage() {
        System.out.println("verifyUserIsInPoliticsPage Method");
        page = driver.findElement(By.xpath("//a[@class='gray-darkest']"));
        System.out.println("'POLITICS' Page Header Found");
        return page.getText().equalsIgnoreCase("Politics");
    }
}
