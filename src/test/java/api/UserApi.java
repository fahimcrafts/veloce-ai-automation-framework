package api;

import config.RequestSpecFactory;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UserApi {
    private final RequestSpecification spec;

    public UserApi(String baseUrl){
        this.spec = RequestSpecFactory.getDefaultSpec(baseUrl);
    }

    public Response registerUser(String name, String email, String password){
        Map<String, String> requestBody = new HashMap<>();

        requestBody.put("name", name);
        requestBody.put("email", email);
        requestBody.put("password", password);

        return given()
                .spec(spec)
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/users/register");
    }

}

