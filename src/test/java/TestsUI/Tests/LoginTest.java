package TestsUI.Tests;

import TestsUI.Pages.Login;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private String username = "admin";
    private String password = "admin";
    private Login loginPage = new Login();
    private final String URL = "http://localhost/login";

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 5000;

        // Prevent closing the browser after the test
        Configuration.holdBrowserOpen = true;

         loginPage = new Login();
    }

    @Test
    public void TestLogin(){
        loginPage.openPage();
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLoginButton()
                .assertLogin();
    }
}
