package org.washingtonpost.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.Color;
import java.time.Duration;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInPage {
    WebDriver driver;
    WebDriverWait wait;
    WebElement button, field, checkBox;
    String buttonName, fieldName, signUpPrompt;
    Commons commons;
    EmailLinkVerificationPage linkVerificationPage;
    EmailLinkVerificationPage SignInWithGooglePage;
    PrivacyPolicy privacyPolicy;
    NeedHelpPage needHelpPage;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        commons = new Commons(driver);
        linkVerificationPage = new EmailLinkVerificationPage(driver);
        SignInWithGooglePage = new EmailLinkVerificationPage(driver);
        privacyPolicy = new PrivacyPolicy(driver);
        needHelpPage = new NeedHelpPage(driver);
    }

    public boolean verifySignInPage() {
        field = driver.findElement(By.xpath("//h1[@data-test-id='signin-header']"));
        return field.getText().equalsIgnoreCase("Sign In");
    }

    public WebElement signInButton() {
        System.out.println("signInButton Method");

        String[] xpaths = {"//a[@aria-label='Sign in']", "//button[text()='Sign In']"};

        for (String xpath : xpaths) {
            try {
                button = driver.findElement(By.xpath(xpath));
                buttonName = button.getText();
                System.out.println("Button Found : " + buttonName);
                break;
            } catch (NoSuchElementException e) {
                System.out.println("Button not found using xpath [" + xpath + "]");
            }
        }
        return button;
    }

    public WebElement signUpButton() {
        System.out.println("signUpButton Method");

        signUpPrompt = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/div[3]")).getText();
        System.out.println("Verifying Sign-Up Prompt from Sign-In page: " + signUpPrompt);

//        Scroll if required :
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(arguments[0], arguments[1]);", 0, 550);

        buttonName = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/div[3]/a")).getText();
        System.out.println("Button Name: " + buttonName);

        button = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/div[3]/a"));
        System.out.println("Sign Up Button found");

//            to be added to UI test script
//            Assert.assertTrue(buttonColorChange(button));
//            System.out.println("Sign Up Button color changes");
//        }
        return button;
    }

    public WebElement nextButton() {
        System.out.println("nextButton Method");

        button = driver.findElement(By.xpath("//button[@data-test-id='sign-in-btn']"));
        buttonName = button.getText();
        System.out.println("Button Found : " + buttonName);

//            to be added to UI test script
//            Assert.assertTrue(buttonColorChange(button));
//            System.out.println("Next Button color changes");
        return button;
    }

    public WebElement continueButton() {
        System.out.println("continueButton Method");

        buttonName = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/button")).getText();
        System.out.println("Button Name: " + buttonName);

        if (Objects.equals(buttonName, "Next")) {
            button = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/button"));
            System.out.println("Continue Button found");

//            to be added to UI test script
//            Assert.assertTrue(buttonColorChange(button));
//            System.out.println("Continue Button color changes");
        }
        return button;
    }

    public WebElement signInWithAppleButton() {
        System.out.println("signInWithAppleButton Method");
        button = driver.findElement(By.xpath("//button[@data-qa='auth--apple']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }

    public WebElement signInWithGoogleButton()  {
        System.out.println("signInWithGoogleButton Method");
        button = driver.findElement(By.xpath("//button[@data-qa='auth--google']"));
        System.out.println("Button Found : " + button.getText());

        return button;
    }

    public WebElement signinwithGoogleNextButton() {
        System.out.println("signinwithGoogleNextButton Method");
        button = driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 BqKGqe Jskylb TrZEUc lw1w4b']"));
        System.out.println("Next Button Found : " + button.getText());
        return button;
    }

    public WebElement signinwithGooglePasswordNextButton() {
        System.out.println("signinwithGooglePasswordNextButton Method");
        button = driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 BqKGqe Jskylb TrZEUc lw1w4b']"));
        System.out.println("Next Button Found : " + button.getText());
        return button;
    }
    public WebElement signInWithAppleSignInArrowButton() {
        System.out.println("signInWithAppleSignInArrowButton Method");
        button = driver.findElement(By.xpath("//button[@id='sign-in']"));
        System.out.println("Next Button Found : " + button.getText());
        return button;
    }

    public WebElement signInWithApplePasswordArrowButton() {
        System.out.println("signInWithApplePasswordArrowButton Method");
        button = driver.findElement(By.xpath("//button[@id='sign-in']"));
        System.out.println("Next Button Found : " + button.getText());
        return button;
    }

    public WebElement signInWithAppleIDContinueButton() {
        System.out.println("signInWithAppleIDContinueButton Method");
        button = driver.findElement(By.xpath("//div[@class='overflow-text']"));
        System.out.println("Next Button Found : " + button.getText());
        return button;
    }
    public WebElement linkSignInButton(){
        System.out.println("linkSignInButton Method");
        button = driver.findElement(By.xpath("//button[@data-test-id='pml-btn']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }
    public WebElement signinwithAmazonButton() {
        System.out.println("signinwithAmazonButton Method");
        button = driver.findElement(By.xpath("button[@data-qa='auth--amazon']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }
    public WebElement signinwithFacebookButton() {
        System.out.println("signinwithFacebooktButton Method");
        button = driver.findElement(By.xpath("//button[@data-qa='auth--facebook']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }
    public WebElement signinwithFacebookLogInButton() {
        System.out.println("signinwithFacebookLogInButton Method");
        button = driver.findElement(By.xpath("//button[@id='loginbutton']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }
    public WebElement signinwithAmazonContinueButton() {
        System.out.println("signinwithAmazonContinueButton Method");
        button = driver.findElement(By.xpath("//input[@id='continue']"));
        System.out.println("Continue Button Found : " + button.getText());
        return button;
    }

    public WebElement signinwithAmazoPasswordButton() {
        System.out.println("signinwithAmazoPasswordButton Method");
        button = driver.findElement(By.xpath("//input[@class='a-button-input']"));
        System.out.println("Sign in with password Button Found : " + button.getText());
        return button;
    }

    // This method shall be called while scripting UI test cases
    public boolean buttonColorChange(WebElement button) {
        String initialColor = button.getCssValue("background-color");
        System.out.println("Button Color before hovering: " + initialColor);
        Actions actions = new Actions(driver);
        actions.moveToElement(button).perform();

        String hoverColor = button.getCssValue("background-color");
        System.out.println("Button Color after hovering: " + hoverColor);

        String initialHexColor = Color.fromString(initialColor).asHex();
        String hoverHexColor = Color.fromString(hoverColor).asHex();

        return !initialHexColor.equals(hoverHexColor);
    }

    public boolean enterEmailIdPassword(String emailIdPwd) throws InterruptedException {
        System.out.println("enterEmailIdPassword Method");
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

    public boolean enterGoogleEmailId(String emailIdPwd) throws InterruptedException {
        System.out.println("enterGoogleEmailId Method");

        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            googleInputField().sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) &&
                !(emailIdPwd.length() < 8) &&
                pwdValidator(emailIdPwd)) {
           googleInputField().sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        }
        return false;
    }

    public boolean enterAppleEmailId(String emailIdPwd) throws InterruptedException {
        System.out.println("enterAppleEmailId Method");

        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            appleInputField().sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) &&
                !(emailIdPwd.length() < 8) &&
                pwdValidator(emailIdPwd)) {
            appleInputField().sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        }
        return false;
    }

    public boolean enterGoogleEmailPassword(String emailIdPwd) throws InterruptedException {
        System.out.println("enterGoogleEmailPassword Method");

        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            googleInputField().sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) &&
                !(emailIdPwd.length() < 8) &&
                pwdValidator(emailIdPwd)) {
            googleInputField().sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        }
        return false;
    }
    public boolean enterAppleEmailPassword(String emailIdPwd) throws InterruptedException {
        System.out.println("enterAppleEmailPassword Method");

        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            appleInputField().sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) &&
                !(emailIdPwd.length() < 8) &&
                pwdValidator(emailIdPwd)) {
            appleInputField().sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        }
        return false;
    }
    public boolean enterAmazonEmailId(String emailIdPwd) throws InterruptedException {
        System.out.println("enterAmazonEmailId Method");

        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            amazonInputField().sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) &&
                !(emailIdPwd.length() < 8) &&
                pwdValidator(emailIdPwd)) {
            amazonInputField().sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        }
        return false;
    }
  
    public boolean enterFacebookEmailId(String emailIdPwd) throws InterruptedException {
        System.out.println("enterFacebookEmailId Method");

        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            facebookInputField().sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) &&
                !(emailIdPwd.length() < 8) &&
                pwdValidator(emailIdPwd)) {
            facebookInputField().sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        }
        return false;
    }

    public boolean enterGoogleEmail(String emailPassword) throws InterruptedException {

        System.out.println("enterGoogleEmail Method");
        return false;
    }

        if (emailPassword.contains("@gmail.com") || emailPassword.contains("@yahoo.com")) {
            inputField().sendKeys(emailPassword);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailPassword.contains("@gmail.com") || emailPassword.contains("@yahoo.com")) &&
                !(emailPassword.length() < 8) &&
                pwdValidator(emailPassword)) {
            inputField().sendKeys(emailPassword);
            System.out.println("Password entered");
            return true;
        }
        return false;
    }

    public boolean enterFacebookEmailInvalidPassword(String emailinvalidPassword) throws InterruptedException {
        System.out.println("enterFacebookEmail Method");

        if (emailinvalidPassword.contains("@gmail.com") || emailinvalidPassword.contains("@yahoo.com")) {
            inputField().sendKeys(emailinvalidPassword);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailinvalidPassword.contains("@gmail.com") || emailinvalidPassword.contains("@yahoo.com")) &&
                !(emailinvalidPassword.length() < 8) &&
                pwdValidator(emailinvalidPassword)) {
            inputField().sendKeys(emailinvalidPassword);
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

    public WebElement inputField() throws InterruptedException {
        System.out.println("inputField Method");
        driver.wait(2500);

        if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='username']")))).isDisplayed()) {
            System.out.println("Email Address text field found");
            return field;
        } else if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='password']")))).isDisplayed()) {
            System.out.println("Password text field found");
            return field;
        } return null;
    }

    public WebElement googleInputField() throws InterruptedException {
        System.out.println("googleInputField Method");
        driver.wait(2500);

        if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='email']")))).isDisplayed()) {
            System.out.println("Email Address text field found");
            return field;
        } else if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='password']")))).isDisplayed()) {
            System.out.println("Password text field found");
            return field;
        } return null;
    }

    public WebElement appleInputField() throws InterruptedException {
        System.out.println("appleInputField Method");
        driver.wait(2500);

        if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='text']")))).isDisplayed()) {
            System.out.println("Email Address text field found");
            return field;
        } else if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='password']")))).isDisplayed()) {
            System.out.println("Password text field found");
            return field;
        }
        return null;
    }
    public WebElement amazonInputField() throws InterruptedException {
        System.out.println("amazonInputField Method");
        driver.wait(2500);

        if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='email']")))).isDisplayed()) {
            System.out.println("Email Address text field found");
            return field;
        } else if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='password']")))).isDisplayed()) {
            System.out.println("Password text field found");
            return field;
        }
        return null;
    }
    public WebElement facebookInputField() throws InterruptedException {
        System.out.println("facebookInputField Method");
        driver.wait(2500);

        if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']")))).isDisplayed()) {
            System.out.println("Email Address text field found");
            return field;
        } else if (wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='Password']")))).isDisplayed()) {
            System.out.println("Password text field found");
            return field;
        }
        return null;
    }

    public boolean needHelpToSignInLink(String emailId) throws InterruptedException {
        System.out.println("needHelpToSignInLink Method");
        driver.wait(3000);

        button = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='red underline']"))));
        System.out.println("Error Message : " + button.getText());

        // need help signing in button click 1
        button.click();
        Thread.sleep(3000);

        // //*[@class='wpds-c-bdLjjU'] - forgot password page verify with this heading 2
        Assert.assertTrue(forgotPasswordPage().isDisplayed());
        Thread.sleep(3000);

        // if empty email ID - @class="red font-xxxs" - error message - put in commmons page 3
        forgotPasswordButton().click();
        Assert.assertTrue(verifyEmailError());
        Thread.sleep(3000);

        // input box verify (Email ID) 4
        inputField().click();
        inputField().sendKeys(emailId);
        Thread.sleep(3000);

        // data-test-id="forgot-password-btn" - send link to reset password button 5
        forgotPasswordButton().click();
        Thread.sleep(3000);

        // @class="mt-md font-md font-bold font--headline" check ur mail page 6
        linkVerificationPage.linkSentNote();
        Thread.sleep(3000);

        // Not You ? button @data-qa="forgot-password-email-change" click 7
        notYouButton().click();
        Thread.sleep(3000);

        // forgot password page - provide mail ID 8
        Assert.assertTrue(forgotPasswordPage().isDisplayed());
        Thread.sleep(3000);

        // privacy policy button 9
        linkVerificationPage.verifyPrivacyPolicyButton();
        Thread.sleep(3000);

        // need help ? button 10
        commons.needHelpButton().click();
        Assert.assertTrue(needHelpPage.verifyNeedHelpPage());
        Thread.sleep(3000);

        // back to sign in button @data-test-id="signin-header" header of page 11
        backToSignInButton().click();
        Assert.assertTrue(verifySignInPage());
        Thread.sleep(3000);

