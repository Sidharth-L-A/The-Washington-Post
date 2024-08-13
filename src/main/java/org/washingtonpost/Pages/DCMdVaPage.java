package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DCMdVaPage {
    WebDriver driver;
    WebElement page;

    public DCMdVaPage (WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyUserIsInDCMdVaPage() {
        System.out.println("verifyUserIsInDCMdVaPage Method");
        page = driver.findElement(By.xpath("//h1[@class='font--headline lh-sm uppercase gray-darkest']"));
        System.out.println("'DCMDVA' Page Header Found");
        return page.getText().equalsIgnoreCase("DCMdVa");
    }
}
