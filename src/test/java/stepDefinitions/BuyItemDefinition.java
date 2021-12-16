package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MyStorePage;
import pages.SignInPage;

import java.util.concurrent.TimeUnit;

public class BuyItemDefinition {
    private WebDriver driver;
    private String size;
    private int quantity;



    @Given("I log user from exercise one")
    public void i_log_user_from_exercise_one() {
        MyStorePage myStorePage = new MyStorePage(driver);
        System.out.println("set quantity of the product: ");
        myStorePage.setQuantity();
        System.out.println("set size of the product (S,M,L,XL): ");
        myStorePage.setSize();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        SignInPage signInUser = new SignInPage(driver);
        signInUser.signInPage("spoqstvoerxbrpamfa@nthrl.com", "12345678");

    }


    @When("I go to myStore page")
    public void goToUrl() {
        MyStorePage goTo = new MyStorePage(driver);
        goTo.goToMyStore();
    }
    @Then("I check if page is correct")
    public void checkMyStoreUrl(){
        MyStorePage test = new MyStorePage(driver);
        String currentUrl = test.getMyStoreUrl();
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php", currentUrl);
    }

    @When("I choose product Hummingbird Printed Sweater")
    public void i_choose_product_hummingbird_printed_sweater() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("I check if product was choosen with discount")
    public void i_check_if_product_was_choosen_with_discount() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^I pick (.*) and (.*) of the product$")
    public void i_pick_quantity_of_the_product(String size, String quantity) {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I add item to a shopping cart")
    public void i_add_item_to_a_shopping_cart() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("I check if item was add it correctly")
    public void i_check_if_item_was_add_it_correctly() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I go to tile checkout")
    public void i_go_to_tile_checkout() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("confirme user address")
    public void confirme_user_address() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I choose shipping method with PrestaShop")
    public void i_choose_shipping_method_with_presta_shop() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I pay by check")
    public void i_pay_by_check() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("I click on Order with an obligation to pay with terms of service")
    public void i_click_on_order_with_an_obligation_to_pay_with_terms_of_service() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("I check the order with price")
    public void i_check_the_order_with_price() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("I make printscreen")
    public void i_make_printscreen() {
        // Write code here that turns the phrase above into concrete actions

    }
}
