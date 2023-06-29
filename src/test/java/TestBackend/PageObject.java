package TestBackend;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
        protected WebDriver driver;
        protected WebDriverWait wait;
        private final int ACTION_TIMEOUT = 3;

        public PageObject(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, ACTION_TIMEOUT);
        }

        protected WebElement getElement(By locator) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        protected void click(By locator) {
            getElement(locator).click();
        }

        protected void inputText(By locator, String text) {
            WebElement element = getElement(locator);
            element.clear();
            element.sendKeys(text);
        }

        protected String getText(By locator) {
            return getElement(locator).getText();
        }

        protected boolean isDisplayed(By locator) {
            try {
                return getElement(locator).isDisplayed();
            } catch (TimeoutException e) {
                return false;
            }
        }

        // Add more common actions or utility methods as needed
}

