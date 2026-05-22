package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LivingRoom extends Basepage {

    JavascriptExecutor js;

    public LivingRoom(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//div[text()='Bestseller']")
    List<WebElement> lstBestSeller;

    @FindBy(xpath = "//div[text()='New Arrivals']")
    List<WebElement> lstNewArrivals;

    public void printProducts() {

        System.out.println("----- BESTSELLERS -----");
        for (WebElement e : lstBestSeller) {
            String name = e.findElement(By.xpath("./ancestor::div[@role='link']//h3")).getText();
            String price = e.findElement(By.xpath("./ancestor::div[@role='link']//div[@class='UYQNp']")).getText();

            System.out.println(name + " | " + price);
        }

        System.out.println("----- NEW ARRIVALS -----");
        for (WebElement e : lstNewArrivals) {
            String name = e.findElement(By.xpath("./ancestor::div[@role='link']//h3")).getText();
            String price = e.findElement(By.xpath("./ancestor::div[@role='link']//div[@class='UYQNp']")).getText();

            System.out.println(name + " | " + price);
        }
    }

    public void scrollToTop() {
        js.executeScript("window.scrollTo(0,0)");
    }

    public void scrollDownMultipleTimes() throws InterruptedException {
        for (int i = 0; i < 8; i++) {
            js.executeScript("window.scrollBy(0,1000)");
            Thread.sleep(3000);
        }
    }
}
