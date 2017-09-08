package io.swagger.petstore;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class JPetTests {

    private String BASE_URL = "http://petstore.swagger.io/v2";


    @Test
    public void test(){
        String testPetId = "898988888", testPetName = "MyLittlePet";
        given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"id\": "+ testPetId + ",\n" +
                        "  \"name\": \""+ testPetName + "\",\n" +
                        "  \"photoUrls\": [],\n" +
                        "  \"tags\": [],\n" +
                        "  \"status\": \"pending\"\n" +
                        "}")
                .header("api_key", "1qa2ws3ed4rfvcxz")
                .post("/pet");

        given()
                .baseUri(BASE_URL)
                .log().everything()
                .contentType(ContentType.JSON)
                .pathParam("petId", testPetId)
                .get("/pet/{petId}")
                .then()
                .body("name", equalTo(testPetName))
                .extract().body().jsonPath()
                .prettyPrint();
    }
}
