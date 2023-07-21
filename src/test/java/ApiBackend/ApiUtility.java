package ApiBackend;


import ApiBackend.payload.Payload;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ApiUtility {

    Payload payload = new Payload();

    @Test
    public void test() throws JsonProcessingException {
        System.out.println(payload.createUser("NewUser#1","password#2"));
    }

    public ApiUtility createUser() throws JsonProcessingException {
        String payLoad = payload.createUser("NewUser#1","password#2");

        Response createUser = RestAssured.given()
                .baseUri("http://127.0.0.1/jsonrpc.php")
                .auth().basic("jsonrpc", "f03c81a80c56b4186843dda6af10ae99e4e2426b91906936c4a7c37c0145")
                .header("Content-Type", "application/json")
                .body(payLoad)
                .post();
        createUser.then().statusCode(200);
//        createUser.then().extract().body();
        return this;
    }



}