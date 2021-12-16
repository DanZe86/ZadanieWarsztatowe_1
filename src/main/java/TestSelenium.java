import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestSelenium {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
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
        inputPassword.sendKeys(haslo);

    }
}

