package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SubscribePage {
    WebElement field;
    WebDriver driver;

    public SubscribePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyUserIsInSubscribePage() {
        field = driver.findElement(By.xpath("//div[@data-qa='header-text']"));
        System.out.println("Subscribe Page header found");
        return field.getText().equalsIgnoreCase("Choose Your Plan");
    }
}
