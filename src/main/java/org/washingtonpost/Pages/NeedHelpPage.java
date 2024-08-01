package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NeedHelpPage {
    WebDriver driver;
    WebElement field;
    String originalHandle;

    public NeedHelpPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyNeedHelpPage() throws InterruptedException {
        field = driver.findElement(By.xpath("//span[@class='hero-title']"));
        System.out.println("Current Page : " + field.getText());
        driver.wait(3000);

        originalHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        driver.close();
        driver.switchTo().window(originalHandle);
        return true;
    }
}
