package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy (xpath = "//*[@id='columns']/div[1]")
    private WebElement breadCrums;

    @FindBy (xpath = "//*[@id='add_to_cart']/button/span")
    private WebElement addToCardBtn;

    @FindBy (xpath = "//*[@id='layer_cart']")
    private WebElement checkOutPopUp;

    @FindBy (xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")
    private WebElement checkBtn;


    /**
     * Constructor
     *
     * @param testClass
     */
    public ProductPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    public void checkBreadcrums (){
        Assert.assertEquals ("Breadcrum is different!", "> Women>Tops>T-shirts>Faded Short Sleeve T-shirts", breadCrums.getText());
    }

    public void clickAddBtn(){
        addToCardBtn.click();
        testClass.waitTillElementIsVisible(checkOutPopUp);
    }

    public CheckoutPage clickCheckoutBtn(){
        checkBtn.click();
        return new CheckoutPage(testClass);
    }
}
