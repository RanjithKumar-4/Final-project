package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class payment extends Basepage {

    WebDriverWait wait;

    public payment(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void selectUPI() {

        WebElement upi = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@data-testid='upi_tray']")
                )));

        upi.click();
    }

    public void clickPay() {

        WebElement payBtn = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@data-testid='pay-button']")
                )));

        payBtn.click();
    }

    public void clickCancel() {

        WebElement cancelBtn = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[text()='Cancel Payment']")
                )));

        cancelBtn.click();
    }

    public void clickOthers() {

        WebElement others = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Others']")
                )));

        others.click();
    }

    public void clickSubmit() {

        WebElement submitBtn = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[text()='Submit']")
                )));

        submitBtn.click();
    }

    public void clickDifferentPaymentMode() {

        WebElement diff = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Different Payment')]")
                )));

        diff.click();
    }

    public String getErrorMessage1() {

        WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'order-complete-header')]")
        ));

        return msg.getText();
    }

    public String getErrorMessage2() {

        try {
            WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class,'order-complete-detail')]")
            ));

            return msg.getText();

        } catch (Exception e) {
            return "No second error message";
        }
    }
}