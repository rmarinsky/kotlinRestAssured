package io.swagger.petstore;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetTestsInRawStyle {

    private String BASE_URL = "http://petstore.swagger.io/v2",
            apiKeyValue = "1qa2ws3ed4rfvcxz";

    @Test
    public void addNewPetToStoreTest() {
        String testPetId = RandomStringUtils.randomNumeric(10),
                testPetName = "Pet_" + RandomStringUtils.randomAlphabetic(10);

        //Add new pet to the store
        RestAssured.given().baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": " + testPetId + ",\n" +
                        "  \"name\": \"" + testPetName + "\",\n" +
                        "  \"photoUrls\": [],\n" +
                        "  \"tags\": [],\n" +
                        "  \"status\": \"pending\"\n" +
                        "}")
                .header("api_key", apiKeyValue)
                .post("/pet")
                .then()
                .body("name", CoreMatchers.equalTo(testPetName))
                .and()
                .body("id", Matchers.hasToString(testPetId));
    }

    @Test
    public void deletePetById() {
        String testPetId = RandomStringUtils.randomNumeric(10),
                testPetName = "Pet_" + RandomStringUtils.randomAlphabetic(10);

        //Add new pet to the store
        given().baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": " + testPetId + ",\n" +
                        "  \"name\": \"" + testPetName + "\",\n" +
                        "  \"photoUrls\": [],\n" +
                        "  \"tags\": [],\n" +
                        "  \"status\": \"pending\"\n" +
                        "}")
                .header("api_key", apiKeyValue)
                .post("/pet");

        //Delete pet by id from store
        given().baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .header("api_key", apiKeyValue)
                .when()
                .delete("/pet/" + testPetId);

        //Check that pet is absent
        given().baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .get("/pet/" + testPetId)
                .then()
                .body("message", equalTo("Pet not found"));
    }

}
