package step_definitions;

import static org.junit.Assert.*;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;

import implementation.Checkout;

public class CheckoutSteps {

    int bananaPrice = 0;
    int applePrice = 0;

    @Given("^the price of a \"(.*?)\" is (\\d+)c$")
    public void thePriceOfAIsC(String itemName, int price) throws Throwable {
        if (itemName.equals("banana")) {
            bananaPrice = price;
        }
        else {  
            applePrice = price;
        }
    }

    Checkout checkout = new Checkout();

    @When("^I checkout (\\d+) \"(.*?)\"$")
    public void iCheckout(int itemCount, String itemName) throws Throwable {
        if (itemName.equals("banana")) {
            checkout.add(itemCount, bananaPrice);
        }
        else {
            checkout.add(itemCount, applePrice);
        }
    }

    @Then("^the total price should be (\\d+)c$")
    public void theTotalPriceShouldBeC(int total) throws Throwable {
        assertEquals(total, checkout.total());
    }
}