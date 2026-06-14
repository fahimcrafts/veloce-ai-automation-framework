package api;

import config.RequestSpecFactory;
import io.restassured.response.Response;
import models.Workout;

import static io.restassured.RestAssured.given;
import io.restassured.specification.RequestSpecification;

public class WorkoutApi {

    private final RequestSpecification spec;
    private String authToken;

    public WorkoutApi(String baseUrl){
        this.spec = RequestSpecFactory.getDefaultSpec(baseUrl);
    }

    public Response getAllWorkouts(){
        return given()
                .spec(spec)
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/workouts");
    }

    public Response getWorkoutById(int id) {
        return given()
                .spec(spec)
                .when()
                .get("/workouts/" + id);
    }

    public void setAuthToken(String token){
        this.authToken = token;
    }
}
