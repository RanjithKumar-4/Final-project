package factory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;


public class BaseClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    static Properties p;
    static Logger logger;

    public static WebDriver initDriver() throws IOException {

        WebDriver dr = null;

        String executionEnv = getProperties().getProperty("execution_env");
        String browser = getProperties().getProperty("browser");

        if (executionEnv.equalsIgnoreCase("local")) {

            switch (browser.toLowerCase()) {
                case "chrome":
                    dr = new ChromeDriver();
                    break;
                case "edge":
                    dr = new EdgeDriver();
                    break;
                default:
                    System.out.println("No matching browser");
            }
        }

        dr.manage().deleteAllCookies();
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        dr.manage().window().maximize();
        driver.set(dr);

        return dr;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    public static void switchToChildWindow() {
        String parentWindow = getDriver().getWindowHandle();
        Set<String> allWindows = getDriver().getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                getDriver().switchTo().window(window);
                break;
            }
        }
    }

    public static Properties getProperties() throws IOException {

        if (p == null) {
            FileReader file = new FileReader(System.getProperty("user.dir") +
                    "\\src\\test\\resources\\config.properties");

            p = new Properties();
            p.load(file);
        }

        return p;
    }


    public static Logger getLogger() {
        logger = LogManager.getLogger();
        return logger;
    }



    public static String captureScreenshot(String testName) {

        String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

        try {
            File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileHandler.copy(src, new File(path));
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }

        return path;
    }

}