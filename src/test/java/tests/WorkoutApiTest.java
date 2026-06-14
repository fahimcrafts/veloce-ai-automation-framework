package tests;

import api.UserApi;
import api.WorkoutApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class WorkoutApiTest extends BaseTest {
    @Test
    @DisplayName("Validate authenticated workout workflow using API chaining")
    void shouldValidateWorkoutWorkFlow() {

        UserApi userApi = new UserApi(BASE_URL);
        WorkoutApi workoutApi = new WorkoutApi(BASE_URL);

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
