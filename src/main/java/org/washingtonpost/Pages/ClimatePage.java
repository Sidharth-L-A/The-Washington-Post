package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClimatePage {
    WebDriver driver;
    SignInPage signInPage;
    HomePage homePage;
    ClimatePage climatePage;
    WebElement page;

    public ClimatePage (WebDriver driver) throws InterruptedException {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        climatePage = new ClimatePage(driver);
    }

    public boolean verifyUserIsInClimatePage() {
        System.out.println("verifyUserIsInClimatePage Method");
        page = driver.findElement(By.xpath("//h1[@class='font--headline lh-sm uppercase gray-darkest']"));
        System.out.println("'CLIMATE' Page Header Found");
        return page.getText().equalsIgnoreCase("Climate");
    }
}
