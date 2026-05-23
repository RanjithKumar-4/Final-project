package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookShelvesPage extends Basepage {

    Actions act;
    WebDriverWait wait;
    JavascriptExecutor js;

    public BookShelvesPage(WebDriver driver) {
        super(driver);
        act = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }


    @FindBy(xpath = "//span[contains(text(),'Sort')]")
    WebElement SortBy;

    @FindBy(xpath = "//*[contains(text(),'Price Low')]")
    WebElement Pricelowtohigh;

    @FindBy(xpath = "//span[text()='Storage Type']")
    WebElement Storagetype;

    @FindBy(xpath = "//div[text()='Open Storage'][@class='Wd1xL']")
    WebElement openstorage;


    @FindBy(xpath = "//span[normalize-space()='New Arrivals']")
    WebElement NewArrivals;

    @FindBy(xpath = "//a[@href='/collection/oasis-living-room-collection']")
    WebElement livingroom;


    public void clickSortby() {

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        js.executeScript("window.scrollBy(0,600)");

        wait.until(ExpectedConditions.visibilityOf(SortBy));
        js.executeScript("arguments[0].scrollIntoView(true);", SortBy);

        wait.until(ExpectedConditions.elementToBeClickable(SortBy)).click();
    }

    public void clickPricelowtohigh() {

        wait.until(ExpectedConditions.elementToBeClickable(Pricelowtohigh)).click();
    }

    public void clickStoragetype() {

        js.executeScript("window.scrollBy(0,600)");

        wait.until(ExpectedConditions.visibilityOf(Storagetype));
        js.executeScript("arguments[0].scrollIntoView(true);", Storagetype);

        wait.until(ExpectedConditions.elementToBeClickable(Storagetype)).click();
    }

    public void clickopenstorage() {

        wait.until(ExpectedConditions.elementToBeClickable(openstorage)).click();
    }

    public void printProductsWithPrices(int count) {

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        List<WebElement> products = driver.findElements(By.className("XxwSy"));
        List<WebElement> prices = driver.findElements(By.className("UYQNp"));

        for (int i = 0; i < count; i++) {

            String productName = products.get(i).getText();
            String productPrice = prices.get(i).getText();

            System.out.println(productName + " : " + productPrice);
        }
    }

    public void clickLivingRoomCollection() {

        act.moveToElement(NewArrivals).perform();

        wait.until(ExpectedConditions.elementToBeClickable(livingroom)).click();
    }
}