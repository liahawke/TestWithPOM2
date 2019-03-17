package com.testswithpom.projectpom.test;

import com.testswithpom.projectpom.base.BaseClass;
import com.testswithpom.projectpom.pages.*;
import org.junit.Test;

public class SignInAndAddToCard extends BaseClass {

    @Test
    public void signInAndCheckName() {

        // Open site
        HomePage homePage = openSite();
        log("Opened site");

        // Click on Sign In link
        LoginPage loginPage = homePage.clickLoginLink();
        log("Click on Login Link");

        // Signing in Account
        AccountPage accountPage = loginPage.fillInputOnLoginPage();
        log("Fill data for auth");

        // Verify user name
        accountPage.verifyName();
        log("Verify user");

        // Click on T-Shirt link
        ListingPage listingPage = accountPage.clickOnMenuLink();
        log("Click on T-Shirt menu's item");

        // Click on Product
        ProductPage productPage = listingPage.clickOnProduct("Faded Short Sleeve T-shirts");
        log("Click on Product");

        // Check Breadcrumbs
        productPage.checkBreadcrumbs(productPage.parseExpectedBreadcrumbs());
        log("Checking Breadcrumbs");

        // Add product to card
        productPage.clickAddBtn();
        log("Add Product to card");

        // Proceed to checkout
        CheckoutPage checkoutPage = productPage.clickCheckoutBtn();
        log("Proceed to checkout");

        // Click + link to increase product quantity
        checkoutPage.clickPlusBtn();
        log("Increase quantity of product");

        // Check price
        checkoutPage.checkPrice();
        log("Check price");

        // Delete product from the card
        checkoutPage.deleteProduct();
        log("Delete product from the card");

        // Check title on empty card page
        checkoutPage.checkTitle();
        log("Check title on empty card page");

        // Close site
        closeSite();
        log("Close site");
    }
}
