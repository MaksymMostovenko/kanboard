package TestBackend;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.$;

public class PageObject {
    private static final int DEFAULT_TIMEOUT_SECONDS = 3;

    protected void click(String selector) {
        $(selector).shouldBe(Condition.visible).click();
    }

    protected void setValue(String selector, String value) {
        $(selector).shouldBe(Condition.visible).setValue(value);
    }

    protected String getText(String selector) {
        return $(selector).shouldBe(Condition.visible).getText();
    }

    protected void waitForElementVisible(String selector) {
        $(selector).shouldBe(Condition.visible);
    }

    protected void waitForElementText(String selector, String expectedText) {
        $(selector).shouldBe(Condition.text(expectedText));
    }

    protected void waitForElementNotVisible(String selector) {
        $(selector).shouldNotBe(Condition.visible);
    }

    // Additional methods for commonly used actions can be added here
}


