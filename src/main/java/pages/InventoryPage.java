package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    // Locators
    private By pageTitle = By.className("title");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get page title
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
}