package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.MyStorePage;
import pages.SignInPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BuyItemDefinition {
    private WebDriver driver;
    BasePage basePage;
    MyStorePage myStorePage;
    SignInPage signInUser;


    @Given("I log user from exercise one")
    public void i_log_user_from_exercise_one() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        signInUser = new SignInPage(driver);
        signInUser.signInPage("spoqstvoerxbrpamfa@nthrl.com", "12345678");

    }


    @When("I go to myStore page")
    public void goToUrl() {
        myStorePage = new MyStorePage(driver);
        myStorePage.goToMyStore();
    }

    @Then("I check if page is correct")
    public void checkMyStoreUrl() {
        String currentUrl = myStorePage.getMyStoreUrl();
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php", currentUrl);
    }

    @When("I choose product Hummingbird Printed Sweater")
    public void i_choose_product_hummingbird_printed_sweater() {
        myStorePage.chooseItem();

    }

    @Then("I check if product was chosen with discount")
    public void i_check_if_product_was_chosen_with_discount() throws IOException {
        double priceAfterDiscount = myStorePage.getRegularPrice() - (myStorePage.getRegularPrice() * 0.2);
        double priceDiscounted = myStorePage.getDiscountPrice();
        Assert.assertTrue(priceAfterDiscount == priceDiscounted);
    }

    @When("^I pick \"(.*)\" and \"(.*)\" of the product$")
    public void pickSizeAndQuantity(String size, String quantity) {
        myStorePage.setQuantity(quantity);
        myStorePage.setSize(size);


        // Write code here that turns the phrase above into concrete actions

    }

    @When("I add item to a shopping cart")
    public void i_add_item_to_a_shopping_cart() {
        myStorePage.addItemToCart();


    }

    @Then("I check if item was add it correctly")
    public void i_check_if_item_was_add_it_correctly() {
        Assert.assertTrue(myStorePage.checkItemAddtoCart() != null);
    }

    @When("I go to tile checkout")
    public void i_go_to_tile_checkout() {
        myStorePage.proceedToCheckout();

    }

    @When("confirm user address")
    public void confirme_user_address() {
        myStorePage.confirmAddress();
    }

    @When("I choose shipping method with PrestaShop")
    public void i_choose_shipping_method_with_presta_shop() {
        myStorePage.confirmShippingMethod();

    }

    @When("I pay by check and click on terms of service")
    public void i_pay_by_check() {
        myStorePage.choosePaymentMethod();
    }

    @When("I click on Order with an obligation to pay")
    public void i_click_on_order_with_an_obligation_to_pay_with_terms_of_service() {
        myStorePage.orderWithAnObligarion();

    }

    @Then("I make printscreen")
    public void i_check_the_order_with_price() throws IOException {
        myStorePage.makePrintScreen();

    }


}
