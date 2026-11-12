package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    @Test
    public void verifyProductInCart() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add product to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        // Open cart
        inventoryPage.openCart();

        // Verify cart product
        CartPage cartPage = new CartPage(driver);

        String actualName = cartPage.getCartProductName();
        String actualPrice = cartPage.getCartProductPrice();

        Assertions.assertEquals("Sauce Labs Backpack", actualName);
        Assertions.assertEquals("$29.99", actualPrice);
    }

    @Test
    public void verifyRemoveProductFromCart() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);

        cartPage.removeBackpackFromCart();

        Assertions.assertTrue(
            driver.findElements(
                org.openqa.selenium.By.className("cart_item")
            ).isEmpty()
        );
    }
}
