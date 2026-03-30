package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zipCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public void enterDetails(String f, String l, String z) {
        driver.findElement(firstName).sendKeys(f);
        driver.findElement(lastName).sendKeys(l);
        driver.findElement(zipCode).sendKeys(z);
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void finishOrder() {
        driver.findElement(finishBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }
}