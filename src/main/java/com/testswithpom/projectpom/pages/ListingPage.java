package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListingPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    private WebElement productLink;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ListingPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /** Click on subcategory Summer Dresses link */
    public ProductPage clickOnProduct() {
        productLink.click();
        return new ProductPage(testClass);
    }
}
