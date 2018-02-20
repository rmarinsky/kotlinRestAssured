package io.swagger.petstore

import io.swagger.petstore.controllers.KPetController
import io.swagger.petstore.models.KPet
import org.amshove.kluent.shouldEqual
import org.apache.commons.lang3.RandomStringUtils
import org.junit.Test

class PetTestsWithFluentAssertions {

    @Test
    fun `Add new pet to store`() {
        val testPet = KPet(id = RandomStringUtils.randomNumeric(10),
                name = "Pet_${RandomStringUtils.randomAlphabetic(8)}",
                status = "available")

        val petResponse = KPetController().addNewPet(testPet)

        petResponse shouldEqual testPet
    }

    @Test
    fun `Delete pet from store test`() {
        val testPet = KPet(id = RandomStringUtils.randomNumeric(10),
                name = "Pet_${RandomStringUtils.randomAlphabetic(8)}",
                status = "available")

        KPetController().apply {
            //with instance of KPetController class call following methods:
            addNewPet(testPet)
            deletePet(testPet)

            getPet(testPet).message shouldEqual "Pet not found"
        }
    }

}
