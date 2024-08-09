package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TechPage {
    WebDriver driver;
    SignInPage signInPage;
    HomePage homePage;
    TechPage techPage;
    WebElement page;

    public TechPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        techPage = new TechPage(driver);
    }

    public boolean verifyUserIsInTechPage() {
        System.out.println("verifyUserIsInTechPage Method");
        page = driver.findElement(By.xpath("//a[@class='gray-darkest']"));
        System.out.println("'TECH' Page Header Found");
        return page.getText().equalsIgnoreCase("Tech");
    }
}
