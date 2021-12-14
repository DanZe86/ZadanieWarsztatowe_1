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

public class AddNewAddressDefinition {
    private WebDriver driver;


    @Given("I have an open browser and log on created user")
    public void logToAccount() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        SignInPage signInUser = new SignInPage(driver);
        signInUser.signInPage("spoqstvoerxbrpamfa@nthrl.com", "12345678");
    }

    @When("I enter site through tiles to user Address")
    public void goToAddressUrl() {
        AddressPage newAddressPage = new AddressPage(driver);
        newAddressPage.goToUrl();
    }

    @Then("I check if page is open on Address Page")
    public void checkAddressPage() {
        AddressPage currentAddress = new AddressPage(driver);
        Assert.assertEquals("https://mystore-testlab.coderslab.pl/index.php?controller=addresses", currentAddress.getUrl());
    }

    @When("I create address and fill the form with \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void addNewAddress(String alias, String address, String postalCode, String city, String country, String phoneNumber) {
        AddressPage addAddress = new AddressPage(driver);
        addAddress.fillAddresForm(alias, address, postalCode, city, country ,phoneNumber);
    }

    @Then("I checked if data are add it and correct with data \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void checkData(String alias, String address, String postalCode, String city, String country, String phoneNumber)  {
        AddressPage newAddressCheck = new AddressPage(driver);

        String confirmationText = newAddressCheck.addAddressConfirmation();
        Assert.assertTrue(confirmationText.contains(alias));
        Assert.assertTrue(confirmationText.contains(address));
        Assert.assertTrue(confirmationText.contains(postalCode));
        Assert.assertTrue(confirmationText.contains(city));
        Assert.assertTrue(confirmationText.contains(country));
        Assert.assertTrue(confirmationText.contains(phoneNumber));
        newAddressCheck.waitASecond();
        driver.quit();
    }
}
