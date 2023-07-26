package TestsUI.Tests;

import TestApi.ApiBackend.ApiUtility;
import TestsUI.Pages.Homepage;
import com.codeborne.selenide.Configuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomepageTest {

    ApiUtility api;
    Homepage homepage;
    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 5000;
        Configuration.holdBrowserOpen = true;
        api = new ApiUtility();
        homepage = new Homepage();
    }

    @AfterTest
    public void cleanUp() throws JsonProcessingException {
        api.removeAllProjects();
    }

    @Test
    public void createProject() throws JsonProcessingException {
        final String name = "UI_TEST_PROJECT";
        homepage.loginByAdmin();
        homepage.createProject(name);
        homepage.assertCreatedProject(name);
    }
}
