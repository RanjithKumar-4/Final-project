package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GiftCardPage extends Basepage{
    JavascriptExecutor js=(JavascriptExecutor) driver;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    //constructor
    public GiftCardPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//a[normalize-space()='Gift Cards']")
    WebElement Giftcards;

    @FindBy(xpath ="//input[@name='denomination']")
    WebElement Denomination;

    @FindBy(xpath = "//input[@name='quantity']")
    WebElement Quantity;

    @FindBy(xpath = "//input[@id='sameAsSender']")
    WebElement Senderchkbox;

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstname;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastname;

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='telephone']")
    WebElement telephone;

    @FindBy(xpath = "//input[@id='agreeTerms']")
    WebElement termschkbox;

    @FindBy(xpath = "//button[@id='pay-now-button']")
    WebElement paynow;

    //Actions
    public void clickgiftcards() {
        wait.until(ExpectedConditions.elementToBeClickable(Giftcards)).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> window = driver.getWindowHandles();
        List<String> giftcard = new ArrayList<>(window);
        driver.switchTo().window(giftcard.get(1));
    }
    public void givedenomination() {

        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(Denomination))).sendKeys("1000");
    }
    public void givequantity() {
        wait.until(ExpectedConditions.visibilityOf(Quantity)).sendKeys("3");
    }
    public void clicksenderchkbox() {
        js.executeScript("arguments[0].click();", Senderchkbox);
    }
    public void enterfirstname() {
        wait.until(ExpectedConditions.visibilityOf(firstname)).sendKeys("rahul");

    }
    public void enterlastname() {
        lastname.sendKeys("reddy");
    }
    public void enteremail() {
        email.sendKeys("abc@gmail.com");
    }
    public void enternumber() {
        telephone.sendKeys("9087865478");
    }
    public void clicktermschkbox() {
        js.executeScript("arguments[0].click();", termschkbox);
    }
    public void clickpaynow() {
        js.executeScript("arguments[0].click();", paynow);
    }



}
