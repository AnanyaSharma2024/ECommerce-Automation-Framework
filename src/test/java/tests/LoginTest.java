//Test execute aur verify karega

package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        // Create LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Perform login
        loginPage.login("standard_user", "secret_sauce");

        // Verify successful login
        Assertions.assertTrue(
            driver.getCurrentUrl().contains("inventory.html")
        );
    }

    // @Test
    // public void invalidPasswordTest() {

    //     // Create LoginPage object
    //     LoginPage loginPage = new LoginPage(driver);

    //     // Enter invalid credentials
    //     loginPage.login("standard_user", "wrong123");

    //     // Get actual error message
    //     String actualMessage = loginPage.getErrorMessage();

    //     // Expected error message
    //     String expectedMessage =
    //         "Epic sadface: Username and password do not match any user in this service";

    //     // Verify error message
    //     Assertions.assertEquals(expectedMessage, actualMessage);
    // }

    // isse hum multiple inputs check kr sakte h ek saath rathe rthan making diff tests 
    @ParameterizedTest
    @CsvSource({
        "standard_user, wrong123",
        "wrong_user, secret_sauce",
        "wrong_user, wrong123"
    })
    public void invalidCredentialsTest(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(username, password);

        String actualMessage = loginPage.getErrorMessage();

        String expectedMessage =
            "Epic sadface: Username and password do not match any user in this service";

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}