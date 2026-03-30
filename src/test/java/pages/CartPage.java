package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By cartItem = By.className("inventory_item_name");
    By checkoutBtn = By.id("checkout");

    public boolean isItemDisplayed() {
        return driver.findElement(cartItem).isDisplayed();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}