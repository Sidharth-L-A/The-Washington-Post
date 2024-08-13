package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvestigationsPage {
    WebDriver driver;
    WebElement page;

    public InvestigationsPage(WebDriver driver) {
            this.driver = driver;
    }

    public boolean verifyUserIsInInvestigationsPage() {
        System.out.println("verifyUserIsInInvestigationsPage Method");
        page = driver.findElement(By.xpath("//a[@class='gray-darkest']"));
        System.out.println("'INVESTIGATIONS' Page Header Found");
        return page.getText().equalsIgnoreCase("Investigations");
    }
}
