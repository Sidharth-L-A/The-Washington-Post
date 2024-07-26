package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.support.Color;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInPage {
    // To Do :
    // Define the xpaths of elements in public strings

    WebDriver driver;
    WebElement button, field, checkBox;
    String buttonName, fieldName, signUpPrompt;

    public WebElement signInButton() {
        System.out.println("signInButton Method");

        buttonName = driver.findElement(By.xpath("//*[@id='__next']/div/div[1]/nav/div[2]/a")).getText();
        System.out.println("Button Name : " + buttonName);

        if(Objects.equals(buttonName, "Sign in")) {
            button = driver.findElement(By.xpath("//*[@id='__next']/div/div[1]/nav/div[2]/a"));
            System.out.println("Sign In Button found");

            Assert.assertTrue(buttonColorChange(button));
            System.out.println("Sign In Button color changes");
        }
        return button;
    }

    public WebElement signUpButton() {
        System.out.println("signUpButton Method");

        signUpPrompt = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/div[3]")).getText();
        System.out.println("Verifying Sign-Up Prompt from Sign-In page : " + signUpPrompt);

        buttonName = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/div[3]/a")).getText();
        System.out.println("Button Name : " + buttonName);

        if(Objects.equals(buttonName, "Sign Up")) {
            button = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/div[3]/a"));
            System.out.println("Sign Up Button found");

            Assert.assertTrue(buttonColorChange(button));
            System.out.println("Sign Up Button color changes");
        }
        return button;
    }

    public WebElement nextButton() {
        System.out.println("nextButton Method");

//        Confirm whether it is required to check the button is disabled while the Email ID field is empty.

        buttonName = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/form/button[1]")).getText();
        System.out.println("Button Name : " + buttonName);

        if(Objects.equals(buttonName, "Next")) {
            button = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/form/button[1]"));
            System.out.println("Next Button found");

            Assert.assertTrue(buttonColorChange(button));
            System.out.println("Next Button color changes");
        }
        return button;
    }

    public WebElement continueButton() {
        System.out.println("nextButton Method");

        buttonName = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/button")).getText();
        System.out.println("Button Name : " + buttonName);

        if(Objects.equals(buttonName, "Next")) {
            button = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/button"));
            System.out.println("Continue Button found");

            Assert.assertTrue(buttonColorChange(button));
            System.out.println("Continue Button color changes");
        }
        return button;
    }

    public boolean buttonColorChange(WebElement button) {
        String initialColor = button.getCssValue("background-color");
        System.out.println("Button Color before hovering : " + initialColor);

        Actions actions = new Actions(driver);
        actions.moveToElement(button).perform();

        String hoverColor = button.getCssValue("background-color");
        System.out.println("Button Color after hovering : " + hoverColor);

        String initialHexColor = Color.fromString(initialColor).asHex();
        String hoverHexColor = Color.fromString(hoverColor).asHex();

        return !initialHexColor.equals(hoverHexColor);
    }
    public boolean enterEmailIdPassword(String emailIdPwd){
        System.out.println("enterEmailIdPassword Method");

        // Currently verify only gmail & yahoo Email IDs :
        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            inputField().sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) &&
                !(emailIdPwd.length() < 8) &&
                pwdValidator(emailIdPwd)) {
            inputField().sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        }
        return false;
    }

    public boolean pwdValidator(String emailIdPwd) {
        String lowercasePattern = ".*[a-z].*";
        String uppercasePattern = ".*[A-Z].*";
        String digitPattern = ".*\\d.*";
        String specialCharPattern = ".*[!\"$#%&'()\\[\\]{}=+\\-*/.,\\\\^@_:;~].*";

        Pattern lowerCase = Pattern.compile(lowercasePattern);
        Pattern upperCase = Pattern.compile(uppercasePattern);
        Pattern digit = Pattern.compile(digitPattern);
        Pattern specialChar = Pattern.compile(specialCharPattern);

        Matcher lowerCaseMatcher = lowerCase.matcher(emailIdPwd);
        Matcher upperCaseMatcher = upperCase.matcher(emailIdPwd);
        Matcher digitMatcher = digit.matcher(emailIdPwd);
        Matcher specialCharMatcher = specialChar.matcher(emailIdPwd);

        return lowerCaseMatcher.matches() &&
                upperCaseMatcher.matches() &&
                digitMatcher.matches() &&
                specialCharMatcher.matches();
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

    public boolean verifyCheckBox(String checkboxIntention) {
        System.out.println("verifyCheckBox Method");

        checkBox = driver.findElement(By.xpath("//*[@role='checkbox']"));
        System.out.println("Check Box located");

        if (checkboxIntention.equalsIgnoreCase("agreeT&C")) {
            if(checkBox.getAttribute("data-state").contains("unchecked")) {
                checkBox.click();
                System.out.println("Clicked on T&C CheckBox");
                return true;
            } return true;
        }
        return false;
    }

    public boolean editEmailId() {
        System.out.println("editEmailId Method");

        fieldName = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/form/div[2]/div")).getText();
        System.out.println("Previously Entered Email ID : " + fieldName);

        // Change button
        driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/form/div[2]/button")).click();
        System.out.println("Clicked on 'Change' Button");
        return true;
    }

    public boolean welcomeNote() {
        return driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/form/div[2]/button")).getText().equals("Welcome to The Washington Post!");
    }
}
