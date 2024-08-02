package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    WebElement masterLogo;

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyUserIsInHomePage() {
        System.out.println("verifyUserIsInHomePage Method");
        masterLogo = driver.findElement(By.xpath("//*[@class='wpds-c-fBqPWp masthead_svg__wplogo']"));
        System.out.println("'The Washington Post' Logo found");
        return masterLogo.isDisplayed();
    }

    public boolean verifyUserNameDisplayed() {
        System.out.println("verifyUserNameDisplayed Method");
        masterLogo = driver.findElement(By.xpath("//span[contains(text(),'the.washington.post.testing')]"));
        System.out.println("'user name' Text found");
        return masterLogo.isDisplayed();
    }
}