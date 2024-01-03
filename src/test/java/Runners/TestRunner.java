package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/MyTest.feature",
        glue = "src/main/java/StepsDefinitions/HomeStepsDefinition.java"
)
public class TestRunner {
}
