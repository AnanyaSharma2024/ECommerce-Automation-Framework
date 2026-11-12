package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
public class InventoryPage {

    private WebDriver driver;

    // Locators
    private By pageTitle = By.className("title");
    private By productNames = By.className("inventory_item_name");
    private By productPrices = By.className("inventory_item_price");
    private By sortDropdown = By.className("product_sort_container");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get page title
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public List<String> getAllProductNames() {

        List<WebElement> elements =
                driver.findElements(productNames);

        List<String> names = new java.util.ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            names.add(elements.get(i).getText());
        }

        return names;
    }

    public List<String> getAllProductPrices() {

        List<WebElement> elements = driver.findElements(productPrices);

        List<String> prices = new java.util.ArrayList<>();

        for (int i = 0; i < elements.size(); i++) {
            prices.add(elements.get(i).getText());
        }

        return prices;
    }

    public void sortProductsByPriceLowToHigh() {

        WebElement dropdown = driver.findElement(sortDropdown);

        Select select = new Select(dropdown);

        select.selectByValue("lohi");
    }

    public void sortProductsByPriceHighToLow() {

        WebElement dropdown = driver.findElement(sortDropdown);

        Select select = new Select(dropdown);

        select.selectByValue("hilo");
    }
}