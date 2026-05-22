package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GiftCardPage extends Basepage {

    WebDriverWait wait;
    JavascriptExecutor js;

    public GiftCardPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//a[normalize-space()='Gift Cards']")
    WebElement lnkGiftCards;

    @FindBy(id = "sameAsSender")
    WebElement chkSender;

    @FindBy(id = "agreeTerms")
    WebElement chkTerms;

    @FindBy(id = "pay-now-button")
    WebElement btnPayNow;


    public void clickGiftCards() {

        wait.until(ExpectedConditions.elementToBeClickable(lnkGiftCards)).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windows = driver.getWindowHandles();
        List<String> list = new ArrayList<>(windows);

        driver.switchTo().window(list.get(1));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("denomination")));
    }


    public void setDenomination(String value) {

        WebElement element = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.presenceOfElementLocated(By.name("denomination"))));

        element.sendKeys(value);
    }

    public void setQuantity(String qty) {

        WebElement element = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.presenceOfElementLocated(By.name("quantity"))));

        element.sendKeys(qty);
    }

    public void clickSenderCheckbox() {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(chkSender));
        js.executeScript("arguments[0].click();", element);
    }

    public void setFirstName(String fname) {

        WebElement element = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.presenceOfElementLocated(By.name("firstname"))));

        element.sendKeys(fname);
    }

    public void setLastName(String lname) {

        WebElement element = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.presenceOfElementLocated(By.name("lastname"))));

        element.sendKeys(lname);
    }

    public void setEmail(String email) {

        WebElement element = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.presenceOfElementLocated(By.name("email"))));

        element.sendKeys(email);
    }

    public void setPhone(String phone) {

        WebElement element = wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.presenceOfElementLocated(By.name("telephone"))));

        element.sendKeys(phone);
    }

    public void clickTerms() {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(chkTerms));
        js.executeScript("arguments[0].click();", element);
    }

    public void clickPayNow() {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnPayNow));
        js.executeScript("arguments[0].click();", element);
    }
}
