package TestBackend;

import static com.codeborne.selenide.Selenide.$;

public class PageLogin extends PageObject {
    private static final String USERNAME_FIELD = "#username";
    private static final String PASSWORD_FIELD = "#password";
    private static final String LOGIN_BUTTON = "#login-button";
    private static final String ERROR_MESSAGE = "#error-message";

    public void enterUsername(String username) {
        setValue(USERNAME_FIELD, username);
    }

    public void enterPassword(String password) {
        setValue(PASSWORD_FIELD, password);
    }

    public void clickLoginButton() {
        click(LOGIN_BUTTON);
    }

    public String getErrorMessage() {
        return getText(ERROR_MESSAGE);
    }
}
