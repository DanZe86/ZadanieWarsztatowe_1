package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement userEmailInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPasswordInput;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement loginSuccess;

    @FindBy(css = ".logout.hidden-sm-down")
    private WebElement signOutButton;


    public void signInPage(String email, String password) {
        userEmailInput.click();
        userEmailInput.clear();
        userEmailInput.sendKeys(email);
        userPasswordInput.click();
        userPasswordInput.clear();
        userPasswordInput.sendKeys(password);
        signInButton.click();
    }

    public void signOutPage() {
        signOutButton.click();
    }

    public String logSuccess() {
        return loginSuccess.getText();
    }
}

