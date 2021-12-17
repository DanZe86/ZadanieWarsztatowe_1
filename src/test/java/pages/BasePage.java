package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitASecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String StringConverter(double element) throws IOException {
        String price = String.valueOf(element);
        return price;
    }
}





