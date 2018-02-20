package io.swagger.petstore.models


data class KPet(
        var id: String = "", //0
        var name: String = "", //doggie
        var photoUrls: List<String> = listOf(),
        var tags: List<Any> = listOf(),
        var status: String = "" //available
)