package TestsUI.Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.Wait;


public class PageObject {
    private static final int WAIT_TIME_SEC = 1;

    public PageObject() {
        timeout = WAIT_TIME_SEC * 5000; // Convert seconds to milliseconds
    }

    public SelenideElement getElement(By by) {
        return $(by).shouldBe(visible);
    }

    public PageObject clickElement(By by) {
        $(by).shouldBe(visible).shouldBe(enabled).click();
        return this;
    }

    public PageObject enterText(By by, String text) {
        $(by).shouldBe(visible).shouldBe(enabled).clear();
        $(by).shouldBe(visible).shouldBe(enabled).val(text);
        return this;
    }

    public void isLoginPage() {
        final String ADMIN = "admin";
        final String PASSWORD = "admin";
        final By USER_INPUT = By.xpath("//*[@id=\"form-username\"]");
        final By PASS_INPUT = By.xpath("//*[@id=\"form-password\"]");
        final By SUBMIT = By.xpath("/html/body/div/form/div[1]/button");
        final String apiSettUrl = "http://localhost/settings/api";
        final String loginPageUrl = "http://localhost/login";

        String currentURL = com.codeborne.selenide.WebDriverRunner.url();
        if (currentURL.equals(loginPageUrl)) {
            enterText(USER_INPUT, ADMIN);
            enterText(PASS_INPUT, PASSWORD);
            clickElement(SUBMIT);
            goToURL(apiSettUrl);
        } else {
            goToURL(apiSettUrl);
        }
    }

    public String getTextFromElement(By by) {
        String elementText = getElement(by).getText();
        Pattern pattern = Pattern.compile("API token: ([a-zA-Z0-9]+)");
        Matcher matcher = pattern.matcher(elementText);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            throw new RuntimeException("No API token found in the element text.");
        }
    }
    public void goToURL(String url) {
        Selenide.open(url);
    }

    public String getUrl() throws InterruptedException {
        Wait().wait(1000);
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }
}
//  //*[@id="config-section"]/div[2]/div[2]/ul/li[1]/strong