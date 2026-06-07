package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {
    public static RequestSpecification getDefaultSpec(String baseUrl){
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .log(LogDetail.ALL)
                .build();
    }
}
