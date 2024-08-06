package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Commons {
    /*
    This class is intended to contain all the elements & objects
    that are common for all pages
    */

    WebDriver driver;
    WebElement button;

    // Constructor to initialize WebDriver
    public Commons(WebDriver driver) {
        this.driver = driver;
    }

    public void backButton(){
        System.out.println("Commons.backButton() method");
        driver.navigate().back();
        System.out.println("Clicked on Back Button");
    }

    public boolean googleSearch(String URL) {
        System.out.println("Commons.googleSearch() method");
        driver.get(URL);
        System.out.println("Called URL: " + URL);
        return true;
    }

    public boolean reloadSite() {
        System.out.println("Commons.reloadSite() method");
        driver.navigate().refresh();
        return true;
    }

    public WebElement changeButton() {
        System.out.println("changeButton Method");
        // should go to the Commons page
        button = driver.findElement(By.xpath("//button[@class='underline pointer ml-xxs gray-dark va-m dib']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }

    public WebElement contactUsButton() {
        System.out.println("contactUsButton Method");
        button = driver.findElement(By.xpath("//a[@class='gray-dark pointer underline']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }

    public WebElement privacyPolicyButton() {
        System.out.println("privacyPolicyButton Method");
        button = driver.findElement(By.xpath("//a[@data-qa='footer-privacy-policy-link']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }

    public WebElement resendButton() {
        System.out.println("EmailLinkVerificationPage.resendButton() Method");
        button = driver.findElement(By.xpath("//a[@data-test-id='resend-btn-link']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }

    public WebElement needHelpButton() {
        System.out.println("EmailLinkVerificationPage.needHelpButton() Method");
        button = driver.findElement(By.xpath("//a[@class='dib gray-dark pl-md pr-md lh-xl pt-xxs pb-xxs']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }
}