package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    By products = By.className("inventory_item");
    By addToCartBtn = By.xpath("(//button[text()='Add to cart'])[1]");
    By cartIcon = By.className("shopping_cart_link");

    public int getProductCount() {
        return driver.findElements(products).size();
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}