package ApiBackend.payload;

import ApiBackend.payload.builders.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Payload {
    public static final String JSONRPC = "2.0";
    public static final String CREATE_PROJECT = "createProject";
    public static final String REMOVE_PROJECT = "removeProject";
    public static final String REMOVE_TASK = "removeTask";
    public static final String CREATE_TASK = "createTask";
    public static final String REMOVE_USER = "removeUser";
    public static final String CREATE_USER_METHOD = "createUser";
    public static final Integer CREATE_USER_ID = 1518863034;
    public static final int REMOVE_USER_ID = 2094191872;
    public static final long CREATE_TASK_ID = 1176509098L;
    public static final long REMOVE_TASK_ID = 1423501287L;
    public static final long CREATE_PROJECT_ID = 1797076613L;
    public static final long REMOVE_PROJECT_ID = 46285125L;
    public static final String GET_USER_BY_NAME = "getUserByName";
    public static final long GET_USER_BY_NAME_ID = 1769674782L;
    public static final String GET_ALL_USERS = "getAllUsers";
    public static final int GET_ALL_USERS_ID = 1438712131;

    String PLACEHOLDER = "";
    public String createUser(String username, String password) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(CreateUser.builder()
                .jsonrpc(JSONRPC)
                .method(CREATE_USER_METHOD)
                .id(CREATE_USER_ID)
                .params(CreateUser.params.builder()
                        .username(username)
                        .password(password)
                        .build())
                .build());
    }
    public String removeUser(Integer userId) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(RemoveUser.builder()
                .jsonrpc(JSONRPC)
                .method(REMOVE_USER)
                .id(REMOVE_USER_ID)
                .params(RemoveUser.Params.builder().user_id(userId).build())
                .build());
    }

    public String createNewTask() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(CreateTask.builder()
                .jsonrpc(JSONRPC)
                .method(CREATE_TASK)
                .id(CREATE_TASK_ID)
                .params(CreateTask.Params.builder()
                        .owner_id(1)
                        .creator_id(0)
                        .date_due("")
                        .description("")
                        .category_id(0)
                        .score(0)
                        .title("Test")
                        .project_id(1)
                        .color_id("green")
                        .column_id(2)
                        .recurrence_status(0)
                        .recurrence_trigger(0)
                        .recurrence_factor(0)
                        .recurrence_timeframe(0)
                        .recurrence_basedate(0)
                        .build())
                .build());
    }

    public String deleteTask(Integer taskId) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(
                RemoveTask.builder()
                        .jsonrpc(JSONRPC)
                        .method(REMOVE_TASK)
                        .id(REMOVE_TASK_ID)
                        .params(RemoveTask.Params.builder().task_id(taskId).build())
                        .build());
    }

    public String createProject(String projectName) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(CreateProject.builder()
                .jsonrpc(JSONRPC)
                .method(CREATE_PROJECT)
                .id(CREATE_PROJECT_ID)
                .params(CreateProject.Params.builder().name(projectName).build())
                .build());
    }
    public String removeProject(Integer projectId) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(RemoveProject.builder()
                .jsonrpc(JSONRPC)
                .method(REMOVE_PROJECT)
                .id(REMOVE_PROJECT_ID)
                .params(RemoveProject.Params.builder().project_id(projectId).build())
                .build()
                .toString());
    }

    public String getUserByName(String username) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(
                RequestUserByName.builder()
                        .jsonrpc(JSONRPC)
                        .method(GET_USER_BY_NAME)
                        .id(GET_USER_BY_NAME_ID)
                        .params(RequestUserByName.Params.builder().username(username).build())
                        .build());
    }

    public String getAllUsers() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(
                GetAllUsers.builder()
                        .jsonrpc(JSONRPC)
                        .method(GET_ALL_USERS)
                        .id(GET_ALL_USERS_ID)
                        .build());
    }

//    public String getTaskByName(String taskName){
//
//    }
}
