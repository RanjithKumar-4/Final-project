package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class payment extends Basepage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    //constructor
    public payment(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//button[@data-testid='upi_tray']//div[@class='flex items-center w-full']")
    WebElement upi;

    @FindBy(xpath = "//button[@data-testid='pay-button']")
    WebElement paybtn;

    @FindBy(xpath = "//button[text()='Cancel Payment']")
    WebElement cancelbtn;

    @FindBy(xpath = "//span[text()='Others']")
    WebElement othersbtn;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitbtn;

    @FindBy(xpath = "//button[text()='Try a Different Payment Mode']")
    WebElement diffpaybtn;

    @FindBy(xpath = "//div[@class='h3 text-danger mt-4 order-complete-header']")
    WebElement errmsg1;

    @FindBy(xpath = "//div[@class=' order-complete-detail']")
    WebElement errmsg2;

    //actions

    public void clickupi() {
        wait.until(ExpectedConditions.elementToBeClickable(upi)).click();
    }

    public void clickpaybtn() {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(paybtn))).click();

    }

    public void clickcancelbtn() {
        wait.until(ExpectedConditions.visibilityOf(cancelbtn)).click();
    }

    public void clickothersbtn() {
        wait.until(ExpectedConditions.visibilityOf(othersbtn)).click();
    }

    public void clicksubmitbtn() {
        wait.until(ExpectedConditions.visibilityOf(submitbtn)).click();
    }

    public void clickdiffpaybtn() {
        wait.until(ExpectedConditions.visibilityOf(diffpaybtn)).click();
    }

    public void printerrormsg1(){

        System.out.println(wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(errmsg1))).getText());

    }

    public void printerrormsg2(){
        System.out.println(wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(errmsg2))).getText());
    }

}