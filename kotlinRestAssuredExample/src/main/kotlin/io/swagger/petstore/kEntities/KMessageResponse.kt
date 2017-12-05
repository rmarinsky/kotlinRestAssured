package io.swagger.petstore.kEntities
import com.fasterxml.jackson.annotation.JsonProperty


data class KMessageResponse(
		@JsonProperty("code") var code: Int = 0, //1
		@JsonProperty("type") var type: String = "", //error
		@JsonProperty("message") var message: String = "" //Pet not found
)