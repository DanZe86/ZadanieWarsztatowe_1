import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestSelenium {
    @FindBy(id = "//select[@name='id_country']")
    private static List<WebElement> country;


    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        PageFactory.initElements(driver, "https://mystore-testlab.coderslab.pl/index.php?controller=address");

        country.get(1).click();


       /* driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=address");
        WebElement element = driver.findElement(By.xpath("//select[@name='id_country']"));
        Select sel = new Select(element);
        sel.selectByVisibleText("United Kingdom");*/



    }
}
