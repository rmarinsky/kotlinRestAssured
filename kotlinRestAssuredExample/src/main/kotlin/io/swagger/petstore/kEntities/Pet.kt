package io.swagger.petstore.kEntities

data class Pet(
        val photoUrls: List<String?>? = null,
        var name: String? = null,
        var id: String? = null,
        val category: Category? = null,
        val tags: List<Tag?>? = null,
        var status: String? = null
)