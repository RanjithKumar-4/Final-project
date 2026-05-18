package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BookShelvesPage;
import pageObjects.LivingRoom;

public class CollectionsSteps {

    BookShelvesPage bs;
    LivingRoom lr;

    @Given("the user is on the bookshelves page")
    public void the_user_is_on_the_bookshelves_page() {
        bs= new BookShelvesPage(BaseClass.getDriver());

    }
    @When("clicks on living room")
    public void clicks_on_living_room() {

        bs.clicklivingroomcollections();
    }
    @Then("the user should print all the bestseller and new arrivals products with their name and price")
    public void the_user_should_print_all_the_bestseller_and_new_arrivals_products_with_their_name_and_price() throws InterruptedException {
        lr= new LivingRoom(BaseClass.getDriver());
        lr.scrollToLoadAllProducts();
        lr.printAllBestsellerAndNewArrivals();
        lr.scrollTotop();


    }
}
