package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTest extends BaseTest {

    @Test
    public void verifyProductsPage() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        // Verify Inventory Page
        InventoryPage inventoryPage = new InventoryPage(driver);

        String actualTitle = inventoryPage.getPageTitle();

        Assertions.assertEquals("Products", actualTitle);
    }
}