package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.MyStorePage;
import pages.SignInPage;

import java.util.concurrent.TimeUnit;

public class TestingTests {

    private WebDriver driver;
    BasePage basePage;
    MyStorePage myStorePage;
    SignInPage signInUser;


    @Before
    public void i_log_user_from_exercise_one() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        signInUser = new SignInPage(driver);
        signInUser.signInPage("spoqstvoerxbrpamfa@nthrl.com", "12345678");

    }

    @Test
    public void historyOrder() {

        WebElement userAccount = driver.findElement(By.cssSelector(".account"));
        userAccount.click();
        WebElement historyOrder = driver.findElement(By.id("history-link"));
        historyOrder.click();
      /*  Assert

      *//*  Assert.assertTrue(txt.contains(priceToCheck));
        Assert.assertTrue(txt.contains("Awaiting check payment"));*/


    }
}







