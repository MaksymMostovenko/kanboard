package TestsUI.Tests;

import TestApi.ApiBackend.ApiUtility;
import TestsUI.Pages.TaskPage;
import com.codeborne.selenide.Configuration;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.*;

public class TaskTest {

    public static final String COMENT = "Capstone Coment. The quick brown fox jumps over the lazy dog.";
    TaskPage page;
    private ApiUtility api;
    private String ADMIN = "admin";
    private final String USERNAME = "SadUser";
    private final String PASSWORS ="TestPassword";
    private final String PROJECT = "TIRED PROJECT";
    public static final String STUPID_TASK = "StupidTask";
    private String token;

    @BeforeClass
    public void startUp() throws JsonProcessingException {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 5000;
        // Prevent closing the browser after the test
        Configuration.holdBrowserOpen = true;

        this.page = new TaskPage();
        this.api = new ApiUtility();
        api.removeAllUsers();
        api.removeAllProjects();
        page.addUser(USERNAME,PASSWORS);
        page.openPage(ADMIN,ADMIN);
        this.token = page.getUserToken(USERNAME);
        page.logout();
        page.openPage(USERNAME,PASSWORS);
        page.addProject(PROJECT,USERNAME,this.token);
    }

    @AfterClass
    public void clean() throws JsonProcessingException {
        api.removeAllProjects();
        api.removeAllUsers();
    }

    @Test
    public void userAbleCreateTask() throws JsonProcessingException {
        page.addTask(STUPID_TASK);
        page.assertTaskAdd();
    }

    @Test(dependsOnMethods = "userAbleCreateTask")
    public void userAbleAddTaskComments(){
        page.addComment(COMENT);
        page.assertCommentAdd(COMENT);
    }

    @Test(dependsOnMethods = "userAbleAddTaskComments")
    public void userAbleCloseTask(){
        page.closeTask().assertTaskClosed();
    }
}

