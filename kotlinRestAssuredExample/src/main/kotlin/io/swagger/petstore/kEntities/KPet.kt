package io.swagger.petstore.kEntities

data class KPet(
        val photoUrls: List<String?>? = null,
        var name: String? = null,
        var id: String? = null,
        val category: KCategory? = null,
        val tags: List<KTag?>? = null,
        var status: String? = null
)