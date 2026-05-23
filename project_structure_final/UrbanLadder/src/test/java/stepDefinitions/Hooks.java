package stepDefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    WebDriver driver;

    @Before
    public void setup() throws Exception {

        BaseClass.getLogger().info("Initializing Browser");

        driver = BaseClass.initDriver();
        driver.get(BaseClass.getProperties().getProperty("appURL"));
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {

        byte[] screenshot = ((TakesScreenshot) BaseClass.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        scenario.attach(screenshot, "image/png", "Step Screenshot");
    }
    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            String screenshotPath = BaseClass.captureScreenshot(scenario.getName());

            byte[] screenshot = ((TakesScreenshot) BaseClass.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", scenario.getName());

            BaseClass.getLogger().info("Screenshot captured: " + screenshotPath);
        }

        BaseClass.quitDriver();
    }


}