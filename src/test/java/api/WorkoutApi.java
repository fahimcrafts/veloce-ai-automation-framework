package api;

import config.RequestSpecFactory;
import io.restassured.response.Response;
import models.Workout;

import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;

public class WorkoutApi {

    private final RequestSpecification spec;

    public WorkoutApi(String baseUrl){
        this.spec = RequestSpecFactory.getDefaultSpec(baseUrl);
    }

    public Response getAllWorkouts(){
        return given()
                .spec(spec)
                .when()
                .get("/workouts");
    }

    public Response getWorkoutById(int id) {
        return given()
                .spec(spec)
                .when()
                .get("/workouts/" + id);
    }
}
