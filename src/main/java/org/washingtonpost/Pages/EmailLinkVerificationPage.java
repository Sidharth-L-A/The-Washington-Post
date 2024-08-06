package org.washingtonpost.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EmailLinkVerificationPage {
//    This call is called during the sign in process while clicking on the 'Send a sign in link' button.

    WebDriver driver;
    WebDriverWait wait;
    WebElement button, field;
    String originalHandle;
    Commons commons;
    SignInPage signIn;
    PrivacyPolicy privacyPolicy;

    public EmailLinkVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commons = new Commons(driver);
        signIn = new SignInPage(driver);
        privacyPolicy = new PrivacyPolicy(driver);
    }


    public boolean linkSentNote() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.linkSentNote() Method");
        Thread.sleep(6000);
        field = driver.findElement(By.xpath("//h2[@class='mt-md font-md font-bold font--headline']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }
    public boolean SigninwithAmazon() throws InterruptedException {
        System.out.println("AmazonSignInVerificationPage.SigninwithAmazon() Method");
        driver.wait(3000);
        field = driver.findElement(By.xpath("//h1[@class='a-spacing-small']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }
    public boolean SigninwithFacebook() throws InterruptedException {
        System.out.println("FacebookSignInVerificationPage.SigninwithFacebook() Method");
        driver.wait(3000);
        field = driver.findElement(By.xpath("//div[@class='_9axz']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }
    public boolean verifySixDigitVerificationPage() throws InterruptedException {
        System.out.println("FacebookSignIn6digitcodeVerificationPage.verify6DigitVerificationPage() Method");
        driver.wait(3000);
        field = driver.findElement(By.xpath("//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x14z4hjw x3x7a5m xngnso2 x1qb5hxa x1xlr1w8 xzsf02u x1yc453h']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }

    public boolean SigninwithApple() throws InterruptedException {
        System.out.println("AppleSignInVerificationPage.SigninwithApple() Method");
        Thread.sleep(6000);
        field = driver.findElement(By.xpath("//div[@class='ac-localnav-title']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }

    public boolean SigninwithGoogle() throws InterruptedException {
        System.out.println("GoogleSignInVerificationPage.SigninwithGoogle() Method");
        Thread.sleep(6000);
        field = driver.findElement(By.xpath("//div[.='Sign in with Google']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }

    public boolean SigninwithGooglePasswordPage() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.SigninwithGooglePasswordPage() Method");
        Thread.sleep(6000);
        field = driver.findElement(By.xpath("//div[.='Sign in with Google']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }

    public boolean resendNotificationVerify() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.resendNotificationVerify() Method");

        Thread.sleep(2000);
        Assert.assertTrue(verifyResendButton());
        System.out.println("Resend Button Verified");

        Thread.sleep(2000);
        Assert.assertTrue(verifyContactUsButton());
        System.out.println("Contact Us Button Verified");

        Thread.sleep(2000);
        Assert.assertTrue(verifyPrivacyPolicyButton());
        System.out.println("Privacy Policy Button Verified");

        Thread.sleep(2000);
        Assert.assertTrue(verifyChangeButton());
        System.out.println("Change Button Verified");
        driver.close();
        return true;
    }

    public boolean verifyResendButton() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.verifyResendButton() Method");
        commons.resendButton().click();
        System.out.println("Resend Button Clicked");
        field = driver.findElement(By.xpath("//span[@class='resending  ']"));

//        Depends on Network Speeds : (tried for 10 second(s) with 500 milliseconds interval) Sometimes Pass, Sometimes Fail.
//        wait.until(ExpectedConditions.textToBePresentInElement(field,"resending"));
//        System.out.println("Notification 1 : " + field.getText());

        wait.until(ExpectedConditions.textToBePresentInElement(field,"Email sent!"));
        System.out.println("Notification 2 : " + field.getText());
        Assert.assertTrue(field.getText().equalsIgnoreCase("Email sent!"));

        Thread.sleep(5000);
        button = driver.findElement(By.xpath("//a[@data-test-id='resend-btn-link']"));
        System.out.println("Button Found : " + button.getText());
        return true;
    }

    public boolean verifyChangeButton() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.verifyChangeButton() Method");
        commons.changeButton().click();
        System.out.println("Change Button Clicked");
        Assert.assertTrue(signIn.inputField().isDisplayed());
        return true;
    }

    public boolean verifyContactUsButton() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.verifyContactUsButton() Method");
        commons.contactUsButton().click();
        System.out.println("Contact Us Button Clicked");

        Thread.sleep(3000);
        System.out.println("Current URL : " + driver.getCurrentUrl());

        originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//html/body/main/div/h1"))));
        System.out.println("Page Opened : " + field.getText());
        Assert.assertTrue(field.isDisplayed());
        driver.close();
        driver.switchTo().window(originalHandle);
        return true;
    }
    public boolean verifyPrivacyPolicyButton() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.verifyPrivacyPolicyButton() Method");
        commons.privacyPolicyButton().click();
        System.out.println("privacyPolicyButton Button Clicked");
        Thread.sleep(3000);

        originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        Assert.assertTrue(privacyPolicy.verifyPrivacyPolicyPage());
        driver.close();
        driver.switchTo().window(originalHandle);
        return true;
    }

}
