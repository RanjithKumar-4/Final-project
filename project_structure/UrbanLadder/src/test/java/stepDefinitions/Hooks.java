package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class Hooks {
    WebDriver driver;

    @Before
    public void setup() {
        driver = BaseClass.initDriver();
        driver.get("https://www.urbanladder.com/");
    }
    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}