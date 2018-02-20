package io.swagger.petstore.models


data class KPet(
        var id: Long = 0, //9205439794349953000
        var category: Category = Category(),
        var name: String = "", //doggie
        var photoUrls: List<String> = listOf(),
        var tags: List<Tag> = listOf(),
        var status: String = "" //available
) {
    data class Category(
            var id: Int = 0, //0
            var name: String = "" //string
    )

    data class Tag(
            var id: Int = 0, //0
            var name: String = "" //string
    )
    data class Message(
            var code: Int,
            var type: String,
            var message: String
    )
}