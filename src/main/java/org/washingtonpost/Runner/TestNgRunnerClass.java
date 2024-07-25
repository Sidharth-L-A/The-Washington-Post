package org.washingtonpost.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions (
        features = "src/main/resources/Features",
        glue = {"org/washingtonpost/StepDefinitions"}
)
@Test
public class TestNgRunnerClass extends AbstractTestNGCucumberTests {
}
