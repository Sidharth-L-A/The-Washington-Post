package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyUserIsInHomePage() {
        System.out.println("verifyUserIsInHomePage Method");

        WebElement twpLogo = driver.findElement(By.xpath("//*[@id='__next']/div/div[3]/div/div/a/span"));
        System.out.println("'The Washington Post' Logo found");

        return twpLogo.isDisplayed();
    }
}