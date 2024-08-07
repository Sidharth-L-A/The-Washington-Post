package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorldPage {
    WebDriver driver;
    SignInPage signInPage;
    HomePage homePage;
    WorldPage worldPage;
    WebElement page;

    public WorldPage(WebDriver driver) {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        worldPage = new WorldPage(driver);
    }

    public boolean verifyUserIsInWorldPage() {
        System.out.println("verifyUserIsInWorldPage Method");
        page = driver.findElement(By.xpath("//a[@class='gray-darkest']"));
        System.out.println("'WORLD' Page Header Found");
        return page.getText().equalsIgnoreCase("World");
    }
}
