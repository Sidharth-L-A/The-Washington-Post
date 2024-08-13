package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class SearchMorePage {
    WebDriver driver;
    WebElement page;

    public SearchMorePage (WebDriver driver) {
        this.driver = driver;
    }

    String SEARCH_MORE_BUTTON = "//button[@data-qa='sc-header-search-menu-button']";
    String SIDEBAR = "//div[@id='sc-sections-nav-drawer']";
    String SEARCH_BAR = "//input[@aria-labelledby='radix-1']";
    String SEARCH_BUTTON = "//span[text()='Search Icon']";
    String CLEAR_BUTTON = "(//span[text()='Clear'])[1]";
    String CHILD_ELEMENTS = "//a[@class='wpds-c-hwurOE']";
    String PAGE_NAMES = "//div[@id='sc-sections-nav-drawer']//a";
    String PAGE_HEADER = "//h1";
    String SUBSCRIBE_PAGE_HEADER = "//div[@data-qa='header-text']";
    String EXPAND_ARROWS = "//*[@class='wpds-c-jsbmJo ']";

    public boolean verifyUserIsInSearchMorePage() {
        System.out.println("verifyUserIsInSearchMorePage Method");
        page = driver.findElement(By.xpath("//div[@class='wpds-c-hCzrjq']"));
        System.out.println("'SearchMore' Tab Found");
        return page.isDisplayed();
    }

    public void verifySidebarAndNavigation(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchMore = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(SEARCH_MORE_BUTTON))));
        System.out.println("Hamburger Button Found");

        searchMore.click();
        System.out.println("Clicked on Hamburger Button");

        WebElement searchMoreTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIDEBAR)));
        Assert.assertTrue(searchMoreTab.isDisplayed(), "Sidebar not opened");
        System.out.println("Sidebar opened");

        List<WebElement> pageNames = driver.findElements(By.xpath(PAGE_NAMES));
        System.out.println("Located and Fetched " + pageNames.size() + " Buttons");

        List<WebElement> expandArrows = driver.findElements(By.xpath(EXPAND_ARROWS));
        System.out.println("Located and Fetched " + expandArrows.size() + " Expand Arrow Buttons");

        WebElement textField = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(SEARCH_BAR))));
        textField.sendKeys("Abc123#");

        WebElement clearButton = driver.findElement(By.xpath(CLEAR_BUTTON));
        clearButton.click();
        System.out.println("Clicked on 'X' Clear Button");

        String fieldValue = textField.getAttribute("value");
        Assert.assertTrue(fieldValue.isEmpty(), "Search Bar is not Cleared");
        System.out.println("Search Bar is Cleared");

        textField.sendKeys("cars");
        WebElement searchButton = driver.findElement(By.xpath(SEARCH_BUTTON));
        searchButton.click();
        System.out.println("Clicked on Search Button");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("cars"), "Searched Content not Displayed");
        System.out.println("Searched Content Displayed");

        driver.navigate().back();
        if(!searchMoreTab.isDisplayed()) searchMore.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIDEBAR)));
        System.out.println("Search More Tab (Sidebar) Opened again");

        for (WebElement pageName : pageNames) {
            pageName.click();
            System.out.println("Clicked on Page : " + pageName.getText());

            if (pageName.getText().equalsIgnoreCase("Subscribe")) {
                Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBSCRIBE_PAGE_HEADER))).getText().equalsIgnoreCase("Choose your plan"), pageName.getText() + " Page Not Opened");
                System.out.println("Page Opened : " + pageName.getText());
            } else if (pageName.getText().equalsIgnoreCase("Home Page")) {
                HomePage homePage = new HomePage(driver);
                homePage.verifyUserIsInHomePage();
                System.out.println("Page Opened : " + pageName.getText());
            }

            WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PAGE_HEADER)));
            Assert.assertTrue(pageHeader.isDisplayed(), "Page Not Opened after clicking <a> tag");
            System.out.println("Page Opened : " + pageHeader.getText());

            driver.navigate().back();
            if(!searchMoreTab.isDisplayed()) searchMore.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIDEBAR)));
            System.out.println("Search More Tab (Sidebar) Opened again");
        }

        for (WebElement expandArrow : expandArrows) {
            expandArrow.click();
            System.out.println("Clicked on expand arrow");

            List<WebElement> children = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(CHILD_ELEMENTS)));
            System.out.println("Located and Fetched " + children.size() + " Child-PageName Buttons");

            for (WebElement child : children) {
                child.click();
                System.out.println("Clicked on Child Page : " + child.getText());

                WebElement newPageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PAGE_HEADER)));
                Assert.assertTrue(newPageHeader.isDisplayed(), "Page Not Opened after clicking temporary <a> element");
                System.out.println("Navigated to page with header: " + newPageHeader.getText());

                driver.navigate().back();
                if(!searchMoreTab.isDisplayed()) searchMore.click();
                expandArrow.click();
                System.out.println("Search More Tab (Sidebar) Opened again");
            }
        }
    }
}
