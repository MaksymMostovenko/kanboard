package TestsUI;

import TestBackend.DockerAppVerification;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private LoginTest loginPage;

    @BeforeClass
    public void setup() {
        // Set up the Selenide configuration
        Configuration.startMaximized = true;
        Configuration.baseUrl = "http://127.0.0.1/login";
        Configuration.timeout = 5000; // Timeout in milliseconds

        // Verify that Docker runs.
        new DockerAppVerification();
        DockerAppVerification.dockerAppVerification();

        // Initialize the LoginPage object
        loginPage = new LoginTest();
    }

    @Test
    public void testLoginWithValidCredentials() {
        System.out.println("Test");
    }
//
//    @Test
//    public void testLoginWithInvalidCredentials() {
//        String username = "invalid_username";
//        String password = "invalid_password";
//
//        // Open the login page
//        loginPage.open();
//
//        // Enter the username and password
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//
//        // Click the login button
//        loginPage.clickLoginButton();
//
//        // Assert the error message is displayed
//        String errorMessage = loginPage.getErrorMessage();
//        // Perform your assertions here
//    }
}