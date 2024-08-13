package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpinionsPage {
        WebDriver driver;
        WebElement page;

        public OpinionsPage(WebDriver driver) {
            this.driver = driver;
        }

        public boolean verifyUserIsInOpinionsPage() {
            System.out.println("verifyUserIsInOpinionsPage Method");
            page = driver.findElement(By.xpath("//h1[@class='font--headline lh-sm uppercase gray-darkest']"));
            System.out.println("'OPINIONS' Page Header Found");
            return page.getText().equalsIgnoreCase("Opinions");
        }
}
