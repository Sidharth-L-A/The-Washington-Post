package org.washingtonpost.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.washingtonpost.Pages.Commons;
import org.washingtonpost.Pages.HomePage;
import org.washingtonpost.Pages.SignInPage;
import org.washingtonpost.Pages.EmailLinkVerificationPage;
import org.washingtonpost.Utilities.TestUtils;
import org.washingtonpost.Utilities.WebDrivers;
import java.io.IOException;
import java.util.Objects;

public class TheWashingtonPostStepDefinitions {

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage,googleSignInPage;
    TestUtils testUtils;
    Commons commons;
    EmailLinkVerificationPage signInWithEmailPage, signInWithGooglePage, signInWithApplePage;


    public TheWashingtonPostStepDefinitions() {
        WebDrivers webDrivers = new WebDrivers();
        driver = webDrivers.chromeBrowserDriverInit();
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        googleSignInPage = new SignInPage(driver);
        testUtils = new TestUtils();
        commons = new Commons(driver);
        signInWithEmailPage = new EmailLinkVerificationPage(driver);
        signInWithGooglePage = new EmailLinkVerificationPage(driver);
        signInWithApplePage = new EmailLinkVerificationPage(driver);
    }

    @Given("the user navigates to {string}")
    public void userTypesInTheSearchBar(String URL) {
        System.out.println("userTypesInTheSearchBar Method");
        Assert.assertTrue(commons.googleSearch(URL));
    }

    @Then("User is on the {string} Page")
    public void userIsInHomepage() {
        System.out.println("userIsInHomepage Method");
        Assert.assertTrue(homePage.verifyUserIsInHomePage());
        System.out.println("<--- The User is in Homepage --->");
    }

//    @Then("User is on the {string} Page")
//    public void userIsInWashingtonHomepage() {
//        System.out.println("userIsInWashingtonHomepage Method");
//        Assert.assertTrue(homePage.userIsInWashingtonHomepage());
//        System.out.println("<--- The User is in Homepage --->");
//    }

