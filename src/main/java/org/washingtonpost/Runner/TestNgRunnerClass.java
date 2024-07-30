package org.washingtonpost.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.washingtonpost.Utilities.WebDrivers;

@CucumberOptions (
        features = "src/main/resources/Features",
        glue = {"org/washingtonpost/StepDefinitions"}
)
// @Test
public class TestNgRunnerClass extends AbstractTestNGCucumberTests {

//    private WebDrivers webDrivers;

//    @BeforeTest
//    public void setUp() {
//        webDrivers = new WebDrivers();
//        webDrivers.chromeBrowserDriverInit();
//        System.out.println("<--- WebDriver Initialized (Chrome) --->");
//    }
//
//    @AfterTest
//    public void tearDown() {
//        if (webDrivers != null && webDrivers.getDriver() != null) {
//            webDrivers.getDriver().quit();
//            System.out.println("<--- Browser Closed, Test Completed --->");
//        }
//    }
}
