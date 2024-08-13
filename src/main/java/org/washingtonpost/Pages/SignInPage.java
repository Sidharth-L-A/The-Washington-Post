package org.washingtonpost.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInPage {
    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement button, field, checkBox;
    String buttonName, fieldName, signUpPrompt;

    public boolean verifySignInPage() {
        System.out.println("verifySignInPage Method");
        field = driver.findElement(By.xpath("//h1[@data-test-id='signin-header']"));
        return field.getText().equalsIgnoreCase("Sign In");
    }

    public WebElement signInButton() throws InterruptedException {
        System.out.println("signInButton Method");
        UI ui = new UI(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String[] xPaths = {"//a[@aria-label='Sign in']", "//button[text()='Sign In']", "//button[@data-test-id='sign-in-btn']"};

        for (String xPath : xPaths) {
            try {
                button = driver.findElement(By.xpath(xPath));
                buttonName = button.getText();
                System.out.println("Button Found : " + buttonName);

                boolean isColorCorrect = wait.until(driver -> {
                    String buttonColor = (String) js.executeScript(
                            "return window.getComputedStyle(arguments[0]).getPropertyValue('background-color');",
                            button);
                    return buttonColor.equals("rgba(0, 0, 0, 0)") || buttonColor.equals("rgb(22, 109, 252)");
                });

                Assert.assertTrue(isColorCorrect);
                System.out.println("Button Color Verified");

                Assert.assertTrue(ui.buttonColorChange(button));
                break;
            } catch (NoSuchElementException e) {
                System.out.println("Button not found using xpath [" + xPath + "]");
            }
        }
        return button;
    }

    public WebElement signUpButton() throws InterruptedException {
        System.out.println("signUpButton Method");
        UI ui = new UI(driver);
        signUpPrompt = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/div[3]")).getText();
        System.out.println("Verifying Sign-Up Prompt from Sign-In page: " + signUpPrompt);

//        Scroll if required :
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollTo(arguments[0], arguments[1]);", 0, 550);

        button = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/div[3]/a"));
        System.out.println("Button Name: " + button.getText());

//        button = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/div[3]/a"));
//        buttonName = button.getCssValue("Background-color");
//        System.out.println("Sign Up Button found");
//        Assert.assertTrue(ui.verifyWhiteButtonColor(buttonName));
//        Assert.assertTrue(ui.buttonColorChange(button));
        return button;
    }

    public WebElement nextButton() {
        System.out.println("nextButton Method");
        WebElement button = null;

        try {
            Thread.sleep(2000);
            button = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test-id='sign-in-btn']"))));
        } catch (Exception e) {
            try {
                Thread.sleep(2000);
                button = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test-id='signup-btn']"))));
            } catch (Exception ex) {
                System.out.println("XXX--- Next Button Not Found ---XXX");
            }
        }
        return button;
    }

    public WebElement googleNextButton() throws InterruptedException {
        System.out.println("googleNextButton Method");
        Thread.sleep(2000);
        try {
            button = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[text()='Next']"))));
            System.out.println("Button Found : " + button.getText());
        } catch (Exception ex) {
            System.out.println("XXX--- Google Next Button Not Found ---XXX");
        }
        return button;
    }

    public WebElement continueButton() {
        System.out.println("continueButton Method");

        buttonName = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/button")).getText();
        System.out.println("Button Name: " + buttonName);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean isColorCorrect = wait.until(driver -> {
            String buttonColor = (String) js.executeScript(
                    "return window.getComputedStyle(arguments[0]).getPropertyValue('background-color');",
                    button);
            System.out.println("Next button Color : " + buttonColor);
            return buttonColor.equals("rgb(22, 109, 252)");
        });

        Assert.assertTrue(isColorCorrect);
        if (Objects.equals(buttonName, "Continue")) {
            button = driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/div/button"));
            System.out.println("Continue Button found");
        }
        return button;
    }

    public WebElement appleSignInContinueButton() {
        System.out.println("continueButton Method");

        button = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='Continue']"))));
        System.out.println("Button Found : " + button.getText());

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        boolean isColorCorrect = wait.until(driver -> {
//            String buttonColor = (String) js.executeScript(
//                    "return window.getComputedStyle(arguments[0]).getPropertyValue('background-color');",
//                    button);
//            System.out.println("Next button Color : " + buttonColor);
//            return buttonColor.equals("rgb(22, 109, 252)");
//        });
//
//        Assert.assertTrue(isColorCorrect);
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

    public WebElement signInWithGoogleNextButton() {
        System.out.println("signInWithGoogleNextButton Method");
        button = driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 BqKGqe Jskylb TrZEUc lw1w4b']"));
        System.out.println("Next Button Found : " + button.getText());
        return button;
    }

    public WebElement signInWithGooglePasswordNextButton() {
        System.out.println("signInWithGooglePasswordNextButton Method");
        button = driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 BqKGqe Jskylb TrZEUc lw1w4b']"));
        System.out.println("Next Button Found : " + button.getText());
        return button;
    }

    public WebElement signInWithAppleSignInArrowButton() {
        System.out.println("signInWithAppleSignInArrowButton Method");
        button = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@id='sign-in']"))));
        System.out.println("Next Button Found : " + button.getText());
        return button;
    }

    public WebElement signInWithAppleIDContinueButton() {
        System.out.println("signInWithAppleIDContinueButton Method");
        button = driver.findElement(By.xpath("//div[@class='overflow-text']"));
        System.out.println("Next Button Found : " + button.getText());
        return button;
    }

    public WebElement linkSignInButton() {
        System.out.println("linkSignInButton Method");
        button = driver.findElement(By.xpath("//button[@data-test-id='pml-btn']"));
        System.out.println("Button Found : " + button.getText());
        return button;
    }

    public boolean enterEmailIdPassword(String emailIdPwd, String fieldType) throws InterruptedException {
        System.out.println("enterEmailIdPassword Method");
        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            inputField(fieldType).sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailIdPwd.contains("@gmail.com")) && !(emailIdPwd.contains("@yahoo.com")) &&
                !(emailIdPwd.length() < 8) &&
                pwdValidator(emailIdPwd)) {
            inputField(fieldType).sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        }
        return false;
    }

    public boolean enterGoogleEmailId(String fieldType, String emailIdPwd) throws InterruptedException {
        System.out.println("enterGoogleEmailId Method");

        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            googleInputField(fieldType).sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) &&
                !(emailIdPwd.length() < 8) &&
                pwdValidator(emailIdPwd)) {
           googleInputField(fieldType).sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        }
        return false;
    }

    public boolean enterAppleEmailId(String emailIdPwd, String fieldType) throws InterruptedException {
        System.out.println("enterAppleEmailId Method");

        if (emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) {
            appleInputField(fieldType).sendKeys(emailIdPwd);
            System.out.println("Email Address entered");
            return true;
        } else if (!(emailIdPwd.contains("@gmail.com") || emailIdPwd.contains("@yahoo.com")) &&
                !(emailIdPwd.length() < 8) &&
                pwdValidator(emailIdPwd)) {
            appleInputField(fieldType).sendKeys(emailIdPwd);
            System.out.println("Password entered");
            return true;
        } else if (emailIdPwd.length() == 6) {
            appleInputField(fieldType).sendKeys(emailIdPwd);
            System.out.println("Apple Two Factor Authentication Code entered");
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

    public WebElement inputField(String fieldType) throws InterruptedException {
        System.out.println("inputField Method");
        if (fieldType.equalsIgnoreCase("EmailId")) {
            Thread.sleep(2000);
            field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='username']"))));
            Assert.assertTrue(field.isDisplayed());
            System.out.println("Email Address text field found");
        } else {
            field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='password']"))));
            Assert.assertTrue(field.isDisplayed());
            System.out.println("Password text field found");
        }
        return field;
    }

    public WebElement googleInputField(String fieldType) throws InterruptedException {
        System.out.println("googleInputField Method");
        Thread.sleep(2500);

        if (fieldType.equalsIgnoreCase("EmailId")) {
            field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='email']"))));
            Assert.assertTrue(field.isDisplayed());
            System.out.println("Email Address text field found");
        } else {
            field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='password']"))));
            Assert.assertTrue(field.isDisplayed());
            System.out.println("Password text field found");
        } return field;
    }

    public WebElement appleInputField(String fieldType) {
        System.out.println("appleInputField Method");

        if (fieldType.equalsIgnoreCase("EmailId")) {
            field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='text']"))));
            Assert.assertTrue(field.isDisplayed());
            System.out.println("Email Address text field found");
        } else if (fieldType.equalsIgnoreCase("Password")) {
            field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='password']"))));
            Assert.assertTrue(field.isDisplayed());
            System.out.println("Password text field found");
        } return field;
    }

    public boolean appleTwoFactorAuth(String twoFactorAuthCode) {
        System.out.println("appleTwoFactorAuth Method");

        boolean result = false;
        WebElement securityCodeContainers = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='security-code-container force-ltr']"))));
        System.out.println("Apple Two Factor Authentication field found");

        List<WebElement> twoFactorAuthBoxes = securityCodeContainers.findElements(By.xpath("//div/input[@class='form-control force-ltr form-textbox-input char-field']"));
        System.out.println("Apple Two Factor Authentication Code Containers found");

        if (twoFactorAuthBoxes.size() == twoFactorAuthCode.length()) {
            System.out.println("Injecting the Two Factor Authentication Code :");
            for (int codeContainer = 0; codeContainer < twoFactorAuthBoxes.size(); codeContainer++) {
                WebElement twoFactorAuthCodeInputBox = twoFactorAuthBoxes.get(codeContainer);
                String code = String.valueOf(twoFactorAuthCode.charAt(codeContainer));
                twoFactorAuthCodeInputBox.sendKeys(code);
                System.out.println(code);
                result = !twoFactorAuthCodeInputBox.getText().isEmpty();
            }
        } else throw new IllegalArgumentException("Lengths of 'Two Factor Auth Code' & 'Code Input Field' does not match ");
        return result;
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

    public boolean needHelpToSignInLink(String fieldType, String emailId) throws InterruptedException {
        System.out.println("needHelpToSignInLink Method");
        EmailLinkVerificationPage linkVerificationPage = new EmailLinkVerificationPage(driver);
        Commons commons = new Commons(driver);
        NeedHelpPage needHelpPage = new NeedHelpPage(driver);

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
        inputField(fieldType).click();
        inputField(fieldType).sendKeys(emailId);
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
        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='pass']"))));
        System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }

    public boolean verifyFacebookIDPasswordEmailError() throws InterruptedException {
        System.out.println("verifyFacebookIDPasswordEmailError Method");
        driver.wait(3000);
        field = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='pass']"))));
        System.out.println("Error Message : " + field.getText());
        return field.isDisplayed();
    }

    public boolean verifySignIn(String accountName) throws InterruptedException {
        System.out.println("verifySignIn Method");
        Thread.sleep(3500);
        buttonName = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@class='wpds-c-gRqkNc']")))).getText();
        System.out.println("Account Name: " + buttonName);
        return accountName.contains(buttonName);
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
        Thread.sleep(2000);
        fieldName = driver.findElement(By.xpath("//div[@data-test-id='current-email']")).getText();
        System.out.println("Previously Entered Email ID: " + fieldName);

        // Change button
        Commons commons = new Commons(driver);
        button = commons.changeButton();
        button.click();
        return true;
    }

    public boolean checkWelcomeNote() {
        System.out.println("checkWelcomeNote Method");
        return driver.findElement(By.xpath("//*[@id='__next']/div/div[2]/div/div/form/div[2]/button")).getText().equals("Welcome to The Washington Post!");
    }
}