    @When("User hits {string} key")
    public void userHitsKey() {
        System.out.println("userHitsKey Method");
    }

//    @Then("The Washington Post homepage is opened")
//    public void theWashingtonPostHomepageIsOpened() {
//        System.out.println("theWashingtonPostHomepageIsOpened Method");
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='__next']/div/div[3]/div/div/a/span")).isDisplayed());
//        System.out.println("<--- The Washington Post Homepage Opened --->");
//    }

    @When("User clicks on the {string} button")
    public void userClicksOnButton(String button)  {
        System.out.println("userClicksOnButton Method");

        if (Objects.equals(button, "SignIn")) {
            signInPage.signInButton().click();
            System.out.println("<--- Clicked on 'Sign In' Button --->");
        } else if (Objects.equals(button, "SignUp")) {
            signInPage.signUpButton().click();
            System.out.println("<--- Clicked on 'Sign Up' Button --->");
        } else if (Objects.equals(button, "Next")) {
            signInPage.nextButton().click();
            System.out.println("<--- Clicked on 'Next' Button --->");
        } else if (Objects.equals(button, "Continue")) {
            signInPage.continueButton().click();
            System.out.println("<--- Clicked on 'Continue' Button --->");
        } else if (Objects.equals(button, "Email a sign in link")) {
            signInPage.linkSignInButton().click();
            System.out.println("<--- Clicked on 'Email a sign in link' Button --->");
        } else if (Objects.equals(button, "Google")) {
            signInPage.signInWithGoogleButton().click();
            System.out.println("<--- Clicked on 'Sign in with Google' Button --->");
        } else if (Objects.equals(button, "Google sign in next button")) {
            signInPage.signinwithGoogleNextButton().click();
            System.out.println("<--- Clicked on 'sign in with Google Next' Button --->");
        } else if (Objects.equals(button, "Google sign in password next button")) {
            signInPage.signinwithGooglePasswordNextButton().click();
            System.out.println("<--- Clicked on 'sign in with Google password Next' Button --->");
        } else if (Objects.equals(button, "Apple")) {
            signInPage.signInWithAppleButton().click();
            System.out.println("<--- Clicked on 'Sign in with Apple' Button --->");
        } else if (Objects.equals(button, "Apple Sign In Arrow")) {
            signInPage.signInWithAppleSignInArrowButton().click();
            System.out.println("<--- Clicked on 'Sign in with Apple Sign In Arrow' Button --->");
        }else if (Objects.equals(button, "Apple Password Arrow")) {
            signInPage.signInWithApplePasswordArrowButton().click();
            System.out.println("<--- Clicked on 'Sign in with Apple Password Arrow' Button --->");
        }else if (Objects.equals(button, "AppleID Continue Button")) {
            signInPage.signInWithAppleIDContinueButton().click();
            System.out.println("<--- Clicked on 'Sign in with AppleID Continue' Button --->");
        }

    }
    @And("User enters {string}")
    public void userEnters(String emailPassword) throws InterruptedException {
        System.out.println("userEnters Method");
        // fails here as we did not receive a mock account's Email ID & Password
        Assert.assertTrue(signInPage.enterEmailIdPassword(emailPassword));
        System.out.println("<--- Email ID & Password Entered successfully --->");
    }

    @And("User enters {string}")
    public void GooglesigninEnters(String emailPassword) throws InterruptedException {
        System.out.println("GooglesigninEnters Method");
        Assert.assertTrue(signInPage.enterGoogleEmail(emailPassword));
        System.out.println("<--- Email Google ID & Password  Entered successfully --->");
    }
    @And("User enters {string}")
    public void ApplesigninEnters(String emailPassword) throws InterruptedException {
        System.out.println("ApplesigninEnters Method");
        Assert.assertTrue(signInPage.enterAppleEmail(emailPassword));
        System.out.println("<--- Email Apple ID & Password  Entered successfully --->");
    }

    @Then("User is signed in to The Washington Post {string}")
    public void userSignedInIntoTheWashingtonPost(String accountName) {
        System.out.println("userSignedInIntoTheWashingtonPost Method");
        Assert.assertTrue(signInPage.verifySignIn(accountName));
        System.out.println("<--- Sign In Successful --->");
    }

    @And("User clicks on the {string} checkbox")
    public void userClicksOnCheckBox(String checkboxIntention) {
        System.out.println("userClicksOnCheckBox Method");
        Assert.assertTrue(signInPage.verifyCheckBox(checkboxIntention));
        System.out.println("<--- Check Box checked --->");
    }

    @Then("User should be able to change the Email ID before Sign-Up")
    public void userEditsTheIncorrectEmailIDWith() throws InterruptedException {
        System.out.println("userEditsTheIncorrectEmailIDWith Method");
        Assert.assertTrue(signInPage.editEmailId());
        System.out.println("User can Sign-Up with another Email ID");
    }

    @Then("User should be on the Welcome Page")
    public void userIsInWelcomePage() {
        System.out.println("userIsInWelcomePage Method");
        Assert.assertTrue(signInPage.checkWelcomeNote());
        System.out.println("<--- User received a Welcome note! --->");
    }

    @And("Internet Connection is {string}")
    public void internetConnectivity(String state) throws IOException {
        System.out.println("internetConnectivity Method");
        Assert.assertTrue(testUtils.wifiOnOff(state));
    }

    @Then("The Site is Reloaded")
    public void reloadSite() {
        System.out.println("reloadSite Method");
        Assert.assertTrue(commons.reloadSite());
        System.out.println("Site reloaded");
    }

    @And("Error message is displayed")
    public void verifyErrorMessage() throws InterruptedException {
        System.out.println("verifyErrorMessage Method");
        Assert.assertTrue(signInPage.verifyEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed")
    public void verifyErrorMessageGoogleID() throws InterruptedException {
        System.out.println("verifyErrorMessageGoogleID Method");
        Assert.assertTrue(signInPage.verifyGoogleIDEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed")
    public void verifyErrorMessageGoogleIDPassword() throws InterruptedException {
        System.out.println("verifyErrorMessageGoogleIDPassword Method");
        Assert.assertTrue(signInPage.verifyGoogleIDPasswordEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed")
    public void verifyErrorMessageAppleIDPassword() throws InterruptedException {
        System.out.println("verifyErrorMessageAppleIDPassword Method");
        Assert.assertTrue(signInPage.verifyAppleIDPasswordEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed")
    public void verifyErrorMessageAppleID() throws InterruptedException {
        System.out.println("verifyErrorMessageAppleID Method");
        Assert.assertTrue(signInPage.verifyAppleIDEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @Then("User should be on the Link Verification Page")
    public void userShouldBeOnTheLinkVerificationPage() throws InterruptedException {
        System.out.println("userShouldBeOnTheLinkVerificationPage Method");
        Assert.assertTrue(signInWithEmailPage.linkSentNote());
        System.out.println("<--- User is prompted to check inbox for a Sign-in link --->");

    }

    @Then("User should be on the Sign in with Google Page")
    public void userShouldBeOnTheSigninwithGooglePage() throws InterruptedException {
        System.out.println("userShouldBeOnTheSigninwithGooglePage Method");
        Assert.assertTrue(signInWithGooglePage.SigninwithGoogle());
        System.out.println("<--- User is in Google sign in page --->");
    }

    @Then("User should be on the Sign in with Google Page")
    public void userShouldBeOnTheSigninwithGooglePasswordPage() throws InterruptedException {
        System.out.println("userShouldBeOnTheSigninwithGooglePasswordPage Method");
        Assert.assertTrue(signInWithGooglePage.SigninwithGooglePasswordPage());
        System.out.println("<--- User is in Google password page --->");
    }

    @Then("User should be able to access all links")
    public void userShouldBeAbleToAccessAllLinks() throws InterruptedException {
        System.out.println("userShouldBeAbleToAccessAllLinks Method");
        Assert.assertTrue(signInWithGooglePage.resendNotificationVerify());
        System.out.println("<--- User is able to access all links from the Link Verification Page --->");
    }

    @Then("Help for Sign-in is prompted {string}")
    public void helpForSignInIsPrompted(String emailId) throws InterruptedException {
        System.out.println("helpForSignInIsPrompted Method");
        Assert.assertTrue(signInPage.needHelpToSignInLink(emailId));
        System.out.println("<--- User received a hyperlink to Sign-in --->");
    }

    @Then("User Account name is Displayed {string}")
    public void userAccountNameIsDisplayed(String accountName) throws InterruptedException {
        System.out.println("userSignedInIntoTheWashingtonPost Method");
        Assert.assertTrue(homePage.verifyAccountNamePostSignin(accountName));
        System.out.println("<--- Sign In Successful --->");
    }

    @Then("User should be on the Sign in with Apple Page")
    public void userShouldBeOnTheSigninwithApplePage() throws InterruptedException {
        System.out.println("userShouldBeOnTheSigninwithApplePage Method");
        Assert.assertTrue(signInWithApplePage.SigninwithApple());
        System.out.println("<--- User is in Apple sign in page --->");
    }

    @Then("User should be on the the Sign in with Apple Page")
    public void userShouldBeOnTheTheSignInWithApplePage() {
    }
}