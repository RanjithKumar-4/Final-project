package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = ".//Features/Collections.feature",
        glue ="stepDefinitions",
        plugin = {"pretty", "html:reports/myreport.html"}
)
public class TestRunner {
}