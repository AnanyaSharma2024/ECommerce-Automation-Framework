package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By cartProductName = By.className("inventory_item_name");
    private By cartProductPrice = By.className("inventory_item_price");

    private By removeBackpackButton =
            By.id("remove-sauce-labs-backpack");

    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getCartProductName() {
        return driver.findElement(cartProductName).getText();
    }

    public String getCartProductPrice() {
        return driver.findElement(cartProductPrice).getText();
    }

    public void removeBackpackFromCart() {
        wait.until(
            ExpectedConditions.elementToBeClickable(removeBackpackButton)
        ).click();
    }

    public void clickCheckout() {
        wait.until(
            ExpectedConditions.elementToBeClickable(checkoutButton)
        ).click();
    }
}