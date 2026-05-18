package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class BookShelvesPage extends Basepage {
    Actions act=new Actions(driver);

    //constructor
    public BookShelvesPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//h2[text()='Sort By']")
    WebElement SortBy;

    @FindBy(xpath = "//*[text()='Price Low to High']")
    WebElement Pricelowtohigh;

    @FindBy(xpath = "//h2[text()='Storage Type']")
    WebElement Storagetype;

    @FindBy(xpath = "//div[text()='Open Storage'][@class='Wd1xL']")
    WebElement openstorage;


    @FindBy(className = "XxwSy")
    List<WebElement> elements;

    @FindBy(className = "UYQNp")
    List<WebElement> price;

    @FindBy(xpath = "//span[normalize-space()='New Arrivals']")
    WebElement NewArrivals;

    @FindBy(xpath = "//a[@href='/collection/oasis-living-room-collection']")
    WebElement livingroom;

    //actions

    public void clickSortby() {
        SortBy.click();
    }
    public void clickPricelowtohigh() {
        Pricelowtohigh.click();
    }
    public void clickStoragetype() {
        Storagetype.click();
    }
    public void clickopenstorage() {
        openstorage.click();
    }

    public void printProductsWithPrices(int count) {
        for (int i = 0; i < count; i++) {
            String productName = elements.get(i).getText();
            String productPrice = price.get(i).getText();
            System.out.println(productName + " : " + productPrice);
        }
    }
    public void clicklivingroomcollections() {
        act.moveToElement(NewArrivals).perform();
        livingroom.click();
    }



}

