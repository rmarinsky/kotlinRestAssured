package io.swagger.petstore;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.swagger.petstore.jEntities.JMessageResponse;
import io.swagger.petstore.jEntities.JPet;

import static io.restassured.RestAssured.given;

class PetActions {

    private RequestSpecification requestSpecification;

    PetActions() {
        requestSpecification = new RequestSpecBuilder()
                .addHeader("api_key", "1qa2ws3ed4rfvcxz")
                .setBaseUri("http://petstore.swagger.io")
                .setBasePath("/v2/pet")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }

    JPet addNewPet(JPet petRequest) {
        return given(requestSpecification)
                .body(petRequest)
                .post().as(JPet.class);
    }

    void deletePet(JPet pet) {
        given(requestSpecification)
                .delete(pet.getId());
    }

    JMessageResponse getAbsentPet(JPet pet) {
        return given(requestSpecification)
                .get(pet.getId())
                .then()
                .extract().body().as(JMessageResponse.class);
    }

}
