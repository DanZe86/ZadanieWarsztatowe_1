package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AddressPage extends BasePage {



    public AddressPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//div/a[@class='col-lg-4 col-md-6 col-sm-6 col-xs-12'][2]")
    private WebElement addAddress;

    @FindBy(xpath = "//ol//li[3]")
    private WebElement addresses;

    @FindBy(xpath = "//span[text() = 'Create new address']")
    private WebElement createNewAddress;

    @FindBy(xpath = "//input[@name='alias']")
    private WebElement inputAlias;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement inputAddress;

    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement inputZipCode;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement inputCity;

    @FindBy(name = "id_country")
    private WebElement inputCountry;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement inputPhone;

    @FindBy(xpath = "//footer//button[contains(text(), 'Save')]")
    private WebElement saveButton;

    @FindBy(tagName = "address")
    List<WebElement> addressDataForm;

    @FindBy(xpath = "//div[@class='address-body']")
    List<WebElement> confirmAddress;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    List<WebElement> deleteButton;

    //Przechodzi do strony z adresami
    public void goToUrl() {

        addAddress.click();
        waitASecond();
        //jeżeli nie ma zakładki "addresses"
        try {
            addresses.click();
        } catch (NoSuchElementException e) {

        }
    }

    public void fillAddresForm(String alias, String address, String postalCode, String city, String country, String phoneNumber) {
        createNewAddress.click();
        inputAlias.click();
        inputAlias.sendKeys(alias);
        inputAddress.click();
        inputAddress.sendKeys(address);
        inputZipCode.click();
        inputZipCode.sendKeys(postalCode);
        inputCity.click();
        inputCity.sendKeys(city);
        inputCountry.click();
        inputCountry.sendKeys(country);
        inputPhone.click();
        inputPhone.clear();
        inputPhone.sendKeys(phoneNumber);
        waitASecond();
        saveButton.click();

    }

    public String addAddressConfirmation() {

        for (WebElement e : confirmAddress) {
            e.getText();
        }
        WebElement lastAddItAddress = confirmAddress.get(confirmAddress.size() - 1);
        return lastAddItAddress.getText();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public WebElement deleteAddress() {
        List<WebElement> multiDelete = new ArrayList<>();

        multiDelete.addAll((deleteButton));
        System.out.println(multiDelete.size());
        System.out.println(multiDelete.indexOf(multiDelete.size() - 1));
        WebElement lastDeleteButton = multiDelete.get(multiDelete.size() - 1);
        return lastDeleteButton;
    }

    public String addressDeleted() {
        WebElement e = driver.findElement(By.xpath("//li[text() = 'Address successfully deleted!']"));
        String infoIsDeleted = e.getText();
        return infoIsDeleted;
    }
}




