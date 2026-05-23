package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage {

    JavascriptExecutor js;

    public Homepage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//img[@alt='Bookshelves']")
    WebElement imgBookshelves;

    @FindBy(xpath = "//h2[normalize-space()='Shop by Category']")
    WebElement lblShopByCategory;

    public void clickBookshelves() {
        js.executeScript("arguments[0].scrollIntoView(true);", lblShopByCategory);
        imgBookshelves.click();
    }
}