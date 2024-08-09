package org.washingtonpost.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class UI {
    WebDriver driver;
    WebDriverWait wait;
    Commons commons;
    EmailLinkVerificationPage linkVerificationPage;
    PrivacyPolicy privacyPolicy;
    NeedHelpPage needHelpPage;
    Actions actions;
    JavascriptExecutor jsExecutor;
    SignInPage signInPage;
    HomePage homepage;

    public UI(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commons = new Commons(driver);
        linkVerificationPage = new EmailLinkVerificationPage(driver);
        privacyPolicy = new PrivacyPolicy(driver);
        needHelpPage = new NeedHelpPage(driver);
        actions = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
        signInPage = new SignInPage(driver);
        homepage = new HomePage(driver);
    }

    public boolean verifyButtonColor() throws InterruptedException {
        // call all buttons from all pages and send for color change during hover, if that button is interactive

        // Page > Elements > get one > add into list

        // Buttons to add :
        // Sign In
        // Next - SignIn(110)
        // Continue - SignIn(129)
        // Email Link to Sign In - SignIn(143)
        // Amazon Button
        // Facebook Button
        // Google
        // AppleID

        // Non-Interactive hyperlinks:
        // signInPage.signUpHyperlink()
        // commons.changeButton()
        // commons.resendButton()
        // commons.needHelpButton())

        List <WebElement> homepageButtons = Arrays.asList(
                signInPage.signInButton(),
                homepage.subscribeButton());

        List <WebElement> signInPageButtons = Arrays.asList(
                signInPage.nextButton(), // Same for 'SignIn' button which is under the 'Password' field
                signInPage.linkSignInButton(),
                signInPage.continueButton());
        // Buttons to add :
        // Amazon Button
        // Facebook Button
        // Google
        // AppleID

        List <WebElement> signUpPageButtons = Arrays.asList(
                signInPage.nextButton()
                // Buttons to add :
                // Amazon Button
                // Facebook Button
                // Google
                // AppleID

        );

        List <WebElement> commonButtons = Arrays.asList(
                commons.contactUsButton()
        );
        return false;
    }

    public boolean buttonColorChange(WebElement button) {
        String initialColor = button.getCssValue("background-color");
        System.out.println("Button Color before hovering: " + initialColor);
        actions.moveToElement(button).perform();

        String hoverColor = button.getCssValue("background-color");
        System.out.println("Button Color after hovering: " + hoverColor);

        String initialHexColor = Color.fromString(initialColor).asHex();
        String hoverHexColor = Color.fromString(hoverColor).asHex();

        return !initialHexColor.equals(hoverHexColor);
    }
}
