package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifySuccessfulCheckout() {

        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Add product to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        // Step 3: Open cart
        inventoryPage.openCart();

        // Step 4: Click checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // Step 5: Enter customer details
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.enterFirstName("Ananya");
        checkoutPage.enterLastName("Sharma");
        checkoutPage.enterPostalCode("281001");

        // Step 6: Continue to overview
        checkoutPage.clickContinue();

        // Step 7: Finish order
        checkoutPage.clickFinish();

        // Step 8: Verify success message
        Assertions.assertEquals(
            "Thank you for your order!",
            checkoutPage.getSuccessMessage()
        );
    }

    // Negative Checkout Testing
    @ParameterizedTest
    @CsvSource({
        "'', Sharma, 281001, 'Error: First Name is required'",
        "Ananya, '', 281001, 'Error: Last Name is required'",
        "Ananya, Sharma, '', 'Error: Postal Code is required'"
    })
    public void verifyCheckoutValidation(
            String firstName,
            String lastName,
            String postalCode,
            String expectedError) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(postalCode);

        checkoutPage.clickContinue();

        Assertions.assertEquals(
            expectedError,
            checkoutPage.getErrorMessage()
        );
    }

    @Test
public void verifyCheckoutOverview() {

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("standard_user", "secret_sauce");

    InventoryPage inventoryPage = new InventoryPage(driver);
    inventoryPage.addBackpackToCart();
    inventoryPage.openCart();

    CartPage cartPage = new CartPage(driver);
    cartPage.clickCheckout();

    CheckoutPage checkoutPage = new CheckoutPage(driver);

    checkoutPage.enterFirstName("Ananya");
    checkoutPage.enterLastName("Sharma");
    checkoutPage.enterPostalCode("281001");

    checkoutPage.clickContinue();

    Assertions.assertEquals(
        "Sauce Labs Backpack",
        checkoutPage.getOverviewProductName()
    );

    Assertions.assertEquals(
        "$29.99",
        checkoutPage.getOverviewProductPrice()
    );

    Assertions.assertEquals(
        "Item total: $29.99",
        checkoutPage.getItemTotal()
    );

    Assertions.assertEquals(
        "Tax: $2.40",
        checkoutPage.getTax()
    );

    Assertions.assertEquals(
        "Total: $32.39",
        checkoutPage.getTotal()
    );
}
}