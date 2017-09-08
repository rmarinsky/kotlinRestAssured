package io.swagger.petstore.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class KPet(
        @field:JsonProperty("photoUrls")
        val photoUrls: List<String?>? = null,

        @field:JsonProperty("name")
        var name: String? = null,

        @field:JsonProperty("id")
        var id: String? = null,

        @field:JsonProperty("category")
        val category: KCategory? = null,

        @field:JsonProperty("tags")
        val tags: List<KTag?>? = null,

        @field:JsonProperty("status")
        var status: String? = null
)