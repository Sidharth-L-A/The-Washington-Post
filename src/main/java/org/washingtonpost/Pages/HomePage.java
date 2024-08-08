package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    WebElement button, masterLogo, field;
    String currentTab, buttonName, url, currentUrl, expectedUrl;
    SignInPage signInPage;
    HomePage homePage;
    JavascriptExecutor js;

    // Constructor to initialize WebDriver
    public HomePage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        js = (JavascriptExecutor) driver;
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
            buttonName = (driver.findElement(By.xpath("(//p[@class='wpds-c-bwYbD'])[" + buttonNum + "]"))).getText();
            if (buttonName.equals(buttonsName)) {
                return button;
            }
        }
        return null;
    }

    public boolean liveAndTrendingSessions() {
        System.out.println("liveAndTrendingSessions method");
        boolean result = false;
        if ((wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='PJLV wpds-c-eUExSu wpds-c-eUExSu-PRook-justify-center']"))))).isDisplayed()) {
            field = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='PJLV wpds-c-eUExSu wpds-c-eUExSu-PRook-justify-center']"))));
            System.out.println("Parent Element of Live & Trending Sessions Located");

            List<WebElement> sessionTypes = wait.until(ExpectedConditions.visibilityOfAllElements(field.findElements(By.tagName("ul"))));
            System.out.println("Live & Trending Sessions Located");

            for (WebElement sessionKind : sessionTypes) {
                List<WebElement> sessions = wait.until(ExpectedConditions.visibilityOfAllElements(sessionKind.findElements(By.tagName("li"))));
                System.out.println("Child Elements of Live & Trending Sessions Located");

                for (WebElement session : sessions) {
                    expectedUrl = session.getAttribute("href");
                    currentUrl = driver.getCurrentUrl();
                    buttonName = session.getText();
                    session.click();
                    System.out.println("Clicked on : " + buttonName);

                    if (driver.getCurrentUrl().equals(expectedUrl)) {
                        result = true;
                        System.out.println("Successfully navigated to: " + expectedUrl);
                    } else System.out.println("Failed to navigate to: " + expectedUrl);
                    driver.navigate().back();
                    driver.navigate().to(currentUrl);
                }
            }
        } else System.out.println("Live & Trending Sessions not Available");
        return result;
    }

    public boolean authorNameLinks() {
        List<WebElement> articleBy = driver.findElements(By.xpath("//div[@class='byline gray-dark font-xxxxs pb-xs']"));
        boolean result = false;

        for (WebElement authorTeam : articleBy) {
            List<WebElement> authors = authorTeam.findElements(By.tagName("a"));
            if (authors.isEmpty()) { continue; }
                for (WebElement author : authors) {
                buttonName = author.getText();
                author.click();
                System.out.println("Clicked on Author's Name : " + buttonName);

                Assert.assertEquals(wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@data-qa='author-name']")))).getText(), buttonName);
                System.out.println("Author's Page Opened ");
                driver.navigate().back();
                result = true;
            }
        }
        System.out.println("Verified all Authors who published current articles in the Homepage");
        return result;
    }

    public boolean verifyAccountNamePostSignIn(String accountName) throws InterruptedException {
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

    public boolean findAllImages() {
        System.out.println("findAllImages method");
        boolean result = false;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("Scrolled till the bottom");

//        homePage.nextSlideButton(); // click until it disappears
//        homePage.previousSlideButton(); // click until it disappears

        js.executeScript("window.scrollTo(0, 0);");
        System.out.println("Scrolled till the top");

        List<WebElement> images = driver.findElements(By.xpath("//img"));
        for (WebElement image : images) {
            System.out.println("All images display");
            url = image.getAttribute("src");
            driver.get(url);
            Assert.assertTrue(driver.findElement(By.xpath("//img")).isDisplayed());
            result = true;
        }
        return result;
    }

    public boolean verifyUserIsInHomePage() {
        System.out.println("verifyUserIsInHomePage Method");
        masterLogo = driver.findElement(By.xpath("//*[@class='wpds-c-fBqPWp masthead_svg__wplogo']"));
        System.out.println("'The Washington Post' Logo found");
        return masterLogo.isDisplayed();
    }
}