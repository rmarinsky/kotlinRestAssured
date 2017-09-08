package io.swagger.petstore.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class KCategory(

	@field:JsonProperty("name")
	val name: String? = null,

	@field:JsonProperty("id")
	val id: Int? = null
)