package TestsUI.Tests;

import TestsUI.Pages.Login;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.*;

@Listeners({AllureTestNg.class})
public class LoginTest {
    private final String password = "admin";
    private Login loginPage;

    @BeforeClass
    @Parameters({ "browser", "headless" })
    public void setUp(@Optional("chrome") String browser, @Optional("true") boolean headless) {
        Configuration.browser = browser;
        Configuration.headless = headless;
        Configuration.timeout = 5000;
        // Prevent closing the browser after the test. TRUE for debug.
        Configuration.holdBrowserOpen = true;
        loginPage = new Login();
    }

    @Test(priority = 1)
    public void badLogin(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        String badUsername = "qwrt43";
        loginPage.openPage()
                .enterUsername(badUsername)
                .enterPassword(password)
                .clickLoginButton()
                .assertBadLogin();
    }

    @Test(priority = 2)
    public void TestLogin(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        String username = "admin";
        loginPage.openPage()
                .enterUsername(username)
                .enterPassword(password)
                .clickLoginButton()
                .assertLogin();
    }
}
