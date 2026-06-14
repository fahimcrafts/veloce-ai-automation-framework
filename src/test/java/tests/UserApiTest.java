package tests;

import api.UserApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApiTest extends BaseTest {
    UserApi userApi;

    @BeforeEach
    public void setUp(){
        userApi = new UserApi(BASE_URL);
    }

    @Test
    public void shouldRegisterUserSuccessfully() {

        String email = "jeffn_" + System.currentTimeMillis() + "@email.com";

        Response response = userApi.registerUser("Jeff Nippard", email, "HxkSqtl!");

        assertEquals(201, response.getStatusCode());
    }

    @Test
    public void shouldReturn409WhenEmailMatchesRule(){
        String email = "s.sulek@email.com";

        Response response = userApi.registerUser("Jane Doe", email, "Password123!");

        assertEquals(409, response.getStatusCode());
    }

    @Test
    public void validUserCanLogin(){
        Response response = userApi.loginUser(
                "testuser@example.com",
                "password123"
        );

        System.out.println("Status Code: " + response.getStatusCode());

        response.prettyPrint();

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void invalidPasswordLoginDebug(){
        Response response = userApi.loginUser(
                "testuser@example.com",
                "wrongpassword"
        );

        assertEquals(401, response.getStatusCode());
        assertEquals("Invalid credentials", response.jsonPath().getString("error"));
    }
}
