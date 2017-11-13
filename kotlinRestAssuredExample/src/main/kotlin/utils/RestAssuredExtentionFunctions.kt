package utils

import io.restassured.response.ResponseBodyExtractionOptions
import io.restassured.specification.RequestSpecification

fun RequestSpecification.When(): RequestSpecification {
    return this.`when`()
}

inline fun <reified T> ResponseBodyExtractionOptions.As(): T {
    return this.`as`(T::class.java)
}