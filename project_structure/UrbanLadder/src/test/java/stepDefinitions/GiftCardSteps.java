package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BookShelvesPage;
import pageObjects.GiftCardPage;
import pageObjects.payment;

public class GiftCardSteps {
    GiftCardPage gc;
    payment pay;


    @Given("the user is on the giftcards  page")
    public void the_user_is_on_the_giftcards_page() {
        gc= new GiftCardPage(BaseClass.getDriver());
        gc.clickgiftcards();
    }
    @When("the user enters all the inputs")
    public void the_user_enters_all_the_inputs() {
        gc.givedenomination();
        gc.givequantity();
        gc.clicksenderchkbox();
        gc.enterfirstname();
        gc.enterlastname();
        gc.enteremail();
        gc.enternumber();
        gc.clicktermschkbox();

    }
    @When("clicks on Paynow")
    public void clicks_on_paynow() {
        gc.clickpaynow();
    }
    @Then("the user gets directed to payment page")
    public void the_user_gets_directed_to_payment_page() {
        pay= new payment(BaseClass.getDriver());
        pay.clickupi();
        pay.clickpaybtn();
    }
    @Then("cancels the payment")
    public void cancels_the_payment() {
        pay.clickcancelbtn();
        pay.clickothersbtn();
        pay.clicksubmitbtn();
        pay.clickdiffpaybtn();
    }
    @Then("validate the error message")
    public void validate_the_error_message() {
        pay.printerrormsg1();
        pay.printerrormsg2();
    }


}
