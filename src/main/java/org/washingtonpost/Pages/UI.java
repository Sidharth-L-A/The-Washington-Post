package org.washingtonpost.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;

public class UI {
    WebDriver driver;
    WebDriverWait wait;
    Commons commons;
    EmailLinkVerificationPage linkVerificationPage;
    PrivacyPolicy privacyPolicy;
    NeedHelpPage needHelpPage;
    JavascriptExecutor jsExecutor;
    SignInPage signInPage;
    HomePage homepage;
    String buttonColor;

    List <String> pathsOfButtons = Arrays.asList(
            "button[data-qa='auth--amazon']",
            "button[data-qa='auth--facebook']",
            "button[data-qa='auth--google']",
            "button[data-qa='auth--amazon']"
    );

    public UI(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        commons = new Commons(driver);
//        linkVerificationPage = new EmailLinkVerificationPage(driver);
//        privacyPolicy = new PrivacyPolicy(driver);
//        needHelpPage = new NeedHelpPage(driver);
//        actions = new Actions(driver);
//        jsExecutor = (JavascriptExecutor) driver;
//        signInPage = new SignInPage(driver);
//        homepage = new HomePage(driver);
    }

    public boolean verifyButtonColor() throws InterruptedException {
        // call all buttons from all pages and send for color change during hover, if that button is interactive

        // Page > Elements > get one > add into list

        // Buttons to add :
        // Sign In
        // Next - SignIn(110)
        // Continue - SignIn(129)
        // Email Link to Sign In - SignIn(143)
        // Amazon Button
        // Facebook Button
        // Google
        // AppleID

        // Non-Interactive hyperlinks:
        // signInPage.signUpHyperlink()
        // commons.changeButton()
        // commons.resendButton()
        // commons.needHelpButton())

        List <WebElement> homepageButtons = Arrays.asList(
                signInPage.signInButton(),
                homepage.subscribeButton());

        List <WebElement> signInPageButtons = Arrays.asList(
                signInPage.nextButton(), // Same for 'SignIn' button which is under the 'Password' field
                signInPage.linkSignInButton(),
                signInPage.continueButton());
        // Buttons to add :
        // Amazon Button
        // Facebook Button
        // Google
        // AppleID

        List <WebElement> signUpPageButtons = Arrays.asList(
                signInPage.nextButton()
                // Buttons to add :
                // Amazon Button
                // Facebook Button
                // Google
                // AppleID

        );

        List <WebElement> commonButtons = Arrays.asList(
                commons.contactUsButton()
        );
        return false;
    }

    public boolean buttonColorChange(WebElement button) {
        System.out.println("buttonColorChange method");
        String initialColor = button.getCssValue("background-color");
        System.out.println("Button Color before hovering: " + initialColor);
        Actions actions = new Actions(driver);
        actions.moveToElement(button).perform();

        String hoverColor = button.getCssValue("background-color");
        System.out.println("Button Color after hovering: " + hoverColor);

        return !initialColor.equals(hoverColor);
    }

    public String blueButtonInitialColor(WebElement button) throws InterruptedException {
        System.out.println("Commons.verifyBlueButtonColor() Method");
//        buttonColor = (String) jsExecutor.executeScript("return window.getComputedStyle(document.querySelector('button[data-test-id=\"sign-in-btn\"]')).getPropertyValue('background-color')");
        System.out.println("Verifying Button Color");
        String buttonColor = button.getCssValue("background-color");
        System.out.println(buttonColor);
        Assert.assertTrue(buttonColor.contains("rgb(22, 109, 252)"));
        System.out.println("Button Color Verified");
        return buttonColor;
    }

    public boolean verifyGrayButtonInitialColor() throws InterruptedException {
        System.out.println("Commons.verifyGrayButtonInitialColor() Method");
        driver.wait(1000);
        buttonColor = (String) jsExecutor.executeScript("return window.getComputedStyle(document.querySelector('button[data-test-id='pml-btn']')).getPropertyValue('background-color')");
        System.out.println("Verifying Button Color");
        driver.wait(1000);
        return buttonColor.contains("rgb(255, 255, 255)");
    }

