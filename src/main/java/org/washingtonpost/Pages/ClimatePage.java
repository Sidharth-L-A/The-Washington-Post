package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClimatePage {
    WebDriver driver;
    WebElement page;

    public ClimatePage (WebDriver driver) {
            this.driver = driver;
    }

    public boolean verifyUserIsInClimatePage() {
        System.out.println("verifyUserIsInClimatePage Method");
        page = driver.findElement(By.xpath("//h1[@class='font--headline lh-sm uppercase gray-darkest']"));
        System.out.println("'CLIMATE' Page Header Found");
        return page.getText().equalsIgnoreCase("Climate");
    }
}
