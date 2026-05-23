package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageObjects.BookShelvesPage;
import pageObjects.Homepage;
import utilities.DataReader;

import java.io.IOException;

public class BookshelvesSteps {

    WebDriver driver;
    Homepage hp;
    BookShelvesPage bs;

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {

        hp = new Homepage(BaseClass.getDriver());
    }

    @When("clicks on Bookshelves")
    public void clicks_on_bookshelves() {

        BaseClass.getLogger().info("Clicking Bookshelves");

        hp.clickBookshelves();
    }

    @When("the user sorts by price from low to high")
    public void sort_low_to_high() {

        bs = new BookShelvesPage(BaseClass.getDriver());

        bs.clickSortby();
        bs.clickPricelowtohigh();
    }

    @When("puts the storage type as open storage")
    public void select_open_storage() {

        bs.clickStoragetype();
        bs.clickopenstorage();
    }

    @Then("the user should print the first three bookshelves names and prices")
    public void print_products() throws IOException {

        bs.printProductsWithPrices(3);
        DataReader.writeBookshelvesData(BaseClass.getDriver(), 3);
    }

}