    public boolean verifyWhiteButtonColor(String actualButtonColor) throws InterruptedException {
        System.out.println("Commons.verifyWhiteButtonInitialColor() Method");
        boolean result = false;

        List<WebElement> buttons = Arrays.asList(
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--amazon']")))),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--facebook']")))),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--google']")))),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--apple']"))))
        );

        for(String button : pathsOfButtons) {
            buttonColor = (String) jsExecutor.executeScript("return window.getComputedStyle(document.querySelector('" + button + "')).getPropertyValue('background-color')");
            System.out.println("Verifying " + button + "Button Color");
            driver.wait(1000);
            Assert.assertTrue(buttonColor.contains("rgb(255, 255, 255)")); // verify .equals()
            driver.wait(1000);
            System.out.println("Verified " + button + "Button Color");
        }

        for(WebElement button : buttons) {
            if(buttonColor.equals(actualButtonColor) && buttonColorChange(button) && elementDimensionsAndPosition()){
                result = true;
            }
        } return result;
    }

    public boolean elementDimensionsAndPosition() throws InterruptedException {
        List<WebElement> elements = Arrays.asList(
//                signInPage.inputField(),
                signInPage.nextButton(),
                signInPage.linkSignInButton(),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@data-test-id='signin-header']")))),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--amazon']")))),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--facebook']")))),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--google']")))),
                wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-qa='auth--apple']"))))
        );

        for(WebElement element : elements) {
            driver.wait(1000);
            Assert.assertTrue(buttonColorChange(element));
            for (Map<String, Integer> actualMap : actualElementAttributes()) {
                boolean matchFound = false;
                for (Map<String, Integer> expectedMap : expectedAttributeData()) {
                    if (mapsMatch(expectedMap, actualMap)) {
                        matchFound = true;
                        break;
                    }
                }
                Assert.assertTrue(matchFound, "No matching expected attributes found for actual attributes: " + actualMap);
            }
            driver.wait(1000);
        } return true;
    }

    private static boolean mapsMatch(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1.size() != map2.size()) return false;
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (!Objects.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public List<Map<String, Integer>> expectedAttributeData() {
        Map<String, Integer> googleButtonAttribute = new HashMap<>();
        googleButtonAttribute.put("top", (int) 552.3958740234375);
        googleButtonAttribute.put("bottom", (int) 592.3958740234375);
        googleButtonAttribute.put("height", 40);
        googleButtonAttribute.put("width", 340);
        googleButtonAttribute.put("left", (int) 461.66668701171875);
        googleButtonAttribute.put("right", (int) 801.6666870117188);
        googleButtonAttribute.put("x", (int) 461.66668701171875);
        googleButtonAttribute.put("y", (int) 552.3958740234375);

        Map<String, Integer> amazonButtonAttribute = new HashMap<>();
        amazonButtonAttribute.put("top", (int) 456.3958435058594);
        amazonButtonAttribute.put("bottom", (int) 496.3958435058594);
        amazonButtonAttribute.put("height", 40);
        amazonButtonAttribute.put("width", 340);
        amazonButtonAttribute.put("left", (int) 461.66668701171875);
        amazonButtonAttribute.put("right", (int) 801.6666870117188);
        amazonButtonAttribute.put("x", (int) 461.66668701171875);
        amazonButtonAttribute.put("y", (int) 456.3958435058594);

        Map<String, Integer> facebookButtonAttribute = new HashMap<>();
        facebookButtonAttribute.put("top", (int) 456.3958435058594);
        facebookButtonAttribute.put("bottom", (int) 344.3958435058594);
        facebookButtonAttribute.put("height", 40);
        facebookButtonAttribute.put("width", 340);
        facebookButtonAttribute.put("left", (int) 461.66668701171875);
        facebookButtonAttribute.put("right", (int) 801.6666870117188);
        facebookButtonAttribute.put("x", (int) 461.66668701171875);
        facebookButtonAttribute.put("y", (int) 304.3958435058594);

        Map<String, Integer> appleButtonAttribute = new HashMap<>();
        appleButtonAttribute.put("top", (int) 300.3958435058594);
        appleButtonAttribute.put("bottom", (int) 340.3958435058594);
        appleButtonAttribute.put("height", 40);
        appleButtonAttribute.put("width", 340);
        appleButtonAttribute.put("left", (int) 461.66668701171875);
        appleButtonAttribute.put("right", (int) 801.6666870117188);
        appleButtonAttribute.put("x", (int) 461.66668701171875);
        appleButtonAttribute.put("y", (int) 300.3958435058594);

        Map<String, Integer> nextButtonAttribute = new HashMap<>();
        nextButtonAttribute.put("top", (int) 157.0625);
        nextButtonAttribute.put("bottom", (int) 197.0625);
        nextButtonAttribute.put("height", 40);
        nextButtonAttribute.put("width", 340);
        nextButtonAttribute.put("left", (int) 461.66668701171875);
        nextButtonAttribute.put("right", (int) 801.6666870117188);
        nextButtonAttribute.put("x", (int) 461.66668701171875);
        nextButtonAttribute.put("y", (int) 157.0625);

        Map<String, Integer> emailSignInLinkButtonAttribute = new HashMap<>();
        emailSignInLinkButtonAttribute.put("top", (int) 139.7291717529297);
        emailSignInLinkButtonAttribute.put("bottom", (int) 181.06250762939453);
        emailSignInLinkButtonAttribute.put("height", (int) 41.333335876464844);
        emailSignInLinkButtonAttribute.put("width", 340);
        emailSignInLinkButtonAttribute.put("left", (int) 461.66668701171875);
        emailSignInLinkButtonAttribute.put("right", (int) 801.6666870117188);
        emailSignInLinkButtonAttribute.put("x", (int) 461.66668701171875);
        emailSignInLinkButtonAttribute.put("y", (int) 139.7291717529297);

        Map<String, Integer> inputFieldAttribute = new HashMap<>();
        inputFieldAttribute.put("top", (int) 192.39584350585938);
        inputFieldAttribute.put("bottom", (int) 240.39584350585938);
        inputFieldAttribute.put("height", 48);
        inputFieldAttribute.put("width", (int) 294.66668701171875);
        inputFieldAttribute.put("left", (int) 506.3333435058594);
        inputFieldAttribute.put("right", (int) 801.0000305175781);
        inputFieldAttribute.put("x", (int) 506.3333435058594);
        inputFieldAttribute.put("y", (int) 192.39584350585938);

        return Arrays.asList(
                inputFieldAttribute,
                emailSignInLinkButtonAttribute,
                googleButtonAttribute,
                amazonButtonAttribute,
                facebookButtonAttribute,
                appleButtonAttribute,
                nextButtonAttribute
        );
    }

    public  List<Map<String, Integer>> actualElementAttributes() throws InterruptedException {
        List<String> buttonSelectors = new ArrayList<>(List.of(
                "input[id=\"username\"]",
                "button[dataqa=\"signup-btn\"]",
                "button[data-qa=\"auth--google\"]",
                "button[data-qa=\"auth--amazon\"]",
                "button[data-qa=\"auth--facebook']",
                "button[data-qa=\"auth--apple\"]"
        ));
        if(signInPage.linkSignInButton().isDisplayed()){buttonSelectors.add("button[data-test-id=\"pml-btn\"]");}

        List<Map<String, Integer>> buttonsAttributes = new ArrayList<>();

        for (String selector : buttonSelectors) {
            Map<String, Integer> attributes = new HashMap<>();
            attributes.put("top", (Integer) jsExecutor.executeScript("return document.querySelector(arguments[0]).getBoundingClientRect().top", selector));
            attributes.put("bottom", (Integer) jsExecutor.executeScript("return document.querySelector(arguments[0]).getBoundingClientRect().bottom", selector));
            attributes.put("left", (Integer) jsExecutor.executeScript("return document.querySelector(arguments[0]).getBoundingClientRect().left", selector));
            attributes.put("right", (Integer) jsExecutor.executeScript("return document.querySelector(arguments[0]).getBoundingClientRect().right", selector));
            attributes.put("height", (Integer) jsExecutor.executeScript("return document.querySelector(arguments[0]).getBoundingClientRect().height", selector));
            attributes.put("width", (Integer) jsExecutor.executeScript("return document.querySelector(arguments[0]).getBoundingClientRect().width", selector));
            attributes.put("x", (Integer) jsExecutor.executeScript("return document.querySelector(arguments[0]).getBoundingClientRect().x", selector));
            attributes.put("y", (Integer) jsExecutor.executeScript("return document.querySelector(arguments[0]).getBoundingClientRect().y", selector));

            buttonsAttributes.add(attributes);
        } return buttonsAttributes;
    }
}
