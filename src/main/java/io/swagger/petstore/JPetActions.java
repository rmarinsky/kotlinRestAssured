package io.swagger.petstore;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.entities.JPet;

import static io.restassured.RestAssured.given;

public class JPetActions {

    private RequestSpecification requestSpecification;

    public JPetActions() {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "1qa2ws3ed4rfvcxz")
                .setBaseUri("http://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }

    public JPet addNewPet(JPet petRequest) {
            return given(requestSpecification)
                    .body(petRequest)
                    .post("/pet").as(JPet.class);
    }
}
