package task4.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task4.Utilities.BrowserUtils;
import task4.Utilities.Driver;

import java.util.List;
import java.util.Random;

public class SummerDressesPage {

    public SummerDressesPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[.=\"Add to cart\"]")
    public List<WebElement> productsATCs;

    @FindBy(xpath = "//a[@title=\"Proceed to checkout\"]/span")
    public WebElement proceedToCheckoutElement;


    public void addToCart() {

        /**  select a product randomly to add to cart**/
        Random random = new Random();
        int randomProduct = random.nextInt(productsATCs.size());
        WebElement randomElement = productsATCs.get(randomProduct);

        try {
            BrowserUtils.waitForClickabilility(randomElement, 5);
            BrowserUtils.clickWithJS(randomElement);
        } catch (Exception e) {
            BrowserUtils.clickWithWait(randomElement, 5);
        }
    }

    public void proceedToChecout() {

        try {
            BrowserUtils.waitForClickabilility(proceedToCheckoutElement, 5);
            BrowserUtils.clickWithJS(proceedToCheckoutElement);
        } catch (Exception e) {
            BrowserUtils.clickWithWait(proceedToCheckoutElement, 5);
        }

    }
}
