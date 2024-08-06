package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;
    WebElement button, masterLogo;
    String currentTab;
    SignInPage signInPage;
    HomePage homePage;

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
    }

    public WebElement subscribeButton() {
        System.out.println("subscribeButton Method");
        button = driver.findElement(By.xpath("//a[@data-qa='subs-offer']"));
        System.out.println("'Subscribe' Button found");
        return button;
    }

    public WebElement allButtons(String buttonsName) {
        int buttonCount = (driver.findElements(By.xpath("//p[@class='wpds-c-bwYbD']"))).size();
        for(int buttonNum = 0; buttonNum <= buttonCount; buttonNum++) {
            String buttonName = (driver.findElement(By.xpath("(//p[@class='wpds-c-bwYbD'])[" + buttonNum + "]"))).getText();
            if (buttonName.equals(buttonsName)) {
                return button;
            }
        }
        return null;
    }

    public boolean verifyAccountNamePostSignin(String accountName) throws InterruptedException {
        System.out.println("helpForSignInIsPrompted Method");
        Assert.assertTrue(verifyUserIsInHomePage());
        ((JavascriptExecutor) driver).executeScript("window.open();");

        currentTab = driver.getWindowHandle();
        for (String newTab : driver.getWindowHandles()) {
            if (!newTab.equals(currentTab)) {
                driver.switchTo().window(newTab);
                break;
            }
        }

        driver.wait(2000);
        driver.get("https://www.washingtonpost.com");
        driver.wait(2000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.washingtonpost.com");
        return signInPage.verifySignIn(accountName);
    }

    public boolean verifyUserIsInHomePage() {
        System.out.println("verifyUserIsInHomePage Method");
        masterLogo = driver.findElement(By.xpath("//*[@class='wpds-c-fBqPWp masthead_svg__wplogo']"));
        System.out.println("'The Washington Post' Logo found");
        return masterLogo.isDisplayed();
    }
}