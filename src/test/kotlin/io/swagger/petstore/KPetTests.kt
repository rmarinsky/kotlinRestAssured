package io.swagger.petstore

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.hamcrest.CoreMatchers
import org.junit.Test

class KPetTests {

    private val BASE_URL = "http://petstore.swagger.io/v2"

    @Test fun test() {
        val testPetId = "898988888"
        val testPetName = "MyLittlePet"
        RestAssured.given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": $testPetId,\n" +
                        "  \"name\": \"$testPetId\",\n" +
                        "  \"photoUrls\": [],\n" +
                        "  \"tags\": [],\n" +
                        "  \"status\": \"pending\"\n" +
                        "}")
                .header("api_key", "1qa2ws3ed4rfvcxz")
                .post("/pet")

        RestAssured.given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .pathParam("petId", testPetId)
                .get("/pet/{petId}")
                .then()
                .body("name", CoreMatchers.equalTo(testPetName))
                .extract().body().jsonPath()
                .prettyPrint()
    }

}
