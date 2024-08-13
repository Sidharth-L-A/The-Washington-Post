package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StylePage {
        WebDriver driver;
        WebElement page;

        public StylePage(WebDriver driver) {
            this.driver = driver;
        }

        public boolean verifyUserIsInStylePage() {
            System.out.println("verifyUserIsInStylePage Method");
            page = driver.findElement(By.xpath("//h1[@class='font--headline lh-sm gray-darkest']"));
            System.out.println("'STYLE' Page Header Found");
            return page.getText().equalsIgnoreCase("Style");
        }
}
