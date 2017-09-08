package io.swagger.petstore

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.apache.commons.lang3.RandomStringUtils
import org.hamcrest.CoreMatchers
import org.junit.Test

class KPetTestsRawStyle {

    private val BASE_URL = "http://petstore.swagger.io/v2"

    @Test fun `add new pet to store`() {
        val testPetId = RandomStringUtils.randomNumeric(10)
        val testPetName = "Pet_${RandomStringUtils.randomAlphabetic(8)}"
        RestAssured.given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": $testPetId,\n" +
                        "  \"name\": \"$testPetId\",\n" +
                        "  \"photoUrls\": [],\n" +
                        "  \"tags\": [],\n" +
                        "  \"status\": \"available\"\n" +
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
