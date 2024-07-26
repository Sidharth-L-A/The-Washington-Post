package org.washingtonpost.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.washingtonpost.Pages.HomePage;
import org.washingtonpost.Pages.SignInPage;
import org.washingtonpost.Utilities.WebDrivers;
import java.util.Objects;

public class TheWashingtonPostStepDefinitions {

    private final WebDriver driver;
    private final HomePage homePage;
    private final SignInPage signInPage;

    public TheWashingtonPostStepDefinitions() {
        WebDrivers webDrivers = new WebDrivers();
        driver = webDrivers.chromeBrowserDriverInit();
        homePage = new HomePage();
        signInPage = new SignInPage();
    }

//    To-Do :
//    Handle Exceptions

    @Given("User types {string} in the search bar")
    public void userTypesInTheSearchBar(String search) {
        System.out.println("userTypesInTheSearchBar Method");

//    To-Do :
//    Move the method to dedicated page file
//    Try to Optimize with userEnters()
    }

    @Given("User is on the Homepage")
    public void userIsInHomepage() {
        System.out.println("userIsInHomepage Method");
        Assert.assertTrue(homePage.verifyUserIsInHomePage());
        System.out.println("<--- The User is in Homepage --->");
    }

    @When("User hits enter key")
    public void userHitsEnterKey() {
        System.out.println("userHitsEnterKey Method");
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

        // Assert if button clicked, change data type of func methods
        if(Objects.equals(button, "SignIn")) {
            signInPage.signInButton().click();
            System.out.println("<--- Clicked on 'Sign In' Button --->");
        }

        else if(Objects.equals(button, "SignUp")) {
            signInPage.signUpButton().click();
            System.out.println("<--- Clicked on 'Sign Up' Button --->");
        }

        else if(Objects.equals(button, "Next")) {
            signInPage.nextButton().click();
            System.out.println("<--- Clicked on 'Next' Button --->");
        }

        else if(Objects.equals(button, "Continue")) {
            signInPage.continueButton().click();
            System.out.println("<--- Clicked on 'Continue' Button --->");
        }

        // To-Do :
        // Subscribe, Politics, Opinions, etc.
        // Re-create the Page Objects file and add common elements
    }

    @And("User enters {string}")
    public void userEnters(String emailPassword) {
        System.out.println("userEnters Method");
        Assert.assertTrue(signInPage.enterEmailIdPassword(emailPassword));
        System.out.println("<--- Email ID & Password Entered successfully --->");

        // To-Do :
        // Find input fields in other pages
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
    public void userEditsTheIncorrectEmailIDWith() {
        System.out.println("userEditsTheIncorrectEmailIDWith Method");
        Assert.assertTrue(signInPage.editEmailId());
        System.out.println("User can SIgn-Up with another Email ID");
    }

    @Then("User should be on the Welcome Page")
    public void userIsInWelcomePage() {
        System.out.println("userIsInWelcomePage Method");
        Assert.assertTrue(signInPage.welcomeNote());
        System.out.println("<--- User received a Welcome note ! --->");
    }

}
