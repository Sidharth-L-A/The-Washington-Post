package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class SignInPage {
    WebDriver driver;
    WebElement button, field;
    String buttonName, fieldName;

    public WebElement signInButton() {
        System.out.println("signInButton Method");

        buttonName = driver.findElement(By.xpath("//*[@id='__next']/div/div[1]/nav/div[2]/a")).getText();
        System.out.println("Button Name : " + buttonName);

        if(Objects.equals(buttonName, "Sign in")) {
            button = driver.findElement(By.xpath("//*[@id='__next']/div/div[1]/nav/div[2]/a"));
            System.out.println("Sign In Button found");
        }
        return button;
    }

    public WebElement nextButton() {
        System.out.println("nextButton Method");

        buttonName = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/form/button[1]")).getText();
        System.out.println("Button Name : " + buttonName);

        if(Objects.equals(buttonName, "Next")) {
            button = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/form/button[1]"));
            System.out.println("Next Button found");
        }
        return button;
    }

    public boolean enterEmailIdPassword(String emailIdPwd){
        System.out.println("enterEmailIdPassword Method");

        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            inputField().sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else {
            inputField().sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        }
    }

    public WebElement inputField() {
        System.out.println("inputField Method");

        fieldName = driver.findElement(By.xpath("//*[@id='radix-0']")).getText();
        System.out.println("Field Name : " + fieldName);

        if(Objects.equals(fieldName, "Email address")) {
            field = driver.findElement(By.xpath("//*[@id='username']"));
            System.out.println("Email Address text field found");
        } else {
            field = driver.findElement(By.xpath("//*[@id='password']"));
            System.out.println("Password text field found");
        }
        return field;
    }

    public boolean verifySignIn() {
        System.out.println("verifySignIn Method");
        buttonName = driver.findElement(By.xpath("//*[@id='__next']/div/div[1]/nav/div[2]/button/span")).getText();
        System.out.println("Account Name : " + buttonName);
        return true;
    }
}
