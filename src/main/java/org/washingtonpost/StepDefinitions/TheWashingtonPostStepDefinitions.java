package org.washingtonpost.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
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
    SignInPage signInPage;
    TestUtils testUtils;
    Commons commons;
    EmailLinkVerificationPage signInWithEmailPage, signInWithAmazonPage, signInWithFacebookPage;

    public TheWashingtonPostStepDefinitions() {
        WebDrivers webDrivers = new WebDrivers();
        driver = webDrivers.chromeBrowserDriverInit();
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        testUtils = new TestUtils();
        commons = new Commons(driver);
        signInWithEmailPage = new EmailLinkVerificationPage(driver);
        signInWithAmazonPage = new EmailLinkVerificationPage(driver);
        signInWithFacebookPage = new EmailLinkVerificationPage(driver);
    }

    @Given("the user navigates to {string}")
    public void userTypesInTheSearchBar(String URL) {
        System.out.println("userTypesInTheSearchBar Method");
        Assert.assertTrue(commons.googleSearch(URL));
    }

    @Then("User is on the {string} Page")
    public void userIsInHomepage(String pageName) {
        System.out.println("userIsInHomepage Method");
        Assert.assertTrue(homePage.verifyUserIsInHomePage());
        System.out.println("<--- The User is in Homepage --->");
    }

    @When("User hits {string} key")
    public void userHitsKey() {
        System.out.println("userHitsKey Method");
    }

    @Then("The Washington Post homepage is opened")
    public void theWashingtonPostHomepageIsOpened() {
        System.out.println("theWashingtonPostHomepageIsOpened Method");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='__next']/div/div[3]/div/div/a/span")).isDisplayed());
        System.out.println("<--- The Washington Post Homepage Opened --->");
    }

    @When("User clicks on the {string} button")
    public void userClicksOnButton(String button) {
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
        } else if (Objects.equals(button, "")) {
            signInPage.continueButton().click();
            System.out.println("<--- Clicked on 'Continue' Button --->");
        } else if (Objects.equals(button, "Email a sign in link")) {
            signInPage.linkSignInButton().click();
            System.out.println("<--- Clicked on 'Email a sign in link' Button --->");
        } else if (Objects.equals(button, "Amazon")) {
            signInPage.signinwithAmazonButton().click();
            System.out.println("<--- Clicked on 'sign in with Amazon' Button --->");
        } else if (Objects.equals(button, "Amazon sign in continue button")) {
            signInPage.signinwithAmazonContinueButton().click();
            System.out.println("<--- Clicked on 'sign in with Amazon Continue' Button --->");
        } else if (Objects.equals(button, "Amazon Password sign in  button")) {
            signInPage.signinwithAmazoPasswordButton().click();
            System.out.println("<--- Clicked on 'sign in with Amazon Password' Button --->");
        } else if (Objects.equals(button, "Facebook")) {
            signInPage.signinwithFacebookButton().click();
            System.out.println("<--- Clicked on 'sign in with Facebook' Button --->");
        } else if (Objects.equals(button, "FacebookLogInButton")) {
            signInPage.signinwithFacebookLogInButton().click();
            System.out.println("<--- Clicked on 'sign in with FacebookLogIn' Button --->");
        }else if (Objects.equals(button, "Facebook6digitcodeButton")) {
            signInPage.SigninwithFacebook6digitcodeButton().click();
            System.out.println("<--- Clicked on 'sign in with Facebook 6 digit code ' Button --->");
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
    public void amazonsigninEnters(String emailId) throws InterruptedException {
        System.out.println("amazonsigninEnters Method");
        Assert.assertTrue(signInPage.enterAmazonEmail(emailId));
        System.out.println("<--- Email Amazon ID  Entered successfully --->");
    }


    @And("User enters {string}")
    public void FacebooksigninEnters(String emailPassword) throws InterruptedException {
        System.out.println("FacebooksigninEnters Method");
        Assert.assertTrue(signInPage.enterFacebookEmail(emailPassword));
        System.out.println("<--- Email Facebook ID  Entered successfully --->");
    }


    @And("User enters {string}")
    public void FacebooksigninEntersInvalidPassword(String emailinvalidPassword) throws InterruptedException {
        System.out.println("FacebooksigninEntersInvalidPassword Method");
        Assert.assertTrue(signInPage.enterFacebookEmailInvalidPassword(emailinvalidPassword));
        System.out.println("<--- Email Facebook ID  Entered successfully --->");
    }


    @Then("User is signed in to The Washington Post")
    public void userSignedInIntoTheWashingtonPost() {
        System.out.println("userSignedInIntoTheWashingtonPost Method");
        Assert.assertTrue(signInPage.verifySignIn());
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



    @Then("User should be able to access all links")
    public void userShouldBeAbleToAccessAllLinks() throws InterruptedException {
        System.out.println("userShouldBeAbleToAccessAllLinks Method");
        Assert.assertTrue(signInWithEmailPage.resendNotificationVerify());
        System.out.println("<--- User is able to access all links from the Link Verification Page --->");
    }

/*    @Then("Help for Sign-in is prompted {string}")
    public void helpForSignInIsPrompted(String emailId) throws InterruptedException {
        System.out.println("helpForSignInIsPrompted Method");
        Assert.assertTrue(signInPage.needHelpToSignInLink(emailId));
        System.out.println("<--- User received a hyperlink to Sign-in --->");
    }*/

  /*  @Then("User should be on the Amazon signIn Page")
    public void userShouldBeOnTheAmazonSignInPage() throws InterruptedException {
        System.out.println("userShouldBeOnTheSigninwithAmazonPage Method");
        Assert.assertTrue(signInWithAmazonPage.SigninwithAmazon());
        System.out.println("<--- User is in Amazon sign in page --->");
    }*/

    @Then("User should be on the Amazon signIn Page")
    public void userShouldBeOnTheAmazonSignInPage() throws InterruptedException {
        System.out.println("userShouldBeOnTheSigninwithAmazonPage Method");
        Assert.assertTrue(signInWithAmazonPage.SigninwithAmazon());
        System.out.println("<--- User is in Amazon sign in page --->");
    }

    @Then("User should be on the Facebook signIn Page")
    public void userShouldBeOnTheFacebookSignInPage() throws InterruptedException {
        System.out.println("userShouldBeOnTheSigninwithFacebookPage Method");
        Assert.assertTrue(signInWithFacebookPage.SigninwithFacebook());
        System.out.println("<--- User is in Facebook sign in page --->");
    }


    @And("Error message is displayed")
    public void verifyErrorMessageAmazonID() throws InterruptedException {
        System.out.println("verifyErrorMessageAmazonID Method");
        Assert.assertTrue(signInPage.verifyAmazonIDEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed")
    public void verifyErrorMessageFacebookID() throws InterruptedException {
        System.out.println("verifyErrorMessageFacebookID Method");
        Assert.assertTrue(signInPage.verifyFacebookIDEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed")
    public void verifyErrorMessageAmazonIDPassword() throws InterruptedException {
        System.out.println("verifyErrorMessageAmazonIDPassword Method");
        Assert.assertTrue(signInPage.verifyAmazonIDPasswordEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed")
    public void verifyErrorMessageFacebookIDPassword() throws InterruptedException {
        System.out.println("verifyErrorMessageFacebookIDPassword Method");
        Assert.assertTrue(signInPage.verifyFacebookIDPasswordEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @Then("User should be on the Link Verification Page")
    public void userShouldBeOnTheLinkVerificationPage() throws InterruptedException {
        System.out.println("userShouldBeOnTheLinkVerificationPage Method");
        Assert.assertTrue(signInWithEmailPage.linkSentNote());
        System.out.println("<--- User is prompted to check inbox for a Sign-in link --->");
    }

    @Then("User should be on the six digit Verification Facebook Page")
    public void userShouldBeOnThe6digitVerificationFacebookPage() throws InterruptedException {
        System.out.println("userShouldBeOnThe 6 digit Verification Facebook Page Method");
        Assert.assertTrue(signInWithEmailPage.verifySixDigitVerificationPage());
        System.out.println("<--- User is prompted to check inbox for a Sign-in link --->");
    }
}





