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
    public void userTypesInTheSearchBar(String arg0) {
        System.out.println("userTypesInTheSearchBar Method");

//    To-Do :
//    Move the method to dedicated page file
//    Try to Optimize with userEnters()
    }

    @Given("User is in Homepage")
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

    @When("User Clicks on {string} button")
    public void userClicksOnButton(String button) {
        System.out.println("userClicksOnButton Method");

        if(Objects.equals(button, "SignIn")) {
            signInPage.signInButton().click();
            System.out.println("<--- Clicked on 'Sign In' Button --->");
        }

        else if(Objects.equals(button, "Next")) {
            signInPage.nextButton().click();
            System.out.println("<--- Clicked on 'Next' Button --->");
        }

        // To-Do :
        // Sign In (2) - done
        // Next - done
        // Subscribe, Politics, Opinions, etc etc
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

    @Then("User Signed in into The Washington Post")
    public void userSignedInIntoTheWashingtonPost() {
        System.out.println("userSignedInIntoTheWashingtonPost Method");
        Assert.assertTrue(signInPage.verifySignIn());
        System.out.println("<--- Sign In Successful --->");
    }
}
