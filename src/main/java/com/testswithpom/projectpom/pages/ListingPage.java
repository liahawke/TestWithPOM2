package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListingPage extends AbstractPage {

    @FindBy(xpath = "//span[@class='cat-name']")
    private WebElement headingOfListingPage;

    /**
     * Constructor
     *
     * @param testClass
     */
    public ListingPage(BaseClass testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on product
     *
     * @param productName
     * @return Product Page
     */
    public ProductPage clickOnProduct(String productName) {
        testClass.waitTillElementIsVisible(headingOfListingPage);
        testClass
                .getDriver()
                .findElement(By.xpath("//a[contains(text(),'" + productName + "')]"))
                .click();
        return new ProductPage(testClass);
    }
}
