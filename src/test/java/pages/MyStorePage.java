package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Scanner;

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

    @FindBy(id = "#group_1")
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

    // secound button to proceed to checkout
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement proceedButtonTwo;
    // tile with address made before
    @FindBy(id = "id-address-delivery-address-18439")
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
    //Checkbox for terms of service
    @FindBy(xpath = "//input[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement termsOfServiceCheckbox;
    //button for order with an obligation to pay
    @FindBy(css = ".btn.btn-primary.center-block")
    private WebElement buttonOrderWith;
    // confirmation of your order
    @FindBy(css = ".h1.card-title")
    private WebElement outputOrderConfirmed;

    public void goToMyStore() {
        myStoreTile.click();
    }

    public String getMyStoreUrl() {
        return driver.getCurrentUrl();
    }



        public String setQuantity () {
            Scanner scan = new Scanner(System.in);
            String quantity = scan.nextLine();
            return quantity;
        }
        public String setSize () {
            Scanner scan = new Scanner(System.in);
            String size = scan.nextLine();
            return size;
        }

    }



