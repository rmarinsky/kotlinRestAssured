package io.swagger.petstore

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import io.swagger.petstore.kEntities.MessageResopnse
import io.swagger.petstore.kEntities.Pet
import utils.As

class PetActions {

    private var requestSpecification: RequestSpecification? = null

    init {
        requestSpecification = RequestSpecBuilder()
                .addHeader("api_key", "1qa2ws3ed4rfvcxz")
                .setBaseUri("http://petstore.swagger.io")
                .setBasePath("/v2/pet")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build()
    }

    fun addNewPet(pet: Pet): Pet {
        return RestAssured.given(requestSpecification)
                .body(pet)
                .post().As()
    }

    fun deletePet(pet: Pet) {
        RestAssured.given(requestSpecification)
                .delete(pet.id)
    }

    fun getAbsentPet(pet: Pet): MessageResopnse {
        return RestAssured.given(requestSpecification)
                .get(pet.id)
                .then()
                .extract().body().As()
    }

}