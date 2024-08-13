package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TechPage {
    WebDriver driver;
    WebElement page;

    public TechPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyUserIsInTechPage() {
        System.out.println("verifyUserIsInTechPage Method");
        page = driver.findElement(By.xpath("//a[@class='gray-darkest']"));
        System.out.println("'TECH' Page Header Found");
        return page.getText().equalsIgnoreCase("Tech");
    }
}
