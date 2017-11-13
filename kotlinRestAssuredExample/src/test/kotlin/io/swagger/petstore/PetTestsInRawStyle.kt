package io.swagger.petstore

import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.apache.commons.lang3.RandomStringUtils
import org.hamcrest.CoreMatchers
import org.junit.Test
import utils.When

class PetTestsInRawStyle {

    private val BASE_URL = "http://petstore.swagger.io/v2"
    private val apiKeyValue = "1qa2ws3ed4rfvcxz"

    @Test
    fun `Add new pet to the store`() {
        val testPetId = RandomStringUtils.randomNumeric(10)
        val testPetName = "Pet_${RandomStringUtils.randomAlphabetic(8)}"

        //Add new pet to the store
        RestAssured.given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": $testPetId,\n" +
                        "  \"name\": \"$testPetName\",\n" +
                        "  \"photoUrls\": [],\n" +
                        "  \"tags\": [],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .header("api_key", apiKeyValue)
                .post("/pet")

        //Check that pet was added
        RestAssured.given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .get("/pet/" + testPetId)
                .then()
                .body("name", CoreMatchers.equalTo(testPetName))
    }

    @Test
    fun `Delete pet by id from store`() {
        val testPetId = RandomStringUtils.randomNumeric(10)
        val testPetName = "Pet_${RandomStringUtils.randomAlphabetic(8)}"

        //Add new pet to the store
        RestAssured.given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": $testPetId,\n" +
                        "  \"name\": \"$testPetName\",\n" +
                        "  \"photoUrls\": [],\n" +
                        "  \"tags\": [],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .header("api_key", apiKeyValue)
                .post("/pet")

        //Delete pet by id from store
        RestAssured.given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .header("api_key", apiKeyValue)
                .When()
                .delete("/pet/" + testPetId)
                .then().statusCode(200)

        //Check that pet is absent
        RestAssured.given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .get("/pet/" + testPetId)
                .then()
                .body("message", CoreMatchers.equalTo("Pet not found"))
    }

}
