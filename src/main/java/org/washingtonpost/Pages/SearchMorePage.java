package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchMorePage {
    WebDriver driver;
    SignInPage signInPage;
    HomePage homePage;
    SearchMorePage searchMorePage;
    WebElement page;

    public SearchMorePage (WebDriver driver) {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        searchMorePage = new SearchMorePage(driver);
    }

    public boolean verifyUserIsInSearchMorePage() {
        System.out.println("verifyUserIsInSearchMorePage Method");
        page = driver.findElement(By.xpath("//div[@class='wpds-c-hCzrjq']"));
        System.out.println("'SearchMore' Tab Found");
        return page.isDisplayed();
    }
}
