package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageObjects.GiftCardPage;
import pageObjects.payment;

public class GiftCardSteps {

    WebDriver driver;
    GiftCardPage gc;
    payment pay;

    @Given("the user is on the giftcards page")
    public void open_giftcard_page() {

        BaseClass.getLogger().info("Opening Gift Cards page");

        gc = new GiftCardPage(BaseClass.getDriver());
        gc.clickGiftCards();
    }

    @When("the user enters gift card details {string} {string} {string} {string} {string} {string}")
    public void the_user_enters_gift_card_details(String amount, String qty, String fname, String lname, String email, String phone) {

        BaseClass.getLogger().info("Entering dynamic gift card details");
        gc.setDenomination(amount);
        gc.setQuantity(qty);
        gc.clickSenderCheckbox();
        gc.setFirstName(fname);
        gc.setLastName(lname);
        gc.setEmail(email);
        gc.setPhone(phone);
        gc.clickTerms();
    }

    @When("the user enters all the inputs")
    public void enter_inputs() {

        BaseClass.getLogger().info("Entering Gift Card details");

        gc.setDenomination("1000");
        gc.setQuantity("3");
        gc.clickSenderCheckbox();
        gc.setFirstName("rahul");
        gc.setLastName("reddy");
        gc.setEmail("abc@gmail.com");
        gc.setPhone("9087865478");
        gc.clickTerms();
    }

    @When("clicks on Paynow")
    public void click_paynow() {

        BaseClass.getLogger().info("Clicking Pay Now");
        gc.clickPayNow();
    }

    @Then("the user gets directed to payment page")
    public void navigate_payment_page() {

        BaseClass.getLogger().info("Navigating to Payment page");

        pay = new payment(BaseClass.getDriver());

        try {
            Thread.sleep(5000);
        } catch (Exception e) {}

        pay.selectUPI();
        pay.clickPay();
    }

    @Then("cancels the payment")
    public void cancel_payment() {

        BaseClass.getLogger().info("Cancelling Payment");

        pay.clickCancel();
        pay.clickOthers();
        pay.clickSubmit();
        pay.clickDifferentPaymentMode();
    }

    @Then("validate the error message")
    public void validate_error_msg() {

        String msg1 = pay.getErrorMessage1();
        String msg2 = pay.getErrorMessage2();

        System.out.println(msg1);
        System.out.println(msg2);

        BaseClass.getLogger().info(msg1);
        BaseClass.getLogger().info(msg2);
    }
}