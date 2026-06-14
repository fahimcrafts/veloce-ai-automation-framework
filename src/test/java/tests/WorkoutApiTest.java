package tests;

import api.WorkoutApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class WorkoutApiTest extends BaseTest {

    WorkoutApi workoutApi = new WorkoutApi(BASE_URL);

    @Test
    @DisplayName("Validate workout workflow using API chaining")
    void shouldValidateWorkoutWorkFlow() {

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
