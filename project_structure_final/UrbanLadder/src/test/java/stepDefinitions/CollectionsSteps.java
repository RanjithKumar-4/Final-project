package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BookShelvesPage;
import pageObjects.LivingRoom;
import utilities.DataReader;

import java.io.IOException;

public class CollectionsSteps {

    WebDriver driver;
    BookShelvesPage bs;
    LivingRoom lr;

    @Given("the user is on the bookshelves page")
    public void the_user_is_on_the_bookshelves_page() {

        BaseClass.getLogger().info("User is on Bookshelves page");

        bs = new BookShelvesPage(BaseClass.getDriver());
    }

    @When("clicks on living room")
    public void clicks_on_living_room() {

        BaseClass.getLogger().info("Clicking on Living Room collection");

        bs.clickLivingRoomCollection();
    }

    @Then("the user should print all the bestseller and new arrivals products with their name and price")
    public void the_user_should_print_all_products() throws InterruptedException, IOException {

        BaseClass.getLogger().info("Printing Bestseller and New Arrival products");

        lr = new LivingRoom(BaseClass.getDriver());

        lr.scrollDownMultipleTimes();
        lr.printProducts();
        DataReader.writeCollectionsData(BaseClass.getDriver());
        lr.scrollToTop();
    }
}