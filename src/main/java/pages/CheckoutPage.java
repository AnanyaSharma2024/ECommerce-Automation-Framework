package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");

    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    private By successMessage = By.className("complete-header");
    private By errorMessage = By.cssSelector("[data-test='error']");

    // Checkout Overview locators
    private By overviewProductName = By.className("inventory_item_name");
    private By overviewProductPrice = By.className("inventory_item_price");
    private By itemTotal = By.className("summary_subtotal_label");
    private By tax = By.className("summary_tax_label");
    private By total = By.className("summary_total_label");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    // Overview methods
    public String getOverviewProductName() {
        return driver.findElement(overviewProductName).getText();
    }

    public String getOverviewProductPrice() {
        return driver.findElement(overviewProductPrice).getText();
    }

    public String getItemTotal() {
        return driver.findElement(itemTotal).getText();
    }

    public String getTax() {
        return driver.findElement(tax).getText();
    }

    public String getTotal() {
        return driver.findElement(total).getText();
    }
}