package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BookShelvesPage;
import pageObjects.Homepage;

public class BookshelvesSteps {
    Homepage hp;
    BookShelvesPage bs;


    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        hp=new Homepage(BaseClass.getDriver());

    }

    @When("clicks on Bookshelves")
    public void clicks_on_bookshelves() {
        hp.clickBookshekves();
    }
    @When("the user sorts by price from low to high")
    public void the_user_sorts_by_price_from_low_to_high() {
        bs= new BookShelvesPage(BaseClass.getDriver());
        bs.clickSortby();
        bs.clickPricelowtohigh();
    }
    @When("puts the storage type as open storage")
    public void puts_the_storage_type_as_open_storage() {
        bs.clickStoragetype();
        bs.clickopenstorage();
    }
    @Then("the user should print the first three bookshelves names and prices")
    public void the_user_should_print_the_first_three_bookshelves_names_and_prices() {
        bs.printProductsWithPrices(3);
    }


}