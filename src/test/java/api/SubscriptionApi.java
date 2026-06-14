package api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SubscriptionApi {
    private final String baseUrl;

    public SubscriptionApi(String baseUrl){
        this.baseUrl=baseUrl;
    }

    public Response getAllSubscriptions(){
        return given()
                .baseUri(baseUrl)
                .when()
                .get("/subscriptions");
    }

    public Response getSubscriptionsById(int id){
        return given()
                .baseUri(baseUrl)
                .when()
                .get("/subscriptions/" + id);
    }
}
