package com.jsonplaceholder

import com.jsonplaceholder.response.Posts
import io.restassured.RestAssured
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.junit.Test
import utils.As
import utils.When

class PostsTests {

    private val spec: RequestSpecification = RequestSpecBuilder()
            .setBaseUri("http://jsonplaceholder.typicode.com")
            .setBasePath("/posts/")
            .setContentType(ContentType.JSON)
            .build()

    @Test fun `check that posts should have correct size`(){
        val posts = RestAssured.given(spec)
                .When()
                .get()
                .then()
                .statusCode(200)
                .extract().response().As<List<Posts>>()
        println(posts[0].body)
    }

}
