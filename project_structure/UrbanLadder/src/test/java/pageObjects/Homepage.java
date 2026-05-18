package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends Basepage{
    JavascriptExecutor js=(JavascriptExecutor) driver;

    //constructor
    public Homepage(WebDriver driver){super (driver);}

    //elements
    @FindBy(xpath="//img[@alt='Bookshelves']")
    WebElement bookshelves;
    @FindBy(xpath="//h2[normalize-space()='Shop by Category']")
    WebElement shopbycategory;



    //Actions
    public void clickBookshekves() {
        js.executeScript("arguments[0].scrollIntoView(true);",shopbycategory);
        bookshelves.click();
    }




}
