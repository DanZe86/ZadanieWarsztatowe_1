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
    AddressPage newAddressPage;
    SignInPage signInUser;
    private WebDriver driver;

    @Given("I have log an user")
    public void i_have_log_an_user() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        signInUser = new SignInPage(driver);
        signInUser.signInPage("nowy@email.pl", "12345678");
    }

    @When("I enter site to user page with Address")
    public void i_enter_site_to_user_page_with_address() {
        newAddressPage = new AddressPage(driver);
        newAddressPage.goToUrl();
    }

    @Then("I check page url")
    public void i_check_page_url() {
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=addresses", newAddressPage.getUrl());
    }

    @When("I delete created address")
    public void i_delete_created_address() {
        newAddressPage.deleteAddress().click();
    }

    @Then("I check if address was deleted")
    public void i_check_if_address_was_deleted() {
        Assert.assertEquals("Address successfully deleted!", newAddressPage.addressDeleted());
        System.out.println("Address was deleted");
        newAddressPage.waitASecond();
        driver.quit();
    }
}
