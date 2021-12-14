package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddressPage;
import pages.SignInPage;

import java.util.concurrent.TimeUnit;

public class DeleteAddressDefinition {
    private WebDriver driver;

    @Given("I have log an user")
    public void i_have_log_an_user() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        SignInPage signInUser = new SignInPage(driver);
        signInUser.signInPage("spoqstvoerxbrpamfa@nthrl.com", "12345678");

    }

    @When("I enter site to user page with Address")
    public void i_enter_site_to_user_page_with_address() {
        AddressPage newAddressPage = new AddressPage(driver);
        newAddressPage.goToUrl();

    }

    @Then("I check page url")
    public void i_check_page_url() {
        AddressPage currentAddress = new AddressPage(driver);
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=addresses", currentAddress.getUrl());

    }

    @When("I delete created address")
    public void i_delete_created_address() {
        AddressPage deleteAddress = new AddressPage(driver);
        deleteAddress.deleteAddress().click();

    }

    @Then("I check if address was deleted")
    public void i_check_if_address_was_deleted() {
        AddressPage isAddressDeleted = new AddressPage(driver);
        Assert.assertEquals("Address successfully deleted!", isAddressDeleted.addressDeleted());
        System.out.println("Address was deleted");
        isAddressDeleted.waitASecond();
        driver.quit();
    }
}
