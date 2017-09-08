package io.swagger.petstore

import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import io.swagger.petstore.entities.KMessageResopnse
import io.swagger.petstore.entities.KPet
import utils.As

class KPetActions {

    private var requestSpecification: RequestSpecification? = null

    init {
        requestSpecification = RequestSpecBuilder()
                .addHeader("api_key", "1qa2ws3ed4rfvcxz")
                .setBaseUri("http://petstore.swagger.io")
                .setBasePath("/v2/pet")
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build()
    }

    fun addNewPet(pet: KPet): KPet {
        return RestAssured.given(requestSpecification)
                .body(pet)
                .post().As()
    }

    fun deletePet(pet: KPet) {
        RestAssured.given(requestSpecification)
                .delete(pet.id)
    }

    fun petIsAbsent(pet: KPet): Boolean {
        return RestAssured.given(requestSpecification)
                .get(pet.id)
                .then().extract().body().As<KMessageResopnse>()
                .message.equals("Pet not found")
    }

}