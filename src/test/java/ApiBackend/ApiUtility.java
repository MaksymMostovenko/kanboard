package ApiBackend;


import ApiBackend.payload.Payload;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.List;

public class ApiUtility {
    public static final String JSONRPC = "jsonrpc";
    public static final String AUTH_TOKEN = "fabab672f147a3b52f9cec09180b36da0927f605e4ac7025284719303b91";
    private static final Integer HTTP_SUCCESS_CODE = 200;
    private static final String  ENDPOINT = "http://127.0.0.1/jsonrpc.php";


    Payload payload;
    public ApiUtility(){
        this.payload = new Payload();
    }


    public ApiUtility createUser(String username, String password) throws JsonProcessingException {
        RestAssured.given()
                .baseUri(ENDPOINT)
                .auth().basic(JSONRPC, AUTH_TOKEN)
                .header("Content-Type", "application/json")
                .body(payload.createUser(username,password))
                .post()
                .then()
                .statusCode(HTTP_SUCCESS_CODE);
        return this;
    }

    public ApiUtility removeUser(Integer userId) throws JsonProcessingException {
        RestAssured.given()
                .baseUri(ENDPOINT)
                .auth().basic(JSONRPC, AUTH_TOKEN)
                .header("Content-Type", "application/json")
                .body(payload.removeUser(userId))
                .post()
                .then()
                .statusCode(HTTP_SUCCESS_CODE);
        return this;
    }

    public ApiUtility createTask() throws JsonProcessingException {
        RestAssured.given()
                .baseUri(ENDPOINT)
                .auth().basic(JSONRPC, AUTH_TOKEN)
                .header("Content-Type", "application/json")
                .body(payload.createNewTask())
                .post()
                .then().statusCode(HTTP_SUCCESS_CODE);
        return this;
    }

    public ApiUtility deleteTask(Integer taskId) throws JsonProcessingException {
        RestAssured.given()
                .baseUri(ENDPOINT)
                .auth().basic(JSONRPC, AUTH_TOKEN)
                .header("Content-Type", "application/json")
                .body(payload.deleteTask(taskId))
                .post()
                .then().statusCode(HTTP_SUCCESS_CODE);
        return this;
    }

    public ApiUtility createProject(String projName) throws JsonProcessingException {
        RestAssured.given()
                .baseUri(ENDPOINT)
                .auth().basic(JSONRPC, AUTH_TOKEN)
                .header("Content-Type", "application/json")
                .body(payload.createProject(projName))
                .post()
                .then().statusCode(HTTP_SUCCESS_CODE);
        return this;
    }

    public ApiUtility removeProject(Integer projId) throws JsonProcessingException {
        RestAssured.given()
                .baseUri(ENDPOINT)
                .auth().basic(JSONRPC, AUTH_TOKEN)
                .header("Content-Type", "application/json")
                .body(payload.removeProject(projId))
                .post()
                .then().statusCode(HTTP_SUCCESS_CODE);
        return this;
    }

    public void removeAllUsers() throws JsonProcessingException {
        Response allUsers = RestAssured.given()
                .baseUri(ENDPOINT)
                .auth().basic(JSONRPC, AUTH_TOKEN)
                .header("Content-Type", "application/json")
                .body(payload.getAllUsers())
                .post();

        List<Object> resultList = allUsers.getBody().jsonPath().getList("result.id");
        String resultString = allUsers.getBody().jsonPath().getString("result.id");
        System.out.println("Result String: " + resultString);

        String cleanString = resultString.replaceAll("[\\[\\] ]", "");
        String[] digitStrings = cleanString.split(",");

        for (String digitString : digitStrings) {
            int id = Integer.parseInt(digitString);
            if(id != 1) {
                removeUser(id);
            }
        }
    }
}