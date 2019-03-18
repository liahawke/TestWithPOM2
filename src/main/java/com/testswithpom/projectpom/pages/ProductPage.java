package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.base.ClothesCategories;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    private WebElement breadCrums;

    @FindBy(xpath = "//*[@id='add_to_cart']/button/span")
    private WebElement addToCardBtn;

    @FindBy(xpath = "//*[@id='layer_cart']")
    private WebElement checkOutPopUp;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement checkoutBtn;

    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement productName;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ProductPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Parse Expected Breadcrumbs
     *
     * @return String with expected Breadcrumbs
     */
    public String parseExpectedBreadcrumbs(ClothesCategories category) {
        String expectedBreadCrumbs =
                "> "+category.getGeneralName()+">"
                        + category.getCategoryName()
                        + ">"
                        + category.getSubcategoryName()
                        + ">"
                        + productName.getText();
        return expectedBreadCrumbs;
    }

    /**
     * Check is breadcrumbs is correct
     *
     * @param expectedBreadCrumbs
     */
    public void checkBreadcrumbs(String expectedBreadCrumbs) {
        testClass.waitTillElementIsVisible(breadCrums);
        Assert.assertEquals("Breadcrum is different!", expectedBreadCrumbs, breadCrums.getText());
    }

    /** Click on Add product button */
    public void clickAddBtn() {
        testClass.waitTillElementIsVisible(addToCardBtn);
        addToCardBtn.click();
        testClass.waitTillElementIsVisible(checkOutPopUp);
    }

    /**
     * Proceed to checkout page
     *
     * @return CheckoutPage
     */
    public CheckoutPage clickCheckoutBtn() {
        testClass.waitTillElementIsVisible(checkoutBtn);
        checkoutBtn.click();
        return new CheckoutPage(testClass);
    }
}
