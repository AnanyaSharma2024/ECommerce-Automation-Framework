package tests;

import java.util.List;

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

    @Test
    public void verifyAllProductsAreDisplayed() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        System.out.println("Product Names:");
        System.out.println(inventoryPage.getAllProductNames());

        System.out.println("Product Prices:");
        System.out.println(inventoryPage.getAllProductPrices());

        Assertions.assertEquals(6, inventoryPage.getAllProductNames().size());

        Assertions.assertEquals(6, inventoryPage.getAllProductPrices().size());
    }

    @Test
    public void verifyPriceSortingLowToHigh() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.sortProductsByPriceLowToHigh();

        List<String> prices = inventoryPage.getAllProductPrices();

        System.out.println("Sorted Prices: " + prices);

        for (int i = 0; i < prices.size() - 1; i++) {
//Double.parseDouble String (text) ko decimal number (double) mein badalta hai.
            double currentPrice =
                    Double.parseDouble(prices.get(i).replace("$", ""));

            double nextPrice =
                    Double.parseDouble(prices.get(i + 1).replace("$", ""));

            Assertions.assertTrue(currentPrice <= nextPrice);
        }
    }

    @Test
    public void verifyPriceSortingHighToLow() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.sortProductsByPriceHighToLow();

        List<String> prices = inventoryPage.getAllProductPrices();

        System.out.println("High to Low Prices: " + prices);

        for (int i = 0; i < prices.size() - 1; i++) {

            double currentPrice =
                    Double.parseDouble(prices.get(i).replace("$", ""));

            double nextPrice =
                    Double.parseDouble(prices.get(i + 1).replace("$", ""));

            Assertions.assertTrue(currentPrice >= nextPrice);
        }
    }
}