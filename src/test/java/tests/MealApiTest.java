package tests;

import api.MealApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MealApiTest extends BaseTest {

    MealApi mealApi = new MealApi(BASE_URL);

    @Test
    void shouldReturnAllMealPlans(){
        Response response = mealApi.getAllMealPlans();

        assertEquals(200, response.getStatusCode());

        response.then()
                .body("[0].id", notNullValue())
                .body("[0].name", notNullValue());
    }

    @Test
    void shouldReturnSingleMealPlanById(){
        Response all = mealApi.getAllMealPlans();
        int id = all.jsonPath().getInt("[0].id");

        mealApi.getMealPlanById(id)
                .then()
                .statusCode(200)
                .body("id", equalTo(id));
    }
}
