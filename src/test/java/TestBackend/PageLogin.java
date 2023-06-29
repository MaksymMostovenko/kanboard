package TestBackend;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin extends PageObject {
    private final By USERNAME_FIELD = By.id("username");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");

    public PageLogin(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        inputText(USERNAME_FIELD, username);
        inputText(PASSWORD_FIELD, password);
        click(LOGIN_BUTTON);
    }

    // Add more login-related methods if needed

    public boolean isLoginPageDisplayed() {
        return isDisplayed(USERNAME_FIELD) && isDisplayed(PASSWORD_FIELD) && isDisplayed(LOGIN_BUTTON);
    }
}

