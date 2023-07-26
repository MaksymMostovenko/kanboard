package TestApi;

import TestsUI.Pages.PageObject;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class ApiToken extends PageObject {
    public ApiToken(){
        Configuration.browser = "chrome";
        Configuration.headless = true;
        Configuration.timeout = 5000;
    }
    public String get(){
        final By tokenPlace = By.xpath("//*[@id=\"config-section\"]/div[2]/div[2]");
        Selenide.open("http://localhost");
        isLoginPage();
        return getTextFromElement(tokenPlace);
    }
}
