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
    WebDrivers webDrivers = new WebDrivers();
    WebDriver driver = webDrivers.chromeBrowserDriverInit();

    @Given("the user navigates to {string}")
    public void userTypesInTheSearchBar(String URL) {
        System.out.println("userTypesInTheSearchBar Method");
        Commons commons = new Commons(driver);
        Assert.assertTrue(commons.googleSearch(URL));
    }

    @Then("User is on the {string} Page")
    public void userIsOnTargetPage(String pageName) throws InterruptedException {
        System.out.println("userIsOnTargetPage Method");

        switch (pageName) {
            case "Home" -> {
                HomePage homePage = new HomePage(driver);
                Assert.assertTrue(homePage.verifyUserIsInHomePage());
                System.out.println("<--- The User is in Homepage --->");
            }
            case "SignIn" -> {
                SignInPage signInPage = new SignInPage(driver);
                Assert.assertTrue(signInPage.verifySignInPage());
                System.out.println("<--- The User is in Homepage --->");
            }
            case "Search More" -> {
                SearchMorePage searchMorePage = new SearchMorePage(driver);
                Assert.assertTrue(searchMorePage.verifyUserIsInSearchMorePage());
                System.out.println("<--- The User is in SearchMore Page --->");
            }
            case "News Alerts" -> {
                NewsAlertsPage newsAlertsPage = new NewsAlertsPage(driver);
                Assert.assertTrue(newsAlertsPage.verifyUserIsInNewsAlertsPage());
                System.out.println("<--- The User is in NewsAlerts Page --->");
            }
            case "Politics" -> {
                PoliticsPage politicsPage = new PoliticsPage(driver);
                Assert.assertTrue(politicsPage.verifyUserIsInPoliticsPage());
                System.out.println("<--- The User is in Politics Page --->");
            }
            case "Opinions" -> {
                OpinionsPage opinionsPage = new OpinionsPage(driver);
                Assert.assertTrue(opinionsPage.verifyUserIsInOpinionsPage());
                System.out.println("<--- The User is in Opinions Page --->");
            }
            case "Style" -> {
                StylePage stylePage = new StylePage(driver);
                Assert.assertTrue(stylePage.verifyUserIsInStylePage());
                System.out.println("<--- The User is in Style Page --->");
            }
            case "Investigations" -> {
                InvestigationsPage investigationsPage = new InvestigationsPage(driver);
                Assert.assertTrue(investigationsPage.verifyUserIsInInvestigationsPage());
                System.out.println("<--- The User is in Investigations page --->");
            }
            case "Climate" -> {
                ClimatePage climatePage = new ClimatePage(driver);
                Assert.assertTrue(climatePage.verifyUserIsInClimatePage());
                System.out.println("<--- The User is in Climate page --->");
            }
            case "Well+Being" -> {
                WellBeingPage wellBeingPage = new WellBeingPage(driver);
                Assert.assertTrue(wellBeingPage.verifyUserIsInWellBeingPage());
                System.out.println("<--- The User is in Well+Being page --->");
            }
            case "Tech" -> {
                TechPage techPage = new TechPage(driver);
                Assert.assertTrue(techPage.verifyUserIsInTechPage());
                System.out.println("<--- The User is in Tech page --->");
            }
            case "World" -> {
                WorldPage worldPage = new WorldPage(driver);
                Assert.assertTrue(worldPage.verifyUserIsInWorldPage());
                System.out.println("<--- The User is in World page --->");
            }
            case "D.C., Md. & Va." -> {
                DCMdVaPage dCMdVaPage = new DCMdVaPage(driver);
                Assert.assertTrue(dCMdVaPage.verifyUserIsInDCMdVaPage());
                System.out.println("<--- The User is in DCMdVa page --->");
            }
            case "Sports" -> {
                SportsPage sportsPage = new SportsPage(driver);
                Assert.assertTrue(sportsPage.verifyUserIsInSportsPage());
                System.out.println("<--- The User is in Sports page --->");
            }
            case "Subscribe" -> {
                SubscribePage subscribePage = new SubscribePage(driver);
                Assert.assertTrue(subscribePage.verifyUserIsInSubscribePage());
                System.out.println("<--- The User is in Sports page --->");
            }
            case "Apple Two Factor Authentication" -> {
                EmailLinkVerificationPage emailLinkVerificationPage = new EmailLinkVerificationPage(driver);
                Assert.assertTrue(emailLinkVerificationPage.appleTwoFactorAuth());
                System.out.println("<--- The User is in Apple Two Factor Authentication page --->");
            }
//            id="trust-browser-1723472625802-2" - Trust Browser
//            ($click)="clicked('actionClicked')" - Continue



        }
    }

    @When("User clicks on the {string} button")
    public void userClicksOnButton(String button) throws InterruptedException {
        System.out.println("userClicksOnButton Method");
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);
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
            case "Google Next" -> {
                signInPage.googleNextButton().click();
                System.out.println("<--- Clicked on 'Next' Button --->");
            }
            case "Continue" -> {
                signInPage.continueButton().click();
                System.out.println("<--- Clicked on 'Continue' Button --->");
            }
            case "Apple Sign In Continue" -> {
                signInPage.appleSignInContinueButton().click();
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
                signInPage.signInWithGoogleNextButton().click();
                System.out.println("<--- Clicked on 'sign in with Google Next' Button --->");
            }
            case "Google sign in password next button" -> {
                signInPage.signInWithGooglePasswordNextButton().click();
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
            case "AppleID Continue Button" -> {
                signInPage.signInWithAppleIDContinueButton().click();
                System.out.println("<--- Clicked on 'Sign in with AppleID Continue' Button --->");
            }
            case "Back" -> {
                Commons commons = new Commons(driver);
                commons.backButton();
                System.out.println("<--- Clicked on 'Navigate Back' Button --->");
            }
            case "Next slide"-> {
                homePage.nextSlideButton(button).click();
                System.out.println("<--- Clicked on 'SearchMore' Button --->");
            }
            case "Previous Slide" -> {
                homePage.previousSlideButton(button).click();
                System.out.println("<--- Clicked on 'SearchMore' Button --->");
            }
            case null, default -> {
                homePage.allButtons(button).click();
                System.out.println("<--- Clicked on 'SearchMore' Button --->");
            }
        }
    }

    @And("User enters {string} in the {string} field")
    public void userEnters(String emailPassword, String fieldType) throws InterruptedException {
        System.out.println("userEnters Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.enterEmailIdPassword(emailPassword, fieldType));
        System.out.println("<--- Email ID & Password Entered successfully --->");
    }
  
    @Then("User is signed in to The Washington Post {string}")
    public void userSignedInIntoTheWashingtonPost(String accountName) throws InterruptedException {
        System.out.println("userSignedInIntoTheWashingtonPost Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifySignIn(accountName));
        System.out.println("<--- Sign In Successful --->");
    }

    @And("User clicks on the {string} checkbox")
    public void userClicksOnCheckBox(String checkboxIntention) throws InterruptedException {
        System.out.println("userClicksOnCheckBox Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifyCheckBox(checkboxIntention));
        System.out.println("<--- Check Box checked --->");
    }

    @Then("User should be able to change the Email ID before Sign-Up")
    public void userEditsTheIncorrectEmailIDWith() throws InterruptedException {
        System.out.println("userEditsTheIncorrectEmailIDWith Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.editEmailId());
        System.out.println("User can Sign-Up with another Email ID");
    }

    @Then("User should be on the Welcome Page")
    public void userIsInWelcomePage() throws InterruptedException {
        System.out.println("userIsInWelcomePage Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.checkWelcomeNote());
        System.out.println("<--- User received a Welcome note! --->");
    }

    @And("Internet Connection is {string}")
    public void internetConnectivity(String state) throws IOException {
        System.out.println("internetConnectivity Method");
        TestUtils testUtils = new TestUtils();
        Assert.assertTrue(testUtils.wifiOnOff(state));
    }

    @Then("The Site is Reloaded")
    public void reloadSite() {
        System.out.println("reloadSite Method");
        Commons commons = new Commons(driver);
        Assert.assertTrue(commons.reloadSite());
        System.out.println("Site reloaded");
    }

    @And("Error message is displayed")
    public void verifyErrorMessage() throws InterruptedException {
        System.out.println("verifyErrorMessage Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifyEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed in GoogleID")
    public void verifyErrorMessageGoogleID() throws InterruptedException {
        System.out.println("verifyErrorMessageGoogleID Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifyGoogleIDEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed in GooglePassword")
    public void verifyErrorMessageGoogleIDPassword() throws InterruptedException {
        System.out.println("verifyErrorMessageGoogleIDPassword Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifyGoogleIDPasswordEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed in ApplePassword")
    public void verifyErrorMessageAppleIDPassword() throws InterruptedException {
        System.out.println("verifyErrorMessageAppleIDPassword Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifyAppleIDPasswordEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed in AppleID")
    public void verifyErrorMessageAppleID() throws InterruptedException {
        System.out.println("verifyErrorMessageAppleID Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifyAppleIDEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @Then("User should be on the Link Verification Page")
    public void userShouldBeOnTheLinkVerificationPage() throws InterruptedException {
        System.out.println("userShouldBeOnTheLinkVerificationPage Method");
        EmailLinkVerificationPage signInWithEmailPage = new EmailLinkVerificationPage(driver);
        Assert.assertTrue(signInWithEmailPage.linkSentNote());
        System.out.println("<--- User is prompted to check inbox for a Sign-in link --->");
    }
  
    @Then("User should be on the Sign in with Google Page")
    public void userShouldBeOnTheSignInWithGooglePage() throws InterruptedException {
        System.out.println("userShouldBeOnTheSignInWithGooglePage Method");
        EmailLinkVerificationPage signInWithEmailPage = new EmailLinkVerificationPage(driver);
        Assert.assertTrue(signInWithEmailPage.signInWithGoogle());
        System.out.println("<--- User is in Google sign in page --->");
    }

    @Then("User should be able to access all links")
    public void userShouldBeAbleToAccessAllLinks() throws InterruptedException {
        System.out.println("userShouldBeAbleToAccessAllLinks Method");
        EmailLinkVerificationPage signInWithEmailPage = new EmailLinkVerificationPage(driver);
        Assert.assertTrue(signInWithEmailPage.resendNotificationVerify());
        System.out.println("<--- User is able to access all links from the Link Verification Page --->");
    }

    @Then("Help for Sign-in using {string} is prompted {string}")
    public void helpForSignInIsPrompted(String fieldType, String emailId) throws InterruptedException {
        System.out.println("helpForSignInIsPrompted Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.needHelpToSignInLink(fieldType, emailId));
        System.out.println("<--- User received a hyperlink to Sign-in --->");
    }

    @Then("User should be on the Amazon signIn Page")
    public void userShouldBeOnTheAmazonSignInPage() throws InterruptedException {
        System.out.println("userShouldBeOnTheAmazonSignInPage Method");
        EmailLinkVerificationPage signInWithEmailPage = new EmailLinkVerificationPage(driver);
        Assert.assertTrue(signInWithEmailPage.signInWithAmazon());
        System.out.println("<--- User is in Amazon sign in page --->");
    }

    @Then("User Account name is Displayed {string}")
    public void userAccountNameIsDisplayed(String accountName) throws InterruptedException {
        System.out.println("userAccountNameIsDisplayed Method");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.verifyAccountNamePostSignIn(accountName));
        System.out.println("<--- Sign In Successful --->");
    }

    @Then("User should be on the Sign in with Apple Page")
    public void userShouldBeOnTheSignInWithApplePage() throws InterruptedException {
        System.out.println("userShouldBeOnTheSignInWithApplePage Method");
        EmailLinkVerificationPage signInWithEmailPage = new EmailLinkVerificationPage(driver);
        Assert.assertTrue(signInWithEmailPage.signInWithApple());
        System.out.println("<--- User is in Apple sign in page --->");
    }

    @Then("User should be on the Facebook signIn Page")
    public void userShouldBeOnTheFacebookSignInPage() throws InterruptedException {
        System.out.println("userShouldBeOnTheFacebookSignInPage Method");
        EmailLinkVerificationPage signInWithEmailPage = new EmailLinkVerificationPage(driver);
        Assert.assertTrue(signInWithEmailPage.signInWithFacebook());
        System.out.println("<--- User is in Facebook sign in page --->");
    }

    @And("Error message is displayed in AmazonID")
    public void verifyErrorMessageAmazonID() throws InterruptedException {
        System.out.println("verifyErrorMessageAmazonID Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifyAmazonIDEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed in FacebookID")
    public void verifyErrorMessageFacebookID() throws InterruptedException {
        System.out.println("verifyErrorMessageFacebookID Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifyFacebookIDEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed in AmazonID Password")
    public void verifyErrorMessageAmazonIDPassword() throws InterruptedException {
        System.out.println("verifyErrorMessageAmazonIDPassword Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifyAmazonIDPasswordEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @And("Error message is displayed in FacebookID Password")
    public void verifyErrorMessageFacebookIDPassword() throws InterruptedException {
        System.out.println("verifyErrorMessageFacebookIDPassword Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.verifyFacebookIDPasswordEmailError());
        System.out.println("<--- Error Message Displayed Successfully --->");
    }

    @Then("User should be on the six digit Verification Facebook Page")
    public void userShouldBeOnThe6digitVerificationFacebookPage() throws InterruptedException {
        System.out.println("userShouldBeOnThe 6 digit Verification Facebook Page Method");
        EmailLinkVerificationPage signInWithEmailPage = new EmailLinkVerificationPage(driver);
        Assert.assertTrue(signInWithEmailPage.verifySixDigitVerificationPage());
        System.out.println("<--- User is prompted to check inbox for a Sign-in link --->");
    }

    @And("User enters {string} in AmazonID")
    public void userEntersAmazonEmailIdPassword(String emailIdPassword) throws InterruptedException {
        System.out.println("userEnters Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.enterAmazonEmailId(emailIdPassword));
        System.out.println("<--- Email ID Entered successfully --->");
    }

    @And("User enters {string} in FacebookID")
    public void userEntersFacebookEmailIdPassword(String emailIdPassword) throws InterruptedException {
    System.out.println("userEnters Method");
    SignInPage signInPage = new SignInPage(driver);
    Assert.assertTrue(signInPage.enterFacebookEmailId(emailIdPassword));
    System.out.println("<--- Email ID Entered successfully --->");
    }

    @And("User enters {string} in Google in the {string} field")
    public void userEntersGoogleEmailIdPassword(String emailIdPassword, String fieldType) throws InterruptedException {
        System.out.println("userEnters Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.enterGoogleEmailId(fieldType, emailIdPassword));
        System.out.println("<--- Email ID Entered successfully --->");
    }

    @And("User enters {string} in AppleID {string} field")
    public void userEntersAppleEmailIdPassword(String emailIdPassword, String fieldType) throws InterruptedException {
        System.out.println("userEnters Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.enterAppleEmailId(emailIdPassword, fieldType));
        System.out.println("<--- Email ID Entered successfully --->");
    }

    @And("User should not be able to click SignUp button")
    public void userShouldNotBeAbleToClickButton() throws InterruptedException {
        System.out.println("userShouldNotBeAbleToClickButton Method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertFalse(signInPage.signUpButton().isEnabled());
        System.out.println("<--- SignUp Button is Disabled --->");
    }

    @And("User opens Live & Trending sessions")
    public void liveAndTrending() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        System.out.println("liveAndTrending method");
        Assert.assertTrue(homePage.liveAndTrendingSessions());
        System.out.println("<--- Live & Trending Sessions Verified --->");
    }

    @And("User clicks on the Article Author Name")
    public void articleAuthorName() throws InterruptedException {
        System.out.println("articleAuthorName method");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.authorNameLinks());
        System.out.println("<--- Article's Author's Pages Verified --->");
    }

    @And("User clicks on images")
    public void userClicksOnImages() throws InterruptedException {
        System.out.println("articleAuthorName method");
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.findAllImages());
        System.out.println("<--- Article's Author's Pages Verified --->");
    }

    @And("User enters the {string}")
    public void userEntersTheInAppleIDField(String twoFactorAuthCode, String authCodeField) {
        System.out.println("userEntersTheInAppleIDField method");
        SignInPage signInPage = new SignInPage(driver);
        Assert.assertTrue(signInPage.appleTwoFactorAuth(twoFactorAuthCode));
        System.out.println("<--- Two Factor Authentication Code Entered --->");
    }
}