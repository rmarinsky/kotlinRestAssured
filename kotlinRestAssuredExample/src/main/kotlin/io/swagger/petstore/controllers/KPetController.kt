package io.swagger.petstore.controllers

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.swagger.petstore.models.KPet
import utils.As

class KPetController {

    init {
        RestAssured.requestSpecification = RequestSpecBuilder()
                .addHeader("api_key", "1qa2ws3ed4rfvcxz")
                .setBaseUri("http://petstore.swagger.io")
                .setBasePath("/v2/pet")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build()
    }

    fun addNewPet(pet: KPet): KPet {
        return RestAssured.given()
                .body(pet)
                .post().As()
    }

    fun deletePet(pet: KPet) {
        RestAssured.given()
                .delete(pet.id.toString())
    }

    fun getPet(pet: KPet): KPet.Message {
        return RestAssured.given()
                .get(pet.id.toString())
                .then()
                .extract().body().As()
    }

}
