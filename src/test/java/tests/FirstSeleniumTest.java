
package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest {

    @Test
    public void openSauceDemoWebsite() {

        // Step 1: Create WebDriver object
        WebDriver driver = new ChromeDriver();

        try {

            // Step 2: Open website
            driver.get("https://www.saucedemo.com/");

            // Step 3: Get website title
            String actualTitle = driver.getTitle();

            System.out.println("Website Title: " + actualTitle);

            // Step 4: Verify title
            Assertions.assertEquals("Swag Labs", actualTitle);

        } finally {

            // Step 5: Close browser
            driver.quit();
        }
    }
}
