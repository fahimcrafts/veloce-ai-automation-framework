package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class MealApi {

    private final String baseUrl;

    public MealApi(String baseUrl){
        this.baseUrl=baseUrl;
    }

    public Response getAllMealPlans(){
        return given()
                .baseUri(baseUrl)
                .when()
                .get("/meal-plans");
    }

    public Response getMealPlanById(int id){
        return given()
                .baseUri(baseUrl)
                .when()
                .get("/meal-plans/" + id);
    }
}
