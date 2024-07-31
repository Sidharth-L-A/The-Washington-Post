package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivacyPolicy {
    WebDriver driver;
    public PrivacyPolicy(WebDriver driver) {
        this.driver = driver;
    }
    public boolean verifyPrivacyPolicyPage(){
        System.out.println("PrivacyPolicy.verifyPrivacyPolicyPage() Method");
        return driver.findElement(By.xpath("//h1[@id='main-content']")).isDisplayed();
    }
}
