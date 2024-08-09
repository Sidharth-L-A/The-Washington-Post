package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpinionsPage {
        WebDriver driver;
        SignInPage signInPage;
        HomePage homePage;
        org.washingtonpost.Pages.OpinionsPage opinionsPage;
        WebElement page;

        public OpinionsPage(WebDriver driver) throws InterruptedException {
            this.driver = driver;
            signInPage = new SignInPage(driver);
            homePage = new HomePage(driver);
            opinionsPage = new org.washingtonpost.Pages.OpinionsPage(driver);
        }

        public boolean verifyUserIsInOpinionsPage() {
            System.out.println("verifyUserIsInOpinionsPage Method");
            page = driver.findElement(By.xpath("//h1[@class='font--headline lh-sm uppercase gray-darkest']"));
            System.out.println("'OPINIONS' Page Header Found");
            return page.getText().equalsIgnoreCase("Opinions");
        }
}
