package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By cartProductName = By.className("inventory_item_name");
    private By cartProductPrice = By.className("inventory_item_price");
    private By removeBackpackButton = By.id("remove-sauce-labs-backpack");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get product name
    public String getCartProductName() {
        return driver.findElement(cartProductName).getText();
    }

    // Get product price
    public String getCartProductPrice() {
        return driver.findElement(cartProductPrice).getText();
    }

    public void removeBackpackFromCart() {
        driver.findElement(removeBackpackButton).click();
    }
}