//        For Sid's Future Reference, Ignore :
//        If failed continuously, new Page : Check your email for a one-time sign in link
//        Signin another way button (button) @data-qa="sign-in-another-way"
//        If Clicked, verifySigInPage()
//        Privacy Policy
//        Need help


        return true;
    }

    public WebElement backToSignInButton() {
        System.out.println("backToSignInButton Method");
        button = driver.findElement(By.xpath("//a[@class='wpds-c-funcLJ']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }

    public WebElement notYouButton() {
        System.out.println("notYouButton Method");
        button = driver.findElement(By.xpath("//*[@data-qa='forgot-password-email-change']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }
    public WebElement forgotPasswordPage(){
        System.out.println("needHelpToSignInButton Method");
        field = driver.findElement(By.xpath("//*[@class='wpds-c-bdLjjU']"));
        System.out.println("Current Page : " + field.getText());
        return field;
    }
    public WebElement forgotPasswordButton() {
        System.out.println("needHelpToSignInButton Method");
        button = driver.findElement(By.xpath("//*[@class='wpds-c-bdLjjU']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }

    public boolean verifyEmailError() throws InterruptedException {
        System.out.println("verifyEmailError Method");
        driver.wait(3000);
      field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='red font-xxxs']"))));

        System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }

    public boolean verifyGoogleIDEmailError() throws InterruptedException {
        System.out.println("verifyGoogleIDEmailError Method");
        Thread.sleep(3000);
        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='Ekjuhf Jj6Lae']"))));
System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }
    public boolean verifyAmazonIDEmailError() throws InterruptedException {
        System.out.println("verifyAmazonIDEmailError Method");
        driver.wait(3000);
        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='ap_email']"))));
        System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }

    public boolean verifyAppleIDEmailError() throws InterruptedException {
        System.out.println("verifyAppleIDEmailError Method");
        driver.wait(3000);
        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@id='errMsg']"))));
System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }
    public boolean verifyFacebookIDEmailError() throws InterruptedException {
        System.out.println("verifyFacebookIDEmaiErro Method");
        driver.wait(3000);
        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='email']"))));
        System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }

    public boolean verifyGoogleIDPasswordEmailError() throws InterruptedException {
        System.out.println("verifyGoogleIDPasswordEmailError Method");
        driver.wait(3000);
        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[.='Wrong password. Try again or click ‘Forgot password’ to reset it.']"))));
        System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }
    public boolean verifyAppleIDPasswordEmailError() throws InterruptedException {
        System.out.println("verifyAppleIDPasswordEmailError Method");
        driver.wait(3000);
        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[@id='errMsg']"))));
System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }
    public boolean verifyAmazonIDPasswordEmailError() throws InterruptedException {
        System.out.println("verifyAmazonIDPasswordEmailError Method");
        driver.wait(3000);
        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"pass\"]"))));
        System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }

    public boolean verifyFacebookIDPasswordEmailError() throws InterruptedException {
        System.out.println("verifyFacebookIDPasswordEmailError Method");
        driver.wait(3000);
        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"pass\"]"))));
        System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }

    public boolean verifySignIn(String accountName) {
        System.out.println("verifySignIn Method");
        try {
            driver.wait(3500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        buttonName = driver.findElement(By.xpath("//span[@class='wpds-c-gRqkNc']")).getText();
        System.out.println("Account Name: " + buttonName);
        return buttonName.contains(accountName);
    }

    public boolean verifyCheckBox(String checkboxIntention) {
        System.out.println("verifyCheckBox Method");

        checkBox = driver.findElement(By.xpath("//*[@role='checkbox']"));
        System.out.println("Check Box located");

        if (checkboxIntention.equalsIgnoreCase("agreeT&C")) {
            if (checkBox.getAttribute("data-state").contains("unchecked")) {
                checkBox.click();
                System.out.println("Clicked on T&C CheckBox");
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean editEmailId() throws InterruptedException {
        System.out.println("editEmailId Method");
        Thread.sleep(3000);
        fieldName = driver.findElement(By.xpath("//div[@data-test-id='current-email']")).getText();
        System.out.println("Previously Entered Email ID: " + fieldName);

        // Change button
        button = commons.changeButton();
        button.click();
        return true;
    }

    public boolean checkWelcomeNote() {
        System.out.println("checkWelcomeNote Method");
        return driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/form/div[2]/button")).getText().equals("Welcome to The Washington Post!");
    }

}
