package TestsUI.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.$;

public class PageObject {
    private static final int WAIT_TIME_SEC = 1;

    public PageObject() {
        timeout = WAIT_TIME_SEC * 1000; // Convert seconds to milliseconds
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
}
