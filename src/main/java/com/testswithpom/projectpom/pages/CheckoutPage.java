package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckoutPage extends AbstractPage{

    // Web elements
    @FindBy(xpath = "//*[@id='cart_quantity_up_1_1_0_145849']")
    private WebElement incProduct;

    @FindBy(xpath = "//input[@name='quantity_1_1_0_145849']")
    private WebElement prodQuantity;

    @FindBy (xpath = "//tr[@id='product_1_1_0_145849']/td[@class='cart_quantity text-center']/input[@type='hidden']")
    private WebElement hiddenQuantity;

    @FindBy (xpath="//*[@id='product_price_1_1_145849']/span")
    private WebElement prodPrice;

    @FindBy (xpath = "//*[@id='total_price']")
    private WebElement totalPrice;

    @FindBy (xpath = "//*[@id='total_shipping']")
    private WebElement shippingPrice;

    @FindBy (xpath = "//*[@id='1_1_0_145849']")
    private WebElement deleteBtn;

    @FindBy (xpath = "//*[@id='center_column']/p")
    private WebElement emptyCardMessage;

    private String EMPTY_CARD_MESSAGE = "Your shopping cart is empty.";

    /**
     * Constructor
     *
     * @param testClass
     */
    public CheckoutPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    public void clickPlusBtn(){
        incProduct.click();
        testClass.waitTillTextAppears(prodQuantity);
    }

    public void checkPrice(){
        float actualPrice = (Float.parseFloat(prodPrice.getText().substring(1))
                * Float.parseFloat(hiddenQuantity.getAttribute("value")))
                + Float.parseFloat(shippingPrice.getText().substring(1));
        Assert.assertEquals("Price is different!", String.valueOf(actualPrice), totalPrice.getText().substring(1));
    }

    public void deleteProduct(){
        deleteBtn.click();
        testClass.waitTillElementIsVisible(emptyCardMessage);
    }

    public void checkTitle() {
        Assert.assertEquals("Card isn't empty!",EMPTY_CARD_MESSAGE,emptyCardMessage.getText() );
    }
}
