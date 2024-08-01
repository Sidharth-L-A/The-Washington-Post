package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Commons {
    /*
    This class is intended to contain all the elements & objects
    that are common for all pages
    */

    WebDriver driver;
    WebDriverWait wait;
    WebElement button;
    JavascriptExecutor jsExecutor;
    String buttonColor;
    SignInPage signInPage;

    List <String> pathsOfButtons = Arrays.asList(
            "button[data-qa='auth--amazon']",
            "button[data-qa='auth--facebook']",
            "button[data-qa='auth--google']",
            "button[data-qa='auth--amazon']"
    );

    // Constructor to initialize WebDriver
    public Commons(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jsExecutor = (JavascriptExecutor) driver;
        signInPage = new SignInPage(driver);
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

    public boolean verifyBlueButtonInitialColor() throws InterruptedException {
        System.out.println("Commons.verifyBlueButtonColor() Method");
        driver.wait(1000);
        buttonColor = (String) jsExecutor.executeScript("return window.getComputedStyle(document.querySelector('button[data-test-id='sign-in-btn']')).getPropertyValue('background-color')");
        System.out.println("Verifying Button Color");
        driver.wait(1000);
        return buttonColor.contains("rgb(22, 109, 252)");
    }

    public boolean verifyGrayButtonInitialColor() throws InterruptedException {
        System.out.println("Commons.verifyGrayButtonInitialColor() Method");
        driver.wait(1000);
        buttonColor = (String) jsExecutor.executeScript("return window.getComputedStyle(document.querySelector('button[data-test-id='pml-btn']')).getPropertyValue('background-color')");
        System.out.println("Verifying Button Color");
        driver.wait(1000);
        return buttonColor.contains("rgb(255, 255, 255)");
    }

    public void verifyWhiteButtonInitialColor() throws InterruptedException {
        System.out.println("Commons.verifyWhiteButtonInitialColor() Method");
        driver.wait(1000);

        List<WebElement> buttons = Arrays.asList(
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--amazon']")))),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--facebook']")))),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--google']")))),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--apple']"))))
        );

        for(String button : pathsOfButtons) {
            buttonColor = (String) jsExecutor.executeScript("return window.getComputedStyle(document.querySelector('" + button + "')).getPropertyValue('background-color')");
            System.out.println("Verifying " + button + "Button Color");
            driver.wait(1000);
            Assert.assertTrue(buttonColor.contains("rgb(255, 255, 255)"));
            driver.wait(1000);
            System.out.println("Verified " + button + "Button Color");
        }

        for(WebElement button : buttons) {
            driver.wait(1000);
            Assert.assertTrue(signInPage.buttonColorChange(button));
            driver.wait(1000);
        }
    }
}