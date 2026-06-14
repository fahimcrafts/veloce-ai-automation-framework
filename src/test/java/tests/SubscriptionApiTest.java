package tests;

import api.SubscriptionApi;
import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubscriptionApiTest extends BaseTest {
    SubscriptionApi subscriptionApi = new SubscriptionApi(BASE_URL);

    @Test
    void shouldReturnAllSubscriptions(){
        Response response = subscriptionApi.getAllSubscriptions();

        assertEquals(200, response.getStatusCode());

        response.then()
                .body("[0].id", notNullValue())
                .body("[0].type", notNullValue());
    }

    @Test
    void shouldReturnSingleSubscriptionById(){
        Response all = subscriptionApi.getAllSubscriptions();
        int id = all.jsonPath().getInt("[0].id");

        subscriptionApi.getSubscriptionsById(id)
                .then()
                .statusCode(200)
                .body("id", equalTo(id));
    }
}
