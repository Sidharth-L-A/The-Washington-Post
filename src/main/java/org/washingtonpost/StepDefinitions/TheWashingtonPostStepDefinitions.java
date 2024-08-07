package org.washingtonpost.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.washingtonpost.Pages.*;
import org.washingtonpost.Utilities.TestUtils;
import org.washingtonpost.Utilities.WebDrivers;
import java.io.IOException;

public class TheWashingtonPostStepDefinitions {

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage, googleSignInPage;
    TestUtils testUtils;
    Commons commons;
    PoliticsPage politicsPage;
    InvestigationsPage investigationsPage;
    ClimatePage climatePage;
    WellBeingPage wellBeingPage;
    TechPage techPage;
    WorldPage worldPage;
    DCMdVaPage dCMdVaPage;
    SportsPage sportsPage;
    OpinionsPage opinionsPage;
    StylePage stylePage;
    SearchMorePage searchMorePage;
    NewsAlertsPage newsAlertsPage;
    EmailLinkVerificationPage signInWithEmailPage, signInWithGooglePage, signInWithApplePage, signInWithAmazonPage, signInWithFacebookPage;

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
        politicsPage = new PoliticsPage(driver);
        investigationsPage = new InvestigationsPage(driver);
        climatePage = new ClimatePage(driver);
        wellBeingPage = new WellBeingPage(driver);
        techPage = new TechPage(driver);
        worldPage = new WorldPage(driver);
        dCMdVaPage = new DCMdVaPage(driver);
        sportsPage = new SportsPage(driver);
        politicsPage = new PoliticsPage (driver);
        opinionsPage = new OpinionsPage(driver);
        stylePage = new StylePage(driver);
        searchMorePage = new SearchMorePage(driver);
        newsAlertsPage = new NewsAlertsPage(driver);
        signInWithAmazonPage = new EmailLinkVerificationPage(driver);
        signInWithFacebookPage = new EmailLinkVerificationPage(driver);
    }

    @Given("the user navigates to {string}")
    public void userTypesInTheSearchBar(String URL) {
        System.out.println("userTypesInTheSearchBar Method");
        Assert.assertTrue(commons.googleSearch(URL));
    }

    @Then("User is on the {string} Page")
    public void userIsOnTargetpage(String pageName) {
        System.out.println("userIsOnTargetpage Method");
        switch (pageName) {
            case "Home" -> {
                Assert.assertTrue(homePage.verifyUserIsInHomePage());
                System.out.println("<--- The User is in Homepage --->");
            }
            case "SearchMorePage" -> {
                System.out.println("userIsInSearchMorePage Method");
                Assert.assertTrue(searchMorePage.verifyUserIsInSearchMorePage());
                System.out.println("<--- The User is in SearchMore Page --->");
            }
            case "NewsAlertsPage" -> {
                System.out.println("userIsInNewsAlertsPage Method");
                Assert.assertTrue(newsAlertsPage.verifyUserIsInNewsAlertsPage());
                System.out.println("<--- The User is in NewsAlerts Page --->");
            }
            case "Politics" -> {
                Assert.assertTrue(politicsPage.verifyUserIsInPoliticsPage());
                System.out.println("<--- The User is in Politics Page --->");
            }
            case "Opinions" -> {
                System.out.println("userIsInOpinionspage Method");
                Assert.assertTrue(opinionsPage.verifyUserIsInOpinionsPage());
                System.out.println("<--- The User is in Opinions Page --->");
            }
            case "Style" -> {
                System.out.println("userIsInStylepage Method");
                Assert.assertTrue(stylePage.verifyUserIsInStylePage());
                System.out.println("<--- The User is in Style Page --->");
            }
            case "Investigations" -> {
                Assert.assertTrue(investigationsPage.verifyUserIsInInvestigationsPage());
                System.out.println("<--- The User is in Investigations page --->");
            }
            case "Climate" -> {
                Assert.assertTrue(climatePage.verifyUserIsInClimatePage());
                System.out.println("<--- The User is in Climate page --->");
            }
            case "Well+Being" -> {
                Assert.assertTrue(wellBeingPage.verifyUserIsInWellBeingPage());
                System.out.println("<--- The User is in Well+Being page --->");
            }
            case "Tech" -> {
                Assert.assertTrue(techPage.verifyUserIsInTechPage());
                System.out.println("<--- The User is in Tech page --->");
            }
            case "World" -> {
                Assert.assertTrue(worldPage.verifyUserIsInWorldPage());
                System.out.println("<--- The User is in World page --->");
            }
            case "D.C., Md. & Va." -> {
                Assert.assertTrue(dCMdVaPage.verifyUserIsInDCMdVaPage());
                System.out.println("<--- The User is in DCMdVa page --->");
            }
            case "Sports" -> {
                Assert.assertTrue(sportsPage.verifyUserIsInSportsPage());
                System.out.println("<--- The User is in Sports page --->");
            }
        }
    }

    @When("User hits {string} key")
    public void userHitsKey() {
        System.out.println("userHitsKey Method");
    }

