package ApiBackend;


import ApiBackend.payload.CreateUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiUtility {

    public static void main(String[] args) throws JsonProcessingException {
        String createUserMethod = "createUser";
        String createUserJsonrpc = "2.0";
        Integer createUserId = 1518863034;

        String username = "user";
        String password = "password";


//        CreateUser user = CreateUser.builder()
//                .jsonrpc(createUserJsonrpc)
//                .method(createUserMethod)
//                .id(createUserId)
//                .credentials(CreateUser.Credentials.builder()
//                        .username(username)
//                        .password(password)
//                        .build())
//                .build();
        String payLoad = "{\n" +
                "    \"jsonrpc\": \"2.0\",\n" +
                "    \"method\": \"createUser\",\n" +
                "    \"id\": 1518863034,\n" +
                "    \"params\": {\n" +
                "        \"username\": \"biloute\",\n" +
                "        \"password\": \"123456\"\n" +
                "    }\n" +
                "}";
//        ObjectMapper objectMapper = new ObjectMapper();
//        String payLoad = objectMapper.writeValueAsString(user);
//        System.out.println(payLoad);
        Response createUser = RestAssured.given()
                .baseUri("http://127.0.0.1/jsonrpc.php")
                .auth().basic("jsonrpc", "f03c81a80c56b4186843dda6af10ae99e4e2426b91906936c4a7c37c0145")
                .header("Content-Type", "application/json")
                .body(payLoad)
                .post();
        createUser.then().statusCode(200);

//        System.out.println(user.getCredentials().getPassword());
    }


    public ApiUtility getCreateUser(String username, String password){
        String createUserMethod = "createUser";
        String createUserJsonrpc = "2.0";
        Integer createUserId = 1518863034;


        CreateUser user = CreateUser.builder()
                    .jsonrpc(createUserJsonrpc)
                    .method(createUserMethod)
                    .id(createUserId)
                    .credentials(CreateUser.Credentials.builder()
                            .username(username)
                            .password(password)
                            .build())
                    .build();
        return this;
    }
}