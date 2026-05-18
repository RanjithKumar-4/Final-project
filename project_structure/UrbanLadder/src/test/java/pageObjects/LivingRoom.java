package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LivingRoom extends Basepage {
    JavascriptExecutor js=(JavascriptExecutor) driver;

    //constructor
    public LivingRoom(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//div[text()='Bestseller']")
    List<WebElement> bestseller;


    @FindBy(xpath = "//div[text()='New Arrivals']")
    List<WebElement> newarrivals;


    //actions

    // ✅ ONE public method – call this directly from Step Definition
    public void printAllBestsellerAndNewArrivals()  {


        System.out.println("----- BESTSELLER PRODUCTS -----");
        for (WebElement tag : bestseller) {

            String name = tag.findElement(
                            By.xpath("./ancestor::div[@role='link']//h3"))
                    .getText();

            String price = tag.findElement(
                            By.xpath("./ancestor::div[@role='link']//div[@class='UYQNp']"))
                    .getText();

            System.out.println("Product: " + name);
            System.out.println("Price: " + price);
            System.out.println("--------------------------------");
        }

        System.out.println("----- NEW ARRIVAL PRODUCTS -----");
        for (WebElement tag : newarrivals) {

            String name = tag.findElement(
                            By.xpath("./ancestor::div[@role='link']//h3"))
                    .getText();

            String price = tag.findElement(
                            By.xpath("./ancestor::div[@role='link']//div[@class='UYQNp']"))
                    .getText();

            System.out.println("Product: " + name);
            System.out.println("Price: " + price);
            System.out.println("--------------------------------");
        }
    }

    public void scrollTotop() throws InterruptedException {

        js.executeScript("window.scrollTo(0, 0)");
        Thread.sleep(2000);
    }


    public void scrollToLoadAllProducts() throws InterruptedException {

        for (int i = 0; i < 8; i++) {
            js.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(3000);
        }
    }

}
