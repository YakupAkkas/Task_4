package task4.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import task4.POM.CartPage;
import task4.POM.CheckoutPage;
import task4.POM.SummerDressesPage;
import task4.Utilities.BrowserUtils;
import task4.Utilities.ConfigurationReader;
import task4.Utilities.Driver;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs {

    SummerDressesPage summerDresses = new SummerDressesPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Given("User is on the Summer Dresses page")
    public void userIsOnTheSummerDressesPage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("User clicks on the product that wants to purchase and add it to the cart")
    public void userClicksOnTheProductThatWantsToPurchaseAndAddItToTheCart() {
        summerDresses.addToCart();
    }

    @And("User Proceed To Checkout")
    public void userProceedToCheckout() {
        summerDresses.proceedToChecout();
    }

    @Then("verify that summer dresses can be added to the cart")
    public void verifyThatSummerDressesCanBeAddedToTheCart() {
        assertNotEquals(cartPage.totalProductElement.getAttribute("value"), "0");
    }

    @And("verify that it’s possible to proceed to the Sign in section")
    public void verifyThatItSPossibleToProceedToTheSignInSection() {
        cartPage.proceedTocheckoutMethod();
        BrowserUtils.waitForPageToLoad(3);
        assertTrue(checkoutPage.alreadyRegisteredElement.isDisplayed());
    }

}
