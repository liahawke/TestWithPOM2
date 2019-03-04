package com.testswithpom.projectpom.pages;

import com.testswithpom.projectpom.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

    // Web Elements
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement loginLink;

    @FindBy(xpath = "//div[@id='page']")
    protected WebElement divPage;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
    public WebElement tshirtsTitle;

    // Instances of BaseTest
    protected BaseClass testClass;

    /**
     * Constructor
     *
     * @param testClass
     */
    public AbstractPage(BaseClass testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on Sign in link
     *
     * @return Login Page
     */
    public LoginPage clickLoginLink() {
        testClass.waitTillElementIsVisible(loginLink);
        loginLink.click();
        return new LoginPage(testClass);
    }

    /** Click on Dresses link */
    public ListingPage clickOnMenuLink() {
        tshirtsTitle.click();
        return new ListingPage(testClass);
    }
}
