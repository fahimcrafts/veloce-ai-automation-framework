package tests;

import api.UserApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApiTest extends BaseTest {
    @Test
    public void shouldRegisterUserSuccessfully() {
        UserApi userApi = new UserApi(BASE_URL);

        Response response = userApi.registerUser("Jeff Nippard", "jeffn@email.com");

        assertEquals(response.getStatusCode(), 201);
    }
}
