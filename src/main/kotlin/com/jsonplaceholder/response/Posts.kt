package com.jsonplaceholder.response

import com.fasterxml.jackson.annotation.JsonProperty
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class Posts(

	@field:JsonProperty("id")
	val id: Int? = null,

	@field:JsonProperty("title")
	val title: String? = null,

	@field:JsonProperty("body")
	val body: String? = null,

	@field:JsonProperty("userId")
	val userId: Int? = null
)