//    @Then("User is on the {string} Page")
//    public void userIsInWashingtonHomepage() {
//        System.out.println("userIsInWashingtonHomepage Method");
//        Assert.assertTrue(homePage.userIsInWashingtonHomepage());
//        System.out.println("<--- The User is in Homepage --->");
//    }

//    @Then("The Washington Post homepage is opened")
//    public void theWashingtonPostHomepageIsOpened() {
//        System.out.println("theWashingtonPostHomepageIsOpened Method");
//        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='__next']/div/div[3]/div/div/a/span")).isDisplayed());
//        System.out.println("<--- The Washington Post Homepage Opened --->");
//    }

    @When("User clicks on the {string} button")
    public void userClicksOnButton(String button) {
        System.out.println("userClicksOnButton Method");
        switch (button) {
            case "SignIn" -> {
                signInPage.signInButton().click();
                System.out.println("<--- Clicked on 'Sign In' Button --->");
            }
            case "SignUp" -> {
                signInPage.signUpButton().click();
                System.out.println("<--- Clicked on 'Sign Up' Button --->");
            }
            case "Next" -> {
                signInPage.nextButton().click();
                System.out.println("<--- Clicked on 'Next' Button --->");
            }
            case "Continue" -> {
                signInPage.continueButton().click();
                System.out.println("<--- Clicked on 'Continue' Button --->");
            }
            case "Email a sign in link" -> {
                signInPage.linkSignInButton().click();
                System.out.println("<--- Clicked on 'Email a sign in link' Button --->");
            }
            case "Google" -> {
                signInPage.signInWithGoogleButton().click();
                System.out.println("<--- Clicked on 'Sign in with Google' Button --->");
            }
            case "Google sign in next button" -> {
                signInPage.signinwithGoogleNextButton().click();
                System.out.println("<--- Clicked on 'sign in with Google Next' Button --->");
            }
            case "Google sign in password next button" -> {
                signInPage.signinwithGooglePasswordNextButton().click();
                System.out.println("<--- Clicked on 'sign in with Google password Next' Button --->");
            }
            case "Apple" -> {
                signInPage.signInWithAppleButton().click();
                System.out.println("<--- Clicked on 'Sign in with Apple' Button --->");
            }
            case "Apple Sign In Arrow" -> {
                signInPage.signInWithAppleSignInArrowButton().click();
                System.out.println("<--- Clicked on 'Sign in with Apple Sign In Arrow' Button --->");
            }
            case "Apple Password Arrow" -> {
                signInPage.signInWithApplePasswordArrowButton().click();
                System.out.println("<--- Clicked on 'Sign in with Apple Password Arrow' Button --->");
            }
            case "AppleID Continue Button" -> {
                signInPage.signInWithAppleIDContinueButton().click();
                System.out.println("<--- Clicked on 'Sign in with AppleID Continue' Button --->");
            }
            case "Back" -> {
                commons.backButton();
                System.out.println("<--- Clicked on 'Navigate Back' Button --->");
            }
            case null, default -> {
                homePage.allButtons(button).click();
                System.out.println("<--- Clicked on 'SearchMore' Button --->");
            }
        }
    }

    @And("User enters {string}")
    public void userEnters(String emailPassword) throws InterruptedException {
        System.out.println("userEnters Method");
        Assert.assertTrue(signInPage.enterEmailIdPassword(emailPassword));
        System.out.println("<--- Email ID & Password Entered successfully --->");
    }

    @And("User enters {string}")
    public void googleSignInEnters(String emailPassword) throws InterruptedException {
        System.out.println("googleSignInEnters Method");
        Assert.assertTrue(signInPage.enterGoogleEmail(emailPassword));
        System.out.println("<--- Email Google ID & Password  Entered successfully --->");
    }
  
    @Then("User is signed in to The Washington Post {string}")
    public void userSignedInIntoTheWashingtonPost(String accountName) {
        System.out.println("userSignedInIntoTheWashingtonPost Method");
        Assert.assertTrue(signInPage.verifySignIn(accountName));
        System.out.println("<--- Sign In Successful --->");
    }
  
    @And("User enters {string}")
    public void FacebooksigninEnters(String emailPassword) throws InterruptedException {
        System.out.println("FacebooksigninEnters Method");
        Assert.assertTrue(signInPage.enterFacebookEmail(emailPassword));
        System.out.println("<--- Email Facebook ID  Entered successfully --->");
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

    @Then("User Account name is Displayed {string}")
    public void userAccountNameIsDisplayed(String accountName) throws InterruptedException {
        System.out.println("userAccountNameIsDisplayed Method");
        Assert.assertTrue(homePage.verifyAccountNamePostSignin(accountName));
        System.out.println("<--- Sign In Successful --->");
    }

    @Then("User should be on the Sign in with Apple Page")
    public void userShouldBeOnTheSigninwithApplePage() throws InterruptedException {
        System.out.println("userShouldBeOnTheSigninwithApplePage Method");
        Assert.assertTrue(signInWithApplePage.SigninwithApple());
        System.out.println("<--- User is in Apple sign in page --->");
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

    @Then("User should be on the six digit Verification Facebook Page")
    public void userShouldBeOnThe6digitVerificationFacebookPage() throws InterruptedException {
        System.out.println("userShouldBeOnThe 6 digit Verification Facebook Page Method");
        Assert.assertTrue(signInWithEmailPage.verifySixDigitVerificationPage());
        System.out.println("<--- User is prompted to check inbox for a Sign-in link --->");
    }

    @And("User enters {string} in AmazonID")
    public void userEntersAmazonEmailIdPassword(String emailIdPassword) throws InterruptedException {
        System.out.println("userEnters Method");
        Assert.assertTrue(signInPage.enterAmazonEmailId(emailIdPassword));
        System.out.println("<--- Email ID Entered successfully --->");
    }

    @And("User enters {string} in FacebookID")
    public void userEntersFacebookEmailIdPassword(String emailIdPassword) throws InterruptedException {
        System.out.println("userEnters Method");
        Assert.assertTrue(signInPage.enterFacebookEmailId(emailIdPassword));
        System.out.println("<--- Email ID Entered successfully --->");
        }

    @And("User enters {string} in Google")
    public void userEntersGoogleEmailIdPassword(String emailIdPassword) throws InterruptedException {
        System.out.println("userEnters Method");
        Assert.assertTrue(signInPage.enterGoogleEmailId(emailIdPassword));
        System.out.println("<--- Email ID Entered successfully --->");
    }

    @And("User enters {string} in AppleID")
    public void userEntersAppleEmailIdPassword(String emailIdPassword) throws InterruptedException {
        System.out.println("userEnters Method");
        Assert.assertTrue(signInPage.enterAppleEmailId(emailIdPassword));
        System.out.println("<--- Email ID Entered successfully --->");

    }
}
