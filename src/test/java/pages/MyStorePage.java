package pages;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;


public class MyStorePage extends BasePage {
    public MyStorePage(WebDriver driver) {
        super(driver);
    }


    // my store tile
    @FindBy(css = ".logo.img-responsive")
    private WebElement myStoreTile;

    //adding product HUMMINGBIRD PRINTED SWEATER
    @FindBy(css = "[alt='Brown bear printed sweater']")
    private WebElement sweater;
    // Choose Size of a sweater

    @FindBy(id = "group_1")
    private WebElement chooseSize;
    //choose quantity of a sweater
    @FindBy(id = "quantity_wanted")
    private WebElement inputQuantity;
    // price without discount
    @FindBy(css = ".regular-price")
    private WebElement regularPrice;
    //price with a discount 20%
    @FindBy(css = "[itemprop='price']")
    private WebElement discountPrice;
    // add to cart button
    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addToCartButton;
    // button to proceed to checkout
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedButton;
    @FindBy(xpath = "//*[@id='myModalLabel']/i")
    private WebElement productAddit;

    // secound button to proceed to checkout
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedButtonTwo;
    // tile with address made before
    @FindBy(css = ".address-item.selected")
    private WebElement chooseAddress;
    // button to contiune to next tile
    @FindBy(name = "confirm-addresses")
    private WebElement continueButton;

    // checkbox for shipping
    @FindBy(id = "delivery_option_1")
    private WebElement shippingMethodCheckbox;
    // continue delivery butto
    @FindBy(name = "confirmDeliveryOption")
    private WebElement continueDeliveryButton;

    //Checkbox for payment
    @FindBy(id = "payment-option-1")
    private WebElement checboxPayment;
    //take price from tile order
    @FindBy(xpath = "//*[@id='cart-subtotal-products']/span[2]")
    private WebElement totalPrice;

    //Checkbox for terms of service
    @FindBy(xpath = "//input[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement termsOfServiceCheckbox;
    //button for order with an obligation to pay
    @FindBy(css = ".btn.btn-primary.center-block")
    private WebElement buttonOrderWith;
    // confirmation of your order
    @FindBy(css = ".h1.card-title")
    private WebElement outputOrderConfirmed;

    // go to user account
    @FindBy(css = ".account")
    private WebElement userAccount;
    // go to tile hisotryOrder
    @FindBy(id = "history-link")
    private WebElement historyOrder;
    //history-link historyOrder

    //.account userAccount

    public void goToMyStore() {
        myStoreTile.click();
    }

    public String getMyStoreUrl() {
        return driver.getCurrentUrl();
    }

    public void chooseItem() {
        sweater.click();
    }

    public double getRegularPrice() throws IOException {
        String price = regularPrice.getText();
        char[] array = new char[100];
        StringReader input = new StringReader(price);
        input.skip(1);
        input.read(array);
        double convertedRegularPrice = Double.parseDouble(String.valueOf(array));
        return convertedRegularPrice;
    }

    public double getDiscountPrice() throws IOException {
        String price = discountPrice.getText();
        char[] array = new char[100];
        StringReader input = new StringReader(price);
        input.skip(1);
        input.read(array);
        double convertedDiscountPrice = Double.parseDouble(String.valueOf(array));
        return convertedDiscountPrice;
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void setSize(String size) {
        chooseSize.click();
        chooseSize.sendKeys(size);
        chooseSize.click();
    }

    public void setQuantity(String quantity) {
        inputQuantity.click();
        inputQuantity.clear();
        inputQuantity.sendKeys(quantity);
    }

    public void addItemToCart() {
        addToCartButton.click();
    }

    public WebElement checkItemAddtoCart() {
        return productAddit;
    }

    public void proceedToCheckout() {
        proceedButton.click();
        proceedButtonTwo.click();
    }

    public void confirmAddress() {
        if (chooseAddress.isSelected()) {
            continueButton.click();
        } else {
            chooseAddress.click();
            continueButton.click();
        }

    }

    public void confirmShippingMethod() {
        if (shippingMethodCheckbox.isSelected()) {
            continueDeliveryButton.click();
        } else {
            shippingMethodCheckbox.click();
            continueDeliveryButton.click();
        }
    }

    public void choosePaymentMethod() {
        if (checboxPayment.isSelected()) {
            termsOfServiceCheckbox.click();
        } else {
            checboxPayment.click();
            termsOfServiceCheckbox.click();
        }

    }

    public void orderWithAnObligarion() {
        buttonOrderWith.click();
    }

    //https://www.guru99.com/take-screenshot-selenium-webdriver.html#1
    public void makePrintScreen() throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("src/test/java/FilesPS/prtscr.png");
        FileUtils.copyFile(SrcFile, DestFile);

       /* Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();*/
    }

    public void goToHistory() {

        userAccount.click();
        historyOrder.click();
        //https://mystore-testlab.coderslab.pl/index.php?controller=order-confirmation&id_cart=76336&id_module=11&id_order=8999&key=547c03bd08d75a96e44011a8e85b5998
    }

    public String getTextOrder() {
        List<WebElement> list = driver.findElements(By.tagName("tr"));
        for (WebElement e : list) {
            e.getText();
        }
        String orderText = list.get(1).getText();
        return orderText;
    }
}



