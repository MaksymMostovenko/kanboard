package ApiBackend.payload;

import ApiBackend.payload.builders.CreateTask;
import ApiBackend.payload.builders.CreateUser;
import ApiBackend.payload.builders.RemoveUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Payload {
    String PLACEHOLDER = "";
    String CREATE_USER_METHOD = "createUser";
    String JSONRPC = "2.0";
    Integer CREATE_USER_ID = 1518863034;
    public String createUser(String username, String password) throws JsonProcessingException {
        CreateUser request = CreateUser.builder()
                .jsonrpc(JSONRPC)
                .method(CREATE_USER_METHOD)
                .id(CREATE_USER_ID)
                .params(CreateUser.params.builder()
                        .username(username)
                        .password(password)
                        .build())
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(request);
        return jsonString;
    }
    public String deleteUser(String userId) throws JsonProcessingException {
        RemoveUser request = RemoveUser.builder()
                .jsonrpc("2.0")
                .method("removeUser")
                .id(2094191872)
                .params(RemoveUser.Params.builder().user_id(userId).build())
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(request);
        return jsonString;
    }

    public String createNewTask() throws JsonProcessingException {
        CreateTask task = CreateTask.builder()
                .jsonrpc("2.0")
                .method("createTask")
                .id(1176509098L)
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
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(task);
        return jsonString;
    }

    public String deleteTask(String userId) throws JsonProcessingException {
        // todo
        return PLACEHOLDER;
    }



}
