package tests;

import api.UserApi;
import api.WorkoutApi;
import base.BaseTest;
import config.ApiFactory;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class WorkoutApiTest extends BaseTest {
    @Test
    @DisplayName("Validate authenticated workout workflow using API chaining")
    void shouldValidateWorkoutWorkFlow() {

        ApiFactory apiFactory = new ApiFactory(BASE_URL);

        WorkoutApi workoutApi = apiFactory.workoutApi();
        UserApi userApi = apiFactory.userApi();

        userApi.loginUser("testuser@example.com", "password123");

        Response response = workoutApi.getAllWorkouts();

        int id = response.jsonPath()
                .getInt("[0].id");

        workoutApi.getWorkoutById(id)
                .then()
                .statusCode(200)
                .body("id", equalTo(id))
                .body("name", notNullValue())
                .body("duration", greaterThan(0));
    }
}
