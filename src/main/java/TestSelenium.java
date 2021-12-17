import org.junit.Assert;

import java.io.IOException;
import java.io.StringReader;

public class TestSelenium {


    public static void main(String[] args) throws IOException {
        String testString = "€35.90";
        char[] array = new char[100];
        double test = 28.72;

        StringReader input = new StringReader(testString);
        input.skip(1);
        input.read(array);
        double valueDouble = Double.parseDouble(String.valueOf(array));
        valueDouble = valueDouble - (valueDouble * 0.2);
        System.out.println(valueDouble);
        String test2 = String.valueOf(valueDouble);
        Assert.assertEquals(test2, "28.72");
        System.out.println(valueDouble);
        System.out.println(test);





















        /*System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj login");
        String login = scan.nextLine();
        System.out.println("Podaj hasło");
        String haslo = scan.nextLine();



        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        WebElement inputLogin = driver.findElement(By.xpath("//input[@class='form-control']"));
        inputLogin.clear();
        inputLogin.click();
        inputLogin.sendKeys(login);
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='password']"));
        inputPassword.clear();
        inputPassword.click();
        inputPassword.sendKeys(haslo);*/

    }
}

