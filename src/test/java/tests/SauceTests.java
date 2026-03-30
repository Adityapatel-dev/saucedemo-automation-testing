package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class SauceTests extends BaseTest {

    @Test
    public void verifyUserCanLoginSuccessfully() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertTrue(inventory.getProductCount() > 0);
    }

    @Test
    public void verifyInvalidLoginShowsError() {
        LoginPage login = new LoginPage(driver);
        login.login("invalid_user", "wrong_pass");

        Assert.assertTrue(login.getErrorMessage().contains("Epic sadface"));
    }

    @Test
    public void verifyProductsAreDisplayed() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertEquals(inventory.getProductCount(), 6);
    }

    @Test
    public void verifyAddToCartFunctionality() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addFirstProductToCart();
        inventory.goToCart();

        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isItemDisplayed());
    }

    @Test
    public void verifyCheckoutProcess() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addFirstProductToCart();
        inventory.goToCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.enterDetails("John", "Doe", "411001");
        checkout.clickContinue();
        checkout.finishOrder();

        Assert.assertTrue(checkout.getSuccessMessage().contains("Thank you"));
    }
}