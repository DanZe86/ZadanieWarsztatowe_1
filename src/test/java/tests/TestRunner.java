package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/cucumber/features/CreateNewAddress.feature", plugin={"pretty","html:testResults.html"}, glue="stepDefinitions")
//DeleteAddress.feature
//CreateNewAddress.feature
public class TestRunner {



}

/*package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
*/
/*
package tests;

import Utils.Helper;
import org.junit.Before;
import org.junit.Test;
import pages.AddressPage;
import pages.SignInPage;

public class CreateAddressTest extends BaseTest {



    @Before

    public void loginUserTest() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        SignInPage login = new SignInPage(driver);
        login.signInPage("spoqstvoerxbrpamfa@nthrl.com", "12345678");
        login.waitASecond();
    }


   */
/* @Test
    public void addAddress() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=my-account");
        AddressPage newAddress1 = new AddressPage(driver);
        newAddress1.goToUrl();
        newAddress1.fillAddresForm("Danny", "Jerozolimskie 5/2", "01-000", "LondonBaby", "567567777");
        // zrobic asercie

        String confirmationText = newAddress1.addAddressConfirmation();
        Assert.assertTrue(confirmationText.contains("Danny"));
        Assert.assertTrue(confirmationText.contains("Jerozolimskie 5/2"));
        Assert.assertTrue(confirmationText.contains("LondonBaby"));
        Assert.assertTrue(confirmationText.contains("567567777"));
    }*//*



    @Test
    public void test(){
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=addresses");
        Helper.deleteAddress();
        AddressPage deleteAddress = new AddressPage(driver);
        deleteAddress.deleteAddress();


    }


}
*/
/*
package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.AddressPage;
import pages.SignInPage;

public class LoginUserTest extends BaseTest {
    private WebDriver Driver;


    @Test
    public void loginUserTest() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        SignInPage login = new SignInPage(driver);
        login.signInPage("spoqstvoerxbrpamfa@nthrl.com", "12345678");
        Assert.assertEquals("Test Testerski", login.logSuccess());
        login.waitASecond();
        AddressPage newAddress1 = new AddressPage(driver);
        newAddress1.goToUrl();
        newAddress1.fillAddresForm("Danny", "Jerozolimskie 5/2", "01-000","LondonBaby" , "567567777");


    }


}
*/


