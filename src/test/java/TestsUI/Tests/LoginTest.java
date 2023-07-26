package TestsUI.Tests;

import TestsUI.Pages.Login;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private String username = "admin";
    private String password = "admin";
    private final String badUsername = "qwrt43";
    private final String badPassword = "adik34";
    private Login loginPage = new Login();

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 5000;

        // Prevent closing the browser after the test
        Configuration.holdBrowserOpen = true;

        this.loginPage = new Login();
        loginPage.openPage();
    }

    @Test(dependsOnMethods = "badLogin")
    public void TestLogin(){
        loginPage.enterUsername(username)
                .enterPassword(password)
                .clickLoginButton()
                .assertLogin();
    }

    @Test
    public void badLogin(){
        loginPage.enterUsername(badUsername)
                .enterPassword(password)
                .clickLoginButton()
                .assertBadLogin();
    }
}
