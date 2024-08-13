package org.washingtonpost.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EmailLinkVerificationPage {
    WebDriver driver;
    WebDriverWait wait;

    public EmailLinkVerificationPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    WebElement button, field;
    String originalHandle;

    public boolean linkSentNote() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.linkSentNote() Method");
        Thread.sleep(6000);
        field = driver.findElement(By.xpath("//h2[@class='mt-md font-md font-bold font--headline']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }

    public boolean appleTwoFactorAuth() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.linkSentNote() Method");
        Thread.sleep(6000);
        field = driver.findElement(By.xpath("// Two factor Authentication Page header xpath"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }

    public boolean signInWithAmazon() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.SignInWithAmazon() Method");
        driver.wait(3000);
        field = driver.findElement(By.xpath("//h1[@class='a-spacing-small']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }
    public boolean signInWithFacebook() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.SigninwithFacebook() Method");
        driver.wait(3000);
        field = driver.findElement(By.xpath("//div[@class='_9axz']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }
    public boolean verifySixDigitVerificationPage() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.verify6DigitVerificationPage() Method");
        driver.wait(3000);
        field = driver.findElement(By.xpath("//span[@class='x193iq5w xeuugli x13faqbe x1vvkbs x1xmvt09 x1lliihq x1s928wv xhkezso x1gmr53x x1cpjm7i x1fgarty x1943h6x x14z4hjw x3x7a5m xngnso2 x1qb5hxa x1xlr1w8 xzsf02u x1yc453h']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }

    public boolean signInWithApple() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.signInWithApple() Method");
        Thread.sleep(6000);
        field = driver.findElement(By.xpath("//div[@class='ac-localnav-title']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }

    public boolean signInWithGoogle() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.signInWithGoogle() Method");
        Thread.sleep(6000);
        field = driver.findElement(By.xpath("//div[.='Sign in with Google']"));
        System.out.println("Message Displayed : " + field.getText());
        return field.isDisplayed();
    }

//    public boolean SigninwithGooglePasswordPage() throws InterruptedException {
//        System.out.println("EmailLinkVerificationPage.SigninwithGooglePasswordPage() Method");
//        Thread.sleep(6000);
//        field = driver.findElement(By.xpath("//div[.='Sign in with Google']"));
//        System.out.println("Message Displayed : " + field.getText());
//        return field.isDisplayed();
//    }

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
        Commons commons = new Commons(driver);
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
        Commons commons = new Commons(driver);
        commons.changeButton().click();
        System.out.println("Change Button Clicked");
        SignInPage signIn = new SignInPage(driver);
        Assert.assertTrue(signIn.inputField("EmailId").isDisplayed());
        return true;
    }

    public boolean verifyContactUsButton() throws InterruptedException {
        System.out.println("EmailLinkVerificationPage.verifyContactUsButton() Method");
        Commons commons = new Commons(driver);
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
        Commons commons = new Commons(driver);
        commons.privacyPolicyButton().click();
        System.out.println("privacyPolicyButton Button Clicked");
        Thread.sleep(2500);

        originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        PrivacyPolicy privacyPolicy = new PrivacyPolicy(driver);
        Assert.assertTrue(privacyPolicy.verifyPrivacyPolicyPage());
        driver.close();
        driver.switchTo().window(originalHandle);
        return true;
    }

}
